package com.xunfeng.business.personagency.receive.dto;

import java.io.Serializable;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class PersonBaseDto implements Serializable
{
	
	// 主键id
	protected Long  expandId;
	// 个人编号
	protected Long  aac001;
	// 主键id（个人档案表）
	protected Long  id;
	
	
	// 公民身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	//出生日期
	protected String aac006;
	// 曾用名
	protected String  expUserName;
	// 性别
	protected String  genderName;
	// 档案姓名
	protected String  archiveName;
	// 民族
	protected String  aac005;
	// 政治面貌
	protected String  aac024;
	// 文化程度
	protected String  aac011;
	// 联系电话(ac01中AAE005存手机号)
	protected String  expPersonPhone;
	//手机号
	protected String aae005;
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
	// 就业失业登记证号码
	protected String  acc0m1;
	// 所在辖区（现居住所在地编码）
	protected String  bab301;
	// 居住所在地（现居住所在地名称）
	protected String  aab301;
	// 基本情况备注
	protected String  aae013;
	
	
	//参加保险情况
	//社会保障号
	protected String  expSoctalNumber;
	// 参加养老保险时间
	protected java.util.Date  expPensionDate;
	// 参加医疗保险时间
	protected java.util.Date  expMedicalDate;
	// 参加保险情况备注
	protected String  expInsurance;
	
	//状态信息
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
	
	
	
	
	
	
	public Long getExpandId() {
		return expandId;
	}
	public void setExpandId(Long expandId) {
		this.expandId = expandId;
	}
	public Long getAac001() {
		return aac001;
	}
	public void setAac001(Long aac001) {
		this.aac001 = aac001;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpSoctalNumber() {
		return expSoctalNumber;
	}
	public void setExpSoctalNumber(String expSoctalNumber) {
		this.expSoctalNumber = expSoctalNumber;
	}
	public java.util.Date getExpPensionDate() {
		return expPensionDate;
	}
	public void setExpPensionDate(java.util.Date expPensionDate) {
		this.expPensionDate = expPensionDate;
	}
	public java.util.Date getExpMedicalDate() {
		return expMedicalDate;
	}
	public void setExpMedicalDate(java.util.Date expMedicalDate) {
		this.expMedicalDate = expMedicalDate;
	}
	public String getExpInsurance() {
		return expInsurance;
	}
	public void setExpInsurance(String expInsurance) {
		this.expInsurance = expInsurance;
	}
	public String getExpArrears() {
		return expArrears;
	}
	public void setExpArrears(String expArrears) {
		this.expArrears = expArrears;
	}
	public String getExpBorrowingStatus() {
		return expBorrowingStatus;
	}
	public void setExpBorrowingStatus(String expBorrowingStatus) {
		this.expBorrowingStatus = expBorrowingStatus;
	}
	public String getExpRetire() {
		return expRetire;
	}
	public void setExpRetire(String expRetire) {
		this.expRetire = expRetire;
	}
	public String getExpSocialization() {
		return expSocialization;
	}
	public void setExpSocialization(String expSocialization) {
		this.expSocialization = expSocialization;
	}
	public String getExpOrganize() {
		return expOrganize;
	}
	public void setExpOrganize(String expOrganize) {
		this.expOrganize = expOrganize;
	}
	public String getExpResidence() {
		return expResidence;
	}
	public void setExpResidence(String expResidence) {
		this.expResidence = expResidence;
	}
	public String getExpPension() {
		return expPension;
	}
	public void setExpPension(String expPension) {
		this.expPension = expPension;
	}
	public String getExpMedical() {
		return expMedical;
	}
	public void setExpMedical(String expMedical) {
		this.expMedical = expMedical;
	}
	public String getExpInjury() {
		return expInjury;
	}
	public void setExpInjury(String expInjury) {
		this.expInjury = expInjury;
	}
	public String getExpBirth() {
		return expBirth;
	}
	public void setExpBirth(String expBirth) {
		this.expBirth = expBirth;
	}
	public String getExpSerious() {
		return expSerious;
	}
	public void setExpSerious(String expSerious) {
		this.expSerious = expSerious;
	}
	public String getExpUnemployment() {
		return expUnemployment;
	}
	public void setExpUnemployment(String expUnemployment) {
		this.expUnemployment = expUnemployment;
	}
	public String getExpAccumulation() {
		return expAccumulation;
	}
	public void setExpAccumulation(String expAccumulation) {
		this.expAccumulation = expAccumulation;
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
	public String getAac006() {
		return aac006;
	}
	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}
	public String getExpUserName() {
		return expUserName;
	}
	public void setExpUserName(String expUserName) {
		this.expUserName = expUserName;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getAac005() {
		return aac005;
	}
	public void setAac005(String aac005) {
		this.aac005 = aac005;
	}
	public String getAac024() {
		return aac024;
	}
	public void setAac024(String aac024) {
		this.aac024 = aac024;
	}
	public String getAac011() {
		return aac011;
	}
	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}
	public String getExpPersonPhone() {
		return expPersonPhone;
	}
	public void setExpPersonPhone(String expPersonPhone) {
		this.expPersonPhone = expPersonPhone;
	}
	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	public String getExpIsCadre() {
		return expIsCadre;
	}
	public void setExpIsCadre(String expIsCadre) {
		this.expIsCadre = expIsCadre;
	}
	public String getExpIsDiscount() {
		return expIsDiscount;
	}
	public void setExpIsDiscount(String expIsDiscount) {
		this.expIsDiscount = expIsDiscount;
	}
	public String getExpIsRegisgration() {
		return expIsRegisgration;
	}
	public void setExpIsRegisgration(String expIsRegisgration) {
		this.expIsRegisgration = expIsRegisgration;
	}
	public String getExpRegisgration() {
		return expRegisgration;
	}
	public void setExpRegisgration(String expRegisgration) {
		this.expRegisgration = expRegisgration;
	}
	public String getExpCardNumber() {
		return expCardNumber;
	}
	public void setExpCardNumber(String expCardNumber) {
		this.expCardNumber = expCardNumber;
	}
	public String getAcc0m1() {
		return acc0m1;
	}
	public void setAcc0m1(String acc0m1) {
		this.acc0m1 = acc0m1;
	}
	public String getBab301() {
		return bab301;
	}
	public void setBab301(String bab301) {
		this.bab301 = bab301;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	public String getAae013() {
		return aae013;
	}
	public void setAae013(String aae013) {
		this.aae013 = aae013;
	}
	
}