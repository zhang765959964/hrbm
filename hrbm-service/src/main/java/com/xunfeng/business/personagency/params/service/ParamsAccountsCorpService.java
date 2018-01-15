package com.xunfeng.business.personagency.params.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.params.dao.ParamsAccountsCorpDao;
import com.xunfeng.business.personagency.params.interf.ParamsAccountsCorpServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsAccountsCorp;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 账号与市场关联维护 Service类
* @author:wanghan
* @createDate 2016-09-07 10:24:43 
* @version V1.0   
*/
@Service
public class ParamsAccountsCorpService extends BaseService<ParamsAccountsCorp> implements ParamsAccountsCorpServiceInterf
{
	@Resource
	private ParamsAccountsCorpDao dao;
	
	
	
	public ParamsAccountsCorpService()
	{
	}
	
	@Override
	protected IEntityDao<ParamsAccountsCorp, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ParamsAccountsCorp> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ParamsAccountsCorp> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public ResultData getParamsList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<ParamsAccountsCorp> dataList=dao.getBySqlKey("getParamsList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
}
