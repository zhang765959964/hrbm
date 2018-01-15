package com.xunfeng.business.dissupport.divice.web.form;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 检索条件配置项
 * @author Administrator
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryField {
	
	/**
	 * 属性对应数据库列名
	 * @return
	 */
	String column() default "";
	
    /**
     * 运算操作
     * @return
     */
    String operation() default "=";
    
    /**
     * 属性对应类型(BS,CS)
     * @return
     */
    String type() default "";
}
