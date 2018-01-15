package com.xunfeng.business.person.service;

import com.xunfeng.business.person.dao.AccountMailAuthDao;
import com.xunfeng.business.person.model.AccountMailAuth;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *<pre>
 * 对象功能:邮件认证表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:27
 *</pre>
 */
@Service
public class AccountMailAuthService extends BaseService<AccountMailAuth>
{
	@Resource
	private AccountMailAuthDao dao;
	
	
	
	public AccountMailAuthService()
	{
	}
	
	@Override
	protected IEntityDao<AccountMailAuth, Long> getEntityDao()
	{
		return dao;
	}
	
	
}
