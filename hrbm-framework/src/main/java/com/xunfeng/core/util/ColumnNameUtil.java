package com.xunfeng.core.util;

import java.lang.reflect.Field;

import com.xunfeng.core.annotion.ColumnName;

public class ColumnNameUtil {
	
	public static String getColumnNameThroughAnnotaion(Class clazz,String fieldName ) throws Exception{
		Field field = clazz.getDeclaredField(fieldName);
		if(null!=field&&field.isAnnotationPresent(ColumnName.class)){
			return field.getAnnotation(ColumnName.class).value();
		}
		return null;
	}
}
