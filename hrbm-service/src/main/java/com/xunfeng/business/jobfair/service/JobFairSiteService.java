package com.xunfeng.business.jobfair.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.jobfair.dao.JobFairSiteDao;
import com.xunfeng.business.jobfair.interf.JobFairSiteServiceInterf;
import com.xunfeng.business.jobfair.model.JobFairBooth;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 场地表 Service类
* @author:wanghan
* @createDate 2015-09-12 11:18:57 
* @version V1.0   
*/
@Service
public class JobFairSiteService extends BaseService<JobFairSite> implements JobFairSiteServiceInterf
{
	@Resource
	private JobFairSiteDao dao;
	@Resource
	JobFairBoothService  jobFairBoothService;
	
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	
	
	public JobFairSiteService()
	{
	}
	@Override
	protected IEntityDao<JobFairSite, Long> getEntityDao() 
	{
		return dao;
	}

	/**
	 * 增加场地时自动增加一个摊位 郑大项目专用
	 * @param jobFairSite
	 *
	 */
	public void add(JobFairSite jobFairSite) {
		JobFairBooth jobFairBooth=new JobFairBooth();
		jobFairBooth.setAce200(UniqueIdUtil.genId(JobFairBooth.class.getName()));
		jobFairBooth.setAcd250(jobFairSite.getAcd250());
		jobFairBoothService.add(jobFairBooth);
		this.getEntityDao().add(jobFairSite);
	}
	public JobFairSite getByAcd200(String acd200) {
		// TODO Auto-generated method stub
		return (JobFairSite) dao.getBySqlKey("getByAcd200",acd200);
	}
	
	/* 根据招聘会Id获取招聘会对应的场地列表
	 * @param  acb330,招聘会Id
	 */
	public List<JobFairSite> getJobFairSite(Long acb330){
		
		return dao.getBySqlKey("getByFairId", acb330);
	}
}
