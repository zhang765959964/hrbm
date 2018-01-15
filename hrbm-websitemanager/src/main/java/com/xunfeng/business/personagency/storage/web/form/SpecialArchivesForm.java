package com.xunfeng.business.personagency.storage.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.storage.model.SpecialArchives;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 特殊档案表 Form对象
* @author:jiangxin
* @createDate 2016-08-15 14:27:06 
* @version V1.0   
*/
public class SpecialArchivesForm extends BaseForm<SpecialArchives>
{
	// 主键
	protected Long  id;
	// 姓名
	protected String  aac003;
	// 身份证号
	protected String  aac002;
	// 性别
	protected String  aac004;
	// 学校名称
	protected String  schoolName;
	// 班级
	protected String  schoolClass;
	// 专业
	protected String  major;
	// 单位名称
	protected String  corpName;
	// 特殊档案编号
	protected String  specialNumber;
	// 特殊档案类别（rsda_tab_special_type）
	protected String  specialType;
	// 特殊档案情况（状态）（0-入档，1-已转出）
	protected String  specialStatus;
	// 退伍编号
	protected String  veteransNumber;
	// 备注
	protected String  description;
	// 录入经办人id
	protected Long  lrCreaterId;
	// 录入经办人姓名
	protected String  lrCreaterName;
	// 录入经办机构id
	protected Long  lrCreaterOrgId;
	// 录入经办机构名称
	protected String  lrCreaterOrgName;
	// 录入经办日期
	protected java.util.Date  lrCreaterDate;
	// 转出办理人
	protected String  zcName;
	// 转出办理人电话
	protected String  zcPhone;
	// 转出去向
	protected String  zcWhere;
	// 转出原因
	protected String  zcReason;
	// 转出经办人id
	protected Long  zcCreaterId;
	// 转出经办人姓名
	protected String  zcCreaterName;
	// 转出经办机构id
	protected Long  zcCreaterOrgId;
	// 转出经办机构名称
	protected String  zcCreaterOrgName;
	// 转出经办日期
	protected java.util.Date  zcCreaterDate;
	// 数据来源（0-单个录入，1-导入）
	protected String  cczy06;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 打印条形码次数
	protected Long  printNumber;
	// 转出备注
	protected String  zcDescription;
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
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setAac002(String aac002) 
	{
		this.aac002 = aac002;
	}
	/**
	 * 返回 身份证号
	 * @return
	 */
	public String getAac002() 
	{
		return this.aac002;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setSchoolName(String schoolName) 
	{
		this.schoolName = schoolName;
	}
	/**
	 * 返回 学校名称
	 * @return
	 */
	public String getSchoolName() 
	{
		return this.schoolName;
	}
	public void setSchoolClass(String schoolClass) 
	{
		this.schoolClass = schoolClass;
	}
	/**
	 * 返回 班级
	 * @return
	 */
	public String getSchoolClass() 
	{
		return this.schoolClass;
	}
	public void setMajor(String major) 
	{
		this.major = major;
	}
	/**
	 * 返回 专业
	 * @return
	 */
	public String getMajor() 
	{
		return this.major;
	}
	public void setCorpName(String corpName) 
	{
		this.corpName = corpName;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getCorpName() 
	{
		return this.corpName;
	}
	public void setSpecialNumber(String specialNumber) 
	{
		this.specialNumber = specialNumber;
	}
	/**
	 * 返回 特殊档案编号
	 * @return
	 */
	public String getSpecialNumber() 
	{
		return this.specialNumber;
	}
	public void setSpecialType(String specialType) 
	{
		this.specialType = specialType;
	}
	/**
	 * 返回 特殊档案类别（rsda_tab_special_type）
	 * @return
	 */
	public String getSpecialType() 
	{
		return this.specialType;
	}
	public void setSpecialStatus(String specialStatus) 
	{
		this.specialStatus = specialStatus;
	}
	/**
	 * 返回 特殊档案情况（状态）（0-入档，1-已转出）
	 * @return
	 */
	public String getSpecialStatus() 
	{
		return this.specialStatus;
	}
	public void setVeteransNumber(String veteransNumber) 
	{
		this.veteransNumber = veteransNumber;
	}
	/**
	 * 返回 退伍编号
	 * @return
	 */
	public String getVeteransNumber() 
	{
		return this.veteransNumber;
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
	public void setLrCreaterId(Long lrCreaterId) 
	{
		this.lrCreaterId = lrCreaterId;
	}
	/**
	 * 返回 录入经办人id
	 * @return
	 */
	public Long getLrCreaterId() 
	{
		return this.lrCreaterId;
	}
	public void setLrCreaterName(String lrCreaterName) 
	{
		this.lrCreaterName = lrCreaterName;
	}
	/**
	 * 返回 录入经办人姓名
	 * @return
	 */
	public String getLrCreaterName() 
	{
		return this.lrCreaterName;
	}
	public void setLrCreaterOrgId(Long lrCreaterOrgId) 
	{
		this.lrCreaterOrgId = lrCreaterOrgId;
	}
	/**
	 * 返回 录入经办机构id
	 * @return
	 */
	public Long getLrCreaterOrgId() 
	{
		return this.lrCreaterOrgId;
	}
	public void setLrCreaterOrgName(String lrCreaterOrgName) 
	{
		this.lrCreaterOrgName = lrCreaterOrgName;
	}
	/**
	 * 返回 录入经办机构名称
	 * @return
	 */
	public String getLrCreaterOrgName() 
	{
		return this.lrCreaterOrgName;
	}
	public void setLrCreaterDate(java.util.Date lrCreaterDate) 
	{
		this.lrCreaterDate = lrCreaterDate;
	}
	/**
	 * 返回 录入经办日期
	 * @return
	 */
	public java.util.Date getLrCreaterDate() 
	{
		return this.lrCreaterDate;
	}
	public void setZcName(String zcName) 
	{
		this.zcName = zcName;
	}
	/**
	 * 返回 转出办理人
	 * @return
	 */
	public String getZcName() 
	{
		return this.zcName;
	}
	public void setZcPhone(String zcPhone) 
	{
		this.zcPhone = zcPhone;
	}
	/**
	 * 返回 转出办理人电话
	 * @return
	 */
	public String getZcPhone() 
	{
		return this.zcPhone;
	}
	public void setZcWhere(String zcWhere) 
	{
		this.zcWhere = zcWhere;
	}
	/**
	 * 返回 转出去向
	 * @return
	 */
	public String getZcWhere() 
	{
		return this.zcWhere;
	}
	public void setZcReason(String zcReason) 
	{
		this.zcReason = zcReason;
	}
	/**
	 * 返回 转出原因
	 * @return
	 */
	public String getZcReason() 
	{
		return this.zcReason;
	}
	public void setZcCreaterId(Long zcCreaterId) 
	{
		this.zcCreaterId = zcCreaterId;
	}
	/**
	 * 返回 转出经办人id
	 * @return
	 */
	public Long getZcCreaterId() 
	{
		return this.zcCreaterId;
	}
	public void setZcCreaterName(String zcCreaterName) 
	{
		this.zcCreaterName = zcCreaterName;
	}
	/**
	 * 返回 转出经办人姓名
	 * @return
	 */
	public String getZcCreaterName() 
	{
		return this.zcCreaterName;
	}
	public void setZcCreaterOrgId(Long zcCreaterOrgId) 
	{
		this.zcCreaterOrgId = zcCreaterOrgId;
	}
	/**
	 * 返回 转出经办机构id
	 * @return
	 */
	public Long getZcCreaterOrgId() 
	{
		return this.zcCreaterOrgId;
	}
	public void setZcCreaterOrgName(String zcCreaterOrgName) 
	{
		this.zcCreaterOrgName = zcCreaterOrgName;
	}
	/**
	 * 返回 转出经办机构名称
	 * @return
	 */
	public String getZcCreaterOrgName() 
	{
		return this.zcCreaterOrgName;
	}
	public void setZcCreaterDate(java.util.Date zcCreaterDate) 
	{
		this.zcCreaterDate = zcCreaterDate;
	}
	/**
	 * 返回 转出经办日期
	 * @return
	 */
	public java.util.Date getZcCreaterDate() 
	{
		return this.zcCreaterDate;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源（0-单个录入，1-导入）
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
	public void setPrintNumber(Long printNumber) 
	{
		this.printNumber = printNumber;
	}
	/**
	 * 返回 打印条形码次数
	 * @return
	 */
	public Long getPrintNumber() 
	{
		return this.printNumber;
	}
	public void setZcDescription(String zcDescription) 
	{
		this.zcDescription = zcDescription;
	}
	/**
	 * 返回 转出备注
	 * @return
	 */
	public String getZcDescription() 
	{
		return this.zcDescription;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SpecialArchivesForm)) 
		{
			return false;
		}
		SpecialArchivesForm rhs = (SpecialArchivesForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.aac003, rhs.aac003)
		.append(this.aac002, rhs.aac002)
		.append(this.aac004, rhs.aac004)
		.append(this.schoolName, rhs.schoolName)
		.append(this.schoolClass, rhs.schoolClass)
		.append(this.major, rhs.major)
		.append(this.corpName, rhs.corpName)
		.append(this.specialNumber, rhs.specialNumber)
		.append(this.specialType, rhs.specialType)
		.append(this.specialStatus, rhs.specialStatus)
		.append(this.veteransNumber, rhs.veteransNumber)
		.append(this.description, rhs.description)
		.append(this.lrCreaterId, rhs.lrCreaterId)
		.append(this.lrCreaterName, rhs.lrCreaterName)
		.append(this.lrCreaterOrgId, rhs.lrCreaterOrgId)
		.append(this.lrCreaterOrgName, rhs.lrCreaterOrgName)
		.append(this.lrCreaterDate, rhs.lrCreaterDate)
		.append(this.zcName, rhs.zcName)
		.append(this.zcPhone, rhs.zcPhone)
		.append(this.zcWhere, rhs.zcWhere)
		.append(this.zcReason, rhs.zcReason)
		.append(this.zcCreaterId, rhs.zcCreaterId)
		.append(this.zcCreaterName, rhs.zcCreaterName)
		.append(this.zcCreaterOrgId, rhs.zcCreaterOrgId)
		.append(this.zcCreaterOrgName, rhs.zcCreaterOrgName)
		.append(this.zcCreaterDate, rhs.zcCreaterDate)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.printNumber, rhs.printNumber)
		.append(this.zcDescription, rhs.zcDescription)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.aac003) 
		.append(this.aac002) 
		.append(this.aac004) 
		.append(this.schoolName) 
		.append(this.schoolClass) 
		.append(this.major) 
		.append(this.corpName) 
		.append(this.specialNumber) 
		.append(this.specialType) 
		.append(this.specialStatus) 
		.append(this.veteransNumber) 
		.append(this.description) 
		.append(this.lrCreaterId) 
		.append(this.lrCreaterName) 
		.append(this.lrCreaterOrgId) 
		.append(this.lrCreaterOrgName) 
		.append(this.lrCreaterDate) 
		.append(this.zcName) 
		.append(this.zcPhone) 
		.append(this.zcWhere) 
		.append(this.zcReason) 
		.append(this.zcCreaterId) 
		.append(this.zcCreaterName) 
		.append(this.zcCreaterOrgId) 
		.append(this.zcCreaterOrgName) 
		.append(this.zcCreaterDate) 
		.append(this.cczy06) 
		.append(this.ccpr08) 
		.append(this.printNumber) 
		.append(this.zcDescription) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("aac003", this.aac003) 
		.append("aac002", this.aac002) 
		.append("aac004", this.aac004) 
		.append("schoolName", this.schoolName) 
		.append("schoolClass", this.schoolClass) 
		.append("major", this.major) 
		.append("corpName", this.corpName) 
		.append("specialNumber", this.specialNumber) 
		.append("specialType", this.specialType) 
		.append("specialStatus", this.specialStatus) 
		.append("veteransNumber", this.veteransNumber) 
		.append("description", this.description) 
		.append("lrCreaterId", this.lrCreaterId) 
		.append("lrCreaterName", this.lrCreaterName) 
		.append("lrCreaterOrgId", this.lrCreaterOrgId) 
		.append("lrCreaterOrgName", this.lrCreaterOrgName) 
		.append("lrCreaterDate", this.lrCreaterDate) 
		.append("zcName", this.zcName) 
		.append("zcPhone", this.zcPhone) 
		.append("zcWhere", this.zcWhere) 
		.append("zcReason", this.zcReason) 
		.append("zcCreaterId", this.zcCreaterId) 
		.append("zcCreaterName", this.zcCreaterName) 
		.append("zcCreaterOrgId", this.zcCreaterOrgId) 
		.append("zcCreaterOrgName", this.zcCreaterOrgName) 
		.append("zcCreaterDate", this.zcCreaterDate) 
		.append("cczy06", this.cczy06) 
		.append("ccpr08", this.ccpr08) 
		.append("printNumber", this.printNumber) 
		.append("zcDescription", this.zcDescription) 
		.toString();
	}
   
  

}