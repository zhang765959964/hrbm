package com.xunfeng.core.util;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: Map操作工具类 
* @author wanghan 
* @createDate 2015年4月23日-上午11:28:24 
* @version V1.0   
*/
public class MapUtil {
	/**
	 * 根据字段取得map中的字段字符串值,如果值为空，则返回 ""空串
	 * 
	 * @param map
	 * @param field
	 * @return
	 */
	public static String getString(Map<?, ?> map, String field) {
		field = field.toLowerCase();
		Set<?> set = map.keySet();
		Iterator<?> it = set.iterator();
		Hashtable<String, String> ht = new Hashtable<String, String>();
		while (it.hasNext()) {
			String key = (String) it.next();
			ht.put(key.toLowerCase(), key);
		}
		field = ht.get(field);
		Object obj = map.get(field);
		return (obj != null) ? obj.toString().trim() : "";
	}

	/**
	 * 取得map中字段的长整型值。取不到值返回-1.
	 * 
	 * @param map
	 * @param field
	 * @return
	 */
	public static long getLong(Map<?, ?> map, String field) {
		String value = (String) getString(map, field);
		if (value.equals(""))
			return -1;
		return Long.parseLong(value);
	}

	/**
	 * 取得map中字段的整型值。取不到值返回-1.
	 * 
	 * @param map
	 * @param field
	 * @return
	 */
	public static int getInt(Map<?, ?> map, String field) {
		String value = (String) getString(map, field);
		if (value.equals(""))
			return -1;
		return Integer.parseInt(value);
	}

	/**
	 * 取得map中字段的浮点数值。取不到值返回-1.
	 * 
	 * @param map
	 * @param field
	 * @return
	 */
	public static float getFloat(Map<?, ?> map, String field) {
		String value = (String) getString(map, field);
		if (value.equals(""))
			return -1;
		return Float.parseFloat(value);
	}

	/**
	 * 取得map中字段的double数值。取不到值返回-1.
	 * 
	 * @param map
	 * @param field
	 * @return
	 */
	public static double getDouble(Map<?, ?> map, String field) {
		String value = (String) getString(map, field);
		if (value.equals(""))
			return -1;
		return Double.parseDouble(value);
	}

}
