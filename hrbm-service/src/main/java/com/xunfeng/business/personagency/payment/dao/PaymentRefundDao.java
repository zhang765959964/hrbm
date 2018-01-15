package com.xunfeng.business.personagency.payment.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.payment.model.PaymentRefund;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND Dao类
* @author:wanghan
* @createDate 2016-08-17 14:13:49 
* @version V1.0   
*/
@Repository
public class PaymentRefundDao extends BaseDao<PaymentRefund>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PaymentRefund.class;
	}

}