package com.xunfeng.business.personagency.social.interf;


import java.util.Map;

import com.xunfeng.business.personagency.social.model.ChangeReporting;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保变更申报记录表 接口类
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
public interface ChangeReportingServiceInterf extends GenericServiceInterface<ChangeReporting,Long>
{
   public ResultData<ChangeReporting> getAllByFilter(QueryFilter fiter);	
   //添加变更申报信息，并且处理之前数据为无效状态
   public void addChangeReporting(ChangeReporting changeReporting);
   //修改变更申报信息，并且处理之前数据为无效状态
   public void updateChangeReporting(ChangeReporting changeReporting);
   //获取变更申报打印数据
   public Map getChangeReportingById(Long id);
   
}
