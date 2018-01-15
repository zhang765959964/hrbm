package com.xunfeng.business.personagency.subsidy.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.subsidy.model.SocialBatch;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_BATCH Dao类
* @author:wanghan
* @createDate 2016-07-07 09:12:59 
* @version V1.0   
*/
@Repository
public class SocialBatchDao extends BaseDao<SocialBatch>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SocialBatch.class;
	}

}