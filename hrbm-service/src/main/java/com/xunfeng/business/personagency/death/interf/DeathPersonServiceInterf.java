package com.xunfeng.business.personagency.death.interf;


import com.xunfeng.business.personagency.death.model.DeathPerson;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 供养直系亲属情况 接口类
* @author:zhangfan
* @createDate 2016-08-30 10:12:09 
* @version V1.0   
*/
public interface DeathPersonServiceInterf extends GenericServiceInterface<DeathPerson,Long>
{
   public ResultData<DeathPerson> getAllByFilter(QueryFilter fiter);	
   
   
   /**
    * 根据人员id 删除信息
    * @param personId 人员id
    */
   public void delByPersonId(Long personId);
   
   
   /**
    * 根据人员id查询亲属关系
    * @param fiter 过滤条件
    * @return
    */
   public ResultData<DeathPerson> getByvPersonId(QueryFilter fiter);	
   
   /**
    * 查询供养直系亲属情况信息
    * @param fiter
    * @return
    */
   public ResultData getByvDeathPerson(QueryFilter fiter);
   
}
