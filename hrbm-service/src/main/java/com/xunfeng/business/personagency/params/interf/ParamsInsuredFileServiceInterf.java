package com.xunfeng.business.personagency.params.interf;


import com.xunfeng.business.personagency.params.model.ParamsInsuredFile;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 参保文件 接口类
* @author:wanghan
* @createDate 2016-09-07 10:23:40 
* @version V1.0   
*/
public interface ParamsInsuredFileServiceInterf extends GenericServiceInterface<ParamsInsuredFile,Long>
{
   public ResultData<ParamsInsuredFile> getAllByFilter(QueryFilter fiter);	
}
