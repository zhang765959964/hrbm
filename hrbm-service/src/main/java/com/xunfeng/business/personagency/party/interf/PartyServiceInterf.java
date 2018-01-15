package com.xunfeng.business.personagency.party.interf;


import java.util.Map;

import com.xunfeng.business.personagency.party.dto.PartyDto;
import com.xunfeng.business.personagency.party.model.Party;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党组织关系表 接口类
* @author:zhangfan
* @createDate 2016-08-17 11:32:11 
* @version V1.0   
*/
public interface PartyServiceInterf extends GenericServiceInterface<Party,Long>
{
   public ResultData<Party> getAllByFilter(QueryFilter fiter);	
   
   
   /**
    * 查询列表信息
    * @param fiter
    * @return
    */
   public ResultData getByPersonIdList(QueryFilter fiter);
   
   /**
    * 根据人员id 查询党组织关系
    * @param personId
    * @return
    */
   public ResultData getPartyByPersonId(Long personId);
   
   
   
   /**
    * 根据人员id 查询档案信息
    * @param personId
    * @return
    */
	public Map getPartyByPersonIds(Long personId);
	
	
	/**
	 * 适用于综合查询 代理详细查询中党组织关系信息
	 * @param personId 人员id
	 * @return
	 */
	public ResultData getByvPersonId(QueryFilter fiter);
	
	/**
	 * 党组织关系查询
	 * @param fiter
	 * @return
	 */
	public ResultData getPartyList(QueryFilter fiter);
   
	
	
	/**
	 * 党组织关系保存或更新
	 * @param partyDto
	 */
	public void saveOrUpdate(PartyDto partyDto);
	
	
	/**
	 * 党组织关系转入
	 * @param partyDto
	 */
	public void partyInto(PartyDto partyDto);
	
	
	
	/**
	 * 党组织关系转出
	 * @param partyDto
	 */
	public void partyOut(PartyDto partyDto);
	
	
	/**
	 * 获取党费缴纳总人数
	 * @return
	 */
	public Long getSumPerson();
	
	/**
	 * 获取党费缴费人数
	 * @return
	 */
	public Long getJfPerson();
	
	
	/**
	 * 欠费人数
	 * @return
	 */
	public Long getPartyOweSum();
	
	/**
	 * 代管组织关系人数
	 * @return
	 */
	public Long getPartyStatus();
	
	
	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId);
	
	
	/**
	 * 删除多条记录
	 */
	public void delPartyByIds(Long [] ids);
	
	/**
	 * 更新缴费状态值为0
	 * @param personId
	 */
	public void updatePay(Long personId);
	
	
	/**
	 * 根据人员id查询党员信息
	 * @param personId
	 * @return
	 */
	public Party findByPersonId(Long personId);
	
	
	/**
	 * 根据人员id查询党组织关系为转出状态
	 * @param personId
	 * @return
	 */
	public Party findByPartyInto(Long personId);
	
 }
	