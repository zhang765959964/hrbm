package com.xunfeng.sys.setMeal.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.sys.setMeal.model.FeeOrderMain;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购主表 Form对象
* @author:
* @createDate 2016-07-19 09:18:37 
* @version V1.0   
*/
public class FeeOrderMainForm extends BaseForm<FeeOrderMain>
{
	// 订购流水
	protected Long  orderSn;
	// 单位编号
	protected Long  aab001;
	// 单位名称
	protected String  aab004;
	// 套餐代码，单买填 999999
	protected String  pkgCode;
	// 收费金额
	protected Long  pkgFee;
	// 实收金额
	protected Long  discountFee;
	// 生效时间
	protected java.util.Date  beginDate;
	// 失效时间
	protected java.util.Date  overDate;
	// 有效标识 1 有效,0 无效
	protected String  isValid;
	// 来源
	protected String  cczy06;
	// 经办人
	protected String  aae011;
	// 经办人名称
	protected String  aae019;
	// 经办时间
	protected java.util.Date  aae036;
	// 经办机构代码
	protected String  aae017;
	// 经办机构名称
	protected String  aae020;
	// 备注
	protected String  remark;
	// 有效时长（天）
	protected Long  validDates;
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
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}
	public void setPkgCode(String pkgCode) 
	{
		this.pkgCode = pkgCode;
	}
	/**
	 * 返回 套餐代码，单买填 999999
	 * @return
	 */
	public String getPkgCode() 
	{
		return this.pkgCode;
	}
	public void setPkgFee(Long pkgFee) 
	{
		this.pkgFee = pkgFee;
	}
	/**
	 * 返回 收费金额
	 * @return
	 */
	public Long getPkgFee() 
	{
		return this.pkgFee;
	}
	public void setDiscountFee(Long discountFee) 
	{
		this.discountFee = discountFee;
	}
	/**
	 * 返回 实收金额
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
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 来源
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办时间
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
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
	public void setValidDates(Long validDates) 
	{
		this.validDates = validDates;
	}
	/**
	 * 返回 有效时长（天）
	 * @return
	 */
	public Long getValidDates() 
	{
		return this.validDates;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof FeeOrderMainForm)) 
		{
			return false;
		}
		FeeOrderMainForm rhs = (FeeOrderMainForm) object;
		return new EqualsBuilder()
		.append(this.orderSn, rhs.orderSn)
		.append(this.aab001, rhs.aab001)
		.append(this.aab004, rhs.aab004)
		.append(this.pkgCode, rhs.pkgCode)
		.append(this.pkgFee, rhs.pkgFee)
		.append(this.discountFee, rhs.discountFee)
		.append(this.beginDate, rhs.beginDate)
		.append(this.overDate, rhs.overDate)
		.append(this.isValid, rhs.isValid)
		.append(this.cczy06, rhs.cczy06)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae036, rhs.aae036)
		.append(this.aae017, rhs.aae017)
		.append(this.aae020, rhs.aae020)
		.append(this.remark, rhs.remark)
		.append(this.validDates, rhs.validDates)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.orderSn) 
		.append(this.aab001) 
		.append(this.aab004) 
		.append(this.pkgCode) 
		.append(this.pkgFee) 
		.append(this.discountFee) 
		.append(this.beginDate) 
		.append(this.overDate) 
		.append(this.isValid) 
		.append(this.cczy06) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae036) 
		.append(this.aae017) 
		.append(this.aae020) 
		.append(this.remark) 
		.append(this.validDates) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("orderSn", this.orderSn) 
		.append("aab001", this.aab001) 
		.append("aab004", this.aab004) 
		.append("pkgCode", this.pkgCode) 
		.append("pkgFee", this.pkgFee) 
		.append("discountFee", this.discountFee) 
		.append("beginDate", this.beginDate) 
		.append("overDate", this.overDate) 
		.append("isValid", this.isValid) 
		.append("cczy06", this.cczy06) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae036", this.aae036) 
		.append("aae017", this.aae017) 
		.append("aae020", this.aae020) 
		.append("remark", this.remark) 
		.append("validDates", this.validDates) 
		.toString();
	}
   
  

}