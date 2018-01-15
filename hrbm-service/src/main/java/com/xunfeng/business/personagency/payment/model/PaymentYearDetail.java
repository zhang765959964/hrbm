package com.xunfeng.business.personagency.payment.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL Model对象
* @author:user
* @createDate 2016-11-03 16:16:59 
* @version V1.0   
*/
public class PaymentYearDetail extends BaseModel
{
	// 主键
	protected Long  id;
	// 缴费记录Id
	protected Long  recordId;
	// 开始缴费日期
	protected String  fdStartDate;
	// 终止缴费日期
	protected String  fdEndDate;
	// 缴费金额
	protected String  fdPaymentAmount;
	// 缴费月数
	protected Long  fdPaymentMonths;
	// 缴费标准
	protected String  fdPaymentStandard;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setRecordId(Long recordId) 
	{
		this.recordId = recordId;
	}
	/**
	 * 返回 缴费记录Id
	 * @return
	 */
	public Long getRecordId() 
	{
		return this.recordId;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PaymentYearDetail)) 
		{
			return false;
		}
		PaymentYearDetail rhs = (PaymentYearDetail) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.recordId, rhs.recordId)
		.append(this.fdStartDate, rhs.fdStartDate)
		.append(this.fdEndDate, rhs.fdEndDate)
		.append(this.fdPaymentAmount, rhs.fdPaymentAmount)
		.append(this.fdPaymentMonths, rhs.fdPaymentMonths)
		.append(this.fdPaymentStandard, rhs.fdPaymentStandard)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.recordId) 
		.append(this.fdStartDate) 
		.append(this.fdEndDate) 
		.append(this.fdPaymentAmount) 
		.append(this.fdPaymentMonths) 
		.append(this.fdPaymentStandard) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("recordId", this.recordId) 
		.append("fdStartDate", this.fdStartDate) 
		.append("fdEndDate", this.fdEndDate) 
		.append("fdPaymentAmount", this.fdPaymentAmount) 
		.append("fdPaymentMonths", this.fdPaymentMonths) 
		.append("fdPaymentStandard", this.fdPaymentStandard) 
		.toString();
	}
   
  

}