package com.xunfeng.sys.setMeal.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.setMeal.model.FeeOrderMain;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购主表 Dao类
* @author:
* @createDate 2016-07-19 09:18:37 
* @version V1.0   
*/
@Repository
public class FeeOrderMainDao extends BaseDao<FeeOrderMain>
{
	@Override
	public Class<?> getEntityClass()
	{
		return FeeOrderMain.class;
	}

}