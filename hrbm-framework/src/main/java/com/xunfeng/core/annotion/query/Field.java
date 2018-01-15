package com.xunfeng.core.annotion.query;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.xunfeng.core.model.FieldPool;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 字段注解 
* @author wanghan 
* @createDate 2015年4月23日-下午2:35:36 
* @version V1.0   
*/
@Target({ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME)   
@Documented  
@Inherited 
public @interface Field {
	/**
	 * 字段名
	 * @return
	 */
	public String name();
	
	
	/**
	 * 描述
	 * @return
	 */
	public String desc();
	

	
	/**
	 * 数据类型，默认为varchar
	 * @return
	 */
	public String dataType() default FieldPool.DATATYPE_VARCHAR;
	
	/**
	 * 可选值和名称的串。每组由值和名称构成，组之间用分号分隔。
	 * 如：0=未激活;1=激活;2=禁用
	 * @return 
	 */
	public String options() default "";	
	
	/**
	 * 字段控件类型，默认为1
	 * FieldPool 里的控件类型
	 * @return
	 */
	public short controlType() default (short)FieldPool.TEXT_INPUT;
	
	/**
	 * 字段格式,日期格式或者数字格式
	 * @return
	 */
	public String style() default "";
	
	
	
}
