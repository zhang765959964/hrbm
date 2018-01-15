package com.xunfeng.business.personagency.subsidy.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴参数 Form对象
* @author:wanghan
* @createDate 2016-07-07 10:26:13 
* @version V1.0   
*/
public class SocialParamsForm extends BaseForm<SocialParams>
{
	// 主键Id
	protected Long  id;
	// 参数类型
	protected String  paramsCode;
	// 开始日期
	protected String  startDate;
	// 结束日期
	protected String  endDate;
	// 参数值
	protected String  paramsValue;
	// 描述
	protected String  description;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键Id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setParamsCode(String paramsCode) 
	{
		this.paramsCode = paramsCode;
	}
	/**
	 * 返回 参数类型
	 * @return
	 */
	public String getParamsCode() 
	{
		return this.paramsCode;
	}
	public void setStartDate(String startDate) 
	{
		this.startDate = startDate;
	}
	/**
	 * 返回 开始日期
	 * @return
	 */
	public String getStartDate() 
	{
		return this.startDate;
	}
	public void setEndDate(String endDate) 
	{
		this.endDate = endDate;
	}
	/**
	 * 返回 结束日期
	 * @return
	 */
	public String getEndDate() 
	{
		return this.endDate;
	}
	public void setParamsValue(String paramsValue) 
	{
		this.paramsValue = paramsValue;
	}
	/**
	 * 返回 参数值
	 * @return
	 */
	public String getParamsValue() 
	{
		return this.paramsValue;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SocialParamsForm)) 
		{
			return false;
		}
		SocialParamsForm rhs = (SocialParamsForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.paramsCode, rhs.paramsCode)
		.append(this.startDate, rhs.startDate)
		.append(this.endDate, rhs.endDate)
		.append(this.paramsValue, rhs.paramsValue)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.paramsCode) 
		.append(this.startDate) 
		.append(this.endDate) 
		.append(this.paramsValue) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("paramsCode", this.paramsCode) 
		.append("startDate", this.startDate) 
		.append("endDate", this.endDate) 
		.append("paramsValue", this.paramsValue) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.toString();
	}
   
  

}