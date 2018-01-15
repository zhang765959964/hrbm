package com.xunfeng.sys.uums.model;



/**
 * 注册表工具类
 * 开发人员:jiangxin
 * 创建时间:2015-06-17 11:57:00   
 */
public class Registered 
{
	// 用户信息表自动编号 
	protected Long  ccmu01;
	// 注册IP
	protected String  ccmu06;
	// 邮箱
	protected String  ccmu08;
	// 手机
	protected String  ccmu09;
	
	//身份证号
	protected String cardNumber;
	//姓名
	protected String cardName;
	
	public Long getCcmu01() {
		return ccmu01;
	}
	public void setCcmu01(Long ccmu01) {
		this.ccmu01 = ccmu01;
	}
	public String getCcmu06() {
		return ccmu06;
	}
	public void setCcmu06(String ccmu06) {
		this.ccmu06 = ccmu06;
	}
	public String getCcmu08() {
		return ccmu08;
	}
	public void setCcmu08(String ccmu08) {
		this.ccmu08 = ccmu08;
	}
	public String getCcmu09() {
		return ccmu09;
	}
	public void setCcmu09(String ccmu09) {
		this.ccmu09 = ccmu09;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	
	

}