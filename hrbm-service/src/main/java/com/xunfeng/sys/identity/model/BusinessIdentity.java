package com.xunfeng.sys.identity.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: WS_M_SYS_BUS_ID Model对象
* @author:user
* @createDate 2016-11-29 10:19:14 
* @version V1.0   
*/
public class BusinessIdentity extends BaseModel
{
	// ID
	protected Long  id;
	// TYPE
	protected String  type;
	// TYPE_NAME
	protected String  typeName;
	// BOUND
	protected Long  bound;
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
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}
	/**
	 * 返回 TYPE_NAME
	 * @return
	 */
	public String getTypeName() 
	{
		return this.typeName;
	}
	public void setBound(Long bound) 
	{
		this.bound = bound;
	}
	/**
	 * 返回 BOUND
	 * @return
	 */
	public Long getBound() 
	{
		return this.bound;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof BusinessIdentity)) 
		{
			return false;
		}
		BusinessIdentity rhs = (BusinessIdentity) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.type, rhs.type)
		.append(this.typeName, rhs.typeName)
		.append(this.bound, rhs.bound)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.type) 
		.append(this.typeName) 
		.append(this.bound) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("type", this.type) 
		.append("typeName", this.typeName) 
		.append("bound", this.bound) 
		.toString();
	}
   
  

}