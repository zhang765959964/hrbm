package com.xunfeng.business.ovemp.corp.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 Model对象
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
public class OvempCorp extends BaseModel
{
	// 培训机构编号
	protected Long  pxOrgId;
	// 培训机构帐号
	protected String  orgAccount;
	// 培训机构密码
	protected String  orgPwd;
	// 培训机构名称
	protected String  orgName;
	// 培训机构LOGO图
	protected String  orgLogoDir;
	// 培训机构地址
	protected String  orgAddr;
	// 培训机构类型
	protected String  orgType;
	// 培训机构成立日期
	protected java.util.Date  orgEstablishDate;
	// 培训机构经营范围
	protected String  orgManageRange;
	// 联系人
	protected String  contactsName;
	// 联系电话
	protected String  contactsTel;
	// 培训机构邮箱
	protected String  orgEmail;
	// 培训机构证件
	protected String  orgCertificate;
	// 培训机构法人身份证
	protected String  orgLegalPersonId;
	// 是否审核通过,0未审核，1审核通过，2审核未通过
	protected String  isAudit;
	// 是否删除，1是 0否
	protected String  isDel;
	// 帐号是否禁用，1是 0否
	protected String  isDisable;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 培训机构行政区划
	protected String  orgAdminDivision;
	//培训机构行政区划名称
	protected String  orgAdminDivisionn;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	// 审核时间
	protected java.util.Date  abb771;
	// 审核人代码
	protected String  abb767;
	// 审核机构代码
	protected String  abb768;
	// 审核人
	protected String  abb769;
	// 审核机构
	protected String  abb770;
	// 审核意见
	protected String  abb772;
	// 名称拼音码
	protected String  aac022;
	// X坐标
	protected Float  cabq02;
	// Y坐标
	protected Float  cabq03;
	//培训机构发布名称
	protected String orgPublishName;
	//培训机构证件号
	protected String orgCertificateId;
	//法人身份证正面照
	protected String orgLegalPersonZphoto;
	//法人身份证反面照
	protected String orgLegalPersonFphoto;
	//组织机构代码证
	protected String pog009;
	//企业对外劳务合作证书
	protected String pog010;
	//企业常用联系人身份证正面照
	protected String pog011;
	//企业常用联系人身份证反面照
	protected String pog012;
	//企业联系人身份证
	protected String contactsCard;
	//企业代码(商务部导入使用)
	protected String pog001;
	
