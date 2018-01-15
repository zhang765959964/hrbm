package com.xunfeng.business.personagency.retired.interf;


import com.xunfeng.business.personagency.retired.model.RetiredXh;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休序号历史记录表 接口类
* @author:zhangfan
* @createDate 2016-11-29 17:11:56 
* @version V1.0   
*/
public interface RetiredXhServiceInterf extends GenericServiceInterface<RetiredXh,Long>
{
   public ResultData<RetiredXh> getAllByFilter(QueryFilter fiter);	
   
   /**
    * 根据退休依据类型求出最小的一条历史数据
    * @param type
    * @return
    */
   public RetiredXh getByRetiredType(String type);
   
   
   /**
    * 根据退休类型和时间获得当前最小的历史记录信息 
    * @param type	退休类型
    * @param bm		编码
    * @return
    */
   public RetiredXh getByRetiredTypeOrBm(String type,String bm);
   
   /**
    * 根据退休编码删除数据
    * @param bm
    */
   public void delByBm(String bm);
   
    
   
}
