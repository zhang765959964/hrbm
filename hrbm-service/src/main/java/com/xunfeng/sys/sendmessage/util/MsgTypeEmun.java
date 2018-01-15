package com.xunfeng.sys.sendmessage.util;

public enum MsgTypeEmun {
	
	trainReg("培训机构会员登记", 39l);
    // 成员变量
    private String name;
    private Long code;

    // 构造方法
    private MsgTypeEmun(String name, Long code) {
        this.name = name;
        this.code = code;
    }

    // 普通方法
    public static String getName(Long code) {
        for (MsgTypeEmun c : MsgTypeEmun.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
