package com.xunfeng.sys.setMeal.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购详表 Model对象
* @author:
* @createDate 2016-07-19 09:19:03 
* @version V1.0   
*/
public class FeeOrderDetail extends BaseModel
{
	// 详单流水
	protected Long  detailSn;
	// 订购流水
	protected Long  orderSn;
	// 细项代码
	protected String  servCode;
	// 数量
	protected Long  servCount;
	// 剩余数量
	protected Long  restCount;
	// 费用
	protected Long  servFee;
	// 折后费用
	protected Long  discountFee;
	// 生效时间
	protected java.util.Date  beginDate;
	// 失效时间
	protected java.util.Date  overDate;
	// 有效标识 1 有效,0 无效
	protected String  isValid;
	// 备注
	protected String  remark;
	public void setDetailSn(Long detailSn) 
	{
		this.detailSn = detailSn;
	}
	/**
	 * 返回 详单流水
	 * @return
	 */
	public Long getDetailSn() 
	{
		return this.detailSn;
	}
	public void setOrderSn(Long orderSn) 
	{
		this.orderSn = orderSn;
	}
	/**
	 * 返回 订购流水
	 * @return
	 */
	public Long getOrderSn() 
	{
		return this.orderSn;
	}
	public void setServCode(String servCode) 
	{
		this.servCode = servCode;
	}
	/**
	 * 返回 细项代码
	 * @return
	 */
	public String getServCode() 
	{
		return this.servCode;
	}
	public void setServCount(Long servCount) 
	{
		this.servCount = servCount;
	}
	/**
	 * 返回 数量
	 * @return
	 */
	public Long getServCount() 
	{
		return this.servCount;
	}
	public void setRestCount(Long restCount) 
	{
		this.restCount = restCount;
	}
	/**
	 * 返回 剩余数量
	 * @return
	 */
	public Long getRestCount() 
	{
		return this.restCount;
	}
	public void setServFee(Long servFee) 
	{
		this.servFee = servFee;
	}
	/**
	 * 返回 费用
	 * @return
	 */
	public Long getServFee() 
	{
		return this.servFee;
	}
	public void setDiscountFee(Long discountFee) 
	{
		this.discountFee = discountFee;
	}
	/**
	 * 返回 折后费用
	 * @return
	 */
	public Long getDiscountFee() 
	{
		return this.discountFee;
	}
	public void setBeginDate(java.util.Date beginDate) 
	{
		this.beginDate = beginDate;
	}
	/**
	 * 返回 生效时间
	 * @return
	 */
	public java.util.Date getBeginDate() 
	{
		return this.beginDate;
	}
	public void setOverDate(java.util.Date overDate) 
	{
		this.overDate = overDate;
	}
	/**
	 * 返回 失效时间
	 * @return
	 */
	public java.util.Date getOverDate() 
	{
		return this.overDate;
	}
	public void setIsValid(String isValid) 
	{
		this.isValid = isValid;
	}
	/**
	 * 返回 有效标识 1 有效,0 无效
	 * @return
	 */
	public String getIsValid() 
	{
		return this.isValid;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getRemark() 
	{
		return this.remark;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof FeeOrderDetail)) 
		{
			return false;
		}
		FeeOrderDetail rhs = (FeeOrderDetail) object;
		return new EqualsBuilder()
		.append(this.detailSn, rhs.detailSn)
		.append(this.orderSn, rhs.orderSn)
		.append(this.servCode, rhs.servCode)
		.append(this.servCount, rhs.servCount)
		.append(this.restCount, rhs.restCount)
		.append(this.servFee, rhs.servFee)
		.append(this.discountFee, rhs.discountFee)
		.append(this.beginDate, rhs.beginDate)
		.append(this.overDate, rhs.overDate)
		.append(this.isValid, rhs.isValid)
		.append(this.remark, rhs.remark)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.detailSn) 
		.append(this.orderSn) 
		.append(this.servCode) 
		.append(this.servCount) 
		.append(this.restCount) 
		.append(this.servFee) 
		.append(this.discountFee) 
		.append(this.beginDate) 
		.append(this.overDate) 
		.append(this.isValid) 
		.append(this.remark) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("detailSn", this.detailSn) 
		.append("orderSn", this.orderSn) 
		.append("servCode", this.servCode) 
		.append("servCount", this.servCount) 
		.append("restCount", this.restCount) 
		.append("servFee", this.servFee) 
		.append("discountFee", this.discountFee) 
		.append("beginDate", this.beginDate) 
		.append("overDate", this.overDate) 
		.append("isValid", this.isValid) 
		.append("remark", this.remark) 
		.toString();
	}
   
  

}