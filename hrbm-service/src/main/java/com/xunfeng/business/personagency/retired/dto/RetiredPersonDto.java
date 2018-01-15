package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;

/**
 * 退休人员登记dto
 * @author 张帆
 * @date 2016年8月3日09:45:18
 * @version 1.0
 *
 */
public class RetiredPersonDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//个人编号
	private String retiredPeopleNo;		
	//型号
	private String xh;		
	//退休个人编码
	private String retiredPeopleBm;	
	//姓名
	private String personName;
	//性别
	private String sex;
	//出生日期
	private java.util.Date personCsrq;
	//是否退休
	private Integer retiredPersonStatus;
	//退休申报状态
	private String statusName;
	//退休人员所属取悦
	private String retiredArea;
	//电话号
	private String phone;
	//手机号
	private String mobilePhone;
	//名族
	private String nationName;
	//参加工作时间
	private java.util.Date personWorkDate;
	//符合离退休规定条款
	private String rgName;
	//缴费年月
	private java.util.Date payDate;
	//应退休时间
	private java.util.Date retiredDate;
	//经办人
	private String createrName;
	//经办时间
	private java.util.Date createrDate;
	//经办机构
	private String createrOgnName;
	public String getRetiredPeopleNo() {
		return retiredPeopleNo;
	}
	public void setRetiredPeopleNo(String retiredPeopleNo) {
		this.retiredPeopleNo = retiredPeopleNo;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getRetiredPeopleBm() {
		return retiredPeopleBm;
	}
	public void setRetiredPeopleBm(String retiredPeopleBm) {
		this.retiredPeopleBm = retiredPeopleBm;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public java.util.Date getPersonCsrq() {
		return personCsrq;
	}
	public void setPersonCsrq(java.util.Date personCsrq) {
		this.personCsrq = personCsrq;
	}
	public Integer getRetiredPersonStatus() {
		return retiredPersonStatus;
	}
	public void setRetiredPersonStatus(Integer retiredPersonStatus) {
		this.retiredPersonStatus = retiredPersonStatus;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getRetiredArea() {
		return retiredArea;
	}
	public void setRetiredArea(String retiredArea) {
		this.retiredArea = retiredArea;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public java.util.Date getPersonWorkDate() {
		return personWorkDate;
	}
	public void setPersonWorkDate(java.util.Date personWorkDate) {
		this.personWorkDate = personWorkDate;
	}
	public String getRgName() {
		return rgName;
	}
	public void setRgName(String rgName) {
		this.rgName = rgName;
	}
	public java.util.Date getPayDate() {
		return payDate;
	}
	public void setPayDate(java.util.Date payDate) {
		this.payDate = payDate;
	}
	public java.util.Date getRetiredDate() {
		return retiredDate;
	}
	public void setRetiredDate(java.util.Date retiredDate) {
		this.retiredDate = retiredDate;
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
	public String getCreaterOgnName() {
		return createrOgnName;
	}
	public void setCreaterOgnName(String createrOgnName) {
		this.createrOgnName = createrOgnName;
	}
	
	
	
	
	
	
}
