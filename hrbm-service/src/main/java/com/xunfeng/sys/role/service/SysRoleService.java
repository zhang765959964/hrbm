package com.xunfeng.sys.role.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.resource.service.SysResourceService;
import com.xunfeng.sys.role.dao.SysRoleDao;
import com.xunfeng.sys.role.interf.SysRoleServiceInterf;
import com.xunfeng.sys.role.model.SysRole;

/**
 *<pre>
 * 对象功能:系统角色表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-08 16:08:57
 *</pre>
 */
@Service
public class SysRoleService extends BaseService<SysRole> implements SysRoleServiceInterf
{
	@Resource
	SysRoleUserService sysRoleUserService;
	
	@Resource
	private SysRoleDao dao;
	
	
	
	public SysRoleService()
	{
	}
	
	@Override
	protected IEntityDao<SysRole, Long> getEntityDao() 
	{
		return dao;
	}
	
	
	/**获取某个用户下所拥有的角色列表，并将结果放入缓存
	 * @param userId
	 * @return
	 */
	public List<SysRole> getUserRole(Long userId){
		List<SysRole> roleList=(List<SysRole>)EhcacheUtil.getInstance().get("user.role", userId);
		if(roleList!=null&&roleList.size()>0){
			return roleList;
		}
	    Map params=new HashMap();
	    params.put("userId", userId);  	    
	    roleList= dao.getBySqlKey("getUserRole", params);
	    EhcacheUtil.getInstance().put("user.role", userId, roleList);
		return roleList;
	}
	
	
	/**获取某个资源对应的角色集合,判断某个路径是不是系统资源，如果是返回给路径的角色集合
	 * @param url  资源url
	 * @return  角色列表
	 */
	public Map getRightResRole(String url){
		Map map=new HashMap();
		Map params=new HashMap();
		params.put("funmapping", url);
		List<SysRole> sysRoleList= dao.getBySqlKey("getUserRoleByUrl", params);
		if(sysRoleList==null||sysRoleList.isEmpty()){
			map.put("isRes", false); 
		}else{
			map.put("isRes", true); 
		}
		map.put("roleList", sysRoleList); 

		return map;
	}
	
	/**获取某个资源对应的角色集合
	 * @param url  资源url
	 * @return  角色列表
	 */
	public List<SysRole> getResRole(Long resId){
		List<SysRole> roleList=(List<SysRole>)EhcacheUtil.getInstance().get("res.role", resId);
		if(roleList!=null){
			return roleList;
		}
	    Map params=new HashMap();
	    params.put("resId", resId);  	    
	    roleList= dao.getBySqlKey("getResRole", params);
	    EhcacheUtil.getInstance().put("res.role", resId, roleList);
		return roleList;
	}
	
	@Override
	public ResultData<SysRole> getPageList(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<SysRole> SysOrgs = dao.getListForm("getAll", queryFilter);
		ResultData<SysRole> resultData = new ResultData<SysRole>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(SysOrgs);
		return resultData;
	}
}
