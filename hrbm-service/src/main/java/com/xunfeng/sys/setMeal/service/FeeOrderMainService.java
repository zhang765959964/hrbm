package com.xunfeng.sys.setMeal.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.setMeal.model.FeeOrderMain;
import com.xunfeng.sys.setMeal.dao.FeeOrderMainDao;
import com.xunfeng.sys.setMeal.interf.FeeOrderMainServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购主表 Service类
* @author:
* @createDate 2016-07-19 09:18:37 
* @version V1.0   
*/
@Service
public class FeeOrderMainService extends BaseService<FeeOrderMain> implements FeeOrderMainServiceInterf
{
	@Resource
	private FeeOrderMainDao dao;
	
	
	
	public FeeOrderMainService()
	{
	}
	
	@Override
	protected IEntityDao<FeeOrderMain, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
