package com.xunfeng.business.personagency.demo.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.demo.model.Demotest;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_DEMO Dao类
* @author:zhangfan
* @createDate 2016-07-28 10:46:20 
* @version V1.0   
*/
@Repository
public class DemotestDao extends BaseDao<Demotest>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Demotest.class;
	}

}