package com.xunfeng.business.personagency.party.dto;

import java.io.Serializable;

/**
 * 党组织关系dto
 * @author Administrator
 *
 */
public class PartyDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// 主键
	protected Long  id;
	// 人员id
	protected Long  partyPersonId;
	// 转入时间
	protected java.util.Date  partyIntoDate;
	// 转出时间
	protected java.util.Date  partyOutDate;
	// 转出原因
	protected String  partyOutReason;
	// 转出去向
	protected String  partyOutWhere;
	// 代党组织关系状态 0 否 1.是
	protected Long  partyStatus;
	// 入党时间
	protected java.util.Date  partyDate;
	// 备注
	protected String  partyNote;
	// 经办人id
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;  
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 曾用名
	protected String  partyOldName;
	// 专业
	protected String  partyZhuanye;
	// 毕业院校
	protected String  partySchoolName;
	// 毕业时间
	protected java.util.Date  partySchoolDate;
	// 手机
	protected String  partyPhone;
	// qq
	protected String  partyQq;
	// 其它联系方式
	protected String  partyOtherAdd;
	
	// 转正时间
	protected java.util.Date  partyPositiveDate;
	
	
	
	protected Long personId;	//人员id
	
	protected String placeName;	//籍贯
	
	protected PartyPersonDto partyPersonDto;	//个人信息和档案基本信息
	
	//终止人id
	protected Long outCreaterId;
		
	//终止经办人
	protected String outCreaterName;
		
	//终止经办时间
	protected java.util.Date outCreaterDate;
		
	//终止经办机构
	protected Long outCreaterOrgId;
		
	//终止经办机构名称
	protected String outCreaterOrgName;
		
	
	
	
	
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPartyPersonId() {
		return partyPersonId;
	}
	public void setPartyPersonId(Long partyPersonId) {
		this.partyPersonId = partyPersonId;
	}
	public java.util.Date getPartyIntoDate() {
		return partyIntoDate;
	}
	public void setPartyIntoDate(java.util.Date partyIntoDate) {
		this.partyIntoDate = partyIntoDate;
	}
	public java.util.Date getPartyOutDate() {
		return partyOutDate;
	}
	public void setPartyOutDate(java.util.Date partyOutDate) {
		this.partyOutDate = partyOutDate;
	}
	public String getPartyOutReason() {
		return partyOutReason;
	}
	public void setPartyOutReason(String partyOutReason) {
		this.partyOutReason = partyOutReason;
	}
	public String getPartyOutWhere() {
		return partyOutWhere;
	}
	public void setPartyOutWhere(String partyOutWhere) {
		this.partyOutWhere = partyOutWhere;
	}
	public Long getPartyStatus() {
		return partyStatus;
	}
	public void setPartyStatus(Long partyStatus) {
		this.partyStatus = partyStatus;
	}
	public java.util.Date getPartyDate() {
		return partyDate;
	}
	public void setPartyDate(java.util.Date partyDate) {
		this.partyDate = partyDate;
	}
	public String getPartyNote() {
		return partyNote;
	}
	public void setPartyNote(String partyNote) {
		this.partyNote = partyNote;
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
	public String getPartyOldName() {
		return partyOldName;
	}
	public void setPartyOldName(String partyOldName) {
		this.partyOldName = partyOldName;
	}
	public String getPartyZhuanye() {
		return partyZhuanye;
	}
	public void setPartyZhuanye(String partyZhuanye) {
		this.partyZhuanye = partyZhuanye;
	}
	public String getPartySchoolName() {
		return partySchoolName;
	}
	public void setPartySchoolName(String partySchoolName) {
		this.partySchoolName = partySchoolName;
	}
	
	public String getPartyPhone() {
		return partyPhone;
	}
	public void setPartyPhone(String partyPhone) {
		this.partyPhone = partyPhone;
	}
	public String getPartyQq() {
		return partyQq;
	}
	public void setPartyQq(String partyQq) {
		this.partyQq = partyQq;
	}
	public String getPartyOtherAdd() {
		return partyOtherAdd;
	}
	public void setPartyOtherAdd(String partyOtherAdd) {
		this.partyOtherAdd = partyOtherAdd;
	}
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public java.util.Date getPartySchoolDate() {
		return partySchoolDate;
	}
	public void setPartySchoolDate(java.util.Date partySchoolDate) {
		this.partySchoolDate = partySchoolDate;
	}
	public java.util.Date getPartyPositiveDate() {
		return partyPositiveDate;
	}
	public void setPartyPositiveDate(java.util.Date partyPositiveDate) {
		this.partyPositiveDate = partyPositiveDate;
	}
	public PartyPersonDto getPartyPersonDto() {
		return partyPersonDto;
	}
	public void setPartyPersonDto(PartyPersonDto partyPersonDto) {
		this.partyPersonDto = partyPersonDto;
	}
	public Long getOutCreaterId() {
		return outCreaterId;
	}
	public void setOutCreaterId(Long outCreaterId) {
		this.outCreaterId = outCreaterId;
	}
	public String getOutCreaterName() {
		return outCreaterName;
	}
	public void setOutCreaterName(String outCreaterName) {
		this.outCreaterName = outCreaterName;
	}
	public java.util.Date getOutCreaterDate() {
		return outCreaterDate;
	}
	public void setOutCreaterDate(java.util.Date outCreaterDate) {
		this.outCreaterDate = outCreaterDate;
	}
	public Long getOutCreaterOrgId() {
		return outCreaterOrgId;
	}
	public void setOutCreaterOrgId(Long outCreaterOrgId) {
		this.outCreaterOrgId = outCreaterOrgId;
	}
	public String getOutCreaterOrgName() {
		return outCreaterOrgName;
	}
	public void setOutCreaterOrgName(String outCreaterOrgName) {
		this.outCreaterOrgName = outCreaterOrgName;
	}

	
	
	

}
