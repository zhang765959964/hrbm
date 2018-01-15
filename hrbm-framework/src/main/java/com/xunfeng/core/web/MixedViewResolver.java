package com.xunfeng.core.web;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 混合视图 
* @author wanghan 
* @createDate 2015年4月23日-上午10:20:11 
* @version V1.0   
*/
public class MixedViewResolver implements ViewResolver
{
	private Map<String, ViewResolver> resolvers;

	public void setResolvers(Map<String, ViewResolver> resolvers)
	{
		this.resolvers = resolvers;
	}

	public View resolveViewName(String viewName, Locale locale) throws Exception
	{
		int n = viewName.lastIndexOf('.');
		if (n == (-1))
			throw new NoSuchViewResolverException();
		String suffix = viewName.substring(n + 1);
		ViewResolver resolver = resolvers.get(suffix);
		// viewName=viewName.substring(0,n);
		if (resolver != null)
			return resolver.resolveViewName(viewName, locale);
		throw new NoSuchViewResolverException("No ViewResolver for " + suffix);
	}
}
