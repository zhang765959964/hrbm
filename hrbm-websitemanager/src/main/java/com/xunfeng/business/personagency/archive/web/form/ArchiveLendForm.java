package com.xunfeng.business.personagency.archive.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 Form对象
* @author:wanghan
* @createDate 2016-08-05 13:12:48 
* @version V1.0   
*/
public class ArchiveLendForm extends BaseForm<ArchiveLend>
{
	// 主键id
	protected Long  lendId;
	// 档案id
	protected Long  archivesId;
	// 档案去向(单位)
	protected String  archivesLendWhere;
	// 调出时间
	protected java.util.Date  lendDate;
	// 调出原因
	protected Long  lendReason;
	// 调出备注
	protected String  lendRemarks;
	// 调出流转状态    4 调出登记 5 调出确认 6 调出完成
	protected Long  lendFlowStatus;
	// 调出人姓名
	protected String  lendName;
	// 调出人身份证号
	protected String  lendIdNumber;
	// 调出人联系方式
	protected String  lendPhone;
	// 提档人
	protected String  lendPeopleMention;
	// 提档人联系方式
	protected String  lendPeoplePhone;
	// 提档人身份证号
	protected String  lendPeopleCard;
	// 调出登记经办人id
	protected Long  lendCreaterId;
	// 调出登记经办人姓名
	protected String  lendCreaterName;
	// 调出登记经办机构id
	protected Long  lendCreaterOrgId;
	// 调出登记经办机构名称
	protected String  lendCreaterOrgName;
	// 调出登记经办日期
	protected java.util.Date  lendCreaterDate;
	// 调出原因（字符串）
	protected String  lendStringReason;
	// 调出确认经办人id
	protected Long  lendConfirmId;
	// 调出确认经办人姓名
	protected String  lendConfirmName;
	// 调出确认经办机构id
	protected Long  lendConfirmOrgId;
	// 调出确认经办机构名称
	protected String  lendConfirmOrgName;
	// 调出确认经办日期
	protected java.util.Date  lendConfirmDate;
	
