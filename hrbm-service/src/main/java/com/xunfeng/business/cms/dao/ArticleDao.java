package com.xunfeng.business.cms.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.cms.model.Article;
import com.xunfeng.core.db.BaseDao;
/**
 *<pre>
 * 对象功能:新闻内容表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:39
 *</pre>
 */
@Repository
public class ArticleDao extends BaseDao<Article>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Article.class;
	}

}