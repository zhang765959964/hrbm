package com.xunfeng.business.personagency.payment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.payment.dao.PaymentRecordDao;
import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentType;
import com.xunfeng.business.personagency.payment.interf.PaymentDerateServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 缴费记录 Service类
* @author:wanghan
* @createDate 2016-08-15 15:23:02 
* @version V1.0   
*/
@Service
public class PaymentDerateService implements PaymentDerateServiceInterf
{
	@Resource
	private PaymentRecordDao dao;
	@Resource
	PaymentCorpRecordService paymentCorpRecordService;
	@Resource
	PaymentMainService  paymentMainService;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	@Resource
	PaymentRecordService  paymentRecordService;
	
	public PaymentDerateService()
	{
	}

	@Override
	public ResultData<PaymentRecordPersonDto> getPersonDerateList(Long fkPersonId,PageBean pageBean) {
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		fiter.addFilter("fdDerateStatus", DerateStatus.减免.getCode());
		fiter.addFilter("fdPaymentType", PaymentType.个人缴费.getCode());
		fiter.addFilter("fkPersonId", fkPersonId);
		ResultData resultData=new ResultData();		
		List<PaymentRecordPersonDto> dataList=dao.getListForm("getPayDetailList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	public void addPaymentDerate(PaymentRecord entity,String expPersonPhone,String aae005) {
		paymentRecordService.updatePersonPhone(entity.getFkPersonId(),  expPersonPhone, aae005);
		entity.setFdPaymentStatus(PaymentStatus.已缴);
		entity.setFdPaymentType(PaymentType.个人缴费);
		entity.setFdDerateStatus(DerateStatus.减免);
		paymentRecordService.addPaymentRecord(entity);	
		
    }
	
	@Override
	public ResultData<PaymentRecordPersonDto> getPersonDerateList(QueryFilter fiter) {
		fiter.addFilter("fdDerateStatus", DerateStatus.减免.getCode());
		ResultData resultData=new ResultData();		
		List<PaymentRecordPersonDto> dataList=dao.getListForm("getPayDetailList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	

}
