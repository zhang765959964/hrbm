package com.xunfeng.business.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.corp.model.CorpCollection;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业人才收藏夹 Dao类
* @author:jiangxin
* @createDate 2015-12-10 14:45:18 
* @version V1.0   
*/
@Repository
public class CorpCollectionDao extends BaseDao<CorpCollection>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpCollection.class;
	}

}