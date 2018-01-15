package com.xunfeng.business.jobfair.dao;

import com.xunfeng.business.jobfair.model.JobFairInfoSite;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 场地初始化表 Dao类
* @author:wanghan
* @createDate 2015-09-12 11:17:55 
* @version V1.0   
*/
@Repository
public class JobFairInfoSiteDao extends BaseDao<JobFairInfoSite>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobFairInfoSite.class;
	}

}