package com.xunfeng.sys.uums.interf;
import java.util.List;
import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysUser;

/**
 *<pre>
 * 对象功能:从业人员信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-27 16:40:20
 *</pre>
 */
public interface SysUserServiceInterf extends GenericServiceInterface<SysUser,Long>
{
	
	public void update(Map dataMap,SysUser sysUser);
	/**根据用户名称获取用户信息
	 * @param userName
	 * @return
	 */
	public SysUser getByUserName(String userName) ;
	
	/**设置人员的机构部门
	 * @param userIds
	 * @param deptId
	 * @param orgId
	 */
	public void updateUserDept(String userIds,Long deptId,Long orgId);
	
	/**
	 * 获取某个角色下的分页用户列表
	 * @param queryFilter
	 * @return
	 */
	public List<SysUser> getUserListByRoleId(QueryFilter queryFilter);
	
	/**
	 * 获取某个角色下的分页用户列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<SysUser> getUserListPageByRoleId(QueryFilter queryFilter);
	
	/**
	 * 获取某个角色可添加用户分页列表
	 * @param queryFilter 检索条数
	 * @return 分页数据返回
	 */
	public ResultData<SysUser> getUserListPageByNoRoleId(QueryFilter queryFilter);
	
	/**
	 * 更新用户角色信息
	 * 
	 * @param userIds  需要修改的用户ID
	 * @param roleId   添加角色
	 */
	public void addUserRoles(String userIds, String roleId);
	
	/**
	 * 为删除某个角色权限
	 * 
	 * @param userIds  需要更改的用户ID
	 * @param roleId   添加角色
	 */
	public void delUserRoles(String userIds, String roleId);
	
	/**
	 * 获取某个部门下可添加人员列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<SysUser> getUserListOtherDeptPage(QueryFilter queryFilter);
	
	
	/**
	 * 获取某个部门下可添加人员列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<SysUser> getUserListPage(QueryFilter queryFilter);
}
