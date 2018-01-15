package com.xunfeng.core.web.listener;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;
import com.xunfeng.sys.config.model.BaseConfig;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: spring 启动监听器 
* @author wanghan 
* @createDate 2015年4月23日-上午11:05:10 
* @version V1.0   
*/
public class StartupListner extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		// 设置变量
		String contextPath = context.getContextPath();
		context.setAttribute("ctx", contextPath);
		super.contextInitialized(event);
		Properties configproperties=(Properties)AppUtil.getBean("configproperties");
		BaseConfigServiceInterf  baseConfigService = (BaseConfigServiceInterf)AppUtil.getBean("baseConfig");
		BaseConfig bs = baseConfigService.getConfigByName("SysTitle");
		context.setAttribute("sysTitle",bs.getCaos04());
		String fileDirectory=configproperties.getProperty("file.directory");
		String sysUrl=configproperties.getProperty("sys.url");
		context.setAttribute("sysUrl", sysUrl);
		context.setAttribute("fileDirectory", fileDirectory);
		AppUtil.init(event.getServletContext());
	}
}
