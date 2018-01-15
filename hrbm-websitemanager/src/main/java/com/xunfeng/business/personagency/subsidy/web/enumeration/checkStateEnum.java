
package com.xunfeng.business.personagency.subsidy.web.enumeration;

import com.xunfeng.core.enumeration.BaseEnum;

/**
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年7月2日-上午11:27:12 
* @version V1.0   
*/
public enum checkStateEnum implements BaseEnum {

	passed("通过","1"),noPassed("未通过","2"),noReview("未审核","0");
	private  String monthName ;
	private  String monthCode ;
	private checkStateEnum(String monthName, String monthCode) {
		this.monthName = monthName;
		this.monthCode = monthCode;
	}
	@Override
	public String getCode() {
		return monthCode;
	}

	@Override
	public String getName() {
		return monthName;
	}

	enum Level{


	}
}
