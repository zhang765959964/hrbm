package com.xunfeng.business.personagency.storage.dto;
import com.xunfeng.business.personagency.storage.model.SpecialArchives;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 特殊类档案dto
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
public class SpecialArchivesDto extends SpecialArchives
{
	
	// 性别
	protected String  genderName;
	// 特殊档案类别（rsda_tab_special_type）
	protected String specialTypeName;
	// 特殊档案情况（状态）（0-入档，1-已转出）
	protected String specialStatusName;
	
	
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	
	public String getSpecialTypeName() {
		return specialTypeName;
	}
	public void setSpecialTypeName(String specialTypeName) {
		this.specialTypeName = specialTypeName;
	}
	public String getSpecialStatusName() {
		return specialStatusName;
	}
	public void setSpecialStatusName(String specialStatusName) {
		this.specialStatusName = specialStatusName;
	}
	
	
	
}