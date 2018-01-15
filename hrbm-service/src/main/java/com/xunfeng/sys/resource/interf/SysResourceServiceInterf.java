package com.xunfeng.sys.resource.interf;
import java.util.List;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.resource.model.SysResource;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月29日-上午8:44:52 
* @version V1.0   
*/
public interface SysResourceServiceInterf  extends GenericServiceInterface<SysResource,Long>
{
//	/**
//	 * 新增资源对象，并设置资源对象的路径，路径的规则[父级路径+"."+本资源Id]
//	 * @param entity
//	 */
//	public void add(SysResource sysResource);
//	/**
//	 * 修改资源对象，在修改资源对象时，清除该资源所有对应的角色下的资源缓存
//	 * @param entity
//	 */
//	public void update(SysResource sysResource);
//	
//	/**
//	 * 根据主键删除对象
//	 * @param id
//	 */
//	public void delById(Long id);
//	 /**根据别名获取资源
//	 * @param alias
//	 * @return
//	 */
//	public SysResource getResByAlias(String alias);
//
//	/**获取某个资源下一级的子级资源。
//	 * @param parentId
//	 * @return
//	 */
//	public List<SysResource> getResListByPaerentId(Long parentId);
//	/**获取某个资源下全部的子级资源。
//	 * @param parentId
//	 * @return
//	 */
//	public List<SysResource> getAllResListByPaerentId(Long parentId);
//	/**获取全部的资源，并将该角色下有已分配的资源打上Checked标记
//	 * @param roleId
//	 * @return
//	 */
//	public List<SysResource> getResWithChecked(Long roleId);
//	
//	 /**获取当前人员所有拥有的资源列表
//	 * @param userId  人员Id
//	 * @param parentId 资源父级Id 
//	 * @param hasChild  是否包含子资源
//	 * @return
//	 */
//	public List<SysResource> getUserResource(Long userId,Long parentId,boolean hasChild);
//	
//	/**获取某个用户有权限的资源列表，获取方式为先取缓存，取不到的情况下直接到数据库读取
//	 * @param curUser  当前人员对像
//	 * @param parentId 父级资源Id 
//	 * @param hasChild 是否包含全部子级
//	 * @return
//	 */
//	public List<SysResource> getEhCacheUserResource(SysUser curUser,Long parentId,boolean hasChild);
//	/**获取所有资源列表，直接到数据库读取，该接口主要提供给超级管理员调用
//	 * @param parentId 父级资源Id 
//	 * @param hasChild 是否包含全部子级
//	 * @return
//	 */
//	public List<SysResource> getAllResource(Long parentId,boolean hasChild);
//	   /**获取某个角色所有拥有的资源列表菜单，只包括显示到菜单的资源
//		 * @param userId  人员Id
//		 * @param parentId 资源父级Id 
//		 * @param hasChild  是否包含子资源
//		 * @return
//		 */
//		public List<SysResource> getRoleResourceMenu(Long roleId);
		/**根据资源路径，获取该资源路径对应的资源信息列表
		 * @param resUrl
		 * @return
		 */
		public List<SysResource> getResByUrl(String resUrl);
		
		
		public List<SysResource> getAllUserResourceByUserId(Long userId);
		
		  /**
	     * 根据角色ID查询角色拥有权限
	     * @param roleId 角色ID
	     * @return 角色权限
	     */
		public List<SysResource> getRoleResourceByRoleId(List<Long> roleIds);
		
		
		/**
		 * 获取角色权限编辑树
		 * @param roleId 角色ID
		 * @param userId 当前用户ID
		 * @param isAdmin 是否是管理员
		 * @return 
		 */
		public List<SysResource> getRoleResourceTree(Long roleId,Long userId,boolean isAdmin);
		
		/**
		 * 资源分页列表
		 * @param queryFilter
		 * @return
		 */
		public ResultData<SysResource>  getPageList(QueryFilter queryFilter);
}
