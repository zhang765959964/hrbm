package com.xunfeng.business.personagency.subsidy.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_ARCHIVES_MAKEUP Model对象
* @author:user
* @createDate 2016-12-01 11:37:21 
* @version V1.0   
*/
public class ArchivesMakeup extends BaseModel
{
	// 主键
	protected Long  id;
	// 档案编号
	protected String  archiveCode;
	// 经办人ID
	protected Long  createrId;
	// 经办日期
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办机构Id
	protected Long  createrOrgId;
	// 人员ID
	protected Long  personId;
	// 档案ID
	protected Long  archiveId;
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
	public void setArchiveCode(String archiveCode) 
	{
		this.archiveCode = archiveCode;
	}
	/**
	 * 返回 档案编号
	 * @return
	 */
	public String getArchiveCode() 
	{
		return this.archiveCode;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人ID
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
	 * 返回 经办日期
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
	 * 返回 经办日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
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
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setArchiveId(Long archiveId) 
	{
		this.archiveId = archiveId;
	}
	/**
	 * 返回 档案ID
	 * @return
	 */
	public Long getArchiveId() 
	{
		return this.archiveId;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ArchivesMakeup)) 
		{
			return false;
		}
		ArchivesMakeup rhs = (ArchivesMakeup) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archiveCode, rhs.archiveCode)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.personId, rhs.personId)
		.append(this.archiveId, rhs.archiveId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archiveCode) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgName) 
		.append(this.createrOrgId) 
		.append(this.personId) 
		.append(this.archiveId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archiveCode", this.archiveCode) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("personId", this.personId) 
		.append("archiveId", this.archiveId) 
		.toString();
	}
   
  

}