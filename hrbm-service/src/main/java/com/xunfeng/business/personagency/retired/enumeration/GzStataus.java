package com.xunfeng.business.personagency.retired.enumeration;

import java.io.Serializable;

import com.xunfeng.core.enumeration.BaseEnum;

public enum GzStataus implements BaseEnum,Serializable {
	

	
	工人("1", "工人"), 干部("2", "干部"),农民("3", "农民"),教师("4", "教师"),
	学生("5", "学生"), 无业("6", "无业"),知青("7", "知青"), 军人("8", "军人"),其它("9", "其它");
	private String code;
	private String name;

	GzStataus(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}



	public String getName() {
		return name;
	}

	  // 普通方法
    public static String getName(Long index) {
        for (GzStataus c : GzStataus.values()) {
            if (Long.parseLong(c.getCode()) == index) {
                return c.name;
            }
        }
        return null;
    }
	
    public static void main(String[] args) {
    	
	}
}
