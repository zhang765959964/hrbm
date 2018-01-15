package com.xunfeng.business.personagency.print.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.print.dao.PrintTemplateDao;
import com.xunfeng.business.personagency.print.interf.PrintTemplateServiceInterf;
import com.xunfeng.business.personagency.print.model.PrintTemplate;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL Service类
* @author:wanghan
* @createDate 2016-10-20 15:19:40 
* @version V1.0   
*/
@Service
public class PrintTemplateService extends BaseService<PrintTemplate> implements PrintTemplateServiceInterf
{
	@Resource
	private PrintTemplateDao dao;
	
	
	
	public PrintTemplateService()
	{
	}
	
	@Override
	protected IEntityDao<PrintTemplate, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<PrintTemplate> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PrintTemplate> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public PrintTemplate getTemplateByAlias(String alias){
		
		Map params=new HashMap();
		params.put("fdModelAlias", alias);
		return dao.getUnique("getAll", params);
		
		
	}
}
