package com.xunfeng.business.personagency.payment.dto;

import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 缴费记录 Model对象
 * @author:wanghan
 * @createDate 2016-08-16 16:43:34
 * @version V1.0
 */
public class PaymentCorpRecordDto extends PaymentCorpRecord {

	protected String aab004;
	protected String aae004;
	protected String aae005;
	protected String aab007;
	
	protected String uaNo;

	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
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

	public String getAab007() {
		return aab007;
	}

	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}

}