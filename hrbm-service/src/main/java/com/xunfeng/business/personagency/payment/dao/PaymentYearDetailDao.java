package com.xunfeng.business.personagency.payment.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.payment.model.PaymentYearDetail;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL Dao类
* @author:user
* @createDate 2016-11-03 16:16:59 
* @version V1.0   
*/
@Repository
public class PaymentYearDetailDao extends BaseDao<PaymentYearDetail>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PaymentYearDetail.class;
	}

}