package com.xunfeng.business.person.dto;
import com.xunfeng.business.person.model.PersonBaseInfo;

/**
 * 对象功能:个人基本信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 */
public class PersonBaseInfoDto extends PersonBaseInfo
{
	private String marriageStatus;
	private String ccmu15;

	public String getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getCcmu15() {
		return ccmu15;
	}

	public void setCcmu15(String ccmu15) {
		this.ccmu15 = ccmu15;
	}
	
	
}