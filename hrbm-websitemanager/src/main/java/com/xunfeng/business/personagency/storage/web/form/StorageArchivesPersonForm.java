package com.xunfeng.business.personagency.storage.web.form;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class StorageArchivesPersonForm 
{
	//档案移库
	// 主键
	protected Long  id;
	// 公民身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	// 姓名拼音码
	protected String  aac022;
	//出生日期
	protected String aac006;
	// 性别
	protected String  genderName;
	// 民族
	protected String nationName;
	// 婚姻状况
	protected String  maritalStatusName;
	// 配偶姓名
	protected String  faName;
	// 文化程度
	protected String  educationName;
	// 政治面貌
	protected String  politicalLandScape;
	// 参加工作时间
	protected String  expStartJobDate;
	// 是否转干部（0-否，1-是）
	protected String  expIsCadreName;
	// 联系电话
	protected String  aae005;
	// 联系电话(ac01中AAE005存手机号)
	protected String  expPersonPhone;
	// 是否享有再就业优惠证标准（0-否，1-是）
	protected String  expISDiscount;
	// 居住所在地
	protected String  aab301;
	// 档案编号
	protected String  archiveCode;
	// 档案出生日期
	protected String  archiveBirthDate;
	// 档案接收日期
	protected String  receiveDate;
	// 档案名称
	protected String  archiveName;
	// 退休年数
	protected Long  retiredAge;
	// 退休参考日期
	protected String  planRetiredDate;
	// 档案状态
	protected String  archiveStatusName;
	// 个人编号
	protected String  expPersonNumber;
	//委托单位名称
	protected String  expEntrustCompany;
	// 存档类型
	protected String  archiveTypeName;
	// 备注
	protected String  aae013;
	//档案入库
	//市场位置
	protected String marketPositionName;
	// 档案库号
	protected String  cabinetsLibrary;
	// 档案排号
	protected String  cabinetsCode;
	// 档案层号
	protected String  cabinetsLayer;
	// 档案组号
	protected String  cabinetsLattice;
	// 档案来源
	protected String archiveSource;
	// 档案接收状态（1-未入库，2-已入库）
	protected Long  archiveReceiveStatus;
	// 档案接收状态（1-未入库，2-已入库）
	protected String  archiveReceiveStatusName;
	// 档案接收存放备注
	protected String  archiveReceiveDesc;
	
	
	
	public String getMarketPositionName() {
		return marketPositionName;
	}
	public void setMarketPositionName(String marketPositionName) {
		this.marketPositionName = marketPositionName;
	}
	public String getCabinetsLibrary() {
		return cabinetsLibrary;
	}
	public void setCabinetsLibrary(String cabinetsLibrary) {
		this.cabinetsLibrary = cabinetsLibrary;
	}
	public String getCabinetsCode() {
		return cabinetsCode;
	}
	public void setCabinetsCode(String cabinetsCode) {
		this.cabinetsCode = cabinetsCode;
	}
	public String getCabinetsLayer() {
		return cabinetsLayer;
	}
	public void setCabinetsLayer(String cabinetsLayer) {
		this.cabinetsLayer = cabinetsLayer;
	}
	public String getCabinetsLattice() {
		return cabinetsLattice;
	}
	public void setCabinetsLattice(String cabinetsLattice) {
		this.cabinetsLattice = cabinetsLattice;
	}
	public String getArchiveSource() {
		return archiveSource;
	}
	public void setArchiveSource(String archiveSource) {
		this.archiveSource = archiveSource;
	}
	public Long getArchiveReceiveStatus() {
		return archiveReceiveStatus;
	}
	public void setArchiveReceiveStatus(Long archiveReceiveStatus) {
		this.archiveReceiveStatus = archiveReceiveStatus;
	}
	public String getArchiveReceiveStatusName() {
		return archiveReceiveStatusName;
	}
	public void setArchiveReceiveStatusName(String archiveReceiveStatusName) {
		this.archiveReceiveStatusName = archiveReceiveStatusName;
	}
	public String getArchiveReceiveDesc() {
		return archiveReceiveDesc;
	}
	public void setArchiveReceiveDesc(String archiveReceiveDesc) {
		this.archiveReceiveDesc = archiveReceiveDesc;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAac022() {
		return aac022;
	}
	public void setAac022(String aac022) {
		this.aac022 = aac022;
	}
	public String getAac006() {
		return aac006;
	}
	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getMaritalStatusName() {
		return maritalStatusName;
	}
	public void setMaritalStatusName(String maritalStatusName) {
		this.maritalStatusName = maritalStatusName;
	}
	public String getFaName() {
		return faName;
	}
	public void setFaName(String faName) {
		this.faName = faName;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getPoliticalLandScape() {
		return politicalLandScape;
	}
	public void setPoliticalLandScape(String politicalLandScape) {
		this.politicalLandScape = politicalLandScape;
	}
	public String getExpStartJobDate() {
		return expStartJobDate;
	}
	public void setExpStartJobDate(String expStartJobDate) {
		this.expStartJobDate = expStartJobDate;
	}
	public String getExpIsCadreName() {
		return expIsCadreName;
	}
	public void setExpIsCadreName(String expIsCadreName) {
		this.expIsCadreName = expIsCadreName;
	}
	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	public String getExpPersonPhone() {
		return expPersonPhone;
	}
	public void setExpPersonPhone(String expPersonPhone) {
		this.expPersonPhone = expPersonPhone;
	}
	public String getExpISDiscount() {
		return expISDiscount;
	}
	public void setExpISDiscount(String expISDiscount) {
		this.expISDiscount = expISDiscount;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}
	public String getArchiveBirthDate() {
		return archiveBirthDate;
	}
	public void setArchiveBirthDate(String archiveBirthDate) {
		this.archiveBirthDate = archiveBirthDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public Long getRetiredAge() {
		return retiredAge;
	}
	public void setRetiredAge(Long retiredAge) {
		this.retiredAge = retiredAge;
	}
	public String getPlanRetiredDate() {
		return planRetiredDate;
	}
	public void setPlanRetiredDate(String planRetiredDate) {
		this.planRetiredDate = planRetiredDate;
	}
	public String getArchiveStatusName() {
		return archiveStatusName;
	}
	public void setArchiveStatusName(String archiveStatusName) {
		this.archiveStatusName = archiveStatusName;
	}
	public String getExpPersonNumber() {
		return expPersonNumber;
	}
	public void setExpPersonNumber(String expPersonNumber) {
		this.expPersonNumber = expPersonNumber;
	}
	public String getExpEntrustCompany() {
		return expEntrustCompany;
	}
	public void setExpEntrustCompany(String expEntrustCompany) {
		this.expEntrustCompany = expEntrustCompany;
	}
	public String getArchiveTypeName() {
		return archiveTypeName;
	}
	public void setArchiveTypeName(String archiveTypeName) {
		this.archiveTypeName = archiveTypeName;
	}
	public String getAae013() {
		return aae013;
	}
	public void setAae013(String aae013) {
		this.aae013 = aae013;
	}
	
	
	
}