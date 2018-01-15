package com.xunfeng.sys.shortMessage.interf;


import com.xunfeng.sys.shortMessage.model.ShortMessage;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信发送内容表 接口类
* @author:wanlupeng
* @createDate 2016-08-15 15:17:45 
* @version V1.0   
*/
public interface ShortMessageServiceInterf extends GenericServiceInterface<ShortMessage,Long>
{
   public ResultData<ShortMessage> getAllByFilter(QueryFilter fiter);
   
}
