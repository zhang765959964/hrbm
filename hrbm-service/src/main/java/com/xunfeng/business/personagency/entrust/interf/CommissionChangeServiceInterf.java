package com.xunfeng.business.personagency.entrust.interf;


import com.xunfeng.business.personagency.entrust.dto.CommissionChangeDto;
import com.xunfeng.business.personagency.entrust.model.CommissionChange;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 委托类型变更 接口类
* @author:jiangxin
* @createDate 2016-08-22 14:48:20 
* @version V1.0   
*/
public interface CommissionChangeServiceInterf extends GenericServiceInterface<CommissionChange,Long>
{
   public ResultData<CommissionChange> getAllByFilter(QueryFilter fiter);	
   //查询所有类型变更数据
   public ResultData getAllCommissionChange(QueryFilter fiter);
   //保存委托变更
   public void addCommissionChange(CommissionChangeDto commissionChangeDto);
}
