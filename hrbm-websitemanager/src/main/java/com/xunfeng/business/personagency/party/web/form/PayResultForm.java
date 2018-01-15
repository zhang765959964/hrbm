package com.xunfeng.business.personagency.party.web.form;

public class PayResultForm {
	
	private String payMoney;	//总价格
	
	private String sumCount;	//总条数

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getSumCount() {
		return sumCount;
	}

	public void setSumCount(String sumCount) {
		this.sumCount = sumCount;
	}

	@Override
	public String toString() {
		return "PayResultForm [payMoney=" + payMoney + ", sumCount=" + sumCount
				+ "]";
	}

	


		
	
	
}
