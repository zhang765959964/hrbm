package com.xunfeng.sys.appVersion.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: app版本表 Model对象
* @author:jiangxin
* @createDate 2016-11-29 17:05:15 
* @version V1.0   
*/
public class AppVersion extends BaseModel
{
	// 主键id
	protected Long  id;
	// 版本号
	protected String  versionNumber;
	// 版本描述
	protected String  versionDescription;
	// 版本下载地址
	protected String  versionDownAddress;
	// 经办人代码
	protected String  aae011;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办机构代码
	protected String  aae017;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 版本上传时间
	protected java.util.Date  versionUpDate;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setVersionNumber(String versionNumber) 
	{
		this.versionNumber = versionNumber;
	}
	/**
	 * 返回 版本号
	 * @return
	 */
	public String getVersionNumber() 
	{
		return this.versionNumber;
	}
	public void setVersionDescription(String versionDescription) 
	{
		this.versionDescription = versionDescription;
	}
	/**
	 * 返回 版本描述
	 * @return
	 */
	public String getVersionDescription() 
	{
		return this.versionDescription;
	}
	public void setVersionDownAddress(String versionDownAddress) 
	{
		this.versionDownAddress = versionDownAddress;
	}
	/**
	 * 返回 版本下载地址
	 * @return
	 */
	public String getVersionDownAddress() 
	{
		return this.versionDownAddress;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
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
	public void setVersionUpDate(java.util.Date versionUpDate) 
	{
		this.versionUpDate = versionUpDate;
	}
	/**
	 * 返回 版本上传时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getVersionUpDate() 
	{
		return this.versionUpDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AppVersion)) 
		{
			return false;
		}
		AppVersion rhs = (AppVersion) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.versionNumber, rhs.versionNumber)
		.append(this.versionDescription, rhs.versionDescription)
		.append(this.versionDownAddress, rhs.versionDownAddress)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae036, rhs.aae036)
		.append(this.aae017, rhs.aae017)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.versionUpDate, rhs.versionUpDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.versionNumber) 
		.append(this.versionDescription) 
		.append(this.versionDownAddress) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae036) 
		.append(this.aae017) 
		.append(this.ccpr08) 
		.append(this.versionUpDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("versionNumber", this.versionNumber) 
		.append("versionDescription", this.versionDescription) 
		.append("versionDownAddress", this.versionDownAddress) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae036", this.aae036) 
		.append("aae017", this.aae017) 
		.append("ccpr08", this.ccpr08) 
		.append("versionUpDate", this.versionUpDate) 
		.toString();
	}
   
  

}