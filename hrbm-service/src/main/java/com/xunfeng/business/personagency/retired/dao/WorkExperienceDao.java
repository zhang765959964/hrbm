package com.xunfeng.business.personagency.retired.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.retired.model.WorkExperience;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作经历维护 Dao类
* @author:zhangfan
* @createDate 2016-07-22 15:23:26 
* @version V1.0   
*/
@Repository
public class WorkExperienceDao extends BaseDao<WorkExperience>
{
	@Override
	public Class<?> getEntityClass()
	{
		return WorkExperience.class;
	}
	
	/**
	 * 根据退休id获得工作经历信息
	 * @param retiredId
	 * @return
	 */
	public List getRetiredById(Long retiredId){
		Map params = new HashMap<String, String>();
		params.put("retiredId", retiredId);
		return this.getBySqlKey("getRetiredById", params);
	}
	
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
		
	}
	
	/**
	 * 根据人员id查询工作简历信息
	 * @param personId
	 * @return
	 */
	public List<WorkExperience> getByPersonId(Long personId){
		return this.getBySqlKey("getByPersonId", personId);
	}
	
	
}