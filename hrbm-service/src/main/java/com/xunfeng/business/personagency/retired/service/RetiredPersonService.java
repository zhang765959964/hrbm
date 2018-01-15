package com.xunfeng.business.personagency.retired.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.retired.model.RetiredPerson;
import com.xunfeng.business.personagency.retired.dao.RetiredPersonDao;
import com.xunfeng.business.personagency.retired.interf.RetiredPersonServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_RETIRED_PERSON Service类
* @author:zhangfan
* @createDate 2016-08-02 17:12:13 
* @version V1.0   
*/
@Service
public class RetiredPersonService extends BaseService<RetiredPerson> implements RetiredPersonServiceInterf
{
	@Resource
	private RetiredPersonDao dao;
	
	
	
	public RetiredPersonService()
	{
	}
	
	@Override
	protected IEntityDao<RetiredPerson, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData getAllByFilter(QueryFilter fiter){
		ResultData<RetiredPerson> resultData=new ResultData();
		List<RetiredPerson> dataList=dao.getBySqlKey("getRetiredPersonList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}


	
	
	
	
}
