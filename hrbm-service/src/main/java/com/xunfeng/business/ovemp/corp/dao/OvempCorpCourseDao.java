package com.xunfeng.business.ovemp.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.ovemp.corp.model.OvempCorpCourse;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班信息表 Dao类
* @author:Wang.CS
* @createDate 2016-05-22 09:25:59 
* @version V1.0   
*/
@Repository
public class OvempCorpCourseDao extends BaseDao<OvempCorpCourse>
{
	@Override
	public Class<?> getEntityClass()
	{
		return OvempCorpCourse.class;
	}

}