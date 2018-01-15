
package com.xunfeng.business.person.enumeration;

import com.xunfeng.core.enumeration.BaseEnum;

/**
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年7月2日-上午11:27:12 
* @version V1.0   
*/
public enum LanguageEnum implements BaseEnum {
	English("英语","EN"),Japan("日语","JP"),Mandarin("普通话","MANDARIN"),CANTONESE("粤语","CANTONESE");
	private  String languageName ;
	private  String languageCode ;
	private LanguageEnum(String languageName, String languageCode) {
		this.languageName = languageName;
		this.languageCode = languageCode;
	}
	@Override
	public String getCode() {
		return languageCode;
	}

	@Override
	public String getName() {
		return languageName;
	}

	enum Level{


	}
}
