package com.xunfeng.business.personagency.retired.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员申报表 Dao类
* @author:zhangfan
* @createDate 2016-07-16 11:24:12 
* @version V1.0   
*/
@Repository
public class RetiredDeclareDao extends BaseDao<RetiredDeclare>
{
	@Override
	public Class<?> getEntityClass()
	{
		return RetiredDeclare.class;
	}
	
	
	/**
	 * 根据人员id获得人员信息和档案信息
	 * @param personId
	 * @return
	 */
	public Map getRetiredByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getRetiredByPersonId", params);
	}
	
	/**
	 * 根据人员id获得退休打印信息
	 * @param personId
	 * @return
	 */
	public Map getPrintByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getPrintByPersonId", params);
		
	}
	
	
	
	/**
	 * 根据id获得养老待遇申请信息
	 * @param id
	 * @return
	 */
	public Map getRetiredById(Long id){
		Map params = new HashMap();
		params.put("id", id);
		return (Map)this.getOne("getRetiredById", params);
		
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Map getRetiredTab(Long id){
		Map params=new HashMap();
		params.put("id", id);
		return (Map)this.getOne("getRetiredTab", params);
	}
	
	/**
	 * 根据人员id返回 当前主键id
	 * @param peopleId
	 * @return
	 */
	public RetiredDeclare getPersonId(Long peopleId){
		return (RetiredDeclare) this.getOne("getPeopleId", peopleId);
	}
	


	/**
	 * 根据人员id删除信息
	 * @param personId 人员id
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
		
	}
	
	/**
	 * 验证退休个人编号
	 * @param retiredBm
	 * @return
	 */
	public Long  getByRetiredBm(String retiredBm){
		return (Long)this.getOne("getByRetiredBm", retiredBm);
		
		
	}
	

}