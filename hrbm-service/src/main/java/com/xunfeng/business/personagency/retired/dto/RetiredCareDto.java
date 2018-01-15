package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;

import com.xunfeng.business.personagency.retired.model.RetiredCare;

/**
 * 大病医保信息Dto
 * @date 2016年12月19日11:25:08
 * @author zf
 * @version 1.0
 */
public class RetiredCareDto implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
		// 主键id
		protected Long  id;
		// 是否可申报大病医保
		protected Long  isCareDeclare;
		// 初次填报日期
		protected java.util.Date  firstFillDate;
		// 填报日期
		protected java.util.Date  fillDate;
		// 是否已申报
		protected Long  isDeclare;
		// 是否已通过
		protected Long  isFlag;
		// 大病医保所在区域
		protected String  addre;
		// 原因
		protected String  reason;
		// 备注
		protected String  note;
		// 人员id
		protected Long  personId;
		// 退休id
		protected Long  retiredId;
		// 经办人id
		protected Long  createrId;
		// 经办人姓名
		protected String  createrName;
		// 经办日期
		protected java.util.Date  createrDate;
		// 经办机构id
		protected Long  createrOrgId;
		// 经办日期
		protected String  createrOrgName;
	
	
	
	
	
	
	
	
	
	
	
	private String personCard;	//身份号码
	
	private String personName;	//姓名
	
	private String archiveCode;	//档案编号
	
	private String sex;	//性别
	
	private String archiveType;	//存档类型
	
	private String archiveStatus;	//档案状态
	
	private String retiredDate;	//退休时间
	
	private String retiredPeopleNo;	//个人编号
	
	private String expOldCompany;		//原单位名称

	private String retiredPeopleBm;	//退休个人编码
	
	private String mobilePhone;	//手机号
	
	private String phone;	//联系电话
	
	private String workResume;	//工作简历

	
	public String getPersonCard() {
		return personCard;
	}

	public void setPersonCard(String personCard) {
		this.personCard = personCard;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getArchiveCode() {
		return archiveCode;
	}

	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getArchiveType() {
		return archiveType;
	}

	public void setArchiveType(String archiveType) {
		this.archiveType = archiveType;
	}

	public String getArchiveStatus() {
		return archiveStatus;
	}

	public void setArchiveStatus(String archiveStatus) {
		this.archiveStatus = archiveStatus;
	}


	public String getRetiredPeopleNo() {
		return retiredPeopleNo;
	}

	public void setRetiredPeopleNo(String retiredPeopleNo) {
		this.retiredPeopleNo = retiredPeopleNo;
	}

	

	public String getRetiredDate() {
		return retiredDate;
	}

	public void setRetiredDate(String retiredDate) {
		this.retiredDate = retiredDate;
	}

	public String getExpOldCompany() {
		return expOldCompany;
	}

	public void setExpOldCompany(String expOldCompany) {
		this.expOldCompany = expOldCompany;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getRetiredPeopleBm() {
		return retiredPeopleBm;
	}

	public void setRetiredPeopleBm(String retiredPeopleBm) {
		this.retiredPeopleBm = retiredPeopleBm;
	}

	public String getMobilephone() {
		return mobilePhone;
	}

	public void setMobilephone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkResume() {
		return workResume;
	}

	public void setWorkResume(String workResume) {
		this.workResume = workResume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIsCareDeclare() {
		return isCareDeclare;
	}

	public void setIsCareDeclare(Long isCareDeclare) {
		this.isCareDeclare = isCareDeclare;
	}

	public java.util.Date getFirstFillDate() {
		return firstFillDate;
	}

	public void setFirstFillDate(java.util.Date firstFillDate) {
		this.firstFillDate = firstFillDate;
	}

	public java.util.Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(java.util.Date fillDate) {
		this.fillDate = fillDate;
	}

	public Long getIsDeclare() {
		return isDeclare;
	}

	public void setIsDeclare(Long isDeclare) {
		this.isDeclare = isDeclare;
	}

	public Long getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(Long isFlag) {
		this.isFlag = isFlag;
	}

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getRetiredId() {
		return retiredId;
	}

	public void setRetiredId(Long retiredId) {
		this.retiredId = retiredId;
	}

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public java.util.Date getCreaterDate() {
		return createrDate;
	}

	public void setCreaterDate(java.util.Date createrDate) {
		this.createrDate = createrDate;
	}

	public Long getCreaterOrgId() {
		return createrOrgId;
	}

	public void setCreaterOrgId(Long createrOrgId) {
		this.createrOrgId = createrOrgId;
	}

	public String getCreaterOrgName() {
		return createrOrgName;
	}

	public void setCreaterOrgName(String createrOrgName) {
		this.createrOrgName = createrOrgName;
	}
	
	

}
