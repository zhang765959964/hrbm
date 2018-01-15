package com.xunfeng.business.ovemp.corp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.ovemp.corp.dao.OvempCorpTypeDao;
import com.xunfeng.business.ovemp.corp.interf.OvempCorpTypeServiceInterf;
import com.xunfeng.business.ovemp.corp.model.OvempCorpType;
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
public class OvempCorpTypeService extends BaseService<OvempCorpType> implements OvempCorpTypeServiceInterf
{
	@Resource
	private OvempCorpTypeDao dao;
	
	
	
	public OvempCorpTypeService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCorpType, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public List<OvempCorpType> getAllTrainOrgType() {
		
		return dao.getBySqlKey("getAll");
	}

	@Override
	public ResultData<OvempCorpType> getTrainOrgTypeData(QueryFilter fiter) {
		
		ResultData<OvempCorpType> resultData=new ResultData<OvempCorpType>();
		List<OvempCorpType> dataList =dao.getAll(fiter);
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
	public OvempCorpType getOrgTypeByName(String orgTypeName) {
		
		return dao.getUnique("getOrgTypeByName", orgTypeName);
	}
	
	
}
