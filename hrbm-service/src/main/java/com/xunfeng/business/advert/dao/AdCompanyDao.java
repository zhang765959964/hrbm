package com.xunfeng.business.advert.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.advert.model.AdCompany;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位放置表 Dao类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
@Repository
public class AdCompanyDao extends BaseDao<AdCompany>
{
	@Override
	public Class<?> getEntityClass()
	{
		return AdCompany.class;
	}
}