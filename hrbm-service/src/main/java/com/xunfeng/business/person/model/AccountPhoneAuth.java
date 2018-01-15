package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:手机认证表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:44
 */
public class AccountPhoneAuth extends BaseModel
{
	// 手机认证表自动编号
	protected Long  ccpf01;
	// 用户编号
	protected Long  ccmu01;
	// 手机号码
	protected String  ccpf02;
	// 激活码
	protected String  ccpf03;
	// 插入时间
	protected java.util.Date  ccpf04;
	// 认证日期
	protected java.util.Date  ccpf05;
	// 过期日期
	protected java.util.Date  ccpf06;
	// 用途1-认证2-找加密码
	protected Long  ccpf07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setCcpf01(Long ccpf01) 
	{
		this.ccpf01 = ccpf01;
	}
	/**
	 * 返回 手机认证表自动编号
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
	 * 返回 用户编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCcpf02(String ccpf02) 
	{
		this.ccpf02 = ccpf02;
	}
	/**
	 * 返回 手机号码
	 * @return
	 */
	public String getCcpf02() 
	{
		return this.ccpf02;
	}
	public void setCcpf03(String ccpf03) 
	{
		this.ccpf03 = ccpf03;
	}
	/**
	 * 返回 激活码
	 * @return
	 */
	public String getCcpf03() 
	{
		return this.ccpf03;
	}
	public void setCcpf04(java.util.Date ccpf04) 
	{
		this.ccpf04 = ccpf04;
	}
	/**
	 * 返回 插入时间
	 * @return
	 */
	public java.util.Date getCcpf04() 
	{
		return this.ccpf04;
	}
	public void setCcpf05(java.util.Date ccpf05) 
	{
		this.ccpf05 = ccpf05;
	}
	/**
	 * 返回 认证日期
	 * @return
	 */
	public java.util.Date getCcpf05() 
	{
		return this.ccpf05;
	}
	public void setCcpf06(java.util.Date ccpf06) 
	{
		this.ccpf06 = ccpf06;
	}
	/**
	 * 返回 过期日期
	 * @return
	 */
	public java.util.Date getCcpf06() 
	{
		return this.ccpf06;
	}
	public void setCcpf07(Long ccpf07) 
	{
		this.ccpf07 = ccpf07;
	}
	/**
	 * 返回 用途1-认证2-找加密码
	 * @return
	 */
	public Long getCcpf07() 
	{
		return this.ccpf07;
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
		if (!(object instanceof AccountPhoneAuth))
		{
			return false;
		}
		AccountPhoneAuth rhs = (AccountPhoneAuth) object;
		return new EqualsBuilder()
		.append(this.ccpf01, rhs.ccpf01)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.ccpf02, rhs.ccpf02)
		.append(this.ccpf03, rhs.ccpf03)
		.append(this.ccpf04, rhs.ccpf04)
		.append(this.ccpf05, rhs.ccpf05)
		.append(this.ccpf06, rhs.ccpf06)
		.append(this.ccpf07, rhs.ccpf07)
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
		.append(this.ccpf02)
		.append(this.ccpf03)
		.append(this.ccpf04)
		.append(this.ccpf05)
		.append(this.ccpf06)
		.append(this.ccpf07)
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
		.append("ccpf02", this.ccpf02) 
		.append("ccpf03", this.ccpf03) 
		.append("ccpf04", this.ccpf04) 
		.append("ccpf05", this.ccpf05) 
		.append("ccpf06", this.ccpf06) 
		.append("ccpf07", this.ccpf07) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}