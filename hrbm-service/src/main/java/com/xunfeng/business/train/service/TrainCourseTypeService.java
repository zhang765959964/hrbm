package com.xunfeng.business.train.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.train.dao.TrainCourseTypeDao;
import com.xunfeng.business.train.interf.TrainCourseTypeServiceInterf;
import com.xunfeng.business.train.model.TrainCourseType;
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
public class TrainCourseTypeService extends BaseService<TrainCourseType> implements TrainCourseTypeServiceInterf
{
	@Resource
	private TrainCourseTypeDao dao;
	
	
	
	public TrainCourseTypeService()
	{
	}
	
	@Override
	protected IEntityDao<TrainCourseType, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public ResultData<TrainCourseType> getAllTrainCourseType(QueryFilter fiter) {
		
		ResultData<TrainCourseType> resultData=new ResultData<TrainCourseType>();
		List<TrainCourseType> dataList =dao.getAll(fiter);
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
	public TrainCourseType getCourseTypeByName(String courseTypeName) {
		
		return dao.getUnique("getCourseTypeByName", courseTypeName);
	}

	@Override
	public List<TrainCourseType> getSubTypeById(Long typeId) {
		
		return dao.getBySqlKey("getSubTypeById", typeId);
	}
	
	
}
