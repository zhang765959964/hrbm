package com.xunfeng.core.web.query.entity;

import com.xunfeng.core.web.query.util.QueryConstants;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 排序字段的数据封装 
* @author wanghan 
* @createDate 2015年4月23日-上午11:04:11 
* @version V1.0   
*/
public class FieldSort extends FieldTable {

	/**
	 * 升或降序
	 */
	private String orderBy = QueryConstants.SORT_ASC;

	public FieldSort() {
	}

	public FieldSort(String tableName, String fieldName, String orderBy) {
		super();
		this.tableName = tableName;
		this.fieldName = fieldName;
		this.orderBy = orderBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}
