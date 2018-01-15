package com.xunfeng.business.personagency.receive.dto;

import java.io.Serializable;



/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class ReceiveArchivesPersonDto implements Serializable
{
	
	// 主键
	protected Long  id;
	// 档案编号
	protected String  archiveCode;
	// 存档类型
	protected Long  archiveType;
	// 档案接收日期
	protected String  receiveDate;
	// 档案名称
	protected String  archiveName;
	// 档案出生日期
	protected String  archiveBirthDate;
	// 退休参考日期
	protected String  planRetiredDate;
	// 退休年数
	protected Long  retiredAge;
	// 档案来源
	protected String  archiveSource;
	// 合同编号
	protected String  contractCode;
	// 市场位置
	protected String  marketPosition;
	// 档案库号
	protected String  cabinetsLibrary;
	// 档案排号
	protected String  cabinetsCode;
	// 档案层号
	protected String  cabinetsLayer;
	// 档案组号
	protected String  cabinetsLattice;
	// 档案接收存放备注
	protected String  archiveReceiveDesc;
	// 档案接收人ID
	protected Long  archiveReceiveUserid;
	// 档案接收人姓名
	protected String  archiveReceiveName;
	// 档案接收经办机构id
	protected Long  archiveReceiveOrgId;
	// 档案接收经办机构名称
	protected String  archiveReceiveOrgName;
	// 档案接收经办日期
	protected String  archiveReceiveDate;
	// 个人编号
	protected String  expPersonNumber;
	
	//个人基本信息
	public PersonBaseDto personBaseDto;
	//工作情况
	public GongZuoDto gongZuoDto;
	//家庭成员
	public JiaTingDto jiaTingDto;
	//个人教育背景
	public JiaoYuDto jiaoYuDto;
	
	//企业主键id
	protected Long  aab001;
	
	
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public String getExpPersonNumber() {
		return expPersonNumber;
	}
	public void setExpPersonNumber(String expPersonNumber) {
		this.expPersonNumber = expPersonNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}
	public Long getArchiveType() {
		return archiveType;
	}
	public void setArchiveType(Long archiveType) {
		this.archiveType = archiveType;
	}
	
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
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
	public Long getRetiredAge() {
		return retiredAge;
	}
	public void setRetiredAge(Long retiredAge) {
		this.retiredAge = retiredAge;
	}
	public String getArchiveSource() {
		return archiveSource;
	}
	public void setArchiveSource(String archiveSource) {
		this.archiveSource = archiveSource;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getMarketPosition() {
		return marketPosition;
	}
	public void setMarketPosition(String marketPosition) {
		this.marketPosition = marketPosition;
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
	public String getArchiveReceiveDesc() {
		return archiveReceiveDesc;
	}
	public void setArchiveReceiveDesc(String archiveReceiveDesc) {
		this.archiveReceiveDesc = archiveReceiveDesc;
	}
	public Long getArchiveReceiveUserid() {
		return archiveReceiveUserid;
	}
	public void setArchiveReceiveUserid(Long archiveReceiveUserid) {
		this.archiveReceiveUserid = archiveReceiveUserid;
	}
	public String getArchiveReceiveName() {
		return archiveReceiveName;
	}
	public void setArchiveReceiveName(String archiveReceiveName) {
		this.archiveReceiveName = archiveReceiveName;
	}
	public Long getArchiveReceiveOrgId() {
		return archiveReceiveOrgId;
	}
	public void setArchiveReceiveOrgId(Long archiveReceiveOrgId) {
		this.archiveReceiveOrgId = archiveReceiveOrgId;
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
	public PersonBaseDto getPersonBaseDto() {
		return personBaseDto;
	}
	public void setPersonBaseDto(PersonBaseDto personBaseDto) {
		this.personBaseDto = personBaseDto;
	}
	public GongZuoDto getGongZuoDto() {
		return gongZuoDto;
	}
	public void setGongZuoDto(GongZuoDto gongZuoDto) {
		this.gongZuoDto = gongZuoDto;
	}
	public JiaTingDto getJiaTingDto() {
		return jiaTingDto;
	}
	public void setJiaTingDto(JiaTingDto jiaTingDto) {
		this.jiaTingDto = jiaTingDto;
	}
	public JiaoYuDto getJiaoYuDto() {
		return jiaoYuDto;
	}
	public void setJiaoYuDto(JiaoYuDto jiaoYuDto) {
		this.jiaoYuDto = jiaoYuDto;
	}
	
	
}