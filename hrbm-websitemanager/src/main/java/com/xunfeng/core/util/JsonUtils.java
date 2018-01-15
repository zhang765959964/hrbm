package com.xunfeng.core.util;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JsonUtils {

	public static final ObjectMapper om = new ObjectMapper();

	public static Object readValue(String content, Class valueType) {
		try {
			return om.readValue(content, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toJSon(Object object) {
		try {
			return om.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	 public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
         return om.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	 }   
	
	
}
