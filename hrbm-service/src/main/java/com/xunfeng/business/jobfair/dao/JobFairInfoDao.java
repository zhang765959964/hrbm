package com.xunfeng.business.jobfair.dao;

import java.util.List;
import java.util.Map;

import com.xunfeng.business.jobfair.model.JobFairInfo;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;

import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 招聘会信息表 Dao类
* @author:wanghan
* @createDate 2015-09-12 11:02:45 
* @version V1.0   
*/
@Repository
public class JobFairInfoDao extends BaseDao<JobFairInfo>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobFairInfo.class;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getJobListPage(QueryFilter queryFilter) {
		return getListForm("getJobListPage", queryFilter);
	}
	
	@SuppressWarnings("unchecked")
	 public List<Map<String, Object>>  getjobSuplyDemandList(QueryFilter queryFilter) {
		return getListBySqlKey("getjobSuplyDemandList", queryFilter.getFilters());
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getJobSalariesStatistics(QueryFilter queryFilter) {
		return getListBySqlKey("getJobSalariesStatistics", queryFilter.getFilters());
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getJobMatchListPage(QueryFilter queryFilter) {
		return getListForm("getJobMatchListPage", queryFilter);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCorpMatchPersonListPage(
			QueryFilter queryFilter) {
		return getListForm("getCorpMatchPersonListPage", queryFilter);
	}
}