package com.xunfeng.business.dissupport.jobmatch.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.dissupport.jobmatch.model.PersonJobRecommend;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 求职推荐匹配表 Dao类
* @author:wanghan
* @createDate 2016-08-15 20:00:42 
* @version V1.0   
*/
@Repository
public class PersonJobRecommendDao extends BaseDao<PersonJobRecommend>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonJobRecommend.class;
	}

}