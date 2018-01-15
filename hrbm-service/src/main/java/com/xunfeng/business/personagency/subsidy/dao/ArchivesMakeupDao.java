package com.xunfeng.business.personagency.subsidy.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.subsidy.model.ArchivesMakeup;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_ARCHIVES_MAKEUP Dao类
* @author:user
* @createDate 2016-12-01 11:32:07 
* @version V1.0   
*/
@Repository
public class ArchivesMakeupDao extends BaseDao<ArchivesMakeup>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ArchivesMakeup.class;
	}

}