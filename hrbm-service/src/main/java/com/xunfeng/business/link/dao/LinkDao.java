package com.xunfeng.business.link.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.link.model.Link;
/**
 *<pre>
 * 对象功能:网站友情链接表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-14 15:51:35
 *</pre>
 */
@Repository
public class LinkDao extends BaseDao<Link>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Link.class;
	}

}