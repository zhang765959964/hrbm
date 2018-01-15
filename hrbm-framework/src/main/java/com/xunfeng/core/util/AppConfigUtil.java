package com.xunfeng.core.util;

import java.util.Properties;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 配置文件属性读取操作工具类
* @author wanghan 
* @createDate 2015年4月23日-上午11:56:17 
* @version V1.0   
*/
public class AppConfigUtil {
	
	
	public static String get(String propertyKey){
		
		Properties properties=(Properties)AppUtil.getBean("configproperties");
		return properties.getProperty(propertyKey);
		
	}
	/**
	 * 从配置文件中读取配置属性
	 * @param propertyKey 属性key
	 * @param defultValue 如果为空，填充默认值。
	 * @return
	 */
	public static String get(String propertyKey,String defultValue){
		
		Properties properties=(Properties)AppUtil.getBean("configproperties");
		String propertie = properties.getProperty(propertyKey);
		
		if(StringUtil.isEmpty(propertie)) return defultValue;
		return propertie;
	}
	
	
}
