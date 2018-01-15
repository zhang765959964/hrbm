package com.xunfeng.business.personagency.social.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保变更申报记录表 Model对象
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
public class ChangeReporting extends BaseModel
{
	// 主键ID
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 档案编号
	protected String  archiveCode;
	// 公民身份证号码
	protected String  aac002;
	// 个人id
	protected Long  personId;
	// 性别
	protected String  aac004;
	// 民族
	protected String  aac005;
	// 姓名
	protected String  aac003;
	// 出生日期
	protected java.util.Date  aac006;
	// 个人编号
	protected String  expPersonNumber;
	// 参加工作时间
	protected java.util.Date  expStartJobDate;
	// 参加养老保险时间
	protected java.util.Date  expPensionDate;
	// 参加医疗保险时间
	protected java.util.Date  expMedicalDate;
	// 用工形式
	protected String  employmentForm;
	// 固定电话
	protected String  aae005;
	// 联系电话
	protected String  expPersonPhone;
	// 居住所在地（家庭住址）
	protected String  aab301;
	// 邮政编码
	protected String  aae007;
	// 变更内容
	protected String  changeContent;
	// 缴费开始年月
	protected java.util.Date  paymentStartDate;
	// 缴费终止年月
	protected java.util.Date  paymentEndDate;
	// 停保原因
	protected String  reasonsForStopping;
	// 是否在外地参加过保险（0-否，1-是）
	protected String  addIsInsurance;
	// 养老保险月缴费基数
	protected String  pensionBase;
	// 医疗保险月缴费基数
	protected String  medicalBase;
	// 转出社保机构名称
	protected String  checkoutSocialOrgName;
	// 外地缴费开始时间
	protected java.util.Date  fieldStartDate;
	// 外地缴费终止时间
	protected java.util.Date  fieldEndDate;
	// 停保时间
	protected java.util.Date  stopSocialDate;
	// 备注
	protected String  description;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 有效标识（0-有效，1-无效）
	protected String  isEffective;
	// 个人社保ID
	protected Long  socialSecId;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
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
	public void setArchiveCode(String archiveCode) 
	{
		this.archiveCode = archiveCode;
	}
	/**
	 * 返回 档案编号
	 * @return
	 */
	public String getArchiveCode() 
	{
		return this.archiveCode;
	}
	public void setAac002(String aac002) 
	{
		this.aac002 = aac002;
	}
	/**
	 * 返回 公民身份证号码
	 * @return
	 */
	public String getAac002() 
	{
		return this.aac002;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 个人id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setAac005(String aac005) 
	{
		this.aac005 = aac005;
	}
	/**
	 * 返回 民族
	 * @return
	 */
	public String getAac005() 
	{
		return this.aac005;
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
	public void setAac006(java.util.Date aac006) 
	{
		this.aac006 = aac006;
	}
	/**
	 * 返回 出生日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getAac006() 
	{
		return this.aac006;
	}
	public void setExpPersonNumber(String expPersonNumber) 
	{
		this.expPersonNumber = expPersonNumber;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public String getExpPersonNumber() 
	{
		return this.expPersonNumber;
	}
	public void setExpStartJobDate(java.util.Date expStartJobDate) 
	{
		this.expStartJobDate = expStartJobDate;
	}
	/**
	 * 返回 参加工作时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getExpStartJobDate() 
	{
		return this.expStartJobDate;
	}
	public void setExpPensionDate(java.util.Date expPensionDate) 
	{
		this.expPensionDate = expPensionDate;
	}
	/**
	 * 返回 参加养老保险时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getExpPensionDate() 
	{
		return this.expPensionDate;
	}
	public void setExpMedicalDate(java.util.Date expMedicalDate) 
	{
		this.expMedicalDate = expMedicalDate;
	}
	/**
	 * 返回 参加医疗保险时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getExpMedicalDate() 
	{
		return this.expMedicalDate;
	}
	public void setEmploymentForm(String employmentForm) 
	{
		this.employmentForm = employmentForm;
	}
	/**
	 * 返回 用工形式
	 * @return
	 */
	public String getEmploymentForm() 
	{
		return this.employmentForm;
	}
	public void setAae005(String aae005) 
	{
		this.aae005 = aae005;
	}
	/**
	 * 返回 固定电话
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setExpPersonPhone(String expPersonPhone) 
	{
		this.expPersonPhone = expPersonPhone;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getExpPersonPhone() 
	{
		return this.expPersonPhone;
	}
	public void setAab301(String aab301) 
	{
		this.aab301 = aab301;
	}
	/**
	 * 返回 居住所在地（家庭住址）
	 * @return
	 */
	public String getAab301() 
	{
		return this.aab301;
	}
	public void setAae007(String aae007) 
	{
		this.aae007 = aae007;
	}
	/**
	 * 返回 邮政编码
	 * @return
	 */
	public String getAae007() 
	{
		return this.aae007;
	}
	public void setChangeContent(String changeContent) 
	{
		this.changeContent = changeContent;
	}
	/**
	 * 返回 变更内容
	 * @return
	 */
	public String getChangeContent() 
	{
		return this.changeContent;
	}
	public void setPaymentStartDate(java.util.Date paymentStartDate) 
	{
		this.paymentStartDate = paymentStartDate;
	}
	/**
	 * 返回 缴费开始年月
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPaymentStartDate() 
	{
		return this.paymentStartDate;
	}
	public void setPaymentEndDate(java.util.Date paymentEndDate) 
	{
		this.paymentEndDate = paymentEndDate;
	}
	/**
	 * 返回 缴费终止年月
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPaymentEndDate() 
	{
		return this.paymentEndDate;
	}
	public void setReasonsForStopping(String reasonsForStopping) 
	{
		this.reasonsForStopping = reasonsForStopping;
	}
	/**
	 * 返回 停保原因
	 * @return
	 */
	public String getReasonsForStopping() 
	{
		return this.reasonsForStopping;
	}
	public void setAddIsInsurance(String addIsInsurance) 
	{
		this.addIsInsurance = addIsInsurance;
	}
	/**
	 * 返回 是否在外地参加过保险（0-否，1-是）
	 * @return
	 */
	public String getAddIsInsurance() 
	{
		return this.addIsInsurance;
	}
	public void setPensionBase(String pensionBase) 
	{
		this.pensionBase = pensionBase;
	}
	/**
	 * 返回 养老保险月缴费基数
	 * @return
	 */
	public String getPensionBase() 
	{
		return this.pensionBase;
	}
	public void setMedicalBase(String medicalBase) 
	{
		this.medicalBase = medicalBase;
	}
	/**
	 * 返回 医疗保险月缴费基数
	 * @return
	 */
	public String getMedicalBase() 
	{
		return this.medicalBase;
	}
	public void setCheckoutSocialOrgName(String checkoutSocialOrgName) 
	{
		this.checkoutSocialOrgName = checkoutSocialOrgName;
	}
	/**
	 * 返回 转出社保机构名称
	 * @return
	 */
	public String getCheckoutSocialOrgName() 
	{
		return this.checkoutSocialOrgName;
	}
	public void setFieldStartDate(java.util.Date fieldStartDate) 
	{
		this.fieldStartDate = fieldStartDate;
	}
	/**
	 * 返回 外地缴费开始时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFieldStartDate() 
	{
		return this.fieldStartDate;
	}
	public void setFieldEndDate(java.util.Date fieldEndDate) 
	{
		this.fieldEndDate = fieldEndDate;
	}
	/**
	 * 返回 外地缴费终止时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFieldEndDate() 
	{
		return this.fieldEndDate;
	}
	public void setStopSocialDate(java.util.Date stopSocialDate) 
	{
		this.stopSocialDate = stopSocialDate;
	}
	/**
	 * 返回 停保时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getStopSocialDate() 
	{
		return this.stopSocialDate;
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
	 * 返回 经办人
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
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setIsEffective(String isEffective) 
	{
		this.isEffective = isEffective;
	}
	/**
	 * 返回 有效标识（0-有效，1-无效）
	 * @return
	 */
	public String getIsEffective() 
	{
		return this.isEffective;
	}
	public void setSocialSecId(Long socialSecId) 
	{
		this.socialSecId = socialSecId;
	}
	/**
	 * 返回 个人社保ID
	 * @return
	 */
	public Long getSocialSecId() 
	{
		return this.socialSecId;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ChangeReporting)) 
		{
			return false;
		}
		ChangeReporting rhs = (ChangeReporting) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.archiveCode, rhs.archiveCode)
		.append(this.aac002, rhs.aac002)
		.append(this.personId, rhs.personId)
		.append(this.aac004, rhs.aac004)
		.append(this.aac005, rhs.aac005)
		.append(this.aac003, rhs.aac003)
		.append(this.aac006, rhs.aac006)
		.append(this.expPersonNumber, rhs.expPersonNumber)
		.append(this.expStartJobDate, rhs.expStartJobDate)
		.append(this.expPensionDate, rhs.expPensionDate)
		.append(this.expMedicalDate, rhs.expMedicalDate)
		.append(this.employmentForm, rhs.employmentForm)
		.append(this.aae005, rhs.aae005)
		.append(this.expPersonPhone, rhs.expPersonPhone)
		.append(this.aab301, rhs.aab301)
		.append(this.aae007, rhs.aae007)
		.append(this.changeContent, rhs.changeContent)
		.append(this.paymentStartDate, rhs.paymentStartDate)
		.append(this.paymentEndDate, rhs.paymentEndDate)
		.append(this.reasonsForStopping, rhs.reasonsForStopping)
		.append(this.addIsInsurance, rhs.addIsInsurance)
		.append(this.pensionBase, rhs.pensionBase)
		.append(this.medicalBase, rhs.medicalBase)
		.append(this.checkoutSocialOrgName, rhs.checkoutSocialOrgName)
		.append(this.fieldStartDate, rhs.fieldStartDate)
		.append(this.fieldEndDate, rhs.fieldEndDate)
		.append(this.stopSocialDate, rhs.stopSocialDate)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.isEffective, rhs.isEffective)
		.append(this.socialSecId, rhs.socialSecId)
		.append(this.ccpr08, rhs.ccpr08)
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
		.append(this.archiveCode) 
		.append(this.aac002) 
		.append(this.personId) 
		.append(this.aac004) 
		.append(this.aac005) 
		.append(this.aac003) 
		.append(this.aac006) 
		.append(this.expPersonNumber) 
		.append(this.expStartJobDate) 
		.append(this.expPensionDate) 
		.append(this.expMedicalDate) 
		.append(this.employmentForm) 
		.append(this.aae005) 
		.append(this.expPersonPhone) 
		.append(this.aab301) 
		.append(this.aae007) 
		.append(this.changeContent) 
		.append(this.paymentStartDate) 
		.append(this.paymentEndDate) 
		.append(this.reasonsForStopping) 
		.append(this.addIsInsurance) 
		.append(this.pensionBase) 
		.append(this.medicalBase) 
		.append(this.checkoutSocialOrgName) 
		.append(this.fieldStartDate) 
		.append(this.fieldEndDate) 
		.append(this.stopSocialDate) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.isEffective) 
		.append(this.socialSecId) 
		.append(this.ccpr08) 
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
		.append("archiveCode", this.archiveCode) 
		.append("aac002", this.aac002) 
		.append("personId", this.personId) 
		.append("aac004", this.aac004) 
		.append("aac005", this.aac005) 
		.append("aac003", this.aac003) 
		.append("aac006", this.aac006) 
		.append("expPersonNumber", this.expPersonNumber) 
		.append("expStartJobDate", this.expStartJobDate) 
		.append("expPensionDate", this.expPensionDate) 
		.append("expMedicalDate", this.expMedicalDate) 
		.append("employmentForm", this.employmentForm) 
		.append("aae005", this.aae005) 
		.append("expPersonPhone", this.expPersonPhone) 
		.append("aab301", this.aab301) 
		.append("aae007", this.aae007) 
		.append("changeContent", this.changeContent) 
		.append("paymentStartDate", this.paymentStartDate) 
		.append("paymentEndDate", this.paymentEndDate) 
		.append("reasonsForStopping", this.reasonsForStopping) 
		.append("addIsInsurance", this.addIsInsurance) 
		.append("pensionBase", this.pensionBase) 
		.append("medicalBase", this.medicalBase) 
		.append("checkoutSocialOrgName", this.checkoutSocialOrgName) 
		.append("fieldStartDate", this.fieldStartDate) 
		.append("fieldEndDate", this.fieldEndDate) 
		.append("stopSocialDate", this.stopSocialDate) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("isEffective", this.isEffective) 
		.append("socialSecId", this.socialSecId) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}