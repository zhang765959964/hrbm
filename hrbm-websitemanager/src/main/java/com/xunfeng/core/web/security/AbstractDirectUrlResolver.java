package com.xunfeng.core.web.security;

import javax.servlet.http.HttpServletRequest;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月23日-上午10:37:42 
* @version V1.0   
*/
public abstract class AbstractDirectUrlResolver implements DirectUrlResolver {

    protected String pattern;  
    protected String directUrl;  
  
    @Override  
    public abstract boolean support(HttpServletRequest request);  
  
    @Override  
    public String directUrl() {  
        return this.directUrl;  
    }  
  
    public void setPattern(String pattern) {  
        this.pattern = pattern;  
    }  
  
    public void setDirectUrl(String directUrl) {  
        this.directUrl = directUrl;  
    }

}
