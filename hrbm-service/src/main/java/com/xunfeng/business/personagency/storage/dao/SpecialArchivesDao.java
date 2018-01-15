package com.xunfeng.business.personagency.storage.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.storage.model.SpecialArchives;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 特殊档案表 Dao类
* @author:jiangxin
* @createDate 2016-08-15 14:27:06 
* @version V1.0   
*/
@Repository
public class SpecialArchivesDao extends BaseDao<SpecialArchives>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SpecialArchives.class;
	}

}