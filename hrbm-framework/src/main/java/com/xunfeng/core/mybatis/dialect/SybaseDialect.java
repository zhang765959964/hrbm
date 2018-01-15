package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: Sybase 方言 
* @author wanghan 
* @createDate 2015年4月23日-下午2:07:39 
* @version V1.0   
*/
public class SybaseDialect extends Dialect
{
	public boolean supportsLimit()
	{
		return false;
	}

	public boolean supportsLimitOffset()
	{
		return false;
	}

	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
	{
		throw new UnsupportedOperationException("paged queries not supported");
	}
}
