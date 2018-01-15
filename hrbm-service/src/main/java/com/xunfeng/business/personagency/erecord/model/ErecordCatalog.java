package com.xunfeng.business.personagency.erecord.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案目录 Model对象
* @author:wanghan
* @createDate 2015-08-20 14:29:30 
* @version V1.0   
*/
public class ErecordCatalog extends BaseModel
{
	// 主键
	protected Long  id;
	// 目录名称
	protected String  name;
	// 目录代码
	protected String  code;
	// 描述
	protected String  description;
	// 排序
	protected Long  sortnum;
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
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * 返回 目录名称
	 * @return
	 */
	public String getName() 
	{
		return this.name;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	/**
	 * 返回 目录代码
	 * @return
	 */
	public String getCode() 
	{
		return this.code;
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
	public void setSortnum(Long sortnum) 
	{
		this.sortnum = sortnum;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getSortnum() 
	{
		return this.sortnum;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ErecordCatalog)) 
		{
			return false;
		}
		ErecordCatalog rhs = (ErecordCatalog) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.name, rhs.name)
		.append(this.code, rhs.code)
		.append(this.description, rhs.description)
		.append(this.sortnum, rhs.sortnum)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.name) 
		.append(this.code) 
		.append(this.description) 
		.append(this.sortnum) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("name", this.name) 
		.append("code", this.code) 
		.append("description", this.description) 
		.append("sortnum", this.sortnum) 
		.toString();
	}
   
  

}