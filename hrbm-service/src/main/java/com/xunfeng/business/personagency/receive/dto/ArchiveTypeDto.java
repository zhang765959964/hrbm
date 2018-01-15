package com.xunfeng.business.personagency.receive.dto;

import java.io.Serializable;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class ArchiveTypeDto implements Serializable
{
	//id
	protected Long id;
	//编码
	protected Long  code;
	//名称
	protected String  name;
	//档案编号
	protected String  harchiveCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHarchiveCode() {
		return harchiveCode;
	}
	public void setHarchiveCode(String harchiveCode) {
		this.harchiveCode = harchiveCode;
	}
	
}