package com.xunfeng.business.person.dto;
/**
 * 对象功能:个人基本信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 */
public class PersonContactDto
{
	private String personName;

	private String contactName;

	private Long aac001;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Long getAac001() {
		return aac001;
	}

	public void setAac001(Long aac001) {
		this.aac001 = aac001;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
}