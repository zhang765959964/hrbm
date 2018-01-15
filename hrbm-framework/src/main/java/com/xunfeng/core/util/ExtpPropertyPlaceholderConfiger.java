package com.xunfeng.core.util;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.ObjectUtils;

import com.xunfeng.core.encrypt.EncryptUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:加密属性密码
* @author wanghan 
* @createDate 2015年4月23日-上午11:38:07 
* @version V1.0   
*/
public class ExtpPropertyPlaceholderConfiger extends PropertyPlaceholderConfigurer {
	
	private String[] encryptNames={"jdbc.password"};
	
	@Override
	protected void convertProperties(Properties props) {
		Enumeration propertyNames = props.propertyNames();
		while (propertyNames.hasMoreElements()) {
			String propertyName = (String) propertyNames.nextElement();
			String propertyValue = props.getProperty(propertyName);
			
			
			String convertedValue = convertPropertyValue(propertyValue);
			if(isEncryptProp(propertyName)){
				try {
					convertedValue=EncryptUtil.decrypt(convertedValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (!ObjectUtils.nullSafeEquals(propertyValue, convertedValue)) {
				
				props.setProperty(propertyName, convertedValue);
			}
		}
	}
	
	

	private boolean isEncryptProp(String propertyName){
		for(String name :encryptNames){
			if(name.equals(propertyName)){
				return true;
			}
		}
		return false;
	}
}
