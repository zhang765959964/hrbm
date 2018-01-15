package com.xunfeng.business.personagency.archive.interf;


import com.xunfeng.business.personagency.archive.model.ArchiveLendExp;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出拓展表 接口类
* @author:jiangxin
* @createDate 2016-12-26 11:21:59 
* @version V1.0   
*/
public interface ArchiveLendExpServiceInterf extends GenericServiceInterface<ArchiveLendExp,Long>
{
   public ResultData<ArchiveLendExp> getAllByFilter(QueryFilter fiter);	
}
