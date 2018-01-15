package com.xunfeng.business.cation.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.cation.model.Authentication;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Dao类
* @author:wanghan
* @createDate 2015-11-11 18:17:38 
* @version V1.0   
*/
@Repository
public class authenticationDao extends BaseDao<Authentication>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Authentication.class;
	}

}