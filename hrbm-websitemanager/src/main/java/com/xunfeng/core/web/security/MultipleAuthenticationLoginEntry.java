package com.xunfeng.core.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: spring security 捕获异常后的入口类 
* @author wanghan 
* @createDate 2015年4月23日-上午10:29:38 
* @version V1.0   
*/
public class MultipleAuthenticationLoginEntry implements
		AuthenticationEntryPoint {

    private String defaultLoginUrl="/login.jsp";  
    private List<DirectUrlResolver> directUrlResolvers = new ArrayList<DirectUrlResolver>();  
  
    /**
     * 根据输入路径与配置项得到跳转路径分别跳到不同登录页面
     */
    @Override  
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {  
        
    	String ctxPath = request.getContextPath();
    	for (DirectUrlResolver directUrlResolver : directUrlResolvers) {  
            if (directUrlResolver.support(request)) {  
                String loginUrl = directUrlResolver.directUrl();  
                response.sendRedirect(ctxPath+ loginUrl);  
                return;  
            }  
        }  
        response.sendRedirect(ctxPath+defaultLoginUrl);  
    }  
  
    public void setDefaultLoginUrl(String defaultLoginUrl) {  
    	
        this.defaultLoginUrl = defaultLoginUrl;  
    }  
  
    public void setDirectUrlResolvers(List<DirectUrlResolver> directUrlResolvers) {  
        this.directUrlResolvers = directUrlResolvers;  
    }  

}
