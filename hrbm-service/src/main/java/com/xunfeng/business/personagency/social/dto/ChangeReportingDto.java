package com.xunfeng.business.personagency.social.dto;
import com.xunfeng.business.personagency.social.model.ChangeReporting;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保变更申报记录表 Model对象
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
public class ChangeReportingDto extends ChangeReporting
{
	
	// 性别
	protected String  genderName;
	// 民族
	protected String  nationName;
	// 用工形式
	protected String  employmentFormName;
	// 变更内容
	protected String  changeContentName;
	// 停保原因
	protected String  reasonsForStoppingName;
	// 是否在外地参加保险
	protected String  addIsInsuranceName;
	// 养老保险基数
	protected String  pensionBaseName;
	// 医疗保险基数
	protected String  medicalBaseName;
	// 是否有效标识
	protected String isEffectiveName;
	
	
	public String getIsEffectiveName() {
		return isEffectiveName;
	}
	public void setIsEffectiveName(String isEffectiveName) {
		this.isEffectiveName = isEffectiveName;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getEmploymentFormName() {
		return employmentFormName;
	}
	public void setEmploymentFormName(String employmentFormName) {
		this.employmentFormName = employmentFormName;
	}
	public String getChangeContentName() {
		return changeContentName;
	}
	public void setChangeContentName(String changeContentName) {
		this.changeContentName = changeContentName;
	}
	public String getReasonsForStoppingName() {
		return reasonsForStoppingName;
	}
	public void setReasonsForStoppingName(String reasonsForStoppingName) {
		this.reasonsForStoppingName = reasonsForStoppingName;
	}
	public String getAddIsInsuranceName() {
		return addIsInsuranceName;
	}
	public void setAddIsInsuranceName(String addIsInsuranceName) {
		this.addIsInsuranceName = addIsInsuranceName;
	}
	public String getPensionBaseName() {
		return pensionBaseName;
	}
	public void setPensionBaseName(String pensionBaseName) {
		this.pensionBaseName = pensionBaseName;
	}
	public String getMedicalBaseName() {
		return medicalBaseName;
	}
	public void setMedicalBaseName(String medicalBaseName) {
		this.medicalBaseName = medicalBaseName;
	}
	
	
	
}