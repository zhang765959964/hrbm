package com.xunfeng.business.person.service;

import com.xunfeng.business.person.dao.AccountPhoneAuthDao;
import com.xunfeng.business.person.model.AccountPhoneAuth;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *<pre>
 * 对象功能:手机认证表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:44
 *</pre>
 */
@Service
public class AccountPhoneAuthService extends BaseService<AccountPhoneAuth>
{
	@Resource
	private AccountPhoneAuthDao dao;
	
	
	
	public AccountPhoneAuthService()
	{
	}
	
	@Override
	protected IEntityDao<AccountPhoneAuth, Long> getEntityDao()
	{
		return dao;
	}
	
	
}
