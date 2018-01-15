package com.xunfeng.business.train.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.train.model.TrainSignUp;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训报名表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:31 
* @version V1.0   
*/
@Repository
public class TrainSignUpDao extends BaseDao<TrainSignUp>
{
	@Override
	public Class<?> getEntityClass()
	{
		return TrainSignUp.class;
	}

}