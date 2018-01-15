package com.xunfeng.business.personagency.payment.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.business.personagency.payment.enumeration.RefundStatus;
import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND Model对象
* @author:wanghan
* @createDate 2016-08-17 16:06:42 
* @version V1.0   
*/
public class PaymentRefund extends BaseModel
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
	// 退费日期
	protected java.util.Date  fdRefundDate;
	// 退费开始日期
	protected String  fdRefundStartDate;
	// 退费结束日期
	protected String  fdRefundEndDate;
	// 是否返还
	protected RefundStatus  fdRefundIsRefund;
	// 调出日期
	protected java.util.Date  fdRefundLendDate;
	// 退费原因
	protected String  fdRefundReason;
	// 备注
	protected String  fdRefundDesc;
	// 退费月数
	protected Long  fdRefundMonths;
	// 退费标准
	protected String  fdRefundStandard;
	// 退费金额
	protected String  fdRefundAmount;
	// 缴费记录Id
	protected Long  fkPaymentId;
	// 确认人Id
	protected Long  fkConfirmsId;
	// 确认人名称
	protected String  fdConfirmsName;
	// 确认日期
	protected java.util.Date  fdConfirmsDate;
	// 确认机构Id
	protected Long  fdConfirmsOrgId;
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
	public void setPkPersonId(Long pkPersonId) 
	{
		this.pkPersonId = pkPersonId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getPkPersonId() 
	{
		return this.pkPersonId;
	}
	public void setFkCreaterId(Long fkCreaterId) 
	{
		this.fkCreaterId = fkCreaterId;
	}
	/**
	 * 返回 经办人员ID
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
	 * 返回 经办人员名称
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
	 * 返回 经办机构Id
	 * @return
	 */
	public Long getFkCreaterOrgId() 
	{
		return this.fkCreaterOrgId;
	}
	public void setFdRefundDate(java.util.Date fdRefundDate) 
	{
		this.fdRefundDate = fdRefundDate;
	}
	/**
	 * 返回 退费日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdRefundDate() 
	{
		return this.fdRefundDate;
	}
	public void setFdRefundStartDate(String fdRefundStartDate) 
	{
		this.fdRefundStartDate = fdRefundStartDate;
	}
	/**
	 * 返回 退费开始日期
	 * @return
	 */
	public String getFdRefundStartDate() 
	{
		return this.fdRefundStartDate;
	}
	public void setFdRefundEndDate(String fdRefundEndDate) 
	{
		this.fdRefundEndDate = fdRefundEndDate;
	}
	/**
	 * 返回 退费结束日期
	 * @return
	 */
	public String getFdRefundEndDate() 
	{
		return this.fdRefundEndDate;
	}

	public RefundStatus getFdRefundIsRefund() {
		return fdRefundIsRefund;
	}
	public void setFdRefundIsRefund(RefundStatus fdRefundIsRefund) {
		this.fdRefundIsRefund = fdRefundIsRefund;
	}
	public void setFdRefundLendDate(java.util.Date fdRefundLendDate) 
	{
		this.fdRefundLendDate = fdRefundLendDate;
	}
	/**
	 * 返回 调出日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdRefundLendDate() 
	{
		return this.fdRefundLendDate;
	}
	public void setFdRefundReason(String fdRefundReason) 
	{
		this.fdRefundReason = fdRefundReason;
	}
	/**
	 * 返回 退费原因
	 * @return
	 */
	public String getFdRefundReason() 
	{
		return this.fdRefundReason;
	}
	public void setFdRefundDesc(String fdRefundDesc) 
	{
		this.fdRefundDesc = fdRefundDesc;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getFdRefundDesc() 
	{
		return this.fdRefundDesc;
	}
	public void setFdRefundMonths(Long fdRefundMonths) 
	{
		this.fdRefundMonths = fdRefundMonths;
	}
	/**
	 * 返回 退费月数
	 * @return
	 */
	public Long getFdRefundMonths() 
	{
		return this.fdRefundMonths;
	}
	public void setFdRefundStandard(String fdRefundStandard) 
	{
		this.fdRefundStandard = fdRefundStandard;
	}
	/**
	 * 返回 退费标准
	 * @return
	 */
	public String getFdRefundStandard() 
	{
		return this.fdRefundStandard;
	}
	public void setFdRefundAmount(String fdRefundAmount) 
	{
		this.fdRefundAmount = fdRefundAmount;
	}
	/**
	 * 返回 退费金额
	 * @return
	 */
	public String getFdRefundAmount() 
	{
		return this.fdRefundAmount;
	}
	public void setFkPaymentId(Long fkPaymentId) 
	{
		this.fkPaymentId = fkPaymentId;
	}
	/**
	 * 返回 缴费记录Id
	 * @return
	 */
	public Long getFkPaymentId() 
	{
		return this.fkPaymentId;
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
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdConfirmsDate() 
	{
		return this.fdConfirmsDate;
	}
	public void setFdConfirmsOrgId(Long fdConfirmsOrgId) 
	{
		this.fdConfirmsOrgId = fdConfirmsOrgId;
	}
	/**
	 * 返回 确认机构Id
	 * @return
	 */
	public Long getFdConfirmsOrgId() 
	{
		return this.fdConfirmsOrgId;
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
		if (!(object instanceof PaymentRefund)) 
		{
			return false;
		}
		PaymentRefund rhs = (PaymentRefund) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.pkPersonId, rhs.pkPersonId)
		.append(this.fkCreaterId, rhs.fkCreaterId)
		.append(this.fdCreaterName, rhs.fdCreaterName)
		.append(this.fdCreaterDate, rhs.fdCreaterDate)
		.append(this.fdCreaterOrgName, rhs.fdCreaterOrgName)
		.append(this.fkCreaterOrgId, rhs.fkCreaterOrgId)
		.append(this.fdRefundDate, rhs.fdRefundDate)
		.append(this.fdRefundStartDate, rhs.fdRefundStartDate)
		.append(this.fdRefundEndDate, rhs.fdRefundEndDate)
		.append(this.fdRefundIsRefund, rhs.fdRefundIsRefund)
		.append(this.fdRefundLendDate, rhs.fdRefundLendDate)
		.append(this.fdRefundReason, rhs.fdRefundReason)
		.append(this.fdRefundDesc, rhs.fdRefundDesc)
		.append(this.fdRefundMonths, rhs.fdRefundMonths)
		.append(this.fdRefundStandard, rhs.fdRefundStandard)
		.append(this.fdRefundAmount, rhs.fdRefundAmount)
		.append(this.fkPaymentId, rhs.fkPaymentId)
		.append(this.fkConfirmsId, rhs.fkConfirmsId)
		.append(this.fdConfirmsName, rhs.fdConfirmsName)
		.append(this.fdConfirmsDate, rhs.fdConfirmsDate)
		.append(this.fdConfirmsOrgId, rhs.fdConfirmsOrgId)
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
		.append(this.pkPersonId) 
		.append(this.fkCreaterId) 
		.append(this.fdCreaterName) 
		.append(this.fdCreaterDate) 
		.append(this.fdCreaterOrgName) 
		.append(this.fkCreaterOrgId) 
		.append(this.fdRefundDate) 
		.append(this.fdRefundStartDate) 
		.append(this.fdRefundEndDate) 
		.append(this.fdRefundIsRefund) 
		.append(this.fdRefundLendDate) 
		.append(this.fdRefundReason) 
		.append(this.fdRefundDesc) 
		.append(this.fdRefundMonths) 
		.append(this.fdRefundStandard) 
		.append(this.fdRefundAmount) 
		.append(this.fkPaymentId) 
		.append(this.fkConfirmsId) 
		.append(this.fdConfirmsName) 
		.append(this.fdConfirmsDate) 
		.append(this.fdConfirmsOrgId) 
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
		.append("pkPersonId", this.pkPersonId) 
		.append("fkCreaterId", this.fkCreaterId) 
		.append("fdCreaterName", this.fdCreaterName) 
		.append("fdCreaterDate", this.fdCreaterDate) 
		.append("fdCreaterOrgName", this.fdCreaterOrgName) 
		.append("fkCreaterOrgId", this.fkCreaterOrgId) 
		.append("fdRefundDate", this.fdRefundDate) 
		.append("fdRefundStartDate", this.fdRefundStartDate) 
		.append("fdRefundEndDate", this.fdRefundEndDate) 
		.append("fdRefundIsRefund", this.fdRefundIsRefund) 
		.append("fdRefundLendDate", this.fdRefundLendDate) 
		.append("fdRefundReason", this.fdRefundReason) 
		.append("fdRefundDesc", this.fdRefundDesc) 
		.append("fdRefundMonths", this.fdRefundMonths) 
		.append("fdRefundStandard", this.fdRefundStandard) 
		.append("fdRefundAmount", this.fdRefundAmount) 
		.append("fkPaymentId", this.fkPaymentId) 
		.append("fkConfirmsId", this.fkConfirmsId) 
		.append("fdConfirmsName", this.fdConfirmsName) 
		.append("fdConfirmsDate", this.fdConfirmsDate) 
		.append("fdConfirmsOrgId", this.fdConfirmsOrgId) 
		.append("fdConfirmsOrgName", this.fdConfirmsOrgName) 
		.toString();
	}
   
  

}