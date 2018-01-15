package com.xunfeng.sys.role.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.role.dao.SysRoleUserDao;
import com.xunfeng.sys.role.interf.SysRoleUserServiceInterf;
import com.xunfeng.sys.role.model.SysRoleUser;

/**
 * <pre>
 * 对象功能:角色人员关系表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-09 09:37:41
 * </pre>
 */
@Service
public class SysRoleUserService extends BaseService<SysRoleUser> implements  SysRoleUserServiceInterf {
	@Resource
	private SysRoleUserDao dao;
	
	@Resource
	UniqueIdUtilService  UniqueIdUtil;

	public SysRoleUserService() {
	}

	@Override
	protected IEntityDao<SysRoleUser, Long> getEntityDao() {
		return dao;
	}

	public void delRoleUser(Long roleId, Long userId) {
		if (roleId == null) {
			throw new RuntimeException("角色Id不能为空");
		}
		if (userId == null) {
			throw new RuntimeException("用户Id不能为空");
		}
		dao.delRoleUser(roleId, userId);
		EhcacheUtil.getInstance().remove("user.role", userId);
	}

	public boolean isExit(Long roleId, Long userId) {
		Map params = new HashMap();
		params.put("roleId", roleId);
		params.put("userId", userId);
		SysRoleUser sysRoleUser = dao.getUnique("getAll", params);
		if (sysRoleUser != null) {
			return true;
		}
		return false;
	}

	public void addUser(Long roleId, Long[] userAryId) {

		for (Long userId : userAryId) {
			if (isExit(roleId, userId)) {
				continue;
			}
			SysRoleUser sysRoleUser = new SysRoleUser();
			sysRoleUser.setId(UniqueIdUtil.genId(SysRoleUser.class.getName()));
			sysRoleUser.setRoleId(roleId);
			sysRoleUser.setUserId(userId);
			this.add(sysRoleUser);
			EhcacheUtil.getInstance().remove("user.role", userId);
		}

	}

	public void delRoleUser(Long roleId, Long[] userAryId) {

		for (Long userId : userAryId) {
			this.delRoleUser(roleId, userId);
		}
	}
}
