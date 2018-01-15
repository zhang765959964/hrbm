package com.xunfeng.business.personagency.retired.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.retired.model.WorkKj;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作扣减情况维护 Dao类
* @author:zhangfan
* @createDate 2016-07-23 10:31:59 
* @version V1.0   
*/
@Repository
public class WorkKjDao extends BaseDao<WorkKj>
{
	@Override
	public Class<?> getEntityClass()
	{
		return WorkKj.class;
	}

	
	/**
	 * 根据退休id 获得扣减情况信息
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
	
	
	
	public List getByPersonId(Long personId){
		
		Map params = new HashMap<String, String>();
		params.put("personId", personId);
		return this.getBySqlKey("getByPersonId", params);
		
	}
	
	
}