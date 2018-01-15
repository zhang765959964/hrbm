package com.xunfeng.business.personagency.retired.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员申报表 Model对象
* @author:zhangfan
* @createDate 2016-07-16 11:24:12 
* @version V1.0   
*/
public class RetiredDeclare extends BaseModel
{
	// 退休申报表id
	protected Long  id;
	// 单位名称
	protected String  unitName;
	// 单位编号
	protected String  unitNo;
	// 郑劳退字（）年（）号
	protected String  zltzh;
	// 序号
	protected String  xh;
	// 工种
	protected String  gzId;
	// 参加工作日期
	protected java.util.Date  createWorkDate;
	// 退休人员所属区域
	protected String  retiredArea;
	// 退休（退职）依据
	protected String  retiredYjId;
	// 退休类别
	protected String  retiredTypeId;
	// 退休后安置点
	protected String  retiredSite;
	// 民族(56)
	protected String  nationalId;
	// 申报分类
	protected String  declareType;
	// 公示开始时间
	protected java.util.Date  gsCreateDate;
	// 公示结束时间
	protected java.util.Date  gsStopDate;
	// 个人编号
	protected String  retiredPeopleNo;
	// 退休申报状态
	protected String  retiredDeclareStatus;
	// 退休个人编码
	protected String  retiredPeopleBm;
	// 申报备注
	protected String  declareNote;
	// 经办人
	protected Long  createrId;
	// 经办机构
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 工作经历维护ID   外键
	protected Long  workExperienceId;
	// 工作扣减情况id  外键
	protected Long  workKjId;
	// 个人基本信息id 外键
	protected Long  peopleId;
	// 档案基本信息ID 外键
	protected Long  archiveId;
	//是否正式退休（0.否 1.是 ）
	protected Long retiredStatus;
	//工种
	protected String craft;
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 退休申报表id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setUnitName(String unitName) 
	{
		this.unitName = unitName;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getUnitName() 
	{
		return this.unitName;
	}
	public void setUnitNo(String unitNo) 
	{
		this.unitNo = unitNo;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public String getUnitNo() 
	{
		return this.unitNo;
	}
	public void setZltzh(String zltzh) 
	{
		this.zltzh = zltzh;
	}
	/**
	 * 返回 郑劳退字（）年（）号
	 * @return
	 */
	public String getZltzh() 
	{
		return this.zltzh;
	}
	public void setXh(String xh) 
	{
		this.xh = xh;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public String getXh() 
	{
		return this.xh;
	}
	public void setGzId(String gzId) 
	{
		this.gzId = gzId;
	}
	/**
	 * 返回 工种
	 * @return
	 */
	public String getGzId() 
	{
		return this.gzId;
	}
	public void setCreateWorkDate(java.util.Date createWorkDate) 
	{
		this.createWorkDate = createWorkDate;
	}
	/**
	 * 返回 参加工作日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreateWorkDate() 
	{
		return this.createWorkDate;
	}
	public void setRetiredArea(String retiredArea) 
	{
		this.retiredArea = retiredArea;
	}
	/**
	 * 返回 退休人员所属区域
	 * @return
	 */
	public String getRetiredArea() 
	{
		return this.retiredArea;
	}
	public void setRetiredYjId(String retiredYjId) 
	{
		this.retiredYjId = retiredYjId;
	}
	/**
	 * 返回 退休（退职）依据
	 * @return
	 */
	public String getRetiredYjId() 
	{
		return this.retiredYjId;
	}
	public void setRetiredTypeId(String retiredTypeId) 
	{
		this.retiredTypeId = retiredTypeId;
	}
	/**
	 * 返回 退休类别
	 * @return
	 */
	public String getRetiredTypeId() 
	{
		return this.retiredTypeId;
	}
	public void setRetiredSite(String retiredSite) 
	{
		this.retiredSite = retiredSite;
	}
	/**
	 * 返回 退休后安置点
	 * @return
	 */
	public String getRetiredSite() 
	{
		return this.retiredSite;
	}
	public Long getRetiredStatus() {
		return retiredStatus;
	}
	public void setRetiredStatus(Long retiredStatus) {
		this.retiredStatus = retiredStatus;
	}
	public void setNationalId(String nationalId) 
	{
		this.nationalId = nationalId;
	}
	/**
	 * 返回 民族(56)
	 * @return
	 */
	public String getNationalId() 
	{
		return this.nationalId;
	}
	public void setDeclareType(String declareType) 
	{
		this.declareType = declareType;
	}
	/**
	 * 返回 申报分类
	 * @return
	 */
	public String getDeclareType() 
	{
		return this.declareType;
	}
	public void setGsCreateDate(java.util.Date gsCreateDate) 
	{
		this.gsCreateDate = gsCreateDate;
	}
	/**
	 * 返回 公示开始时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getGsCreateDate() 
	{
		return this.gsCreateDate;
	}
	public void setGsStopDate(java.util.Date gsStopDate) 
	{
		this.gsStopDate = gsStopDate;
	}
	/**
	 * 返回 公示结束时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getGsStopDate() 
	{
		return this.gsStopDate;
	}
	public void setRetiredPeopleNo(String retiredPeopleNo) 
	{
		this.retiredPeopleNo = retiredPeopleNo;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public String getRetiredPeopleNo() 
	{
		return this.retiredPeopleNo;
	}
	public void setRetiredDeclareStatus(String retiredDeclareStatus) 
	{
		this.retiredDeclareStatus = retiredDeclareStatus;
	}
	/**
	 * 返回 退休申报状态
	 * @return
	 */
	public String getRetiredDeclareStatus() 
	{
		return this.retiredDeclareStatus;
	}
	public void setRetiredPeopleBm(String retiredPeopleBm) 
	{
		this.retiredPeopleBm = retiredPeopleBm;
	}
	/**
	 * 返回 退休个人编码
	 * @return
	 */
	public String getRetiredPeopleBm() 
	{
		return this.retiredPeopleBm;
	}
	public void setDeclareNote(String declareNote) 
	{
		this.declareNote = declareNote;
	}
	/**
	 * 返回 申报备注
	 * @return
	 */
	public String getDeclareNote() 
	{
		return this.declareNote;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人
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
	 * 返回 经办机构
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
	}
	public void setCreaterDate(java.util.Date createrDate) 
	{
		this.createrDate = createrDate;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setCreaterOrgId(Long createrOrgId) 
	{
		this.createrOrgId = createrOrgId;
	}
	/**
	 * 返回 经办机构Id
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
	 * 返回 经办机构名称
	 * @return
	 */
	public String getCreaterOrgName() 
	{
		return this.createrOrgName;
	}
	public void setWorkExperienceId(Long workExperienceId) 
	{
		this.workExperienceId = workExperienceId;
	}
	/**
	 * 返回 工作经历维护ID   外键
	 * @return
	 */
	public Long getWorkExperienceId() 
	{
		return this.workExperienceId;
	}
	public void setWorkKjId(Long workKjId) 
	{
		this.workKjId = workKjId;
	}
	/**
	 * 返回 工作扣减情况id  外键
	 * @return
	 */
	public Long getWorkKjId() 
	{
		return this.workKjId;
	}
	public void setPeopleId(Long peopleId) 
	{
		this.peopleId = peopleId;
	}
	/**
	 * 返回 个人基本信息id 外键
	 * @return
	 */
	public Long getPeopleId() 
	{
		return this.peopleId;
	}
	public void setArchiveId(Long archiveId) 
	{
		this.archiveId = archiveId;
	}
	/**
	 * 返回 档案基本信息ID 外键
	 * @return
	 */
	public Long getArchiveId() 
	{
		return this.archiveId;
	}
	
	public String getCraft() {
		return craft;
	}
	public void setCraft(String craft) {
		this.craft = craft;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof RetiredDeclare)) 
		{
			return false;
		}
		RetiredDeclare rhs = (RetiredDeclare) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.unitName, rhs.unitName)
		.append(this.unitNo, rhs.unitNo)
		.append(this.zltzh, rhs.zltzh)
		.append(this.xh, rhs.xh)
		.append(this.gzId, rhs.gzId)
		.append(this.createWorkDate, rhs.createWorkDate)
		.append(this.retiredArea, rhs.retiredArea)
		.append(this.retiredYjId, rhs.retiredYjId)
		.append(this.retiredTypeId, rhs.retiredTypeId)
		.append(this.retiredSite, rhs.retiredSite)
		.append(this.nationalId, rhs.nationalId)
		.append(this.declareType, rhs.declareType)
		.append(this.gsCreateDate, rhs.gsCreateDate)
		.append(this.gsStopDate, rhs.gsStopDate)
		.append(this.retiredPeopleNo, rhs.retiredPeopleNo)
		.append(this.retiredDeclareStatus, rhs.retiredDeclareStatus)
		.append(this.retiredPeopleBm, rhs.retiredPeopleBm)
		.append(this.declareNote, rhs.declareNote)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.workExperienceId, rhs.workExperienceId)
		.append(this.workKjId, rhs.workKjId)
		.append(this.peopleId, rhs.peopleId)
		.append(this.archiveId, rhs.archiveId)
		.append(this.retiredStatus, rhs.retiredStatus)
		.append(this.craft, rhs.craft)
		
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.unitName) 
		.append(this.unitNo) 
		.append(this.zltzh) 
		.append(this.xh) 
		.append(this.gzId) 
		.append(this.createWorkDate) 
		.append(this.retiredArea) 
		.append(this.retiredYjId) 
		.append(this.retiredTypeId) 
		.append(this.retiredSite) 
		.append(this.nationalId) 
		.append(this.declareType) 
		.append(this.gsCreateDate) 
		.append(this.gsStopDate) 
		.append(this.retiredPeopleNo) 
		.append(this.retiredDeclareStatus) 
		.append(this.retiredPeopleBm) 
		.append(this.declareNote) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.workExperienceId) 
		.append(this.workKjId) 
		.append(this.peopleId) 
		.append(this.archiveId) 
		.append(this.retiredStatus)
		.append(this.craft)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("unitName", this.unitName) 
		.append("unitNo", this.unitNo) 
		.append("zltzh", this.zltzh) 
		.append("xh", this.xh) 
		.append("gzId", this.gzId) 
		.append("createWorkDate", this.createWorkDate) 
		.append("retiredArea", this.retiredArea) 
		.append("retiredYjId", this.retiredYjId) 
		.append("retiredTypeId", this.retiredTypeId) 
		.append("retiredSite", this.retiredSite) 
		.append("nationalId", this.nationalId) 
		.append("declareType", this.declareType) 
		.append("gsCreateDate", this.gsCreateDate) 
		.append("gsStopDate", this.gsStopDate) 
		.append("retiredPeopleNo", this.retiredPeopleNo) 
		.append("retiredDeclareStatus", this.retiredDeclareStatus) 
		.append("retiredPeopleBm", this.retiredPeopleBm) 
		.append("declareNote", this.declareNote) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("workExperienceId", this.workExperienceId) 
		.append("workKjId", this.workKjId) 
		.append("peopleId", this.peopleId) 
		.append("archiveId", this.archiveId) 
		.append("retiredStatus",this.retiredStatus)
		.append("craft",this.craft)
		.toString();
	}
   
  

}