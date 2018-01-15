package com.xunfeng.business.ovemp.corp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.ovemp.corp.model.OvempCorpCourse;
import com.xunfeng.business.ovemp.corp.model.OvempCorpSignUp;
import com.xunfeng.business.ovemp.corp.dao.OvempCorpSignUpDao;
import com.xunfeng.business.ovemp.corp.interf.OvempCorpSignUpServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训报名表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:31 
* @version V1.0   
*/
@Service
public class OvempCorpSignUpService extends BaseService<OvempCorpSignUp> implements OvempCorpSignUpServiceInterf
{
	@Resource
	private OvempCorpSignUpDao dao;
	
	
	
	public OvempCorpSignUpService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCorpSignUp, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public Map getCountByCourseId(Long id) {
		List<Map> dataList = (List<Map>)dao.getListBySqlKey("getCountByCourseId",id);
		return dataList.get(0);
	}

	@Override
	public Map getCountByUserId(Long userId,Long courseId) {
		Map params = new HashMap();
		params.put("userId",userId);
		params.put("courseId",courseId);
		List<Map> dataList = (List<Map>)dao.getListBySqlKey("getCountByUserId",params);
		return dataList.get(0);
	}

	@Override
	public List<Object> getTrainSignUpList(Map<String, Object> paramMap) {
		List<Object> dataList=dao.getListBySqlKey("getAllTrainSignUp", paramMap);
		
		return dataList;
	}

	@Override
	public ResultData<OvempCorpSignUp> getAllTrainSignUpData(QueryFilter fiter) {
		
		ResultData<OvempCorpSignUp> resultData=new ResultData<OvempCorpSignUp>();
		List<OvempCorpSignUp> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public List<Map<String, Object>> getAllDataSourses() {
		
		return dao.getListBySqlKey("getALLDataSourses", null);
	}

	@Override
	public int updateBatchTrainSignUp(Map<String, Object> paramMap) {
		
		return dao.update("updateBatchTrainSignUp", paramMap);
	}

	@Override
	public int updateIsCheck() {
		
		return dao.update("updateIsCheck", null);
	}

	@Override
	public int updateIsContact() {
		
		return dao.update("updateIsContact", null);
	}
	
}
