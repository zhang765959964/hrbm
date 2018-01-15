package com.xunfeng.business.personagency.entrust.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 委托类型变更 Model对象
* @author:jiangxin
* @createDate 2016-08-23 10:03:50 
* @version V1.0   
*/
public class CommissionChange extends BaseModel
{
	// 主键
	protected Long  id;
	// 变更类型
	protected String  commissionType;
	// 变更日期
	protected java.util.Date  commissionDate;
	// 档案编号（变更前）
	protected String  archiveCodeBefore;
	// 档案编号（变更后）
	protected String  archiveCodeAfter;
	// 变更委托单位名称
	protected String  commissionCorpName;
	// 备注
	protected String  description;
	// 经办人id
	protected Long  createrId;
	// 经办人
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 数据来源（）
	protected String  cczy06;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 打印标签次数
	protected Long  printNumber;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
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
	public void setCommissionType(String commissionType) 
	{
		this.commissionType = commissionType;
	}
	/**
	 * 返回 变更类型
	 * @return
	 */
	public String getCommissionType() 
	{
		return this.commissionType;
	}
	public void setCommissionDate(java.util.Date commissionDate) 
	{
		this.commissionDate = commissionDate;
	}
	/**
	 * 返回 变更日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCommissionDate() 
	{
		return this.commissionDate;
	}
	public void setArchiveCodeBefore(String archiveCodeBefore) 
	{
		this.archiveCodeBefore = archiveCodeBefore;
	}
	/**
	 * 返回 档案编号（变更前）
	 * @return
	 */
	public String getArchiveCodeBefore() 
	{
		return this.archiveCodeBefore;
	}
	public void setArchiveCodeAfter(String archiveCodeAfter) 
	{
		this.archiveCodeAfter = archiveCodeAfter;
	}
	/**
	 * 返回 档案编号（变更后）
	 * @return
	 */
	public String getArchiveCodeAfter() 
	{
		return this.archiveCodeAfter;
	}
	public void setCommissionCorpName(String commissionCorpName) 
	{
		this.commissionCorpName = commissionCorpName;
	}
	/**
	 * 返回 变更委托单位名称
	 * @return
	 */
	public String getCommissionCorpName() 
	{
		return this.commissionCorpName;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getDescription() 
	{
		return this.description;
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
	 * 返回 经办人
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
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
	 * 返回 经办机构
	 * @return
	 */
	public String getCreaterOrgName() 
	{
		return this.createrOrgName;
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
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源（）
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}
	public void setPrintNumber(Long printNumber) 
	{
		this.printNumber = printNumber;
	}
	/**
	 * 返回 打印标签次数
	 * @return
	 */
	public Long getPrintNumber() 
	{
		return this.printNumber;
	}
	public void setArchivesId(Long archivesId) 
	{
		this.archivesId = archivesId;
	}
	/**
	 * 返回 档案id
	 * @return
	 */
	public Long getArchivesId() 
	{
		return this.archivesId;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof CommissionChange)) 
		{
			return false;
		}
		CommissionChange rhs = (CommissionChange) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.commissionType, rhs.commissionType)
		.append(this.commissionDate, rhs.commissionDate)
		.append(this.archiveCodeBefore, rhs.archiveCodeBefore)
		.append(this.archiveCodeAfter, rhs.archiveCodeAfter)
		.append(this.commissionCorpName, rhs.commissionCorpName)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.printNumber, rhs.printNumber)
		.append(this.archivesId, rhs.archivesId)
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
		.append(this.commissionType) 
		.append(this.commissionDate) 
		.append(this.archiveCodeBefore) 
		.append(this.archiveCodeAfter) 
		.append(this.commissionCorpName) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.cczy06) 
		.append(this.ccpr08) 
		.append(this.printNumber) 
		.append(this.archivesId) 
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
		.append("commissionType", this.commissionType) 
		.append("commissionDate", this.commissionDate) 
		.append("archiveCodeBefore", this.archiveCodeBefore) 
		.append("archiveCodeAfter", this.archiveCodeAfter) 
		.append("commissionCorpName", this.commissionCorpName) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("cczy06", this.cczy06) 
		.append("ccpr08", this.ccpr08) 
		.append("printNumber", this.printNumber) 
		.append("archivesId", this.archivesId) 
		.append("personId", this.personId) 
		.toString();
	}
   
  

}