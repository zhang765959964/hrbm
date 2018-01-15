package com.xunfeng.sys.identity.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.identity.model.BusinessIdentity;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: WS_M_SYS_BUS_ID Dao类
* @author:user
* @createDate 2016-11-29 09:45:50 
* @version V1.0   
*/
@Repository
public class BusinessIdentityDao extends BaseDao<BusinessIdentity>
{
	@Override
	public Class<?> getEntityClass()
	{
		return BusinessIdentity.class;
	}

}