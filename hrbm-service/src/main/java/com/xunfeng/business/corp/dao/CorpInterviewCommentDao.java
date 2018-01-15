package com.xunfeng.business.corp.dao;

import com.xunfeng.business.corp.model.CorpInterviewComment;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 *<pre>
 * 对象功能:面试评语表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wxl
 * 创建时间:2015-07-23 15:46:14
 *</pre>
 */
@Repository
public class CorpInterviewCommentDao extends BaseDao<CorpInterviewComment>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpInterviewComment.class;
	}

	/**
	 * 改变面试评语的删除状态
	 * // 是否删除 0:否 1:是 acp001
	 protected String  ccpr08;
	 */
	public void updateCommentStatus(Long acp001,String ccpr08){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("ccpr08",ccpr08);
		params.put("acp001",acp001);
		this.update("updateCommentStatus",params);
	}

}