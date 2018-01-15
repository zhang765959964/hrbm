package com.xunfeng.sys.config.interf;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.dao.SysConfigDao;
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
public interface SysConfigServiceInter  extends GenericServiceInterface<SysConfig,Long>
{
	
	
	public List<SysConfig> getDatagridData(QueryFilter filter);
	
	public SysConfig getConfigByName(String name);
	
	public List<SysConfig> getBaseConfigs();
	
	public void saveBaseConfig(Long[] ids,String[] values);
	
}
