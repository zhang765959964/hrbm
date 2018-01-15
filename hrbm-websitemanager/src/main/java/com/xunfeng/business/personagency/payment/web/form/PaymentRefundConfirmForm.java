package com.xunfeng.business.personagency.payment.web.form;

import java.util.Date;

import com.xunfeng.business.personagency.payment.model.PaymentRefund;
import com.xunfeng.core.model.BaseForm;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PAYMENT_REFUND Form对象
 * @author:wanghan
 * @createDate 2016-08-17 16:06:42
 * @version V1.0
 */
public class PaymentRefundConfirmForm extends BaseForm<PaymentRefund> {
	// 主键ID
	protected Long pkId;
	// 退费日期
	protected java.util.Date fdRefundDate;
	// 退费开始日期
	protected String fdRefundStartDate;
	// 退费结束日期
	protected String fdRefundEndDate;

	// 备注
	protected String fdRefundDesc;
	// 退费月数
	protected Long fdRefundMonths;
	// 退费标准
	protected String fdRefundStandard;
	// 退费金额
	protected String fdRefundAmount;
	// 缴费记录Id
	protected Long fkPaymentId;
	// 确认人Id
	protected Long fkConfirmsId;
	// 确认人名称
	protected String fdConfirmsName;
	// 确认日期
	protected java.util.Date fdConfirmsDate;
	// 确认机构Id
	protected Long fdConfirmsOrgId;
	// 确认机构名称
	protected String fdConfirmsOrgName;
	protected String archiveCode;
	protected String aac002;
	protected String aac003;

	public Long getPkId() {
		return pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public java.util.Date getFdRefundDate() {
		return fdRefundDate;
	}

	public void setFdRefundDate(java.util.Date fdRefundDate) {
		this.fdRefundDate = fdRefundDate;
	}

	public String getFdRefundStartDate() {
		return fdRefundStartDate;
	}

	public void setFdRefundStartDate(String fdRefundStartDate) {
		this.fdRefundStartDate = fdRefundStartDate;
	}

	public String getFdRefundEndDate() {
		return fdRefundEndDate;
	}

	public void setFdRefundEndDate(String fdRefundEndDate) {
		this.fdRefundEndDate = fdRefundEndDate;
	}

	public String getFdRefundDesc() {
		return fdRefundDesc;
	}

	public void setFdRefundDesc(String fdRefundDesc) {
		this.fdRefundDesc = fdRefundDesc;
	}

	public Long getFdRefundMonths() {
		return fdRefundMonths;
	}

	public void setFdRefundMonths(Long fdRefundMonths) {
		this.fdRefundMonths = fdRefundMonths;
	}

	public String getFdRefundStandard() {
		return fdRefundStandard;
	}

	public void setFdRefundStandard(String fdRefundStandard) {
		this.fdRefundStandard = fdRefundStandard;
	}

	public String getFdRefundAmount() {
		return fdRefundAmount;
	}

	public void setFdRefundAmount(String fdRefundAmount) {
		this.fdRefundAmount = fdRefundAmount;
	}

	public Long getFkPaymentId() {
		return fkPaymentId;
	}

	public void setFkPaymentId(Long fkPaymentId) {
		this.fkPaymentId = fkPaymentId;
	}

	public Long getFkConfirmsId() {
		return fkConfirmsId;
	}

	public void setFkConfirmsId(Long fkConfirmsId) {
		this.fkConfirmsId = fkConfirmsId;
	}

	public String getFdConfirmsName() {
		return fdConfirmsName;
	}

	public void setFdConfirmsName(String fdConfirmsName) {
		this.fdConfirmsName = fdConfirmsName;
	}

	public java.util.Date getFdConfirmsDate() {
		return fdConfirmsDate;
	}

	public void setFdConfirmsDate(java.util.Date fdConfirmsDate) {
		this.fdConfirmsDate = fdConfirmsDate;
	}

	public Long getFdConfirmsOrgId() {
		return fdConfirmsOrgId;
	}

	public void setFdConfirmsOrgId(Long fdConfirmsOrgId) {
		this.fdConfirmsOrgId = fdConfirmsOrgId;
	}

	public String getFdConfirmsOrgName() {
		return fdConfirmsOrgName;
	}

	public void setFdConfirmsOrgName(String fdConfirmsOrgName) {
		this.fdConfirmsOrgName = fdConfirmsOrgName;
	}

	public String getArchiveCode() {
		return archiveCode;
	}

	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}

	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public String getAac003() {
		return aac003;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	/*@Override
	public void setCreaterId(Long createrId) {

		this.fkConfirmsId=createrId;
	}

	@Override
	public void setCreaterName(String createrName) {

		this.fdConfirmsName=createrName;
	}

	@Override
	public void setCreaterDate(Date createrDate) {

		this.fdConfirmsDate=createrDate;
	}

	@Override
	public void setCreaterOrgName(String createrOrgName) {

		this.fdConfirmsOrgName=createrOrgName;
	}

	@Override
	public void setCreaterOrgId(Long createrOrgId) {

		this.fdConfirmsOrgId=createrOrgId;
	}
	*/
	

}