package com.xunfeng.business.person.dto;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;

/**
 * 对象功能:个人基本信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 */
public class PersonBaseAddDto extends PersonBaseInfo
{
	private PersonExpand personExpand;
	private PersonFamily personFamily;
	public PersonExpand getPersonExpand() {
		return personExpand;
	}
	public void setPersonExpand(PersonExpand personExpand) {
		this.personExpand = personExpand;
	}
	public PersonFamily getPersonFamily() {
		return personFamily;
	}
	public void setPersonFamily(PersonFamily personFamily) {
		this.personFamily = personFamily;
	}
	
}