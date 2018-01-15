package com.xunfeng.business.personagency.payment.interf;


import com.xunfeng.business.personagency.payment.dto.PaymentRefundDto;
import com.xunfeng.business.personagency.payment.enumeration.RefundStatus;
import com.xunfeng.business.personagency.payment.model.PaymentRefund;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND 接口类
* @author:wanghan
* @createDate 2016-08-17 14:13:49 
* @version V1.0   
*/
public interface PaymentRefundServiceInterf extends GenericServiceInterface<PaymentRefund,Long>
{
   
	public ResultData<PaymentRefund> getAllByFilter(QueryFilter fiter);	
   
	/**获取已登记人员退费记录
	 * @return
	 */
	public ResultData<PaymentRefundDto> getRegisterRefundList(PageBean pageBean);	 
	
	/**根据退费记录主键Id获取退费记录，
	 * @param pkId   退费记录主键
	 * @return 包括人员基本信息的PaymentRefundDto对象
	 */
	public PaymentRefundDto getPaymentRefundById(Long pkId);	
	
	/**确认退费
	 * @param pkId 退费记录主键
	 */
	public void confirmRefund(PaymentRefund paymentRefund);
	
	/**获取当前退费的记录数
	 * @param pkPersonId  用户Id
	 * @param refundStatus  退费状态
	 * @return
	 */
	public Long getRefundCount(Long pkPersonId,RefundStatus refundStatus);
	
}
