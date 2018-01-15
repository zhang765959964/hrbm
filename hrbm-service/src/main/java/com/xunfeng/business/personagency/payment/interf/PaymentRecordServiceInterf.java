package com.xunfeng.business.personagency.payment.interf;

import java.util.Date;
import java.util.List;

import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 缴费记录 接口类
 * @author:wanghan
 * @createDate 2016-08-15 15:23:02
 * @version V1.0
 */
public interface PaymentRecordServiceInterf extends GenericServiceInterface<PaymentRecord, Long> {
	
	public void add(PaymentRecord entity,String expPersonPhone,String aae005);

	/**根据过滤器查询数据
	 * @param fiter
	 * @return
	 */
	public ResultData<PaymentRecord> getAllByFilter(QueryFilter fiter);

	/**根据过滤器查询数据
	 * @param fiter
	 * @return 带有用户基本信息的数据
	 */
	public ResultData<PaymentRecordPersonDto> getPersonRecordByFilter(QueryFilter fiter);

	/**获取实收人员缴费列表，除掉重复人员
	 * @param pageBean
	 * @return
	 */
	public ResultData<PaymentRecordPersonDto> getNoReceiveGroupPayList(PageBean pageBean );
	/**获取实收人员缴费列表，除掉重复人员
	 * @param pageBean
	 * @param currentDate
	 * @return
	 */
	public ResultData<PaymentRecordPersonDto> getNoReceiveGroupPayList(PageBean pageBean ,Date currentDate);
	/**根据缴费状态、日期获取缴费记录
	 * @param pageBean  分页信息
	 * @param fdPaymentStatus  0，未缴 1 已缴
	 * @param currentDate 日期
	 * @return
	 */
	public ResultData<PaymentRecordPersonDto> getOverReceiveGroupPayList(PageBean pageBean,Date currentDate);

	/**获取所有缴费记录
	 * @param pageBean 分页信息
	 * @return
	 */
	public ResultData<PaymentRecordPersonDto> getOverReceiveGroupPayList(PageBean pageBean);
	
	/**获取单位下所有的缴费人员
	 * @param corpId，单位Id，ab01表主键
	 * @return
	 */
	public List<PaymentRecord> getCorpRecordList(Long corpId);

	/**个人缴费批量实收
	 * @param idArray
	 */
	public void bathPayment(Long id,SysUser sysUser);
	
	public Long getNoPaymentCount(Long fkPersonId);
	
	/**根据条件获取欠费人员记录
	 * @param fiter
	 * @return
	 */
	public ResultData<PaymentRecordPersonDto> getOverPersonPayList(QueryFilter fiter);
	
	public ResultData<PaymentRecordPersonDto> getPersonRecordByCorpRecordId(Long fkCorpRecordId,String fdDerateStatus ,PageBean pageBean);
	public ResultData<PaymentRecordPersonDto> getPersonRecordByPersonId(Long fkPersonId);
	public ResultData<PaymentRecordPersonDto> getPersonRecordByPersonId(Long fkPersonId,DerateStatus derateStatus);


}
