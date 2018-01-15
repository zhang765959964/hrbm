package com.xunfeng.business.personagency.erecord.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.erecord.model.ErecordCatalog;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案目录 Dao类
* @author:wanghan
* @createDate 2015-08-10 15:00:46 
* @version V1.0   
*/
@Repository
public class ErecordCatalogDao extends BaseDao<ErecordCatalog>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ErecordCatalog.class;
	}

}