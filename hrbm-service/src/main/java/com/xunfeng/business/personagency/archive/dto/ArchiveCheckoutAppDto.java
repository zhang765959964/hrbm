package com.xunfeng.business.personagency.archive.dto;
//import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 借阅记录表appDTO
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
//public class ArchiveCheckoutAppDto extends ArchiveCheckout
public class ArchiveCheckoutAppDto
{
	//借阅表id
	protected Long  id;
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
	//借阅登记经办人
	protected String  checkoutRegisterName;
	//批次名
	protected String  batchName;
	//返还登记经办人姓名
	protected String  checkinName;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCheckoutRegisterName() {
		return checkoutRegisterName;
	}
	public void setCheckoutRegisterName(String checkoutRegisterName) {
		this.checkoutRegisterName = checkoutRegisterName;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getCheckinName() {
		return checkinName;
	}
	public void setCheckinName(String checkinName) {
		this.checkinName = checkinName;
	}
	
	
}