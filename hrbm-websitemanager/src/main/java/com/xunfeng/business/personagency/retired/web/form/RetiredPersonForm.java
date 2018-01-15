package com.xunfeng.business.personagency.retired.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.retired.model.RetiredPerson;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_RETIRED_PERSON Form对象
* @author:zhangfan
* @createDate 2016-08-02 17:12:13 
* @version V1.0   
*/
public class RetiredPersonForm extends BaseForm<RetiredPerson>
{
	// 主键
	protected Long  id;
	// 退休状态（0 否1 是）
	protected Long  retiredPersonStatus;
	// 外键（退休申诉id）
	protected Long  retiredDeclareId;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
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
	public void setRetiredPersonStatus(Long retiredPersonStatus) 
	{
		this.retiredPersonStatus = retiredPersonStatus;
	}
	/**
	 * 返回 退休状态（0 否1 是）
	 * @return
	 */
	public Long getRetiredPersonStatus() 
	{
		return this.retiredPersonStatus;
	}
	public void setRetiredDeclareId(Long retiredDeclareId) 
	{
		this.retiredDeclareId = retiredDeclareId;
	}
	/**
	 * 返回 外键（退休申诉id）
	 * @return
	 */
	public Long getRetiredDeclareId() 
	{
		return this.retiredDeclareId;
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
	 * 返回 经办日期
	 * @return
	 */
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
		if (!(object instanceof RetiredPersonForm)) 
		{
			return false;
		}
		RetiredPersonForm rhs = (RetiredPersonForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.retiredPersonStatus, rhs.retiredPersonStatus)
		.append(this.retiredDeclareId, rhs.retiredDeclareId)
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
		.append(this.retiredPersonStatus) 
		.append(this.retiredDeclareId) 
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
		.append("retiredPersonStatus", this.retiredPersonStatus) 
		.append("retiredDeclareId", this.retiredDeclareId) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.toString();
	}
   
  

}