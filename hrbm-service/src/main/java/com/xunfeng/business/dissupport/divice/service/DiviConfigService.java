package com.xunfeng.business.dissupport.divice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.dissupport.divice.model.DiviConfig;
import com.xunfeng.business.dissupport.divice.dao.DiviConfigDao;
import com.xunfeng.business.dissupport.divice.interf.DiviConfigServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备配置表 Service类
* @author:wanghan
* @createDate 2016-07-28 15:30:48 
* @version V1.0   
*/
@Service
public class DiviConfigService extends BaseService<DiviConfig> implements DiviConfigServiceInterf
{
	@Resource
	private DiviConfigDao dao;
	
	
	
	public DiviConfigService()
	{
	}
	
	@Override
	protected IEntityDao<DiviConfig, Long> getEntityDao() 
	{
		return dao;
	}
	
	@Override
	public ResultData<Map<String, Object>> getViewList(
			QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> dataList=(List<Map<String, Object>>)dao.getListForm("getViewList",queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	@Override
	public ResultData<Map<String, Object>> getPostionViewList(
			QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> dataList=(List<Map<String, Object>>)dao.getListForm("getPostionViewList",queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
}
