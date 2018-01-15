package com.xunfeng.business.personagency.retired.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.retired.model.RetiredCard;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员领取退休证 Dao类
* @author:zhangfan
* @createDate 2016-08-05 11:14:07 
* @version V1.0   
*/
@Repository
public class RetiredCardDao extends BaseDao<RetiredCard>
{
	@Override
	public Class<?> getEntityClass()
	{
		return RetiredCard.class;
	}

	
	

	/**
	 * 根据人员id返回 当前主键id
	 * @param peopleId
	 * @return
	 */
	public RetiredCard getByRetiredId(Long retiredDeclareId){
		return (RetiredCard) this.getOne("getByRetiredId", retiredDeclareId);
		
	}
	
	
	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
	}
	

	public RetiredCard getByPersonId(Long personId){
		return this.getUnique("getByRetiredId", personId);
		
	}
	
	

	/**
	 * 查询退休证号
	 * @return
	 */
	public Long getByCardCode(String retiredCardCode){
		return (Long)this.getOne("getByCardCode", retiredCardCode);
		
	}
	
}