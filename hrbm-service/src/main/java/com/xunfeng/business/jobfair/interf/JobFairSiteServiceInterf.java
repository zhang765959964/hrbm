package com.xunfeng.business.jobfair.interf;

import java.util.List;

import com.xunfeng.business.jobfair.model.JobFairInfoSite;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.core.service.GenericServiceInterface;
/**
* @company:河南讯丰信息技术有限公司
* @Description: 场地表 Service类
* @author:wanghan
* @createDate 2015-09-12 11:18:57 
* @version V1.0   
*/
public interface JobFairSiteServiceInterf extends GenericServiceInterface<JobFairSite,Long>
{


	/**
	 * 增加场地时自动增加一个摊位 郑大项目专用
	 * @param jobFairSite
	 *
	 */
	public void add(JobFairSite jobFairSite) ;
	public JobFairSite getByAcd200(String acd200) ;
	public List<JobFairSite> getJobFairSite(Long acb330);
	
}
