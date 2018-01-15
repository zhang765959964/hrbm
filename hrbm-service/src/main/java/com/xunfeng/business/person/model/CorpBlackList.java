package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 屏蔽单位 Model对象
* @author:wanghan
* @createDate 2015-07-23 14:48:15 
* @version V1.0   
*/
public class CorpBlackList extends BaseModel
{
	// 屏蔽流水
	protected Long  aac0g0;
	// 个人编号
	protected Long  aac001;
	// 单位名称
	protected String  aab004;
	public void setAac0g0(Long aac0g0) 
	{
		this.aac0g0 = aac0g0;
	}
	/**
	 * 返回 屏蔽流水
	 * @return
	 */
	public Long getAac0g0() 
	{
		return this.aac0g0;
	}
	public void setAac001(Long aac001) 
	{
		this.aac001 = aac001;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getAac001() 
	{
		return this.aac001;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof CorpBlackList))
		{
			return false;
		}
		CorpBlackList rhs = (CorpBlackList) object;
		return new EqualsBuilder()
		.append(this.aac0g0, rhs.aac0g0)
		.append(this.aac001, rhs.aac001)
		.append(this.aab004, rhs.aab004)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aac0g0)
		.append(this.aac001)
		.append(this.aab004)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aac0g0", this.aac0g0) 
		.append("aac001", this.aac001) 
		.append("aab004", this.aab004) 
		.toString();
	}
   
  

}