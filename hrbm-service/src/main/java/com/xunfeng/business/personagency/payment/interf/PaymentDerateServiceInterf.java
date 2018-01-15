package com.xunfeng.business.personagency.payment.interf;

import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 缴费记录 接口类
 * @author:wanghan
 * @createDate 2016-08-15 15:23:02
 * @version V1.0
 */
public interface PaymentDerateServiceInterf {

	public ResultData<PaymentRecordPersonDto> getPersonDerateList(Long fkPersonId, PageBean pageBean);

	public void addPaymentDerate(PaymentRecord entity,String expPersonPhone,String aae005);

	public ResultData<PaymentRecordPersonDto> getPersonDerateList(QueryFilter fiter);


}
