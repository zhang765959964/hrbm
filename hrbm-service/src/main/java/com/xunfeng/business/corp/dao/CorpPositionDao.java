package com.xunfeng.business.corp.dao;

import com.xunfeng.business.corp.dto.CorpPositionDto;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 招聘空位信息表 Dao类
* @author:wxl
* @createDate 2015-07-24 11:31:13 
* @version V1.0   
*/
@Repository
public class CorpPositionDao extends BaseDao<CorpPosition>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpPosition.class;
	}

	//冻结职位
	public void freezeCorpPosition(Long corpPositionId,String operatorName,Date freezeDate,String freezeReason){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("corpPositionId",corpPositionId);
		params.put("freezeStatus",1L);
		params.put("freezeDate",freezeDate);
		params.put("operatorName",operatorName);
		params.put("freezeReason",freezeReason);
		this.update("freezeCorpPosition",params);
	}
	
	//删除职位
	public void deleteCorpPosition(Long corpPositionId,String lastModifyUserName,Date lastModifyDate,String modifySource){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("corpPositionId",corpPositionId);
		params.put("deleteStatus",1L);
		params.put("lastModifyUserName",lastModifyUserName);
		params.put("lastModifyDate",lastModifyDate);
		params.put("modifySource",modifySource);
		this.update("deleteCorpPosition",params);
	}
	
	/**
	 * 解冻职位   根据职位的ID
	 */
	public void unfreezeCorpPosition(Long corpPositionId){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("corpPositionId",corpPositionId);
		params.put("freezeStatus",0L);
		this.update("unfreezeCorpPosition",params);
	}

	/**
	 * 通过视图获取所有的职位
	 */
	public ResultData<CorpPositionDto> getAllCorpPositionDto(QueryFilter filter){
		ResultData<CorpPositionDto> resultData = new ResultData<CorpPositionDto>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(this.getListForm("getAllCorpPositionDto",filter));
		return resultData;
	}
	//企业获取最新职位信息
	public List<CorpPositionDto> getAllNewCorpPositionDto(QueryFilter filter){
		return this.getListForm("getAllNewCorpPositionDto", filter);
	}
	/**
	 * 获取公司发布的职位
	 */
	public List<CorpPositionDto> getCorpPositionByCorpId(Long aab001){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("aab001",aab001);
		return this.getListBySqlKey("getAllCorpPositionDto",params);
	}
	//根据公司ID获取公司发布的有效委托职位（）
	public List<CorpPositionDto> getEffectivePositionByCorpId(Long aab001){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("aab001",aab001);
		return this.getListBySqlKey("getEffectivePositionByCorpId",params);
	}
	/**
	 * 获得职位详情
	 * 2016-04-13
	 * @param queryFilter
	 * @return
	 */
	public Map<String,Object> getJobDetail(Long acb210){
		return (Map<String, Object>) this.getOne("jobDetail",  acb210);
	}
	/**
	 * 获取公司发布的职位
	 * 2016-04-13
	 * @param queryFilter
	 * @return
	 */
	public List<Map> getCurrentJob(QueryFilter queryFilter){
		queryFilter.addFilter("isFairJob", 0);
		return this.getListForm("getCurrentJob", queryFilter);
	}
	/**
	 * 获取公司现场发布的职位 所有未冻结的
	 * 2016-06-15
	 * @param queryFilter
	 * @return
	 */
	public List<Map> getCurrentFairJob(QueryFilter queryFilter){
		queryFilter.addFilter("isFairJob", 1);
		return this.getListForm("getCurrentJob", queryFilter);
	}
	
	
	/**
	 * 获得职位下的工作福利
	 * @return
	 */
	public List<Map<String,Object>> getWelfareByCode(String acc214){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		if(acc214 !=null && !acc214.equals("")&& !acc214.equals("null")){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("acc214", acc214);
			list = this.getListBySqlKey("getWelfareByCode", map);
	     }
		return list;
	}

	/**
	 * @param acb200
	 * @param acb210
	 * @param acb201
	 * @return
	 */
	public int getPostionCount(Long acb200, Long acb210, Long aab001,String code) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("acb200", acb200);
		params.put("acb210", acb210);
		params.put("aab001", aab001);
		params.put("code", code);
		return (Integer)this.getOne("getPostionCount", params);
	}
}