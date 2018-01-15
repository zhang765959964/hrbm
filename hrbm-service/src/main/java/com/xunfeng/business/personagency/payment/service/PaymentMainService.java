package com.xunfeng.business.personagency.payment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.payment.dao.PaymentMainDao;
import com.xunfeng.business.personagency.payment.enumeration.PaymentConst;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentMainServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.model.PaymentYearDetail;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringPool;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_MAIN Service类
* @author:wanghan
* @createDate 2016-09-01 10:57:44 
* @version V1.0   
*/
@Service
public class PaymentMainService extends BaseService<PaymentMain> implements PaymentMainServiceInterf
{
	@Resource
	private PaymentMainDao dao;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	@Resource
	ArchivesService archivesService;
	
	
	public PaymentMainService()
	{
	}
	
	@Override
	protected IEntityDao<PaymentMain, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<PaymentMain> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PaymentMain> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public PaymentMain getPaymentMain(Long fkPersonid){
		
		Map params=new HashMap();
		params.put("fkPersonid", fkPersonid);
		PaymentMain paymentMain=dao.getUnique("getAll", params);
		return paymentMain;
		
	}
	
	public String getLastPayMentDate(Long personId){
		
		PaymentMain paymentMain=this.getPaymentMain(personId);
		if(paymentMain!=null){
			return paymentMain.getFdEndPaymentDate();
		}else{
			Archives archives=archivesService.getArchivesByPId(personId);

			Date receiveDate= archives.getReceiveDate();
			return DateUtil.getformatterDate(receiveDate, "yyyy-MM");
		}
		
	}
	
	public void updatePaymentMain (PaymentRecord entity){
		
//		if(PaymentStatus.未缴.getCode().equals(entity.getFdPaymentStatus().getCode())){
//			return;
//		}
		PaymentMain paymentMain=this.getPaymentMain(entity.getFkPersonId());
		if(paymentMain==null){
			paymentMain=new PaymentMain();
			paymentMain.setPkId(uniqueIdUtilService.genId(PaymentMain.class.getName()));
			paymentMain.setFdStartPaymentDate(entity.getFdStartDate());
			paymentMain.setFdEndPaymentDate(entity.getFdEndDate());
			paymentMain.setFkPersonid(entity.getFkPersonId());
			this.add(paymentMain);
		}else{
			paymentMain.setFdEndPaymentDate(entity.getFdEndDate());
			this.update(paymentMain);
		}
	}
	public void deletePaymentMain (Long personId,String fdEndDate){
		

		PaymentMain paymentMain=this.getPaymentMain(personId);
		if(paymentMain==null){
			
		}else{
			if(DateUtil.compare(paymentMain.getFdEndPaymentDate(), fdEndDate, StringPool.DATE_FORMAT_MONTH)>0){
				paymentMain.setFdEndPaymentDate(fdEndDate);
				this.update(paymentMain);
			}
			
		}
	}
	
	public  List<PaymentMain> getOverPaymentMain(Long corpId){
		
		QueryFilter queryFilter=new QueryFilter();	
		queryFilter.addFilter("endPaymentDate",PaymentConst.endPaymentDate);
		queryFilter.addFilter("corpId",corpId);
		List<PaymentMain> dataList=dao.getListForm("getOverAll", queryFilter);
		return dataList;
	}
	
}
