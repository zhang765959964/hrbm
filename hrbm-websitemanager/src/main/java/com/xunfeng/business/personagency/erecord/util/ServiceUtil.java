package com.xunfeng.business.personagency.erecord.util;


import com.xunfeng.core.util.AppConfigUtil;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.StringUtil;
import org.springframework.web.context.ContextLoader;

import java.util.Properties;

public class ServiceUtil {


	/**
	 * 获取项目路径，如/bpm3
	 * @author hjx
	 * @version 创建时间：2014-2-8  下午5:59:41
	 * @return
	 */
	public static String getBaseUrl(){
		String baseUrl= ContextLoader.getCurrentWebApplicationContext().getServletContext().getContextPath();
		return baseUrl;
	}

	
	/**
	 * 配置文件中获取文件上传路径
	 * 如果为空则采用默认路径/attachFiles/temp
	 * 这个路径返回没有/或\结尾。
	 * 
	 * @author hjx
	 * @version 创建时间：2013-11-4  下午3:46:28
	 * @return
	 */
	public static String getBasePath() {
		String attachPath= AppConfigUtil.get("file.upload");
		if (StringUtil.isEmpty(attachPath)) {
			attachPath = AppUtil.getRealPath("/attachFiles/temp");
		}
		attachPath= StringUtil.trimSufffix(attachPath, "\\") ;
		attachPath=StringUtil.trimSufffix(attachPath, "/") ;
		
		return attachPath;
	}
	
	
	/**
	 * 配置文件中获取文件存放的类型
	 * @author xcx
	 * @version 创建时间：2013-12-27  下午3:53:20
	 * @return
	 */
	public static String getSaveType() {
		Properties configproperties=(Properties)AppUtil.getBean("configproperties");
		String saveType = configproperties.getProperty("file.saveType");
		if (StringUtil.isEmpty(saveType)) {
			saveType = "Folder";
		}
		return saveType.trim().toLowerCase();
	}
	

}
