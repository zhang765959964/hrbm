package com.xunfeng.business.dissupport.divice.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.dissupport.divice.model.DevType;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备类别表 Dao类
* @author:wanghan
* @createDate 2016-07-28 11:19:04 
* @version V1.0   
*/
@Repository
public class DevTypeDao extends BaseDao<DevType>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DevType.class;
	}

}