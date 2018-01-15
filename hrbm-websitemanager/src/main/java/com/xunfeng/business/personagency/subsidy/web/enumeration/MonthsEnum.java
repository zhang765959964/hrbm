
package com.xunfeng.business.personagency.subsidy.web.enumeration;

import com.xunfeng.core.enumeration.BaseEnum;

/**
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年7月2日-上午11:27:12 
* @version V1.0   
*/
public enum MonthsEnum implements BaseEnum {
	 month_7("7月","7"),month_8("8月","8"),month_9("9月","9"),month_10("10月","10")
	,month_11("11月","11"),month_12("12月","12"),month_1("1月","1"),month_2("2月","2")
	,month_3("3月","3"),month_4("4月","4"),month_5("5月","5"),month_6("6月","6");
	private  String monthName ;
	private  String monthCode ;
	private MonthsEnum(String monthName, String monthCode) {
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
