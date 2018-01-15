package com.xunfeng.business.personagency.subsidy.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_BATCH Model对象
* @author:wanghan
* @createDate 2016-07-07 09:12:59 
* @version V1.0   
*/
public class SocialBatch extends BaseModel
{
	// 主键
	protected Long  id;
	// 批次名称
	protected String  batchName;
	// 批次开始时间
	protected java.util.Date  batchStartdate;
	// 批次结束时间
	protected java.util.Date  batchEnddate;
	// 描述
	protected String  description;
	// 经办人Id
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办时间
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setBatchName(String batchName) 
	{
		this.batchName = batchName;
	}
	/**
	 * 返回 批次名称
	 * @return
	 */
	public String getBatchName() 
	{
		return this.batchName;
	}
	public void setBatchStartdate(java.util.Date batchStartdate) 
	{
		this.batchStartdate = batchStartdate;
	}
	/**
	 * 返回 批次开始时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getBatchStartdate() 
	{
		return this.batchStartdate;
	}
	public void setBatchEnddate(java.util.Date batchEnddate) 
	{
		this.batchEnddate = batchEnddate;
	}
	/**
	 * 返回 批次结束时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getBatchEnddate() 
	{
		return this.batchEnddate;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * 返回 描述
	 * @return
	 */
	public String getDescription() 
	{
		return this.description;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人Id
	 * @return
	 */
	public Long getCreaterId() 
	{
		return this.createrId;
	}
	public void setCreaterName(String createrName) 
	{
		this.createrName = createrName;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
	}
	public void setCreaterDate(java.util.Date createrDate) 
	{
		this.createrDate = createrDate;
	}
	/**
	 * 返回 经办时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setCreaterOrgId(Long createrOrgId) 
	{
		this.createrOrgId = createrOrgId;
	}
	/**
	 * 返回 经办机构Id
	 * @return
	 */
	public Long getCreaterOrgId() 
	{
		return this.createrOrgId;
	}
	public void setCreaterOrgName(String createrOrgName) 
	{
		this.createrOrgName = createrOrgName;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getCreaterOrgName() 
	{
		return this.createrOrgName;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SocialBatch)) 
		{
			return false;
		}
		SocialBatch rhs = (SocialBatch) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.batchName, rhs.batchName)
		.append(this.batchStartdate, rhs.batchStartdate)
		.append(this.batchEnddate, rhs.batchEnddate)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.batchName) 
		.append(this.batchStartdate) 
		.append(this.batchEnddate) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("batchName", this.batchName) 
		.append("batchStartdate", this.batchStartdate) 
		.append("batchEnddate", this.batchEnddate) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.toString();
	}
   
  

}