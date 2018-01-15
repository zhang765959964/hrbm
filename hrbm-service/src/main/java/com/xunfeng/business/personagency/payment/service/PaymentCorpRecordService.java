package com.xunfeng.business.personagency.payment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lowagie.tools.concat_pdf;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.business.personagency.params.service.ParamsPaymentService;
import com.xunfeng.business.personagency.payment.dao.PaymentCorpRecordDao;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpOverDto;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentConst;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentType;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpRecordServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;
import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringPool;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysOrgService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PAYMENT_CORP_RECORD Service类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
@Service
public class PaymentCorpRecordService extends BaseService<PaymentCorpRecord> implements PaymentCorpRecordServiceInterf {
	@Resource
	private PaymentCorpRecordDao dao;
	@Resource
	PaymentRecordService paymentRecordService;
	@Resource
	PaymentMainService paymentMainService;
	@Resource
	ParamsPaymentService paramsPaymentService;

	@Resource
	UniqueIdUtilService uniqueIdUtilService;
	
	@Resource
	ArchivesService archivesService;
	
	@Resource
	SysOrgService sysOrgService;
	@Resource
	PaymentYearDetailService paymentYearDetailService;

	public PaymentCorpRecordService() {
	}

	@Override
	protected IEntityDao<PaymentCorpRecord, Long> getEntityDao() {
		return dao;
	}

	public ResultData<PaymentCorpRecord> getAllByFilter(QueryFilter fiter) {
		
		ResultData resultData = new ResultData();
		List<PaymentCorpRecord> dataList = dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;

	}

