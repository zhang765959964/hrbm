package com.xunfeng.business.personagency.payment.web.form;
import java.util.Date;

import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.payment.model.PaymentRefund;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND Form对象
* @author:wanghan
* @createDate 2016-08-31 14:29:32 
* @version V1.0   
*/
public class PaymentRefundForm extends BaseForm<PaymentRefund>
{
	// 主键ID
	protected Long  pkId;
	// 人员ID
	protected Long  pkPersonId;
	// 经办人员ID
	protected Long  fkCreaterId;
	// 经办人员名称
	protected String  fdCreaterName;
	// 经办时间
	protected java.util.Date  fdCreaterDate;
	// 经办机构名称
	protected String  fdCreaterOrgName;
	// 经办机构Id
	protected Long  fkCreaterOrgId;
	// 退费开始日期
	protected String  fdRefundStartDate;
	// 退费结束日期
	protected String  fdRefundEndDate;


	// 备注
	protected String  fdRefundDesc;
	// 退费月数
	protected Long  fdRefundMonths;
	// 退费标准
	protected String  fdRefundStandard;
	// 退费金额
	protected String  fdRefundAmount;
	
	protected String archiveCode;
	protected String aac002;
	protected String aac003;
	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public Long getPkPersonId() {
		return pkPersonId;
	}
	public void setPkPersonId(Long pkPersonId) {
		this.pkPersonId = pkPersonId;
	}
	public Long getFkCreaterId() {
		return fkCreaterId;
	}
	public void setFkCreaterId(Long fkCreaterId) {
		this.fkCreaterId = fkCreaterId;
	}
	public String getFdCreaterName() {
		return fdCreaterName;
	}
	public void setFdCreaterName(String fdCreaterName) {
		this.fdCreaterName = fdCreaterName;
	}
	public java.util.Date getFdCreaterDate() {
		return fdCreaterDate;
	}
	public void setFdCreaterDate(java.util.Date fdCreaterDate) {
		this.fdCreaterDate = fdCreaterDate;
	}
	public String getFdCreaterOrgName() {
		return fdCreaterOrgName;
	}
	public void setFdCreaterOrgName(String fdCreaterOrgName) {
		this.fdCreaterOrgName = fdCreaterOrgName;
	}
	public Long getFkCreaterOrgId() {
		return fkCreaterOrgId;
	}
	public void setFkCreaterOrgId(Long fkCreaterOrgId) {
		this.fkCreaterOrgId = fkCreaterOrgId;
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
		this.fkCreaterId=createrId;
	}
	@Override
	public void setCreaterName(String createrName) {
		
		this.fdCreaterName=createrName;
	}
	@Override
	public void setCreaterDate(Date createrDate) {
		
		this.fdCreaterDate=createrDate;
	}
	@Override
	public void setCreaterOrgName(String createrOrgName) {
		
		this.fdCreaterOrgName=createrOrgName;
	}
	@Override
	public void setCreaterOrgId(Long createrOrgId) {
		
		this.fkCreaterOrgId=createrOrgId;
	}
*/
	

}