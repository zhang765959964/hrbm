package com.xunfeng.sys.role.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.role.model.SysRole;
/**
 *<pre>
 * 对象功能:系统角色表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-08 16:08:57
 *</pre>
 */
@Repository
public class SysRoleDao extends BaseDao<SysRole>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysRole.class;
	}

}