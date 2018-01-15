package com.xunfeng.sys.accounts.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.accounts.model.Accounts;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 *<pre>
 * 对象功能:用户信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:24:01
 *</pre>
 */
@Repository
public class AccountsDao extends BaseDao<Accounts>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Accounts.class;
	}
	 

	/**
	 *  根据用户编号修改用户密码
	 */
	public void updatePassword(Long accountId,String password){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("accountId", accountId);
		params.put("password", password);
		this.update("updatePassword", params);
	}
	
	/**
	 * 根据用户编号，修改手机激活状态  
	 * 0未激活 1激活
	 */
	
	public void updateTelephoneStatus(Long accountId,Long status){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("accountId", accountId);
		params.put("telephoneStatus", status);
		this.update("updateTelephoneStatus", params);
	}
	
	
	/**
	 * 根据用户编号，修改邮箱激活状态  
	 * 0未激活 1激活
	 */
	
	public void updateEmailStatus(Long accountId,Long status){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("accountId", accountId);
		params.put("emailStatus", status);
		this.update("updateEmailStatus", params);
	}
}