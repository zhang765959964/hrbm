package com.xunfeng.business.personagency.params.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 账号与市场关联维护 Model对象
* @author:wanghan
* @createDate 2016-09-07 10:24:43 
* @version V1.0   
*/
public class ParamsAccountsCorp extends BaseModel
{
	// 主键
	protected Long  pkId;
	// 用户帐号
	protected String  fdUserAccount;
	// 用户名称
	protected String  fdUserName;
	// 用户所在机构
	protected String  fdDeptName;
	// 市场位置名称
	protected String  fdOrgName;
	// 市场位置ID
	protected Long  fdOrgId;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFdUserAccount(String fdUserAccount) 
	{
		this.fdUserAccount = fdUserAccount;
	}
	/**
	 * 返回 用户帐号
	 * @return
	 */
	public String getFdUserAccount() 
	{
		return this.fdUserAccount;
	}
	public void setFdUserName(String fdUserName) 
	{
		this.fdUserName = fdUserName;
	}
	/**
	 * 返回 用户名称
	 * @return
	 */
	public String getFdUserName() 
	{
		return this.fdUserName;
	}
	public void setFdDeptName(String fdDeptName) 
	{
		this.fdDeptName = fdDeptName;
	}
	/**
	 * 返回 用户所在机构
	 * @return
	 */
	public String getFdDeptName() 
	{
		return this.fdDeptName;
	}
	public void setFdOrgName(String fdOrgName) 
	{
		this.fdOrgName = fdOrgName;
	}
	/**
	 * 返回 市场位置名称
	 * @return
	 */
	public String getFdOrgName() 
	{
		return this.fdOrgName;
	}
	public void setFdOrgId(Long fdOrgId) 
	{
		this.fdOrgId = fdOrgId;
	}
	/**
	 * 返回 市场位置ID
	 * @return
	 */
	public Long getFdOrgId() 
	{
		return this.fdOrgId;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ParamsAccountsCorp)) 
		{
			return false;
		}
		ParamsAccountsCorp rhs = (ParamsAccountsCorp) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fdUserAccount, rhs.fdUserAccount)
		.append(this.fdUserName, rhs.fdUserName)
		.append(this.fdDeptName, rhs.fdDeptName)
		.append(this.fdOrgName, rhs.fdOrgName)
		.append(this.fdOrgId, rhs.fdOrgId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fdUserAccount) 
		.append(this.fdUserName) 
		.append(this.fdDeptName) 
		.append(this.fdOrgName) 
		.append(this.fdOrgId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fdUserAccount", this.fdUserAccount) 
		.append("fdUserName", this.fdUserName) 
		.append("fdDeptName", this.fdDeptName) 
		.append("fdOrgName", this.fdOrgName) 
		.append("fdOrgId", this.fdOrgId) 
		.toString();
	}
   
  

}