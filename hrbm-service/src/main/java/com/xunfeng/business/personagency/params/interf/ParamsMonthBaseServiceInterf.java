package com.xunfeng.business.personagency.params.interf;


import com.xunfeng.business.personagency.params.model.ParamsMonthBase;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 月缴费基数 接口类
* @author:wanghan
* @createDate 2016-09-07 09:23:00 
* @version V1.0   
*/
public interface ParamsMonthBaseServiceInterf extends GenericServiceInterface<ParamsMonthBase,Long>
{
   public ResultData<ParamsMonthBase> getAllByFilter(QueryFilter fiter);	
}
