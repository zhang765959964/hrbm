package com.xunfeng.business.personagency.params.interf;

import java.util.Date;

import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PARAMS_PAYMENT 接口类
 * @author:wanghan
 * @createDate 2016-09-05 09:47:42
 * @version V1.0
 */
public interface ParamsPaymentServiceInterf extends GenericServiceInterface<ParamsPayment, Long> {
	public ResultData<ParamsPayment> getAllByFilter(QueryFilter fiter);

	/**
	 * 根据当前日期获取当前日期对应的缴费参数.
	 * 
	 * @param currentDate
	 * @return
	 */
	public ParamsPayment getParamsPayment(Date currentDate);
}
