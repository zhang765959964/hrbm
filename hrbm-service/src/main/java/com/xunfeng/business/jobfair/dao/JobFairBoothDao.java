package com.xunfeng.business.jobfair.dao;

import com.xunfeng.business.jobfair.model.JobFairBooth;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位初始化表 Dao类
* @author:wanghan
* @createDate 2015-09-12 11:06:53 
* @version V1.0   
*/
@Repository
public class JobFairBoothDao extends BaseDao<JobFairBooth>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobFairBooth.class;
	}

}