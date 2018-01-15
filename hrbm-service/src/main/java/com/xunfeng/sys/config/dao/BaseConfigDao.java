package com.xunfeng.sys.config.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.config.model.BaseConfig;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 系统配置表 Dao类
* @author:wxl
* @createDate 2015-08-07 17:39:43 
* @version V1.0   
*/
@Repository
public class BaseConfigDao extends BaseDao<BaseConfig>
{
	@Override
	public Class<?> getEntityClass()
	{
		return BaseConfig.class;
	}

	public List<BaseConfig> getModelConfig(Long caos05,String caos06){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("caos05",caos05);
		params.put("caos06",caos06);
		return this.getListBySqlKey("getModelConfig",params);
	}

	public BaseConfig getConfigByName(String caos02){
		return this.getUnique("getConfigByName",caos02);
	}
}