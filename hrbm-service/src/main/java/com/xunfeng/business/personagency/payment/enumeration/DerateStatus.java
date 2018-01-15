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
public enum DerateStatus implements BaseEnum, Serializable {
	
	正常缴费("0", "正常缴费"), 减免("1", "减免");
	
	private String code;
	private String name;

	DerateStatus(String code, String name) {
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
