package com.xunfeng.business.personagency.erecord.interf;


import com.xunfeng.business.personagency.erecord.model.ErecordCatalog;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴参数 接口类
* @author:wanghan
* @createDate 2016-08-06 10:00:50 
* @version V1.0   
*/
public interface ErecordCatalogServiceInterf extends GenericServiceInterface<ErecordCatalog,Long>
{
   public ResultData<ErecordCatalog> getAllByFilter(QueryFilter fiter);	
}
