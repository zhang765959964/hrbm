package com.xunfeng.business.personagency.params.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 月缴费基数 Model对象
* @author:wanghan
* @createDate 2016-09-07 09:23:00 
* @version V1.0   
*/
public class ParamsMonthBase extends BaseModel
{
	// 主键
	protected Long  pkId;
	// 月缴费基数
	protected Float  fdMonthBase;
	// 参数描述
	protected String  fdParmsDesc;
	// 描述
	protected String  fdDesc;
	// 经办人ID
	protected Long  fkCreaterId;
	// 经办人名称
	protected String  fdCreaterName;
	// 经办时间
	protected java.util.Date  fdCreaterDate;
	// 经办机构ID
	protected Long  fkCreaterOrgId;
	// 经办机构名称
	protected String  fdCreaterOrgName;
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
	public void setFdMonthBase(Float fdMonthBase) 
	{
		this.fdMonthBase = fdMonthBase;
	}
	/**
	 * 返回 月缴费基数
	 * @return
	 */
	public Float getFdMonthBase() 
	{
		return this.fdMonthBase;
	}
	public void setFdParmsDesc(String fdParmsDesc) 
	{
		this.fdParmsDesc = fdParmsDesc;
	}
	/**
	 * 返回 参数描述
	 * @return
	 */
	public String getFdParmsDesc() 
	{
		return this.fdParmsDesc;
	}
	public void setFdDesc(String fdDesc) 
	{
		this.fdDesc = fdDesc;
	}
	/**
	 * 返回 描述
	 * @return
	 */
	public String getFdDesc() 
	{
		return this.fdDesc;
	}
	public void setFkCreaterId(Long fkCreaterId) 
	{
		this.fkCreaterId = fkCreaterId;
	}
	/**
	 * 返回 经办人ID
	 * @return
	 */
	public Long getFkCreaterId() 
	{
		return this.fkCreaterId;
	}
	public void setFdCreaterName(String fdCreaterName) 
	{
		this.fdCreaterName = fdCreaterName;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getFdCreaterName() 
	{
		return this.fdCreaterName;
	}
	public void setFdCreaterDate(java.util.Date fdCreaterDate) 
	{
		this.fdCreaterDate = fdCreaterDate;
	}
	/**
	 * 返回 经办时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdCreaterDate() 
	{
		return this.fdCreaterDate;
	}
	public void setFkCreaterOrgId(Long fkCreaterOrgId) 
	{
		this.fkCreaterOrgId = fkCreaterOrgId;
	}
	/**
	 * 返回 经办机构ID
	 * @return
	 */
	public Long getFkCreaterOrgId() 
	{
		return this.fkCreaterOrgId;
	}
	public void setFdCreaterOrgName(String fdCreaterOrgName) 
	{
		this.fdCreaterOrgName = fdCreaterOrgName;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getFdCreaterOrgName() 
	{
		return this.fdCreaterOrgName;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ParamsMonthBase)) 
		{
			return false;
		}
		ParamsMonthBase rhs = (ParamsMonthBase) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fdMonthBase, rhs.fdMonthBase)
		.append(this.fdParmsDesc, rhs.fdParmsDesc)
		.append(this.fdDesc, rhs.fdDesc)
		.append(this.fkCreaterId, rhs.fkCreaterId)
		.append(this.fdCreaterName, rhs.fdCreaterName)
		.append(this.fdCreaterDate, rhs.fdCreaterDate)
		.append(this.fkCreaterOrgId, rhs.fkCreaterOrgId)
		.append(this.fdCreaterOrgName, rhs.fdCreaterOrgName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fdMonthBase) 
		.append(this.fdParmsDesc) 
		.append(this.fdDesc) 
		.append(this.fkCreaterId) 
		.append(this.fdCreaterName) 
		.append(this.fdCreaterDate) 
		.append(this.fkCreaterOrgId) 
		.append(this.fdCreaterOrgName) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fdMonthBase", this.fdMonthBase) 
		.append("fdParmsDesc", this.fdParmsDesc) 
		.append("fdDesc", this.fdDesc) 
		.append("fkCreaterId", this.fkCreaterId) 
		.append("fdCreaterName", this.fdCreaterName) 
		.append("fdCreaterDate", this.fdCreaterDate) 
		.append("fkCreaterOrgId", this.fkCreaterOrgId) 
		.append("fdCreaterOrgName", this.fdCreaterOrgName) 
		.toString();
	}
   
  

}