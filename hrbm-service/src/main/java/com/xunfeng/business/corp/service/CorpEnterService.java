package com.xunfeng.business.corp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.CorpEnterDao;
import com.xunfeng.business.corp.model.CorpEnter;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位进场招聘表 Service类
* @author:wanghan
* @createDate 2016-04-14 09:11:39 
* @version V1.0   
*/
@Service
public class CorpEnterService extends BaseService<CorpEnter> 
{
	@Resource
	private CorpEnterDao dao;
	
	
	
	public CorpEnterService()
	{
	}
	
	@Override
	protected IEntityDao<CorpEnter, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
