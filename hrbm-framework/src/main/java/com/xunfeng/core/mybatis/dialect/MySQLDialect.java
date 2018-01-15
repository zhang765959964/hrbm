package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: mysql 方言处理
* @author wanghan 
* @createDate 2015年4月23日-下午2:05:39 
* @version V1.0   
*/
public class MySQLDialect extends Dialect
{
	public boolean supportsLimitOffset()
	{
		return true;
	}

	public boolean supportsLimit()
	{
		return true;
	}

	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
	{
		if (offset > 0)
		{
			return sql + " limit " + offsetPlaceholder + "," + limitPlaceholder;
		}
		else
		{
			return sql + " limit " + limitPlaceholder;
		}
	}

	
}
