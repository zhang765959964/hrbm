package com.xunfeng.business.personagency.retired.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.retired.model.RetiredSocial;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员转社会化 Dao类
* @author:zhangfan
* @createDate 2016-08-09 15:09:43 
* @version V1.0   
*/
@Repository
public class RetiredSocialDao extends BaseDao<RetiredSocial>
{
	@Override
	public Class<?> getEntityClass()
	{
		return RetiredSocial.class;
	}
	
	
	/**
	 * 根据人员id返回 当前主键id
	 * @param peopleId
	 * @return
	 */
	public RetiredSocial getByRetiredId(Long personId){
		return (RetiredSocial) this.getOne("getByRetiredId", personId);
		
	}
	
	/**
	 * 根据人员id获得转社会信息
	 * @param personId
	 * @return
	 */
	public RetiredSocial getByPersonId(Long personId){
		return this.getUnique("getByPersonId", personId);
		
	}
	
	public  void retiredSocialAdd(RetiredSocial retiredSocial){
		this.add(retiredSocial);
	}

	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
	}
}