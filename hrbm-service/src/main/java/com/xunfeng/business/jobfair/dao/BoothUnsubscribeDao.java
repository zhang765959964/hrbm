package com.xunfeng.business.jobfair.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.jobfair.model.BoothUnsubscribe;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位退订表 Dao类
* @author:wanghan
* @createDate 2016-04-26 10:44:30 
* @version V1.0   
*/
@Repository
public class BoothUnsubscribeDao extends BaseDao<BoothUnsubscribe>
{
	@Override
	public Class<?> getEntityClass()
	{
		return BoothUnsubscribe.class;
	}

}