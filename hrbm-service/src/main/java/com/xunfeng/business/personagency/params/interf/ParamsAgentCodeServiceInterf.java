package com.xunfeng.business.personagency.params.interf;


import com.xunfeng.business.personagency.params.model.ParamsAgentCode;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 劳动代理代码维护 接口类
* @author:wanghan
* @createDate 2016-09-07 10:24:17 
* @version V1.0   
*/
public interface ParamsAgentCodeServiceInterf extends GenericServiceInterface<ParamsAgentCode,Long>
{
   public ResultData<ParamsAgentCode> getAllByFilter(QueryFilter fiter);	
}
