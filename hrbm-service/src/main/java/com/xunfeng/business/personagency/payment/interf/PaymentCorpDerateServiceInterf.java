package com.xunfeng.business.personagency.payment.interf;

import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PAYMENT_CORP_RECORD 接口类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
public interface PaymentCorpDerateServiceInterf {

	/**增加一条单位扣减记录
	 * @param entity
	 */
	public void addPaymentCorpDerate(PaymentCorpRecord entity);

	/**根据条件获取单位扣减记录，一般用于多条件查询
	 * @param fiter
	 * @return
	 */
	public ResultData<PaymentCorpRecordDto> getCorpDerateList(QueryFilter fiter);

	/**
	 * 单位缴费扣减，用于单位批量多选缴费扣减
	 * 
	 * @param entity
	 * @param personIds
	 */
	public void mutiCorpDerate(PaymentRecord entity, Long[] personIds,int type);

	/**
	 * 单位缴费扣减，用于单位下全部存档人员缴费扣减
	 * 
	 * @param pkId
	 *            单位缴费记录主键ID
	 * @param lAryId
	 *            单位下人员缴费记录主键ID数组
	 */
	public void allCorpDerate(PaymentRecord entity,int type);

}
