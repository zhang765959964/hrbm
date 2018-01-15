package com.xunfeng.business.personagency.archive.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 Form对象
* @author:jiangxin
* @createDate 2016-09-02 15:56:41 
* @version V1.0   
*/
public class ArchiveCheckoutForm extends BaseForm<ArchiveCheckout>
{
	// 主键ID
	protected Long  id;
	// 档案Id
	protected Long  archiveId;
	// 借阅类别(rsda_tab_checkouttype 1.借阅未出库2.借阅出库)
	protected Long  checkoutType;
	// 借阅日期
	protected java.util.Date  checkoutDate;
	// 借阅期限日期
	protected java.util.Date  checkoutPeriodDate;
	// 借阅单位
	protected String  checkoutCorp;
	// 借阅人
	protected String  checkoutPerson;
	// 借阅原因
	protected String  checkoutReason;
	// 借阅人员电话
	protected String  checkoutPersonPhone;
	// 借阅状态
	protected Long  checkoutStatus;
	// 借阅描述（备注）
	protected String  checkoutDesc;
	// 是否允许借出，允许，不允许。
	protected Long  confirmAllowFlag;
	// 档案室理由
	protected String  confirmReason;
	// 借阅返还登记经办日期
	protected java.util.Date  checkinDate;
	// 抵押物或者提交材料
	protected String  checkoutMortgage;
	// 是否接收抵押物
	protected Long  isReceiveMortgage;
	// 档案室是否返还抵押物
	protected Long  isRestoreMortgage;
	// 提档人
	protected String  checkoutPeopleMention;
	// 提档人联系方式
	protected String  checkoutPeoplePhone;
	// 提档人身份证号
	protected String  checkoutPeopleCard;
	// 借阅登记经办人id
	protected Long  checkoutRegisterId;
	// 借阅登记经办人姓名
	protected String  checkoutRegisterName;
	// 借阅登记经办机构id
	protected Long  checkoutRegisterOrgId;
	// 借阅登记经办机构名称
	protected String  checkoutRegisterOrgName;
	// 借阅登记经办日期
	protected java.util.Date  checkoutRegisterDate;
	// 借阅确认经办人id
	protected Long  checkoutConfirmId;
	// 借阅确认经办人姓名
	protected String  checkoutConfirmName;
	// 借阅确认经办人机构id
	protected Long  checkoutConfirmOrgId;
	// 借阅确认经办人机构名称
	protected String  checkoutConfirmOrgName;
	// 借阅确认经办日期
	protected java.util.Date  checkoutConfirmDate;
	// 借阅返还登记人id
	protected Long  checkinId;
	// 借阅返还登记人姓名
	protected String  checkinName;
	// 借阅返还登记机构id
	protected Long  checkinOrgId;
	// 借阅返还登记机构名称
	protected String  checkinOrgName;
	// 借阅返还确认人id
	protected Long  checkinConfirmId;
	// 借阅返还确认人姓名
	protected String  checkinConfirmName;
	// 借阅返还确认机构id
	protected Long  checkinConfirmOrgId;
	// 借阅返还确认机构名称
	protected String  checkinConfirmOrgName;
	// 借阅返还确认经办日期
	protected java.util.Date  checkinConfirmDate;
	// 扣押材料（rsda_tab_SEIZUREMATERIAL）
	protected Long  seizureMaterial;
	// 借阅种类(RSDA_TAB_CHECKOUKINDS)
	protected Long  checkoutKinds;
	// 借阅内容
	protected String  checkoutContent;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 生成批次名
	protected String  batchName;
	//单位档案批量借阅登记档案id
	protected String  archiveIds;
	
	
	
