package com.xunfeng.business.personagency.subsidy.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 Model对象
* @author:wanghan
* @createDate 2016-07-14 10:12:14 
* @version V1.0   
*/
public class SocialSubsidy extends BaseModel
{
	// 主键
	protected Long  id;
	// 编号
	protected String  subsidyNum;
	// 老编号
	protected String  oldSubsidyNum;
	// 养老保险补贴月数
	protected String  pensionMonths;
	// 养老补贴开始年份
	protected String  pensionStartDate;
	// 养老补贴结束年份
	protected String  pensionEndDate;
	// 医疗保险补贴月数
	protected String  medicalMonths;
	// 医疗补贴开始年份
	protected String  medicalStartDate;
	// 医疗补贴结束年份
	protected String  medicalEndDate;
	// 签订劳动合同开始时间
	protected java.util.Date  contractSignDate;
	// 签订劳动合同终止时间
	protected java.util.Date  contractEndDate;
	// 劳动合同解除日期
	protected java.util.Date  contractDestoryDate;
	// 是否通过
	protected String  isPassed;
	// 审核标记
	protected String  checkState="0";
	// 开户银行
	protected String  bankName;
	// 银行帐号
	protected String  bankCardNo;
	// 是否持有营业执照
	protected String  isHasBusLic;
	// 营业执照编号
	protected String  busLicNum;
	// 已在外单位享受补贴月数
	protected String  outerSubsidyMonths;
	// 登记次数
	protected String  createrNum;
	// 原工作单位
	protected String  oldWorkCorp;
	// 备注
	protected String  description;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
//	// 批次Id
//	protected Long  batchId;
//	// 批次名称
//	protected String  batchName;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办机构Id
	protected Long  createrOrgId;
	// 养老补贴标准
	protected String  pensionStandard;
	// 养老补贴金额
	protected String  pensionAmount="0";
	// 医疗补贴标准
	protected String  medicalStandard;
	// 医疗补贴金额
	protected String  medicalAmount="0";
	// 人员Id
	protected Long  personId;
	// 养老保险补贴总月数
	protected String  pensionTotalMonths;
	// 医疗保险补贴总月数
	protected String  medicalTotalMonths;
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
	public void setSubsidyNum(String subsidyNum) 
	{
		this.subsidyNum = subsidyNum;
	}
	/**
	 * 返回 编号
	 * @return
	 */
	public String getSubsidyNum() 
	{
		return this.subsidyNum;
	}
	public void setOldSubsidyNum(String oldSubsidyNum) 
	{
		this.oldSubsidyNum = oldSubsidyNum;
	}
	/**
	 * 返回 老编号
	 * @return
	 */
	public String getOldSubsidyNum() 
	{
		return this.oldSubsidyNum;
	}
	public void setPensionMonths(String pensionMonths) 
	{
		this.pensionMonths = pensionMonths;
	}
	/**
	 * 返回 养老保险补贴月数
	 * @return
	 */
	public String getPensionMonths() 
	{
		return this.pensionMonths;
	}
	public void setPensionStartDate(String pensionStartDate) 
	{
		this.pensionStartDate = pensionStartDate;
	}
	/**
	 * 返回 养老补贴开始年份
	 * @return
	 */
	public String getPensionStartDate() 
	{
		return this.pensionStartDate;
	}
	public void setPensionEndDate(String pensionEndDate) 
	{
		this.pensionEndDate = pensionEndDate;
	}
	/**
	 * 返回 养老补贴结束年份
	 * @return
	 */
	public String getPensionEndDate() 
	{
		return this.pensionEndDate;
	}
	public void setMedicalMonths(String medicalMonths) 
	{
		this.medicalMonths = medicalMonths;
	}
	/**
	 * 返回 医疗保险补贴月数
	 * @return
	 */
	public String getMedicalMonths() 
	{
		return this.medicalMonths;
	}
	public void setMedicalStartDate(String medicalStartDate) 
	{
		this.medicalStartDate = medicalStartDate;
	}
	/**
	 * 返回 医疗补贴开始年份
	 * @return
	 */
	public String getMedicalStartDate() 
	{
		return this.medicalStartDate;
	}
	public void setMedicalEndDate(String medicalEndDate) 
	{
		this.medicalEndDate = medicalEndDate;
	}
	/**
	 * 返回 医疗补贴结束年份
	 * @return
	 */
	public String getMedicalEndDate() 
	{
		return this.medicalEndDate;
	}
	public void setContractSignDate(java.util.Date contractSignDate) 
	{
		this.contractSignDate = contractSignDate;
	}
	/**
	 * 返回 签订劳动合同开始时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getContractSignDate() 
	{
		return this.contractSignDate;
	}
	public void setContractEndDate(java.util.Date contractEndDate) 
	{
		this.contractEndDate = contractEndDate;
	}
	/**
	 * 返回 签订劳动合同终止时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getContractEndDate() 
	{
		return this.contractEndDate;
	}
	public void setContractDestoryDate(java.util.Date contractDestoryDate) 
	{
		this.contractDestoryDate = contractDestoryDate;
	}
	/**
	 * 返回 劳动合同解除日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getContractDestoryDate() 
	{
		return this.contractDestoryDate;
	}
	public void setIsPassed(String isPassed) 
	{
		this.isPassed = isPassed;
	}
	/**
	 * 返回 是否通过
	 * @return
	 */
	public String getIsPassed() 
	{
		return this.isPassed;
	}
	public void setCheckState(String checkState) 
	{
		this.checkState = checkState;
	}
	/**
	 * 返回 审核标记
	 * @return
	 */
	public String getCheckState() 
	{
		return this.checkState;
	}
	public void setBankName(String bankName) 
	{
		this.bankName = bankName;
	}
	/**
	 * 返回 开户银行
	 * @return
	 */
	public String getBankName() 
	{
		return this.bankName;
	}
	public void setBankCardNo(String bankCardNo) 
	{
		this.bankCardNo = bankCardNo;
	}
	/**
	 * 返回 银行帐号
	 * @return
	 */
	public String getBankCardNo() 
	{
		return this.bankCardNo;
	}
	public void setIsHasBusLic(String isHasBusLic) 
	{
		this.isHasBusLic = isHasBusLic;
	}
	/**
	 * 返回 是否持有营业执照
	 * @return
	 */
	public String getIsHasBusLic() 
	{
		return this.isHasBusLic;
	}
	public void setBusLicNum(String busLicNum) 
	{
		this.busLicNum = busLicNum;
	}
	/**
	 * 返回 营业执照编号
	 * @return
	 */
	public String getBusLicNum() 
	{
		return this.busLicNum;
	}
	public void setOuterSubsidyMonths(String outerSubsidyMonths) 
	{
		this.outerSubsidyMonths = outerSubsidyMonths;
	}
	/**
	 * 返回 已在外单位享受补贴月数
	 * @return
	 */
	public String getOuterSubsidyMonths() 
	{
		return this.outerSubsidyMonths;
	}
	public void setCreaterNum(String createrNum) 
	{
		this.createrNum = createrNum;
	}
	/**
	 * 返回 登记次数
	 * @return
	 */
	public String getCreaterNum() 
	{
		return this.createrNum;
	}
	public void setOldWorkCorp(String oldWorkCorp) 
	{
		this.oldWorkCorp = oldWorkCorp;
	}
	/**
	 * 返回 原工作单位
	 * @return
	 */
	public String getOldWorkCorp() 
	{
		return this.oldWorkCorp;
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
	public void setPensionStandard(String pensionStandard) 
	{
		this.pensionStandard = pensionStandard;
	}
	/**
	 * 返回 养老补贴标准
	 * @return
	 */
	public String getPensionStandard() 
	{
		return this.pensionStandard;
	}
	public void setPensionAmount(String pensionAmount) 
	{
		this.pensionAmount = pensionAmount;
	}
	/**
	 * 返回 养老补贴金额
	 * @return
	 */
	public String getPensionAmount() 
	{
		return this.pensionAmount;
	}
	public void setMedicalStandard(String medicalStandard) 
	{
		this.medicalStandard = medicalStandard;
	}
	/**
	 * 返回 医疗补贴标准
	 * @return
	 */
	public String getMedicalStandard() 
	{
		return this.medicalStandard;
	}
	public void setMedicalAmount(String medicalAmount) 
	{
		this.medicalAmount = medicalAmount;
	}
	/**
	 * 返回 医疗补贴金额
	 * @return
	 */
	public String getMedicalAmount() 
	{
		return this.medicalAmount;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员Id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setPensionTotalMonths(String pensionTotalMonths) 
	{
		this.pensionTotalMonths = pensionTotalMonths;
	}
	/**
	 * 返回 养老保险补贴总月数
	 * @return
	 */
	public String getPensionTotalMonths() 
	{
		return this.pensionTotalMonths;
	}
	public void setMedicalTotalMonths(String medicalTotalMonths) 
	{
		this.medicalTotalMonths = medicalTotalMonths;
	}
	/**
	 * 返回 医疗保险补贴总月数
	 * @return
	 */
	public String getMedicalTotalMonths() 
	{
		return this.medicalTotalMonths;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SocialSubsidy)) 
		{
			return false;
		}
		SocialSubsidy rhs = (SocialSubsidy) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.subsidyNum, rhs.subsidyNum)
		.append(this.oldSubsidyNum, rhs.oldSubsidyNum)
		.append(this.pensionMonths, rhs.pensionMonths)
		.append(this.pensionStartDate, rhs.pensionStartDate)
		.append(this.pensionEndDate, rhs.pensionEndDate)
		.append(this.medicalMonths, rhs.medicalMonths)
		.append(this.medicalStartDate, rhs.medicalStartDate)
		.append(this.medicalEndDate, rhs.medicalEndDate)
		.append(this.contractSignDate, rhs.contractSignDate)
		.append(this.contractEndDate, rhs.contractEndDate)
		.append(this.contractDestoryDate, rhs.contractDestoryDate)
		.append(this.isPassed, rhs.isPassed)
		.append(this.checkState, rhs.checkState)
		.append(this.bankName, rhs.bankName)
		.append(this.bankCardNo, rhs.bankCardNo)
		.append(this.isHasBusLic, rhs.isHasBusLic)
		.append(this.busLicNum, rhs.busLicNum)
		.append(this.outerSubsidyMonths, rhs.outerSubsidyMonths)
		.append(this.createrNum, rhs.createrNum)
		.append(this.oldWorkCorp, rhs.oldWorkCorp)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.pensionStandard, rhs.pensionStandard)
		.append(this.pensionAmount, rhs.pensionAmount)
		.append(this.medicalStandard, rhs.medicalStandard)
		.append(this.medicalAmount, rhs.medicalAmount)
		.append(this.personId, rhs.personId)
		.append(this.pensionTotalMonths, rhs.pensionTotalMonths)
		.append(this.medicalTotalMonths, rhs.medicalTotalMonths)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.subsidyNum) 
		.append(this.oldSubsidyNum) 
		.append(this.pensionMonths) 
		.append(this.pensionStartDate) 
		.append(this.pensionEndDate) 
		.append(this.medicalMonths) 
		.append(this.medicalStartDate) 
		.append(this.medicalEndDate) 
		.append(this.contractSignDate) 
		.append(this.contractEndDate) 
		.append(this.contractDestoryDate) 
		.append(this.isPassed) 
		.append(this.checkState) 
		.append(this.bankName) 
		.append(this.bankCardNo) 
		.append(this.isHasBusLic) 
		.append(this.busLicNum) 
		.append(this.outerSubsidyMonths) 
		.append(this.createrNum) 
		.append(this.oldWorkCorp) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgName) 
		.append(this.createrOrgId) 
		.append(this.pensionStandard) 
		.append(this.pensionAmount) 
		.append(this.medicalStandard) 
		.append(this.medicalAmount) 
		.append(this.personId) 
		.append(this.pensionTotalMonths) 
		.append(this.medicalTotalMonths) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("subsidyNum", this.subsidyNum) 
		.append("oldSubsidyNum", this.oldSubsidyNum) 
		.append("pensionMonths", this.pensionMonths) 
		.append("pensionStartDate", this.pensionStartDate) 
		.append("pensionEndDate", this.pensionEndDate) 
		.append("medicalMonths", this.medicalMonths) 
		.append("medicalStartDate", this.medicalStartDate) 
		.append("medicalEndDate", this.medicalEndDate) 
		.append("contractSignDate", this.contractSignDate) 
		.append("contractEndDate", this.contractEndDate) 
		.append("contractDestoryDate", this.contractDestoryDate) 
		.append("isPassed", this.isPassed) 
		.append("checkState", this.checkState) 
		.append("bankName", this.bankName) 
		.append("bankCardNo", this.bankCardNo) 
		.append("isHasBusLic", this.isHasBusLic) 
		.append("busLicNum", this.busLicNum) 
		.append("outerSubsidyMonths", this.outerSubsidyMonths) 
		.append("createrNum", this.createrNum) 
		.append("oldWorkCorp", this.oldWorkCorp) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("pensionStandard", this.pensionStandard) 
		.append("pensionAmount", this.pensionAmount) 
		.append("medicalStandard", this.medicalStandard) 
		.append("medicalAmount", this.medicalAmount) 
		.append("personId", this.personId) 
		.append("pensionTotalMonths", this.pensionTotalMonths) 
		.append("medicalTotalMonths", this.medicalTotalMonths) 
		.toString();
	}
   
  

}