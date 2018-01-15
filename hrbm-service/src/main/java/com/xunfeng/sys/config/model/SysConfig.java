package com.xunfeng.sys.config.model;


import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:RSDA_SYS_CONFIG Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-05-27 10:24:37
 */
public class SysConfig extends BaseModel
{
	// ID
	protected Long  id;
	// TYPE
	protected String  type;
	// FORM_CONTENT
	protected String  formContent;
	// 机构 预留字段
	protected Long  orgId;
	// 显示内容
	protected String  label;
	// 名称
	protected String  name;
	// 值
	protected String  value;
	// 排序字段
	protected Long  sortField;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 ID
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	/**
	 * 返回 TYPE
	 * @return
	 */
	public String getType() 
	{
		return this.type;
	}
	public void setFormContent(String formContent) 
	{
		this.formContent = formContent;
	}
	/**
	 * 返回 FORM_CONTENT
	 * @return
	 */
	public String getFormContent() 
	{
		return this.formContent;
	}
	public void setOrgId(Long orgId) 
	{
		this.orgId = orgId;
	}
	/**
	 * 返回 ORG_ID
	 * @return
	 */
	public Long getOrgId() 
	{
		return this.orgId;
	}
	public void setLabel(String label) 
	{
		this.label = label;
	}
	/**
	 * 返回 LABEL
	 * @return
	 */
	public String getLabel() 
	{
		return this.label;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * 返回 NAME
	 * @return
	 */
	public String getName() 
	{
		return this.name;
	}
	public void setValue(String value) 
	{
		this.value = value;
	}
	/**
	 * 返回 VALUE
	 * @return
	 */
	public String getValue() 
	{
		return this.value;
	}
	public void setSortField(Long sortField) 
	{
		this.sortField = sortField;
	}
	/**
	 * 返回 SORT_FIELD
	 * @return
	 */
	public Long getSortField() 
	{
		return this.sortField;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof SysConfig))
		{
			return false;
		}
		SysConfig rhs = (SysConfig) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.type, rhs.type)
		.append(this.formContent, rhs.formContent)
		.append(this.orgId, rhs.orgId)
		.append(this.label, rhs.label)
		.append(this.name, rhs.name)
		.append(this.value, rhs.value)
		.append(this.sortField, rhs.sortField)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id)
		.append(this.type)
		.append(this.formContent)
		.append(this.orgId)
		.append(this.label)
		.append(this.name)
		.append(this.value)
		.append(this.sortField)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("type", this.type) 
		.append("formContent", this.formContent) 
		.append("orgId", this.orgId) 
		.append("label", this.label) 
		.append("name", this.name) 
		.append("value", this.value) 
		.append("sortField", this.sortField) 
		.toString();
	}
   
  

}