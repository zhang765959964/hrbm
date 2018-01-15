package com.xunfeng.business.train.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.train.model.TrainCourse;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班信息表 Dao类
* @author:Wang.CS
* @createDate 2016-05-22 09:25:59 
* @version V1.0   
*/
@Repository
public class TrainCourseDao extends BaseDao<TrainCourse>
{
	@Override
	public Class<?> getEntityClass()
	{
		return TrainCourse.class;
	}

}