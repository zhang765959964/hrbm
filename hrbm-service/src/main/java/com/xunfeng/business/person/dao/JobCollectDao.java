package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.JobCollect;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:个人职位收藏夹 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:28
 *</pre>
 */
@Repository
public class JobCollectDao extends BaseDao<JobCollect>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobCollect.class;
	}

}