package com.xunfeng.sys.message.model;

import com.xunfeng.core.json.JsonDateMMSerializer;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 对象功能:站内信表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:03:04
 */
public class AccountMessage extends BaseModel
{
	// 站内信编号
	protected Long  ccmc01;
	// 发件人会员编号（0-系统发送）
	protected Long  ccms01;
	// 标题
	protected String  ccmc02;
	// 内容
	protected String  ccmc03;
	// 发件时间
	protected java.util.Date  ccmc04;
	// 收件人会员编号
	protected Long  ccmr01;
	// 是否查看（0-未查看1-已查看）
	protected String  ccmc05;
	public void setCcmc01(Long ccmc01) 
	{
		this.ccmc01 = ccmc01;
	}
	/**
	 * 返回 站内信编号
	 * @return
	 */
	public Long getCcmc01() 
	{
		return this.ccmc01;
	}
	public void setCcms01(Long ccms01) 
	{
		this.ccms01 = ccms01;
	}
	/**
	 * 返回 发件人会员编号（0-系统发送）
	 * @return
	 */
	public Long getCcms01() 
	{
		return this.ccms01;
	}
	public void setCcmc02(String ccmc02) 
	{
		this.ccmc02 = ccmc02;
	}
	/**
	 * 返回 标题
	 * @return
	 */
	public String getCcmc02() 
	{
		return this.ccmc02;
	}
	public void setCcmc03(String ccmc03) 
	{
		this.ccmc03 = ccmc03;
	}
	/**
	 * 返回 内容
	 * @return
	 */
	public String getCcmc03() 
	{
		return this.ccmc03;
	}
	public void setCcmc04(java.util.Date ccmc04) 
	{
		this.ccmc04 = ccmc04;
	}
	/**
	 * 返回 发件时间
	 * @return
	 */
	@JsonSerialize(using = JsonDateMMSerializer.class)
	public java.util.Date getCcmc04() 
	{
		return this.ccmc04;
	}
	public void setCcmr01(Long ccmr01) 
	{
		this.ccmr01 = ccmr01;
	}
	/**
	 * 返回 收件人会员编号
	 * @return
	 */
	public Long getCcmr01() 
	{
		return this.ccmr01;
	}
	public void setCcmc05(String ccmc05) 
	{
		this.ccmc05 = ccmc05;
	}
	/**
	 * 返回 是否查看（0-未查看1-已查看）
	 * @return
	 */
	public String getCcmc05() 
	{
		return this.ccmc05;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof AccountMessage))
		{
			return false;
		}
		AccountMessage rhs = (AccountMessage) object;
		return new EqualsBuilder()
		.append(this.ccmc01, rhs.ccmc01)
		.append(this.ccms01, rhs.ccms01)
		.append(this.ccmc02, rhs.ccmc02)
		.append(this.ccmc03, rhs.ccmc03)
		.append(this.ccmc04, rhs.ccmc04)
		.append(this.ccmr01, rhs.ccmr01)
		.append(this.ccmc05, rhs.ccmc05)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccmc01)
		.append(this.ccms01)
		.append(this.ccmc02)
		.append(this.ccmc03)
		.append(this.ccmc04)
		.append(this.ccmr01)
		.append(this.ccmc05)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccmc01", this.ccmc01) 
		.append("ccms01", this.ccms01) 
		.append("ccmc02", this.ccmc02) 
		.append("ccmc03", this.ccmc03) 
		.append("ccmc04", this.ccmc04) 
		.append("ccmr01", this.ccmr01) 
		.append("ccmc05", this.ccmc05) 
		.toString();
	}
   
  

}