package com.xunfeng.core.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月23日-下午2:33:49 
* @version V1.0   
*/
@Target({ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface FieldDescription {
	/**
	 * 是否为主键
	 * @return
	 */
	public boolean pk() default false;
	/**
	 * 对应数据库列名
	 * @return
	 */
	public String columnName() default "";
	/**
	 * 该字段是否允许更新
	 * @return
	 */
	public boolean canUpd() default true;
}
