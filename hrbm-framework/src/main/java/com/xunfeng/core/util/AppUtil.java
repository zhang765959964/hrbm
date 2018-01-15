package com.xunfeng.core.util;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.xunfeng.core.model.OnlineUser;




/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: spring ApplicationContext 操作类，获取spring上下文环境
* @author wanghan 
* @createDate 2015年4月23日-上午11:55:18 
* @version V1.0   
*/
public class AppUtil implements ApplicationContextAware {

	private static  ApplicationContext applicationContext;
	
	
	
	/**
	 * 在线用户
	 */
	private static Map<Long,OnlineUser> onlineUsers=new LinkedHashMap<Long, OnlineUser>();
	
	
	private static ServletContext servletContext;
	
	
	/**
	 * 
	 * @param servletContext
	 */
	public static void init(ServletContext _servletContext)
	{
		servletContext=_servletContext;
	}
	
	/**
	 * 获取web应用的ServletContext对象。
	 * @return
	 * @throws Exception
	 */
	public static ServletContext getServletContext() throws Exception{
		return servletContext;
	}

	/**
	 * spring启动时注入context
	 */
	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		applicationContext=contex;
	}

	/**
	 * 获取spring的上下文。
	 * @return
	 */
	public static ApplicationContext getContext(){
		return applicationContext;
	}
	
	

	
	/**
	 * 根据类从spring上下文获取bean。
	 * @param cls
	 * @return
	 */
	public  static <C> C getBean(Class<C> cls){
		return applicationContext.getBean(cls);
	}
	
	/**
	 * 根据类名从spring上下文获取bean。
	 * @param cls
	 * @return
	 */
	public static Object getBean(String  beanId){
		return applicationContext.getBean(beanId);
	}

	/**
	 * 取得应用程序的绝对路径
	 * @return
	 */
	public static String getAppAbsolutePath(){
		return servletContext.getRealPath("/");
	}
	
	/**
	 * 在web环境中根据web页面的路径获取对应页面的绝对路径。
	 * @param path
	 * @return
	 */
	public static String getRealPath(String path){
		return servletContext.getRealPath(path);
	}
	
	public static Map<Long, OnlineUser> getOnlineUsers() {
		return onlineUsers;
	}
	
	/**
	 * 获取Classpath物理路径
	 * @return
	 */
	public static String getClasspath(){
		 String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		 String rootPath  = "";
		  //windows下
		  if("\\".equals(File.separator)){   
		   rootPath  = classPath.substring(1);
		   rootPath = rootPath.replace("/", "\\");
		  }
		  //linux下
		  if("/".equals(File.separator)){   
		   rootPath  = classPath.substring(1);
		   rootPath = rootPath.replace("\\", "/");
		  }
		  return rootPath;
	}
	
	public static void main(String[]args){
		Logger logger = LoggerFactory.getLogger(AppUtil.class);
		logger.info("path:" + getClasspath());
	}


}
