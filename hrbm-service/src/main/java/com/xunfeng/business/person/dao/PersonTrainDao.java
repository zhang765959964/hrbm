package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.PersonTrain;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:培训经历表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:00:23
 *</pre>
 */
@Repository
public class PersonTrainDao extends BaseDao<PersonTrain>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonTrain.class;
	}

}