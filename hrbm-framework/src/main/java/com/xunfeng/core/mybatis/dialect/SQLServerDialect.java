package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: sqlserver 方言 
* @author wanghan 
* @createDate 2015年4月23日-下午2:07:18 
* @version V1.0   
*/
public class SQLServerDialect extends Dialect
{
	public boolean supportsLimitOffset()
	{
		return false;
	}

	public boolean supportsLimit()
	{
		return true;
	}

	static int getAfterSelectInsertPoint(String sql)
	{
		int selectIndex = sql.toLowerCase().indexOf("select");
		final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
		return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
	}

	public String getLimitString(String sql, int offset, int limit)
	{
		return getLimitString(sql, offset, null, limit, null);
	}

	public String getLimitString(String querySelect, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
	{
		if (offset > 0)
		{
			throw new UnsupportedOperationException("sql server has no offset");
		}
	
		return new StringBuffer(querySelect.length() + 8).append(querySelect).insert(getAfterSelectInsertPoint(querySelect), " top " + limit).toString();
	}

	
}
