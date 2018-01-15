package com.xunfeng.core.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年6月8日-下午4:23:57 
* @version V1.0   
*/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)   
@Documented  
@Inherited 
public @interface Action {
	
	/**
	 * 操作类型
	 * @return
	 */
	//public String operateType() default "";
	/**
	 * 方法描述
	 * @return
	 */
	public String description() default "no description";
	
	
	/**
	 * 归属模块
	 * @return
	 */
//	public SysAuditModelType ownermodel() default SysAuditModelType.NULL ; 
	/**
	 * 日志类型
	 * @return
	 */
	public String exectype() default "操作日志";
	
	/**
	 * 详细信息
	 * @return
	 */
	public String detail() default "";
	
	/**
	 * 执行顺序
	 */
	public ActionExecOrder execOrder() default ActionExecOrder.AFTER;
}