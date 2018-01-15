package com.xunfeng.business.enterprise.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.enterprise.model.Enterprise;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位基本信息表 Dao类
* @author:liwenhao
* @createDate 2016-06-16 16:09:33 
* @version V1.0   
*/
@Repository
public class EnterpriseDao extends BaseDao<Enterprise>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Enterprise.class;
	}

}