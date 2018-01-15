package com.xunfeng.business.train.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.train.model.TrainOrgType;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构类型表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:02 
* @version V1.0   
*/
@Repository
public class TrainOrgTypeDao extends BaseDao<TrainOrgType>
{
	@Override
	public Class<?> getEntityClass()
	{
		return TrainOrgType.class;
	}

}