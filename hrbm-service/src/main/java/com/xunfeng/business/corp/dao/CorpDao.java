package com.xunfeng.business.corp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:单位基本信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:51:36
 *</pre>
 */
@Repository
public class CorpDao extends BaseDao<Corp>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Corp.class;
	}
	//用户编号 ccmu01 获取企业的基本信息
	public Corp getCorpByAccountId(Long ccmu01){
		return this.getUnique("getByAccountId",ccmu01);
	}
	//企业获取推荐人才 传ccmu01
	public List<Map> getRecommendPerson(QueryFilter queryFilter){
        return this.getListForm("getRecommendPerson", queryFilter);
	}
	//企业获取推荐人才  没有参数
	public List<Map> getRecommendBlackPerson(QueryFilter queryFilter){
        return this.getListForm("getRecommendBlackPerson", queryFilter);
	}
	//获取推荐人才合并
	public List<Map> getRecommendPersonMerge(QueryFilter queryFilter){
        return this.getListForm("getRecommendPersonMerge", queryFilter);
	}
	
	/**
	 * 通过jobid获得企业详细信息
	 * @param queryFilter
	 * @return
	 */
	public List<Map> getCorpInfoByJobId(QueryFilter queryFilter){
		return this.getListForm("getCorpInfoByJobId", queryFilter);
	}
	/**
	 * 通过Corpid获得企业详细信息
	 * @param queryFilter
	 * @return
	 */
	public Map<String,Object> getCorpInfoByCorpId(Long aab001){
		return  (Map<String, Object>) this.getOne("getCorpInfoByCorpId", aab001);
	}
	/**
	 * 通过jobid获得企业详细信息
	 * @param queryFilter
	 * @return
	 */
	public String getCorpDescByCorpId(Long aab001){
		return  (String) this.getOne("getCorpDescByCorpId", aab001);
	}
	/**
	 * 根据企业名称获得公司信息
	 * 2016-05-05
	 */
	public Corp getCorpByCorpName(String corpName){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab004", corpName);
		List<Corp> listCorp = this.getBySqlKey("getCorpByCorpNameOrBusCard", map);
		if(listCorp!=null && listCorp.size()>0){
			return listCorp.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 根据企业获得公司信息
	 * 2016-05-05
	 */
	public Corp getCorpByBusCardNum(String cardNum){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab007", cardNum);
		List<Corp> listCorp = this.getBySqlKey("getCorpByCorpNameOrBusCard", map);
		if(listCorp!=null && listCorp.size()>0){
			return listCorp.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 查询企业统计数据 
	 * @param queryFilter 检索条件
	 * @return 企业统计数据返回
	 */
	public ResultData<Map<String, Object>> getCorpStatistics(
			QueryFilter queryFilter) {
    	@SuppressWarnings("unchecked")
		List<Map<String, Object>> maps = getListForm("getCorpStatistics", queryFilter);
    	ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(maps);
    	return resultData;
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
	public List<Map<String, Object>> getCorpStatisticsEcharts(
			QueryFilter queryFilter) {
		return getListBySqlKey("getCorpStatisticsEcharts", queryFilter.getFilters());
	}
	public Map getCorpUnitAgreement(Long aab001){
		Map params=new HashMap();
		params.put("aab001", aab001);
		return (Map)this.getOne("getCorpUnitAgreement", params);
	}
}