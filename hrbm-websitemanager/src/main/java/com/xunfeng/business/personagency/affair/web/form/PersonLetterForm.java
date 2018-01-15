package com.xunfeng.business.personagency.affair.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.affair.model.PersonLetter;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人事档案联系函表 Form对象
* @author:jiangxin
* @createDate 2016-09-14 09:32:03 
* @version V1.0   
*/
public class PersonLetterForm extends BaseForm<PersonLetter>
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 姓名
	protected String  aac003;
	// 文件号
	protected String  fileNumber;
	// 工作单位
	protected String  workUnit;
	// 代管内容
	protected String  escrowContent;
	// 事由
	protected String  reason;
	// 办理事项
	protected String  handlingMatters;
	// 开具日期
	protected java.util.Date  dateOfIssue;
	// 第4项内容
	protected String  fourthItems;
	// 数据来源（16人事档案）
	protected String  cczy06;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 经办人id
	protected Long  createrId;
	// 经办人姓名
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
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
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setFileNumber(String fileNumber) 
	{
		this.fileNumber = fileNumber;
	}
	/**
	 * 返回 文件号
	 * @return
	 */
	public String getFileNumber() 
	{
		return this.fileNumber;
	}
	public void setWorkUnit(String workUnit) 
	{
		this.workUnit = workUnit;
	}
	/**
	 * 返回 工作单位
	 * @return
	 */
	public String getWorkUnit() 
	{
		return this.workUnit;
	}
	public void setEscrowContent(String escrowContent) 
	{
		this.escrowContent = escrowContent;
	}
	/**
	 * 返回 代管内容
	 * @return
	 */
	public String getEscrowContent() 
	{
		return this.escrowContent;
	}
	public void setReason(String reason) 
	{
		this.reason = reason;
	}
	/**
	 * 返回 事由
	 * @return
	 */
	public String getReason() 
	{
		return this.reason;
	}
	public void setHandlingMatters(String handlingMatters) 
	{
		this.handlingMatters = handlingMatters;
	}
	/**
	 * 返回 办理事项
	 * @return
	 */
	public String getHandlingMatters() 
	{
		return this.handlingMatters;
	}
	public void setDateOfIssue(java.util.Date dateOfIssue) 
	{
		this.dateOfIssue = dateOfIssue;
	}
	/**
	 * 返回 开具日期
	 * @return
	 */
	public java.util.Date getDateOfIssue() 
	{
		return this.dateOfIssue;
	}
	public void setFourthItems(String fourthItems) 
	{
		this.fourthItems = fourthItems;
	}
	/**
	 * 返回 第4项内容
	 * @return
	 */
	public String getFourthItems() 
	{
		return this.fourthItems;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源（16人事档案）
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
	 * 返回 经办机构名称
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
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonLetterForm)) 
		{
			return false;
		}
		PersonLetterForm rhs = (PersonLetterForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.aac003, rhs.aac003)
		.append(this.fileNumber, rhs.fileNumber)
		.append(this.workUnit, rhs.workUnit)
		.append(this.escrowContent, rhs.escrowContent)
		.append(this.reason, rhs.reason)
		.append(this.handlingMatters, rhs.handlingMatters)
		.append(this.dateOfIssue, rhs.dateOfIssue)
		.append(this.fourthItems, rhs.fourthItems)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archivesId) 
		.append(this.personId) 
		.append(this.aac003) 
		.append(this.fileNumber) 
		.append(this.workUnit) 
		.append(this.escrowContent) 
		.append(this.reason) 
		.append(this.handlingMatters) 
		.append(this.dateOfIssue) 
		.append(this.fourthItems) 
		.append(this.cczy06) 
		.append(this.ccpr08) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archivesId", this.archivesId) 
		.append("personId", this.personId) 
		.append("aac003", this.aac003) 
		.append("fileNumber", this.fileNumber) 
		.append("workUnit", this.workUnit) 
		.append("escrowContent", this.escrowContent) 
		.append("reason", this.reason) 
		.append("handlingMatters", this.handlingMatters) 
		.append("dateOfIssue", this.dateOfIssue) 
		.append("fourthItems", this.fourthItems) 
		.append("cczy06", this.cczy06) 
		.append("ccpr08", this.ccpr08) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.toString();
	}
   
  

}