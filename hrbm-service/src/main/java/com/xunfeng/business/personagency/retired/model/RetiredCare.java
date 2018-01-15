package com.xunfeng.business.personagency.retired.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员大病医保表 Model对象
* @author:zhangfan
* @createDate 2016-12-16 11:23:41 
* @version V1.0   
*/
public class RetiredCare extends BaseModel
{
	// 主键id
	protected Long  id;
	// 是否可申报大病医保
	protected Long  isCareDeclare;
	// 初次填报日期
	protected java.util.Date  firstFillDate;
	// 填报日期
	protected java.util.Date  fillDate;
	// 是否已申报
	protected Long  isDeclare;
	// 是否已通过
	protected Long  isFlag;
	// 大病医保所在区域
	protected String  addre;
	// 原因
	protected String  reason;
	// 备注
	protected String  note;
	// 人员id
	protected Long  personId;
	// 退休id
	protected Long  retiredId;
	// 经办人id
	protected Long  createrId;
	// 经办人姓名
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办日期
	protected String  createrOrgName;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setIsCareDeclare(Long isCareDeclare) 
	{
		this.isCareDeclare = isCareDeclare;
	}
	/**
	 * 返回 是否可申报大病医保
	 * @return
	 */
	public Long getIsCareDeclare() 
	{
		return this.isCareDeclare;
	}
	public void setFirstFillDate(java.util.Date firstFillDate) 
	{
		this.firstFillDate = firstFillDate;
	}
	/**
	 * 返回 初次填报日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFirstFillDate() 
	{
		return this.firstFillDate;
	}
	public void setFillDate(java.util.Date fillDate) 
	{
		this.fillDate = fillDate;
	}
	/**
	 * 返回 填报日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFillDate() 
	{
		return this.fillDate;
	}
	public void setIsDeclare(Long isDeclare) 
	{
		this.isDeclare = isDeclare;
	}
	/**
	 * 返回 是否已申报
	 * @return
	 */
	public Long getIsDeclare() 
	{
		return this.isDeclare;
	}
	public void setIsFlag(Long isFlag) 
	{
		this.isFlag = isFlag;
	}
	/**
	 * 返回 是否已通过
	 * @return
	 */
	public Long getIsFlag() 
	{
		return this.isFlag;
	}
	public void setAddre(String addre) 
	{
		this.addre = addre;
	}
	/**
	 * 返回 大病医保所在区域
	 * @return
	 */
	public String getAddre() 
	{
		return this.addre;
	}
	public void setReason(String reason) 
	{
		this.reason = reason;
	}
	/**
	 * 返回 原因
	 * @return
	 */
	public String getReason() 
	{
		return this.reason;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getNote() 
	{
		return this.note;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setRetiredId(Long retiredId) 
	{
		this.retiredId = retiredId;
	}
	/**
	 * 返回 退休id
	 * @return
	 */
	public Long getRetiredId() 
	{
		return this.retiredId;
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
	 * 返回 经办人姓名
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
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setCreaterOrgId(Long createrOrgId) 
	{
		this.createrOrgId = createrOrgId;
	}
	/**
	 * 返回 经办机构id
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
	 * 返回 经办日期
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
		if (!(object instanceof RetiredCare)) 
		{
			return false;
		}
		RetiredCare rhs = (RetiredCare) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.isCareDeclare, rhs.isCareDeclare)
		.append(this.firstFillDate, rhs.firstFillDate)
		.append(this.fillDate, rhs.fillDate)
		.append(this.isDeclare, rhs.isDeclare)
		.append(this.isFlag, rhs.isFlag)
		.append(this.addre, rhs.addre)
		.append(this.reason, rhs.reason)
		.append(this.note, rhs.note)
		.append(this.personId, rhs.personId)
		.append(this.retiredId, rhs.retiredId)
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
		.append(this.isCareDeclare) 
		.append(this.firstFillDate) 
		.append(this.fillDate) 
		.append(this.isDeclare) 
		.append(this.isFlag) 
		.append(this.addre) 
		.append(this.reason) 
		.append(this.note) 
		.append(this.personId) 
		.append(this.retiredId) 
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
		.append("isCareDeclare", this.isCareDeclare) 
		.append("firstFillDate", this.firstFillDate) 
		.append("fillDate", this.fillDate) 
		.append("isDeclare", this.isDeclare) 
		.append("isFlag", this.isFlag) 
		.append("addre", this.addre) 
		.append("reason", this.reason) 
		.append("note", this.note) 
		.append("personId", this.personId) 
		.append("retiredId", this.retiredId) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.toString();
	}
   
  

}