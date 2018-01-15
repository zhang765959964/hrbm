package com.xunfeng.sys.uums.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.core.util.MapBeanCopyUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;
import com.xunfeng.sys.uums.dao.SysUserDao;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * <pre>
 * 对象功能:从业人员信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-27 16:40:20
 * </pre>
 */
@Service
public class SysUserService extends BaseService<SysUser> implements
		SysUserServiceInterf {
	@Resource
	private SysUserDao dao;
	@Resource
	BaseConfigServiceInterf baseConfigService;
	public SysUserService() {
	}

	@Override
	protected IEntityDao<SysUser, Long> getEntityDao() {
		return dao;
	}

	public void update(Map dataMap, SysUser sysUser) {
		SysUser old_sysUser = dao.getById(sysUser.getAcd230());
		SysUser new_sysUser = MapBeanCopyUtil.MapToBean(dataMap, old_sysUser);

		dao.update(new_sysUser);
	}

	/**
	 * 根据用户名称获取用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public SysUser getByUserName(String userName) {
		return dao.getByUserName(userName);
	}

	/**
	 * 设置人员的机构部门
	 * 
	 * @param userIds
	 * @param deptId
	 * @param orgId
	 */
	public void updateUserDept(String userIds, Long deptId, Long orgId) {
		dao.updateUserDept(userIds, deptId, orgId);
	}

	/**
	 * 获取某个角色下的分页用户列表
	 * 
	 * @param queryFilter
	 * @return
	 */
	public List<SysUser> getUserListByRoleId(QueryFilter queryFilter) {

		return dao.getUserListByRoleId(queryFilter);

	}

	/**
	 * 获取某个角色下的分页用户列表
	 * 
	 * @param queryFilter
	 *            检索条数
	 * @return 分页数据返回
	 */
	public ResultData<SysUser> getUserListPageByRoleId(QueryFilter queryFilter) {

		return dao.getUserListPageByRoleId(queryFilter);

	}

	/**
	 * 获取某个角色可添加用户分页列表
	 * 
	 * @param queryFilter
	 *            检索条数
	 * @return 分页数据返回
	 */
	public ResultData<SysUser> getUserListPageByNoRoleId(QueryFilter queryFilter) {
		return dao.getUserListPageByNoRoleId(queryFilter);
	}

	/**
	 * 更新用户角色信息
	 * 
	 * @param userIds  需要修改的用户ID
	 * @param roleId   添加角色
	 */
	public void addUserRoles(String userIds, String roleId) {
		Long roleIdLong = Long.valueOf(roleId);
		roleId = String.valueOf(roleIdLong);
		// 获取用户信息
		if (!StringUtil.isEmpty(roleId)) {
			List<SysUser> sysUsers = dao.getUserListByUserIds(userIds);
			List<SysUser> updateUsers = new ArrayList<SysUser>();
			if (sysUsers != null)
				for (SysUser sysUser : sysUsers) {
					String cczh03 = sysUser.getCczh03();
					if (!StringUtil.isEmpty(cczh03)) {
						List<String> roles = Arrays.asList(cczh03.split(","));
						if (!roles.contains(roleId)) {
							sysUser.setCczh03(cczh03.concat(",".concat(roleId)));
							updateUsers.add(sysUser);
						}
					} else {
						sysUser.setCczh03(roleId);
						updateUsers.add(sysUser);
					}
					EhcacheUtil.getInstance().remove("user.role", sysUser.getAcd230());
				}
			dao.updateUserRoles(updateUsers);
		}
	}
	
	/**
	 * 为删除某个角色权限
	 * 
	 * @param userIds  需要更改的用户ID
	 * @param roleId   添加角色
	 */
	public void delUserRoles(String userIds, String roleId) {
		Long roleIdLong = Long.valueOf(roleId);
		roleId = String.valueOf(roleIdLong);
		// 获取用户信息
		if (!StringUtil.isEmpty(roleId)) {
			List<SysUser> sysUsers = dao.getUserListByUserIds(userIds);
			List<SysUser> updateUsers = new ArrayList<SysUser>();
			if (sysUsers != null)
				for (SysUser sysUser : sysUsers) {
					String cczh03 = sysUser.getCczh03();
					if (!StringUtil.isEmpty(cczh03)) {
						List<String> roles = new ArrayList<String>();
						String[] ros =cczh03.split(",");
						//Arrays.asList() 返回数据不能remove
						for (int i = 0; i < ros.length; i++) {
							roles.add(ros[i]);
						}
						if (roles.contains(roleId)) {
							roles.remove(roleId);
							sysUser.setCczh03(org.apache.commons.lang.StringUtils.join(roles.toArray(),","));
							updateUsers.add(sysUser);
						}
					}
					EhcacheUtil.getInstance().remove("user.role", sysUser.getAcd230());
				}
			dao.updateUserRoles(updateUsers);
		}
	}
	
	/**
	 * 获取某个部门下可添加人员列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<SysUser> getUserListOtherDeptPage(QueryFilter queryFilter){
		return dao.getUserListOtherDeptPage(queryFilter);
	}
	/**
	 * 获取某个部门下可添加人员列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<SysUser> getUserListPage(QueryFilter queryFilter){
		return dao.getUserListPage(queryFilter);
	}
	
 
}
