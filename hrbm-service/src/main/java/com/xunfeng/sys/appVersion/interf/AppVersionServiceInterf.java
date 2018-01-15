package com.xunfeng.sys.appVersion.interf;


import com.xunfeng.sys.appVersion.model.AppVersion;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: app版本表 接口类
* @author:jiangxin
* @createDate 2016-11-29 17:05:15 
* @version V1.0   
*/
public interface AppVersionServiceInterf extends GenericServiceInterface<AppVersion,Long>
{
   public ResultData<AppVersion> getAllByFilter(QueryFilter fiter);	
}
