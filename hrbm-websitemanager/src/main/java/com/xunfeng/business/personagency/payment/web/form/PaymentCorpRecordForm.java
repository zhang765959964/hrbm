package com.xunfeng.business.personagency.payment.web.form;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;
import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseForm;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_CORP_RECORD Form对象
* @author:wanghan
* @createDate 2016-08-20 14:57:53 
* @version V1.0   
*/
public class PaymentCorpRecordForm extends BaseForm<PaymentCorpRecord>
{
	// 主键ID
	protected Long  pkId;
	// 人员ID
	protected Long  fkCorpId;
	// 经办人ID
	protected Long  fkCreaterId;
	// 经办人名称
	protected String  fdCreaterName;
	// 经办时间
	protected java.util.Date  fdCreaterDate;
	// 经办机构名称
	protected String  fdCreaterOrgName;
	// 经办机构ID
	protected Long  fkCreaterOrgId;
	// 开始缴费日期
	protected String  fdStartDate;
	// 终止缴费日期
	protected String  fdEndDate;
	// 缴费金额
	protected String  fdPaymentAmount;
	// 缴费月数
	protected Long  fdPaymentMonths;
	// 缴费类型
	protected String  fdPaymentType;
	// 缴费状态
	protected PaymentStatus  fdPaymentStatus;
	// 缴费标准
	protected String  fdPaymentStandard;
	// 缴费日期
	protected java.util.Date  fdPaymentDate;
	// 确认人Id
	protected Long  fkConfirmsId;
	// 确认人名称
	protected String  fdConfirmsName;
	// 确认日期
	protected java.util.Date  fdConfirmsDate;
	// 确认机构Id
	protected Long  fkConfirmsOrgId;
	// 确认机构名称
	protected String  fdConfirmsOrgName;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键ID
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFkCorpId(Long fkCorpId) 
	{
		this.fkCorpId = fkCorpId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getFkCorpId() 
	{
		return this.fkCorpId;
	}
	public void setFkCreaterId(Long fkCreaterId) 
	{
		this.fkCreaterId = fkCreaterId;
	}
	/**
	 * 返回 经办人ID
	 * @return
	 */
	public Long getFkCreaterId() 
	{
		return this.fkCreaterId;
	}
	public void setFdCreaterName(String fdCreaterName) 
	{
		this.fdCreaterName = fdCreaterName;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getFdCreaterName() 
	{
		return this.fdCreaterName;
	}
	public void setFdCreaterDate(java.util.Date fdCreaterDate) 
	{
		this.fdCreaterDate = fdCreaterDate;
	}
	/**
	 * 返回 经办时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdCreaterDate() 
	{
		return this.fdCreaterDate;
	}
	public void setFdCreaterOrgName(String fdCreaterOrgName) 
	{
		this.fdCreaterOrgName = fdCreaterOrgName;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getFdCreaterOrgName() 
	{
		return this.fdCreaterOrgName;
	}
	public void setFkCreaterOrgId(Long fkCreaterOrgId) 
	{
		this.fkCreaterOrgId = fkCreaterOrgId;
	}
	/**
	 * 返回 经办机构ID
	 * @return
	 */
	public Long getFkCreaterOrgId() 
	{
		return this.fkCreaterOrgId;
	}
	public void setFdStartDate(String fdStartDate) 
	{
		this.fdStartDate = fdStartDate;
	}
	/**
	 * 返回 开始缴费日期
	 * @return
	 */
	public String getFdStartDate() 
	{
		return this.fdStartDate;
	}
	public void setFdEndDate(String fdEndDate) 
	{
		this.fdEndDate = fdEndDate;
	}
	/**
	 * 返回 终止缴费日期
	 * @return
	 */
	public String getFdEndDate() 
	{
		return this.fdEndDate;
	}
	public void setFdPaymentAmount(String fdPaymentAmount) 
	{
		this.fdPaymentAmount = fdPaymentAmount;
	}
	/**
	 * 返回 缴费金额
	 * @return
	 */
	public String getFdPaymentAmount() 
	{
		return this.fdPaymentAmount;
	}
	public void setFdPaymentMonths(Long fdPaymentMonths) 
	{
		this.fdPaymentMonths = fdPaymentMonths;
	}
	/**
	 * 返回 缴费月数
	 * @return
	 */
	public Long getFdPaymentMonths() 
	{
		return this.fdPaymentMonths;
	}
	public void setFdPaymentType(String fdPaymentType) 
	{
		this.fdPaymentType = fdPaymentType;
	}
	/**
	 * 返回 缴费类型
	 * @return
	 */
	public String getFdPaymentType() 
	{
		return this.fdPaymentType;
	}

	public PaymentStatus getFdPaymentStatus() {
		return fdPaymentStatus;
	}
	public void setFdPaymentStatus(PaymentStatus fdPaymentStatus) {
		this.fdPaymentStatus = fdPaymentStatus;
	}
	public void setFdPaymentStandard(String fdPaymentStandard) 
	{
		this.fdPaymentStandard = fdPaymentStandard;
	}
	/**
	 * 返回 缴费标准
	 * @return
	 */
	public String getFdPaymentStandard() 
	{
		return this.fdPaymentStandard;
	}
	public void setFdPaymentDate(java.util.Date fdPaymentDate) 
	{
		this.fdPaymentDate = fdPaymentDate;
	}
	/**
	 * 返回 缴费日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdPaymentDate() 
	{
		return this.fdPaymentDate;
	}
	public void setFkConfirmsId(Long fkConfirmsId) 
	{
		this.fkConfirmsId = fkConfirmsId;
	}
	/**
	 * 返回 确认人Id
	 * @return
	 */
	public Long getFkConfirmsId() 
	{
		return this.fkConfirmsId;
	}
	public void setFdConfirmsName(String fdConfirmsName) 
	{
		this.fdConfirmsName = fdConfirmsName;
	}
	/**
	 * 返回 确认人名称
	 * @return
	 */
	public String getFdConfirmsName() 
	{
		return this.fdConfirmsName;
	}
	public void setFdConfirmsDate(java.util.Date fdConfirmsDate) 
	{
		this.fdConfirmsDate = fdConfirmsDate;
	}
	/**
	 * 返回 确认日期
	 * @return
	 */
	public java.util.Date getFdConfirmsDate() 
	{
		return this.fdConfirmsDate;
	}
	public void setFkConfirmsOrgId(Long fkConfirmsOrgId) 
	{
		this.fkConfirmsOrgId = fkConfirmsOrgId;
	}
	/**
	 * 返回 确认机构Id
	 * @return
	 */
	public Long getFkConfirmsOrgId() 
	{
		return this.fkConfirmsOrgId;
	}
	public void setFdConfirmsOrgName(String fdConfirmsOrgName) 
	{
		this.fdConfirmsOrgName = fdConfirmsOrgName;
	}
	/**
	 * 返回 确认机构名称
	 * @return
	 */
	public String getFdConfirmsOrgName() 
	{
		return this.fdConfirmsOrgName;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PaymentCorpRecordForm)) 
		{
			return false;
		}
		PaymentCorpRecordForm rhs = (PaymentCorpRecordForm) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fkCorpId, rhs.fkCorpId)
		.append(this.fkCreaterId, rhs.fkCreaterId)
		.append(this.fdCreaterName, rhs.fdCreaterName)
		.append(this.fdCreaterDate, rhs.fdCreaterDate)
		.append(this.fdCreaterOrgName, rhs.fdCreaterOrgName)
		.append(this.fkCreaterOrgId, rhs.fkCreaterOrgId)
		.append(this.fdStartDate, rhs.fdStartDate)
		.append(this.fdEndDate, rhs.fdEndDate)
		.append(this.fdPaymentAmount, rhs.fdPaymentAmount)
		.append(this.fdPaymentMonths, rhs.fdPaymentMonths)
		.append(this.fdPaymentType, rhs.fdPaymentType)
		.append(this.fdPaymentStatus, rhs.fdPaymentStatus)
		.append(this.fdPaymentStandard, rhs.fdPaymentStandard)
		.append(this.fdPaymentDate, rhs.fdPaymentDate)
		.append(this.fkConfirmsId, rhs.fkConfirmsId)
		.append(this.fdConfirmsName, rhs.fdConfirmsName)
		.append(this.fdConfirmsDate, rhs.fdConfirmsDate)
		.append(this.fkConfirmsOrgId, rhs.fkConfirmsOrgId)
		.append(this.fdConfirmsOrgName, rhs.fdConfirmsOrgName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fkCorpId) 
		.append(this.fkCreaterId) 
		.append(this.fdCreaterName) 
		.append(this.fdCreaterDate) 
		.append(this.fdCreaterOrgName) 
		.append(this.fkCreaterOrgId) 
		.append(this.fdStartDate) 
		.append(this.fdEndDate) 
		.append(this.fdPaymentAmount) 
		.append(this.fdPaymentMonths) 
		.append(this.fdPaymentType) 
		.append(this.fdPaymentStatus) 
		.append(this.fdPaymentStandard) 
		.append(this.fdPaymentDate) 
		.append(this.fkConfirmsId) 
		.append(this.fdConfirmsName) 
		.append(this.fdConfirmsDate) 
		.append(this.fkConfirmsOrgId) 
		.append(this.fdConfirmsOrgName) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fkCorpId", this.fkCorpId) 
		.append("fkCreaterId", this.fkCreaterId) 
		.append("fdCreaterName", this.fdCreaterName) 
		.append("fdCreaterDate", this.fdCreaterDate) 
		.append("fdCreaterOrgName", this.fdCreaterOrgName) 
		.append("fkCreaterOrgId", this.fkCreaterOrgId) 
		.append("fdStartDate", this.fdStartDate) 
		.append("fdEndDate", this.fdEndDate) 
		.append("fdPaymentAmount", this.fdPaymentAmount) 
		.append("fdPaymentMonths", this.fdPaymentMonths) 
		.append("fdPaymentType", this.fdPaymentType) 
		.append("fdPaymentStatus", this.fdPaymentStatus) 
		.append("fdPaymentStandard", this.fdPaymentStandard) 
		.append("fdPaymentDate", this.fdPaymentDate) 
		.append("fkConfirmsId", this.fkConfirmsId) 
		.append("fdConfirmsName", this.fdConfirmsName) 
		.append("fdConfirmsDate", this.fdConfirmsDate) 
		.append("fkConfirmsOrgId", this.fkConfirmsOrgId) 
		.append("fdConfirmsOrgName", this.fdConfirmsOrgName) 
		.toString();
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
	}*/
   
  

}