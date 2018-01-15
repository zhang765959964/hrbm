package com.xunfeng.business.personagency.retired.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.retired.model.RetiredCard;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员领取退休证 Form对象
* @author:zhangfan
* @createDate 2016-08-05 11:14:07 
* @version V1.0   
*/
public class RetiredCardForm extends BaseForm<RetiredCard>
{
	// 主键
	protected Long  id;
	// 是否领取退休证（0.否1.是）
	protected Long  isRetiredCard;
	// 领取退休证时间
	protected java.util.Date  retiredCardDate;
	// 退休证号
	protected String  retiredCardCode;
	// 退休证领取人
	protected String  retiredCardName;
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
	
	//退休申诉id
	protected Long retiredDeclareId;
	
	
	//退休申诉状态
	protected String retiredDeclareStatus;
	
	//是否退休
	protected Long retiredStatus; 
	
	//人员id
	protected Long personId;
	
	public Long getRetiredDeclareId() {
		return retiredDeclareId;
	}
	public void setRetiredDeclareId(Long retiredDeclareId) {
		this.retiredDeclareId = retiredDeclareId;
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
	public void setIsRetiredCard(Long isRetiredCard) 
	{
		this.isRetiredCard = isRetiredCard;
	}
	/**
	 * 返回 是否领取退休证（0.否1.是）
	 * @return
	 */
	public Long getIsRetiredCard() 
	{
		return this.isRetiredCard;
	}
	public void setRetiredCardDate(java.util.Date retiredCardDate) 
	{
		this.retiredCardDate = retiredCardDate;
	}
	/**
	 * 返回 领取退休证时间
	 * @return
	 */
	public java.util.Date getRetiredCardDate() 
	{
		return this.retiredCardDate;
	}
	public void setRetiredCardCode(String retiredCardCode) 
	{
		this.retiredCardCode = retiredCardCode;
	}
	/**
	 * 返回 退休证号
	 * @return
	 */
	public String getRetiredCardCode() 
	{
		return this.retiredCardCode;
	}
	public void setRetiredCardName(String retiredCardName) 
	{
		this.retiredCardName = retiredCardName;
	}
	/**
	 * 返回 退休证领取人
	 * @return
	 */
	public String getRetiredCardName() 
	{
		return this.retiredCardName;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof RetiredCardForm)) 
		{
			return false;
		}
		RetiredCardForm rhs = (RetiredCardForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.isRetiredCard, rhs.isRetiredCard)
		.append(this.retiredCardDate, rhs.retiredCardDate)
		.append(this.retiredCardCode, rhs.retiredCardCode)
		.append(this.retiredCardName, rhs.retiredCardName)
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
		.append(this.isRetiredCard) 
		.append(this.retiredCardDate) 
		.append(this.retiredCardCode) 
		.append(this.retiredCardName) 
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
		.append("isRetiredCard", this.isRetiredCard) 
		.append("retiredCardDate", this.retiredCardDate) 
		.append("retiredCardCode", this.retiredCardCode) 
		.append("retiredCardName", this.retiredCardName) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("personId", this.personId) 
		.toString();
	}
	
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
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
   
  

}