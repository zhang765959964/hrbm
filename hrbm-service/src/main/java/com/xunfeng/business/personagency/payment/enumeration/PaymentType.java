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
public enum PaymentType implements BaseEnum, Serializable {
	
	个人缴费("0", "个人缴费"), 单位缴费("1", "单位缴费");
	
	private String code;
	private String name;

	PaymentType(String code, String name) {
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
