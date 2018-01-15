package com.xunfeng.business.personagency.params.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.params.model.ParamsPayment;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PARAMS_PAYMENT Dao类
* @author:wanghan
* @createDate 2016-09-05 09:47:42 
* @version V1.0   
*/
@Repository
public class ParamsPaymentDao extends BaseDao<ParamsPayment>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ParamsPayment.class;
	}

}