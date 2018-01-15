package com.xunfeng.sys.resource.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.resource.dao.SysResourceDao;
import com.xunfeng.sys.resource.interf.SysResourceServiceInterf;
import com.xunfeng.sys.resource.model.SysResource;
import com.xunfeng.sys.role.model.SysRole;
import com.xunfeng.sys.role.service.SysRoleResourceService;
import com.xunfeng.sys.role.service.SysRoleService;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月29日-上午8:44:52 
* @version V1.0   
*/
@Service
public class SysResourceService extends BaseService<SysResource>  implements SysResourceServiceInterf
{
	@Resource
	private SysResourceDao dao;
	@Resource
	SysRoleService sysRoleService;
	
	@Resource
	SysRoleService roleService;
	
	@Resource
	SysRoleResourceService sysRoleResourceService;
	public SysResourceService()
	{
	}
	
	@Override
	protected IEntityDao<SysResource, Long> getEntityDao() 
	{
		return dao;
	}
	
//	/**
//	 * 新增资源对象，并设置资源对象的路径，路径的规则[父级路径+"."+本资源Id]
//	 * @param entity
//	 */
//	public void add(SysResource sysResource)
//	{
//		SysResource parentSysResource =this.getById(sysResource.getParentId());
//		
//		if(parentSysResource!=null){
//			String resPath=parentSysResource.getResPath()+"."+sysResource.getResId();
//			sysResource.setResPath(resPath);
//		}
//		dao.add(sysResource);
//	}
//	/**
//	 * 修改资源对象，在修改资源对象时，清除该资源所有对应的角色下的资源缓存
//	 * @param entity
//	 */
//	public void update(SysResource sysResource)
//	{
//		dao.update(sysResource);
//		List<SysRole> roleList=sysRoleService.getResRole(sysResource.getResId());
//		
//		for(SysRole sysRole: roleList){
//			EhcacheUtil.getInstance().remove("role.res", sysRole.getRoleId());
//		}
//		
//	}
//	
//	/**
//	 * 根据主键删除对象
//	 * @param id
//	 */
//	public void delById(Long id)
//	{
//		dao.delById(id);
//		
//        List<SysRole> roleList=sysRoleService.getResRole(id);
//		
//		for(SysRole sysRole: roleList){
//			EhcacheUtil.getInstance().remove("role.res", sysRole.getRoleId());
//		}
//	}
//	 /**根据别名获取资源
//	 * @param alias
//	 * @return
//	 */
//	public SysResource getResByAlias(String alias){
//	    Map params=new HashMap();
//	    params.put("resAlias", alias);
//		return dao.getUnique("getAll", params);
//	}
//
//	/**获取某个资源下一级的子级资源。
//	 * @param parentId
//	 * @return
//	 */
//	public List<SysResource> getResListByPaerentId(Long parentId){
//	    Map params=new HashMap();
//	    params.put("parentId", parentId);
//		return dao.getBySqlKey("getAll", params);
//	}
//	/**获取某个资源下全部的子级资源。
//	 * @param parentId
//	 * @return
//	 */
//	public List<SysResource> getAllResListByPaerentId(Long parentId){
//		
//		SysResource sysResource=this.getById(parentId);
//	    Map params=new HashMap();
//	    params.put("resPath", sysResource.getResPath()+".%");
//		return dao.getBySqlKey("getAll", params);
//	}
//	/**获取全部的资源，并将该角色下有已分配的资源打上Checked标记
//	 * @param roleId
//	 * @return
//	 */
//	public List<SysResource> getResWithChecked(Long roleId){
//		
//	    Map params=new HashMap();
//	    params.put("roleId", roleId);
//		return dao.getBySqlKey("getResWithChecked", params);
//	}
//	
//	 /**获取当前人员所有拥有的资源列表
//	 * @param userId  人员Id
//	 * @param parentId 资源父级Id 
//	 * @param hasChild  是否包含子资源
//	 * @return
//	 */
//	public List<SysResource> getUserResource(Long userId,Long parentId,boolean hasChild){
//		
//		//List<SysResource> resList=(List<SysResource>)EhcacheUtil.getInstance().get("", "");
//	    Map params=new HashMap();
//	    params.put("userId", userId);
//	    if(hasChild){
//	    	 SysResource sysResource=this.getById(parentId);
//	 	    params.put("resPath", sysResource.getResPath()+".%");
//	    }else{
//	    	params.put("parentId", parentId);
//	    }	   	    
//		return dao.getBySqlKey("getUserResource", params);
//	}
//	
//	/**获取某个用户有权限的资源列表，获取方式为先取缓存，取不到的情况下直接到数据库读取
//	 * @param curUser  当前人员对像
//	 * @param parentId 父级资源Id 
//	 * @param hasChild 是否包含全部子级
//	 * @return
//	 */
//	public List<SysResource> getEhCacheUserResource(SysUser curUser,Long parentId,boolean hasChild){
//		SysResource parentSysResource=null;
//		String admin=SysUser.getAdminAccount();
//		// 添加超级管理员角色。
//		if (admin.equals(curUser.getCczh01())) {
//			return getAllResource( parentId, hasChild);
//		}
//		Long userId=curUser.getAcd230();
//		if(hasChild){
//			parentSysResource=this.getById(parentId);
//	     }
//		List<SysRole> roleList= sysRoleService.getUserRole(userId);
//		List<SysResource> returnResList=new ArrayList();
//		Set<SysResource> resSet=new HashSet<SysResource>();
//		for(SysRole role:roleList){
//			List<SysResource> resList=getRoleResourceMenu(role.getRoleId());
//			resSet.addAll(resList);
//		}
//		for(SysResource res: resSet){
//			if(hasChild){
//				if(res.getResPath().startsWith(parentSysResource.getResPath()+".")){
//					returnResList.add(res);
//				}
//		     }else{
//		    	 if(res.getParentId()==parentId){
//					returnResList.add(res);
//				  }
//		     }
//			
//		}
//		Collections.sort(returnResList,new ComparatorUser());
//		return returnResList;
//	}
//	/**获取所有资源列表，直接到数据库读取，该接口主要提供给超级管理员调用
//	 * @param parentId 父级资源Id 
//	 * @param hasChild 是否包含全部子级
//	 * @return
//	 */
//	public List<SysResource> getAllResource(Long parentId,boolean hasChild){
//		
//	
//	    Map params=new HashMap();
//	    if(hasChild){
//	    	 SysResource sysResource=this.getById(parentId);
//	 	    params.put("resPath", sysResource.getResPath()+".%");
//	    }else{
//	    	params.put("parentId", parentId);
//	    }
//	    params.put("isDisplay", 0);
//		return dao.getBySqlKey("getAll", params);
//	}
//	   /**获取某个角色所有拥有的资源列表菜单，只包括显示到菜单的资源
//		 * @param userId  人员Id
//		 * @param parentId 资源父级Id 
//		 * @param hasChild  是否包含子资源
//		 * @return
//		 */
//		public List<SysResource> getRoleResourceMenu(Long roleId){	
//			List<SysResource> resList=(List<SysResource>)EhcacheUtil.getInstance().get("role.res", roleId);
//			if(resList!=null){
//				return resList;
//			}
//		    Map params=new HashMap();
//		    params.put("roleId", roleId);
//		    params.put("isDisplay", 0);
//		    resList= dao.getBySqlKey("getRoleResource", params);
//			EhcacheUtil.getInstance().put("role.res", roleId, resList);
//			return resList;
//		}
//		/**根据资源路径，获取该资源路径对应的资源信息列表
//		 * @param resUrl
//		 * @return
//		 */
		public List<SysResource> getResByUrl(String resUrl){	
		    Map params=new HashMap();
		    params.put("resUrl", resUrl);  	    
		    List<SysResource> resList= dao.getBySqlKey("getResByUrl", params);
			return resList;
		}
//		
//		public class ComparatorUser implements Comparator{
//
//			@Override
//			public int compare(Object arg0, Object arg1) {
//				
//				SysResource res0=(SysResource)arg0;
//				SysResource res1=(SysResource)arg1;
//				return res0.getResSn().compareTo(res1.getResSn());
//
//			}
//	 }
		
	 
		@Override
		public ResultData<SysResource> getPageList(QueryFilter queryFilter) {
			@SuppressWarnings("unchecked")
			List<SysResource> SysOrgs = dao.getListForm("getAll", queryFilter);
			ResultData<SysResource> resultData = new ResultData<SysResource>();
			resultData.setPageBean(queryFilter.getPageBean());
			resultData.setDataList(SysOrgs);
			return resultData;
		}
		public List<SysResource> getAllUserResourceByUserId(Long userId){
			
			Map param=new HashMap();
			param.put("userId", userId);
			return dao.getBySqlKey("getAllUserResourceByUserId", param);
			
		}
		
