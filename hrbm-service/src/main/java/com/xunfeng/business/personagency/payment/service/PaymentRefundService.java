package com.xunfeng.business.personagency.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.payment.dao.PaymentRefundDao;
import com.xunfeng.business.personagency.payment.dto.PaymentRefundDto;
import com.xunfeng.business.personagency.payment.enumeration.RefundStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentRefundServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.payment.model.PaymentRefund;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringPool;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND Service类
* @author:wanghan
* @createDate 2016-08-17 14:13:49 
* @version V1.0   
*/
@Service
public class PaymentRefundService extends BaseService<PaymentRefund> implements PaymentRefundServiceInterf
{
	@Resource
	private PaymentRefundDao dao;
	@Resource
	PaymentMainService paymentMainService;
	
	
	
	public PaymentRefundService()
	{
	}
	
	@Override
	protected IEntityDao<PaymentRefund, Long> getEntityDao() 
	{
		return dao;
	}
	@Override
	public void add(PaymentRefund entity) {
		
		entity.setFdRefundIsRefund(RefundStatus.已登记);
//		Integer fdPaymentStandard=5;
//		entity.setFdRefundStandard(fdPaymentStandard.toString());
//		Long fdRefundMonths=5L;
//		Long monthsAmount=fdPaymentStandard*fdRefundMonths;
//		entity.setFdRefundMonths(fdRefundMonths);
//		entity.setFdRefundAmount(monthsAmount.toString());
		dao.add(entity);
	}
	public ResultData<PaymentRefund> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PaymentRefund> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public Long getRefundCount(Long pkPersonId,RefundStatus refundStatus){
		Map params=new HashMap();
		params.put("pkPersonId", pkPersonId);
		params.put("fdRefundIsRefund", refundStatus.getCode());
		Long count =(Long)dao.getOne("getRefundCount", params);
		return count;
		
	}
	@Override
	public ResultData<PaymentRefundDto> getRegisterRefundList(PageBean pageBean) {
		QueryFilter queryFilter =new QueryFilter();
		queryFilter.setPageBean(pageBean);
		queryFilter.addFilter("fdRefundIsRefund", RefundStatus.已登记.getCode());
		ResultData<PaymentRefundDto> resultData=new ResultData<PaymentRefundDto>();
		List<PaymentRefundDto> dataList=dao.getListForm("getAllwithPersonInfo", queryFilter);
		resultData.setDataList(dataList);
		resultData.setPageBean(queryFilter.getPageBean());
		return resultData;
	}

	@Override
	public PaymentRefundDto getPaymentRefundById(Long pkId) {
		Map params=new HashMap();
		params.put("pkId", pkId);
		PaymentRefundDto PaymentRefundDto=(PaymentRefundDto)dao.getOne("getAllwithPersonInfo", params);
		return PaymentRefundDto;
	}

	@Override
	public void confirmRefund(PaymentRefund paymentRefund) {
		
		paymentRefund.setFdRefundIsRefund(RefundStatus.已确认退费);
		PaymentMain paymentMain=paymentMainService.getPaymentMain(paymentRefund.getPkPersonId());
		String refundEndDate=DateUtil.addMonth(paymentRefund.getFdRefundEndDate(), StringPool.DATE_FORMAT_MONTH, -1);
		paymentMain.setFdEndPaymentDate(refundEndDate);
		paymentMainService.update(paymentMain);
		dao.update(paymentRefund);
		
	}
	
	
	
}
