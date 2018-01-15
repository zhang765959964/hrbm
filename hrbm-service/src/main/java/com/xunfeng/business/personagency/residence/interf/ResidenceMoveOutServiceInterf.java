package com.xunfeng.business.personagency.residence.interf;


import com.xunfeng.business.personagency.residence.model.ResidenceMoveOut;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口迁入迁出表 接口类
* @author:jiangxin
* @createDate 2016-08-27 15:36:07 
* @version V1.0   
*/
public interface ResidenceMoveOutServiceInterf extends GenericServiceInterface<ResidenceMoveOut,Long>
{
   public ResultData<ResidenceMoveOut> getAllByFilter(QueryFilter fiter);	
   //查询所有户口迁入数据
   public ResultData getAllResidenceMoveOut(QueryFilter fiter);
   //删除户口迁入迁移信息
   public void deleteResidenceMoveOutByIds(Long[] lAryId);
   //查询户口迁入迁移条数
   public Long getTotalResidenceMoveOut(String residenceStatus);
}
