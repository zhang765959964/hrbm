package com.xunfeng.business.personagency.subsidy.dto;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 Form对象
* @author:wanghan
* @createDate 2016-07-07 16:58:57 
* @version V1.0   
*/
public class SocialSubsidyDto implements Serializable
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
	protected String  checkState;
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
	// 备注
	protected String  description;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 批次Id
	protected Long  batchId;
	// 批次名称
	protected String  batchName;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办机构Id
	protected Long  createrOrgId;
	// 养老补贴标准
	protected String  pensionStandard;
	// 养老补贴金额
	protected String  pensionAmount;
	// 医疗补贴标准
	protected String  medicalStandard;
	// 医疗补贴金额
	protected String  medicalAmount;
	// 养老保险补贴总月数
	protected String  pensionTotalMonths;
	// 医疗保险补贴总月数
	protected String  medicalTotalMonths;
	/**
	 * 个人基本信息相关字段
	 */
	// 个人编号
	protected Long  aac001;
	// 公民身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 出生日期
	protected java.util.Date  aac006;
	
	protected String archiveCode;
	
	// 再就业优惠证编号
	protected String  expRegisgration;
	
	// 是否就业困难人员（0-否，1-是）
	protected String  expIsDifficult;
	
	// 就业困难人员类别（TAB_EDO）
	protected String  expHardPerson;
	// 就业失业登记证
	protected String acc0m1;
	// 手机号
	protected String aae005;
	// 联系电话
	protected String expPersonPhone;
	
	// 原工作单位
	protected String  expOldCompany;

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
	@JsonSerialize(using=JsonDateSerializer.class) 
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
	@JsonSerialize(using=JsonDateSerializer.class) 
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

	public String getExpOldCompany() {
		return expOldCompany;
	}
	public void setExpOldCompany(String expOldCompany) {
		this.expOldCompany = expOldCompany;
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
	public void setBatchId(Long batchId) 
	{
		this.batchId = batchId;
	}
	/**
	 * 返回 批次Id
	 * @return
	 */
	public Long getBatchId() 
	{
		return this.batchId;
	}
	public void setBatchName(String batchName) 
	{
		this.batchName = batchName;
	}
	/**
	 * 返回 批次名称
	 * @return
	 */
	public String getBatchName() 
	{
		return this.batchName;
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


	public Long getAac001() {
		return aac001;
	}
	public void setAac001(Long aac001) {
		this.aac001 = aac001;
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
	public String getAac004() {
		return aac004;
	}
	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}

	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getAac006() {
		return aac006;
	}
	public void setAac006(java.util.Date aac006) {
		this.aac006 = aac006;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SocialSubsidyDto)) 
		{
			return false;
		}
		SocialSubsidyDto rhs = (SocialSubsidyDto) object;
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
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.batchId, rhs.batchId)
		.append(this.batchName, rhs.batchName)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.pensionStandard, rhs.pensionStandard)
		.append(this.pensionAmount, rhs.pensionAmount)
		.append(this.medicalStandard, rhs.medicalStandard)
		.append(this.medicalAmount, rhs.medicalAmount)
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
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.batchId) 
		.append(this.batchName) 
		.append(this.createrOrgName) 
		.append(this.createrOrgId) 
		.append(this.pensionStandard) 
		.append(this.pensionAmount) 
		.append(this.medicalStandard) 
		.append(this.medicalAmount) 
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
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("batchId", this.batchId) 
		.append("batchName", this.batchName) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("pensionStandard", this.pensionStandard) 
		.append("pensionAmount", this.pensionAmount) 
		.append("medicalStandard", this.medicalStandard) 
		.append("medicalAmount", this.medicalAmount) 
		.toString();
	}
	public String getPensionTotalMonths() {
		return pensionTotalMonths;
	}
	public void setPensionTotalMonths(String pensionTotalMonths) {
		this.pensionTotalMonths = pensionTotalMonths;
	}
	public String getMedicalTotalMonths() {
		return medicalTotalMonths;
	}
	public void setMedicalTotalMonths(String medicalTotalMonths) {
		this.medicalTotalMonths = medicalTotalMonths;
	}
	public String getPensionStartDate() {
		return pensionStartDate;
	}
	public void setPensionStartDate(String pensionStartDate) {
		this.pensionStartDate = pensionStartDate;
	}
	public String getPensionEndDate() {
		return pensionEndDate;
	}
	public void setPensionEndDate(String pensionEndDate) {
		this.pensionEndDate = pensionEndDate;
	}
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}
	public String getExpRegisgration() {
		return expRegisgration;
	}
	public void setExpRegisgration(String expRegisgration) {
		this.expRegisgration = expRegisgration;
	}
	public String getExpIsDifficult() {
		return expIsDifficult;
	}
	public void setExpIsDifficult(String expIsDifficult) {
		this.expIsDifficult = expIsDifficult;
	}
	public String getExpHardPerson() {
		return expHardPerson;
	}
	public void setExpHardPerson(String expHardPerson) {
		this.expHardPerson = expHardPerson;
	}
	public String getAcc0m1() {
		return acc0m1;
	}
	public void setAcc0m1(String acc0m1) {
		this.acc0m1 = acc0m1;
	}
	public String getExpPersonPhone() {
		return expPersonPhone;
	}
	public void setExpPersonPhone(String expPersonPhone) {
		this.expPersonPhone = expPersonPhone;
	}
   
  

}