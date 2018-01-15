package com.xunfeng.business.jobfair.interf;

import java.util.List;

import com.xunfeng.business.jobfair.model.JobFairInfoSite;
import com.xunfeng.core.service.GenericServiceInterface;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 场地初始化表 Service类
* @author:wanghan
* @createDate 2015-09-12 11:17:55 
* @version V1.0   
*/
public interface JobFairInfoSiteServiceInterf extends GenericServiceInterface<JobFairInfoSite,Long>
{

	public void dateleByJobFairInfoId(Long infoId);

	public List<JobFairInfoSite> getJobFairInfoSite(Long acb330);
}
