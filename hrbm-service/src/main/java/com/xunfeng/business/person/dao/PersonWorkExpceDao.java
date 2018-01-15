package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:个人工作经历表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:00:45
 *</pre>
 */
@Repository
public class PersonWorkExpceDao extends BaseDao<PersonWorkExpce>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonWorkExpce.class;
	}

}