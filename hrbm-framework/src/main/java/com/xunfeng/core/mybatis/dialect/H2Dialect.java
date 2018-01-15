package com.xunfeng.core.mybatis.dialect;

import com.xunfeng.core.mybatis.Dialect;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: H2方言 
* @author wanghan 
* @createDate 2015年4月23日-下午2:04:51 
* @version V1.0   
*/
public class H2Dialect extends Dialect
{
	public boolean supportsLimit()
	{
		return true;
	}

	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
	{
		return new StringBuffer(sql.length() + 40).append(sql).append((offset > 0) ? " limit " + limitPlaceholder + " offset " + offsetPlaceholder : " limit " + limitPlaceholder).toString();
	}

	@Override
	public boolean supportsLimitOffset()
	{
		return true;
	}
	// public boolean bindLimitParametersInReverseOrder() {
	// return true;
	// }
	//
	// public boolean bindLimitParametersFirst() {
	// return false;
	// }
}
