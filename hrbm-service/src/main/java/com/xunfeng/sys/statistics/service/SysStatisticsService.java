package com.xunfeng.sys.statistics.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.statistics.dao.SysStatisticsDao;
import com.xunfeng.sys.statistics.interf.SysStatisticsServiceInterf;
import com.xunfeng.sys.statistics.model.SysStatistics;

/**
 * <pre>
 * 对象功能:科室表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-30 09:51:03
 * </pre>
 */
@Service
public class SysStatisticsService extends BaseService<SysStatistics> implements
		SysStatisticsServiceInterf {
	@Resource
	private SysStatisticsDao dao;

	public SysStatisticsService() {
	}

	@Override
	protected IEntityDao<SysStatistics, Long> getEntityDao() {
		return dao;
	}

	/**
	 * 个人信息统计
	 * 
	 * @param queryFilter
	 *            检索条件
	 * @return 数据结果返回
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getPersonBaseInfoStatistics(
			QueryFilter queryFilter) {
		dao.getListBySqlKey("getPersonBaseInfoStatistics",
				queryFilter.getFilters());
		return (List<Map<String, Object>>) queryFilter.getFilters().get(
				"V_CURSOR");
	}

	/*
	 * 企业信息统计 (non-Javadoc)
	 * 
	 * @see
	 * com.xunfeng.business.corp.interf.CorpServiceInter#getCorpStatistics(com
	 * .xunfeng.core.web.query.QueryFilter)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getCorpStatistics(QueryFilter queryFilter) {
		dao.getListBySqlKey("getCorpStatistics", queryFilter.getFilters());
		return (List<Map<String, Object>>) queryFilter.getFilters().get(
				"V_CURSOR");
	}

	/**
	 * 企业总数查询
	 * 
	 * @param queryFilter
	 *            检索条件
	 * @return 结果返回
	 */
	public Integer getCorpStatisticsCount(QueryFilter queryFilter) {
		return dao.getCorpStatisticsCount(queryFilter);
	}

	@Override
	public List<Map<String, Object>> getCorpStatisticsEcharts(
			QueryFilter queryFilter) {
		return dao.getCorpStatisticsEcharts(queryFilter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getPersonRegistStatistics(
			QueryFilter queryFilter) {
		dao.getListBySqlKey("getPersonRegistStatistics", queryFilter.getFilters());
		return (List<Map<String, Object>>) queryFilter.getFilters().get(
				"V_CURSOR");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getCorpDemandStatistics(
			QueryFilter queryFilter) {
		dao.getListBySqlKey("getCorpDemandStatistics", queryFilter.getFilters());
		return (List<Map<String, Object>>) queryFilter.getFilters().get(
				"P_CURSOR");
	}
}