	public String getArchiveIds() {
		return archiveIds;
	}
	public void setArchiveIds(String archiveIds) {
		this.archiveIds = archiveIds;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键ID
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setArchiveId(Long archiveId) 
	{
		this.archiveId = archiveId;
	}
	/**
	 * 返回 档案Id
	 * @return
	 */
	public Long getArchiveId() 
	{
		return this.archiveId;
	}
	public void setCheckoutType(Long checkoutType) 
	{
		this.checkoutType = checkoutType;
	}
	/**
	 * 返回 借阅类别(rsda_tab_checkouttype 1.借阅未出库2.借阅出库)
	 * @return
	 */
	public Long getCheckoutType() 
	{
		return this.checkoutType;
	}
	public void setCheckoutDate(java.util.Date checkoutDate) 
	{
		this.checkoutDate = checkoutDate;
	}
	/**
	 * 返回 借阅日期
	 * @return
	 */
	public java.util.Date getCheckoutDate() 
	{
		return this.checkoutDate;
	}
	public void setCheckoutPeriodDate(java.util.Date checkoutPeriodDate) 
	{
		this.checkoutPeriodDate = checkoutPeriodDate;
	}
	/**
	 * 返回 借阅期限日期
	 * @return
	 */
	public java.util.Date getCheckoutPeriodDate() 
	{
		return this.checkoutPeriodDate;
	}
	public void setCheckoutCorp(String checkoutCorp) 
	{
		this.checkoutCorp = checkoutCorp;
	}
	/**
	 * 返回 借阅单位
	 * @return
	 */
	public String getCheckoutCorp() 
	{
		return this.checkoutCorp;
	}
	public void setCheckoutPerson(String checkoutPerson) 
	{
		this.checkoutPerson = checkoutPerson;
	}
	/**
	 * 返回 借阅人
	 * @return
	 */
	public String getCheckoutPerson() 
	{
		return this.checkoutPerson;
	}
	public void setCheckoutReason(String checkoutReason) 
	{
		this.checkoutReason = checkoutReason;
	}
	/**
	 * 返回 借阅原因
	 * @return
	 */
	public String getCheckoutReason() 
	{
		return this.checkoutReason;
	}
	public void setCheckoutPersonPhone(String checkoutPersonPhone) 
	{
		this.checkoutPersonPhone = checkoutPersonPhone;
	}
	/**
	 * 返回 借阅人员电话
	 * @return
	 */
	public String getCheckoutPersonPhone() 
	{
		return this.checkoutPersonPhone;
	}
	public void setCheckoutStatus(Long checkoutStatus) 
	{
		this.checkoutStatus = checkoutStatus;
	}
	/**
	 * 返回 借阅状态
	 * @return
	 */
	public Long getCheckoutStatus() 
	{
		return this.checkoutStatus;
	}
	public void setCheckoutDesc(String checkoutDesc) 
	{
		this.checkoutDesc = checkoutDesc;
	}
	/**
	 * 返回 借阅描述（备注）
	 * @return
	 */
	public String getCheckoutDesc() 
	{
		return this.checkoutDesc;
	}
	public void setConfirmAllowFlag(Long confirmAllowFlag) 
	{
		this.confirmAllowFlag = confirmAllowFlag;
	}
	/**
	 * 返回 是否允许借出，允许，不允许。
	 * @return
	 */
	public Long getConfirmAllowFlag() 
	{
		return this.confirmAllowFlag;
	}
	public void setConfirmReason(String confirmReason) 
	{
		this.confirmReason = confirmReason;
	}
	/**
	 * 返回 档案室理由
	 * @return
	 */
	public String getConfirmReason() 
	{
		return this.confirmReason;
	}
	public void setCheckinDate(java.util.Date checkinDate) 
	{
		this.checkinDate = checkinDate;
	}
	/**
	 * 返回 借阅返还登记经办日期
	 * @return
	 */
	public java.util.Date getCheckinDate() 
	{
		return this.checkinDate;
	}
	public void setCheckoutMortgage(String checkoutMortgage) 
	{
		this.checkoutMortgage = checkoutMortgage;
	}
	/**
	 * 返回 抵押物或者提交材料
	 * @return
	 */
	public String getCheckoutMortgage() 
	{
		return this.checkoutMortgage;
	}
	public void setIsReceiveMortgage(Long isReceiveMortgage) 
	{
		this.isReceiveMortgage = isReceiveMortgage;
	}
	/**
	 * 返回 是否接收抵押物
	 * @return
	 */
	public Long getIsReceiveMortgage() 
	{
		return this.isReceiveMortgage;
	}
	public void setIsRestoreMortgage(Long isRestoreMortgage) 
	{
		this.isRestoreMortgage = isRestoreMortgage;
	}
	/**
	 * 返回 档案室是否返还抵押物
	 * @return
	 */
	public Long getIsRestoreMortgage() 
	{
		return this.isRestoreMortgage;
	}
	public void setCheckoutPeopleMention(String checkoutPeopleMention) 
	{
		this.checkoutPeopleMention = checkoutPeopleMention;
	}
	/**
	 * 返回 提档人
	 * @return
	 */
	public String getCheckoutPeopleMention() 
	{
		return this.checkoutPeopleMention;
	}
	public void setCheckoutPeoplePhone(String checkoutPeoplePhone) 
	{
		this.checkoutPeoplePhone = checkoutPeoplePhone;
	}
	/**
	 * 返回 提档人联系方式
	 * @return
	 */
	public String getCheckoutPeoplePhone() 
	{
		return this.checkoutPeoplePhone;
	}
	public void setCheckoutPeopleCard(String checkoutPeopleCard) 
	{
		this.checkoutPeopleCard = checkoutPeopleCard;
	}
	/**
	 * 返回 提档人身份证号
	 * @return
	 */
	public String getCheckoutPeopleCard() 
	{
		return this.checkoutPeopleCard;
	}
	public void setCheckoutRegisterId(Long checkoutRegisterId) 
	{
		this.checkoutRegisterId = checkoutRegisterId;
	}
	/**
	 * 返回 借阅登记经办人id
	 * @return
	 */
	public Long getCheckoutRegisterId() 
	{
		return this.checkoutRegisterId;
	}
	public void setCheckoutRegisterName(String checkoutRegisterName) 
	{
		this.checkoutRegisterName = checkoutRegisterName;
	}
	/**
	 * 返回 借阅登记经办人姓名
	 * @return
	 */
	public String getCheckoutRegisterName() 
	{
		return this.checkoutRegisterName;
	}
	public void setCheckoutRegisterOrgId(Long checkoutRegisterOrgId) 
	{
		this.checkoutRegisterOrgId = checkoutRegisterOrgId;
	}
	/**
	 * 返回 借阅登记经办机构id
	 * @return
	 */
	public Long getCheckoutRegisterOrgId() 
	{
		return this.checkoutRegisterOrgId;
	}
	public void setCheckoutRegisterOrgName(String checkoutRegisterOrgName) 
	{
		this.checkoutRegisterOrgName = checkoutRegisterOrgName;
	}
	/**
	 * 返回 借阅登记经办机构名称
	 * @return
	 */
	public String getCheckoutRegisterOrgName() 
	{
		return this.checkoutRegisterOrgName;
	}
	public void setCheckoutRegisterDate(java.util.Date checkoutRegisterDate) 
	{
		this.checkoutRegisterDate = checkoutRegisterDate;
	}
	/**
	 * 返回 借阅登记经办日期
	 * @return
	 */
	public java.util.Date getCheckoutRegisterDate() 
	{
		return this.checkoutRegisterDate;
	}
	public void setCheckoutConfirmId(Long checkoutConfirmId) 
	{
		this.checkoutConfirmId = checkoutConfirmId;
	}
	/**
	 * 返回 借阅确认经办人id
	 * @return
	 */
	public Long getCheckoutConfirmId() 
	{
		return this.checkoutConfirmId;
	}
	public void setCheckoutConfirmName(String checkoutConfirmName) 
	{
		this.checkoutConfirmName = checkoutConfirmName;
	}
	/**
	 * 返回 借阅确认经办人姓名
	 * @return
	 */
	public String getCheckoutConfirmName() 
	{
		return this.checkoutConfirmName;
	}
	public void setCheckoutConfirmOrgId(Long checkoutConfirmOrgId) 
	{
		this.checkoutConfirmOrgId = checkoutConfirmOrgId;
	}
	/**
	 * 返回 借阅确认经办人机构id
	 * @return
	 */
	public Long getCheckoutConfirmOrgId() 
	{
		return this.checkoutConfirmOrgId;
	}
	public void setCheckoutConfirmOrgName(String checkoutConfirmOrgName) 
	{
		this.checkoutConfirmOrgName = checkoutConfirmOrgName;
	}
	/**
	 * 返回 借阅确认经办人机构名称
	 * @return
	 */
	public String getCheckoutConfirmOrgName() 
	{
		return this.checkoutConfirmOrgName;
	}
	public void setCheckoutConfirmDate(java.util.Date checkoutConfirmDate) 
	{
		this.checkoutConfirmDate = checkoutConfirmDate;
	}
	/**
	 * 返回 借阅确认经办日期
	 * @return
	 */
	public java.util.Date getCheckoutConfirmDate() 
	{
		return this.checkoutConfirmDate;
	}
	public void setCheckinId(Long checkinId) 
	{
		this.checkinId = checkinId;
	}
	/**
	 * 返回 借阅返还登记人id
	 * @return
	 */
	public Long getCheckinId() 
	{
		return this.checkinId;
	}
	public void setCheckinName(String checkinName) 
	{
		this.checkinName = checkinName;
	}
	/**
	 * 返回 借阅返还登记人姓名
	 * @return
	 */
	public String getCheckinName() 
	{
		return this.checkinName;
	}
	public void setCheckinOrgId(Long checkinOrgId) 
	{
		this.checkinOrgId = checkinOrgId;
	}
	/**
	 * 返回 借阅返还登记机构id
	 * @return
	 */
	public Long getCheckinOrgId() 
	{
		return this.checkinOrgId;
	}
	public void setCheckinOrgName(String checkinOrgName) 
	{
		this.checkinOrgName = checkinOrgName;
	}
	/**
	 * 返回 借阅返还登记机构名称
	 * @return
	 */
	public String getCheckinOrgName() 
	{
		return this.checkinOrgName;
	}
	public void setCheckinConfirmId(Long checkinConfirmId) 
	{
		this.checkinConfirmId = checkinConfirmId;
	}
	/**
	 * 返回 借阅返还确认人id
	 * @return
	 */
	public Long getCheckinConfirmId() 
	{
		return this.checkinConfirmId;
	}
	public void setCheckinConfirmName(String checkinConfirmName) 
	{
		this.checkinConfirmName = checkinConfirmName;
	}
	/**
	 * 返回 借阅返还确认人姓名
	 * @return
	 */
	public String getCheckinConfirmName() 
	{
		return this.checkinConfirmName;
	}
	public void setCheckinConfirmOrgId(Long checkinConfirmOrgId) 
	{
		this.checkinConfirmOrgId = checkinConfirmOrgId;
	}
	/**
	 * 返回 借阅返还确认机构id
	 * @return
	 */
	public Long getCheckinConfirmOrgId() 
	{
		return this.checkinConfirmOrgId;
	}
	public void setCheckinConfirmOrgName(String checkinConfirmOrgName) 
	{
		this.checkinConfirmOrgName = checkinConfirmOrgName;
	}
	/**
	 * 返回 借阅返还确认机构名称
	 * @return
	 */
	public String getCheckinConfirmOrgName() 
	{
		return this.checkinConfirmOrgName;
	}
	public void setCheckinConfirmDate(java.util.Date checkinConfirmDate) 
	{
		this.checkinConfirmDate = checkinConfirmDate;
	}
	/**
	 * 返回 借阅返还确认经办日期
	 * @return
	 */
	public java.util.Date getCheckinConfirmDate() 
	{
		return this.checkinConfirmDate;
	}
	public void setSeizureMaterial(Long seizureMaterial) 
	{
		this.seizureMaterial = seizureMaterial;
	}
	/**
	 * 返回 暂扣材料（rsda_tab_SEIZUREMATERIAL）
	 * @return
	 */
	public Long getSeizureMaterial() 
	{
		return this.seizureMaterial;
	}
	public void setCheckoutKinds(Long checkoutKinds) 
	{
		this.checkoutKinds = checkoutKinds;
	}
	/**
	 * 返回 借阅种类(RSDA_TAB_CHECKOUKINDS)
	 * @return
	 */
	public Long getCheckoutKinds() 
	{
		return this.checkoutKinds;
	}
	public void setCheckoutContent(String checkoutContent) 
	{
		this.checkoutContent = checkoutContent;
	}
	/**
	 * 返回 借阅内容
	 * @return
	 */
	public String getCheckoutContent() 
	{
		return this.checkoutContent;
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
	public void setBatchName(String batchName) 
	{
		this.batchName = batchName;
	}
	/**
	 * 返回 生成批次名
	 * @return
	 */
	public String getBatchName() 
	{
		return this.batchName;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ArchiveCheckoutForm)) 
		{
			return false;
		}
		ArchiveCheckoutForm rhs = (ArchiveCheckoutForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archiveId, rhs.archiveId)
		.append(this.checkoutType, rhs.checkoutType)
		.append(this.checkoutDate, rhs.checkoutDate)
		.append(this.checkoutPeriodDate, rhs.checkoutPeriodDate)
		.append(this.checkoutCorp, rhs.checkoutCorp)
		.append(this.checkoutPerson, rhs.checkoutPerson)
		.append(this.checkoutReason, rhs.checkoutReason)
		.append(this.checkoutPersonPhone, rhs.checkoutPersonPhone)
		.append(this.checkoutStatus, rhs.checkoutStatus)
		.append(this.checkoutDesc, rhs.checkoutDesc)
		.append(this.confirmAllowFlag, rhs.confirmAllowFlag)
		.append(this.confirmReason, rhs.confirmReason)
		.append(this.checkinDate, rhs.checkinDate)
		.append(this.checkoutMortgage, rhs.checkoutMortgage)
		.append(this.isReceiveMortgage, rhs.isReceiveMortgage)
		.append(this.isRestoreMortgage, rhs.isRestoreMortgage)
		.append(this.checkoutPeopleMention, rhs.checkoutPeopleMention)
		.append(this.checkoutPeoplePhone, rhs.checkoutPeoplePhone)
		.append(this.checkoutPeopleCard, rhs.checkoutPeopleCard)
		.append(this.checkoutRegisterId, rhs.checkoutRegisterId)
		.append(this.checkoutRegisterName, rhs.checkoutRegisterName)
		.append(this.checkoutRegisterOrgId, rhs.checkoutRegisterOrgId)
		.append(this.checkoutRegisterOrgName, rhs.checkoutRegisterOrgName)
		.append(this.checkoutRegisterDate, rhs.checkoutRegisterDate)
		.append(this.checkoutConfirmId, rhs.checkoutConfirmId)
		.append(this.checkoutConfirmName, rhs.checkoutConfirmName)
		.append(this.checkoutConfirmOrgId, rhs.checkoutConfirmOrgId)
		.append(this.checkoutConfirmOrgName, rhs.checkoutConfirmOrgName)
		.append(this.checkoutConfirmDate, rhs.checkoutConfirmDate)
		.append(this.checkinId, rhs.checkinId)
		.append(this.checkinName, rhs.checkinName)
		.append(this.checkinOrgId, rhs.checkinOrgId)
		.append(this.checkinOrgName, rhs.checkinOrgName)
		.append(this.checkinConfirmId, rhs.checkinConfirmId)
		.append(this.checkinConfirmName, rhs.checkinConfirmName)
		.append(this.checkinConfirmOrgId, rhs.checkinConfirmOrgId)
		.append(this.checkinConfirmOrgName, rhs.checkinConfirmOrgName)
		.append(this.checkinConfirmDate, rhs.checkinConfirmDate)
		.append(this.seizureMaterial, rhs.seizureMaterial)
		.append(this.checkoutKinds, rhs.checkoutKinds)
		.append(this.checkoutContent, rhs.checkoutContent)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.batchName, rhs.batchName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archiveId) 
		.append(this.checkoutType) 
		.append(this.checkoutDate) 
		.append(this.checkoutPeriodDate) 
		.append(this.checkoutCorp) 
		.append(this.checkoutPerson) 
		.append(this.checkoutReason) 
		.append(this.checkoutPersonPhone) 
		.append(this.checkoutStatus) 
		.append(this.checkoutDesc) 
		.append(this.confirmAllowFlag) 
		.append(this.confirmReason) 
		.append(this.checkinDate) 
		.append(this.checkoutMortgage) 
		.append(this.isReceiveMortgage) 
		.append(this.isRestoreMortgage) 
		.append(this.checkoutPeopleMention) 
		.append(this.checkoutPeoplePhone) 
		.append(this.checkoutPeopleCard) 
		.append(this.checkoutRegisterId) 
		.append(this.checkoutRegisterName) 
		.append(this.checkoutRegisterOrgId) 
		.append(this.checkoutRegisterOrgName) 
		.append(this.checkoutRegisterDate) 
		.append(this.checkoutConfirmId) 
		.append(this.checkoutConfirmName) 
		.append(this.checkoutConfirmOrgId) 
		.append(this.checkoutConfirmOrgName) 
		.append(this.checkoutConfirmDate) 
		.append(this.checkinId) 
		.append(this.checkinName) 
		.append(this.checkinOrgId) 
		.append(this.checkinOrgName) 
		.append(this.checkinConfirmId) 
		.append(this.checkinConfirmName) 
		.append(this.checkinConfirmOrgId) 
		.append(this.checkinConfirmOrgName) 
		.append(this.checkinConfirmDate) 
		.append(this.seizureMaterial) 
		.append(this.checkoutKinds) 
		.append(this.checkoutContent) 
		.append(this.ccpr08) 
		.append(this.batchName) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archiveId", this.archiveId) 
		.append("checkoutType", this.checkoutType) 
		.append("checkoutDate", this.checkoutDate) 
		.append("checkoutPeriodDate", this.checkoutPeriodDate) 
		.append("checkoutCorp", this.checkoutCorp) 
		.append("checkoutPerson", this.checkoutPerson) 
		.append("checkoutReason", this.checkoutReason) 
		.append("checkoutPersonPhone", this.checkoutPersonPhone) 
		.append("checkoutStatus", this.checkoutStatus) 
		.append("checkoutDesc", this.checkoutDesc) 
		.append("confirmAllowFlag", this.confirmAllowFlag) 
		.append("confirmReason", this.confirmReason) 
		.append("checkinDate", this.checkinDate) 
		.append("checkoutMortgage", this.checkoutMortgage) 
		.append("isReceiveMortgage", this.isReceiveMortgage) 
		.append("isRestoreMortgage", this.isRestoreMortgage) 
		.append("checkoutPeopleMention", this.checkoutPeopleMention) 
		.append("checkoutPeoplePhone", this.checkoutPeoplePhone) 
		.append("checkoutPeopleCard", this.checkoutPeopleCard) 
		.append("checkoutRegisterId", this.checkoutRegisterId) 
		.append("checkoutRegisterName", this.checkoutRegisterName) 
		.append("checkoutRegisterOrgId", this.checkoutRegisterOrgId) 
		.append("checkoutRegisterOrgName", this.checkoutRegisterOrgName) 
		.append("checkoutRegisterDate", this.checkoutRegisterDate) 
		.append("checkoutConfirmId", this.checkoutConfirmId) 
		.append("checkoutConfirmName", this.checkoutConfirmName) 
		.append("checkoutConfirmOrgId", this.checkoutConfirmOrgId) 
		.append("checkoutConfirmOrgName", this.checkoutConfirmOrgName) 
		.append("checkoutConfirmDate", this.checkoutConfirmDate) 
		.append("checkinId", this.checkinId) 
		.append("checkinName", this.checkinName) 
		.append("checkinOrgId", this.checkinOrgId) 
		.append("checkinOrgName", this.checkinOrgName) 
		.append("checkinConfirmId", this.checkinConfirmId) 
		.append("checkinConfirmName", this.checkinConfirmName) 
		.append("checkinConfirmOrgId", this.checkinConfirmOrgId) 
		.append("checkinConfirmOrgName", this.checkinConfirmOrgName) 
		.append("checkinConfirmDate", this.checkinConfirmDate) 
		.append("seizureMaterial", this.seizureMaterial) 
		.append("checkoutKinds", this.checkoutKinds) 
		.append("checkoutContent", this.checkoutContent) 
		.append("ccpr08", this.ccpr08) 
		.append("batchName", this.batchName) 
		.toString();
	}
   
  

}