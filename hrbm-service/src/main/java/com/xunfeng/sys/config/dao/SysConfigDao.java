package com.xunfeng.sys.config.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.model.SysConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *<pre>
 * 对象功能:RSDA_SYS_CONFIG Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-05-23 14:46:39
 *</pre>
 */
@Repository
public class SysConfigDao extends BaseDao<SysConfig>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysConfig.class;
	}
	
	public List<SysConfig> getAllConfig(QueryFilter queryFilter){
		return this.getListForm("getAllConfig", queryFilter);
	}
	
	 
	
	public SysConfig getConfigByName(String name){
		return this.getUnique("getConfigByName",name);
	}
	 
	public List<SysConfig> getBaseConfigs(){
		return this.getListBySqlKey("getBaseConfigs", "base_config");
	}

}