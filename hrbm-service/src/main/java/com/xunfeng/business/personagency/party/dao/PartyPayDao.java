package com.xunfeng.business.personagency.party.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.party.model.PartyPay;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党费缴纳 Dao类
* @author:zhangfan
* @createDate 2016-08-16 17:44:26 
* @version V1.0   
*/
@Repository
public class PartyPayDao extends BaseDao<PartyPay>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PartyPay.class;
	}
	
	
	public Map getPartyPayResult(QueryFilter filter){
		
		return (Map)this.getOne("getPartyPayResult", filter);
		
	}


	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		
		this.delBySqlKey("delByPersonId", personId);
		
	}

	/**
	 * 查询党组织关系是否有缴费记录
	 * @param partyId
	 * @return
	 */
	public Long getPartyById(Long partyId){
		return (Long)this.getOne("getPartyById", partyId);
	}
	

}