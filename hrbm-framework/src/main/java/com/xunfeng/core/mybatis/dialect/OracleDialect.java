package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: oracle方言
* @author wanghan 
* @createDate 2015年4月23日-下午2:06:17 
* @version V1.0   
*/
public class OracleDialect extends Dialect
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
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update"))
		{
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		if (offset > 0)
		{
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		}
		else
		{
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (offset > 0)
		{
			// int end = offset+limit;
			String endString = offsetPlaceholder + "+" + limitPlaceholder;
			pagingSelect.append(" ) row_ ) where rownum_ <= " + endString + " and rownum_ > " + offsetPlaceholder);
		}
		else
		{
			pagingSelect.append(" ) where rownum <= " + limitPlaceholder);
		}
		if (isForUpdate)
		{
			pagingSelect.append(" for update");
		}
		return pagingSelect.toString();
	}

}
