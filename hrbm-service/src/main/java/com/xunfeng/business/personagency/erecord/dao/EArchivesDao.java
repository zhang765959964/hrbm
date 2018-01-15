package com.xunfeng.business.personagency.erecord.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.erecord.model.EArchives;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案表 Dao类
* @author:wanghan
* @createDate 2015-08-10 14:59:21 
* @version V1.0   
*/
@Repository
public class EArchivesDao extends BaseDao<EArchives>
{
	@Override
	public Class<?> getEntityClass()
	{
		return EArchives.class;
	}

}