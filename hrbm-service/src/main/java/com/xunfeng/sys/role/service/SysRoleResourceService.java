package com.xunfeng.sys.role.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.resource.model.SysResource;
import com.xunfeng.sys.role.dao.SysRoleResourceDao;
import com.xunfeng.sys.role.interf.SysRoleResourceServiceInterf;
import com.xunfeng.sys.role.model.SysRole;
import com.xunfeng.sys.role.model.SysRoleResource;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 角色功能表 Service类
* @author:liwenhao
* @createDate 2016-06-27 17:38:21 
* @version V1.0   
*/
@Service
public class SysRoleResourceService extends BaseService<SysRoleResource> implements SysRoleResourceServiceInterf
{
	@Resource
	private SysRoleResourceDao dao;
	@Resource
	SysRoleService roleService;
	
	public SysRoleResourceService()
	{
	}
	
	@Override
	protected IEntityDao<SysRoleResource, Long> getEntityDao() 
	{
		return dao;
	}
	/**
	 * 删除角色
	 * @param roleId 角色ID
	 */
	private void delResource(Long roleId) {

		if (roleId == null) {
			throw new RuntimeException("角色ID不能为空");
		}
		Map params = new HashMap();
		params.put("roleid", roleId);
//		List<SysRoleResource> roleResList = dao.getBySqlKey("getAll", params);
		EhcacheUtil.getInstance().remove("res.role",roleId);
		dao.delBySqlKey("delById", roleId);
	}

	/**
	 * 添加角色权限
	 * @param roleId 角色ID
	 * @param resAryId 权限ID
	 */
	public void addResource(Long roleId, String[] resAryId) {
		List<Long> res = new ArrayList<Long>();
		delResource(roleId);
		if (resAryId != null && resAryId.length > 0) {
			for (String resId : resAryId) {
				SysRoleResource sysRoleRes = new SysRoleResource();
				sysRoleRes.setRoleid(roleId);
				sysRoleRes.setFunid(new Long(resId));
				this.add(sysRoleRes);
				res.add(new Long(resId));
			}
			EhcacheUtil.getInstance().put("res.role",roleId,res);
		}
	}

}
