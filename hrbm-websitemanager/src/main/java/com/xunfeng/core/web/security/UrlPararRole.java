package com.xunfeng.core.web.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月23日-上午10:28:22 
* @version V1.0   
*/
public class UrlPararRole{
	
	private Map<String, Collection<ConfigAttribute>> 	urlRoleMap=new HashMap<String, Collection<ConfigAttribute>>();
	private Map<String, Set<String>> urlParaMap =new HashMap<String, Set<String>>();
	
	public Map<String, Collection<ConfigAttribute>> getUrlRoleMap() {
		return urlRoleMap;
	}
	public void setUrlRoleMap(Map<String, Collection<ConfigAttribute>> urlRoleMap) {
		this.urlRoleMap = urlRoleMap;
	}
	public Map<String, Set<String>> getUrlParaMap() {
		return urlParaMap;
	}
	public void setUrlParaMap(Map<String, Set<String>> urlParaMap) {
		this.urlParaMap = urlParaMap;
	}
	
	
	
}
