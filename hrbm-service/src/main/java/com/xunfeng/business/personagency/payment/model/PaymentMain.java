package com.xunfeng.business.personagency.payment.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_MAIN Model对象
* @author:wanghan
* @createDate 2016-09-01 10:57:44 
* @version V1.0   
*/
public class PaymentMain extends BaseModel
{
	// 主键
	protected Long  pkId;
	// 人员ID
	protected Long  fkPersonid;
	// 开始缴费月份
	protected String  fdStartPaymentDate;
	// 终止缴费月份
	protected String  fdEndPaymentDate;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFkPersonid(Long fkPersonid) 
	{
		this.fkPersonid = fkPersonid;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getFkPersonid() 
	{
		return this.fkPersonid;
	}
	public void setFdStartPaymentDate(String fdStartPaymentDate) 
	{
		this.fdStartPaymentDate = fdStartPaymentDate;
	}
	/**
	 * 返回 开始缴费月份
	 * @return
	 */
	public String getFdStartPaymentDate() 
	{
		return this.fdStartPaymentDate;
	}
	public void setFdEndPaymentDate(String fdEndPaymentDate) 
	{
		this.fdEndPaymentDate = fdEndPaymentDate;
	}
	/**
	 * 返回 终止缴费月份
	 * @return
	 */
	public String getFdEndPaymentDate() 
	{
		return this.fdEndPaymentDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PaymentMain)) 
		{
			return false;
		}
		PaymentMain rhs = (PaymentMain) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fkPersonid, rhs.fkPersonid)
		.append(this.fdStartPaymentDate, rhs.fdStartPaymentDate)
		.append(this.fdEndPaymentDate, rhs.fdEndPaymentDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fkPersonid) 
		.append(this.fdStartPaymentDate) 
		.append(this.fdEndPaymentDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fkPersonid", this.fkPersonid) 
		.append("fdStartPaymentDate", this.fdStartPaymentDate) 
		.append("fdEndPaymentDate", this.fdEndPaymentDate) 
		.toString();
	}
   
  

}