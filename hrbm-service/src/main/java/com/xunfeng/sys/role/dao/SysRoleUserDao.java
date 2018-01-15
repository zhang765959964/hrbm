package com.xunfeng.sys.role.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.role.model.SysRoleUser;
/**
 *<pre>
 * 对象功能:角色人员关系表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-09 09:37:41
 *</pre>
 */
@Repository
public class SysRoleUserDao extends BaseDao<SysRoleUser>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysRoleUser.class;
	}
	
	public void delRoleUser(Long roleId,Long userId){
		 Map params=new HashMap();
		 params.put("userId", userId);
		 params.put("roleId", roleId);
		 this.delBySqlKey("delRoleUser", params);
	 }
}