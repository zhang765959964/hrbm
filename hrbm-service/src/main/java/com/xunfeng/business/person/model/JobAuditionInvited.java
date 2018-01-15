package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:面试邀请表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:48
 */
public class JobAuditionInvited extends BaseModel
{
	// 面试邀请自动编号
	protected Long  ccps01;
	// 企业编号
	protected Long  ccmc01;
	// 个人编号
	protected Long  ccmp01;
	// 职位编号
	protected Long  acb210;
	// 邀请日期
	protected java.util.Date  ccps02;
	// 面试日期及内容
	protected String  ccps03;
	// 用户是否查看(0-未查看1-已查看)
	protected Long  ccps04;
	// 数据来源
	protected String  ccps06;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 招聘会编号
	protected Long  acb330;
	//是否接受邀请
	protected Long isaccept;
	public void setCcps01(Long ccps01) 
	{
		this.ccps01 = ccps01;
	}
	/**
	 * 返回 面试邀请自动编号
	 * @return
	 */
	public Long getCcps01() 
	{
		return this.ccps01;
	}
	public void setCcmc01(Long ccmc01) 
	{
		this.ccmc01 = ccmc01;
	}
	/**
	 * 返回 企业编号
	 * @return
	 */
	public Long getCcmc01() 
	{
		return this.ccmc01;
	}
	public void setCcmp01(Long ccmp01) 
	{
		this.ccmp01 = ccmp01;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getCcmp01() 
	{
		return this.ccmp01;
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
	public void setCcps02(java.util.Date ccps02) 
	{
		this.ccps02 = ccps02;
	}
	/**
	 * 返回 邀请日期
	 * @return
	 */
	public java.util.Date getCcps02() 
	{
		return this.ccps02;
	}
	public void setCcps03(String ccps03) 
	{
		this.ccps03 = ccps03;
	}
	/**
	 * 返回 面试日期及内容
	 * @return
	 */
	public String getCcps03() 
	{
		return this.ccps03;
	}
	public void setCcps04(Long ccps04) 
	{
		this.ccps04 = ccps04;
	}
	/**
	 * 返回 用户是否查看(0-未查看1-已查看)
	 * @return
	 */
	public Long getCcps04() 
	{
		return this.ccps04;
	}
	public void setCcps06(String ccps06) 
	{
		this.ccps06 = ccps06;
	}
	/**
	 * 返回 数据来源
	 * @return
	 */
	public String getCcps06() 
	{
		return this.ccps06;
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
	public void setAcb330(Long acb330) 
	{
		this.acb330 = acb330;
	}
	/**
	 * 返回 招聘会编号
	 * @return
	 */
	public Long getAcb330() 
	{
		return this.acb330;
	}

   	public Long getIsaccept() {
		return isaccept;
	}
	public void setIsaccept(Long isaccept) {
		this.isaccept = isaccept;
	}
	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof JobAuditionInvited))
		{
			return false;
		}
		JobAuditionInvited rhs = (JobAuditionInvited) object;
		return new EqualsBuilder()
		.append(this.ccps01, rhs.ccps01)
		.append(this.ccmc01, rhs.ccmc01)
		.append(this.ccmp01, rhs.ccmp01)
		.append(this.acb210, rhs.acb210)
		.append(this.ccps02, rhs.ccps02)
		.append(this.ccps03, rhs.ccps03)
		.append(this.ccps04, rhs.ccps04)
		.append(this.ccps06, rhs.ccps06)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.acb330, rhs.acb330)
		.append(this.isaccept, rhs.isaccept)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccps01)
		.append(this.ccmc01)
		.append(this.ccmp01)
		.append(this.acb210)
		.append(this.ccps02)
		.append(this.ccps03)
		.append(this.ccps04)
		.append(this.ccps06)
		.append(this.ccpr08)
		.append(this.acb330)
		.append(this.isaccept)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccps01", this.ccps01) 
		.append("ccmc01", this.ccmc01) 
		.append("ccmp01", this.ccmp01) 
		.append("acb210", this.acb210) 
		.append("ccps02", this.ccps02) 
		.append("ccps03", this.ccps03) 
		.append("ccps04", this.ccps04) 
		.append("ccps06", this.ccps06) 
		.append("ccpr08", this.ccpr08) 
		.append("acb330", this.acb330) 
		.append("isaccept", this.isaccept) 
		.toString();
	}
   
  

}