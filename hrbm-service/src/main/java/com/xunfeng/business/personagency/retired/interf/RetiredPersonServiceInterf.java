package com.xunfeng.business.personagency.retired.interf;


import java.util.HashMap;
import java.util.Map;

import com.xunfeng.business.personagency.retired.model.RetiredPerson;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_RETIRED_PERSON 接口类
* @author:zhangfan
* @createDate 2016-08-02 17:12:13 
* @version V1.0   
*/
public interface RetiredPersonServiceInterf extends GenericServiceInterface<RetiredPerson,Long>
{
	
   public ResultData<RetiredPerson> getAllByFilter(QueryFilter fiter);	
   
}
