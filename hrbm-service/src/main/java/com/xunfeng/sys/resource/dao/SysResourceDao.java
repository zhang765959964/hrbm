package com.xunfeng.sys.resource.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.resource.model.SysResource;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月29日-上午8:44:32 
* @version V1.0   
*/
@Repository
public class SysResourceDao extends BaseDao<SysResource>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysResource.class;
	}
	
    /**
     * 根据角色ID查询角色拥有权限
     * @param roleId
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<SysResource> getResourceByRoleId(List<Long> roleIds){
    	Map<String, List<Long>> map = new HashMap<String, List<Long>>();
    	map.put("roles", roleIds);
    	return this.getListBySqlKey("getRoleResourceByRoleId", map);
    }
}