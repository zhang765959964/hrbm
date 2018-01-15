package com.xunfeng.business.person.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.person.dto.PersonInvitedDto;
import com.xunfeng.business.person.model.JobAuditionInvited;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:面试邀请表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:48
 *</pre>
 */
@Repository
public class JobAuditionInvitedDao extends BaseDao<JobAuditionInvited>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobAuditionInvited.class;
	}

	/**
	 * 获取企业发起的面试邀请
	 * 2016-04-07
	 */
	public List<Map> getAllCorpInviteDto(QueryFilter filter){
		return this.getListForm("getAllCorpInviteDto",filter);
	} 
	/**
	 * 获取企业发起的面试邀请总记录数
	 */
	public Long getTotalInterviewsRecord(Long aac001){
		return (Long) this.getOne("getTotalInterviewsRecord", aac001);
	}
	/**
	 * 修改面试接受或者拒接的状态
	 * 2016-04-07
	 */
	public void updateJobAuditionInvited(Map map){
		this.update("updateJobAuditionInvited", map);
	} 
	/**
	 * 获得现场面试记录
	 * 2016-04-08
	 */
	public List<Map> getInterviewsRecord(QueryFilter filter){
		return this.getListForm("getInterviewsRecord",filter);
	} 

	/**
	 *企业招聘会面试记录
	 */
	public List<PersonInvitedDto> getCorpInterviewLog(QueryFilter filter){
		return this.getListForm("getCorpInterviewLog",filter);
	}


}