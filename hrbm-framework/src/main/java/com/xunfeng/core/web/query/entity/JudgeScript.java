package com.xunfeng.core.web.query.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 查询条件的脚本值封装
* @author wanghan 
* @createDate 2015年4月23日-上午10:57:56 
* @version V1.0   
*/
public class JudgeScript {

	/**
	 * 值
	 */
	protected String value;

	// ========== getter 和 setter ============
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("value", value).toString();
	}

}
