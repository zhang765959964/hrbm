package com.xunfeng.core.web.security;

import javax.servlet.http.HttpServletRequest;

import com.xunfeng.core.util.StringUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月23日-上午10:29:26 
* @version V1.0   
*/
public class RequestUriDirectUrlResolver extends AbstractDirectUrlResolver {  
	
	/**
	 * 获得跳转路径里的标识
	 */
    @Override  
    public boolean support(HttpServletRequest request) {
    	
        String requestURI = request.getRequestURI();  
        return requestURI.contains(this.pattern);
        
    }
    
}  
