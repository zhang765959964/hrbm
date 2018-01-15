package com.xunfeng.business.personagency.social.web.form;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class ArchivesPersonMapForm 
{
	// 主键
	protected Long  archivesId;
	// 个人编号
	protected Long  personId;
	// 档案编号
	protected String  archiveCode;
	// 公民身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 民族
	protected String  aac005;
	/*// 出生日期
	protected java.util.Date  aac006;*/
	// 个人编号
	protected String  expPersonNumber;
	// 参加工作时间
	protected java.util.Date  expStartJobDate;
	// 参加养老保险时间
	protected java.util.Date  expPensionDate;
	// 参加医疗保险时间
	protected java.util.Date  expMedicalDate;
	// 联系电话
	protected String  aae005;
	// 联系电话(ac01中AAE005存手机号)
	protected String  expPersonPhone;
	// 居住所在地
	protected String  aab301;
	// 邮编
	protected String  aae007;
	
	public Long getArchivesId() {
		return archivesId;
	}
	public void setArchivesId(Long archivesId) {
		this.archivesId = archivesId;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
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
	public String getAac004() {
		return aac004;
	}
	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}
	public String getAac005() {
		return aac005;
	}
	public void setAac005(String aac005) {
		this.aac005 = aac005;
	}
	public String getExpPersonNumber() {
		return expPersonNumber;
	}
	public void setExpPersonNumber(String expPersonNumber) {
		this.expPersonNumber = expPersonNumber;
	}
	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	public String getExpPersonPhone() {
		return expPersonPhone;
	}
	public void setExpPersonPhone(String expPersonPhone) {
		this.expPersonPhone = expPersonPhone;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	public String getAae007() {
		return aae007;
	}
	public void setAae007(String aae007) {
		this.aae007 = aae007;
	}
	public java.util.Date getExpStartJobDate() {
		return expStartJobDate;
	}
	public void setExpStartJobDate(java.util.Date expStartJobDate) {
		this.expStartJobDate = expStartJobDate;
	}
	public java.util.Date getExpPensionDate() {
		return expPensionDate;
	}
	public void setExpPensionDate(java.util.Date expPensionDate) {
		this.expPensionDate = expPensionDate;
	}
	public java.util.Date getExpMedicalDate() {
		return expMedicalDate;
	}
	public void setExpMedicalDate(java.util.Date expMedicalDate) {
		this.expMedicalDate = expMedicalDate;
	}
	
		
}