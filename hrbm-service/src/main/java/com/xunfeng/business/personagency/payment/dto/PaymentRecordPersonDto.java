package com.xunfeng.business.personagency.payment.dto;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 缴费记录 Model对象
* @author:wanghan
* @createDate 2016-08-16 16:43:34 
* @version V1.0   
*/
public class PaymentRecordPersonDto extends PaymentRecord
{
	protected String id;
	protected String  archiveCode;
	protected String  aac002;
	protected String  aac003;
	// 欠费金额
	protected String overAmount;
	// 缴费终止日期
	protected String fdEndPaymentDate;
	// 性别
	protected String genderName;
	// 民族
	protected String nationName;
	// 出生日期
	protected String aac006;
	// 工作单位
	protected String expEntrustCompany;
	// 原单位
	protected String expOldCompany;
	// 职务
	protected String expPost;
	// 存档类型
	protected String archiveTypeName;
	// 参加工作时间
	protected String expStartJobDate;
	// 文化程度
	protected String educationName;
	// 婚姻状况
	protected String maritalStatusName;
	// 政治面貌
	protected String politicalLandscape;
	protected String archiveBirthDate;//档案出生日期
	protected String planRetiredDate;//退休参考日期
	protected String  receiveDate;//档案接收日期
	protected String archivePrintLabel;//打印标签次数
	protected String receiveDesc;//档案存放备注
	protected String   archiveReceiveDesc;//档案接收备注
	protected String   archiveReceiveName;//档案接收经办人
	protected String archiveReceiveOrgName;//档案接收经办机构
	protected String  archiveReceiveDate;//档案接收经办日期
	protected String  archiveStorageName;//档案入库经办人
	protected String  archiveStorageOrgName;//档案入库经办机构
	protected String archiveStorageDate;//档案入库经办日期
	protected String ContractCode;//合同编号
	protected String  marketPosition;//市场位置code
	protected String  marketPositionName;//市场位置
	protected String cabinetsLibrary;//档案库号（区）
	protected String  cabinetsCode;//档案排号(柜)
	protected String cabinetsLayer;//档案层号（排）
	protected String  cabinetsLattice;//档案组号（列）
	protected String  archiveStatus;//档案状态code
	protected String archiveStatusName;//档案状态(名称)
	protected String  archiveFlowStatusName;//档案流转状态
	protected String  archiveReceiveStatusName;//档案接收状态（名称）
	protected String  aae005;//手机号
	protected String  aab301;//居住所在地
	protected String expPersonPhone;//联系电话
	protected String expSoctalNumber;//社会保障号
	protected String expPersonNumber;//个人编号
	protected String  expIsDiscount;//是否享有再就业优惠证标准（0-否，1-是）
	protected String faName;//配偶姓名
	
