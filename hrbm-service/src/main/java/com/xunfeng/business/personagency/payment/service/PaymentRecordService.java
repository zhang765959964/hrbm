package com.xunfeng.business.personagency.payment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.business.personagency.params.service.ParamsPaymentService;
import com.xunfeng.business.personagency.payment.dao.PaymentRecordDao;
import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentConst;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentType;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.model.PaymentYearDetail;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
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
* @Description: 缴费记录 Service类
* @author:wanghan
* @createDate 2016-08-15 15:23:02 
* @version V1.0   
*/
@Service
public class PaymentRecordService extends BaseService<PaymentRecord> implements PaymentRecordServiceInterf
{
	@Resource
	private PaymentRecordDao dao;
	@Resource
	PaymentCorpRecordService paymentCorpRecordService;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	@Resource
	ParamsPaymentService paramsPaymentService;
	@Resource
	SysOrgService sysOrgService;
	@Resource
	private PersonBaseInfoService baseInfoService;
	@Resource
	PersonExpandService personExpandService;
	@Resource
	PaymentYearDetailService  paymentYearDetailService;
	
	@Resource
	PaymentMainService  paymentMainService;
	
	public PaymentRecordService()
	{
	}
	
	@Override
	protected IEntityDao<PaymentRecord, Long> getEntityDao() 
	{
		return dao;
	}
	/**
	 *个人登记
	 */
	@Override
	public void add(PaymentRecord entity,String expPersonPhone,String aae005) {	
		updatePersonPhone(entity.getFkPersonId(),  expPersonPhone, aae005);
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		entity.setFdPaymentType(PaymentType.个人缴费);
		entity.setFdDerateStatus(DerateStatus.正常缴费);
		addPaymentRecord(entity);
	}
	
	public void updatePersonPhone(Long fkPersonId, String expPersonPhone,String aae005){
		PersonBaseInfo basePerson=baseInfoService.getById(fkPersonId);
		PersonExpand personExpand=personExpandService.getByExpPersonId(fkPersonId);
		basePerson.setAae005(aae005);//设置手机号
	    //保存个人扩展信息
		if(personExpand==null){
	    	personExpand=  new PersonExpand();
	    	personExpand.setExpPersonPhone(expPersonPhone);
	    	personExpand.setExpPersonId(fkPersonId);
	    	personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
	    	personExpandService.add(personExpand);
	    }else{
	    	personExpand.setExpPersonPhone(expPersonPhone);
	    	personExpandService.update(personExpand);
	    }
		baseInfoService.update(basePerson);
	}
	
	public void addPaymentRecord(PaymentRecord entity) {		
		
		List<ParamsPayment> paramslist = paramsPaymentService.getAll();
		savePayMentAmount( entity, paramslist);
	}
	/**
	 *个人实收
	 */
	public void bathPayment(Long id,SysUser sysUser){
		Long orgId = sysUser.getAcd200();
		SysOrg sysOrg=null;
		if(orgId!=null){
			sysOrg= sysOrgService.getById(orgId);
		}
			PaymentRecord paymentRecord=dao.getById(id);
			paymentRecord.setFdPaymentStatus(PaymentStatus.已缴);
			paymentRecord.setFdConfirmsDate(new Date());	
			paymentRecord.setFkConfirmsId(sysUser.getAcd230());
			paymentRecord.setFdConfirmsName(sysUser.getAac003());
			if(sysOrg!=null){
				paymentRecord.setFkConfirmsOrgId(sysOrg.getAcd200());
				paymentRecord.setFdConfirmsOrgName(sysOrg.getAcd202());
			}

			dao.update(paymentRecord);
		
		
	}
	
	

	@Override
	public void delByIds(Long[] ids) {
		if(BeanUtils.isEmpty(ids)) return;
		for (Long p : ids){
			delById(p);
		}
	}

