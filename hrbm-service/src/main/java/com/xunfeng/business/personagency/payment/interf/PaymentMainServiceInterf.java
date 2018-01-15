package com.xunfeng.business.personagency.payment.interf;

import java.util.List;

import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PAYMENT_MAIN 接口类
 * @author:wanghan
 * @createDate 2016-09-01 10:57:44
 * @version V1.0
 */
public interface PaymentMainServiceInterf extends GenericServiceInterface<PaymentMain, Long> {
	public ResultData<PaymentMain> getAllByFilter(QueryFilter fiter);

	public PaymentMain getPaymentMain(Long fkPersonid);

	/**获取最后缴费月份
	 * @param personId
	 * @return
	 */
	public String getLastPayMentDate(Long personId);
	
	/**获取单位欠费人员记录
	 * @param corpId
	 * @return
	 */
	public  List<PaymentMain> getOverPaymentMain(Long corpId);
}
