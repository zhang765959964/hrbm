package com.xunfeng.business.personagency.params.interf;


import com.xunfeng.business.personagency.params.model.ParamsAccountsCorp;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 账号与市场关联维护 接口类
* @author:wanghan
* @createDate 2016-09-07 10:24:43 
* @version V1.0   
*/
public interface ParamsAccountsCorpServiceInterf extends GenericServiceInterface<ParamsAccountsCorp,Long>
{
   public ResultData<ParamsAccountsCorp> getAllByFilter(QueryFilter fiter);	
   
   
   public ResultData getParamsList(QueryFilter fiter);
   
}
