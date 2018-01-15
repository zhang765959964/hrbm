package com.xunfeng.business.corp.dao;

import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/**
 *<pre>
 * 对象功能:单位招聘信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-22 17:34:19
 *</pre>
 */
@Repository
public class CorpPositionPublishDao extends BaseDao<CorpPositionPublish>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpPositionPublish.class;
	}

}