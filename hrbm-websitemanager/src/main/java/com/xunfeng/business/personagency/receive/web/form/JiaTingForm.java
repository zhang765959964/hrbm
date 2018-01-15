package com.xunfeng.business.personagency.receive.web.form;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class JiaTingForm 
{
	// 主键ID
	protected Long  id;
	// 婚姻状况
	protected String  faMarriage;
	// 结婚时间
	protected java.util.Date  faMarriageDate;
	// 配偶姓名
	protected String  faName;
	// 配偶身份证号
	protected String  faSpouseCard;
	// 配偶出生日期
	protected java.util.Date  faSpouseBirth;
	// 配偶民族
	protected String  faSpouseNational;
	// 配偶单位
	protected String  faSpouseCompany;
	// 配偶电话
	protected String  faSpousePhone;
	// 计生情况（TAB_CONDITION）
	protected String  faBirthCondition;
	// 节育措施（TAB_BIRTHCONTROL）
	protected String  faBirthControl;
	// 家庭情况备注
	protected String  faFamilyBark;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFaMarriage() {
		return faMarriage;
	}
	public void setFaMarriage(String faMarriage) {
		this.faMarriage = faMarriage;
	}
	public java.util.Date getFaMarriageDate() {
		return faMarriageDate;
	}
	public void setFaMarriageDate(java.util.Date faMarriageDate) {
		this.faMarriageDate = faMarriageDate;
	}
	public String getFaName() {
		return faName;
	}
	public void setFaName(String faName) {
		this.faName = faName;
	}
	public String getFaSpouseCard() {
		return faSpouseCard;
	}
	public void setFaSpouseCard(String faSpouseCard) {
		this.faSpouseCard = faSpouseCard;
	}
	public java.util.Date getFaSpouseBirth() {
		return faSpouseBirth;
	}
	public void setFaSpouseBirth(java.util.Date faSpouseBirth) {
		this.faSpouseBirth = faSpouseBirth;
	}
	public String getFaSpouseNational() {
		return faSpouseNational;
	}
	public void setFaSpouseNational(String faSpouseNational) {
		this.faSpouseNational = faSpouseNational;
	}
	public String getFaSpouseCompany() {
		return faSpouseCompany;
	}
	public void setFaSpouseCompany(String faSpouseCompany) {
		this.faSpouseCompany = faSpouseCompany;
	}
	public String getFaSpousePhone() {
		return faSpousePhone;
	}
	public void setFaSpousePhone(String faSpousePhone) {
		this.faSpousePhone = faSpousePhone;
	}
	public String getFaBirthCondition() {
		return faBirthCondition;
	}
	public void setFaBirthCondition(String faBirthCondition) {
		this.faBirthCondition = faBirthCondition;
	}
	public String getFaBirthControl() {
		return faBirthControl;
	}
	public void setFaBirthControl(String faBirthControl) {
		this.faBirthControl = faBirthControl;
	}
	public String getFaFamilyBark() {
		return faFamilyBark;
	}
	public void setFaFamilyBark(String faFamilyBark) {
		this.faFamilyBark = faFamilyBark;
	}
	
	
}