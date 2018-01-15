package com.xunfeng.sys.statistics.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.statistics.model.SysStatistics;
@Repository
public class SysStatisticsDao extends BaseDao<SysStatistics> {

	@SuppressWarnings("rawtypes")
	@Override
	public Class getEntityClass() {
		return SysStatistics.class;
	}
 
	/**
	 * 查询企业总数
	 * @param queryFilter 查询企业总数
	 * @return 企业总数返回
	 */
	public Integer getCorpStatisticsCount(QueryFilter queryFilter) {
		   @SuppressWarnings("unchecked")
		   Map<String, Object> results = (Map<String, Object>) getOne("getCorpStatisticsCount", queryFilter.getFilters());
	       return  Integer.valueOf(results.get("TOTALNUM").toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCorpStatisticsEcharts(
			QueryFilter queryFilter) {
		return getListBySqlKey("getCorpStatisticsEcharts", queryFilter.getFilters());
	}
}
