package com.xunfeng.business.person.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.JobAuditionInvitedDao;
import com.xunfeng.business.person.dto.PersonInvitedDto;
import com.xunfeng.business.person.interf.JobApplyServiceInterf;
import com.xunfeng.business.person.interf.JobAuditionInvitedServiceInterf;
import com.xunfeng.business.person.model.JobAuditionInvited;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:面试邀请表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:48
 *</pre>
 */
@Service
public class JobAuditionInvitedService extends BaseService<JobAuditionInvited>  implements JobAuditionInvitedServiceInterf  
{
	@Resource
	private JobAuditionInvitedDao dao;
	
	
	
	public JobAuditionInvitedService()
	{
	}
	
	@Override
	protected IEntityDao<JobAuditionInvited, Long> getEntityDao()
	{
		return dao;
	}


	/**
	 * 获取企业发起的面试邀请(面试邀请)
	 * 201-04-07
	 */
	public ResultData<Map> getAllCorpInviteDto(QueryFilter filter){
		ResultData<Map> resultData =new ResultData<Map>();
		resultData.setDataList(dao.getAllCorpInviteDto(filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	}
	/**
	 * 获得现场面试记录
	 * 2016-04-08
	 */
	public ResultData<Map> getInterviewsRecord(QueryFilter filter){
		ResultData<Map> resultData =new ResultData<Map>();
		resultData.setDataList(dao.getInterviewsRecord(filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	} 
	/**
	 * 获取企业发起的面试邀请总记录数
	 */
	public Long getTotalInterviewsRecord(Long aac001){
		return dao.getTotalInterviewsRecord(aac001);
	}
	/**
	 * 修改用户时候接受或者拒接邀请
	 * 201-04-07
	 */
	public void updateJobAuditionInvited(Map map){
		dao.updateJobAuditionInvited(map);
		
	}
	/**
	 *企业招聘会面试记录
	 */
	public List<PersonInvitedDto> getCorpInterviewLog(QueryFilter filter){
		return dao.getCorpInterviewLog(filter);
	}
	//企业中心-》简历管理-（邀请面试记录 jx 2016.04.27）
	public ResultData<Map> getCorpInviteRecord(QueryFilter filter){
		ResultData<Map> resultData =new ResultData<Map>();
		resultData.setDataList(dao.getListForm("getCorpInviteRecord", filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	}
	//企业中心-》简历管理-（招聘会面试记录 jx 2016.04.27）
	public ResultData<Map> getCorpFairRecord(QueryFilter filter){
		ResultData<Map> resultData =new ResultData<Map>();
		resultData.setDataList(dao.getListForm("getCorpFairRecord", filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	}
}
