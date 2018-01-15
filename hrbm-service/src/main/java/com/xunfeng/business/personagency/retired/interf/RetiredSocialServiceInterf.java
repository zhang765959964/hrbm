package com.xunfeng.business.personagency.retired.interf;

import com.xunfeng.business.personagency.retired.dto.RetiredSocialDto;
import com.xunfeng.business.personagency.retired.model.RetiredSocial;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员转社会化 接口类
* @author:zhangfan
* @createDate 2016-08-09 15:09:43 
* @version V1.0   
*/
public interface RetiredSocialServiceInterf extends GenericServiceInterface<RetiredSocial,Long>
{
   public ResultData<RetiredSocial> getAllByFilter(QueryFilter fiter);	
   
   
   /**
    * 退休人员转社会化列表信息
    * @param fiter
    * @return
    */
   public  ResultData getRetiredSocialList(QueryFilter fiter);
   
   /**
    * 根据退休申诉id查询转社会化记录
    * @param retiredDeclareId
    * @return
    */
   public RetiredSocial getByRetiredId(Long personId);
   
   
   /**
    * 退休转社会化查询
    * @param fiter
    * @return
    */
   public ResultData getRetiredSocialListJson(QueryFilter fiter);
   
   
   /**
    * 批量保存更新退休转社会化
    * @param retiredSocial
    */
   public void saveOrUpdate(Long [] arrId,RetiredSocial retiredSocial);
   
   /**
    * 根据人员id删除信息
    * @param personId
    */
   public void delByPersonId(Long personId);
   
   /**
    * 根据人员id获得转社会化信息
    * @param personId
    * @return
    */
   public RetiredSocial getByPersonId(Long personId);
   
   
   
   
}
