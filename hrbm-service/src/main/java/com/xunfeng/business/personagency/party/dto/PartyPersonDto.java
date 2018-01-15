package com.xunfeng.business.personagency.party.dto;

import java.io.Serializable;
import java.util.Date;

public class PartyPersonDto implements Serializable{
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
private Long partyId;	//党员id
	
	private Long personId;	//人员id
	
	private Long expandId;	//人员扩展表
	
	private String personCard;	//公民身份号码
	
	private String personCsrq;	//出生日期
	
	private String personName;	//姓名
	
	private String personSex;	//性别
	
	private String mobilePhone;	//联系电话
	
	private String archiveCode;	//档案编号
	
	private String archiveName;	//档案姓名
	
	private String archiveBirthDate;	//档案出生日期
	
	private String partyIntoDate;	//档案转入日期
	
	private String archiveStatusName;	//档案状态
	
	private String archiveReceiveName;	//接收人
	
	private String archiveTypeName;	//存档类型
	
	private String corpName;	//所属单位名称
	
	private String phone;		//手机号
	
	private String	expCardAdd;	//家庭通讯地址
	
	private String affilName;	//政治面貌
	
	
	private String nationId;	//民族id
	
	private String nationName;	//名族
	
	private String personOldName;	//曾用名
	
	private String whcdId;		//文化程度id
	
	private String whcdName;	//文化程度
	
	
	private String zhuanyeName;	//专业名字
	
	private String partySchoolName;	//毕业院校
	
	private String partySchoolDate;	//毕业时间
	
	private String placeName;	//籍贯
	
	private String expAddress;	//现居住地址

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getExpandId() {
		return expandId;
	}

	public void setExpandId(Long expandId) {
		this.expandId = expandId;
	}

	public String getPersonCard() {
		return personCard;
	}

	public void setPersonCard(String personCard) {
		this.personCard = personCard;
	}

	public String getPersonCsrq() {
		return personCsrq;
	}

	public void setPersonCsrq(String personCsrq) {
		this.personCsrq = personCsrq;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getArchiveCode() {
		return archiveCode;
	}

	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}

	public String getArchiveName() {
		return archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}

	public String getArchiveBirthDate() {
		return archiveBirthDate;
	}

	public void setArchiveBirthDate(String archiveBirthDate) {
		this.archiveBirthDate = archiveBirthDate;
	}

	public String getPartyIntoDate() {
		return partyIntoDate;
	}

	public void setPartyIntoDate(String partyIntoDate) {
		this.partyIntoDate = partyIntoDate;
	}

	public String getArchiveStatusName() {
		return archiveStatusName;
	}

	public void setArchiveStatusName(String archiveStatusName) {
		this.archiveStatusName = archiveStatusName;
	}

	public String getArchiveReceiveName() {
		return archiveReceiveName;
	}

	public void setArchiveReceiveName(String archiveReceiveName) {
		this.archiveReceiveName = archiveReceiveName;
	}

	public String getArchiveTypeName() {
		return archiveTypeName;
	}

	public void setArchiveTypeName(String archiveTypeName) {
		this.archiveTypeName = archiveTypeName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExpCardAdd() {
		return expCardAdd;
	}

	public void setExpCardAdd(String expCardAdd) {
		this.expCardAdd = expCardAdd;
	}

	public String getAffilName() {
		return affilName;
	}

	public void setAffilName(String affilName) {
		this.affilName = affilName;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getPersonOldName() {
		return personOldName;
	}

	public void setPersonOldName(String personOldName) {
		this.personOldName = personOldName;
	}

	public String getWhcdId() {
		return whcdId;
	}

	public void setWhcdId(String whcdId) {
		this.whcdId = whcdId;
	}

	public String getWhcdName() {
		return whcdName;
	}

	public void setWhcdName(String whcdName) {
		this.whcdName = whcdName;
	}

	public String getZhuanyeName() {
		return zhuanyeName;
	}

	public void setZhuanyeName(String zhuanyeName) {
		this.zhuanyeName = zhuanyeName;
	}

	public String getPartySchoolName() {
		return partySchoolName;
	}

	public void setPartySchoolName(String partySchoolName) {
		this.partySchoolName = partySchoolName;
	}

	public String getPartySchoolDate() {
		return partySchoolDate;
	}

	public void setPartySchoolDate(String partySchoolDate) {
		this.partySchoolDate = partySchoolDate;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getExpAddress() {
		return expAddress;
	}

	public void setExpAddress(String expAddress) {
		this.expAddress = expAddress;
	}
	
	
	
	
	
	
}
