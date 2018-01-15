package com.xunfeng.core.web.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.web.util.RequestUtil;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:   用于拦截请求以获取HttpSevletRequest对象，以供后续Aop类使用。
*  用于相同线程间共享Request对象 。
* @author wanghan 
* @createDate 2015年4月23日-上午11:10:30 
* @version V1.0   
*/
public class AopFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException{
		try{
			//ContextUtil.clearAll();
			RequestUtil.setHttpServletRequest((HttpServletRequest) request);
			RequestUtil.setHttpServletResponse((HttpServletResponse)response);
			Long userId=ContextUtil.getCurrentUserId();
			
			SessionLocaleResolver sessionResolver=(SessionLocaleResolver)AppUtil.getBean(SessionLocaleResolver.class);
			Locale local= sessionResolver.resolveLocale((HttpServletRequest) request);
			ContextUtil.setLocale(local);
			
		    HttpSession session=	((HttpServletRequest)request).getSession();
		    if(null==session.getAttribute("loginTitle")){
		    	 session.setAttribute("loginTitle", ContextUtil.getLoginTitle());
		    } 
			
			if(userId!=null && userId>0){
				//ContextUtil.getCurrentPosFromSession();
			}
			chain.doFilter(request, response);
		}
		finally{
			//ContextUtil.clearAll();
		}
	}
	

	@Override
	public void destroy()
	{
	}

}
