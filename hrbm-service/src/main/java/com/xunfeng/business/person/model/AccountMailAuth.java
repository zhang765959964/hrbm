package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:邮件认证表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:27
 */
public class AccountMailAuth extends BaseModel
{
	// 邮件认证表自动编号
	protected Long  ccpe01;
	// 用户编号
	protected Long  ccmu01;
	// 邮件地址
	protected String  ccpe02;
	// 激活码
	protected String  ccpe03;
	// 插入时间
	protected java.util.Date  ccpe04;
	// 认证日期
	protected java.util.Date  ccpe05;
	// 过期时间
	protected java.util.Date  ccpe06;
	// 用途1-认证2-找加密码
	protected Long  ccpe07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setCcpe01(Long ccpe01) 
	{
		this.ccpe01 = ccpe01;
	}
	/**
	 * 返回 邮件认证表自动编号
	 * @return
	 */
	public Long getCcpe01() 
	{
		return this.ccpe01;
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
	public void setCcpe02(String ccpe02) 
	{
		this.ccpe02 = ccpe02;
	}
	/**
	 * 返回 邮件地址
	 * @return
	 */
	public String getCcpe02() 
	{
		return this.ccpe02;
	}
	public void setCcpe03(String ccpe03) 
	{
		this.ccpe03 = ccpe03;
	}
	/**
	 * 返回 激活码
	 * @return
	 */
	public String getCcpe03() 
	{
		return this.ccpe03;
	}
	public void setCcpe04(java.util.Date ccpe04) 
	{
		this.ccpe04 = ccpe04;
	}
	/**
	 * 返回 插入时间
	 * @return
	 */
	public java.util.Date getCcpe04() 
	{
		return this.ccpe04;
	}
	public void setCcpe05(java.util.Date ccpe05) 
	{
		this.ccpe05 = ccpe05;
	}
	/**
	 * 返回 认证日期
	 * @return
	 */
	public java.util.Date getCcpe05() 
	{
		return this.ccpe05;
	}
	public void setCcpe06(java.util.Date ccpe06) 
	{
		this.ccpe06 = ccpe06;
	}
	/**
	 * 返回 过期时间
	 * @return
	 */
	public java.util.Date getCcpe06() 
	{
		return this.ccpe06;
	}
	public void setCcpe07(Long ccpe07) 
	{
		this.ccpe07 = ccpe07;
	}
	/**
	 * 返回 用途1-认证2-找加密码
	 * @return
	 */
	public Long getCcpe07() 
	{
		return this.ccpe07;
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
		if (!(object instanceof AccountMailAuth))
		{
			return false;
		}
		AccountMailAuth rhs = (AccountMailAuth) object;
		return new EqualsBuilder()
		.append(this.ccpe01, rhs.ccpe01)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.ccpe02, rhs.ccpe02)
		.append(this.ccpe03, rhs.ccpe03)
		.append(this.ccpe04, rhs.ccpe04)
		.append(this.ccpe05, rhs.ccpe05)
		.append(this.ccpe06, rhs.ccpe06)
		.append(this.ccpe07, rhs.ccpe07)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccpe01)
		.append(this.ccmu01)
		.append(this.ccpe02)
		.append(this.ccpe03)
		.append(this.ccpe04)
		.append(this.ccpe05)
		.append(this.ccpe06)
		.append(this.ccpe07)
		.append(this.ccpr08)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccpe01", this.ccpe01) 
		.append("ccmu01", this.ccmu01) 
		.append("ccpe02", this.ccpe02) 
		.append("ccpe03", this.ccpe03) 
		.append("ccpe04", this.ccpe04) 
		.append("ccpe05", this.ccpe05) 
		.append("ccpe06", this.ccpe06) 
		.append("ccpe07", this.ccpe07) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}