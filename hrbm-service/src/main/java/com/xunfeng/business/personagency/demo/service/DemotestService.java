package com.xunfeng.business.personagency.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.demo.dao.DemotestDao;
import com.xunfeng.business.personagency.demo.interf.DemotestServiceInterf;
import com.xunfeng.business.personagency.demo.model.Demotest;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_DEMO Service类
* @author:zhangfan
* @createDate 2016-07-28 10:46:20 
* @version V1.0   
*/
@Service
public class DemotestService extends BaseService<Demotest> implements DemotestServiceInterf
{
	@Resource
	private DemotestDao dao;
	
	
	
	public DemotestService()
	{
	}
	
	@Override
	protected IEntityDao<Demotest, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<Demotest> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Demotest> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
