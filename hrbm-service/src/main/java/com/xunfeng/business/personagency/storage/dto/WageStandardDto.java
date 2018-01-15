package com.xunfeng.business.personagency.storage.dto;
import com.xunfeng.business.personagency.storage.model.WageStandard;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工资标准表 Model对象
* @author:jiangxin
* @createDate 2016-08-17 11:06:20 
* @version V1.0   
*/
public class WageStandardDto extends WageStandard
{
	// 性别
	protected String  genderName;
	// 民族
	protected String  nationName;
	// 文化程度
	protected String aac011Name;
	// 档案编号
	protected String  archiveCode;
	// 公民身份证号码
	protected String  aac002;
	
	
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
	public String getAac011Name() {
		return aac011Name;
	}
	public void setAac011Name(String aac011Name) {
		this.aac011Name = aac011Name;
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
   
	

}