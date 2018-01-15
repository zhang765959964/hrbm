package com.xunfeng.business.personagency.payment.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.service.PaymentMainService;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 缴费记录 Dao类
* @author:wanghan
* @createDate 2016-08-15 15:23:02 
* @version V1.0   
*/
@Repository
public class PaymentRecordDao extends BaseDao<PaymentRecord>
{
	@Resource
	PaymentMainService  paymentMainService;
	@Override
	public Class<?> getEntityClass()
	{
		return PaymentRecord.class;
	}

	@Override
	public void add(PaymentRecord entity) {
		paymentMainService.updatePaymentMain(entity);
		super.add(entity);
	}

	@Override
	public int update(PaymentRecord entity) {
//		paymentMainService.updatePaymentMain(entity);
		return super.update(entity);
	}
	
	

}