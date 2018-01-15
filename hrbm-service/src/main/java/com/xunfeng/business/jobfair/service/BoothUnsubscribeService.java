package com.xunfeng.business.jobfair.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.jobfair.dao.BoothUnsubscribeDao;
import com.xunfeng.business.jobfair.model.BoothUnsubscribe;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位退订表 Service类
* @author:wanghan
* @createDate 2016-04-26 10:44:30 
* @version V1.0   
*/
@Service
public class BoothUnsubscribeService extends BaseService<BoothUnsubscribe> 
{
	@Resource
	private BoothUnsubscribeDao dao;
	
	
	
	public BoothUnsubscribeService()
	{
	}
	
	@Override
	protected IEntityDao<BoothUnsubscribe, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
