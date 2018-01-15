package com.xunfeng.business.personagency.params.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.params.dao.ParamsDiffCorpDao;
import com.xunfeng.business.personagency.params.interf.ParamsDiffCorpServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsDiffCorp;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 困难企业 Service类
* @author:wanghan
* @createDate 2016-09-07 10:22:54 
* @version V1.0   
*/
@Service
public class ParamsDiffCorpService extends BaseService<ParamsDiffCorp> implements ParamsDiffCorpServiceInterf
{
	@Resource
	private ParamsDiffCorpDao dao;
	
	
	
	public ParamsDiffCorpService()
	{
	}
	
	@Override
	protected IEntityDao<ParamsDiffCorp, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ParamsDiffCorp> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ParamsDiffCorp> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
