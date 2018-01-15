package com.xunfeng.business.link.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.link.dao.LinkDao;
import com.xunfeng.business.link.interf.LinkInterfaceService;
import com.xunfeng.business.link.model.Link;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
 *<pre>
 * 对象功能:网站友情链接表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-14 15:51:35
 *</pre>
 */
@Service
public class LinkService extends BaseService<Link> implements LinkInterfaceService
{
	@Resource
	private LinkDao dao;
	
	
	
	public LinkService()
	{
	}
	
	@Override
	protected IEntityDao<Link, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
