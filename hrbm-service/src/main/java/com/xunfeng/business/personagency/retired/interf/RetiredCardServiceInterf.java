package com.xunfeng.business.personagency.retired.interf;


import java.util.List;

import com.xunfeng.business.personagency.retired.dto.RetiredCardDto;
import com.xunfeng.business.personagency.retired.model.RetiredCard;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员领取退休证 接口类
* @author:zhangfan
* @createDate 2016-08-05 11:14:07 
* @version V1.0   
*/
public interface RetiredCardServiceInterf extends GenericServiceInterface<RetiredCard,Long>
{
   public ResultData<RetiredCard> getAllByFilter(QueryFilter fiter);	
   
   /**
    * 退休人员查询信息
    * @param fiter
    * @return
    */
   public ResultData getRetiredPersonList(QueryFilter fiter);
   
   
   
   /**
    * 退休人员审批表打印
    * @param filter
    * @return
    */
   public ResultData  getRetiredReportList(QueryFilter fiter);
   
   
   /**
    * 验证退休编号是否重复
    * @param fiter
    * @return
    */
   public List<RetiredCard> getByExitCode(QueryFilter fiter);
   
   /**
    * 保存或者更新领取退休证信息
    * @param retiredCardDto
    */
   public void saveOrUpdate(RetiredCardDto retiredCardDto);
   
   /**
    * 根据退休申诉id查询领取退休证信息
    * @param retiredDeclareId
    * @return
    */
   public RetiredCard getByRetiredId(Long retiredDeclareId);
   
   /**
    * 根据人员id获得领取退休证信息
    * @param personId
    * @return
    */
   public RetiredCard getByPersonId(Long personId);
   
   /**
    * 根据人员id删除信息
    * @param personId
    */
   public void delByPersonId(Long personId);
   

   

   
   
}
