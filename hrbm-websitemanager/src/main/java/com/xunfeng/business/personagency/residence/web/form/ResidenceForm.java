package com.xunfeng.business.personagency.residence.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.residence.model.Residence;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口材料表 Form对象
* @author:jiangxin
* @createDate 2016-08-26 11:46:18 
* @version V1.0   
*/
public class ResidenceForm extends BaseForm<Residence>
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 申请日期
	protected java.util.Date  applicationDate;
	// 材料类别 （RSDA_TAB_MATERIAL_CATEGORY）
	protected String  materialCategory;
	// 提交材料名称
	protected String  materialName;
	// 联系方式
	protected String  aae005;
	// 是否退回（0-否，1-是）
	protected String  isBack;
	// 退回原因
	protected String  backReason;
	// 材料退回本人日期
	protected java.util.Date  applicationOneselfDate;
	// 是否通知（0-否，1-是）
	protected String  isNotice;
	// 通知日期
	protected java.util.Date  noticeDate;
	// 经办人id
	protected Long  createrId;
	// 经办人姓名
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 数据来源（16人事档案）
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
	public void setApplicationDate(java.util.Date applicationDate) 
	{
		this.applicationDate = applicationDate;
	}
	/**
	 * 返回 申请日期
	 * @return
	 */
	public java.util.Date getApplicationDate() 
	{
		return this.applicationDate;
	}
	public void setMaterialCategory(String materialCategory) 
	{
		this.materialCategory = materialCategory;
	}
	/**
	 * 返回 材料类别 （RSDA_TAB_MATERIAL_CATEGORY）
	 * @return
	 */
	public String getMaterialCategory() 
	{
		return this.materialCategory;
	}
	public void setMaterialName(String materialName) 
	{
		this.materialName = materialName;
	}
	/**
	 * 返回 提交材料名称
	 * @return
	 */
	public String getMaterialName() 
	{
		return this.materialName;
	}
	public void setAae005(String aae005) 
	{
		this.aae005 = aae005;
	}
	/**
	 * 返回 联系方式
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setIsBack(String isBack) 
	{
		this.isBack = isBack;
	}
	/**
	 * 返回 是否退回（0-否，1-是）
	 * @return
	 */
	public String getIsBack() 
	{
		return this.isBack;
	}
	public void setBackReason(String backReason) 
	{
		this.backReason = backReason;
	}
	/**
	 * 返回 退回原因
	 * @return
	 */
	public String getBackReason() 
	{
		return this.backReason;
	}
	public void setApplicationOneselfDate(java.util.Date applicationOneselfDate) 
	{
		this.applicationOneselfDate = applicationOneselfDate;
	}
	/**
	 * 返回 材料退回本人日期
	 * @return
	 */
	public java.util.Date getApplicationOneselfDate() 
	{
		return this.applicationOneselfDate;
	}
	public void setIsNotice(String isNotice) 
	{
		this.isNotice = isNotice;
	}
	/**
	 * 返回 是否通知（0-否，1-是）
	 * @return
	 */
	public String getIsNotice() 
	{
		return this.isNotice;
	}
	public void setNoticeDate(java.util.Date noticeDate) 
	{
		this.noticeDate = noticeDate;
	}
	/**
	 * 返回 通知日期
	 * @return
	 */
	public java.util.Date getNoticeDate() 
	{
		return this.noticeDate;
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
	 * 返回 经办人姓名
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
	 * 返回 经办机构名称
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
	 * 返回 数据来源（16人事档案）
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
		if (!(object instanceof ResidenceForm)) 
		{
			return false;
		}
		ResidenceForm rhs = (ResidenceForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.applicationDate, rhs.applicationDate)
		.append(this.materialCategory, rhs.materialCategory)
		.append(this.materialName, rhs.materialName)
		.append(this.aae005, rhs.aae005)
		.append(this.isBack, rhs.isBack)
		.append(this.backReason, rhs.backReason)
		.append(this.applicationOneselfDate, rhs.applicationOneselfDate)
		.append(this.isNotice, rhs.isNotice)
		.append(this.noticeDate, rhs.noticeDate)
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
		.append(this.applicationDate) 
		.append(this.materialCategory) 
		.append(this.materialName) 
		.append(this.aae005) 
		.append(this.isBack) 
		.append(this.backReason) 
		.append(this.applicationOneselfDate) 
		.append(this.isNotice) 
		.append(this.noticeDate) 
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
		.append("applicationDate", this.applicationDate) 
		.append("materialCategory", this.materialCategory) 
		.append("materialName", this.materialName) 
		.append("aae005", this.aae005) 
		.append("isBack", this.isBack) 
		.append("backReason", this.backReason) 
		.append("applicationOneselfDate", this.applicationOneselfDate) 
		.append("isNotice", this.isNotice) 
		.append("noticeDate", this.noticeDate) 
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