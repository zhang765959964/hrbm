package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: HSQL方言
* @author wanghan 
* @createDate 2015年4月23日-下午2:05:10 
* @version V1.0   
*/
public class HSQLDialect extends Dialect
{
	public boolean supportsLimit()
	{
		return true;
	}

	public boolean supportsLimitOffset()
	{
		return true;
	}

	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
	{
		boolean hasOffset = offset > 0;
		return new StringBuffer(sql.length() + 10).append(sql).insert(sql.toLowerCase().indexOf("select") + 6, hasOffset ? " limit " + offsetPlaceholder + " " + limitPlaceholder : " top " + limitPlaceholder).toString();
	}
}
