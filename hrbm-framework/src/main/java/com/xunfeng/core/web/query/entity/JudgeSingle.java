package com.xunfeng.core.web.query.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 查询条件的单值封装
* @author wanghan 
* @createDate 2015年4月23日-上午10:54:03 
* @version V1.0   
*/
public class JudgeSingle extends FieldTable {

	/**
	 * 值比较符
	 */
	protected String compare;
	/**
	 * 值
	 */
	protected String value;

	// ========== getter 和 setter ============


	public String getCompare() {
		return compare;
	}

	public void setCompare(String compare) {
		this.compare = compare;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("fieldName", fieldName)
				.append("compare", compare).append("value", value).toString();
	}

}
