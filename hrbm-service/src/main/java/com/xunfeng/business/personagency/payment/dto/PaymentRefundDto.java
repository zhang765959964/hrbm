package com.xunfeng.business.personagency.payment.dto;
import com.xunfeng.business.personagency.payment.model.PaymentRefund;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_REFUND Model对象
* @author:wanghan
* @createDate 2016-08-17 16:06:42 
* @version V1.0   
*/
public class PaymentRefundDto extends PaymentRefund
{
	protected String  archiveCode;
	protected String  aac002;
	protected String  aac003;
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
	public String getAac003() {
		return aac003;
	}
	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
  

}