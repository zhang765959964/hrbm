package com.xunfeng.business.dissupport.divice.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.dissupport.divice.model.DiviceModel;
import com.xunfeng.business.dissupport.divice.dao.DiviceModelDao;
import com.xunfeng.business.dissupport.divice.interf.DiviceModelServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 型号表 Service类
* @author:wanghan
* @createDate 2016-07-27 17:03:37 
* @version V1.0   
*/
@Service
public class DiviceModelService extends BaseService<DiviceModel> implements DiviceModelServiceInterf
{
	@Resource
	private DiviceModelDao dao;
	
	
	
	public DiviceModelService()
	{
	}
	
	@Override
	protected IEntityDao<DiviceModel, Long> getEntityDao() 
	{
		return dao;
	}
	
}
