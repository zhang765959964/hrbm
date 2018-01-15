package com.xunfeng.sys.setMeal.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.setMeal.model.FeeUseDetail;
import com.xunfeng.sys.setMeal.dao.FeeUseDetailDao;
import com.xunfeng.sys.setMeal.interf.FeeUseDetailServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 消费使用流水表 Service类
* @author:
* @createDate 2016-07-19 09:22:45 
* @version V1.0   
*/
@Service
public class FeeUseDetailService extends BaseService<FeeUseDetail> implements FeeUseDetailServiceInterf
{
	@Resource
	private FeeUseDetailDao dao;
	
	
	
	public FeeUseDetailService()
	{
	}
	
	@Override
	protected IEntityDao<FeeUseDetail, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
