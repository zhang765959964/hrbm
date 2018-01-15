package com.xunfeng.business.person.interf;

import java.util.Map;

import com.xunfeng.business.person.model.JobAuditionInvited;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:面试邀请表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:48
 *</pre>
 */
public interface JobAuditionInvitedServiceInterf extends GenericServiceInterface<JobAuditionInvited,Long>
{


	/**
	 * 获取企业发起的面试邀请
	 */
	public ResultData<Map> getAllCorpInviteDto(QueryFilter filter);
	/**
	 * 获取企业发起的面试邀请总记录数
	 */
	public Long getTotalInterviewsRecord(Long aac001);
	/**
	 * 修改用户时候接受或者拒接邀请
	 * 201-04-07
	 */
	public void updateJobAuditionInvited(Map map);
	/**
	 * 获得现场面试记录
	 * 2016-04-08
	 */
	public ResultData<Map> getInterviewsRecord(QueryFilter filter);
//	/**
//	 *企业招聘会面试记录
//	 */
//	public List<PersonInvitedDto> getCorpInterviewLog(QueryFilter filter);
	
	//企业中心-》简历管理-（邀请面试记录 jx 2016.04.27）
	public ResultData<Map> getCorpInviteRecord(QueryFilter filter);
	//企业中心-》简历管理-（招聘会面试记录 jx 2016.04.27）
	public ResultData<Map> getCorpFairRecord(QueryFilter filter);
}
