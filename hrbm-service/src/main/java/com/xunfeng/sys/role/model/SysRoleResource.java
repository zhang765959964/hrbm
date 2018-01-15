package com.xunfeng.sys.role.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 角色功能表 Model对象
* @author:liwenhao
* @createDate 2016-06-27 17:38:21 
* @version V1.0   
*/
public class SysRoleResource extends BaseModel
{
	// 角色编号
	protected Long  roleid;
	// 功能编号
	protected Long  funid;
	public void setRoleid(Long roleid) 
	{
		this.roleid = roleid;
	}
	/**
	 * 返回 角色编号
	 * @return
	 */
	public Long getRoleid() 
	{
		return this.roleid;
	}
	public void setFunid(Long funid) 
	{
		this.funid = funid;
	}
	/**
	 * 返回 功能编号
	 * @return
	 */
	public Long getFunid() 
	{
		return this.funid;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysRoleResource)) 
		{
			return false;
		}
		SysRoleResource rhs = (SysRoleResource) object;
		return new EqualsBuilder()
		.append(this.roleid, rhs.roleid)
		.append(this.funid, rhs.funid)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.roleid) 
		.append(this.funid) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("roleid", this.roleid) 
		.append("funid", this.funid) 
		.toString();
	}
   
  

}