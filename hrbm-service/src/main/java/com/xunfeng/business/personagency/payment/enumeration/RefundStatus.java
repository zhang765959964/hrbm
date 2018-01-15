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
public enum RefundStatus implements BaseEnum, Serializable {
	
	已登记("0", "已登记"), 已确认退费("1", "已确认退费");
	
	private String code;
	private String name;

	RefundStatus(String code, String name) {
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
