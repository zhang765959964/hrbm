package com.xunfeng.business.corp.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:面试评语表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wxl
 * 创建时间:2015-07-23 15:46:14
 */
public class CorpInterviewComment extends BaseModel
{
	// 面试评语编号
	protected Long  acp001;
	// 面试评语内容
	protected String  acp002;
	// 单位编号 0:系统默认评语 >0:单位自定义评语
	protected Long  aab001;
	// 是否删除 0:否 1:是
	protected String  ccpr08;
	public void setAcp001(Long acp001) 
	{
		this.acp001 = acp001;
	}
	/**
	 * 返回 面试评语编号
	 * @return
	 */
	public Long getAcp001() 
	{
		return this.acp001;
	}
	public void setAcp002(String acp002) 
	{
		this.acp002 = acp002;
	}
	/**
	 * 返回 面试评语内容
	 * @return
	 */
	public String getAcp002() 
	{
		return this.acp002;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号 0:系统默认评语 >0:单位自定义评语
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除 0:否 1:是
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
		if (!(object instanceof CorpInterviewComment))
		{
			return false;
		}
		CorpInterviewComment rhs = (CorpInterviewComment) object;
		return new EqualsBuilder()
		.append(this.acp001, rhs.acp001)
		.append(this.acp002, rhs.acp002)
		.append(this.aab001, rhs.aab001)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acp001)
		.append(this.acp002)
		.append(this.aab001)
		.append(this.ccpr08)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acp001", this.acp001) 
		.append("acp002", this.acp002) 
		.append("aab001", this.aab001) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}