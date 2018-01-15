package com.xunfeng.business.personagency.party.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.business.personagency.party.model.PartyPay;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党费缴纳 接口类
* @author:zhangfan
* @createDate 2016-08-16 17:44:26 
* @version V1.0   
*/
public interface PartyPayServiceInterf extends GenericServiceInterface<PartyPay,Long>
{
   public ResultData<PartyPay> getAllByFilter(QueryFilter fiter);	
   
   
   /**
    * 根据党员id查询缴费记录
    * @param partyId
    * @return
    */
   public ResultData  getByPartyId(Long partyId);
   
   
   
   /**
    * 党员缴费列表记录
    * @param fiter
    * @return
    */
   public ResultData getPartyPayList(QueryFilter fiter);
   
   
   /**
    * 用于综合查询缴费记录
    * @param fiter
    * @return
    */
   public ResultData getByvPersonId(QueryFilter fiter);
   
   
   /**
    * 党费交纳统计
    * @param fiter
    * @return
    */
   public ResultData getPartyPayResultList(QueryFilter fiter);
   
   /**
    * 党员缴费金额
    * @param fiter
    * @return
    */
   public List getPartyPayResult(QueryFilter fiter);
   
   
   /**
    * 党员缴费记录数
    * @param fiter
    * @return
    */
   public List getPartyPayCount(QueryFilter fiter);
   
   
   /**
    * 根据党员id获得信息
    * @param payId
    * @return
    */
   public Object getPartyPayById(Long payId);
   
   
   /**
    * 保存或者更新缴费记录
    * @param partyPay
    */
   public void saveOrUpdate(PartyPay partyPay);
   
   
   /**
    * 根据人员id删除信息
    * @param personId
    */
   public void delByPersonId(Long personId);
   
   /**
    * 查询党组织关系是否有缴费记录
    * @param partyId
    * @return
    */
   public Long  getPartyById(Long partyId);

   
  
}
