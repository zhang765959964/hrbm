package com.xunfeng.business.careertalk.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会教师时间段划分表 Model对象
* @author:zhouhang
* @createDate 2015-09-21 09:49:15 
* @version V1.0   
*/
public class CareerTimeBucket implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5878178674816162991L;
	// 主键
	protected Long  ctbId;
	// 外键ID
	protected Long  crId;
	// 开始时间
	protected String  ctbStarttime;
	// 结束时间
	protected String  ctbEndtime;
	// 周几
	protected String ctbWeekday;
	
	public String getCtbWeekday() {
		return ctbWeekday;
	}
	public void setCtbWeekday(String ctbWeekday) {
		this.ctbWeekday = ctbWeekday;
	}
	public void setCtbId(Long ctbId) 
	{
		this.ctbId = ctbId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getCtbId() 
	{
		return this.ctbId;
	}
	public void setCrId(Long crId) 
	{
		this.crId = crId;
	}
	/**
	 * 返回 外键ID
	 * @return
	 */
	public Long getCrId() 
	{
		return this.crId;
	}
	

   	public String getCtbStarttime() {
		return ctbStarttime;
	}
	public void setCtbStarttime(String ctbStarttime) {
		this.ctbStarttime = ctbStarttime;
	}
	public String getCtbEndtime() {
		return ctbEndtime;
	}
	public void setCtbEndtime(String ctbEndtime) {
		this.ctbEndtime = ctbEndtime;
	}
	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof CareerTimeBucket))
		{
			return false;
		}
		CareerTimeBucket rhs = (CareerTimeBucket) object;
		return new EqualsBuilder()
		.append(this.ctbId, rhs.ctbId)
		.append(this.crId, rhs.crId)
		.append(this.ctbStarttime, rhs.ctbStarttime)
		.append(this.ctbEndtime, rhs.ctbEndtime)
		.append(this.ctbWeekday, rhs.ctbWeekday)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ctbId)
		.append(this.crId)
		.append(this.ctbStarttime)
		.append(this.ctbEndtime)
		.append(this.ctbWeekday)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ctbId", this.ctbId) 
		.append("crId", this.crId) 
		.append("ctbStarttime", this.ctbStarttime) 
		.append("ctbEndtime", this.ctbEndtime) 
		.append("ctbWeekday", this.ctbWeekday) 
		.toString();
	}
   
  

}