package com.xunfeng.business.personagency.retired.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作经历维护 Model对象
* @author:zhangfan
* @createDate 2016-07-23 14:54:37 
* @version V1.0   
*/
public class WorkExperience extends BaseModel
{
	// 序号
	protected Long  id;
	// 起始时间
	protected java.util.Date  createTime;
	// 终止时间
	protected java.util.Date  endTime;
	// 工作单位
	protected String  workUnit;
	// 工种（职务
	protected Long  gzId;

	// 经办人
	protected Long  createrId;
	// 经办机构
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 退休申诉id
	protected Long  retiredDeclareId;
	
	//人员id
	protected Long personId;
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setCreateTime(java.util.Date createTime) 
	{
		this.createTime = createTime;
	}
	/**
	 * 返回 起始时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreateTime() 
	{
		return this.createTime;
	}
	public void setEndTime(java.util.Date endTime) 
	{
		this.endTime = endTime;
	}
	/**
	 * 返回 终止时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getEndTime() 
	{
		return this.endTime;
	}
	public void setWorkUnit(String workUnit) 
	{
		this.workUnit = workUnit;
	}
	/**
	 * 返回 工作单位
	 * @return
	 */
	public String getWorkUnit() 
	{
		return this.workUnit;
	}
	public void setGzId(Long gzId) 
	{
		this.gzId = gzId;
	}
	/**
	 * 返回 工种（职务
	 * @return
	 */
	public Long getGzId() 
	{
		return this.gzId;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人
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
	 * 返回 经办机构
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
	public void setRetiredDeclareId(Long retiredDeclareId) 
	{
		this.retiredDeclareId = retiredDeclareId;
	}
	/**
	 * 返回 退休申诉id
	 * @return
	 */
	public Long getRetiredDeclareId() 
	{
		return this.retiredDeclareId;
	}
	
	
	

   	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof WorkExperience)) 
		{
			return false;
		}
		WorkExperience rhs = (WorkExperience) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.createTime, rhs.createTime)
		.append(this.endTime, rhs.endTime)
		.append(this.workUnit, rhs.workUnit)
		.append(this.gzId, rhs.gzId)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.retiredDeclareId, rhs.retiredDeclareId)
		.append(this.getPersonId(), rhs.getPersonId())
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.createTime) 
		.append(this.endTime) 
		.append(this.workUnit) 
		.append(this.gzId) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.retiredDeclareId) 
		
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("createTime", this.createTime) 
		.append("endTime", this.endTime) 
		.append("workUnit", this.workUnit) 
		.append("gzId", this.gzId) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("retiredDeclareId", this.retiredDeclareId)
		.append("personId",this.personId)
		.toString();
	}
   
  

}