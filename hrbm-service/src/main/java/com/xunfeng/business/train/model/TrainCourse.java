package com.xunfeng.business.train.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班信息表 Model对象
* @author:Wang.CS
* @createDate 2016-05-22 09:25:59 
* @version V1.0   
*/
public class TrainCourse extends BaseModel
{
	// 开班编号
	protected Long  pxCourseId;
	// 培训机构编号
	protected Long  pxOrgId;
	//所属机构名称
	protected String pxOrgName;
	// 点击次数
	protected Long  clickTimes;
	// 开班名称
	protected String  courseName;
	// 开班类型
	protected String  courseType;
	// 开班时间
	protected String  courseStartTime;
	// 学习周期
	protected String  coursePeriod;
	// 培训地点
	protected String  courseAddr;
	// 培训特色
	protected String  courseFeature;
	// 培训内容
	protected String  courseContent;
	// 联系人
	protected String  contactsName;
	// 联系电话
	protected String  contactsTel;
	// 是否审核通过,0未审核，1审核通过，2审核未通过
	protected String  isAudit;
	// 冻结标记，1是 0否
	protected String  acb208;
	// 是否删除，1是 0否
	protected String  isDel;
	// 是否禁用，1是 0否
	protected String  isDisable;
	// 费用
	protected Float  cost;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	// 审核时间
	protected java.util.Date  abb771;
	// 审核人代码
	protected String  abb767;
	// 审核机构代码
	protected String  abb768;
	// 审核人
	protected String  abb769;
	// 审核机构
	protected String  abb770;
	// 审核意见
	protected String  abb772;
	// 名称拼音码
	protected String  aac022;
	//开班logo
	protected String courseLogo;
	
	public void setPxCourseId(Long pxCourseId) 
	{
		this.pxCourseId = pxCourseId;
	}
	/**
	 * 返回 开班编号
	 * @return
	 */
	public Long getPxCourseId() 
	{
		return this.pxCourseId;
	}
	public void setPxOrgId(Long pxOrgId) 
	{
		this.pxOrgId = pxOrgId;
	}
	/**
	 * 返回 培训机构编号
	 * @return
	 */
	public Long getPxOrgId() 
	{
		return this.pxOrgId;
	}
	public void setClickTimes(Long clickTimes) 
	{
		this.clickTimes = clickTimes;
	}
	
