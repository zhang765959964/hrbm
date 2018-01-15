package com.xunfeng.core.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 错误信息处理类
* @author wanghan 
* @createDate 2015年4月23日-上午11:40:11 
* @version V1.0   
*/
public class ExceptionUtil {

	/**
	 * 获取exception的详细错误信息。
	 * 
	 * @param e
	 * @return
	 */
	public static String getExceptionMessage(Exception e) {

		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		String str = sw.toString();

		return str;
	}
}
