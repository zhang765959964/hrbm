package com.xunfeng.business.personagency.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.payment.dao.PaymentYearDetailDao;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentYearDetailServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.model.PaymentYearDetail;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringPool;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL Service类
* @author:user
* @createDate 2016-11-03 16:16:59 
* @version V1.0   
*/
@Service
public class PaymentYearDetailService extends BaseService<PaymentYearDetail> implements PaymentYearDetailServiceInterf
{
	@Resource
	private PaymentYearDetailDao dao;
	@Resource
	private PaymentRecordService  paymentRecordService;
	
	@Resource
	PaymentMainService  paymentMainService;
	
	
	public PaymentYearDetailService()
	{
	}
	
	@Override
	protected IEntityDao<PaymentYearDetail, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<PaymentYearDetail> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PaymentYearDetail> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public void delById(Long id){
		
		PaymentYearDetail paymentYearDetail = dao.getById(id);
		Long recordId=paymentYearDetail.getRecordId();
		PaymentRecord paymentRecord=paymentRecordService.getById(recordId);
		if(paymentRecord.getFdPaymentStatus().compareTo(PaymentStatus.已缴)==0&&paymentRecord.getFdDerateStatus().compareTo(DerateStatus.正常缴费)==0){
			throw new RuntimeException("不能删除已缴费记录");
		}
		PaymentYearDetail lastPaymentYearDetail=getLastPaymentYearDetail(paymentRecord.getFkPersonId());
		if(lastPaymentYearDetail!=null&&lastPaymentYearDetail.getId().compareTo(id)==0){
			List<PaymentYearDetail> detailList=getByRecordId(recordId);
			if(detailList!=null&&detailList.size()<=1){
				//只有一条缴费记录			
				paymentRecordService.delById(recordId);
			}
			dao.delById(id);
			String fdEndDate=DateUtil.addMonth(paymentYearDetail.getFdStartDate(), StringPool.DATE_FORMAT_MONTH, -1);
			paymentMainService.deletePaymentMain(paymentRecord.getFkPersonId(),fdEndDate);
			
			
		}else{
			throw new RuntimeException("必须从最后的一条缴费记录删起");
		}
		
//		List<PaymentYearDetail> detailList=getByRecordId(recordId);
//		if(detailList.size()<=1){
//			//只有一条缴费记录			
//			paymentRecordService.delById(recordId);
//			dao.delById(recordId);
//		}else{
//			//有多条缴费记录	
//			if(detailList.get(detailList.size()-1).getId().compareTo(id)==0){
//				//当前要删除记录是多次缴费记录的最后一条，因为删除时，只能先从最后的缴费记录删起。
//				dao.delById(id);
//				
//			}else{
//				throw new RuntimeException("必须从最后的一条缴费记录删起");
//				
//			}
//		}
	}
	
	public List<PaymentYearDetail> getByRecordId(Long recordId){
		
		QueryFilter  queryFilter=new QueryFilter();
		queryFilter.addFilter("recordId", recordId);
		queryFilter.addFilter("orderField", "FD_START_DATE");
		queryFilter.addFilter("orderSeq", "asc");

		return dao.getBySqlKey("getAll", queryFilter);
	}
	
	public PaymentYearDetail getLastPaymentYearDetail(Long personId){
		
		QueryFilter  queryFilter=new QueryFilter();
		queryFilter.addFilter("personId", personId);
		queryFilter.addFilter("orderField", "FD_START_DATE");
		queryFilter.addFilter("orderSeq", "asc");
		List<PaymentYearDetail> detailList=dao.getBySqlKey("getPaymentYearDetail", queryFilter);
		if(detailList!=null&&detailList.size()>0){
			return detailList.get(detailList.size()-1);
		}else{
			return null;
		}
		 
	} 
	public void delByRecordId(Long recordId){
		
		Map Params=new HashMap();
		Params.put("recordId", recordId);
		dao.delBySqlKey("delByRecordId", recordId);
		
	}
	
}
