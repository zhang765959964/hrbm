package com.xunfeng.business.personagency.retired.interf;


import java.util.Map;

import com.xunfeng.business.personagency.retired.dto.RetiredCareDto;
import com.xunfeng.business.personagency.retired.model.RetiredCare;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员大病医保表 接口类
* @author:zhangfan
* @createDate 2016-12-16 11:23:41 
* @version V1.0   
*/
public interface RetiredCareServiceInterf extends GenericServiceInterface<RetiredCare,Long>
{
   public ResultData<RetiredCare> getAllByFilter(QueryFilter fiter);	
   
   
   /**
    * 退休人员大病医保列表
    * @param fiter
    * @return
    */
   public ResultData getRetiredCareList(QueryFilter fiter);
   

   
   /**
    * 根据人员id获取大病医保信息
    * @param personId
    * @return
    */
   public Map getByPersonId(Long personId);
   
   
   
   /**
    * 根据人员id获取大病医保信息
    * @param personId
    * @return
    */
   public RetiredCare getCareByPersonId(Long personId);
   
   
   /**
    * 保存
    * @param retiredCareDto
    */
   public void saveOrUpdate(RetiredCareDto retiredCareDto);
   
   
   /**
    * 批量操作大病医保 信息
    * @param arrId
    * @param retiredCare
    */
   public void saveOrUpdatePl(Long [] arrId,RetiredCareDto  retiredCareDto);
   
}
