/**
 * 
 */
package com.xunfeng.sys.identity.enumeration;

import java.io.Serializable;

import com.xunfeng.core.enumeration.BaseEnum;

/**
 * @author Administrator
 *
 */
public enum SeqType implements BaseEnum, Serializable {
	
	集体代理存档("1", "集体代理存档"), 正规档案代理("2", "正规档案代理"),自由人档案代理("3", "自由人档案代理"),学生档案代理("4", "学生档案代理")
	, 技校生("5", "技校生"),退伍("6", "退伍"),单位转入("7", "单位转入"),死亡("8", "死亡"),其他("9", "其他")
	,正常退休("10","正常退休"),特殊工种("11","特殊工种"),超龄退休("12","超龄退休"),病退("13","病退"),社保补贴("14","社保补贴");
	
	private String code;
	private String name;

	SeqType(String code, String name) {
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

	public SeqType setCode(String code) {
		this.code = code;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

}
