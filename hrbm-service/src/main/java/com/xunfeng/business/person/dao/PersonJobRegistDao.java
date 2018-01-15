package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:个人求职登记表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:03
 *</pre>
 */
@Repository
public class PersonJobRegistDao extends BaseDao<PersonJobRegist>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonJobRegist.class;
	}

}