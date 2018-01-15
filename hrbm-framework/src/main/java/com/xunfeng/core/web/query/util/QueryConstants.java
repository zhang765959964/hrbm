package com.xunfeng.core.web.query.util;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 查询常用的变量 
* @author wanghan 
* @createDate 2015年4月23日-上午10:41:00 
* @version V1.0   
*/
public interface QueryConstants {
	/** 查询AND */
	String QUERY_AND = "AND";
	String QUERY_OR = "OR";
	String QUERY_NOT = "NOT";
	
	/**SQL Relation 关联关系*/
	String SQL_RELATION_EQUAL = "=";
	String SQL_RELATION_GT = ">";
	String SQL_RELATION_GT_EQUAL = ">=";
	String SQL_RELATION_LT = "<";
	String SQL_RELATION_LT_EQUAL = "<=";
	String SQL_RELATION_LIKE = " LIKE ";
	/**SQL排序*/
	String SORT_ASC = "ASC";
	String SORT_DESC = "DESC";

	/** 单值 */
	int JUDGE_SINGLE = 1;
	/** 范围值 */
	int JUDGE_SCOPE = 2;
	/** 脚本 */
	int JUDGE_SCRIPT = 3;

	/** 参数标识(过滤条件KEY) */
	String FILTER_KEY = "__FILTERKEY__";
	/**过滤条件标识*/
	String FILTER_FLAG = "__FILTER_FLAG__";
	/**是否初始化查询*/
	String IS_QUERY = "__IS_QUERY__";
	
	short IS_QUERY_YES = 0;
	short IS_QUERY_NOT = 1;
}
