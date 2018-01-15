package com.xunfeng.business.personagency.affair.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 考试报名登记表 Model对象
* @author:jiangxin
* @createDate 2016-09-20 10:13:34 
* @version V1.0   
*/
public class ExaminationRegister extends BaseModel
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 联系电话
	protected String  contactNumber;
	// 工作单位
	protected String  workUnit;
	// 工作年龄
	protected String  workingAge;
	// 考试类别
	protected Long  examinationType;
	// 考试明细
	protected Long  examinationMxType;
	// 考试级别
	protected Long  examinationLevel;
	// 考试成绩
	protected String  examinationChengji;
	// 评定结果（0-成功，1-失败）
	protected Long  evaluationResult;
	// 是否领取成绩单（0-否，1-是）
	protected Long  isLingExamination;
	// 是否领取证书（0-否，1-是）
	protected Long  isLingZhengshu;
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
	public void setWorkingAge(String workingAge) 
	{
		this.workingAge = workingAge;
	}
	/**
	 * 返回 工作年龄
	 * @return
	 */
	public String getWorkingAge() 
	{
		return this.workingAge;
	}
	public void setExaminationType(Long examinationType) 
	{
		this.examinationType = examinationType;
	}
	/**
	 * 返回 考试类别
	 * @return
	 */
	public Long getExaminationType() 
	{
		return this.examinationType;
	}
	public void setExaminationMxType(Long examinationMxType) 
	{
		this.examinationMxType = examinationMxType;
	}
	/**
	 * 返回 考试明细
	 * @return
	 */
	public Long getExaminationMxType() 
	{
		return this.examinationMxType;
	}
	public void setExaminationLevel(Long examinationLevel) 
	{
		this.examinationLevel = examinationLevel;
	}
	/**
	 * 返回 考试级别
	 * @return
	 */
	public Long getExaminationLevel() 
	{
		return this.examinationLevel;
	}
	public void setExaminationChengji(String examinationChengji) 
	{
		this.examinationChengji = examinationChengji;
	}
	/**
	 * 返回 考试成绩
	 * @return
	 */
	public String getExaminationChengji() 
	{
		return this.examinationChengji;
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
	public void setIsLingExamination(Long isLingExamination) 
	{
		this.isLingExamination = isLingExamination;
	}
	/**
	 * 返回 是否领取成绩单（0-否，1-是）
	 * @return
	 */
	public Long getIsLingExamination() 
	{
		return this.isLingExamination;
	}
	public void setIsLingZhengshu(Long isLingZhengshu) 
	{
		this.isLingZhengshu = isLingZhengshu;
	}
	/**
	 * 返回 是否领取证书（0-否，1-是）
	 * @return
	 */
	public Long getIsLingZhengshu() 
	{
		return this.isLingZhengshu;
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
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ExaminationRegister)) 
		{
			return false;
		}
		ExaminationRegister rhs = (ExaminationRegister) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.contactNumber, rhs.contactNumber)
		.append(this.workUnit, rhs.workUnit)
		.append(this.workingAge, rhs.workingAge)
		.append(this.examinationType, rhs.examinationType)
		.append(this.examinationMxType, rhs.examinationMxType)
		.append(this.examinationLevel, rhs.examinationLevel)
		.append(this.examinationChengji, rhs.examinationChengji)
		.append(this.evaluationResult, rhs.evaluationResult)
		.append(this.isLingExamination, rhs.isLingExamination)
		.append(this.isLingZhengshu, rhs.isLingZhengshu)
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
		.append(this.contactNumber) 
		.append(this.workUnit) 
		.append(this.workingAge) 
		.append(this.examinationType) 
		.append(this.examinationMxType) 
		.append(this.examinationLevel) 
		.append(this.examinationChengji) 
		.append(this.evaluationResult) 
		.append(this.isLingExamination) 
		.append(this.isLingZhengshu) 
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
		.append("contactNumber", this.contactNumber) 
		.append("workUnit", this.workUnit) 
		.append("workingAge", this.workingAge) 
		.append("examinationType", this.examinationType) 
		.append("examinationMxType", this.examinationMxType) 
		.append("examinationLevel", this.examinationLevel) 
		.append("examinationChengji", this.examinationChengji) 
		.append("evaluationResult", this.evaluationResult) 
		.append("isLingExamination", this.isLingExamination) 
		.append("isLingZhengshu", this.isLingZhengshu) 
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