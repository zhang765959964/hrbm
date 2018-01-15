package com.xunfeng.core.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 消息操作类
* @author wanghan 
* @createDate 2015年4月23日-上午11:25:03 
* @version V1.0   
*/
public   class ResourceUtil {
	
	
	  /**
     * 取得资源键值 
     * @param msgKey
     * @param arg
     * @param locale
     * @return
     */
    public static String getText(String msgKey,Object arg,Locale local) {
    	MessageSource messageSource=(MessageSource)AppUtil.getBean(MessageSource.class);
    	return messageSource.getMessage(msgKey,new Object[]{ arg}, local);
    }
    
    /**
     * 取得资源键值 
     * @param msgKey
     * @param args
     * @param locale
     * @return
     */
    public static String getText(String msgKey,Object[] args,Locale local) {
    	MessageSource messageSource=(MessageSource)AppUtil.getBean(MessageSource.class);
    	return messageSource.getMessage(msgKey,args, local);
    }
	
    
   
}
