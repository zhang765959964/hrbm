package com.xunfeng.sys.config.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.dao.SysConfigDao;
import com.xunfeng.sys.config.interf.SysConfigServiceInter;
import com.xunfeng.sys.config.model.SysConfig;

/**
 *<pre>
 * 对象功能:RSDA_SYS_CONFIG Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-05-23 14:46:39
 *</pre>
 */
@Service
public class SysConfigService extends BaseService<SysConfig> implements SysConfigServiceInter
{
	@Resource
	private SysConfigDao dao;

	public SysConfigService()
	{
	}
	
	@Override
	protected IEntityDao<SysConfig, Long> getEntityDao()
	{
		return dao;
	}
	
	public List<SysConfig> getDatagridData(QueryFilter filter){
		return dao.getAllConfig(filter);
	}
	
	public SysConfig getConfigByName(String name){
		return dao.getConfigByName(name);
	}
	
	public List<SysConfig> getBaseConfigs(){
		return dao.getBaseConfigs();
	}
	
	public void saveBaseConfig(Long[] ids,String[] values){
		for(int i=0;i<ids.length;i++){
		  SysConfig sysConfig =dao.getById(ids[i]);
		  sysConfig.setValue(values[i]);
		  dao.update(sysConfig);
		}
	}
	
	
	
	
	
	
}
