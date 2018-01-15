package com.xunfeng.business.personagency.payment.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.payment.model.PaymentMain;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_MAIN Dao类
* @author:wanghan
* @createDate 2016-09-01 10:57:44 
* @version V1.0   
*/
@Repository
public class PaymentMainDao extends BaseDao<PaymentMain>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PaymentMain.class;
	}

}