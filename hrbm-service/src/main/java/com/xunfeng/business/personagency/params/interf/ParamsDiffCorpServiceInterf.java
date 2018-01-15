package com.xunfeng.business.personagency.params.interf;


import com.xunfeng.business.personagency.params.model.ParamsDiffCorp;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 困难企业 接口类
* @author:wanghan
* @createDate 2016-09-07 10:22:54 
* @version V1.0   
*/
public interface ParamsDiffCorpServiceInterf extends GenericServiceInterface<ParamsDiffCorp,Long>
{
   public ResultData<ParamsDiffCorp> getAllByFilter(QueryFilter fiter);	
}
