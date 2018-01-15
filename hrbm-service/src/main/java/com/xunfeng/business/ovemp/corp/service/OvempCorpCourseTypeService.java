package com.xunfeng.business.ovemp.corp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.ovemp.corp.dao.OvempCorpCourseTypeDao;
import com.xunfeng.business.ovemp.corp.interf.OvempCorpCourseTypeServiceInterf;
import com.xunfeng.business.ovemp.corp.model.OvempCorpCourseType;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班类型表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:29:51 
* @version V1.0   
*/
@Service
public class OvempCorpCourseTypeService extends BaseService<OvempCorpCourseType> implements OvempCorpCourseTypeServiceInterf
{
	@Resource
	private OvempCorpCourseTypeDao dao;
	
	
	
	public OvempCorpCourseTypeService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCorpCourseType, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public ResultData<OvempCorpCourseType> getAllTrainCourseType(QueryFilter fiter) {
		
		ResultData<OvempCorpCourseType> resultData=new ResultData<OvempCorpCourseType>();
		List<OvempCorpCourseType> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public int updateBatchDel(Map<String, Object> map) {
		
		return dao.update("updateBatchDel", map);
	}

	@Override
	public Integer getCountByPId(Long typeId) {
		
		return (Integer) dao.getOne("getCountByPId", typeId);
	}

	@Override
	public OvempCorpCourseType getCourseTypeByName(String courseTypeName) {
		
		return dao.getUnique("getCourseTypeByName", courseTypeName);
	}
	
	
}
