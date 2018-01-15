package com.xunfeng.business.personagency.subsidy.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 社保补贴 Form对象
 * @author:wanghan
 * @createDate 2016-07-07 16:58:57
 * @version V1.0
 */
public class ArchivesMakeupDto implements Serializable {
	// 主键
	protected Long id;
	/**
	 * 个人基本信息相关字段
	 */
	// 个人编号
	protected Long aac001;
	// 公民身份证号码
	protected String aac002;
	// 姓名
	protected String aac003;
	// 性别
	protected String aac004;
	protected String aae005;
	// 出生日期
	protected java.util.Date aac006;
	protected String aac005;

	protected String aac024;
	protected String aac011;
	protected String expUserName;
	protected String aac022;
	// 是否转干部（0-否，1-是）
	protected String expIsCadre;
	// 是否享有再就业优惠证标准（0-否，1-是）
	protected String expIsDiscount;
	// 是否持有就业失业登记证（0-否，1-是）
	protected String expIsRegisgration;
	// 再就业优惠证编号
	protected String expRegisgration;

	protected String acc0m1;
	// 身份证住址
	protected String expCardNumber;

	protected String aab301;
	protected String aae013;
	protected int userAge;

	protected String archiveCode;
	protected Date storageDate;
	protected Long archiveType;
	protected Long archiveStatus;
	// 调出登记经办人id
	protected Long lendCreaterId;
	// 调出登记经办人姓名
	protected String lendCreaterName;
	// 调出登记经办机构id
	protected Long lendCreaterOrgId;
	// 调出登记经办机构名称
	protected String lendCreaterOrgName;
	// 调出登记经办日期
	protected java.util.Date lendCreaterDate;
	// 调出原因（字符串）
	protected String lendStringReason;
	// 调出确认经办人id
	protected Long lendConfirmId;
	// 调出确认经办人姓名
	protected String lendConfirmName;
	// 调出确认经办机构id
	protected Long lendConfirmOrgId;
	// 调出确认经办机构名称
	protected String lendConfirmOrgName;
	// 调出确认经办日期
	protected java.util.Date lendConfirmDate;
	
	// 经办人ID
	protected Long  createrId;
	// 经办日期
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办机构Id
	protected Long  createrOrgId;

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回 主键
	 * 
	 * @return
	 */
	public Long getId() {
		return this.id;
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

	public java.util.Date getAac006() {
		return aac006;
	}

	public void setAac006(java.util.Date aac006) {
		this.aac006 = aac006;
	}

	public String getArchiveCode() {
		return archiveCode;
	}

	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public Long getArchiveType() {
		return archiveType;
	}

	public void setArchiveType(Long archiveType) {
		this.archiveType = archiveType;
	}

	public Long getArchiveStatus() {
		return archiveStatus;
	}

	public void setArchiveStatus(Long archiveStatus) {
		this.archiveStatus = archiveStatus;
	}

	public Long getLendCreaterId() {
		return lendCreaterId;
	}

	public void setLendCreaterId(Long lendCreaterId) {
		this.lendCreaterId = lendCreaterId;
	}

	public String getLendCreaterName() {
		return lendCreaterName;
	}

	public void setLendCreaterName(String lendCreaterName) {
		this.lendCreaterName = lendCreaterName;
	}

	public Long getLendCreaterOrgId() {
		return lendCreaterOrgId;
	}

	public void setLendCreaterOrgId(Long lendCreaterOrgId) {
		this.lendCreaterOrgId = lendCreaterOrgId;
	}

	public String getLendCreaterOrgName() {
		return lendCreaterOrgName;
	}

	public void setLendCreaterOrgName(String lendCreaterOrgName) {
		this.lendCreaterOrgName = lendCreaterOrgName;
	}

	public java.util.Date getLendCreaterDate() {
		return lendCreaterDate;
	}

	public void setLendCreaterDate(java.util.Date lendCreaterDate) {
		this.lendCreaterDate = lendCreaterDate;
	}

	public String getLendStringReason() {
		return lendStringReason;
	}

	public void setLendStringReason(String lendStringReason) {
		this.lendStringReason = lendStringReason;
	}

	public Long getLendConfirmId() {
		return lendConfirmId;
	}

	public void setLendConfirmId(Long lendConfirmId) {
		this.lendConfirmId = lendConfirmId;
	}

	public String getLendConfirmName() {
		return lendConfirmName;
	}

	public void setLendConfirmName(String lendConfirmName) {
		this.lendConfirmName = lendConfirmName;
	}

	public Long getLendConfirmOrgId() {
		return lendConfirmOrgId;
	}

	public void setLendConfirmOrgId(Long lendConfirmOrgId) {
		this.lendConfirmOrgId = lendConfirmOrgId;
	}

	public String getLendConfirmOrgName() {
		return lendConfirmOrgName;
	}

	public void setLendConfirmOrgName(String lendConfirmOrgName) {
		this.lendConfirmOrgName = lendConfirmOrgName;
	}

	public java.util.Date getLendConfirmDate() {
		return lendConfirmDate;
	}

	public void setLendConfirmDate(java.util.Date lendConfirmDate) {
		this.lendConfirmDate = lendConfirmDate;
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

	public String getExpUserName() {
		return expUserName;
	}

	public void setExpUserName(String expUserName) {
		this.expUserName = expUserName;
	}

	public String getAac022() {
		return aac022;
	}

	public void setAac022(String aac022) {
		this.aac022 = aac022;
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

	public String getAcc0m1() {
		return acc0m1;
	}

	public void setAcc0m1(String acc0m1) {
		this.acc0m1 = acc0m1;
	}

	public String getExpCardNumber() {
		return expCardNumber;
	}

	public void setExpCardNumber(String expCardNumber) {
		this.expCardNumber = expCardNumber;
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

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
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

	public String getCreaterOrgName() {
		return createrOrgName;
	}

	public void setCreaterOrgName(String createrOrgName) {
		this.createrOrgName = createrOrgName;
	}

	public Long getCreaterOrgId() {
		return createrOrgId;
	}

	public void setCreaterOrgId(Long createrOrgId) {
		this.createrOrgId = createrOrgId;
	}

}