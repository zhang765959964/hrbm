package com.xunfeng.business.personagency.payment.interf;


import com.xunfeng.business.personagency.payment.model.PaymentYearDetail;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL 接口类
* @author:user
* @createDate 2016-11-03 16:16:59 
* @version V1.0   
*/
public interface PaymentYearDetailServiceInterf extends GenericServiceInterface<PaymentYearDetail,Long>
{
   public ResultData<PaymentYearDetail> getAllByFilter(QueryFilter fiter);	
}
