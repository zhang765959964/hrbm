package com.xunfeng.business.jobfair.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.jobfair.dao.JobFairBoothDao;
import com.xunfeng.business.jobfair.interf.JobFairBoothServiceInterf;
import com.xunfeng.business.jobfair.model.JobFairBooth;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 摊位初始化表 Service类
* @author:wanghan
* @createDate 2015-09-12 11:06:53 
* @version V1.0   
*/
@Service
public class JobFairBoothService extends BaseService<JobFairBooth>  implements JobFairBoothServiceInterf
{
	@Resource
	private JobFairBoothDao dao;
	
	
	public JobFairBoothService()
	{
	}
	
	@Override
	protected IEntityDao<JobFairBooth, Long> getEntityDao() 
	{
		return dao;
	}
	

	
}
