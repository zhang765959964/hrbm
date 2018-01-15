package com.xunfeng.business.dissupport.divice.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.dissupport.divice.model.DiviConfig;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备配置表 Dao类
* @author:wanghan
* @createDate 2016-07-28 15:30:48 
* @version V1.0   
*/
@Repository
public class DiviConfigDao extends BaseDao<DiviConfig>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DiviConfig.class;
	}

}