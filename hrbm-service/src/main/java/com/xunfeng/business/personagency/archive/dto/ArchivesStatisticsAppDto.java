package com.xunfeng.business.personagency.archive.dto;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 借阅记录表appDTO
* @author:jiangxin
* @createDate 2016-11-28 09:36:03 
* @version V1.0   
*/
public class ArchivesStatisticsAppDto
{
	// 档案Id
	protected Long  id;
	//位置
	protected String  position;
	//档案编号
	protected String  archiveCode;
	//姓名
	protected String  aac003;
	//身份证号
	protected String  aac002;
	//经办人
	protected String  createrName;
	//性别
	protected String  genderName;
	//分类id
	protected Long type;
	//分类名称
	protected String typeName;
	// 经办人id
	protected Long createrId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Long getCreaterId() {
		return createrId;
	}
	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}
	
	
}