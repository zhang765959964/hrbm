package com.xunfeng.business.person.model;
import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息拓展表 Model对象
* @author:wanlupeng
* @createDate 2016-07-06 18:11:28 
* @version V1.0   
*/
public class PersonExpand extends BaseModel
{
	// 主键id
	protected Long  expandId;
	// 个人信息表id
	protected Long  expPersonId;
	// 参加工作时间
	protected java.util.Date  expStartJobDate;
	// 曾用名
	protected String  expUserName;
	// 个人编号
	protected String  expPersonNumber;
	// 档案编号
	protected String  expArchivesNumber;
	// 通用1
	protected String  expGengral1;
	// 原工作单位
	protected String  expOldCompany;
	// 社保状态
	protected Long  expSecStatus;
	// 备注
	protected String  expRemarks;
	// 创建人id
	protected Long  expOpeartorUserId;
	// 创建时间
	protected java.util.Date  expOpeartorDate;
	// 视同
	protected String  expEquate;
	// 个人状态(TAB_PSTATUS)
	protected String  expPersonStatus;
	// 联系电话(ac01中AAE005存手机号)
	protected String  expPersonPhone;
	// 户口登记日期
	protected java.util.Date  expHourseDate;
	// 详细地址
	protected String  expAddress;
	// 职务
	protected String  expPost;
	// 国家职业资格等级(TAB_COQ)
	protected String  expLevel;
	// 取得职业资格等级日期
	protected java.util.Date  expLevelDate;
	// 职业工种资格ID（TAB_CRAFT）
	protected String  expPositionCode;
	// 职业工种资格名称（TAB_CRAFT）
	protected String  expPositionName;
	// 专业技术职务（TAB_TITLE）
	protected String  expTechnical;
	// 取得专业技术职务资格日期
	protected java.util.Date  expTechnicalDate;
	// 是否零就业家庭（0-否，1-是）
	protected String  expIsFamily;
	// 是否就业困难人员（0-否，1-是）
	protected String  expIsDifficult;
	// 是否转干部（0-否，1-是）
	protected String  expIsCadre;
	// 是否享有再就业优惠证标准（0-否，1-是）
	protected String  expIsDiscount;
	// 是否持有就业失业登记证（0-否，1-是）
	protected String  expIsRegisgration;
	// 再就业优惠证编号
	protected String  expRegisgration;
	// 身份证住址
	protected String  expCardNumber;
	// 就业困难人员类别（TAB_EDO）
	protected String  expHardPerson;
	//社会保障号
	protected String  expSoctalNumber;
	//委托单位名称
	protected String  expEntrustCompany;
	//专业工种
	protected String  expZhuanye;
	// 是否欠费
	protected String  expArrears;
	// 借阅状态
	protected String  expBorrowingStatus;
	// 是否正式退休
	protected String  expRetire;
	// 是否转社会化
	protected String  expSocialization;
	// 是否代管组织关系
	protected String  expOrganize;
	// 是否代管户口
	protected String  expResidence;
	// 是否代管养老保险
	protected String  expPension;
	// 是否代管医疗保险
	protected String  expMedical;
	// 是否代管工伤保险
	protected String  expInjury;
	// 是否代管生育保险
	protected String  expBirth;
	// 是否代管大病保险
	protected String  expSerious;
	// 是否代管失业保险
	protected String  expUnemployment;
	// 是否代管住房公积金
	protected String  expAccumulation;
	// 参加养老保险时间
	protected java.util.Date  expPensionDate;
	// 参加医疗保险时间
	protected java.util.Date  expMedicalDate;
	// 参加保险情况备注
	protected String  expInsurance;
	// 就业失业情况（1-就业，2-不在岗，3-未就业及失业，4-服刑，5-出国定居，6-在学）
	protected String  expacc0m;
	public void setExpandId(Long expandId) 
	{
		this.expandId = expandId;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getExpandId() 
	{
		return this.expandId;
	}
	public void setExpPersonId(Long expPersonId) 
	{
		this.expPersonId = expPersonId;
	}
	/**
	 * 返回 个人信息表id
	 * @return
	 */
	public Long getExpPersonId() 
	{
		return this.expPersonId;
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
	public void setExpUserName(String expUserName) 
	{
		this.expUserName = expUserName;
	}
	/**
	 * 返回 曾用名
	 * @return
	 */
	public String getExpUserName() 
	{
		return this.expUserName;
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
	public void setExpArchivesNumber(String expArchivesNumber) 
	{
		this.expArchivesNumber = expArchivesNumber;
	}
	/**
	 * 返回 档案编号
	 * @return
	 */
	public String getExpArchivesNumber() 
	{
		return this.expArchivesNumber;
	}
	public void setExpGengral1(String expGengral1) 
	{
		this.expGengral1 = expGengral1;
	}
	/**
	 * 返回 通用1
	 * @return
	 */
	public String getExpGengral1() 
	{
		return this.expGengral1;
	}
	public void setExpOldCompany(String expOldCompany) 
	{
		this.expOldCompany = expOldCompany;
	}
	/**
	 * 返回 原工作单位
	 * @return
	 */
	public String getExpOldCompany() 
	{
		return this.expOldCompany;
	}
	public void setExpSecStatus(Long expSecStatus) 
	{
		this.expSecStatus = expSecStatus;
	}
	/**
	 * 返回 社保状态
	 * @return
	 */
	public Long getExpSecStatus() 
	{
		return this.expSecStatus;
	}
	public void setExpRemarks(String expRemarks) 
	{
		this.expRemarks = expRemarks;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getExpRemarks() 
	{
		return this.expRemarks;
	}
	public void setExpOpeartorUserId(Long expOpeartorUserId) 
	{
		this.expOpeartorUserId = expOpeartorUserId;
	}
	/**
	 * 返回 创建人id
	 * @return
	 */
	public Long getExpOpeartorUserId() 
	{
		return this.expOpeartorUserId;
	}
	public void setExpOpeartorDate(java.util.Date expOpeartorDate) 
	{
		this.expOpeartorDate = expOpeartorDate;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getExpOpeartorDate() 
	{
		return this.expOpeartorDate;
	}
	public void setExpEquate(String expEquate) 
	{
		this.expEquate = expEquate;
	}
	/**
	 * 返回 视同
	 * @return
	 */
	public String getExpEquate() 
	{
		return this.expEquate;
	}
	public void setExpPersonStatus(String expPersonStatus) 
	{
		this.expPersonStatus = expPersonStatus;
	}
	/**
	 * 返回 个人状态(TAB_PSTATUS)
	 * @return
	 */
	public String getExpPersonStatus() 
	{
		return this.expPersonStatus;
	}
	public void setExpPersonPhone(String expPersonPhone) 
	{
		this.expPersonPhone = expPersonPhone;
	}
	/**
	 * 返回 联系电话(ac01中AAE005存手机号)
	 * @return
	 */
	public String getExpPersonPhone() 
	{
		return this.expPersonPhone;
	}
	public void setExpHourseDate(java.util.Date expHourseDate) 
	{
		this.expHourseDate = expHourseDate;
	}
	/**
	 * 返回 户口登记日期
	 * @return
	 */
	public java.util.Date getExpHourseDate() 
	{
		return this.expHourseDate;
	}
	public void setExpAddress(String expAddress) 
	{
		this.expAddress = expAddress;
	}
	/**
	 * 返回 详细地址
	 * @return
	 */
	public String getExpAddress() 
	{
		return this.expAddress;
	}
	public void setExpPost(String expPost) 
	{
		this.expPost = expPost;
	}
	/**
	 * 返回 职务
	 * @return
	 */
	public String getExpPost() 
	{
		return this.expPost;
	}
	public void setExpLevel(String expLevel) 
	{
		this.expLevel = expLevel;
	}
	/**
	 * 返回 国家职业资格等级(TAB_COQ)
	 * @return
	 */
	public String getExpLevel() 
	{
		return this.expLevel;
	}
	public void setExpLevelDate(java.util.Date expLevelDate) 
	{
		this.expLevelDate = expLevelDate;
	}
	/**
	 * 返回 取得职业资格等级日期
	 * @return
	 */
	public java.util.Date getExpLevelDate() 
	{
		return this.expLevelDate;
	}
	public void setExpPositionCode(String expPositionCode) 
	{
		this.expPositionCode = expPositionCode;
	}
	/**
	 * 返回 职业工种资格ID（TAB_CRAFT）
	 * @return
	 */
	public String getExpPositionCode() 
	{
		return this.expPositionCode;
	}
	public void setExpPositionName(String expPositionName) 
	{
		this.expPositionName = expPositionName;
	}
	/**
	 * 返回 职业工种资格名称（TAB_CRAFT）
	 * @return
	 */
	public String getExpPositionName() 
	{
		return this.expPositionName;
	}
	public void setExpTechnical(String expTechnical) 
	{
		this.expTechnical = expTechnical;
	}
	/**
	 * 返回 专业技术职务（TAB_TITLE）
	 * @return
	 */
	public String getExpTechnical() 
	{
		return this.expTechnical;
	}
	public void setExpTechnicalDate(java.util.Date expTechnicalDate) 
	{
		this.expTechnicalDate = expTechnicalDate;
	}
	/**
	 * 返回 取得专业技术职务资格日期
	 * @return
	 */
	public java.util.Date getExpTechnicalDate() 
	{
		return this.expTechnicalDate;
	}
	public void setExpIsFamily(String expIsFamily) 
	{
		this.expIsFamily = expIsFamily;
	}
	/**
	 * 返回 是否零就业家庭（0-否，1-是）
	 * @return
	 */
	public String getExpIsFamily() 
	{
		return this.expIsFamily;
	}
	public void setExpIsDifficult(String expIsDifficult) 
	{
		this.expIsDifficult = expIsDifficult;
	}
	/**
	 * 返回 是否就业困难人员（0-否，1-是）
	 * @return
	 */
	public String getExpIsDifficult() 
	{
		return this.expIsDifficult;
	}
	public void setExpIsCadre(String expIsCadre) 
	{
		this.expIsCadre = expIsCadre;
	}
	/**
	 * 返回 是否转干部（0-否，1-是）
	 * @return
	 */
	public String getExpIsCadre() 
	{
		return this.expIsCadre;
	}
	public void setExpIsDiscount(String expIsDiscount) 
	{
		this.expIsDiscount = expIsDiscount;
	}
	/**
	 * 返回 是否享有再就业优惠证标准（0-否，1-是）
	 * @return
	 */
	public String getExpIsDiscount() 
	{
		return this.expIsDiscount;
	}
	public void setExpIsRegisgration(String expIsRegisgration) 
	{
		this.expIsRegisgration = expIsRegisgration;
	}
	/**
	 * 返回 是否持有就业失业登记证（0-否，1-是）
	 * @return
	 */
	public String getExpIsRegisgration() 
	{
		return this.expIsRegisgration;
	}
	public void setExpRegisgration(String expRegisgration) 
	{
		this.expRegisgration = expRegisgration;
	}
	/**
	 * 返回 再就业优惠证编号
	 * @return
	 */
	public String getExpRegisgration() 
	{
		return this.expRegisgration;
	}
	public void setExpCardNumber(String expCardNumber) 
	{
		this.expCardNumber = expCardNumber;
	}
	/**
	 * 返回 身份证住址
	 * @return
	 */
	public String getExpCardNumber() 
	{
		return this.expCardNumber;
	}
	public void setExpHardPerson(String expHardPerson) 
	{
		this.expHardPerson = expHardPerson;
	}
	/**
	 * 返回 就业困难人员类别（TAB_EDO）
	 * @return
	 */
	public String getExpHardPerson() 
	{
		return this.expHardPerson;
	}
	public void setExpSoctalNumber(String expSoctalNumber) {
		this.expSoctalNumber = expSoctalNumber;
	}
	/**
	 * 返回 社会保障号
	 * @return
	 */
   	public String getExpSoctalNumber() {
		return this.expSoctalNumber;
	}
	public void setExpEntrustCompany(String expEntrustCompany) {
		this.expEntrustCompany = expEntrustCompany;
	}
	/**
	 * 返回 委托单位名称
	 * @return
	 */
	public String getExpEntrustCompany() {
		return this.expEntrustCompany;
	}
	
	public void setExpZhuanye(String expZhuanye) {
		this.expZhuanye = expZhuanye;
	}
	/**
	 * 返回 专业工种
	 * @return
	 */
	public String getExpZhuanye() {
		return this.expZhuanye;
	}
	public void setExpArrears(String expArrears) 
	{
		this.expArrears = expArrears;
	}
	/**
	 * 返回 是否欠费
	 * @return
	 */
	public String getExpArrears() 
	{
		return this.expArrears;
	}
	public void setExpBorrowingStatus(String expBorrowingStatus) 
	{
		this.expBorrowingStatus = expBorrowingStatus;
	}
	/**
	 * 返回 借阅状态
	 * @return
	 */
	public String getExpBorrowingStatus() 
	{
		return this.expBorrowingStatus;
	}
	public void setExpRetire(String expRetire) 
	{
		this.expRetire = expRetire;
	}
	/**
	 * 返回 是否正式退休
	 * @return
	 */
	public String getExpRetire() 
	{
		return this.expRetire;
	}
	public void setExpSocialization(String expSocialization) 
	{
		this.expSocialization = expSocialization;
	}
	/**
	 * 返回 是否转社会化
	 * @return
	 */
	public String getExpSocialization() 
	{
		return this.expSocialization;
	}
	public void setExpOrganize(String expOrganize) 
	{
		this.expOrganize = expOrganize;
	}
	/**
	 * 返回 是否代管组织关系
	 * @return
	 */
	public String getExpOrganize() 
	{
		return this.expOrganize;
	}
	public void setExpResidence(String expResidence) 
	{
		this.expResidence = expResidence;
	}
	/**
	 * 返回 是否代管户口
	 * @return
	 */
	public String getExpResidence() 
	{
		return this.expResidence;
	}
	public void setExpPension(String expPension) 
	{
		this.expPension = expPension;
	}
	/**
	 * 返回 是否代管养老保险
	 * @return
	 */
	public String getExpPension() 
	{
		return this.expPension;
	}
	public void setExpMedical(String expMedical) 
	{
		this.expMedical = expMedical;
	}
	/**
	 * 返回 是否代管医疗保险
	 * @return
	 */
	public String getExpMedical() 
	{
		return this.expMedical;
	}
	public void setExpInjury(String expInjury) 
	{
		this.expInjury = expInjury;
	}
	/**
	 * 返回 是否代管工伤保险
	 * @return
	 */
	public String getExpInjury() 
	{
		return this.expInjury;
	}
	public void setExpBirth(String expBirth) 
	{
		this.expBirth = expBirth;
	}
	/**
	 * 返回 是否代管生育保险
	 * @return
	 */
	public String getExpBirth() 
	{
		return this.expBirth;
	}
	public void setExpSerious(String expSerious) 
	{
		this.expSerious = expSerious;
	}
	/**
	 * 返回 是否代管大病保险
	 * @return
	 */
	public String getExpSerious() 
	{
		return this.expSerious;
	}
	public void setExpUnemployment(String expUnemployment) 
	{
		this.expUnemployment = expUnemployment;
	}
	/**
	 * 返回 是否代管失业保险
	 * @return
	 */
	public String getExpUnemployment() 
	{
		return this.expUnemployment;
	}
	public void setExpAccumulation(String expAccumulation) 
	{
		this.expAccumulation = expAccumulation;
	}
	/**
	 * 返回 是否代管住房公积金
	 * @return
	 */
	public String getExpAccumulation() 
	{
		return this.expAccumulation;
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
	public void setExpInsurance(String expInsurance) 
	{
		this.expInsurance = expInsurance;
	}
	/**
	 * 返回 参加保险情况备注
	 * @return
	 */
	public String getExpInsurance() 
	{
		return this.expInsurance;
	}
	public void setExpacc0m(String expacc0m) {
		this.expacc0m = expacc0m;
	}
	/**
	 * 返回 就业失业情况（1-就业，2-不在岗，3-未就业及失业，4-服刑，5-出国定居，6-在学）
	 * @return
	 */
	public String getExpacc0m() {
		return this.expacc0m;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonExpand)) 
		{
			return false;
		}
		PersonExpand rhs = (PersonExpand) object;
		return new EqualsBuilder()
		.append(this.expandId, rhs.expandId)
		.append(this.expPersonId, rhs.expPersonId)
		.append(this.expStartJobDate, rhs.expStartJobDate)
		.append(this.expUserName, rhs.expUserName)
		.append(this.expPersonNumber, rhs.expPersonNumber)
		.append(this.expArchivesNumber, rhs.expArchivesNumber)
		.append(this.expGengral1, rhs.expGengral1)
		.append(this.expOldCompany, rhs.expOldCompany)
		.append(this.expSecStatus, rhs.expSecStatus)
		.append(this.expRemarks, rhs.expRemarks)
		.append(this.expOpeartorUserId, rhs.expOpeartorUserId)
		.append(this.expOpeartorDate, rhs.expOpeartorDate)
		.append(this.expEquate, rhs.expEquate)
		.append(this.expPersonStatus, rhs.expPersonStatus)
		.append(this.expPersonPhone, rhs.expPersonPhone)
		.append(this.expHourseDate, rhs.expHourseDate)
		.append(this.expAddress, rhs.expAddress)
		.append(this.expPost, rhs.expPost)
		.append(this.expLevel, rhs.expLevel)
		.append(this.expLevelDate, rhs.expLevelDate)
		.append(this.expPositionCode, rhs.expPositionCode)
		.append(this.expPositionName, rhs.expPositionName)
		.append(this.expTechnical, rhs.expTechnical)
		.append(this.expTechnicalDate, rhs.expTechnicalDate)
		.append(this.expIsFamily, rhs.expIsFamily)
		.append(this.expIsDifficult, rhs.expIsDifficult)
		.append(this.expIsCadre, rhs.expIsCadre)
		.append(this.expIsDiscount, rhs.expIsDiscount)
		.append(this.expIsRegisgration, rhs.expIsRegisgration)
		.append(this.expRegisgration, rhs.expRegisgration)
		.append(this.expCardNumber, rhs.expCardNumber)
		.append(this.expHardPerson, rhs.expHardPerson)
		.append(this.expSoctalNumber, rhs.expSoctalNumber)
		.append(this.expEntrustCompany, rhs.expEntrustCompany)
		.append(this.expZhuanye, rhs.expZhuanye)
		.append(this.expArrears, rhs.expArrears)
		.append(this.expBorrowingStatus, rhs.expBorrowingStatus)
		.append(this.expRetire, rhs.expRetire)
		.append(this.expSocialization, rhs.expSocialization)
		.append(this.expOrganize, rhs.expOrganize)
		.append(this.expResidence, rhs.expResidence)
		.append(this.expPension, rhs.expPension)
		.append(this.expMedical, rhs.expMedical)
		.append(this.expInjury, rhs.expInjury)
		.append(this.expBirth, rhs.expBirth)
		.append(this.expSerious, rhs.expSerious)
		.append(this.expUnemployment, rhs.expUnemployment)
		.append(this.expAccumulation, rhs.expAccumulation)
		.append(this.expPensionDate, rhs.expPensionDate)
		.append(this.expMedicalDate, rhs.expMedicalDate)
		.append(this.expInsurance, rhs.expInsurance)
		.append(this.expacc0m, rhs.expacc0m)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.expandId) 
		.append(this.expPersonId) 
		.append(this.expStartJobDate) 
		.append(this.expUserName) 
		.append(this.expPersonNumber) 
		.append(this.expArchivesNumber) 
		.append(this.expGengral1) 
		.append(this.expOldCompany) 
		.append(this.expSecStatus) 
		.append(this.expRemarks) 
		.append(this.expOpeartorUserId) 
		.append(this.expOpeartorDate) 
		.append(this.expEquate) 
		.append(this.expPersonStatus) 
		.append(this.expPersonPhone) 
		.append(this.expHourseDate) 
		.append(this.expAddress) 
		.append(this.expPost) 
		.append(this.expLevel) 
		.append(this.expLevelDate) 
		.append(this.expPositionCode) 
		.append(this.expPositionName) 
		.append(this.expTechnical) 
		.append(this.expTechnicalDate) 
		.append(this.expIsFamily) 
		.append(this.expIsDifficult) 
		.append(this.expIsCadre) 
		.append(this.expIsDiscount) 
		.append(this.expIsRegisgration) 
		.append(this.expRegisgration) 
		.append(this.expCardNumber) 
		.append(this.expHardPerson) 
		.append(this.expSoctalNumber) 
		.append(this.expEntrustCompany) 
		.append(this.expZhuanye)
		.append(this.expArrears) 
		.append(this.expBorrowingStatus) 
		.append(this.expRetire) 
		.append(this.expSocialization) 
		.append(this.expOrganize) 
		.append(this.expResidence) 
		.append(this.expPension) 
		.append(this.expMedical) 
		.append(this.expInjury) 
		.append(this.expBirth) 
		.append(this.expSerious) 
		.append(this.expUnemployment) 
		.append(this.expAccumulation) 
		.append(this.expPensionDate) 
		.append(this.expMedicalDate) 
		.append(this.expInsurance)
		.append(this.expacc0m)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("expandId", this.expandId) 
		.append("expPersonId", this.expPersonId) 
		.append("expStartJobDate", this.expStartJobDate) 
		.append("expUserName", this.expUserName) 
		.append("expPersonNumber", this.expPersonNumber) 
		.append("expArchivesNumber", this.expArchivesNumber) 
		.append("expGengral1", this.expGengral1) 
		.append("expOldCompany", this.expOldCompany) 
		.append("expSecStatus", this.expSecStatus) 
		.append("expRemarks", this.expRemarks) 
		.append("expOpeartorUserId", this.expOpeartorUserId) 
		.append("expOpeartorDate", this.expOpeartorDate) 
		.append("expEquate", this.expEquate) 
		.append("expPersonStatus", this.expPersonStatus) 
		.append("expPersonPhone", this.expPersonPhone) 
		.append("expHourseDate", this.expHourseDate) 
		.append("expAddress", this.expAddress) 
		.append("expPost", this.expPost) 
		.append("expLevel", this.expLevel) 
		.append("expLevelDate", this.expLevelDate) 
		.append("expPositionCode", this.expPositionCode) 
		.append("expPositionName", this.expPositionName) 
		.append("expTechnical", this.expTechnical) 
		.append("expTechnicalDate", this.expTechnicalDate) 
		.append("expIsFamily", this.expIsFamily) 
		.append("expIsDifficult", this.expIsDifficult) 
		.append("expIsCadre", this.expIsCadre) 
		.append("expIsDiscount", this.expIsDiscount) 
		.append("expIsRegisgration", this.expIsRegisgration) 
		.append("expRegisgration", this.expRegisgration) 
		.append("expCardNumber", this.expCardNumber) 
		.append("expHardPerson", this.expHardPerson) 
		.append("expSoctalNumber", this.expSoctalNumber) 
		.append("expEntrustCompany", this.expEntrustCompany) 
		.append("expZhuanye", this.expZhuanye) 
		.append("expArrears", this.expArrears) 
		.append("expBorrowingStatus", this.expBorrowingStatus) 
		.append("expRetire", this.expRetire) 
		.append("expSocialization", this.expSocialization) 
		.append("expOrganize", this.expOrganize) 
		.append("expResidence", this.expResidence) 
		.append("expPension", this.expPension) 
		.append("expMedical", this.expMedical) 
		.append("expInjury", this.expInjury) 
		.append("expBirth", this.expBirth) 
		.append("expSerious", this.expSerious) 
		.append("expUnemployment", this.expUnemployment) 
		.append("expAccumulation", this.expAccumulation) 
		.append("expPensionDate", this.expPensionDate) 
		.append("expMedicalDate", this.expMedicalDate) 
		.append("expInsurance", this.expInsurance) 
		.append("expacc0m", this.expacc0m) 
		.toString();
	}
   
  

}