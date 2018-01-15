package com.xunfeng.business.personagency.receive.web.form;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class CorpUnitAgreementForm 
{
	// 单位名称
	protected String  aab004;
	// 工商登记执照号码
	protected String  aab007;
	// 单位协议编号
	protected String  uaNo;
	// 协议签订日期
	protected String  uaCreatetime;
	// 联系人
	protected String  aae004;
	// 联系电话
	protected String  aae005;
	// 单位协议人
	protected String  uaName;
	// 联系电话
	protected String  uaPhone;
	// 经办人身份证号
	protected String  uaCard;
	// 经办人身份证号
	protected String  aab019Name;
	// 协议主要内容
	protected String  uaContent;
	//协议状态 0.签订协议 1.终止协议
	protected Long uaStatus;
	
	
	
	
	public String getUaName() {
		return uaName;
	}
	public void setUaName(String uaName) {
		this.uaName = uaName;
	}
	public String getUaPhone() {
		return uaPhone;
	}
	public void setUaPhone(String uaPhone) {
		this.uaPhone = uaPhone;
	}
	public Long getUaStatus() {
		return uaStatus;
	}
	public void setUaStatus(Long uaStatus) {
		this.uaStatus = uaStatus;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getAab007() {
		return aab007;
	}
	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}
	public String getUaNo() {
		return uaNo;
	}
	public void setUaNo(String uaNo) {
		this.uaNo = uaNo;
	}
	public String getUaCreatetime() {
		return uaCreatetime;
	}
	public void setUaCreatetime(String uaCreatetime) {
		this.uaCreatetime = uaCreatetime;
	}
	public String getAae004() {
		return aae004;
	}
	public void setAae004(String aae004) {
		this.aae004 = aae004;
	}
	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	public String getUaCard() {
		return uaCard;
	}
	public void setUaCard(String uaCard) {
		this.uaCard = uaCard;
	}
	public String getAab019Name() {
		return aab019Name;
	}
	public void setAab019Name(String aab019Name) {
		this.aab019Name = aab019Name;
	}
	public String getUaContent() {
		return uaContent;
	}
	public void setUaContent(String uaContent) {
		this.uaContent = uaContent;
	}
	
}