	@Override
	public void delById(Long id) {
		PaymentRecord paymentRecord=dao.getById(id);
		if(paymentRecord.getFdPaymentStatus().compareTo(PaymentStatus.已缴)==0&&paymentRecord.getFdDerateStatus().compareTo(DerateStatus.正常缴费)==0){
			throw new RuntimeException("不能删除已缴费记录");
		}
		super.delById(id);
	}
	public void delCorpRecordById(PaymentRecord  paymentRecord) {
		
		if(paymentRecord.getFdPaymentStatus().compareTo(PaymentStatus.已缴)==0&&paymentRecord.getFdDerateStatus().compareTo(DerateStatus.正常缴费)==0){
			throw new RuntimeException("不能删除已缴费记录");
		}
//		PaymentRecord lastpaymentRecord=getLastPaymentRecord(paymentRecord.getFkPersonId());
//		if(lastpaymentRecord!=null&&lastpaymentRecord.getPkId().compareTo(paymentRecord.getPkId())==0){
			dao.delById(paymentRecord.getPkId());
			paymentYearDetailService.delByRecordId(paymentRecord.getPkId());
			String fdEndDate=DateUtil.addMonth(paymentRecord.getFdStartDate(), StringPool.DATE_FORMAT_MONTH, -1);
			paymentMainService.deletePaymentMain(paymentRecord.getFkPersonId(),fdEndDate);
						
//		}else{
//			throw new RuntimeException("必须从最后的一条缴费记录删起");
//		}
		
	}
	public PaymentRecord getLastPaymentRecord(Long fkPersonId){
		
		QueryFilter  queryFilter=new QueryFilter();
		queryFilter.addFilter("fkPersonId", fkPersonId);
		queryFilter.addFilter("orderField", "FD_START_DATE");
		queryFilter.addFilter("orderSeq", "asc");
		List<PaymentRecord> detailList=dao.getBySqlKey("getAll", queryFilter);
		if(detailList!=null&&detailList.size()>0){
			return detailList.get(detailList.size()-1);
		}else{
			return null;
		}
		 
	} 
	public ResultData<PaymentRecord> getAllByFilter(QueryFilter fiter){
//		fiter.addFilter("fdDerateStatus", DerateStatus.正常缴费.getCode());
		ResultData resultData=new ResultData();
		List<PaymentRecord> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public ResultData<PaymentRecordPersonDto> getPersonRecordByFilter(QueryFilter fiter){
//		fiter.addFilter("fdDerateStatus", DerateStatus.正常缴费.getCode());
		ResultData resultData=new ResultData();
		List<PaymentRecordPersonDto> dataList=dao.getListForm("getPayDetailList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public ResultData<PaymentRecordPersonDto> getPersonRecordByCorpRecordId(Long fkCorpRecordId,String fdDerateStatus ,PageBean pageBean){
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("fkCorpRecordId", fkCorpRecordId);
		if(fdDerateStatus!=null){
			fiter.addFilter("fdDerateStatus", fdDerateStatus);
		}
		
		fiter.setPageBean(pageBean);
		ResultData resultData=new ResultData();
		List<PaymentRecordPersonDto> dataList=dao.getListForm("getPayDetailList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public ResultData<PaymentRecordPersonDto> getPersonRecordByPersonId(Long fkPersonId){
		return getPersonRecordByPersonId(fkPersonId, null);
		
	}
	public ResultData<PaymentRecordPersonDto> getPersonRecordByPersonId(Long fkPersonId,DerateStatus derateStatus){
		QueryFilter fiter=new QueryFilter();
		if(derateStatus!=null){
			fiter.addFilter("fdDerateStatus", derateStatus.getCode());
		}	
		fiter.addFilter("fkPersonId", fkPersonId);
		ResultData resultData=new ResultData();
		List<PaymentRecordPersonDto> dataList=dao.getListForm("getPayDetailList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public ResultData<PaymentRecordPersonDto> getOverReceiveGroupPayList(PageBean pageBean ,Date currenConfirmtDate){
		return getReceiveGroupPayList(pageBean, null,currenConfirmtDate,PaymentStatus.已缴.getCode());
		
	}
	
    public ResultData<PaymentRecordPersonDto> getOverReceiveGroupPayList(PageBean pageBean){
    	return getOverReceiveGroupPayList( pageBean, null);
	}
    
    
    public ResultData<PaymentRecordPersonDto> getNoReceiveGroupPayList(PageBean pageBean ){   	
    	return getNoReceiveGroupPayList( pageBean ,null);
	}
    public ResultData<PaymentRecordPersonDto> getNoReceiveGroupPayList(PageBean pageBean ,Date createrDate){   	
		return getReceiveGroupPayList(pageBean, createrDate,null,PaymentStatus.未缴.getCode());
	}

    private ResultData<PaymentRecordPersonDto> getReceiveGroupPayList(PageBean pageBean ,Date createrDate,Date currenConfirmtDate,String fdPaymentStatus){   	
    	QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		fiter.addFilter("fdDerateStatus", DerateStatus.正常缴费.getCode());
		fiter.addFilter("fdPaymentStatus", fdPaymentStatus);
		fiter.addFilter("fdPaymentType", PaymentType.个人缴费.getCode());
		if(createrDate!=null){
			fiter.addFilter("currentDate", DateUtil.getformatterDate(createrDate, StringPool.DATE_FORMAT_DATE));
		}
		if(currenConfirmtDate!=null){
		fiter.addFilter("currenConfirmtDate", DateUtil.getformatterDate(currenConfirmtDate, StringPool.DATE_FORMAT_DATE));
		}
		ResultData resultData=new ResultData();
		List<PaymentRecordPersonDto> dataList=dao.getListForm("getReceiveGroupPayList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

    
    public Long getNoPaymentCount(Long fkPersonId){
    	
    	Map params=new HashMap();
    	params.put("fkPersonId", fkPersonId);
    	params.put("fdPaymentStatus", PaymentStatus.未缴.getCode());
    	return (Long)dao.getOne("getCount", params);
	}
		
    public ResultData<PaymentRecordPersonDto> getOverPersonPayList(QueryFilter fiter){
    	fiter.addFilter("endPaymentDate", PaymentConst.endPaymentDate);
		ResultData<PaymentRecordPersonDto> resultData = new ResultData<PaymentRecordPersonDto>();
		List<PaymentRecordPersonDto> dataList = dao.getListForm("getPersonPayment", fiter);
		List<ParamsPayment> paramslist = paramsPaymentService.getAll();
		for (PaymentRecordPersonDto paymentRecordPersonDto : dataList) {
			Float amount=PaymentRecordService.getPayMentAmount(DateUtil.addMonth(paymentRecordPersonDto.getFdEndPaymentDate(), StringPool.DATE_FORMAT_MONTH, 1), PaymentConst.endPaymentDate, paramslist);

			paymentRecordPersonDto.setOverAmount(amount.toString());
		}
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
    	
    }
	public List<PaymentRecord> getCorpRecordList(Long corpRecordId){
		
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("fkCorpRecordId", corpRecordId);
		fiter.addFilter("orderField", "FD_START_DATE");
		fiter.addFilter("orderSeq", "desc");
//		fiter.addFilter("fdDerateStatus", DerateStatus.正常缴费.getCode());
		return dao.getAll(fiter);
	}
	
	public static   Float getPayMentAmount(String startMonth, String endMonth, List<ParamsPayment> paramslist) {
//      List list =new ArrayList();
      Float allAmount=0F;
		String tempStartMonth=startMonth; 
		String tempEndMonth=endMonth;
		for (ParamsPayment paramsPayment : paramslist) {	
			Map sumMap = new HashMap();
			String paymentMonth=paramsPayment.getFdEnddate();
			
			if(DateUtil.compare(endMonth, paymentMonth, StringPool.DATE_FORMAT_MONTH)<=0){
				sumMap.put("sartMonth", tempStartMonth);
				sumMap.put("endMonth", endMonth);
				int month=DateUtil.getMonthSpace(tempStartMonth, endMonth);
				month++;
				allAmount=allAmount+month*paramsPayment.getFdStandard();
//				list.add(sumMap);
				break;
			}else if(DateUtil.compare(endMonth, paymentMonth, StringPool.DATE_FORMAT_MONTH)>0){
				if(DateUtil.compare(startMonth, paymentMonth, StringPool.DATE_FORMAT_MONTH)>0){
					continue;
				}
				sumMap.put("sartMonth", tempStartMonth);
				sumMap.put("endMonth", paymentMonth);	
				tempStartMonth=DateUtil.addMonth(paymentMonth, StringPool.DATE_FORMAT_MONTH, 1)  ;
				int month=DateUtil.getMonthSpace(tempStartMonth, endMonth);
				month++;
				allAmount=allAmount+month*paramsPayment.getFdStandard();
//				list.add(sumMap);
			}			
		}
		return  allAmount;
	}
	
	/**
	 * @param entity
	 * @param paramslist
	 */
	private    void savePayMentAmount(PaymentRecord entity, List<ParamsPayment> paramslist) {
//      List list =new ArrayList();

        String endMonth=entity.getFdEndDate();
        String startMonth=entity.getFdStartDate();
		String tempStartMonth=entity.getFdStartDate(); 
		entity.setPkId(uniqueIdUtilService.genId(PaymentRecord.class.getName()));
		Float totalAmount=0F;
		for (ParamsPayment paramsPayment : paramslist) {	
			Map sumMap = new HashMap();
			String paymentMonth=paramsPayment.getFdEnddate();
			PaymentYearDetail paymentDetail=new PaymentYearDetail();
			//BeanToBean.copyProperties(entity, newPayment);
			paymentDetail.setId(uniqueIdUtilService.genId(PaymentYearDetail.class.getName()));
			if(DateUtil.compare(endMonth, paymentMonth, StringPool.DATE_FORMAT_MONTH)<=0){
				sumMap.put("sartMonth", tempStartMonth);
				sumMap.put("endMonth", endMonth);
				paymentDetail.setFdStartDate(tempStartMonth);
				paymentDetail.setFdEndDate(endMonth);
				int month=DateUtil.getMonthSpace(tempStartMonth, endMonth);		
				month++;
				paymentDetail.setFdPaymentMonths((long)month);
				//正常缴费计算金额，减免缴费直接通过前台参数传入取值。
				Float allAmount=0F;
				if(entity.getFdDerateStatus().getCode().equals(DerateStatus.正常缴费.getCode())){
					 allAmount=month*paramsPayment.getFdStandard();						 
				}else{
					allAmount=month*Float.valueOf(StringUtil.isEmpty(entity.getFdPaymentStandard())?"0":entity.getFdPaymentStandard());
				}
				totalAmount=totalAmount+allAmount;
				paymentDetail.setFdPaymentStandard(paramsPayment.getFdStandard().toString());
				paymentDetail.setFdPaymentAmount(allAmount.toString());
				paymentDetail.setRecordId(entity.getPkId());
				paymentYearDetailService.add(paymentDetail);
//				list.add(sumMap);
				break;
			}else if(DateUtil.compare(endMonth, paymentMonth, StringPool.DATE_FORMAT_MONTH)>0){
				//对于缴费基数比开始缴费日前还小的，不用处理
				if(DateUtil.compare(startMonth, paymentMonth, StringPool.DATE_FORMAT_MONTH)>0){
					continue;
				}
				sumMap.put("sartMonth", tempStartMonth);
				sumMap.put("endMonth", paymentMonth);	
				paymentDetail.setFdStartDate(tempStartMonth);
				paymentDetail.setFdEndDate(paymentMonth);		
				int month=DateUtil.getMonthSpace(tempStartMonth, paymentMonth);
				month++;
				paymentDetail.setFdPaymentMonths((long)month);
				//正常缴费计算金额，减免缴费直接通过前台参数传入取值。
				Float allAmount=0F;
				if(entity.getFdDerateStatus().getCode().equals(DerateStatus.正常缴费.getCode())){
					 allAmount=month*paramsPayment.getFdStandard();	
				}else{
					 allAmount=month*Float.valueOf(StringUtil.isEmpty(entity.getFdPaymentStandard())?"0":entity.getFdPaymentStandard());
				}
				totalAmount=totalAmount+allAmount;
				paymentDetail.setFdPaymentAmount(allAmount.toString());	
				paymentDetail.setFdPaymentStandard(paramsPayment.getFdStandard().toString());
				paymentDetail.setRecordId(entity.getPkId());
				tempStartMonth=DateUtil.addMonth(paymentMonth, StringPool.DATE_FORMAT_MONTH, 1) ;
				paymentYearDetailService.add(paymentDetail);
//				list.add(sumMap);
			}			
		}
		entity.setFdPaymentAmount(totalAmount.toString());	
		dao.add(entity);
	}
	
//	public void delByCorpRecordId(Long corpRecordId){
//		
//		dao.delBySqlKey("delByCorpRecordId", corpRecordId);
//	}
	
}
