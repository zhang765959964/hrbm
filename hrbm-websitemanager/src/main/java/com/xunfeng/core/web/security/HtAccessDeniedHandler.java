package com.xunfeng.core.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: spring security 访问拒绝处理器 
* @author wanghan 
* @createDate 2015年4月23日-上午10:35:54 
* @version V1.0   
*/
public class HtAccessDeniedHandler implements AccessDeniedHandler {

	private String accessDeniedUrl;

	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}
	
	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}
	

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException ex) throws IOException, ServletException {
		request.setAttribute("ex", ex);
		try{
			request.getRequestDispatcher(accessDeniedUrl).forward(request, response);
			return;
		}
		catch(Exception e){
			
		}
		
		
	}

}
