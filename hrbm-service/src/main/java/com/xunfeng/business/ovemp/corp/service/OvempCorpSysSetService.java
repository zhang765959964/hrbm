package com.xunfeng.business.ovemp.corp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.ovemp.corp.dao.OvempCorpSysSetDao;
import com.xunfeng.business.ovemp.corp.interf.OvempCorpSysSetServiceInterf;
import com.xunfeng.business.ovemp.corp.model.OvempCorpSysSet;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训系统设置表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:57 
* @version V1.0   
*/
@Service
public class OvempCorpSysSetService extends BaseService<OvempCorpSysSet> implements OvempCorpSysSetServiceInterf
{
	@Resource
	private OvempCorpSysSetDao dao;
	
	
	
	public OvempCorpSysSetService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCorpSysSet, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public ResultData<OvempCorpSysSet> getAllTrainSysSet(QueryFilter fiter) {
		
		ResultData<OvempCorpSysSet> resultData=new ResultData<OvempCorpSysSet>();
		List<OvempCorpSysSet> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	
}
