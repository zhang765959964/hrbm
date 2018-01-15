package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:职位申请表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:05
 */
public class JobApply extends BaseModel
{
	// 职位申请自动编号
	protected Long  ccpj01;
	// 用户信息表自动编号
	protected Long  ccmu01;
	// 职位编号
	protected Long  acb210;
	// 下载日期
	protected java.util.Date  ccpj02;
	// 是否已查看0-未查看1-已查看
	protected Long  ccpj03;
	// 个人备注
	protected String  ccpj04;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 招聘会编号
	protected Long  acb330;
	// 数据来源
	protected String  cczy06;
	// 设备编号
	protected Long  div001;
	public void setCcpj01(Long ccpj01) 
	{
		this.ccpj01 = ccpj01;
	}
	/**
	 * 返回 职位申请自动编号
	 * @return
	 */
	public Long getCcpj01() 
	{
		return this.ccpj01;
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
	public void setCcpj02(java.util.Date ccpj02) 
	{
		this.ccpj02 = ccpj02;
	}
	/**
	 * 返回 下载日期
	 * @return
	 */
	public java.util.Date getCcpj02() 
	{
		return this.ccpj02;
	}
	public void setCcpj03(Long ccpj03) 
	{
		this.ccpj03 = ccpj03;
	}
	/**
	 * 返回 是否已查看0-未查看1-已查看
	 * @return
	 */
	public Long getCcpj03() 
	{
		return this.ccpj03;
	}
	public void setCcpj04(String ccpj04) 
	{
		this.ccpj04 = ccpj04;
	}
	/**
	 * 返回 个人备注
	 * @return
	 */
	public String getCcpj04() 
	{
		return this.ccpj04;
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
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setDiv001(Long div001) 
	{
		this.div001 = div001;
	}
	/**
	 * 返回 设备编号
	 * @return
	 */
	public Long getDiv001() 
	{
		return this.div001;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof JobApply))
		{
			return false;
		}
		JobApply rhs = (JobApply) object;
		return new EqualsBuilder()
		.append(this.ccpj01, rhs.ccpj01)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.acb210, rhs.acb210)
		.append(this.ccpj02, rhs.ccpj02)
		.append(this.ccpj03, rhs.ccpj03)
		.append(this.ccpj04, rhs.ccpj04)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.acb330, rhs.acb330)
		.append(this.cczy06, rhs.cczy06)
		.append(this.div001, rhs.div001)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccpj01)
		.append(this.ccmu01)
		.append(this.acb210)
		.append(this.ccpj02)
		.append(this.ccpj03)
		.append(this.ccpj04)
		.append(this.ccpr08)
		.append(this.acb330)
		.append(this.cczy06)
		.append(this.div001)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccpj01", this.ccpj01) 
		.append("ccmu01", this.ccmu01) 
		.append("acb210", this.acb210) 
		.append("ccpj02", this.ccpj02) 
		.append("ccpj03", this.ccpj03) 
		.append("ccpj04", this.ccpj04) 
		.append("ccpr08", this.ccpr08) 
		.append("acb330", this.acb330) 
		.append("cczy06", this.cczy06) 
		.append("div001", this.div001) 
		.toString();
	}
   
  

}