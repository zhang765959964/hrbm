package com.xunfeng.business.jobfair.dao;

import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 场地表 Dao类
* @author:wanghan
* @createDate 2015-09-12 11:18:57 
* @version V1.0   
*/
@Repository
public class JobFairSiteDao extends BaseDao<JobFairSite>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobFairSite.class;
	}

}