/**
 * 
 */
package com.xunfeng.business.personagency.payment.enumeration;

import java.io.Serializable;

import com.xunfeng.core.enumeration.BaseEnum;

/**
 * @author Administrator
 *
 */
public enum PaymentStatus implements BaseEnum, Serializable {
	
	未缴("0", "未缴"), 已缴("1", "已缴");
	
	private String code;
	private String name;

	PaymentStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String getCode() {
		
		return code;
	}

	@Override
	public String getName() {
		
		return name;
	}

}
