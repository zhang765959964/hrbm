package com.xunfeng.business.ovemp.corp.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 培训报名表 Model对象
 * @author:Wang.CS
 * @createDate 2016-05-23 09:31:31
 * @version V1.0
 */
public class OvempCorpSignUp extends BaseModel {
	// 报名编号
	protected Long pxSignUpId;
	// 培训机构编号
	protected Long pxOrgId;
	// 开班编号
	protected Long pxCourseId;
	// 个人编号
	protected Long aac001;
	// 经办人代码
	protected String aae011;
	// 经办机构代码
	protected String aae017;
	// 经办日期
	protected java.util.Date aae036;
	// 经办人
	protected String aae019;
	// 经办机构
	protected String aae020;
	// 报名信息状态,见tab_sign_up_status表
	protected String signUpStatus;
	// 备注
	protected String remarks;
	// 数据来源0未知1网站2窗口
	protected String cczy06;

	// 机构类别名称
	protected String pxOrgTypeName;
	// 机构名称
	protected String pxOrgName;
	// 开班类别名称
	protected String courseTypeName;
	// 开班名称
	protected String courseName;
	// 个人姓名
	protected String userName;
	// 身份证号
	protected String userCard;
	// 个人性别
	protected String userSex;
	// 个人民族
	protected String userNation;
	// 个人联系电话
	protected String phone;
	//是否查看标识
	protected String isCheck;
	//是否联系标识
	protected String isContact;

	public void setPxSignUpId(Long pxSignUpId) {
		this.pxSignUpId = pxSignUpId;
	}

	/**
	 * 返回 报名编号
	 * 
	 * @return
	 */
	public Long getPxSignUpId() {
		return this.pxSignUpId;
	}

	public void setPxOrgId(Long pxOrgId) {
		this.pxOrgId = pxOrgId;
	}

	/**
	 * 返回 培训机构编号
	 * 
	 * @return
	 */
	public Long getPxOrgId() {
		return this.pxOrgId;
	}

	public void setPxCourseId(Long pxCourseId) {
		this.pxCourseId = pxCourseId;
	}

	/**
	 * 返回 开班编号
	 * 
	 * @return
	 */
	public Long getPxCourseId() {
		return this.pxCourseId;
	}

	public void setAac001(Long aac001) {
		this.aac001 = aac001;
	}

	/**
	 * 返回 个人编号
	 * 
	 * @return
	 */
	public Long getAac001() {
		return this.aac001;
	}

	public void setAae011(String aae011) {
		this.aae011 = aae011;
	}

	/**
	 * 返回 经办人代码
	 * 
	 * @return
	 */
	public String getAae011() {
		return this.aae011;
	}

	public void setAae017(String aae017) {
		this.aae017 = aae017;
	}

	/**
	 * 返回 经办机构代码
	 * 
	 * @return
	 */
	public String getAae017() {
		return this.aae017;
	}

	public void setAae036(java.util.Date aae036) {
		this.aae036 = aae036;
	}

	/**
	 * 返回 经办日期
	 * 
	 * @return
	 */
	public java.util.Date getAae036() {
		return this.aae036;
	}

	public void setAae019(String aae019) {
		this.aae019 = aae019;
	}

	/**
	 * 返回 经办人
	 * 
	 * @return
	 */
	public String getAae019() {
		return this.aae019;
	}

	public void setAae020(String aae020) {
		this.aae020 = aae020;
	}

	/**
	 * 返回 经办机构
	 * 
	 * @return
	 */
	public String getAae020() {
		return this.aae020;
	}

	public void setSignUpStatus(String signUpStatus) {
		this.signUpStatus = signUpStatus;
	}

	/**
	 * 返回 报名信息状态,见tab_sign_up_status表
	 * 
	 * @return
	 */
	public String getSignUpStatus() {
		return this.signUpStatus;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 返回 备注
	 * 
	 * @return
	 */
	public String getRemarks() {
		return this.remarks;
	}

	public void setCczy06(String cczy06) {
		this.cczy06 = cczy06;
	}

	/**
	 * 返回 数据来源0未知1网站2窗口
	 * 
	 * @return
	 */
	public String getCczy06() {
		return this.cczy06;
	}

	public String getPxOrgTypeName() {
		return pxOrgTypeName;
	}

	public void setPxOrgTypeName(String pxOrgTypeName) {
		this.pxOrgTypeName = pxOrgTypeName;
	}

	public String getPxOrgName() {
		return pxOrgName;
	}

	public void setPxOrgName(String pxOrgName) {
		this.pxOrgName = pxOrgName;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getIsContact() {
		return isContact;
	}

	public void setIsContact(String isContact) {
		this.isContact = isContact;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof OvempCorpSignUp)) {
			return false;
		}
		OvempCorpSignUp rhs = (OvempCorpSignUp) object;
		return new EqualsBuilder().append(this.pxSignUpId, rhs.pxSignUpId)
				.append(this.pxOrgId, rhs.pxOrgId)
				.append(this.pxCourseId, rhs.pxCourseId)
				.append(this.aac001, rhs.aac001)
				.append(this.aae011, rhs.aae011)
				.append(this.aae017, rhs.aae017)
				.append(this.aae036, rhs.aae036)
				.append(this.aae019, rhs.aae019)
				.append(this.aae020, rhs.aae020)
				.append(this.signUpStatus, rhs.signUpStatus)
				.append(this.remarks, rhs.remarks)
				.append(this.cczy06, rhs.cczy06).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.pxSignUpId).append(this.pxOrgId)
				.append(this.pxCourseId).append(this.aac001)
				.append(this.aae011).append(this.aae017).append(this.aae036)
				.append(this.aae019).append(this.aae020)
				.append(this.signUpStatus).append(this.remarks)
				.append(this.cczy06).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("pxSignUpId", this.pxSignUpId)
				.append("pxOrgId", this.pxOrgId)
				.append("pxCourseId", this.pxCourseId)
				.append("aac001", this.aac001).append("aae011", this.aae011)
				.append("aae017", this.aae017).append("aae036", this.aae036)
				.append("aae019", this.aae019).append("aae020", this.aae020)
				.append("signUpStatus", this.signUpStatus)
				.append("remarks", this.remarks).append("cczy06", this.cczy06)
				.toString();
	}

}