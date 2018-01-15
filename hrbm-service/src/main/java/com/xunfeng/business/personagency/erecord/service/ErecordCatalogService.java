package com.xunfeng.business.personagency.erecord.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.erecord.dao.ErecordCatalogDao;
import com.xunfeng.business.personagency.erecord.interf.ErecordCatalogServiceInterf;
import com.xunfeng.business.personagency.erecord.model.ErecordCatalog;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案目录 Service类
* @author:wanghan
* @createDate 2015-08-10 15:00:46 
* @version V1.0   
*/
@Service
public class ErecordCatalogService extends BaseService<ErecordCatalog> implements ErecordCatalogServiceInterf
{
	@Resource
	private ErecordCatalogDao dao;
	
	
	
	public ErecordCatalogService()
	{
	}
	
	@Override
	protected IEntityDao<ErecordCatalog, Long> getEntityDao() 
	{
		return dao;
	}
	
	public ResultData<ErecordCatalog> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ErecordCatalog> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
}
