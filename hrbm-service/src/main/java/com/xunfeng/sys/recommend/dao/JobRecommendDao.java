package com.xunfeng.sys.recommend.dao;

import com.xunfeng.business.corp.dto.CorpRecommendResumeDto;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.recommend.model.JobRecommend;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 求职推荐匹配表 Dao类
* @author:wxl
* @createDate 2015-07-25 10:01:43 
* @version V1.0   
*/
@Repository
public class JobRecommendDao extends BaseDao<JobRecommend>
{
	@Override
	public Class<?> getEntityClass()
	{
		return JobRecommend.class;
	}

	/**
	 * 系统给企业推荐的简历
	 */
	public List<CorpRecommendResumeDto> getAllCorpRecommendResume(QueryFilter filter){
		return this.getListForm("getAllCorpRecommendResume",filter);
	}
}