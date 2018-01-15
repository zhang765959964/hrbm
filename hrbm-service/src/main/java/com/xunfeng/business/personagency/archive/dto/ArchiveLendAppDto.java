package com.xunfeng.business.personagency.archive.dto;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 借阅记录表appDTO
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
public class ArchiveLendAppDto
{
	//档案表id
	protected Long  lendId;
	// 档案Id
	protected Long  archiveId;
	//位置
	protected String  position;
	//档案编号
	protected String  archiveCode;
	//姓名
	protected String  aac003;
	//身份证号
	protected String  aac002;
	//调出登记经办人姓名
	protected String  lendCreaterName;
	//性别
	protected String  genderName;
	
	
	public Long getLendId() {
		return lendId;
	}
	public void setLendId(Long lendId) {
		this.lendId = lendId;
	}
	public Long getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Long archiveId) {
		this.archiveId = archiveId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getArchiveCode() {
		return archiveCode;
	}
	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}
	public String getAac003() {
		return aac003;
	}
	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
	public String getAac002() {
		return aac002;
	}
	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}
	public String getLendCreaterName() {
		return lendCreaterName;
	}
	public void setLendCreaterName(String lendCreaterName) {
		this.lendCreaterName = lendCreaterName;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	
	
}