package com.xunfeng.business.personagency.demo.interf;


import com.xunfeng.business.personagency.demo.model.Demotest;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_DEMO 接口类
* @author:zhangfan
* @createDate 2016-07-28 10:46:20 
* @version V1.0   
*/
public interface DemotestServiceInterf extends GenericServiceInterface<Demotest,Long>
{
   public ResultData<Demotest> getAllByFilter(QueryFilter fiter);	
}
