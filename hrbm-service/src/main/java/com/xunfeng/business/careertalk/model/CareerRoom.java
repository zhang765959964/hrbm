package com.xunfeng.business.careertalk.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会教室 Model对象
* @author:zhouhang
* @createDate 2015-09-21 09:49:15 
* @version V1.0   
*/
public class CareerRoom implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9153583117293023448L;
	// 主键
	protected Long  crId;
	// 教室名称
	protected String  crName;
	// 教室地址
	protected String  crAddress;
	// 最大容纳人数
	protected Long  crMaxPeople;
	// 描述
	protected String  crDesc;
	// 状态
	protected Long  crStatus;
	// 创建时间
	protected java.util.Date  crCreatetime;
	// 最终修改时间
	protected java.util.Date  crUpdatetime;
	// 创建人
	protected Long  crCreateBy;
	// 最终修改人
	protected Long  crUpdateBy;
	public void setCrId(Long crId) 
	{
		this.crId = crId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getCrId() 
	{
		return this.crId;
	}
	public void setCrName(String crName) 
	{
		this.crName = crName;
	}
	/**
	 * 返回 教室名称
	 * @return
	 */
	public String getCrName() 
	{
		return this.crName;
	}
	public void setCrAddress(String crAddress) 
	{
		this.crAddress = crAddress;
	}
	/**
	 * 返回 教室地址
	 * @return
	 */
	public String getCrAddress() 
	{
		return this.crAddress;
	}
	public void setCrMaxPeople(Long crMaxPeople) 
	{
		this.crMaxPeople = crMaxPeople;
	}
	/**
	 * 返回 最大容纳人数
	 * @return
	 */
	public Long getCrMaxPeople() 
	{
		return this.crMaxPeople;
	}
	public void setCrDesc(String crDesc) 
	{
		this.crDesc = crDesc;
	}
	/**
	 * 返回 描述
	 * @return
	 */
	public String getCrDesc() 
	{
		return this.crDesc;
	}
	public void setCrStatus(Long crStatus) 
	{
		this.crStatus = crStatus;
	}
	/**
	 * 返回 状态
	 * @return
	 */
	public Long getCrStatus() 
	{
		return this.crStatus;
	}
	public void setCrCreatetime(java.util.Date crCreatetime) 
	{
		this.crCreatetime = crCreatetime;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getCrCreatetime() 
	{
		return this.crCreatetime;
	}
	public void setCrUpdatetime(java.util.Date crUpdatetime) 
	{
		this.crUpdatetime = crUpdatetime;
	}
	/**
	 * 返回 最终修改时间
	 * @return
	 */
	public java.util.Date getCrUpdatetime() 
	{
		return this.crUpdatetime;
	}
	public void setCrCreateBy(Long crCreateBy) 
	{
		this.crCreateBy = crCreateBy;
	}
	/**
	 * 返回 创建人
	 * @return
	 */
	public Long getCrCreateBy() 
	{
		return this.crCreateBy;
	}
	public void setCrUpdateBy(Long crUpdateBy) 
	{
		this.crUpdateBy = crUpdateBy;
	}
	/**
	 * 返回 最终修改人
	 * @return
	 */
	public Long getCrUpdateBy() 
	{
		return this.crUpdateBy;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof CareerRoom))
		{
			return false;
		}
		CareerRoom rhs = (CareerRoom) object;
		return new EqualsBuilder()
		.append(this.crId, rhs.crId)
		.append(this.crName, rhs.crName)
		.append(this.crAddress, rhs.crAddress)
		.append(this.crMaxPeople, rhs.crMaxPeople)
		.append(this.crDesc, rhs.crDesc)
		.append(this.crStatus, rhs.crStatus)
		.append(this.crCreatetime, rhs.crCreatetime)
		.append(this.crUpdatetime, rhs.crUpdatetime)
		.append(this.crCreateBy, rhs.crCreateBy)
		.append(this.crUpdateBy, rhs.crUpdateBy)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.crId)
		.append(this.crName)
		.append(this.crAddress)
		.append(this.crMaxPeople)
		.append(this.crDesc)
		.append(this.crStatus)
		.append(this.crCreatetime)
		.append(this.crUpdatetime)
		.append(this.crCreateBy)
		.append(this.crUpdateBy)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("crId", this.crId) 
		.append("crName", this.crName) 
		.append("crAddress", this.crAddress) 
		.append("crMaxPeople", this.crMaxPeople) 
		.append("crDesc", this.crDesc) 
		.append("crStatus", this.crStatus) 
		.append("crCreatetime", this.crCreatetime) 
		.append("crUpdatetime", this.crUpdatetime) 
		.append("crCreateBy", this.crCreateBy) 
		.append("crUpdateBy", this.crUpdateBy) 
		.toString();
	}
   
  

}