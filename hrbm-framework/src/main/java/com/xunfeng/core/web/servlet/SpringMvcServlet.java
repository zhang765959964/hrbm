package com.xunfeng.core.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

import com.xunfeng.core.util.StringUtil;

public class SpringMvcServlet extends DispatcherServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		String requestURI=request.getRequestURI();
		logger.debug("not foud handle mapping for url: " + requestURI);
		//处理RequestURI
		String contextPath=request.getContextPath();
		
		requestURI=requestURI.replace(".xf", "");
		int cxtIndex=requestURI.indexOf(contextPath);
		if(cxtIndex!=-1)
		{
			requestURI=requestURI.substring(cxtIndex+contextPath.length());
		}
		String[]paths=requestURI.split("[/]");
		String jspPath=null;
		if(paths!=null && paths.length==5){
			jspPath="/"+paths[1] + "/" + paths[2] + "/" +paths[3] +  StringUtil.makeFirstLetterUpperCase(paths[4]) + ".jsp";
		}else{
			jspPath=requestURI + ".jsp";
		}
		logger.debug("requestURI:" + request.getRequestURI() + " and forward to /WEB-INF/view"+jspPath );
		request.getRequestDispatcher("/WEB-INF/view"+jspPath).forward(request, response);
		//super.noHandlerFound(request, response);
	}
}
