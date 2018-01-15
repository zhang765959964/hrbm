package com.xunfeng.business.personagency.payment.web.form;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class ArchivesPersonBaseForm 
{
	//档案id
	protected Long  id;
	// 公民身份证号码
	protected String  AAC002;
	// 姓名
	protected String  AAC003;
	// 性别
	protected String  genderName;
	// 档案编号
	protected String  archiveCode;
	// 档案状态
	protected String  archiveStatusName;
	// 存档类型
	protected String  archiveTypeName;
	//联系电话
	protected String expPersonPhone;
	//出生日期
	protected String AAC006;
	//档案出生日期
	protected String archiveBirthDate;
	//档案姓名
	protected String archiveName;
	//档案接收人
	protected String archiveReceiveName;
	//档案转入日期
	protected String receiveDate;
	//手机号
	protected String AAE005;
	//原工作单位
	protected String expOldCompany;
	//委托单位名称
	protected String expEntrustCompany;
	//档案流转状态
	protected Long archiveFlowStatus;
	//档案接收状态
	protected Long archiveReceiveStatus;
	
	protected String contractCode;
	
	protected String paymentEndDate;
	
	
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public Long getArchiveReceiveStatus() {
		return archiveReceiveStatus;
	}
	public void setArchiveReceiveStatus(Long archiveReceiveStatus) {
		this.archiveReceiveStatus = archiveReceiveStatus;
	}
	public Long getArchiveFlowStatus() {
		return archiveFlowStatus;
	}
	public void setArchiveFlowStatus(Long archiveFlowStatus) {
		this.archiveFlowStatus = archiveFlowStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpPersonPhone() {
		return expPersonPhone;
	}
	public void setExpPersonPhone(String expPersonPhone) {
		this.expPersonPhone = expPersonPhone;
	}
	public String getAAC006() {
		return AAC006;
	}
	public void setAAC006(String aAC006) {
		AAC006 = aAC006;
	}
	public String getArchiveBirthDate() {
		return archiveBirthDate;
	}
	public void setArchiveBirthDate(String archiveBirthDate) {
		this.archiveBirthDate = archiveBirthDate;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getArchiveReceiveName() {
		return archiveReceiveName;
	}
	public void setArchiveReceiveName(String archiveReceiveName) {
		this.archiveReceiveName = archiveReceiveName;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getAAE005() {
		return AAE005;
	}
	public void setAAE005(String aAE005) {
		AAE005 = aAE005;
	}
	public String getExpOldCompany() {
		return expOldCompany;
	}
	public void setExpOldCompany(String expOldCompany) {
		this.expOldCompany = expOldCompany;
	}
	public String getExpEntrustCompany() {
		return expEntrustCompany;
	}
	public void setExpEntrustCompany(String expEntrustCompany) {
		this.expEntrustCompany = expEntrustCompany;
	}
	public String getAAC002() {
		return AAC002;
	}
	public void setAAC002(String aAC002) {
		AAC002 = aAC002;
	}
	public String getAAC003() {
		return AAC003;
	}
	public void setAAC003(String aAC003) {
		AAC003 = aAC003;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}
	public String getArchiveStatusName() {
		return archiveStatusName;
	}
	public void setArchiveStatusName(String archiveStatusName) {
		this.archiveStatusName = archiveStatusName;
	}
	public String getArchiveTypeName() {
		return archiveTypeName;
	}
	public void setArchiveTypeName(String archiveTypeName) {
		this.archiveTypeName = archiveTypeName;
	}
	public String getPaymentEndDate() {
		return paymentEndDate;
	}
	public void setPaymentEndDate(String paymentEndDate) {
		this.paymentEndDate = paymentEndDate;
	}
	
	

}