	//单位档案批量调出登记档案id
	protected String  archiveIds;
	
	
	public String getArchiveIds() {
		return archiveIds;
	}
	public void setArchiveIds(String archiveIds) {
		this.archiveIds = archiveIds;
	}
	public void setLendId(Long lendId) 
	{
		this.lendId = lendId;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getLendId() 
	{
		return this.lendId;
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
	public void setArchivesLendWhere(String archivesLendWhere) 
	{
		this.archivesLendWhere = archivesLendWhere;
	}
	/**
	 * 返回 档案去向(单位)
	 * @return
	 */
	public String getArchivesLendWhere() 
	{
		return this.archivesLendWhere;
	}
	public void setLendDate(java.util.Date lendDate) 
	{
		this.lendDate = lendDate;
	}
	/**
	 * 返回 调出时间
	 * @return
	 */
	public java.util.Date getLendDate() 
	{
		return this.lendDate;
	}
	public void setLendReason(Long lendReason) 
	{
		this.lendReason = lendReason;
	}
	/**
	 * 返回 调出原因
	 * @return
	 */
	public Long getLendReason() 
	{
		return this.lendReason;
	}
	public void setLendRemarks(String lendRemarks) 
	{
		this.lendRemarks = lendRemarks;
	}
	/**
	 * 返回 调出备注
	 * @return
	 */
	public String getLendRemarks() 
	{
		return this.lendRemarks;
	}
	public void setLendFlowStatus(Long lendFlowStatus) 
	{
		this.lendFlowStatus = lendFlowStatus;
	}
	/**
	 * 返回 调出流转状态    4 调出登记 5 调出确认 6 调出完成
	 * @return
	 */
	public Long getLendFlowStatus() 
	{
		return this.lendFlowStatus;
	}
	public void setLendName(String lendName) 
	{
		this.lendName = lendName;
	}
	/**
	 * 返回 调出人姓名
	 * @return
	 */
	public String getLendName() 
	{
		return this.lendName;
	}
	public void setLendIdNumber(String lendIdNumber) 
	{
		this.lendIdNumber = lendIdNumber;
	}
	/**
	 * 返回 调出人身份证号
	 * @return
	 */
	public String getLendIdNumber() 
	{
		return this.lendIdNumber;
	}
	public void setLendPhone(String lendPhone) 
	{
		this.lendPhone = lendPhone;
	}
	/**
	 * 返回 调出人联系方式
	 * @return
	 */
	public String getLendPhone() 
	{
		return this.lendPhone;
	}
	public void setLendPeopleMention(String lendPeopleMention) 
	{
		this.lendPeopleMention = lendPeopleMention;
	}
	/**
	 * 返回 提档人
	 * @return
	 */
	public String getLendPeopleMention() 
	{
		return this.lendPeopleMention;
	}
	public void setLendPeoplePhone(String lendPeoplePhone) 
	{
		this.lendPeoplePhone = lendPeoplePhone;
	}
	/**
	 * 返回 提档人联系方式
	 * @return
	 */
	public String getLendPeoplePhone() 
	{
		return this.lendPeoplePhone;
	}
	public void setLendPeopleCard(String lendPeopleCard) 
	{
		this.lendPeopleCard = lendPeopleCard;
	}
	/**
	 * 返回 提档人身份证号
	 * @return
	 */
	public String getLendPeopleCard() 
	{
		return this.lendPeopleCard;
	}
	public void setLendCreaterId(Long lendCreaterId) 
	{
		this.lendCreaterId = lendCreaterId;
	}
	/**
	 * 返回 调出登记经办人id
	 * @return
	 */
	public Long getLendCreaterId() 
	{
		return this.lendCreaterId;
	}
	public void setLendCreaterName(String lendCreaterName) 
	{
		this.lendCreaterName = lendCreaterName;
	}
	/**
	 * 返回 调出登记经办人姓名
	 * @return
	 */
	public String getLendCreaterName() 
	{
		return this.lendCreaterName;
	}
	public void setLendCreaterOrgId(Long lendCreaterOrgId) 
	{
		this.lendCreaterOrgId = lendCreaterOrgId;
	}
	/**
	 * 返回 调出登记经办机构id
	 * @return
	 */
	public Long getLendCreaterOrgId() 
	{
		return this.lendCreaterOrgId;
	}
	public void setLendCreaterOrgName(String lendCreaterOrgName) 
	{
		this.lendCreaterOrgName = lendCreaterOrgName;
	}
	/**
	 * 返回 调出登记经办机构名称
	 * @return
	 */
	public String getLendCreaterOrgName() 
	{
		return this.lendCreaterOrgName;
	}
	public void setLendCreaterDate(java.util.Date lendCreaterDate) 
	{
		this.lendCreaterDate = lendCreaterDate;
	}
	/**
	 * 返回 调出登记经办日期
	 * @return
	 */
	public java.util.Date getLendCreaterDate() 
	{
		return this.lendCreaterDate;
	}
	public void setLendStringReason(String lendStringReason) 
	{
		this.lendStringReason = lendStringReason;
	}
	/**
	 * 返回 调出原因（字符串）
	 * @return
	 */
	public String getLendStringReason() 
	{
		return this.lendStringReason;
	}
	public void setLendConfirmId(Long lendConfirmId) 
	{
		this.lendConfirmId = lendConfirmId;
	}
	/**
	 * 返回 调出确认经办人id
	 * @return
	 */
	public Long getLendConfirmId() 
	{
		return this.lendConfirmId;
	}
	public void setLendConfirmName(String lendConfirmName) 
	{
		this.lendConfirmName = lendConfirmName;
	}
	/**
	 * 返回 调出确认经办人姓名
	 * @return
	 */
	public String getLendConfirmName() 
	{
		return this.lendConfirmName;
	}
	public void setLendConfirmOrgId(Long lendConfirmOrgId) 
	{
		this.lendConfirmOrgId = lendConfirmOrgId;
	}
	/**
	 * 返回 调出确认经办机构id
	 * @return
	 */
	public Long getLendConfirmOrgId() 
	{
		return this.lendConfirmOrgId;
	}
	public void setLendConfirmOrgName(String lendConfirmOrgName) 
	{
		this.lendConfirmOrgName = lendConfirmOrgName;
	}
	/**
	 * 返回 调出确认经办机构名称
	 * @return
	 */
	public String getLendConfirmOrgName() 
	{
		return this.lendConfirmOrgName;
	}
	public void setLendConfirmDate(java.util.Date lendConfirmDate) 
	{
		this.lendConfirmDate = lendConfirmDate;
	}
	/**
	 * 返回 调出确认经办日期
	 * @return
	 */
	public java.util.Date getLendConfirmDate() 
	{
		return this.lendConfirmDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ArchiveLendForm)) 
		{
			return false;
		}
		ArchiveLendForm rhs = (ArchiveLendForm) object;
		return new EqualsBuilder()
		.append(this.lendId, rhs.lendId)
		.append(this.archivesId, rhs.archivesId)
		.append(this.archivesLendWhere, rhs.archivesLendWhere)
		.append(this.lendDate, rhs.lendDate)
		.append(this.lendReason, rhs.lendReason)
		.append(this.lendRemarks, rhs.lendRemarks)
		.append(this.lendFlowStatus, rhs.lendFlowStatus)
		.append(this.lendName, rhs.lendName)
		.append(this.lendIdNumber, rhs.lendIdNumber)
		.append(this.lendPhone, rhs.lendPhone)
		.append(this.lendPeopleMention, rhs.lendPeopleMention)
		.append(this.lendPeoplePhone, rhs.lendPeoplePhone)
		.append(this.lendPeopleCard, rhs.lendPeopleCard)
		.append(this.lendCreaterId, rhs.lendCreaterId)
		.append(this.lendCreaterName, rhs.lendCreaterName)
		.append(this.lendCreaterOrgId, rhs.lendCreaterOrgId)
		.append(this.lendCreaterOrgName, rhs.lendCreaterOrgName)
		.append(this.lendCreaterDate, rhs.lendCreaterDate)
		.append(this.lendStringReason, rhs.lendStringReason)
		.append(this.lendConfirmId, rhs.lendConfirmId)
		.append(this.lendConfirmName, rhs.lendConfirmName)
		.append(this.lendConfirmOrgId, rhs.lendConfirmOrgId)
		.append(this.lendConfirmOrgName, rhs.lendConfirmOrgName)
		.append(this.lendConfirmDate, rhs.lendConfirmDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.lendId) 
		.append(this.archivesId) 
		.append(this.archivesLendWhere) 
		.append(this.lendDate) 
		.append(this.lendReason) 
		.append(this.lendRemarks) 
		.append(this.lendFlowStatus) 
		.append(this.lendName) 
		.append(this.lendIdNumber) 
		.append(this.lendPhone) 
		.append(this.lendPeopleMention) 
		.append(this.lendPeoplePhone) 
		.append(this.lendPeopleCard) 
		.append(this.lendCreaterId) 
		.append(this.lendCreaterName) 
		.append(this.lendCreaterOrgId) 
		.append(this.lendCreaterOrgName) 
		.append(this.lendCreaterDate) 
		.append(this.lendStringReason) 
		.append(this.lendConfirmId) 
		.append(this.lendConfirmName) 
		.append(this.lendConfirmOrgId) 
		.append(this.lendConfirmOrgName) 
		.append(this.lendConfirmDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("lendId", this.lendId) 
		.append("archivesId", this.archivesId) 
		.append("archivesLendWhere", this.archivesLendWhere) 
		.append("lendDate", this.lendDate) 
		.append("lendReason", this.lendReason) 
		.append("lendRemarks", this.lendRemarks) 
		.append("lendFlowStatus", this.lendFlowStatus) 
		.append("lendName", this.lendName) 
		.append("lendIdNumber", this.lendIdNumber) 
		.append("lendPhone", this.lendPhone) 
		.append("lendPeopleMention", this.lendPeopleMention) 
		.append("lendPeoplePhone", this.lendPeoplePhone) 
		.append("lendPeopleCard", this.lendPeopleCard) 
		.append("lendCreaterId", this.lendCreaterId) 
		.append("lendCreaterName", this.lendCreaterName) 
		.append("lendCreaterOrgId", this.lendCreaterOrgId) 
		.append("lendCreaterOrgName", this.lendCreaterOrgName) 
		.append("lendCreaterDate", this.lendCreaterDate) 
		.append("lendStringReason", this.lendStringReason) 
		.append("lendConfirmId", this.lendConfirmId) 
		.append("lendConfirmName", this.lendConfirmName) 
		.append("lendConfirmOrgId", this.lendConfirmOrgId) 
		.append("lendConfirmOrgName", this.lendConfirmOrgName) 
		.append("lendConfirmDate", this.lendConfirmDate) 
		.toString();
	}
   
  

}