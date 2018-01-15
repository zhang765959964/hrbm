package com.xunfeng.business.personagency.retired.enumeration;

import java.io.Serializable;

import com.xunfeng.core.enumeration.BaseEnum;

/**
 * 退休类别枚举类
 * @date 2017年1月3日15:34:50
 * @author zf
 *
 */
public enum RetiredType implements BaseEnum, Serializable {
	
	工人正常退休("1", "工人正常退休"), 特殊工种退休("2", "特殊工种退休"),病退("3", "病退"),退职("4", "退职"),
	干部退休("5", "干部退休"), 军转干部退休("6", "军转干部退休"),超龄退休("7", "超龄退休"),其它("8", "其它");
	
	
	private String code;
	private String name;
	
	RetiredType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	
	  // 根据code 获得name
    public static String getName(String index) {
        for (RetiredType c : RetiredType.values()) {
            if (c.getCode() == index) {
                return c.name;
            }
        }
        return null;
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
