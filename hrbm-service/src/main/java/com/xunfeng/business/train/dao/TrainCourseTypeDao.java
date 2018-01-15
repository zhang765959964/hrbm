package com.xunfeng.business.train.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.train.model.TrainCourseType;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班类型表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:29:51 
* @version V1.0   
*/
@Repository
public class TrainCourseTypeDao extends BaseDao<TrainCourseType>
{
	@Override
	public Class<?> getEntityClass()
	{
		return TrainCourseType.class;
	}

}