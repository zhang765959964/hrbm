package com.xunfeng.business.personagency.params.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.params.dao.ParamsAgentCodeDao;
import com.xunfeng.business.personagency.params.interf.ParamsAgentCodeServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsAgentCode;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 劳动代理代码维护 Service类
* @author:wanghan
* @createDate 2016-09-07 10:24:17 
* @version V1.0   
*/
@Service
public class ParamsAgentCodeService extends BaseService<ParamsAgentCode> implements ParamsAgentCodeServiceInterf
{
	@Resource
	private ParamsAgentCodeDao dao;
	
	
	
	public ParamsAgentCodeService()
	{
	}
	
	@Override
	protected IEntityDao<ParamsAgentCode, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ParamsAgentCode> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ParamsAgentCode> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
