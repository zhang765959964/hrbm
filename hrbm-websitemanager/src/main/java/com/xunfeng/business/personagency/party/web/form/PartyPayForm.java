package com.xunfeng.business.personagency.party.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.party.model.PartyPay;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党费缴纳 Form对象
* @author:zhangfan
* @createDate 2016-08-16 17:44:26 
* @version V1.0   
*/
public class PartyPayForm extends BaseForm<PartyPay>
{
	// 主键
	protected Long  id;
	// 党组织关系外键
	protected Long  partyId;
	// 交纳开始年月
	protected java.util.Date  partyBeginDate;
	// 交纳截止年月
	protected java.util.Date  partyEndDate;
	// 缴费金额
	protected Float  partyPayMoney;
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
	
	//人员id
	protected Long personId;
	
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
	public void setPartyId(Long partyId) 
	{
		this.partyId = partyId;
	}
	/**
	 * 返回 党组织关系外键
	 * @return
	 */
	public Long getPartyId() 
	{
		return this.partyId;
	}
	public void setPartyBeginDate(java.util.Date partyBeginDate) 
	{
		this.partyBeginDate = partyBeginDate;
	}
	/**
	 * 返回 交纳开始年月
	 * @return
	 */
	public java.util.Date getPartyBeginDate() 
	{
		return this.partyBeginDate;
	}
	public void setPartyEndDate(java.util.Date partyEndDate) 
	{
		this.partyEndDate = partyEndDate;
	}
	/**
	 * 返回 交纳截止年月
	 * @return
	 */
	public java.util.Date getPartyEndDate() 
	{
		return this.partyEndDate;
	}
	public void setPartyPayMoney(Float partyPayMoney) 
	{
		this.partyPayMoney = partyPayMoney;
	}
	/**
	 * 返回 缴费金额
	 * @return
	 */
	public Float getPartyPayMoney() 
	{
		return this.partyPayMoney;
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
		if (!(object instanceof PartyPayForm)) 
		{
			return false;
		}
		PartyPayForm rhs = (PartyPayForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.partyId, rhs.partyId)
		.append(this.partyBeginDate, rhs.partyBeginDate)
		.append(this.partyEndDate, rhs.partyEndDate)
		.append(this.partyPayMoney, rhs.partyPayMoney)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.partyId) 
		.append(this.partyBeginDate) 
		.append(this.partyEndDate) 
		.append(this.partyPayMoney) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("partyId", this.partyId) 
		.append("partyBeginDate", this.partyBeginDate) 
		.append("partyEndDate", this.partyEndDate) 
		.append("partyPayMoney", this.partyPayMoney) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.toString();
	}
   
  

}