package com.xunfeng.core.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: cxf的描述
* @author wanghan 
* @createDate 2015年4月23日-下午2:34:06 
* @version V1.0   
*/
@Target(ElementType.METHOD)   
@Retention(RetentionPolicy.RUNTIME)   
@Documented  
@Inherited 
public @interface CxfFuncDesc {
	/**
	 * 调用方法名称
	 * @return
	 */
	public String callName() default "";
	/**
	 * 调用描述
	 * @return
	 */
	public String callDesc() default "";
}
