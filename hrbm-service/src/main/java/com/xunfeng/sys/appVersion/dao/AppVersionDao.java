package com.xunfeng.sys.appVersion.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.appVersion.model.AppVersion;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: app版本表 Dao类
* @author:jiangxin
* @createDate 2016-11-29 17:05:15 
* @version V1.0   
*/
@Repository
public class AppVersionDao extends BaseDao<AppVersion>
{
	@Override
	public Class<?> getEntityClass()
	{
		return AppVersion.class;
	}

}