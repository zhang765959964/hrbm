package com.xunfeng.business.personagency.subsidy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidyBatch;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_SUBSIDY_BATCH Dao类
* @author:wanghan
* @createDate 2016-07-15 14:28:38 
* @version V1.0   
*/
@Repository
public class SocialSubsidyBatchDao extends BaseDao<SocialSubsidyBatch>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SocialSubsidyBatch.class;
	}
	public void batchAdd(List<SocialSubsidyBatch> batchList){
		
		 this.insert("batchAdd_"+this.getDbType(), batchList);
	}
}