package com.xunfeng.sys.setMeal.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.setMeal.model.FeeUseDetail;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 消费使用流水表 Dao类
* @author:
* @createDate 2016-07-19 09:22:45 
* @version V1.0   
*/
@Repository
public class FeeUseDetailDao extends BaseDao<FeeUseDetail>
{
	@Override
	public Class<?> getEntityClass()
	{
		return FeeUseDetail.class;
	}

}