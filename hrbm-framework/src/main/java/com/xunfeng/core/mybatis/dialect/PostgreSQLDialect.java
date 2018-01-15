package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: PostgreSQL方言
* @author wanghan 
* @createDate 2015年4月23日-下午2:06:30 
* @version V1.0   
*/
public class PostgreSQLDialect extends Dialect
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
		return new StringBuffer(sql.length() + 20).append(sql).append(offset > 0 ? " limit " + limitPlaceholder + " offset " + offsetPlaceholder : " limit " + limitPlaceholder).toString();
	}
}
