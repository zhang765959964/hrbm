package com.xunfeng.business.personagency.params.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.params.dao.ParamsMonthBaseDao;
import com.xunfeng.business.personagency.params.interf.ParamsMonthBaseServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsMonthBase;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 月缴费基数 Service类
* @author:wanghan
* @createDate 2016-09-07 09:23:00 
* @version V1.0   
*/
@Service
public class ParamsMonthBaseService extends BaseService<ParamsMonthBase> implements ParamsMonthBaseServiceInterf
{
	@Resource
	private ParamsMonthBaseDao dao;
	
	
	
	public ParamsMonthBaseService()
	{
	}
	
	@Override
	protected IEntityDao<ParamsMonthBase, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ParamsMonthBase> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ParamsMonthBase> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
