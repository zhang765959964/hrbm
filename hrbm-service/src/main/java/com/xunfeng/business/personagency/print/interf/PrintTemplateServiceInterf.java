package com.xunfeng.business.personagency.print.interf;


import com.xunfeng.business.personagency.print.model.PrintTemplate;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL 接口类
* @author:wanghan
* @createDate 2016-10-20 15:19:40 
* @version V1.0   
*/
public interface PrintTemplateServiceInterf extends GenericServiceInterface<PrintTemplate,Long>
{
   public ResultData<PrintTemplate> getAllByFilter(QueryFilter fiter);
   public PrintTemplate getTemplateByAlias(String alias);
}
