package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.AccountPhoneAuth;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:手机认证表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:44
 *</pre>
 */
@Repository
public class AccountPhoneAuthDao extends BaseDao<AccountPhoneAuth>
{
	@Override
	public Class<?> getEntityClass()
	{
		return AccountPhoneAuth.class;
	}

}