	protected String  lendStringReason;//调出原因
	protected String  archivesLendWhere;//调出去向
	protected String   LendIdNumber;//调出人身份证号
	protected String  lendPhone;//调出人联系方式
	protected String  lendRemarks ;//调出原因
	protected String  lendConfirmName;//经办人
	protected String  lendConfirmDate; //经办时间
	protected String  lendConfirmOrgName;//经办机构
	protected String  aab004;
	
	
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
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
	public String getOverAmount() {
		return overAmount;
	}
	public void setOverAmount(String overAmount) {
		this.overAmount = overAmount;
	}
	public String getFdEndPaymentDate() {
		return fdEndPaymentDate;
	}
	public void setFdEndPaymentDate(String fdEndPaymentDate) {
		this.fdEndPaymentDate = fdEndPaymentDate;
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
	public String getAac006() {
		return aac006;
	}
	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}
	public String getExpEntrustCompany() {
		return expEntrustCompany;
	}
	public void setExpEntrustCompany(String expEntrustCompany) {
		this.expEntrustCompany = expEntrustCompany;
	}
	public String getExpOldCompany() {
		return expOldCompany;
	}
	public void setExpOldCompany(String expOldCompany) {
		this.expOldCompany = expOldCompany;
	}
	public String getExpPost() {
		return expPost;
	}
	public void setExpPost(String expPost) {
		this.expPost = expPost;
	}
	public String getArchiveTypeName() {
		return archiveTypeName;
	}
	public void setArchiveTypeName(String archiveTypeName) {
		this.archiveTypeName = archiveTypeName;
	}
	public String getExpStartJobDate() {
		return expStartJobDate;
	}
	public void setExpStartJobDate(String expStartJobDate) {
		this.expStartJobDate = expStartJobDate;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getMaritalStatusName() {
		return maritalStatusName;
	}
	public void setMaritalStatusName(String maritalStatusName) {
		this.maritalStatusName = maritalStatusName;
	}
	public String getPoliticalLandscape() {
		return politicalLandscape;
	}
	public void setPoliticalLandscape(String politicalLandscape) {
		this.politicalLandscape = politicalLandscape;
	}
	public String getArchiveBirthDate() {
		return archiveBirthDate;
	}
	public void setArchiveBirthDate(String archiveBirthDate) {
		this.archiveBirthDate = archiveBirthDate;
	}
	public String getPlanRetiredDate() {
		return planRetiredDate;
	}
	public void setPlanRetiredDate(String planRetiredDate) {
		this.planRetiredDate = planRetiredDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getArchivePrintLabel() {
		return archivePrintLabel;
	}
	public void setArchivePrintLabel(String archivePrintLabel) {
		this.archivePrintLabel = archivePrintLabel;
	}
	public String getReceiveDesc() {
		return receiveDesc;
	}
	public void setReceiveDesc(String receiveDesc) {
		this.receiveDesc = receiveDesc;
	}
	public String getArchiveReceiveDesc() {
		return archiveReceiveDesc;
	}
	public void setArchiveReceiveDesc(String archiveReceiveDesc) {
		this.archiveReceiveDesc = archiveReceiveDesc;
	}
	public String getArchiveReceiveName() {
		return archiveReceiveName;
	}
	public void setArchiveReceiveName(String archiveReceiveName) {
		this.archiveReceiveName = archiveReceiveName;
	}
	public String getArchiveReceiveOrgName() {
		return archiveReceiveOrgName;
	}
	public void setArchiveReceiveOrgName(String archiveReceiveOrgName) {
		this.archiveReceiveOrgName = archiveReceiveOrgName;
	}
	public String getArchiveReceiveDate() {
		return archiveReceiveDate;
	}
	public void setArchiveReceiveDate(String archiveReceiveDate) {
		this.archiveReceiveDate = archiveReceiveDate;
	}
	public String getArchiveStorageName() {
		return archiveStorageName;
	}
	public void setArchiveStorageName(String archiveStorageName) {
		this.archiveStorageName = archiveStorageName;
	}
	public String getArchiveStorageOrgName() {
		return archiveStorageOrgName;
	}
	public void setArchiveStorageOrgName(String archiveStorageOrgName) {
		this.archiveStorageOrgName = archiveStorageOrgName;
	}
	public String getArchiveStorageDate() {
		return archiveStorageDate;
	}
	public void setArchiveStorageDate(String archiveStorageDate) {
		this.archiveStorageDate = archiveStorageDate;
	}
	public String getContractCode() {
		return ContractCode;
	}
	public void setContractCode(String contractCode) {
		ContractCode = contractCode;
	}
	public String getMarketPosition() {
		return marketPosition;
	}
	public void setMarketPosition(String marketPosition) {
		this.marketPosition = marketPosition;
	}
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
	public String getArchiveStatus() {
		return archiveStatus;
	}
	public void setArchiveStatus(String archiveStatus) {
		this.archiveStatus = archiveStatus;
	}
	public String getArchiveStatusName() {
		return archiveStatusName;
	}
	public void setArchiveStatusName(String archiveStatusName) {
		this.archiveStatusName = archiveStatusName;
	}
	public String getArchiveFlowStatusName() {
		return archiveFlowStatusName;
	}
	public void setArchiveFlowStatusName(String archiveFlowStatusName) {
		this.archiveFlowStatusName = archiveFlowStatusName;
	}
	public String getArchiveReceiveStatusName() {
		return archiveReceiveStatusName;
	}
	public void setArchiveReceiveStatusName(String archiveReceiveStatusName) {
		this.archiveReceiveStatusName = archiveReceiveStatusName;
	}
	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	public String getExpPersonPhone() {
		return expPersonPhone;
	}
	public void setExpPersonPhone(String expPersonPhone) {
		this.expPersonPhone = expPersonPhone;
	}
	public String getExpSoctalNumber() {
		return expSoctalNumber;
	}
	public void setExpSoctalNumber(String expSoctalNumber) {
		this.expSoctalNumber = expSoctalNumber;
	}
	public String getExpPersonNumber() {
		return expPersonNumber;
	}
	public void setExpPersonNumber(String expPersonNumber) {
		this.expPersonNumber = expPersonNumber;
	}
	public String getExpIsDiscount() {
		return expIsDiscount;
	}
	public void setExpIsDiscount(String expIsDiscount) {
		this.expIsDiscount = expIsDiscount;
	}
	public String getFaName() {
		return faName;
	}
	public void setFaName(String faName) {
		this.faName = faName;
	}
	public String getLendStringReason() {
		return lendStringReason;
	}
	public void setLendStringReason(String lendStringReason) {
		this.lendStringReason = lendStringReason;
	}
	public String getArchivesLendWhere() {
		return archivesLendWhere;
	}
	public void setArchivesLendWhere(String archivesLendWhere) {
		this.archivesLendWhere = archivesLendWhere;
	}
	public String getLendIdNumber() {
		return LendIdNumber;
	}
	public void setLendIdNumber(String lendIdNumber) {
		LendIdNumber = lendIdNumber;
	}
	public String getLendPhone() {
		return lendPhone;
	}
	public void setLendPhone(String lendPhone) {
		this.lendPhone = lendPhone;
	}
	public String getLendRemarks() {
		return lendRemarks;
	}
	public void setLendRemarks(String lendRemarks) {
		this.lendRemarks = lendRemarks;
	}
	public String getLendConfirmName() {
		return lendConfirmName;
	}
	public void setLendConfirmName(String lendConfirmName) {
		this.lendConfirmName = lendConfirmName;
	}
	public String getLendConfirmDate() {
		return lendConfirmDate;
	}
	public void setLendConfirmDate(String lendConfirmDate) {
		this.lendConfirmDate = lendConfirmDate;
	}
	public String getLendConfirmOrgName() {
		return lendConfirmOrgName;
	}
	public void setLendConfirmOrgName(String lendConfirmOrgName) {
		this.lendConfirmOrgName = lendConfirmOrgName;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	
	public String getId() {
	
		return id;
	}
	
	public void setId(String id) {
	
		this.id = id;
	}
	
	
	
}