	/**
	 * 返回 所属机构名称
	 * @return
	 */
	public String getPxOrgName() {
		return pxOrgName;
	}
	public void setPxOrgName(String pxOrgName) {
		this.pxOrgName = pxOrgName;
	}
	/**
	 * 返回 点击次数
	 * @return
	 */
	public Long getClickTimes() 
	{
		return this.clickTimes;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}
	/**
	 * 返回 开班名称
	 * @return
	 */
	public String getCourseName() 
	{
		return this.courseName;
	}
	public void setCourseType(String courseType) 
	{
		this.courseType = courseType;
	}
	/**
	 * 返回 开班类型
	 * @return
	 */
	public String getCourseType() 
	{
		return this.courseType;
	}
	public void setCourseStartTime(String courseStartTime) 
	{
		this.courseStartTime = courseStartTime;
	}
	/**
	 * 返回 开班时间
	 * @return
	 */
	public String getCourseStartTime() 
	{
		return this.courseStartTime;
	}
	public void setCoursePeriod(String coursePeriod) 
	{
		this.coursePeriod = coursePeriod;
	}
	/**
	 * 返回 学习周期
	 * @return
	 */
	public String getCoursePeriod() 
	{
		return this.coursePeriod;
	}
	public void setCourseAddr(String courseAddr) 
	{
		this.courseAddr = courseAddr;
	}
	/**
	 * 返回 培训地点
	 * @return
	 */
	public String getCourseAddr() 
	{
		return this.courseAddr;
	}
	public void setCourseFeature(String courseFeature) 
	{
		this.courseFeature = courseFeature;
	}
	/**
	 * 返回 培训特色
	 * @return
	 */
	public String getCourseFeature() 
	{
		return this.courseFeature;
	}
	public void setCourseContent(String courseContent) 
	{
		this.courseContent = courseContent;
	}
	/**
	 * 返回 培训内容
	 * @return
	 */
	public String getCourseContent() 
	{
		return this.courseContent;
	}
	public void setContactsName(String contactsName) 
	{
		this.contactsName = contactsName;
	}
	/**
	 * 返回 联系人
	 * @return
	 */
	public String getContactsName() 
	{
		return this.contactsName;
	}
	public void setContactsTel(String contactsTel) 
	{
		this.contactsTel = contactsTel;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getContactsTel() 
	{
		return this.contactsTel;
	}
	public void setIsAudit(String isAudit) 
	{
		this.isAudit = isAudit;
	}
	/**
	 * 返回 是否审核通过,0未审核，1审核通过，2审核未通过
	 * @return
	 */
	public String getIsAudit() 
	{
		return this.isAudit;
	}
	public void setAcb208(String acb208) 
	{
		this.acb208 = acb208;
	}
	/**
	 * 返回 冻结标记，1是 0否
	 * @return
	 */
	public String getAcb208() 
	{
		return this.acb208;
	}
	public void setIsDel(String isDel) 
	{
		this.isDel = isDel;
	}
	/**
	 * 返回 是否删除，1是 0否
	 * @return
	 */
	public String getIsDel() 
	{
		return this.isDel;
	}
	public void setIsDisable(String isDisable) 
	{
		this.isDisable = isDisable;
	}
	/**
	 * 返回 是否禁用，1是 0否
	 * @return
	 */
	public String getIsDisable() 
	{
		return this.isDisable;
	}
	public void setCost(Float cost) 
	{
		this.cost = cost;
	}
	/**
	 * 返回 费用
	 * @return
	 */
	public Float getCost() 
	{
		return this.cost;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setAbb771(java.util.Date abb771) 
	{
		this.abb771 = abb771;
	}
	/**
	 * 返回 审核时间
	 * @return
	 */
	public java.util.Date getAbb771() 
	{
		return this.abb771;
	}
	public void setAbb767(String abb767) 
	{
		this.abb767 = abb767;
	}
	/**
	 * 返回 审核人代码
	 * @return
	 */
	public String getAbb767() 
	{
		return this.abb767;
	}
	public void setAbb768(String abb768) 
	{
		this.abb768 = abb768;
	}
	/**
	 * 返回 审核机构代码
	 * @return
	 */
	public String getAbb768() 
	{
		return this.abb768;
	}
	public void setAbb769(String abb769) 
	{
		this.abb769 = abb769;
	}
	/**
	 * 返回 审核人
	 * @return
	 */
	public String getAbb769() 
	{
		return this.abb769;
	}
	public void setAbb770(String abb770) 
	{
		this.abb770 = abb770;
	}
	/**
	 * 返回 审核机构
	 * @return
	 */
	public String getAbb770() 
	{
		return this.abb770;
	}
	public void setAbb772(String abb772) 
	{
		this.abb772 = abb772;
	}
	/**
	 * 返回 审核意见
	 * @return
	 */
	public String getAbb772() 
	{
		return this.abb772;
	}
	public void setAac022(String aac022) 
	{
		this.aac022 = aac022;
	}
	/**
	 * 返回 名称拼音码
	 * @return
	 */
	public String getAac022() 
	{
		return this.aac022;
	}
		
   	public String getCourseLogo() {
		return courseLogo;
	}
	public void setCourseLogo(String courseLogo) {
		this.courseLogo = courseLogo;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof TrainCourse)) 
		{
			return false;
		}
		TrainCourse rhs = (TrainCourse) object;
		return new EqualsBuilder()
		.append(this.pxCourseId, rhs.pxCourseId)
		.append(this.pxOrgId, rhs.pxOrgId)
		.append(this.clickTimes, rhs.clickTimes)
		.append(this.courseName, rhs.courseName)
		.append(this.courseType, rhs.courseType)
		.append(this.courseStartTime, rhs.courseStartTime)
		.append(this.coursePeriod, rhs.coursePeriod)
		.append(this.courseAddr, rhs.courseAddr)
		.append(this.courseFeature, rhs.courseFeature)
		.append(this.courseContent, rhs.courseContent)
		.append(this.contactsName, rhs.contactsName)
		.append(this.contactsTel, rhs.contactsTel)
		.append(this.isAudit, rhs.isAudit)
		.append(this.acb208, rhs.acb208)
		.append(this.isDel, rhs.isDel)
		.append(this.isDisable, rhs.isDisable)
		.append(this.cost, rhs.cost)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.cczy06, rhs.cczy06)
		.append(this.abb771, rhs.abb771)
		.append(this.abb767, rhs.abb767)
		.append(this.abb768, rhs.abb768)
		.append(this.abb769, rhs.abb769)
		.append(this.abb770, rhs.abb770)
		.append(this.abb772, rhs.abb772)
		.append(this.aac022, rhs.aac022)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pxCourseId) 
		.append(this.pxOrgId) 
		.append(this.clickTimes) 
		.append(this.courseName) 
		.append(this.courseType) 
		.append(this.courseStartTime) 
		.append(this.coursePeriod) 
		.append(this.courseAddr) 
		.append(this.courseFeature) 
		.append(this.courseContent) 
		.append(this.contactsName) 
		.append(this.contactsTel) 
		.append(this.isAudit) 
		.append(this.acb208) 
		.append(this.isDel) 
		.append(this.isDisable) 
		.append(this.cost) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.cczy06) 
		.append(this.abb771) 
		.append(this.abb767) 
		.append(this.abb768) 
		.append(this.abb769) 
		.append(this.abb770) 
		.append(this.abb772) 
		.append(this.aac022) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pxCourseId", this.pxCourseId) 
		.append("pxOrgId", this.pxOrgId) 
		.append("clickTimes", this.clickTimes) 
		.append("courseName", this.courseName) 
		.append("courseType", this.courseType) 
		.append("courseStartTime", this.courseStartTime) 
		.append("coursePeriod", this.coursePeriod) 
		.append("courseAddr", this.courseAddr) 
		.append("courseFeature", this.courseFeature) 
		.append("courseContent", this.courseContent) 
		.append("contactsName", this.contactsName) 
		.append("contactsTel", this.contactsTel) 
		.append("isAudit", this.isAudit) 
		.append("acb208", this.acb208) 
		.append("isDel", this.isDel) 
		.append("isDisable", this.isDisable) 
		.append("cost", this.cost) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("cczy06", this.cczy06) 
		.append("abb771", this.abb771) 
		.append("abb767", this.abb767) 
		.append("abb768", this.abb768) 
		.append("abb769", this.abb769) 
		.append("abb770", this.abb770) 
		.append("abb772", this.abb772) 
		.append("aac022", this.aac022) 
		.toString();
	}
   
  

}