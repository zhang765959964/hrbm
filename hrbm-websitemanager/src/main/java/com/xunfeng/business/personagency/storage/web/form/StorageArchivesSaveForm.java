package com.xunfeng.business.personagency.storage.web.form;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class StorageArchivesSaveForm 
{
	// 主键
	protected Long  id;
	// 市场位置
	protected String  marketPosition;
	// 档案排号
	protected String  cabinetsCode;
	// 档案层号
	protected String  cabinetsLayer;
	// 档案组号
	protected String  cabinetsLattice;
	// 档案入库人ID
	protected Long  archiveStorageUserid;
	// 档案来源
	protected String  archiveSource;
	// 档案库号
	protected String  cabinetsLibrary;
	// 档案入库人姓名
	protected String  archiveStorageName;
	// 档案入库经办机构id
	protected Long  archiveStorageOrgId;
	// 档案入库经办机构名称
	protected String  archiveStorageOrgName;
	// 档案入库经办日期
	protected java.util.Date  archiveStorageDate;
	// 档案接收状态（1-未入库，2-已入库）
	protected Long  archiveReceiveStatus;
	// 档案接收存放备注
	protected String  archiveReceiveDesc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarketPosition() {
		return marketPosition;
	}
	public void setMarketPosition(String marketPosition) {
		this.marketPosition = marketPosition;
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
	public Long getArchiveStorageUserid() {
		return archiveStorageUserid;
	}
	public void setArchiveStorageUserid(Long archiveStorageUserid) {
		this.archiveStorageUserid = archiveStorageUserid;
	}
	public String getArchiveSource() {
		return archiveSource;
	}
	public void setArchiveSource(String archiveSource) {
		this.archiveSource = archiveSource;
	}
	public String getCabinetsLibrary() {
		return cabinetsLibrary;
	}
	public void setCabinetsLibrary(String cabinetsLibrary) {
		this.cabinetsLibrary = cabinetsLibrary;
	}
	public String getArchiveStorageName() {
		return archiveStorageName;
	}
	public void setArchiveStorageName(String archiveStorageName) {
		this.archiveStorageName = archiveStorageName;
	}
	public Long getArchiveStorageOrgId() {
		return archiveStorageOrgId;
	}
	public void setArchiveStorageOrgId(Long archiveStorageOrgId) {
		this.archiveStorageOrgId = archiveStorageOrgId;
	}
	public String getArchiveStorageOrgName() {
		return archiveStorageOrgName;
	}
	public void setArchiveStorageOrgName(String archiveStorageOrgName) {
		this.archiveStorageOrgName = archiveStorageOrgName;
	}
	public java.util.Date getArchiveStorageDate() {
		return archiveStorageDate;
	}
	public void setArchiveStorageDate(java.util.Date archiveStorageDate) {
		this.archiveStorageDate = archiveStorageDate;
	}
	public Long getArchiveReceiveStatus() {
		return archiveReceiveStatus;
	}
	public void setArchiveReceiveStatus(Long archiveReceiveStatus) {
		this.archiveReceiveStatus = archiveReceiveStatus;
	}
	public String getArchiveReceiveDesc() {
		return archiveReceiveDesc;
	}
	public void setArchiveReceiveDesc(String archiveReceiveDesc) {
		this.archiveReceiveDesc = archiveReceiveDesc;
	}
	
	
	
	
}