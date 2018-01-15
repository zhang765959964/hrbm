package com.xunfeng.business.cms.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.core.db.BaseDao;
/**
 *<pre>
 * 对象功能:新闻类别表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:15
 *</pre>
 */
@Repository
public class ArticleColumnDao extends BaseDao<ArticleColumn>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ArticleColumn.class;
	}

}