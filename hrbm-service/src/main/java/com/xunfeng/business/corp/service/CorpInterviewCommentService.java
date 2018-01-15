package com.xunfeng.business.corp.service;

import com.xunfeng.business.corp.dao.CorpInterviewCommentDao;
import com.xunfeng.business.corp.model.CorpInterviewComment;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *<pre>
 * 对象功能:面试评语表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wxl
 * 创建时间:2015-07-23 15:46:14
 *</pre>
 */
@Service
public class CorpInterviewCommentService extends BaseService<CorpInterviewComment>
{
	@Resource
	private CorpInterviewCommentDao dao;
	
	
	
	public CorpInterviewCommentService()
	{
	}
	
	@Override
	protected IEntityDao<CorpInterviewComment, Long> getEntityDao()
	{
		return dao;
	}
	//使用的是逻辑删除 0:否 1:是
	public void delCommentByIds(Long[] ids){
		for(Long id:ids){
			dao.updateCommentStatus(id,"1");
		}
	}
}
