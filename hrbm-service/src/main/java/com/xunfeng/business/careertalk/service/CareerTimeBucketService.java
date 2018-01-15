package com.xunfeng.business.careertalk.service;

import com.xunfeng.business.careertalk.dao.CareerTimeBucketDao;
import com.xunfeng.business.careertalk.model.CareerTimeBucket;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会教师时间段划分表 Service类
* @author:zhouhang
* @createDate 2015-09-21 09:49:15 
* @version V1.0   
*/
@Service
public class CareerTimeBucketService extends BaseService<CareerTimeBucket>
{
	@Resource
	private CareerTimeBucketDao dao;
	
	
	
	public CareerTimeBucketService()
	{
	}
	
	@Override
	protected IEntityDao<CareerTimeBucket, Long> getEntityDao() 
	{
		return dao;
	}

}
