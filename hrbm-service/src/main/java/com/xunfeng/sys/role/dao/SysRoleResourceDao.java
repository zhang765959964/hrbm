package com.xunfeng.sys.role.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.resource.model.SysResource;
import com.xunfeng.sys.role.model.SysRoleResource;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 角色功能表 Dao类
* @author:liwenhao
* @createDate 2016-06-27 17:38:21 
* @version V1.0   
*/
@Repository
public class SysRoleResourceDao extends BaseDao<SysRoleResource>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysRoleResource.class;
	}

}