	public ResultData<PaymentCorpRecordDto> getAllWithCorpInfoFilter(QueryFilter fiter) {
		ResultData resultData = new ResultData();
		List<PaymentCorpRecordDto> dataList = dao.getListForm("getAllWithCorpInfo", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;

	}

	public ResultData<PaymentCorpRecordDto> getNoPaymentList(PageBean pageBean) {
		QueryFilter fiter = new QueryFilter();
		fiter.setPageBean(pageBean);
		fiter.addFilter("fdPaymentStatus", PaymentStatus.未缴.getCode());
		ResultData resultData = new ResultData();
		List<PaymentCorpRecord> dataList = dao.getListForm("getAllWithCorpInfo", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	public ResultData<PaymentCorpRecordDto> getPaymentList(PageBean pageBean) {
		QueryFilter fiter = new QueryFilter();
		fiter.setPageBean(pageBean);
		fiter.addFilter("fdPaymentStatus", PaymentStatus.已缴.getCode());
		ResultData resultData = new ResultData();
		List<PaymentCorpRecord> dataList = dao.getListForm("getAllWithCorpInfo", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;

	}
	public Long getPaymentCorpRecordCount(Long corpId, PaymentStatus paymentStatus,DerateStatus derateStatus) {
		Map param = new HashMap();
		
		if(paymentStatus!=null){
			param.put("fdPaymentStatus", paymentStatus.getCode());
		}
		
		if(derateStatus!=null){
			param.put("fdDerateStatus", derateStatus.getCode());
		}
		
		param.put("fkCorpId", corpId);
		Long count = (Long)dao.getOne("getPaymentCorpRecordCount", param);
		return count;

	}
	public Long getPaymentCorpRecordCount(Long corpId, PaymentStatus paymentStatus) {
		return getPaymentCorpRecordCount(corpId, paymentStatus, null);

	}

	public PaymentCorpRecordDto getPaymentWithCorpById(Long pkId) {
		QueryFilter fiter = new QueryFilter();

		fiter.addFilter("pkId", pkId);

		List<PaymentCorpRecordDto> dataList = dao.getListForm("getAllWithCorpInfo", fiter);
		if (dataList != null && dataList.size() > 0) {
			return dataList.get(0);
		} else {
			return null;
		}

	}

	public ResultData<PaymentCorpOverDto> getOverUnitAgreement(QueryFilter fiter) {

		fiter.addFilter("endPaymentDate", PaymentConst.endPaymentDate);
		ResultData<PaymentCorpOverDto> resultData = new ResultData<PaymentCorpOverDto>();
		List<PaymentCorpOverDto> dataList = dao.getListForm("getOverUnitAgreement", fiter);
		List<ParamsPayment> paramslist = paramsPaymentService.getAll();
		for (PaymentCorpOverDto paymentCorpOverDto : dataList) {
			List<PaymentMain> overList= paymentMainService.getOverPaymentMain(paymentCorpOverDto.getAab001());
			setOverAmount(paymentCorpOverDto, overList, paramslist);
		}
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;

	}

	private void setOverAmount(PaymentCorpOverDto paymentCorpOverDto, List<PaymentMain> list,
			List<ParamsPayment> paramslist) {
		Integer overUserNum = list != null && list.size() > 0 ? list.size() : 0;
		paymentCorpOverDto.setOverUserNum(overUserNum.toString());
		Float allAmount=0F;
		for (PaymentMain paymentMain : list) {
			Float amount=PaymentRecordService.getPayMentAmount(DateUtil.addMonth(paymentMain.getFdEndPaymentDate(), StringPool.DATE_FORMAT_MONTH, 1), PaymentConst.endPaymentDate, paramslist);
			allAmount=allAmount+amount;
		}
		paymentCorpOverDto.setOverAmount(allAmount.toString());
	}

	/**
	 *单位单条登记
	 */
	public void addCorpPayment(PaymentRecord entity) {
		
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		entity.setFdPaymentType(PaymentType.单位缴费);
		entity.setFdDerateStatus(DerateStatus.正常缴费);
		paymentRecordService.addPaymentRecord(entity);
		//老代码的处理是缴费时，计算缴费金额后存到单位缴费记录表，新版本不再计算，使用时通过个人缴费记录自动计算，所以下面的代码注释掉
//		setCorpAmount(entity.getFkCorpRecordId());
		
	}
	
//	/**设置单位缴费金额和人数
//	 * @param corpRecordId
//	 */
//	private void setCorpAmount(Long corpRecordId){
//		
//		PaymentCorpRecord paymentCorpRecord=this.getById(corpRecordId);
//		
//		List<PaymentRecord> paymentRecordList = paymentRecordService.getCorpRecordList(corpRecordId);
//		Float allAmount=0f;
//		for(PaymentRecord paymentRecord : paymentRecordList){
//			
//			Float amount=StringUtil.isEmpty(paymentRecord.getFdPaymentAmount())?0F:Float.valueOf(paymentRecord.getFdPaymentAmount());
//			allAmount+=amount;
//		}
//		paymentCorpRecord.setFdPaymentAmount(allAmount.toString());
//		this.update(paymentCorpRecord);
//	}
	
	/**
	 *单位批量登记
	 */
   public void allCorpPayment(PaymentRecord entity,int type) {
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		entity.setFdPaymentType(PaymentType.单位缴费);
		entity.setFdDerateStatus(DerateStatus.正常缴费);
		PaymentCorpRecord paymentCorpRecord=this.getById(entity.getFkCorpRecordId());
		if(paymentCorpRecord==null){
			throw new RuntimeException("当前缴费记录不存在或已被删除");
		}
		if(PaymentStatus.已缴.getCode().equals(paymentCorpRecord.getFdPaymentStatus().getCode())){
			throw new RuntimeException("不能选择已缴费记录，请刷新单位缴费记录后重试");
		}
		ResultData<Map> resultData = archivesService.getCorpAllArchive(null, paymentCorpRecord.getFkCorpId() );
		Long[] personIds=new Long[resultData.getDataList().size()]; 
		int i=0;
		for(Map map:resultData.getDataList()){
			personIds[i]=Long.valueOf(map.get("aac001").toString());
			i++;
		}
		mutiCorpPayment(entity, personIds, type);
	}
   
	public void batchAddCorpPayment(PaymentRecord entity,Long[] personIds,int type) {		
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		entity.setFdPaymentType(PaymentType.单位缴费);
		entity.setFdDerateStatus(DerateStatus.正常缴费);
		PaymentCorpRecord paymentCorpRecord=this.getById(entity.getFkCorpRecordId());
		if(paymentCorpRecord==null){
			throw new RuntimeException("当前缴费记录不存在或已被删除");
		}
		if(PaymentStatus.已缴.getCode().equals(paymentCorpRecord.getFdPaymentStatus().getCode())){
			throw new RuntimeException("不能选择已缴费记录，请刷新单位缴费记录后重试");
		}
		mutiCorpPayment(entity, personIds, type);
	}
	
	
	public void mutiCorpPayment(PaymentRecord entity,Long[] personIds,int type) {		

		for(long personId:personIds){	
//			Long noPayCount=paymentRecordService.getNoPaymentCount(personId);
//			if(noPayCount>0){
//				throw new RuntimeException("有未缴费记录，请先缴费");
//			}
			PaymentRecord newPayment=new PaymentRecord();
			BeanToBean.copyProperties(entity, newPayment);
			if(type==1){
				//按月扣减
				Long months=newPayment.getFdPaymentMonths();
				String sartMonth=paymentMainService.getLastPayMentDate(personId);
			    sartMonth=DateUtil.addMonth(sartMonth, "yyyy-MM", 1);
				String endMonth=DateUtil.addMonth(sartMonth, "yyyy-MM", Integer.valueOf(months.toString())-1);
				newPayment.setFdStartDate(sartMonth);
				newPayment.setFdEndDate(endMonth);
			}else{
				//按截至日期扣减
				String sartMonth=paymentMainService.getLastPayMentDate(personId);
			    sartMonth=DateUtil.addMonth(sartMonth, "yyyy-MM", 1);
				newPayment.setFdStartDate(sartMonth);	
				
				if(DateUtil.compare(newPayment.getFdEndDate(), newPayment.getFdStartDate(), StringPool.DATE_FORMAT_MONTH)<0){
					continue;
				}
			}			
			newPayment.setPkId(uniqueIdUtilService.genId(PaymentRecord.class.getName()));
			newPayment.setFkPersonId(personId);
			//增加一条记录
			paymentRecordService.addPaymentRecord(newPayment);	
		}
//		setCorpAmount(entity.getFkCorpRecordId());
	}


	/**
	 *单位实收
	 */
	public void receiveMutiPayment(Long corpRecordId, Long[] lAryId) {

		PaymentCorpRecord paymentCorpRecord = this.getById(corpRecordId);
		paymentCorpRecord.setFdPaymentStatus(PaymentStatus.已缴);
		this.update(paymentCorpRecord);
		for (Long id : lAryId) {
			PaymentRecord paymentRecord = paymentRecordService.getById(id);
			paymentRecord.setFdPaymentStatus(PaymentStatus.已缴);
			paymentRecordService.update(paymentRecord);
		}

	}

	public void receiveAllPayment(Long corpRecordId,SysUser sysUser) {
		Long orgId = sysUser.getAcd200();
		SysOrg sysOrg=null;
		if(orgId!=null){
			sysOrg= sysOrgService.getById(orgId);
		}
		PaymentCorpRecord paymentCorpRecord = this.getById(corpRecordId);

		paymentCorpRecord.setFdPaymentStatus(PaymentStatus.已缴);
		paymentCorpRecord.setFdConfirmsDate(new Date());	
		paymentCorpRecord.setFkConfirmsId(sysUser.getAcd230());
		paymentCorpRecord.setFdConfirmsName(sysUser.getAac003());
		if(sysOrg!=null){
			paymentCorpRecord.setFkConfirmsOrgId(sysOrg.getAcd200());
			paymentCorpRecord.setFdConfirmsOrgName(sysOrg.getAcd202());
		}
		this.update(paymentCorpRecord);
		List<PaymentRecord> paymentRecordList = paymentRecordService.getCorpRecordList(corpRecordId);

		for (PaymentRecord paymentRecord : paymentRecordList) {
			paymentRecord.setFdPaymentStatus(PaymentStatus.已缴);
			paymentRecord.setFdConfirmsDate(new Date());	
			paymentRecord.setFkConfirmsId(sysUser.getAcd230());
			paymentRecord.setFdConfirmsName(sysUser.getAac003());
			if(sysOrg!=null){
				paymentRecord.setFkConfirmsOrgId(sysOrg.getAcd200());
				paymentRecord.setFdConfirmsOrgName(sysOrg.getAcd202());
			}
			paymentRecordService.update(paymentRecord);
		}

	}

	@Override
	public void delById(Long id) {	
		PaymentCorpRecord paymentCorpRecord=this.getById(id);
		if(paymentCorpRecord.getFdPaymentStatus().getCode().equals(PaymentStatus.已缴.getCode())){
			throw new RuntimeException("不能删除已缴费记录");
		}
		
		super.delById(id);
		
		List<PaymentRecord> paymentRecordList = paymentRecordService.getCorpRecordList(paymentCorpRecord.getPkId());
		
		for(PaymentRecord  paymentRecord:paymentRecordList){ 
			
			
			paymentRecordService.delCorpRecordById(paymentRecord);
			
		}
		
	}


	
//	public static void main(String[] arg){
//		
//		Map map = new LinkedHashMap ();
//		map.put("2005-12", 15);
//		map.put("2008-11", 10);
//		map.put("2014-12", 5);
//		map.put("2020-12", 0);
//		
//		List list=PaymentCorpRecordService.getPayMentAmount("2005-02", "2018-11", map);
//		String sds="";
//		
//		
//		
//	}
	
}
