package com.xunfeng.sys.role.interf;



import com.xunfeng.sys.role.model.SysRoleResource;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 角色功能表 接口类
* @author:liwenhao
* @createDate 2016-06-27 17:38:21 
* @version V1.0   
*/
public interface SysRoleResourceServiceInterf extends GenericServiceInterface<SysRoleResource,Long>
{
	/**
	 * 添加角色权限
	 * @param roleId 角色ID
	 * @param resAryId 权限ID
	 */
	public void addResource(Long roleId, String[] resAryId);
 
}
