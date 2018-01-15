package com.xunfeng.core.util;

import org.apache.commons.lang.ArrayUtils;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 数组操作类 
* @author wanghan 
* @createDate 2015年4月23日-上午11:53:21 
* @version V1.0   
*/
public class ArrayUtil {

	/**
	 * 字符串数组转换为Long数组
	 * @param aryStr  字符串数组
	 * @return Long数组
	 */
	public static Long[] convertArray(String[] aryStr) {
		if(ArrayUtils.isEmpty(aryStr))
			return ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
		Long[] aryLong = new Long[aryStr.length];
		for (int i = 0; i < aryStr.length; i++) {
			aryLong[i] = Long.parseLong(aryStr[i]);
		}
		return aryLong;
	}
	
	
	/**
	 * Long数组转换为字符串数组
	 * @param aryLong Long数组
	 * @return 字符串数组
	 */
	public static String[] convertArray(Long[] aryLong) {
		if(ArrayUtils.isEmpty(aryLong))
			return ArrayUtils.EMPTY_STRING_ARRAY;
		String[] aryStr = new String[aryLong.length];
		for (int i = 0; i < aryStr.length; i++) {
			aryStr[i] = String.valueOf(aryStr[i]);
		}
		return aryStr;
	}
}
