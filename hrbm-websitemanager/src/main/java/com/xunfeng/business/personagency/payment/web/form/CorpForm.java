package com.xunfeng.business.personagency.payment.web.form;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND Form对象
* @author:wanghan
* @createDate 2016-08-17 16:06:42 
* @version V1.0   
*/
public class CorpForm 
{	
	 /**
	 * 单位名称
	 */
	private String aab004;
	
	 /**
	 * 工商登记执照号码
	 */
	private String aab007; 
	/**
	 * 联系人
	 */
	private String aae004;
	 /**
	 * 地址
	 */
	private String aae006;
	private String bab002;
	/**
	 * 联系电话
	 */
	private String aae005;
	
	private String uaNo;
	
	private Long  aab001;
	
	private Long uaStatus;
	
	private String uaStatusName;
	
	protected java.util.Date  uaCreatetime;
	
	// 经办人身份证号
	protected String uaCard;
	// 单位协议人
	protected String uaName;
	// 联系电话
	protected String uaPhone;
	
	
	
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

	public String getAae006() {
		return aae006;
	}
	public void setAae006(String aae006) {
		this.aae006 = aae006;
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
	public String getUaNo() {
		return uaNo;
	}
	public void setUaNo(String uaNo) {
		this.uaNo = uaNo;
	}
	public java.util.Date getUaCreatetime() {
		return uaCreatetime;
	}
	public void setUaCreatetime(java.util.Date uaCreatetime) {
		this.uaCreatetime = uaCreatetime;
	}
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public Long getUaStatus() {
		return uaStatus;
	}
	public void setUaStatus(Long uaStatus) {
		this.uaStatus = uaStatus;
	}
	public String getUaStatusName() {
		if(uaStatus==null){
			uaStatusName="";
		}else if(uaStatus==0) {
			uaStatusName="有效";
		}else{
			uaStatusName="无效";
		}
		return uaStatusName;
	}
	public void setUaStatusName(String uaStatusName) {
		this.uaStatusName = uaStatusName;
	}
	public String getUaCard() {
		return uaCard;
	}
	public void setUaCard(String uaCard) {
		this.uaCard = uaCard;
	}
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
	public String getBab002() {
		return bab002;
	}
	public void setBab002(String bab002) {
		this.bab002 = bab002;
	}	
	
}