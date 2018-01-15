package com.xunfeng.business.personagency.payment.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_CORP_RECORD Dao类
* @author:wanghan
* @createDate 2016-08-20 14:57:53 
* @version V1.0   
*/
@Repository
public class PaymentCorpRecordDao extends BaseDao<PaymentCorpRecord>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PaymentCorpRecord.class;
	}

}