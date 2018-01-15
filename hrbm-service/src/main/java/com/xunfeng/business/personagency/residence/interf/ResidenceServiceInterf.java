package com.xunfeng.business.personagency.residence.interf;


import com.xunfeng.business.personagency.residence.model.Residence;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口材料表 接口类
* @author:jiangxin
* @createDate 2016-08-26 11:46:18 
* @version V1.0   
*/
public interface ResidenceServiceInterf extends GenericServiceInterface<Residence,Long>
{
   public ResultData<Residence> getAllByFilter(QueryFilter fiter);	
   //查询所有户口材料数据
   public ResultData getAllResidence(QueryFilter fiter);
   //删除户口材料信息
   public void deleteResidenceByIds(Long[] lAryId);
}
