package com.xunfeng.core.web;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 未找到视图异常类 
* @author wanghan 
* @createDate 2015年4月23日-上午10:17:52 
* @version V1.0   
*/
public class NoSuchViewResolverException extends RuntimeException
{
	public NoSuchViewResolverException()
	{
		super("No such ViewResolver.");
	}

	public NoSuchViewResolverException(String message)
	{
		super(message);
	}
}
