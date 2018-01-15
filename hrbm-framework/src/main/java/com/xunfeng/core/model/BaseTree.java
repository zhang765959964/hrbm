package com.xunfeng.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: 实体类基类 easyui tree 基本数据信息
 */
public class BaseTree implements Serializable {

	public BaseTree() {

	}

	protected Long id;
	protected String text;
	protected String code;
	protected String state="closed";
	protected List  children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
