package com.xunfeng.business.link.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/**
 * 对象功能:网站友情链接表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-14 15:51:35
 */
public class Link extends BaseModel
{
	// 链接编号
	protected Long  ccmw01;
	// 网站名称
	protected String  ccmw02;
	// 链接地址
	protected String  ccmw03;
	// 添加日期
	protected java.util.Date  ccmw04;
	// 链接分类
	protected Long  ccmw05;
	// 排序
	protected Long  ccmw06;
	public void setCcmw01(Long ccmw01) 
	{
		this.ccmw01 = ccmw01;
	}
	/**
	 * 返回 链接编号
	 * @return
	 */
	public Long getCcmw01() 
	{
		return this.ccmw01;
	}
	public void setCcmw02(String ccmw02) 
	{
		this.ccmw02 = ccmw02;
	}
	/**
	 * 返回 网站名称
	 * @return
	 */
	public String getCcmw02() 
	{
		return this.ccmw02;
	}
	public void setCcmw03(String ccmw03) 
	{
		this.ccmw03 = ccmw03;
	}
	/**
	 * 返回 链接地址
	 * @return
	 */
	public String getCcmw03() 
	{
		return this.ccmw03;
	}
	public void setCcmw04(java.util.Date ccmw04) 
	{
		this.ccmw04 = ccmw04;
	}
	/**
	 * 返回 添加日期
	 * @return
	 */
	public java.util.Date getCcmw04() 
	{
		return this.ccmw04;
	}
	public void setCcmw05(Long ccmw05) 
	{
		this.ccmw05 = ccmw05;
	}
	/**
	 * 返回 链接分类
	 * @return
	 */
	public Long getCcmw05() 
	{
		return this.ccmw05;
	}
	public void setCcmw06(Long ccmw06) 
	{
		this.ccmw06 = ccmw06;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getCcmw06() 
	{
		return this.ccmw06;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Link)) 
		{
			return false;
		}
		Link rhs = (Link) object;
		return new EqualsBuilder()
		.append(this.ccmw01, rhs.ccmw01)
		.append(this.ccmw02, rhs.ccmw02)
		.append(this.ccmw03, rhs.ccmw03)
		.append(this.ccmw04, rhs.ccmw04)
		.append(this.ccmw05, rhs.ccmw05)
		.append(this.ccmw06, rhs.ccmw06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccmw01) 
		.append(this.ccmw02) 
		.append(this.ccmw03) 
		.append(this.ccmw04) 
		.append(this.ccmw05) 
		.append(this.ccmw06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccmw01", this.ccmw01) 
		.append("ccmw02", this.ccmw02) 
		.append("ccmw03", this.ccmw03) 
		.append("ccmw04", this.ccmw04) 
		.append("ccmw05", this.ccmw05) 
		.append("ccmw06", this.ccmw06) 
		.toString();
	}
   
  

}