package com.xunfeng.business.train.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.train.model.TrainOrg;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
@Repository
public class TrainOrgDao extends BaseDao<TrainOrg>
{
	@Override
	public Class<?> getEntityClass()
	{
		return TrainOrg.class;
	}

}