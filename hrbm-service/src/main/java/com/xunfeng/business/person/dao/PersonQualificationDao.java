package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.PersonQualification;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:个人资格证书表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:29
 *</pre>
 */
@Repository
public class PersonQualificationDao extends BaseDao<PersonQualification>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonQualification.class;
	}

}