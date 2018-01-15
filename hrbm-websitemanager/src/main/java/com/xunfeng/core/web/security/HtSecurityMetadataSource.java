package com.xunfeng.core.web.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.role.interf.SysRoleServiceInterf;
import com.xunfeng.sys.role.model.SysRole;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 系统初始化时，构建系统的url和角色映射。
* 并根据当前的url取出url具有的角色权限。
* 实现了 BeanPostProcessor接口，保证SysRoleService，SubSystemService，ICache能在初始化时进行注入，并调用其获取系统资源。
* @author wanghan 
* @createDate 2015年4月23日-上午10:31:53 
* @version V1.0   
*/
public class HtSecurityMetadataSource implements FilterInvocationSecurityMetadataSource ,BeanPostProcessor {
    /**具有匿名访问权限的url*/
	private  HashSet<String> anonymousUrls=new HashSet<String>();
   
	/**
	 * 设置具有匿名访问权限的url
	 * @param anonymousUrls
	 */
	public  void setAnonymousUrls(HashSet<String> anonymousUrls) {
		this.anonymousUrls = anonymousUrls;
	}

    
    /**
     * 根据当前的URL返回该url的角色集合。
     * 1.如果当前的URL在匿名访问的URL集合当中时，在当前的角色中添加匿名访问的角色(SysRole.ROLE_CONFIG_ANONYMOUS)。
     * 2.如果当前系统不存在的情况，给当前用户添加一个公共访问的角色(SysRole.ROLE_CONFIG_PUBLIC)。
     * 3.url 和角色映射，url和参数映射，给当前用户添加一个公共的角色(SysRole.ROLE_CONFIG_PUBLIC)。
     *
     */
    public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException {
    	
		Collection<ConfigAttribute> configAttribute =new HashSet<ConfigAttribute>();
		
		FilterInvocation filterInvocation=((FilterInvocation)object);
    	HttpServletRequest request=filterInvocation.getRequest();
    	
    	String url = request.getRequestURI();
    	url=removeCtx(url,request.getContextPath());
    	//匿名访问的URL
    	if(anonymousUrls.contains(url)){
    		configAttribute.add(SystemConst.ROLE_CONFIG_ANONYMOUS);
    		return configAttribute;
    	}

    	
    	SysRoleServiceInterf sysRoleService=(SysRoleServiceInterf)AppUtil.getBean("sysRole");
    	Map map=sysRoleService.getRightResRole(url);
    	
    	Boolean isRes=(Boolean)map.get("isRes");
    	List<SysRole> roleList=(List<SysRole>)map.get("roleList");
    	if(!isRes){
    		configAttribute.add(SystemConst.ROLE_CONFIG_PUBLIC);
    		return configAttribute;
    	}
    	else{
    		if(roleList.size()>0){
    			for(SysRole role:roleList){
    	    		configAttribute.add(new SecurityConfig(role.getRolename()));
    	    	}
    		}else{
    			configAttribute.add(SystemConst.ROLE_CONFIG_NOROLE);
    		}
    	}
    	
    	return configAttribute;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
    
    /**
     * 返回系统中所有为url分配了的权限
     */
    public Collection<ConfigAttribute> getAllConfigAttributes() {
    	return null;
    }
    

	
	
	
	/**
	 * 获取当前URL
	 * @param url
	 * @param contextPath
	 * @return
	 */
	private static String removeCtx(String url,String contextPath){
		url=url.trim();
		if(StringUtil.isEmpty(contextPath)) return url;
		if(StringUtil.isEmpty(url)) return "";
		if(url.startsWith(contextPath)){
			url=url.replaceFirst(contextPath, "");
		}
		return url;
	}
	
	/**
	 * 保证资源只被初始化一次。
	 */
	boolean isInit=false;
	
	/**
	 * 保证service的注入。
	 * 获取系统资源。
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
	
		
//		if(bean instanceof ICache){
//			this.iCache=(ICache)bean;
//		}
		
//		if(this.sysRoleService!=null && this.subSystemService!=null && iCache!=null ){
//			if(!isInit){
////				SecurityUtil.loadRes();
//				isInit=true;
//			}
//		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		return bean;
	}


	

}
