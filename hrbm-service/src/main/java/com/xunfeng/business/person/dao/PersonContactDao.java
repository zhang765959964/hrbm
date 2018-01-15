package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.PersonContact;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:个人基本信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 *</pre>
 */
@Repository
public class PersonContactDao extends BaseDao<PersonContact>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonContact.class;
	}

}