package com.xunfeng.business.personagency.receive.interf;


import com.xunfeng.business.personagency.receive.model.CorpPerson;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位人员关系表 接口类
* @author:wanghan
* @createDate 2016-08-09 09:11:37 
* @version V1.0   
*/
public interface CorpPersonServiceInterf extends GenericServiceInterface<CorpPerson,Long>
{
   public ResultData<CorpPerson> getAllByFilter(QueryFilter fiter);	
   //获取条数数据
   public Long getArchivesCountByCorpId(String corpId);
}
