package com.xunfeng.business.person.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.PinyinUtil;
import com.xunfeng.core.web.query.QueryFilter;

import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:个人基本信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 *</pre>
 */
@Repository
public class PersonBaseInfoDao extends BaseDao<PersonBaseInfo>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonBaseInfo.class;
	}

	@Override
	public void add(PersonBaseInfo entity) {
		String pinyin=PinyinUtil.getPinyin(entity.getAac003());
		entity.setAac022(pinyin);
		super.add(entity);
	}

	public PersonBaseInfo getByIdcardAndRealName(String idCard) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("idCard", idCard);
		return this.getUnique("getByIdcardAndRealName",params);
	}
	
	/*public void addPersonBaseInfo(Long idLong, String idCard, String realName, String telephone, String gender){
		PersonBaseInfo personBaseInfo = new PersonBaseInfo();
		personBaseInfo.setAac001(idLong);
		personBaseInfo.setAac002(idCard);
		personBaseInfo.setAac003(realName);
		personBaseInfo.setAae005(telephone);
		personBaseInfo.setAac004(gender);
		this.add(personBaseInfo);
	}*/
	 /**
     * 个人统计信息查询
     * @param queryFilter 检索条件
     * @return 结果返回
     */
    public ResultData<Map<String, Object>> getPersonStatistics(QueryFilter queryFilter){
    	@SuppressWarnings("unchecked")
		List<Map<String, Object>> maps = getListForm("getPersonStatistics", queryFilter);
    	ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(maps);
    	return resultData;
    }
    
    /**
     * 个人统计信息查询
     * @param queryFilter 检索条件
     * @return 结果返回
     */
    public Integer getPersonStatisticsCount(QueryFilter queryFilter){
        @SuppressWarnings("unchecked")
		Map<String, Object> results = (Map<String, Object>) getOne("getPersonStatisticsCount", queryFilter.getFilters());
    	return  Integer.valueOf(results.get("TOTALNUM").toString());
    }

	/**
	 * 报表数据获取
	 * @param queryFilter 检索条件
	 * @return 返回结果
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getPersonStatisticsEcharts(QueryFilter queryFilter) {
		return getListBySqlKey("getPersonStatisticsEcharts", queryFilter.getFilters());
	}
	public Map getReceivePersonByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getReceivePersonByPersonId", params);
	}
}