package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:个人职位收藏夹 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:28
 */
public class JobCollect extends BaseModel
{
	// 个人职位收藏夹自动编号
	protected Long  ccpf01;
	// 用户信息表自动编号
	protected Long  ccmu01;
	// 职位编号
	protected Long  acb210;
	// 收藏时间
	protected java.util.Date  ccpf02;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setCcpf01(Long ccpf01) 
	{
		this.ccpf01 = ccpf01;
	}
	/**
	 * 返回 个人职位收藏夹自动编号
	 * @return
	 */
	public Long getCcpf01() 
	{
		return this.ccpf01;
	}
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 用户信息表自动编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setAcb210(Long acb210) 
	{
		this.acb210 = acb210;
	}
	/**
	 * 返回 职位编号
	 * @return
	 */
	public Long getAcb210() 
	{
		return this.acb210;
	}
	public void setCcpf02(java.util.Date ccpf02) 
	{
		this.ccpf02 = ccpf02;
	}
	/**
	 * 返回 收藏时间
	 * @return
	 */
	public java.util.Date getCcpf02() 
	{
		return this.ccpf02;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof JobCollect))
		{
			return false;
		}
		JobCollect rhs = (JobCollect) object;
		return new EqualsBuilder()
		.append(this.ccpf01, rhs.ccpf01)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.acb210, rhs.acb210)
		.append(this.ccpf02, rhs.ccpf02)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccpf01)
		.append(this.ccmu01)
		.append(this.acb210)
		.append(this.ccpf02)
		.append(this.ccpr08)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccpf01", this.ccpf01) 
		.append("ccmu01", this.ccmu01) 
		.append("acb210", this.acb210) 
		.append("ccpf02", this.ccpf02) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}