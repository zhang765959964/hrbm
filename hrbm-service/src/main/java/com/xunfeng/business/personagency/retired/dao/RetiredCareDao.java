package com.xunfeng.business.personagency.retired.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.retired.model.RetiredCare;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员大病医保表 Dao类
* @author:zhangfan
* @createDate 2016-12-16 11:23:41 
* @version V1.0   
*/
@Repository
public class RetiredCareDao extends BaseDao<RetiredCare>
{
	@Override
	public Class<?> getEntityClass()
	{
		return RetiredCare.class;
	}
	
	/**
	 * 根据人员id获取养老待遇信息
	 * @param personId
	 * @return
	 */
	public RetiredCare getCareByPersonId(Long personId){
		
	 return	this.getUnique("getCareByPersonId", personId);
		
	}

	

}