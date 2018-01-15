package com.xunfeng.business.personagency.death.interf;

import java.util.Map;
import com.xunfeng.business.personagency.death.model.DeathDeclare;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 死亡待遇申报 接口类
* @author:zhangfan
* @createDate 2016-08-26 16:25:11 
* @version V1.0   
*/
public interface DeathDeclareServiceInterf extends GenericServiceInterface<DeathDeclare,Long>
{
   public ResultData getAllByFilter(QueryFilter fiter);	
   
   /**
    * 根据人员id查询档案信息
    * @param personId 人员id
    * @return
    */
   public Map getByPersonId(Long personId);
   
   
   
   /**
    * 保存或者更新死忙待遇申报
    * @param deathDeclareDto
    */
   public void saveOrUpdate(DeathDeclare deathDeclare);
   
   
   /**
    * 根据人员id查询申报信息
    * @param personId 人员id
    * @return
    */
   public DeathDeclare getByDeathPersonId(Long personId);
   
   /**
    * 根据身份证号和档案编号查询死亡待遇申请信息
    * @param filter 过滤条件
    * @return
    */
   public ResultData getByPersonIdOraAchiveCode(QueryFilter fiter);
   
   
   /**
    * 根据人员id查询死亡待遇申请信息
    * @param fiter 过滤条件
    * @return
    */
   public ResultData getByvPersonId(QueryFilter fiter);
   
   
   /**
    * 根据人员id删除死亡待遇申请信息
    * @param personId 人员id
    */
   public void delByPersonId(Long personId);
   
   /**
    * 根据人员id返回数据
    * @param personIds 人员id
    * @return
    */
   public Map getPrintDeathList(String  personIds);
   
}
