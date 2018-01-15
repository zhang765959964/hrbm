package com.xunfeng.business.personagency.retired.web.form;

/**
 * 退休养老需要字段信息
 * @author Administrator
 *
 */
public class RetiredYangLaoForm {
	
	private Long id;	//退休id
	
	private String xh;	//序号
	
	private String retiredPeopleNo; 	//个人编号
	
	private String personName;	//姓名
		
	private String personCsrq;	//出生日期
	
	private String nationName;	//民族
	
	private String createrWorkDate;	//参加工作日期
	
	private String retiredArea;	//退休人员所属取悦
	
	private String rgName;	//符合退休条款
	
	private String status;	//退休申报状态
	
	private String statusName;	//退休申报值
	
	private Long personId;	//人员id
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getRetiredPeopleNo() {
		return retiredPeopleNo;
	}
	public void setRetiredPeopleNo(String retiredPeopleNo) {
		this.retiredPeopleNo = retiredPeopleNo;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonCsrq() {
		return personCsrq;
	}
	public void setPersonCsrq(String personCsrq) {
		this.personCsrq = personCsrq;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	
	public String getCreaterWorkDate() {
		return createrWorkDate;
	}
	public void setCreaterWorkDate(String createrWorkDate) {
		this.createrWorkDate = createrWorkDate;
	}
	public String getRetiredArea() {
		return retiredArea;
	}
	public void setRetiredArea(String retiredArea) {
		this.retiredArea = retiredArea;
	}
	public String getRgName() {
		return rgName;
	}
	public void setRgName(String rgName) {
		this.rgName = rgName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public Long getPersonId() {
	
		return personId;
	}
	
	public void setPersonId(Long personId) {
	
		this.personId = personId;
	}
	
	
	
	
	
	
}
