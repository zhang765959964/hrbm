package com.xunfeng.core.web.query.script.impl;

import com.xunfeng.core.web.query.script.ISingleScript;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 单值工厂 
* @author wanghan 
* @createDate 2015年4月23日-上午10:45:22 
* @version V1.0   
*/
public class SingleScriptFactory {
	public final static int OPT_TYPE_NUMBER = 1; // 数值
	public final static int OPT_TYPE_STRING = 2; // 字符串
	public final static int OPT_TYPE_DATE = 3; // 日期
	public final static int OPT_TYPE_DIC = 4; // 字典
	public final static int OPT_TYPE_SELECTOR = 5; // 选择器

	public static ISingleScript getQueryScript(Integer optType) {
		switch (optType) {
		case OPT_TYPE_NUMBER:
		case OPT_TYPE_DATE:
			return new NumberScript();
		case OPT_TYPE_STRING:
		case OPT_TYPE_DIC:
			return new StringScript();
		case OPT_TYPE_SELECTOR:
			return new InScript();
		default:
			return new NumberScript();
		}

	}
}
