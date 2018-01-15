package com.xunfeng.core.web.security;

import javax.servlet.http.HttpServletRequest;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月23日-上午10:37:31 
* @version V1.0   
*/
public interface DirectUrlResolver {
	
	/**
	 * 获得配置配置标识用以跳转判断
	 * @param request
	 * @return
	 */
    boolean support(HttpServletRequest request);  
    
    /**
     * 获取跳转路径
     * @return
     */
    String directUrl();
    
}
