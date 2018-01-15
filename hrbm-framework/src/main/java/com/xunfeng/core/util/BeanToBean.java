package com.xunfeng.core.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
 
public class BeanToBean {
	
 
	
	
	public static <T>  T copyProperties(Object source,T target,boolean nullCopy){

		 if(source==null||target==null){
			 return target;
		 }
			 
 		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(target.getClass());
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null ) {
				PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						
				 
//						if(!IdEntity.class.isAssignableFrom(readMethod.getReturnType())){
//							if(value==null&&!nullCopy){
//	 							continue ;
//								 
//							}
//						}
//	 
//						
//						
						
						Method writeMethod = targetPd.getWriteMethod();
						if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
							writeMethod.setAccessible(true);
						}
						
						Class getParamType = readMethod.getReturnType();
						Class setParamType = writeMethod.getParameterTypes()[0];
						if(setParamType.isAssignableFrom(getParamType)){
							writeMethod.invoke(target, value);
							continue ;
						}
						if((value instanceof Collection)) {
						 
							Collection targetValue	= (Collection) targetPd.getReadMethod().invoke(target);
							if(targetValue!=null){
								targetValue.addAll((Collection) value);
							}
				 
						}  
						 
						
					}
					catch (Throwable ex) {
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
		
 
		 
 		 return target ;
	
	}
	
	public static <T>  T copyProperties(Object source,T target) throws BeansException{
		return  copyProperties(source,target,false);
	}
	 
	
	
	
	
	public static Object getProperty(Object bean,String name){
		try {
			return PropertyUtils.getProperty(bean, name);
		} catch (Exception e) {
		   throw new RuntimeException(e);
		}
	}
	 
	 public static void main(String[] arg){
		 
		 Map map=new HashMap();
		 map.put("aaa", "aaab");
		 map.put("bbb", "bbb");
		 
		 String aaa=(String) getProperty(map, "aaa");
		 String dsds="";
		 
		 
	 }
	
 	
	
}
