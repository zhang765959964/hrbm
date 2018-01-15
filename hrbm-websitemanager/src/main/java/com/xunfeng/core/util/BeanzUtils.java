package com.xunfeng.core.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import com.xunfeng.business.dissupport.divice.web.form.DiviConfigForm;
import com.xunfeng.business.dissupport.divice.web.form.QueryField;

public class BeanzUtils {

	public static final Map<String, Object> toMap(Object bean)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	/**
	 * 获得QueryField 检索项
	 * 
	 * @param object
	 *            实体类
	 * @param type
	 * @return 返回数据
	 */
	public static final String getBaseQuery(Object object, String type) {
		StringBuilder builder = new StringBuilder();
		builder.append("ACB208N='0' ");
		Method[] methods = DiviConfigForm.class.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getAnnotation(QueryField.class) != null) {
				QueryField p = method.getAnnotation(QueryField.class);
				try {
					if (type.equals(p.type())) {
						Object obj = method.invoke(object, null);
						if (obj != null
								&& StringUtil.isNotEmpty(obj.toString())) {
							Class<?> cls = obj.getClass();
							builder.append(" AND ").append(p.column())
									.append(p.operation());
							if (cls.equals(Long.class)) {
								builder.append(obj);
							} else {
								builder.append("'");
								if (cls.equals(java.util.Date.class)) {
									builder.append(new SimpleDateFormat(
											"yyyy-MM-dd").format(obj));
								} else {
									builder.append(obj);
								}
								builder.append("'");
							}
							// 日期格式转换成yyyy-MM-dd
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return builder.toString();
	}
}
