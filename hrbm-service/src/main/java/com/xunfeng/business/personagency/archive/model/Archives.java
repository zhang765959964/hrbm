package com.xunfeng.business.personagency.archive.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Model对象
* @author:jiangxin
* @createDate 2016-09-12 16:18:11 
* @version V1.0   
*/
public class Archives extends BaseModel
{
	// 主键
	protected Long  id;
	// 档案编号
	protected String  archiveCode;
	// 档案接收日期
	protected java.util.Date  receiveDate;
	// 档案名称
	protected String  archiveName;
	// 档案出生日期
	protected java.util.Date  archiveBirthDate;
	// 退休年数
	protected Long  retiredAge;
	// 退休参考日期
	protected java.util.Date  planRetiredDate;
	// 存档类型
	protected Long  archiveType;
	// 市场位置
	protected String  marketPosition;
	// 合同编号
	protected String  contractCode;
	// 档案状态
	protected Long  archiveStatus;
	// 人员Id
	protected Long  personId;
	// 档案排号
	protected String  cabinetsCode;
	// 档案层号
	protected String  cabinetsLayer;
	// 档案组号
	protected String  cabinetsLattice;
	// 档案存放备注
	protected String  receiveDesc;
	// 档案接收人ID
	protected Long  archiveReceiveUserid;
	// 档案入库人ID
	protected Long  archiveStorageUserid;
	// 档案入库日期
	protected java.util.Date  storageDate;
	// 流转状态
	protected Long  archiveFlowStatus;
	// 方位 南北
	protected Long  cabinetsPositionStatus;
	// 档案来源
	protected String  archiveSource;
	// 档案库号
	protected String  cabinetsLibrary;
	// 档案接收人姓名
	protected String  archiveReceiveName;
	// 档案接收经办机构id
	protected Long  archiveReceiveOrgId;
	// 档案接收经办机构名称
	protected String  archiveReceiveOrgName;
	// 档案接收经办日期
	protected java.util.Date  archiveReceiveDate;
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
	// 打印标签次数
	protected Long  archivePrintLabel;
	// 档案接收备注
	protected String  archiveReceiveDesc;
	// 数据来源（1-档案接收，2-社保补录）
	protected String  dataSources;
	// 历史编号（存json字符串）
	protected String  historyArchiveCode;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setArchiveCode(String archiveCode) 
	{
		this.archiveCode = archiveCode;
	}
	/**
	 * 返回 档案编号
	 * @return
	 */
	public String getArchiveCode() 
	{
		return this.archiveCode;
	}
	public void setReceiveDate(java.util.Date receiveDate) 
	{
		this.receiveDate = receiveDate;
	}
	/**
	 * 返回 档案接收日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getReceiveDate() 
	{
		return this.receiveDate;
	}
	public void setArchiveName(String archiveName) 
	{
		this.archiveName = archiveName;
	}
	/**
	 * 返回 档案名称
	 * @return
	 */
	public String getArchiveName() 
	{
		return this.archiveName;
	}
	public void setArchiveBirthDate(java.util.Date archiveBirthDate) 
	{
		this.archiveBirthDate = archiveBirthDate;
	}
	/**
	 * 返回 档案出生日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getArchiveBirthDate() 
	{
		return this.archiveBirthDate;
	}
	public void setRetiredAge(Long retiredAge) 
	{
		this.retiredAge = retiredAge;
	}
	/**
	 * 返回 退休年数
	 * @return
	 */
	public Long getRetiredAge() 
	{
		return this.retiredAge;
	}
	public void setPlanRetiredDate(java.util.Date planRetiredDate) 
	{
		this.planRetiredDate = planRetiredDate;
	}
	/**
	 * 返回 退休参考日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPlanRetiredDate() 
	{
		return this.planRetiredDate;
	}
	public void setArchiveType(Long archiveType) 
	{
		this.archiveType = archiveType;
	}
	/**
	 * 返回 存档类型
	 * @return
	 */
	public Long getArchiveType() 
	{
		return this.archiveType;
	}
	public void setMarketPosition(String marketPosition) 
	{
		this.marketPosition = marketPosition;
	}
	/**
	 * 返回 市场位置
	 * @return
	 */
	public String getMarketPosition() 
	{
		return this.marketPosition;
	}
	public void setContractCode(String contractCode) 
	{
		this.contractCode = contractCode;
	}
	/**
	 * 返回 合同编号
	 * @return
	 */
	public String getContractCode() 
	{
		return this.contractCode;
	}
	public void setArchiveStatus(Long archiveStatus) 
	{
		this.archiveStatus = archiveStatus;
	}
	/**
	 * 返回 档案状态
	 * @return
	 */
	public Long getArchiveStatus() 
	{
		return this.archiveStatus;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员Id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setCabinetsCode(String cabinetsCode) 
	{
		this.cabinetsCode = cabinetsCode;
	}
	/**
	 * 返回 档案排号
	 * @return
	 */
	public String getCabinetsCode() 
	{
		return this.cabinetsCode;
	}
	public void setCabinetsLayer(String cabinetsLayer) 
	{
		this.cabinetsLayer = cabinetsLayer;
	}
	/**
	 * 返回 档案层号
	 * @return
	 */
	public String getCabinetsLayer() 
	{
		return this.cabinetsLayer;
	}
	public void setCabinetsLattice(String cabinetsLattice) 
	{
		this.cabinetsLattice = cabinetsLattice;
	}
	/**
	 * 返回 档案组号
	 * @return
	 */
	public String getCabinetsLattice() 
	{
		return this.cabinetsLattice;
	}
	public void setReceiveDesc(String receiveDesc) 
	{
		this.receiveDesc = receiveDesc;
	}
	/**
	 * 返回 档案存放备注
	 * @return
	 */
	public String getReceiveDesc() 
	{
		return this.receiveDesc;
	}
	public void setArchiveReceiveUserid(Long archiveReceiveUserid) 
	{
		this.archiveReceiveUserid = archiveReceiveUserid;
	}
	/**
	 * 返回 档案接收人ID
	 * @return
	 */
	public Long getArchiveReceiveUserid() 
	{
		return this.archiveReceiveUserid;
	}
	public void setArchiveStorageUserid(Long archiveStorageUserid) 
	{
		this.archiveStorageUserid = archiveStorageUserid;
	}
	/**
	 * 返回 档案入库人ID
	 * @return
	 */
	public Long getArchiveStorageUserid() 
	{
		return this.archiveStorageUserid;
	}
	public void setStorageDate(java.util.Date storageDate) 
	{
		this.storageDate = storageDate;
	}
	/**
	 * 返回 档案入库日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getStorageDate() 
	{
		return this.storageDate;
	}
	public void setArchiveFlowStatus(Long archiveFlowStatus) 
	{
		this.archiveFlowStatus = archiveFlowStatus;
	}
	/**
	 * 返回 流转状态
	 * @return
	 */
	public Long getArchiveFlowStatus() 
	{
		return this.archiveFlowStatus;
	}
	public void setCabinetsPositionStatus(Long cabinetsPositionStatus) 
	{
		this.cabinetsPositionStatus = cabinetsPositionStatus;
	}
	/**
	 * 返回 方位 南北
	 * @return
	 */
	public Long getCabinetsPositionStatus() 
	{
		return this.cabinetsPositionStatus;
	}
	public void setArchiveSource(String archiveSource) 
	{
		this.archiveSource = archiveSource;
	}
	/**
	 * 返回 档案来源
	 * @return
	 */
	public String getArchiveSource() 
	{
		return this.archiveSource;
	}
	public void setCabinetsLibrary(String cabinetsLibrary) 
	{
		this.cabinetsLibrary = cabinetsLibrary;
	}
	/**
	 * 返回 档案库号
	 * @return
	 */
	public String getCabinetsLibrary() 
	{
		return this.cabinetsLibrary;
	}
	public void setArchiveReceiveName(String archiveReceiveName) 
	{
		this.archiveReceiveName = archiveReceiveName;
	}
	/**
	 * 返回 档案接收人姓名
	 * @return
	 */
	public String getArchiveReceiveName() 
	{
		return this.archiveReceiveName;
	}
	public void setArchiveReceiveOrgId(Long archiveReceiveOrgId) 
	{
		this.archiveReceiveOrgId = archiveReceiveOrgId;
	}
	/**
	 * 返回 档案接收经办机构id
	 * @return
	 */
	public Long getArchiveReceiveOrgId() 
	{
		return this.archiveReceiveOrgId;
	}
	public void setArchiveReceiveOrgName(String archiveReceiveOrgName) 
	{
		this.archiveReceiveOrgName = archiveReceiveOrgName;
	}
	/**
	 * 返回 档案接收经办机构名称
	 * @return
	 */
	public String getArchiveReceiveOrgName() 
	{
		return this.archiveReceiveOrgName;
	}
	public void setArchiveReceiveDate(java.util.Date archiveReceiveDate) 
	{
		this.archiveReceiveDate = archiveReceiveDate;
	}
	/**
	 * 返回 档案接收经办日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getArchiveReceiveDate() 
	{
		return this.archiveReceiveDate;
	}
	public void setArchiveStorageName(String archiveStorageName) 
	{
		this.archiveStorageName = archiveStorageName;
	}
	/**
	 * 返回 档案入库人姓名
	 * @return
	 */
	public String getArchiveStorageName() 
	{
		return this.archiveStorageName;
	}
	public void setArchiveStorageOrgId(Long archiveStorageOrgId) 
	{
		this.archiveStorageOrgId = archiveStorageOrgId;
	}
	/**
	 * 返回 档案入库经办机构id
	 * @return
	 */
	public Long getArchiveStorageOrgId() 
	{
		return this.archiveStorageOrgId;
	}
	public void setArchiveStorageOrgName(String archiveStorageOrgName) 
	{
		this.archiveStorageOrgName = archiveStorageOrgName;
	}
	/**
	 * 返回 档案入库经办机构名称
	 * @return
	 */
	public String getArchiveStorageOrgName() 
	{
		return this.archiveStorageOrgName;
	}
	public void setArchiveStorageDate(java.util.Date archiveStorageDate) 
	{
		this.archiveStorageDate = archiveStorageDate;
	}
	/**
	 * 返回 档案入库经办日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getArchiveStorageDate() 
	{
		return this.archiveStorageDate;
	}
	public void setArchiveReceiveStatus(Long archiveReceiveStatus) 
	{
		this.archiveReceiveStatus = archiveReceiveStatus;
	}
	/**
	 * 返回 档案接收状态（1-未入库，2-已入库）
	 * @return
	 */
	public Long getArchiveReceiveStatus() 
	{
		return this.archiveReceiveStatus;
	}
	public void setArchivePrintLabel(Long archivePrintLabel) 
	{
		this.archivePrintLabel = archivePrintLabel;
	}
	/**
	 * 返回 打印标签次数
	 * @return
	 */
	public Long getArchivePrintLabel() 
	{
		return this.archivePrintLabel;
	}
	public void setArchiveReceiveDesc(String archiveReceiveDesc) 
	{
		this.archiveReceiveDesc = archiveReceiveDesc;
	}
	/**
	 * 返回 档案接收备注
	 * @return
	 */
	public String getArchiveReceiveDesc() 
	{
		return this.archiveReceiveDesc;
	}
	public void setDataSources(String dataSources) 
	{
		this.dataSources = dataSources;
	}
	/**
	 * 返回 数据来源（1-档案接收，2-社保补录）
	 * @return
	 */
	public String getDataSources() 
	{
		return this.dataSources;
	}
	public void setHistoryArchiveCode(String historyArchiveCode) 
	{
		this.historyArchiveCode = historyArchiveCode;
	}
	/**
	 * 返回 历史编号（存json字符串）
	 * @return
	 */
	public String getHistoryArchiveCode() 
	{
		return this.historyArchiveCode;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Archives)) 
		{
			return false;
		}
		Archives rhs = (Archives) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archiveCode, rhs.archiveCode)
		.append(this.receiveDate, rhs.receiveDate)
		.append(this.archiveName, rhs.archiveName)
		.append(this.archiveBirthDate, rhs.archiveBirthDate)
		.append(this.retiredAge, rhs.retiredAge)
		.append(this.planRetiredDate, rhs.planRetiredDate)
		.append(this.archiveType, rhs.archiveType)
		.append(this.marketPosition, rhs.marketPosition)
		.append(this.contractCode, rhs.contractCode)
		.append(this.archiveStatus, rhs.archiveStatus)
		.append(this.personId, rhs.personId)
		.append(this.cabinetsCode, rhs.cabinetsCode)
		.append(this.cabinetsLayer, rhs.cabinetsLayer)
		.append(this.cabinetsLattice, rhs.cabinetsLattice)
		.append(this.receiveDesc, rhs.receiveDesc)
		.append(this.archiveReceiveUserid, rhs.archiveReceiveUserid)
		.append(this.archiveStorageUserid, rhs.archiveStorageUserid)
		.append(this.storageDate, rhs.storageDate)
		.append(this.archiveFlowStatus, rhs.archiveFlowStatus)
		.append(this.cabinetsPositionStatus, rhs.cabinetsPositionStatus)
		.append(this.archiveSource, rhs.archiveSource)
		.append(this.cabinetsLibrary, rhs.cabinetsLibrary)
		.append(this.archiveReceiveName, rhs.archiveReceiveName)
		.append(this.archiveReceiveOrgId, rhs.archiveReceiveOrgId)
		.append(this.archiveReceiveOrgName, rhs.archiveReceiveOrgName)
		.append(this.archiveReceiveDate, rhs.archiveReceiveDate)
		.append(this.archiveStorageName, rhs.archiveStorageName)
		.append(this.archiveStorageOrgId, rhs.archiveStorageOrgId)
		.append(this.archiveStorageOrgName, rhs.archiveStorageOrgName)
		.append(this.archiveStorageDate, rhs.archiveStorageDate)
		.append(this.archiveReceiveStatus, rhs.archiveReceiveStatus)
		.append(this.archivePrintLabel, rhs.archivePrintLabel)
		.append(this.archiveReceiveDesc, rhs.archiveReceiveDesc)
		.append(this.dataSources, rhs.dataSources)
		.append(this.historyArchiveCode, rhs.historyArchiveCode)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archiveCode) 
		.append(this.receiveDate) 
		.append(this.archiveName) 
		.append(this.archiveBirthDate) 
		.append(this.retiredAge) 
		.append(this.planRetiredDate) 
		.append(this.archiveType) 
		.append(this.marketPosition) 
		.append(this.contractCode) 
		.append(this.archiveStatus) 
		.append(this.personId) 
		.append(this.cabinetsCode) 
		.append(this.cabinetsLayer) 
		.append(this.cabinetsLattice) 
		.append(this.receiveDesc) 
		.append(this.archiveReceiveUserid) 
		.append(this.archiveStorageUserid) 
		.append(this.storageDate) 
		.append(this.archiveFlowStatus) 
		.append(this.cabinetsPositionStatus) 
		.append(this.archiveSource) 
		.append(this.cabinetsLibrary) 
		.append(this.archiveReceiveName) 
		.append(this.archiveReceiveOrgId) 
		.append(this.archiveReceiveOrgName) 
		.append(this.archiveReceiveDate) 
		.append(this.archiveStorageName) 
		.append(this.archiveStorageOrgId) 
		.append(this.archiveStorageOrgName) 
		.append(this.archiveStorageDate) 
		.append(this.archiveReceiveStatus) 
		.append(this.archivePrintLabel) 
		.append(this.archiveReceiveDesc) 
		.append(this.dataSources) 
		.append(this.historyArchiveCode) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archiveCode", this.archiveCode) 
		.append("receiveDate", this.receiveDate) 
		.append("archiveName", this.archiveName) 
		.append("archiveBirthDate", this.archiveBirthDate) 
		.append("retiredAge", this.retiredAge) 
		.append("planRetiredDate", this.planRetiredDate) 
		.append("archiveType", this.archiveType) 
		.append("marketPosition", this.marketPosition) 
		.append("contractCode", this.contractCode) 
		.append("archiveStatus", this.archiveStatus) 
		.append("personId", this.personId) 
		.append("cabinetsCode", this.cabinetsCode) 
		.append("cabinetsLayer", this.cabinetsLayer) 
		.append("cabinetsLattice", this.cabinetsLattice) 
		.append("receiveDesc", this.receiveDesc) 
		.append("archiveReceiveUserid", this.archiveReceiveUserid) 
		.append("archiveStorageUserid", this.archiveStorageUserid) 
		.append("storageDate", this.storageDate) 
		.append("archiveFlowStatus", this.archiveFlowStatus) 
		.append("cabinetsPositionStatus", this.cabinetsPositionStatus) 
		.append("archiveSource", this.archiveSource) 
		.append("cabinetsLibrary", this.cabinetsLibrary) 
		.append("archiveReceiveName", this.archiveReceiveName) 
		.append("archiveReceiveOrgId", this.archiveReceiveOrgId) 
		.append("archiveReceiveOrgName", this.archiveReceiveOrgName) 
		.append("archiveReceiveDate", this.archiveReceiveDate) 
		.append("archiveStorageName", this.archiveStorageName) 
		.append("archiveStorageOrgId", this.archiveStorageOrgId) 
		.append("archiveStorageOrgName", this.archiveStorageOrgName) 
		.append("archiveStorageDate", this.archiveStorageDate) 
		.append("archiveReceiveStatus", this.archiveReceiveStatus) 
		.append("archivePrintLabel", this.archivePrintLabel) 
		.append("archiveReceiveDesc", this.archiveReceiveDesc) 
		.append("dataSources", this.dataSources) 
		.append("historyArchiveCode", this.historyArchiveCode) 
		.toString();
	}
   
  

}