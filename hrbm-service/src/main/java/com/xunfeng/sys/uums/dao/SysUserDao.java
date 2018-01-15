package com.xunfeng.sys.uums.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysDept;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * <pre>
 * 对象功能:从业人员信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-27 16:40:20
 * </pre>
 */
@Repository
public class SysUserDao extends BaseDao<SysUser> implements UserDetailsService {
	@Override
	public Class<?> getEntityClass() {
		return SysUser.class;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		SysUser sysUser = getByUserName(username);
		if (sysUser == null)
			throw new UsernameNotFoundException("用户不存在");
		return sysUser;
	}

	public SysUser getByUserName(String userName) {
		SysUser sysUser = (SysUser) getUnique("getByUserName", userName);
		return sysUser;
	}
	
	public void updateUserDept(String userIds,Long deptId,Long orgId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dep001", deptId);
		params.put("acd200", orgId);
		if(!StringUtil.isEmpty(userIds)){
		params.put("acd230s", Arrays.asList(userIds.split(",")));
		this.update("udpateUserDept", params);
		}
	}
	
	public List<SysUser> getUserListByRoleId(QueryFilter queryFilter) {
		  
		return this.getList("getUserListByRoleId", queryFilter);

	}
	
 
	/**
	 * 更新用户角色信息
	 * @param userId 用户主键
	 * @param cczh03 角色权限编号
	 */
	public void updateUserRoles(String userId,String cczh03){
		SysUser sysUser = new SysUser();
		sysUser.setAcd230(Long.valueOf(userId));
		sysUser.setCczh03(cczh03);
		this.update("udpateUserRoles", sysUser);
	}
	
	/**
	 * 更新用户角色信息
	 * @param userId 用户主键
	 * @param cczh03 角色权限编号
	 */
	public void updateUserRoles(List<SysUser> users){
		for (SysUser sysUser : users) {
			this.update("udpateUserRoles", sysUser);
		}
	}
	
	/**
	 * 根据用户Id查询用户集合
	 * @param userIds 用户id
	 * @return 用户集合
	 */
	public List<SysUser> getUserListByUserIds(String userIds) {
		if(StringUtil.isEmpty(userIds)){
			return new ArrayList<SysUser>();
		}
		Map<String, List<String>> param = new HashMap<String, List<String>>();
		param.put("list",  Arrays.asList(userIds.split(",")));
		return this.getList("getUserListByUserIds",param);

	}
	
	/**
	 * 根据角色查询用户分页
	 * @param queryFilter 检索条件
	 * @return 返回数据
	 */
	public ResultData<SysUser> getUserListPageByRoleId(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<SysUser> users = this.getListForm("getUserListByRoleId", queryFilter);
		ResultData<SysUser> resultData = new ResultData<SysUser>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(users);
		return resultData;
	}
	
	/**
	 * 查询可添加该角色的人员
	 * @param queryFilter 检索条件
	 * @return 返回数据
	 */
	public ResultData<SysUser> getUserListPageByNoRoleId(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<SysUser> users = this.getListForm("getUserListByNoRoleId", queryFilter);
		ResultData<SysUser> resultData = new ResultData<SysUser>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(users);
		return resultData;
	}
	
	/**
	 * 查询可添加该角色的人员
	 * @param queryFilter 检索条件
	 * @return 返回数据
	 */
	public ResultData<SysUser> getUserListOtherDeptPage(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<SysUser> users = this.getListForm("getUserListOtherDeptPage", queryFilter);
		ResultData<SysUser> resultData = new ResultData<SysUser>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(users);
		return resultData;
	}
	/**
	 * 获取人员分页列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<SysUser> getUserListPage(QueryFilter queryFilter){
		@SuppressWarnings("unchecked")
		List<SysUser> users = this.getListForm("getAll", queryFilter);
		ResultData<SysUser> resultData = new ResultData<SysUser>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(users);
		return resultData;
	}
}