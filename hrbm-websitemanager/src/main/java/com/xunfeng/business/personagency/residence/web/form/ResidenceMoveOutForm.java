package com.xunfeng.business.personagency.residence.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.residence.model.ResidenceMoveOut;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口迁入迁出表 Form对象
* @author:jiangxin
* @createDate 2016-08-27 15:36:07 
* @version V1.0   
*/
public class ResidenceMoveOutForm extends BaseForm<ResidenceMoveOut>
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 户口编号
	protected String  residenceNumber;
	// 户口状态
	protected String  residenceStatus;
	// 迁入日期
	protected java.util.Date  moveDate;
	// 迁出日期
	protected java.util.Date  outDate;
	// 落户地户籍部门
	protected String  settleDepartment;
	// 原户籍所在地
	protected String  originalDomicile;
	// 落户地址
	protected String  settleAddress;
	// 开具日期
	protected java.util.Date  openDate;
	// 毕业生届期
	protected String  thoseGraduates;
	// 迁往地址
	protected String  moveToAddress;
	// 备注
	protected String  description;
	// 经办人id
	protected Long  createrId;
	// 经办人
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 数据来源
	protected String  cczy06;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setArchivesId(Long archivesId) 
	{
		this.archivesId = archivesId;
	}
	/**
	 * 返回 档案id
	 * @return
	 */
	public Long getArchivesId() 
	{
		return this.archivesId;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setResidenceNumber(String residenceNumber) 
	{
		this.residenceNumber = residenceNumber;
	}
	/**
	 * 返回 户口编号
	 * @return
	 */
	public String getResidenceNumber() 
	{
		return this.residenceNumber;
	}
	public void setResidenceStatus(String residenceStatus) 
	{
		this.residenceStatus = residenceStatus;
	}
	/**
	 * 返回 户口状态
	 * @return
	 */
	public String getResidenceStatus() 
	{
		return this.residenceStatus;
	}
	public void setMoveDate(java.util.Date moveDate) 
	{
		this.moveDate = moveDate;
	}
	/**
	 * 返回 迁入日期
	 * @return
	 */
	public java.util.Date getMoveDate() 
	{
		return this.moveDate;
	}
	public void setOutDate(java.util.Date outDate) 
	{
		this.outDate = outDate;
	}
	/**
	 * 返回 迁出日期
	 * @return
	 */
	public java.util.Date getOutDate() 
	{
		return this.outDate;
	}
	public void setSettleDepartment(String settleDepartment) 
	{
		this.settleDepartment = settleDepartment;
	}
	/**
	 * 返回 落户地户籍部门
	 * @return
	 */
	public String getSettleDepartment() 
	{
		return this.settleDepartment;
	}
	public void setOriginalDomicile(String originalDomicile) 
	{
		this.originalDomicile = originalDomicile;
	}
	/**
	 * 返回 原户籍所在地
	 * @return
	 */
	public String getOriginalDomicile() 
	{
		return this.originalDomicile;
	}
	public void setSettleAddress(String settleAddress) 
	{
		this.settleAddress = settleAddress;
	}
	/**
	 * 返回 落户地址
	 * @return
	 */
	public String getSettleAddress() 
	{
		return this.settleAddress;
	}
	public void setOpenDate(java.util.Date openDate) 
	{
		this.openDate = openDate;
	}
	/**
	 * 返回 开具日期
	 * @return
	 */
	public java.util.Date getOpenDate() 
	{
		return this.openDate;
	}
	public void setThoseGraduates(String thoseGraduates) 
	{
		this.thoseGraduates = thoseGraduates;
	}
	/**
	 * 返回 毕业生届期
	 * @return
	 */
	public String getThoseGraduates() 
	{
		return this.thoseGraduates;
	}
	public void setMoveToAddress(String moveToAddress) 
	{
		this.moveToAddress = moveToAddress;
	}
	/**
	 * 返回 迁往地址
	 * @return
	 */
	public String getMoveToAddress() 
	{
		return this.moveToAddress;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getDescription() 
	{
		return this.description;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人id
	 * @return
	 */
	public Long getCreaterId() 
	{
		return this.createrId;
	}
	public void setCreaterName(String createrName) 
	{
		this.createrName = createrName;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
	}
	public void setCreaterOrgId(Long createrOrgId) 
	{
		this.createrOrgId = createrOrgId;
	}
	/**
	 * 返回 经办机构id
	 * @return
	 */
	public Long getCreaterOrgId() 
	{
		return this.createrOrgId;
	}
	public void setCreaterOrgName(String createrOrgName) 
	{
		this.createrOrgName = createrOrgName;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getCreaterOrgName() 
	{
		return this.createrOrgName;
	}
	public void setCreaterDate(java.util.Date createrDate) 
	{
		this.createrDate = createrDate;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ResidenceMoveOutForm)) 
		{
			return false;
		}
		ResidenceMoveOutForm rhs = (ResidenceMoveOutForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.residenceNumber, rhs.residenceNumber)
		.append(this.residenceStatus, rhs.residenceStatus)
		.append(this.moveDate, rhs.moveDate)
		.append(this.outDate, rhs.outDate)
		.append(this.settleDepartment, rhs.settleDepartment)
		.append(this.originalDomicile, rhs.originalDomicile)
		.append(this.settleAddress, rhs.settleAddress)
		.append(this.openDate, rhs.openDate)
		.append(this.thoseGraduates, rhs.thoseGraduates)
		.append(this.moveToAddress, rhs.moveToAddress)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archivesId) 
		.append(this.personId) 
		.append(this.residenceNumber) 
		.append(this.residenceStatus) 
		.append(this.moveDate) 
		.append(this.outDate) 
		.append(this.settleDepartment) 
		.append(this.originalDomicile) 
		.append(this.settleAddress) 
		.append(this.openDate) 
		.append(this.thoseGraduates) 
		.append(this.moveToAddress) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.cczy06) 
		.append(this.ccpr08) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archivesId", this.archivesId) 
		.append("personId", this.personId) 
		.append("residenceNumber", this.residenceNumber) 
		.append("residenceStatus", this.residenceStatus) 
		.append("moveDate", this.moveDate) 
		.append("outDate", this.outDate) 
		.append("settleDepartment", this.settleDepartment) 
		.append("originalDomicile", this.originalDomicile) 
		.append("settleAddress", this.settleAddress) 
		.append("openDate", this.openDate) 
		.append("thoseGraduates", this.thoseGraduates) 
		.append("moveToAddress", this.moveToAddress) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("cczy06", this.cczy06) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}