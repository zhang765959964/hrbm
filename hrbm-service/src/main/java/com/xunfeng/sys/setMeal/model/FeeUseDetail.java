package com.xunfeng.sys.setMeal.model;
import java.util.Date;

import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 消费使用流水表 Model对象
* @author:
* @createDate 2016-07-19 09:22:45 
* @version V1.0   
*/
public class FeeUseDetail extends BaseModel
{
	// 使用流水
	protected Long  useSn;
	// 订购流水
	protected Long  orderSn;
	// 订购详单流水
	protected Long  detailSn;
	// 单位编号
	protected Long  aab001;
	// 单位名称
	protected String  aab004;
	// 细项编号
	protected String  servCode;
	// 使用数量
	protected Long  useCount;
	// 消费业务  可以自定义业务编码存入该字段，方便统计
	protected String  consumeCode;
	// 消费说明
	protected String  consumeRemark;
	// 来源
	protected String  cczy06;
	// 有效标识 1 有效,0 无效
	protected String  isValid;
	// 经办人
	protected String  aae011;
	// 经办人名称
	protected String  aae019;
	// 经办时间
	protected java.util.Date aae036;
	// 经办机构代码
	protected String  aae017;
	// 经办机构名称
	protected String  aae020;
	// 备注
	protected String  remark;
	public void setUseSn(Long useSn) 
	{
		this.useSn = useSn;
	}
	/**
	 * 返回 使用流水
	 * @return
	 */
	public Long getUseSn() 
	{
		return this.useSn;
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
	public void setDetailSn(Long detailSn) 
	{
		this.detailSn = detailSn;
	}
	/**
	 * 返回 订购详单流水
	 * @return
	 */
	public Long getDetailSn() 
	{
		return this.detailSn;
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
	public void setServCode(String servCode) 
	{
		this.servCode = servCode;
	}
	/**
	 * 返回 细项编号
	 * @return
	 */
	public String getServCode() 
	{
		return this.servCode;
	}
	public void setUseCount(Long useCount) 
	{
		this.useCount = useCount;
	}
	/**
	 * 返回 使用数量
	 * @return
	 */
	public Long getUseCount() 
	{
		return this.useCount;
	}
	public void setConsumeCode(String consumeCode) 
	{
		this.consumeCode = consumeCode;
	}
	/**
	 * 返回 消费业务  可以自定义业务编码存入该字段，方便统计
	 * @return
	 */
	public String getConsumeCode() 
	{
		return this.consumeCode;
	}
	public void setConsumeRemark(String consumeRemark) 
	{
		this.consumeRemark = consumeRemark;
	}
	/**
	 * 返回 消费说明
	 * @return
	 */
	public String getConsumeRemark() 
	{
		return this.consumeRemark;
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
	public void setAae036(Date aae036) 
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
		if (!(object instanceof FeeUseDetail)) 
		{
			return false;
		}
		FeeUseDetail rhs = (FeeUseDetail) object;
		return new EqualsBuilder()
		.append(this.useSn, rhs.useSn)
		.append(this.orderSn, rhs.orderSn)
		.append(this.detailSn, rhs.detailSn)
		.append(this.aab001, rhs.aab001)
		.append(this.aab004, rhs.aab004)
		.append(this.servCode, rhs.servCode)
		.append(this.useCount, rhs.useCount)
		.append(this.consumeCode, rhs.consumeCode)
		.append(this.consumeRemark, rhs.consumeRemark)
		.append(this.cczy06, rhs.cczy06)
		.append(this.isValid, rhs.isValid)
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
		.append(this.useSn) 
		.append(this.orderSn) 
		.append(this.detailSn) 
		.append(this.aab001) 
		.append(this.aab004) 
		.append(this.servCode) 
		.append(this.useCount) 
		.append(this.consumeCode) 
		.append(this.consumeRemark) 
		.append(this.cczy06) 
		.append(this.isValid) 
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
		.append("useSn", this.useSn) 
		.append("orderSn", this.orderSn) 
		.append("detailSn", this.detailSn) 
		.append("aab001", this.aab001) 
		.append("aab004", this.aab004) 
		.append("servCode", this.servCode) 
		.append("useCount", this.useCount) 
		.append("consumeCode", this.consumeCode) 
		.append("consumeRemark", this.consumeRemark) 
		.append("cczy06", this.cczy06) 
		.append("isValid", this.isValid) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae036", this.aae036) 
		.append("aae017", this.aae017) 
		.append("aae020", this.aae020) 
		.append("remark", this.remark) 
		.toString();
	}
   
  

}