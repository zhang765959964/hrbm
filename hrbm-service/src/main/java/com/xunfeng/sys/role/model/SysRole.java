package com.xunfeng.sys.role.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 角色表 Model对象
* @author:wanghan
* @createDate 2016-06-07 18:29:00 
* @version V1.0   
*/
public class SysRole extends BaseModel
{
	// 角色编号
	protected Long  roleid;
	// 角色名称
	protected String  rolename;
	// 角色描述
	protected String  roledesc;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
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
	public void setRolename(String rolename) 
	{
		this.rolename = rolename;
	}
	/**
	 * 返回 角色名称
	 * @return
	 */
	public String getRolename() 
	{
		return this.rolename;
	}
	public void setRoledesc(String roledesc) 
	{
		this.roledesc = roledesc;
	}
	/**
	 * 返回 角色描述
	 * @return
	 */
	public String getRoledesc() 
	{
		return this.roledesc;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysRole)) 
		{
			return false;
		}
		SysRole rhs = (SysRole) object;
		return new EqualsBuilder()
		.append(this.roleid, rhs.roleid)
		.append(this.rolename, rhs.rolename)
		.append(this.roledesc, rhs.roledesc)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.roleid) 
		.append(this.rolename) 
		.append(this.roledesc) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("roleid", this.roleid) 
		.append("rolename", this.rolename) 
		.append("roledesc", this.roledesc) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.toString();
	}
   
  

}