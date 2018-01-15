package com.xunfeng.sys.role.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/**
 * 对象功能:角色人员关系表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-09 09:37:41
 */
public class SysRoleUser extends BaseModel
{
	// 角色用户ID
	protected Long  id;
	// 角色Id
	protected Long  roleId;
	// 用户Id
	protected Long  userId;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 角色用户ID
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setRoleId(Long roleId) 
	{
		this.roleId = roleId;
	}
	/**
	 * 返回 角色Id
	 * @return
	 */
	public Long getRoleId() 
	{
		return this.roleId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}
	/**
	 * 返回 用户Id
	 * @return
	 */
	public Long getUserId() 
	{
		return this.userId;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysRoleUser)) 
		{
			return false;
		}
		SysRoleUser rhs = (SysRoleUser) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.roleId, rhs.roleId)
		.append(this.userId, rhs.userId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.roleId) 
		.append(this.userId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("roleId", this.roleId) 
		.append("userId", this.userId) 
		.toString();
	}
   
  

}