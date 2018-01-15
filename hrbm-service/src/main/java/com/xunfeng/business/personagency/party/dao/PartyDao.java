package com.xunfeng.business.personagency.party.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.party.model.Party;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党组织关系表 Dao类
* @author:zhangfan
* @createDate 2016-08-17 11:32:11 
* @version V1.0   
*/
@Repository
public class PartyDao extends BaseDao<Party>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Party.class;
	}

	
	
	

	
	/**
	 * 根据人员id获得档案信息 和个人基本信息
	 * @param personId
	 * @return
	 */
	public Map getPartyByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getPartyByPersonId", params);
		
	}

	/**
	 * 查询缴费总人数
	 * @return
	 */
	public Long getSumPerson(){
		return (Long)this.getOne("getSumPerson", null);
		
	}
	/**
	 * 查询缴费人数
	 * @return
	 */
	public Long getJfPerson(){
		return (Long)this.getOne("getJfPerson", null);
		
	}
	
	/**
	 * 代管组织关系为是
	 * @return
	 */
	public Long getPartyStatus(){
		return (Long)this.getOne("getPartyStatus", null);
	}
	
	/**
	 * 欠费人数
	 * @return
	 */
	public Long  getPartyOweSum(){
		return (Long)this.getOne("getPartyOweSum",null);
	}
	
	/**
	 * 根据人员删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
		
	}
	
	/**
	 * 更新缴费状态
	 * @param personId
	 */
	public void updatePay(Long personId){
		this.update("updatePay", personId);
	}
	
	/**
	 * 根据人员id查询党组织关系为转入的数据
	 * @param personId
	 * @return
	 */
	public Party findByPartyInto(Long personId){
		return this.getUnique("findByPartyInto", personId);
	}
}