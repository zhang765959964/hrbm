package com.xunfeng.core.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;

public class MapBeanCopyUtil {

	public static Map<String, Object> beanToMapList(Object source, boolean nullCopy) {

		//List<Map<String, String>> formDataList = new ArrayList<Map<String, String>>();
		Map<String, Object> formDataMap = new HashMap<String, Object>();
		PropertyDescriptor[] sourcePds = BeanUtils.getPropertyDescriptors(source.getClass());
		for (PropertyDescriptor sourcePd : sourcePds) {
			if (sourcePd != null && sourcePd.getReadMethod() != null) {
				try {

					Method readMethod = sourcePd.getReadMethod();
					if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
						readMethod.setAccessible(true);
					}

					Object value = readMethod.invoke(source);
					if (value == null && !nullCopy) {
						continue;
					}
					formDataMap.put(sourcePd.getName(), value);
				} catch (Exception ex) {
					throw new FatalBeanException("Could not copy properties from source to target", ex);
				}
			}

		}

		return formDataMap;

	}

	public static <T> T MapToBean(Map<String, String> map, T target) {

		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(target.getClass());
		for (PropertyDescriptor targetPd : targetPds) {

			if (targetPd.getWriteMethod() != null) {
				try {

					String propertyName = targetPd.getName();

					String value = map.get(propertyName);

					Method writeMethod = targetPd.getWriteMethod();

					Class setParamType = writeMethod.getParameterTypes()[0];
					

					if (setParamType.isAssignableFrom(String.class) && value != null) {
						writeMethod.invoke(target, value);

					}else if(setParamType.isAssignableFrom(Date.class) && value != null){
						writeMethod.invoke(target, DateUtil.parseDate(value));
					}else if(setParamType.isAssignableFrom(Long.class) && value != null){
						writeMethod.invoke(target,Long.valueOf(value));
					}

				} catch (Throwable ex) {
					throw new FatalBeanException("Could not copy properties from source to target", ex);
				}
			}

		}
		return target;

	}
    public static void copyProperty(Object target,String propertyName,String value){
    	try{
    	PropertyDescriptor targetPd=BeanUtils.getPropertyDescriptor(target.getClass(), propertyName);
    	Method writeMethod=targetPd.getWriteMethod();
    	Class setParamType = writeMethod.getParameterTypes()[0];
    	if (setParamType.isAssignableFrom(String.class) && StringUtils.isNotBlank(value)) {
			writeMethod.invoke(target, value);

		}
//    	else if(setParamType.isAssignableFrom(Date.class) && value != null){
//			writeMethod.invoke(target, DateUtil.parseDate(value));
//		}
    	else if(setParamType.isAssignableFrom(Long.class) && StringUtils.isNotBlank(value)){
			float f=Float.valueOf(value);
			long l=(long)f;
    		writeMethod.invoke(target,Long.valueOf(l));
		}
    	}catch(Exception ex){
    		System.out.println(propertyName);
    		System.out.println(value);
    		ex.printStackTrace();
    	}
    }
	public static Map<String, Object> beanToMapList(Object source) throws BeansException {
		return beanToMapList(source, false);
	}

}
