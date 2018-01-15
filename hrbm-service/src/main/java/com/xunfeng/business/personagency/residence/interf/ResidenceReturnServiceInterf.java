package com.xunfeng.business.personagency.residence.interf;


import com.xunfeng.business.personagency.residence.model.ResidenceReturn;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口借用归还表 接口类
* @author:jiangxin
* @createDate 2016-08-30 09:58:41 
* @version V1.0   
*/
public interface ResidenceReturnServiceInterf extends GenericServiceInterface<ResidenceReturn,Long>
{
   public ResultData<ResidenceReturn> getAllByFilter(QueryFilter fiter);	
   //删除户口借用归还信息
   public void deleteResidenceReturnByIds(Long[] lAryId);
}
