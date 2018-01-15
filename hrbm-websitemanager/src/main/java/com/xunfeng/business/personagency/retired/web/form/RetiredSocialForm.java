package com.xunfeng.business.personagency.retired.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.retired.model.RetiredSocial;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员转社会化 Form对象
* @author:zhangfan
* @createDate 2016-08-09 15:09:43 
* @version V1.0   
*/
public class RetiredSocialForm extends BaseForm<RetiredSocial>
{
	// 主键
	protected Long  id;
	// 转社会化协议编号
	protected String  retiredSocialNo;
	// 转社会化协议日期
	protected java.util.Date  retiredSocialDate;
	// 对方经办人
	protected String  retiredSocialName;
	// 转入单位
	protected String  retiredSocialUnit;
	// 是否转社会化（0否1是）
	protected Long  isRetiredSocial;
	// 退休申诉id
	protected Long  retiredDeclareId;
	
	// 经办人id
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	
	//退休申诉状态
	protected String retiredDeclareStatus;
	
	//是否退休
	protected Long retiredStatus; 
	
	//人员id
	protected Long personId;
	
	
	public String getRetiredDeclareStatus() {
		return retiredDeclareStatus;
	}
	public void setRetiredDeclareStatus(String retiredDeclareStatus) {
		this.retiredDeclareStatus = retiredDeclareStatus;
	}
	public Long getRetiredStatus() {
		return retiredStatus;
	}
	public void setRetiredStatus(Long retiredStatus) {
		this.retiredStatus = retiredStatus;
	}
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
	public void setRetiredSocialNo(String retiredSocialNo) 
	{
		this.retiredSocialNo = retiredSocialNo;
	}
	/**
	 * 返回 转社会化协议编号
	 * @return
	 */
	public String getRetiredSocialNo() 
	{
		return this.retiredSocialNo;
	}
	public void setRetiredSocialDate(java.util.Date retiredSocialDate) 
	{
		this.retiredSocialDate = retiredSocialDate;
	}
	/**
	 * 返回 转社会化协议日期
	 * @return
	 */
	public java.util.Date getRetiredSocialDate() 
	{
		return this.retiredSocialDate;
	}
	public void setRetiredSocialName(String retiredSocialName) 
	{
		this.retiredSocialName = retiredSocialName;
	}
	/**
	 * 返回 对方经办人
	 * @return
	 */
	public String getRetiredSocialName() 
	{
		return this.retiredSocialName;
	}
	public void setRetiredSocialUnit(String retiredSocialUnit) 
	{
		this.retiredSocialUnit = retiredSocialUnit;
	}
	/**
	 * 返回 转入单位
	 * @return
	 */
	public String getRetiredSocialUnit() 
	{
		return this.retiredSocialUnit;
	}
	public void setIsRetiredSocial(Long isRetiredSocial) 
	{
		this.isRetiredSocial = isRetiredSocial;
	}
	/**
	 * 返回 是否转社会化（0否1是）
	 * @return
	 */
	public Long getIsRetiredSocial() 
	{
		return this.isRetiredSocial;
	}
	public void setRetiredDeclareId(Long retiredDeclareId) 
	{
		this.retiredDeclareId = retiredDeclareId;
	}
	/**
	 * 返回 退休申诉id
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
	 * 返回 经办人id
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

	
	
	
   	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof RetiredSocialForm)) 
		{
			return false;
		}
		RetiredSocialForm rhs = (RetiredSocialForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.retiredSocialNo, rhs.retiredSocialNo)
		.append(this.retiredSocialDate, rhs.retiredSocialDate)
		.append(this.retiredSocialName, rhs.retiredSocialName)
		.append(this.retiredSocialUnit, rhs.retiredSocialUnit)
		.append(this.isRetiredSocial, rhs.isRetiredSocial)
		.append(this.retiredDeclareId, rhs.retiredDeclareId)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.personId, rhs.personId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.retiredSocialNo) 
		.append(this.retiredSocialDate) 
		.append(this.retiredSocialName) 
		.append(this.retiredSocialUnit) 
		.append(this.isRetiredSocial) 
		.append(this.retiredDeclareId) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.personId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("retiredSocialNo", this.retiredSocialNo) 
		.append("retiredSocialDate", this.retiredSocialDate) 
		.append("retiredSocialName", this.retiredSocialName) 
		.append("retiredSocialUnit", this.retiredSocialUnit) 
		.append("isRetiredSocial", this.isRetiredSocial) 
		.append("retiredDeclareId", this.retiredDeclareId) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("personId", this.personId) 
		.toString();
	}
   
  

}