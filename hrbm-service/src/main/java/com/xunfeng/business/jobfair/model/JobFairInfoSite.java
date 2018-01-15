package com.xunfeng.business.jobfair.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 场地初始化表 Model对象
* @author:wanghan
* @createDate 2015-09-12 11:17:55 
* @version V1.0   
*/
public class JobFairInfoSite extends BaseModel
{
	// 场地初始化编号 
	protected Long  cccd01;
	// 招聘会编号
	protected Long  acb330;
	// 场地编号
	protected Long  acd250;
	public void setCccd01(Long cccd01) 
	{
		this.cccd01 = cccd01;
	}
	/**
	 * 返回 场地初始化编号 
	 * @return
	 */
	public Long getCccd01() 
	{
		return this.cccd01;
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
	public void setAcd250(Long acd250) 
	{
		this.acd250 = acd250;
	}
	/**
	 * 返回 场地编号
	 * @return
	 */
	public Long getAcd250() 
	{
		return this.acd250;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof JobFairInfoSite)) 
		{
			return false;
		}
		JobFairInfoSite rhs = (JobFairInfoSite) object;
		return new EqualsBuilder()
		.append(this.cccd01, rhs.cccd01)
		.append(this.acb330, rhs.acb330)
		.append(this.acd250, rhs.acd250)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.cccd01) 
		.append(this.acb330) 
		.append(this.acd250) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("cccd01", this.cccd01) 
		.append("acb330", this.acb330) 
		.append("acd250", this.acd250) 
		.toString();
	}
   
  

}