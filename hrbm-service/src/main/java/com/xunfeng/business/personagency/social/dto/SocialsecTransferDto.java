package com.xunfeng.business.personagency.social.dto;
import com.xunfeng.business.personagency.social.model.SocialsecTransfer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保统筹范围内转移表 Model对象
* @author:jiangxin
* @createDate 2016-08-12 15:39:19 
* @version V1.0   
*/
public class SocialsecTransferDto extends SocialsecTransfer
{
	// 性别
	protected String  genderName;
	// 民族
	protected String  nationName;
	// 用工形式
	protected String  employmentFormName;
	// 变更内容
	protected String  changeContenttwoName;
	// 养老保险基数
	protected String  pensionBaseName;
	// 医疗保险基数
	protected String  medicalBaseName;
	// 是否有效标识
	protected String isEffectiveName;
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
	public String getChangeContenttwoName() {
		return changeContenttwoName;
	}
	public void setChangeContenttwoName(String changeContenttwoName) {
		this.changeContenttwoName = changeContenttwoName;
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
	public String getIsEffectiveName() {
		return isEffectiveName;
	}
	public void setIsEffectiveName(String isEffectiveName) {
		this.isEffectiveName = isEffectiveName;
	}
   
  

}