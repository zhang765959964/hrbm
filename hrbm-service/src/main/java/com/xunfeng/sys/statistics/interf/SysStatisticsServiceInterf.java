package com.xunfeng.sys.statistics.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.statistics.model.SysStatistics;

public interface SysStatisticsServiceInterf extends
		GenericServiceInterface<SysStatistics, Long> {
	/**
	 * 个人信息统计
	 * 
	 * @param queryFilter
	 * @return
	 */
	public List<Map<String, Object>> getPersonBaseInfoStatistics(
			QueryFilter queryFilter);

	/**
	 * 企业信息统计
	 * 
	 * @param queryFilter
	 * @return
	 */
	public List<Map<String, Object>> getCorpStatistics(QueryFilter queryFilter);

	/**
	 * 企业报表统计数据获取
	 * 
	 * @param queryFilter
	 *            检索条件
	 * @return 返回结果
	 */
	public List<Map<String, Object>> getCorpStatisticsEcharts(
			QueryFilter queryFilter);

	/**
	 * 个人求职统计
	 * 
	 * @param queryFilter
	 *            检索条件
	 * @return 返回结果
	 */
	public List<Map<String, Object>> getPersonRegistStatistics(
			QueryFilter queryFilter);

	/**
	 * 企业需求统计
	 * @param queryFilter 检索条件
	 * @return 返回结果
	 */
	public List<Map<String, Object>> getCorpDemandStatistics(
			QueryFilter queryFilter);
}
