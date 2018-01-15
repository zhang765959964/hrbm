package com.xunfeng.business.personagency.payment.interf;

import com.xunfeng.business.personagency.payment.dto.PaymentCorpOverDto;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PAYMENT_CORP_RECORD 接口类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
public interface PaymentCorpRecordServiceInterf extends GenericServiceInterface<PaymentCorpRecord, Long> {
	/**获取单位正常缴费记录
	 * @param fiter
	 * @return
	 */
	public ResultData<PaymentCorpRecord> getAllByFilter(QueryFilter fiter);
	
	public ResultData<PaymentCorpRecordDto> getAllWithCorpInfoFilter(QueryFilter fiter);

	/**获取所有未缴费单位记录
	 * @param pageBean
	 * @return
	 */
	public ResultData<PaymentCorpRecordDto> getNoPaymentList(PageBean pageBean);

	/**获取所有已缴费单位记录
	 * @param pageBean
	 * @return
	 */
	public ResultData<PaymentCorpRecordDto> getPaymentList(PageBean pageBean);
	

	
	/**根据单位缴费记录Id获取单位缴费记录
	 * @param pkId
	 * @return 带有单位基本信息的单位缴费记录对象
	 */
	public PaymentCorpRecordDto getPaymentWithCorpById(Long pkId) ;
	
	
	/**根据条件获取满足条件的欠费的的单位列表
	 * @param fiter
	 * @return
	 */
	public ResultData<PaymentCorpOverDto> getOverUnitAgreement(QueryFilter fiter );
	
	/**单位缴费，用于单位单笔缴费登记
	 * @param entity
	 */
	public void addCorpPayment(PaymentRecord entity);
	
	/**单位缴费，用于单位全部缴费登记
	 * @param entity
	 * @param type
	 */
	public void allCorpPayment(PaymentRecord entity,int type) ;
	
	/**单位缴费，用于单位批量缴费登记
	 * @param entity
	 * @param personIds
	 */
	public void batchAddCorpPayment(PaymentRecord entity,Long[] personIds,int type);
	
	/**单位多选实收
	 * @param pkId   单位缴费记录主键ID
	 * @param lAryId  单位下人员缴费记录主键ID数组
	 */
	public void receiveMutiPayment(Long pkId, Long[] lAryId);

	/**单位全选实收
	 * @param pkId  单位缴费记录主键ID
	 */
	public void receiveAllPayment(Long pkId,SysUser sysUser);
	
	public Long getPaymentCorpRecordCount(Long corpId, PaymentStatus paymentStatus);
	
	public Long getPaymentCorpRecordCount(Long corpId, PaymentStatus paymentStatus,DerateStatus derateStatus) ;
	
	
}
