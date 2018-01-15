package com.xunfeng.business.personagency.social.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.social.model.SocialsecTransfer;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保统筹范围内转移表 Form对象
* @author:jiangxin
* @createDate 2016-08-12 15:39:20 
* @version V1.0   
*/
public class SocialsecTransferForm extends BaseForm<SocialsecTransfer>
{
	// 主键ID
	protected Long  id;
	// 个人社保ID
	protected Long  socialSecId;
	// 档案编号
	protected String  archiveCode;
	// 公民身份证号码
	protected String  aac002;
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
	// 人员ID
	protected Long  personId;
	// 居住所在地（家庭住址）
	protected String  aab301;
	// 邮政编码
	protected String  aae007;
	// 变更内容(RSDA_TAB_CHANGE_CONTENTTWO)
	protected String  changeContenttwo;
	// 养老保险月缴费基数
	protected String  pensionBase;
	// 档案id
	protected Long  archivesId;
	// 联系电话
	protected String  expPersonPhone;
	// 医疗保险月缴费基数
	protected String  medicalBase;
	// 原参保地缴费起始时间
	protected java.util.Date  yuanStartDate;
	// 原参保地缴费截止时间
	protected java.util.Date  yuanEndDate;
	// 原单位名称
	protected String  yuanCorpName;
	// 原单位编号
	protected String  yuanCorpNumber;
	// 原社保机构名称
	protected String  yuanSocialName;
	// 现单位名称
	protected String  xianCorpName;
	// 现单位编号
	protected String  xianCorpNumber;
	// 现社保机构名称
	protected String  xianSocialName;
	// 备注
	protected String  description;
	// 经办人id
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
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
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
	public void setChangeContenttwo(String changeContenttwo) 
	{
		this.changeContenttwo = changeContenttwo;
	}
	/**
	 * 返回 变更内容(RSDA_TAB_CHANGE_CONTENTTWO)
	 * @return
	 */
	public String getChangeContenttwo() 
	{
		return this.changeContenttwo;
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
	public void setYuanStartDate(java.util.Date yuanStartDate) 
	{
		this.yuanStartDate = yuanStartDate;
	}
	/**
	 * 返回 原参保地缴费起始时间
	 * @return
	 */
	public java.util.Date getYuanStartDate() 
	{
		return this.yuanStartDate;
	}
	public void setYuanEndDate(java.util.Date yuanEndDate) 
	{
		this.yuanEndDate = yuanEndDate;
	}
	/**
	 * 返回 原参保地缴费截止时间
	 * @return
	 */
	public java.util.Date getYuanEndDate() 
	{
		return this.yuanEndDate;
	}
	public void setYuanCorpName(String yuanCorpName) 
	{
		this.yuanCorpName = yuanCorpName;
	}
	/**
	 * 返回 原单位名称
	 * @return
	 */
	public String getYuanCorpName() 
	{
		return this.yuanCorpName;
	}
	public void setYuanCorpNumber(String yuanCorpNumber) 
	{
		this.yuanCorpNumber = yuanCorpNumber;
	}
	/**
	 * 返回 原单位编号
	 * @return
	 */
	public String getYuanCorpNumber() 
	{
		return this.yuanCorpNumber;
	}
	public void setYuanSocialName(String yuanSocialName) 
	{
		this.yuanSocialName = yuanSocialName;
	}
	/**
	 * 返回 原社保机构名称
	 * @return
	 */
	public String getYuanSocialName() 
	{
		return this.yuanSocialName;
	}
	public void setXianCorpName(String xianCorpName) 
	{
		this.xianCorpName = xianCorpName;
	}
	/**
	 * 返回 现单位名称
	 * @return
	 */
	public String getXianCorpName() 
	{
		return this.xianCorpName;
	}
	public void setXianCorpNumber(String xianCorpNumber) 
	{
		this.xianCorpNumber = xianCorpNumber;
	}
	/**
	 * 返回 现单位编号
	 * @return
	 */
	public String getXianCorpNumber() 
	{
		return this.xianCorpNumber;
	}
	public void setXianSocialName(String xianSocialName) 
	{
		this.xianSocialName = xianSocialName;
	}
	/**
	 * 返回 现社保机构名称
	 * @return
	 */
	public String getXianSocialName() 
	{
		return this.xianSocialName;
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
		if (!(object instanceof SocialsecTransferForm)) 
		{
			return false;
		}
		SocialsecTransferForm rhs = (SocialsecTransferForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.socialSecId, rhs.socialSecId)
		.append(this.archiveCode, rhs.archiveCode)
		.append(this.aac002, rhs.aac002)
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
		.append(this.personId, rhs.personId)
		.append(this.aab301, rhs.aab301)
		.append(this.aae007, rhs.aae007)
		.append(this.changeContenttwo, rhs.changeContenttwo)
		.append(this.pensionBase, rhs.pensionBase)
		.append(this.archivesId, rhs.archivesId)
		.append(this.expPersonPhone, rhs.expPersonPhone)
		.append(this.medicalBase, rhs.medicalBase)
		.append(this.yuanStartDate, rhs.yuanStartDate)
		.append(this.yuanEndDate, rhs.yuanEndDate)
		.append(this.yuanCorpName, rhs.yuanCorpName)
		.append(this.yuanCorpNumber, rhs.yuanCorpNumber)
		.append(this.yuanSocialName, rhs.yuanSocialName)
		.append(this.xianCorpName, rhs.xianCorpName)
		.append(this.xianCorpNumber, rhs.xianCorpNumber)
		.append(this.xianSocialName, rhs.xianSocialName)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.isEffective, rhs.isEffective)
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
		.append(this.socialSecId) 
		.append(this.archiveCode) 
		.append(this.aac002) 
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
		.append(this.personId) 
		.append(this.aab301) 
		.append(this.aae007) 
		.append(this.changeContenttwo) 
		.append(this.pensionBase) 
		.append(this.archivesId) 
		.append(this.expPersonPhone) 
		.append(this.medicalBase) 
		.append(this.yuanStartDate) 
		.append(this.yuanEndDate) 
		.append(this.yuanCorpName) 
		.append(this.yuanCorpNumber) 
		.append(this.yuanSocialName) 
		.append(this.xianCorpName) 
		.append(this.xianCorpNumber) 
		.append(this.xianSocialName) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.isEffective) 
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
		.append("socialSecId", this.socialSecId) 
		.append("archiveCode", this.archiveCode) 
		.append("aac002", this.aac002) 
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
		.append("personId", this.personId) 
		.append("aab301", this.aab301) 
		.append("aae007", this.aae007) 
		.append("changeContenttwo", this.changeContenttwo) 
		.append("pensionBase", this.pensionBase) 
		.append("archivesId", this.archivesId) 
		.append("expPersonPhone", this.expPersonPhone) 
		.append("medicalBase", this.medicalBase) 
		.append("yuanStartDate", this.yuanStartDate) 
		.append("yuanEndDate", this.yuanEndDate) 
		.append("yuanCorpName", this.yuanCorpName) 
		.append("yuanCorpNumber", this.yuanCorpNumber) 
		.append("yuanSocialName", this.yuanSocialName) 
		.append("xianCorpName", this.xianCorpName) 
		.append("xianCorpNumber", this.xianCorpNumber) 
		.append("xianSocialName", this.xianSocialName) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("isEffective", this.isEffective) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}