		  /**
	     * 根据角色ID查询角色拥有权限
	     * @param roleId
	     * @return
	     */
		public List<SysResource> getRoleResourceByRoleId(List<Long> roleIds){
	    	return dao.getResourceByRoleId(roleIds);
	    }
		
		/**
		 * 获取角色权限编辑树
		 * @param roleId 角色ID
		 * @param userId 当前用户ID
		 * @return 
		 */
		public List<SysResource> getRoleResourceTree(Long roleId,Long userId,boolean isAdmin){
			 List<SysResource> returnResults = new ArrayList<SysResource>();
			//查询该用户拥有角色
			List<SysRole> sysRoles = roleService.getUserRole(userId);
			List<Long> roleIds = new ArrayList<Long>();
			 for (SysRole sysRole : sysRoles) {
				 roleIds.add(sysRole.getRoleid());
			}
			//查询该用户所有权限
			if(roleIds!=null){
			    returnResults =isAdmin?this.getAll():this.getRoleResourceByRoleId(roleIds);
			    //查询该角色拥有权限
				List<Long> list = new ArrayList<Long>(1);
				list.add(roleId);
				List<SysResource> roleResources =this.getRoleResourceByRoleId(list);
				//
				for (SysResource sysResource : returnResults) {
					if(roleResources.contains(sysResource)){
						sysResource.setChecked(true);
					}
				}
			}
			return returnResults;
		}
}
