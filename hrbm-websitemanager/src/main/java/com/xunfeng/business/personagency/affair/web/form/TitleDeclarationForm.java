package com.xunfeng.business.personagency.affair.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.affair.model.TitleDeclaration;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职称申报评定表 Form对象
* @author:jiangxin
* @createDate 2016-09-18 15:38:07 
* @version V1.0   
*/
public class TitleDeclarationForm extends BaseForm<TitleDeclaration>
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 序号
	protected String  serialNumber;
	// 联系电话
	protected String  contactNumber;
	// 工作单位
	protected String  workUnit;
	// 工作年龄
	protected Long  workingAge;
	// 现职称级别
	protected Long  nowTitleGrade;
	// 申报级别
	protected Long  declarationLevel;
	// 评定结果（0-成功，1-失败）
	protected Long  evaluationResult;
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
	// 经办机构
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	//不需要映射
	// 档案编号
	protected String  archiveCode;
	// 公民身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	
	
	
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}
	public String getAac002() {
		return aac002;
	}
	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}
	public String getAac003() {
		return aac003;
	}
	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
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
	public void setSerialNumber(String serialNumber) 
	{
		this.serialNumber = serialNumber;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public String getSerialNumber() 
	{
		return this.serialNumber;
	}
	public void setContactNumber(String contactNumber) 
	{
		this.contactNumber = contactNumber;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getContactNumber() 
	{
		return this.contactNumber;
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
	public void setWorkingAge(Long workingAge) 
	{
		this.workingAge = workingAge;
	}
	/**
	 * 返回 工作年龄
	 * @return
	 */
	public Long getWorkingAge() 
	{
		return this.workingAge;
	}
	public void setNowTitleGrade(Long nowTitleGrade) 
	{
		this.nowTitleGrade = nowTitleGrade;
	}
	/**
	 * 返回 现职称级别
	 * @return
	 */
	public Long getNowTitleGrade() 
	{
		return this.nowTitleGrade;
	}
	public void setDeclarationLevel(Long declarationLevel) 
	{
		this.declarationLevel = declarationLevel;
	}
	/**
	 * 返回 申报级别
	 * @return
	 */
	public Long getDeclarationLevel() 
	{
		return this.declarationLevel;
	}
	public void setEvaluationResult(Long evaluationResult) 
	{
		this.evaluationResult = evaluationResult;
	}
	/**
	 * 返回 评定结果（0-成功，1-失败）
	 * @return
	 */
	public Long getEvaluationResult() 
	{
		return this.evaluationResult;
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
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof TitleDeclarationForm)) 
		{
			return false;
		}
		TitleDeclarationForm rhs = (TitleDeclarationForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.serialNumber, rhs.serialNumber)
		.append(this.contactNumber, rhs.contactNumber)
		.append(this.workUnit, rhs.workUnit)
		.append(this.workingAge, rhs.workingAge)
		.append(this.nowTitleGrade, rhs.nowTitleGrade)
		.append(this.declarationLevel, rhs.declarationLevel)
		.append(this.evaluationResult, rhs.evaluationResult)
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
		.append(this.serialNumber) 
		.append(this.contactNumber) 
		.append(this.workUnit) 
		.append(this.workingAge) 
		.append(this.nowTitleGrade) 
		.append(this.declarationLevel) 
		.append(this.evaluationResult) 
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
		.append("serialNumber", this.serialNumber) 
		.append("contactNumber", this.contactNumber) 
		.append("workUnit", this.workUnit) 
		.append("workingAge", this.workingAge) 
		.append("nowTitleGrade", this.nowTitleGrade) 
		.append("declarationLevel", this.declarationLevel) 
		.append("evaluationResult", this.evaluationResult) 
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