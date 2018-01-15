package com.xunfeng.business.jobfair.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.jobfair.dao.JobFairInfoSiteDao;
import com.xunfeng.business.jobfair.interf.JobFairInfoSiteServiceInterf;
import com.xunfeng.business.jobfair.model.JobFairInfoSite;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 场地初始化表 Service类
* @author:wanghan
* @createDate 2015-09-12 11:17:55 
* @version V1.0   
*/
@Service
public class JobFairInfoSiteService extends BaseService<JobFairInfoSite>  implements JobFairInfoSiteServiceInterf
{
	@Resource
	private JobFairInfoSiteDao dao;
	
	
	
	public JobFairInfoSiteService()
	{
	}
	
	@Override
	protected IEntityDao<JobFairInfoSite, Long> getEntityDao() 
	{
		return dao;
	}
	
	public void dateleByJobFairInfoId(Long infoId){
		Map params=new HashMap();
		params.put("acb330",infoId);
		dao.delBySqlKey("dateleByJobFairInfoId", params);
	}

	public List<JobFairInfoSite> getJobFairInfoSite(Long acb330){
		Map params=new HashMap();
		params.put("acb330",acb330);
		List<JobFairInfoSite>  obFairInfoSiteList=dao.getBySqlKey("getAll",params);

		return obFairInfoSiteList;


	}
}
