package com.xunfeng.business.train.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.train.dao.TrainOrgTypeDao;
import com.xunfeng.business.train.interf.TrainOrgTypeServiceInterf;
import com.xunfeng.business.train.model.TrainOrgType;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构类型表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:02 
* @version V1.0   
*/
@Service
public class TrainOrgTypeService extends BaseService<TrainOrgType> implements TrainOrgTypeServiceInterf
{
	@Resource
	private TrainOrgTypeDao dao;
	
	
	
	public TrainOrgTypeService()
	{
	}
	
	@Override
	protected IEntityDao<TrainOrgType, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public List<TrainOrgType> getAllTrainOrgType() {
		
		return dao.getBySqlKey("getAll");
	}

	@Override
	public ResultData<TrainOrgType> getTrainOrgTypeData(QueryFilter fiter) {
		
		ResultData<TrainOrgType> resultData=new ResultData<TrainOrgType>();
		List<TrainOrgType> dataList =dao.getAll(fiter);
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
	public TrainOrgType getOrgTypeByName(String orgTypeName) {
		
		return dao.getUnique("getOrgTypeByName", orgTypeName);
	}

	@Override
	public List<TrainOrgType> getSubTypeById(Long typeId) {
		
		return dao.getBySqlKey("getSubTypeById", typeId);
	}
		
}