	public String getPog001() {
		return pog001;
	}
	public void setPog001(String pog001) {
		this.pog001 = pog001;
	}
	public String getContactsCard() {
		return contactsCard;
	}
	public void setContactsCard(String contactsCard) {
		this.contactsCard = contactsCard;
	}
	public String getPog009() {
		return pog009;
	}
	public void setPog009(String pog009) {
		this.pog009 = pog009;
	}
	public String getPog010() {
		return pog010;
	}
	public void setPog010(String pog010) {
		this.pog010 = pog010;
	}
	public String getPog011() {
		return pog011;
	}
	public void setPog011(String pog011) {
		this.pog011 = pog011;
	}
	public String getPog012() {
		return pog012;
	}
	public void setPog012(String pog012) {
		this.pog012 = pog012;
	}
	public void setPxOrgId(Long pxOrgId) 
	{
		this.pxOrgId = pxOrgId;
	}
	/**
	 * 返回 培训机构编号
	 * @return
	 */
	public Long getPxOrgId() 
	{
		return this.pxOrgId;
	}
	public void setOrgAccount(String orgAccount) 
	{
		this.orgAccount = orgAccount;
	}
	/**
	 * 返回 培训机构帐号
	 * @return
	 */
	public String getOrgAccount() 
	{
		return this.orgAccount;
	}
	public void setOrgPwd(String orgPwd) 
	{
		this.orgPwd = orgPwd;
	}
	/**
	 * 返回 培训机构密码
	 * @return
	 */
	public String getOrgPwd() 
	{
		return this.orgPwd;
	}
	public void setOrgName(String orgName) 
	{
		this.orgName = orgName;
	}
	/**
	 * 返回 培训机构名称
	 * @return
	 */
	public String getOrgName() 
	{
		return this.orgName;
	}
	public void setOrgLogoDir(String orgLogoDir) 
	{
		this.orgLogoDir = orgLogoDir;
	}
	/**
	 * 返回 培训机构LOGO图
	 * @return
	 */
	public String getOrgLogoDir() 
	{
		return this.orgLogoDir;
	}
	public void setOrgAddr(String orgAddr) 
	{
		this.orgAddr = orgAddr;
	}
	/**
	 * 返回 培训机构地址
	 * @return
	 */
	public String getOrgAddr() 
	{
		return this.orgAddr;
	}
	public void setOrgType(String orgType) 
	{
		this.orgType = orgType;
	}
	/**
	 * 返回 培训机构类型
	 * @return
	 */
	public String getOrgType() 
	{
		return this.orgType;
	}
	public void setOrgEstablishDate(java.util.Date orgEstablishDate) 
	{
		this.orgEstablishDate = orgEstablishDate;
	}
	/**
	 * 返回 培训机构成立日期
	 * @return
	 */
	public java.util.Date getOrgEstablishDate() 
	{
		return this.orgEstablishDate;
	}
	public void setOrgManageRange(String orgManageRange) 
	{
		this.orgManageRange = orgManageRange;
	}
	/**
	 * 返回 培训机构经营范围
	 * @return
	 */
	public String getOrgManageRange() 
	{
		return this.orgManageRange;
	}
	public void setContactsName(String contactsName) 
	{
		this.contactsName = contactsName;
	}
	/**
	 * 返回 联系人
	 * @return
	 */
	public String getContactsName() 
	{
		return this.contactsName;
	}
	public void setContactsTel(String contactsTel) 
	{
		this.contactsTel = contactsTel;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getContactsTel() 
	{
		return this.contactsTel;
	}
	public void setOrgEmail(String orgEmail) 
	{
		this.orgEmail = orgEmail;
	}
	/**
	 * 返回 培训机构邮箱
	 * @return
	 */
	public String getOrgEmail() 
	{
		return this.orgEmail;
	}
	public void setOrgCertificate(String orgCertificate) 
	{
		this.orgCertificate = orgCertificate;
	}
	/**
	 * 返回 培训机构证件
	 * @return
	 */
	public String getOrgCertificate() 
	{
		return this.orgCertificate;
	}
	public void setOrgLegalPersonId(String orgLegalPersonId) 
	{
		this.orgLegalPersonId = orgLegalPersonId;
	}
	/**
	 * 返回 培训机构法人身份证
	 * @return
	 */
	public String getOrgLegalPersonId() 
	{
		return this.orgLegalPersonId;
	}
	public void setIsAudit(String isAudit) 
	{
		this.isAudit = isAudit;
	}
	/**
	 * 返回 是否审核通过,0未审核，1审核通过，2审核未通过
	 * @return
	 */
	public String getIsAudit() 
	{
		return this.isAudit;
	}
	public void setIsDel(String isDel) 
	{
		this.isDel = isDel;
	}
	/**
	 * 返回 是否删除，1是 0否
	 * @return
	 */
	public String getIsDel() 
	{
		return this.isDel;
	}
	public void setIsDisable(String isDisable) 
	{
		this.isDisable = isDisable;
	}
	/**
	 * 返回 帐号是否禁用，1是 0否
	 * @return
	 */
	public String getIsDisable() 
	{
		return this.isDisable;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setOrgAdminDivision(String orgAdminDivision) 
	{
		this.orgAdminDivision = orgAdminDivision;
	}
	/**
	 * 返回 培训机构行政区划
	 * @return
	 */
	public String getOrgAdminDivision() 
	{
		return this.orgAdminDivision;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setAbb771(java.util.Date abb771) 
	{
		this.abb771 = abb771;
	}
	/**
	 * 返回 审核时间
	 * @return
	 */
	public java.util.Date getAbb771() 
	{
		return this.abb771;
	}
	public void setAbb767(String abb767) 
	{
		this.abb767 = abb767;
	}
	/**
	 * 返回 审核人代码
	 * @return
	 */
	public String getAbb767() 
	{
		return this.abb767;
	}
	public void setAbb768(String abb768) 
	{
		this.abb768 = abb768;
	}
	/**
	 * 返回 审核机构代码
	 * @return
	 */
	public String getAbb768() 
	{
		return this.abb768;
	}
	public void setAbb769(String abb769) 
	{
		this.abb769 = abb769;
	}
	/**
	 * 返回 审核人
	 * @return
	 */
	public String getAbb769() 
	{
		return this.abb769;
	}
	public void setAbb770(String abb770) 
	{
		this.abb770 = abb770;
	}
	/**
	 * 返回 审核机构
	 * @return
	 */
	public String getAbb770() 
	{
		return this.abb770;
	}
	public void setAbb772(String abb772) 
	{
		this.abb772 = abb772;
	}
	/**
	 * 返回 审核意见
	 * @return
	 */
	public String getAbb772() 
	{
		return this.abb772;
	}
	public void setAac022(String aac022) 
	{
		this.aac022 = aac022;
	}
	/**
	 * 返回 名称拼音码
	 * @return
	 */
	public String getAac022() 
	{
		return this.aac022;
	}
	public void setCabq02(Float cabq02) 
	{
		this.cabq02 = cabq02;
	}
	/**
	 * 返回 X坐标
	 * @return
	 */
	public Float getCabq02() 
	{
		return this.cabq02;
	}
	public void setCabq03(Float cabq03) 
	{
		this.cabq03 = cabq03;
	}
	/**
	 * 返回 Y坐标
	 * @return
	 */
	public Float getCabq03() 
	{
		return this.cabq03;
	}
 
   	public String getOrgPublishName() {
		return orgPublishName;
	}
   	
	public void setOrgPublishName(String orgPublishName) {
		this.orgPublishName = orgPublishName;
	}
	
	public String getOrgCertificateId() {
		return orgCertificateId;
	}
	
	public void setOrgCertificateId(String orgCertificateId) {
		this.orgCertificateId = orgCertificateId;
	}
	
	public String getOrgLegalPersonZphoto() {
		return orgLegalPersonZphoto;
	}
	
	public void setOrgLegalPersonZphoto(String orgLegalPersonZphoto) {
		this.orgLegalPersonZphoto = orgLegalPersonZphoto;
	}
	
	public String getOrgLegalPersonFphoto() {
		return orgLegalPersonFphoto;
	}
	
	public void setOrgLegalPersonFphoto(String orgLegalPersonFphoto) {
		this.orgLegalPersonFphoto = orgLegalPersonFphoto;
	}
	
	public String getOrgAdminDivisionn() {
		return orgAdminDivisionn;
	}
	public void setOrgAdminDivisionn(String orgAdminDivisionn) {
		this.orgAdminDivisionn = orgAdminDivisionn;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof OvempCorp)) 
		{
			return false;
		}
		OvempCorp rhs = (OvempCorp) object;
		return new EqualsBuilder()
		.append(this.pxOrgId, rhs.pxOrgId)
		.append(this.orgAccount, rhs.orgAccount)
		.append(this.orgPwd, rhs.orgPwd)
		.append(this.orgName, rhs.orgName)
		.append(this.orgLogoDir, rhs.orgLogoDir)
		.append(this.orgAddr, rhs.orgAddr)
		.append(this.orgType, rhs.orgType)
		.append(this.orgEstablishDate, rhs.orgEstablishDate)
		.append(this.orgManageRange, rhs.orgManageRange)
		.append(this.contactsName, rhs.contactsName)
		.append(this.contactsTel, rhs.contactsTel)
		.append(this.orgEmail, rhs.orgEmail)
		.append(this.orgCertificate, rhs.orgCertificate)
		.append(this.orgLegalPersonId, rhs.orgLegalPersonId)
		.append(this.isAudit, rhs.isAudit)
		.append(this.isDel, rhs.isDel)
		.append(this.isDisable, rhs.isDisable)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.orgAdminDivision, rhs.orgAdminDivision)
		.append(this.cczy06, rhs.cczy06)
		.append(this.abb771, rhs.abb771)
		.append(this.abb767, rhs.abb767)
		.append(this.abb768, rhs.abb768)
		.append(this.abb769, rhs.abb769)
		.append(this.abb770, rhs.abb770)
		.append(this.abb772, rhs.abb772)
		.append(this.aac022, rhs.aac022)
		.append(this.cabq02, rhs.cabq02)
		.append(this.cabq03, rhs.cabq03)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pxOrgId) 
		.append(this.orgAccount) 
		.append(this.orgPwd) 
		.append(this.orgName) 
		.append(this.orgLogoDir) 
		.append(this.orgAddr) 
		.append(this.orgType) 
		.append(this.orgEstablishDate) 
		.append(this.orgManageRange) 
		.append(this.contactsName) 
		.append(this.contactsTel) 
		.append(this.orgEmail) 
		.append(this.orgCertificate) 
		.append(this.orgLegalPersonId) 
		.append(this.isAudit) 
		.append(this.isDel) 
		.append(this.isDisable) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.orgAdminDivision) 
		.append(this.cczy06) 
		.append(this.abb771) 
		.append(this.abb767) 
		.append(this.abb768) 
		.append(this.abb769) 
		.append(this.abb770) 
		.append(this.abb772) 
		.append(this.aac022) 
		.append(this.cabq02) 
		.append(this.cabq03) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pxOrgId", this.pxOrgId) 
		.append("orgAccount", this.orgAccount) 
		.append("orgPwd", this.orgPwd) 
		.append("orgName", this.orgName) 
		.append("orgLogoDir", this.orgLogoDir) 
		.append("orgAddr", this.orgAddr) 
		.append("orgType", this.orgType) 
		.append("orgEstablishDate", this.orgEstablishDate) 
		.append("orgManageRange", this.orgManageRange) 
		.append("contactsName", this.contactsName) 
		.append("contactsTel", this.contactsTel) 
		.append("orgEmail", this.orgEmail) 
		.append("orgCertificate", this.orgCertificate) 
		.append("orgLegalPersonId", this.orgLegalPersonId) 
		.append("isAudit", this.isAudit) 
		.append("isDel", this.isDel) 
		.append("isDisable", this.isDisable) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("orgAdminDivision", this.orgAdminDivision) 
		.append("cczy06", this.cczy06) 
		.append("abb771", this.abb771) 
		.append("abb767", this.abb767) 
		.append("abb768", this.abb768) 
		.append("abb769", this.abb769) 
		.append("abb770", this.abb770) 
		.append("abb772", this.abb772) 
		.append("aac022", this.aac022) 
		.append("cabq02", this.cabq02) 
		.append("cabq03", this.cabq03) 
		.toString();
	}
   
  

}