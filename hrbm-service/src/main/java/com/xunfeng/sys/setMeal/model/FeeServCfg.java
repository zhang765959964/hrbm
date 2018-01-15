package com.xunfeng.sys.setMeal.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 服务细项表 Model对象
* @author:wangyanyan
* @createDate 2016-07-19 09:11:01 
* @version V1.0   
*/
public class FeeServCfg extends BaseModel
{
	// 细项代码
	protected String  servCode;
	// 细项名称
	protected String  servName;
	// 单价
	protected Long  servFee;
	// 有效标识 1 有效,0 无效
	protected String  isValid;
	// 有效时长（天）
	protected Long  validDates;
	// 单项购买标识 1 是,0 否
	protected String  isSingle;
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
	public void setServName(String servName) 
	{
		this.servName = servName;
	}
	/**
	 * 返回 细项名称
	 * @return
	 */
	public String getServName() 
	{
		return this.servName;
	}
	public void setServFee(Long servFee) 
	{
		this.servFee = servFee;
	}
	/**
	 * 返回 单价
	 * @return
	 */
	public Long getServFee() 
	{
		return this.servFee;
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
	public void setIsSingle(String isSingle) 
	{
		this.isSingle = isSingle;
	}
	/**
	 * 返回 单项购买标识 1 是,0 否
	 * @return
	 */
	public String getIsSingle() 
	{
		return this.isSingle;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof FeeServCfg)) 
		{
			return false;
		}
		FeeServCfg rhs = (FeeServCfg) object;
		return new EqualsBuilder()
		.append(this.servCode, rhs.servCode)
		.append(this.servName, rhs.servName)
		.append(this.servFee, rhs.servFee)
		.append(this.isValid, rhs.isValid)
		.append(this.validDates, rhs.validDates)
		.append(this.isSingle, rhs.isSingle)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae036, rhs.aae036)
		.append(this.aae017, rhs.aae017)
		.append(this.aae020, rhs.aae020)
		.append(this.remark, rhs.remark)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.servCode) 
		.append(this.servName) 
		.append(this.servFee) 
		.append(this.isValid) 
		.append(this.validDates) 
		.append(this.isSingle) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae036) 
		.append(this.aae017) 
		.append(this.aae020) 
		.append(this.remark) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("servCode", this.servCode) 
		.append("servName", this.servName) 
		.append("servFee", this.servFee) 
		.append("isValid", this.isValid) 
		.append("validDates", this.validDates) 
		.append("isSingle", this.isSingle) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae036", this.aae036) 
		.append("aae017", this.aae017) 
		.append("aae020", this.aae020) 
		.append("remark", this.remark) 
		.toString();
	}
   
  

}