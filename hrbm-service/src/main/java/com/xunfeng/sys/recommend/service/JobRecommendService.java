package com.xunfeng.sys.recommend.service;

import com.xunfeng.business.corp.dto.CorpRecommendResumeDto;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.recommend.dao.JobRecommendDao;
import com.xunfeng.sys.recommend.model.JobRecommend;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 求职推荐匹配表 Service类
* @author:wxl
* @createDate 2015-07-25 10:01:43 
* @version V1.0   
*/
@Service
public class JobRecommendService extends BaseService<JobRecommend>
{
	@Resource
	private JobRecommendDao dao;
	
	
	
	public JobRecommendService()
	{
	}
	
	@Override
	protected IEntityDao<JobRecommend, Long> getEntityDao() 
	{
		return dao;
	}

	 public List<JobRecommend> getJobRecommendList(Long aac001) {
		 Map pram=new HashMap();
		 pram.put("aac001",aac001);
         return dao.getBySqlKey("getAll",pram);
	}


	/**
	 * 系统给企业推荐的简历
	 */
	public List<CorpRecommendResumeDto> getAllCorpRecommendResume(QueryFilter filter){
		return dao.getAllCorpRecommendResume(filter);
	}
	//验证当前是不是已经发送过面试邀请  aac001  aab001 acb210
	public JobRecommend getJobRecommendByZhuJian(Long aac001,Long aab001,Long acb210){
		Map params=new HashMap();
		params.put("aac001",aac001);
		params.put("aab001",aab001);
		params.put("acb210",acb210);
		params.put("ccpr08",0);
		return dao.getUnique("getAll", params);
	}
	
	public Long getTotalCount(){
		return (Long)dao.getOne("getTotalCount", null);
	}
	
	
}
