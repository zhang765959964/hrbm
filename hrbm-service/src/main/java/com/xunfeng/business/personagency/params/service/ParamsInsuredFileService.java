package com.xunfeng.business.personagency.params.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.params.dao.ParamsInsuredFileDao;
import com.xunfeng.business.personagency.params.interf.ParamsInsuredFileServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsInsuredFile;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 参保文件 Service类
* @author:wanghan
* @createDate 2016-09-07 10:23:40 
* @version V1.0   
*/
@Service
public class ParamsInsuredFileService extends BaseService<ParamsInsuredFile> implements ParamsInsuredFileServiceInterf
{
	@Resource
	private ParamsInsuredFileDao dao;
	
	
	
	public ParamsInsuredFileService()
	{
	}
	
	@Override
	protected IEntityDao<ParamsInsuredFile, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ParamsInsuredFile> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ParamsInsuredFile> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
