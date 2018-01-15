package com.xunfeng.business.ovemp.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.ovemp.corp.model.OvempCorpCourseType;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班类型表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:29:51 
* @version V1.0   
*/
@Repository
public class OvempCorpCourseTypeDao extends BaseDao<OvempCorpCourseType>
{
	@Override
	public Class<?> getEntityClass()
	{
		return OvempCorpCourseType.class;
	}

}