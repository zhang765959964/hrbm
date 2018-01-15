package com.xunfeng.business.jobfair.interf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xunfeng.business.jobfair.dto.JobFairInfoSiteDto;
import com.xunfeng.business.jobfair.model.JobFairInfo;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 招聘会信息表 Service类
 * @author:wanghan
 * @createDate 2015-09-12 11:02:45
 * @version V1.0
 */
@Service
public interface JobFairInfoServiceInter extends GenericServiceInterface<JobFairInfo, Long> {
    
	public List<JobFairInfoSiteDto> getcurrentJobFair(String dateString);
	//传分页取招聘会数据
	public ResultData<JobFairInfoSiteDto> getPagecurrentJobFair(QueryFilter queryFilter);

	public List<JobFairInfo> getAcd200(Long acd200);

	public JobFairInfoSiteDto getJobFairById(String dateString, Long acb330);

	ResultData<JobFairInfo> getJobFairList(QueryFilter queryFilter);
	
	/**
	 * 招聘会视图查询分页
	 * @param queryFilter 检索条件
	 * @return 结果返回
	 */
	public ResultData<JobFairInfo> getJobInfoViewsPageList(QueryFilter queryFilter);
    
	/**
	 * 招聘职位查询
	 * @param queryFilter 检索条件
	 * @return 
	 */
	public  ResultData<Map<String, Object>>  getJobListPage(QueryFilter queryFilter);
	/**
	 * 个人匹配职位查询
	 * @param queryFilter 检索条件
	 * @return 
	 */
	public  ResultData<Map<String, Object>>  getJobMatchListPage(QueryFilter queryFilter);
	/**
	 * 单位匹配求职信息查询
	 * @param queryFilter 检索条件
	 * @return 
	 */
	public  ResultData<Map<String, Object>>  getCorpMatchPersonListPage(QueryFilter queryFilter);
	
	/**
	 * 招聘供求情况统计
	 * @param queryFilter
	 * @return
	 */
	public List<Map<String, Object>>  getjobSuplyDemandList(QueryFilter queryFilter);
	/**
	 * 工种工资统计
	 * @param queryFilter
	 * @return
	 */
	public List<Map<String, Object>>  getJobSalariesStatistics(QueryFilter queryFilter);
}
