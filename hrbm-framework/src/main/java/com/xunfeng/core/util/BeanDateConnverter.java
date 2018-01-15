package com.xunfeng.core.util;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: bean时间转换类
* @author wanghan 
* @createDate 2015年4月23日-上午11:52:53 
* @version V1.0   
*/
public class BeanDateConnverter implements Converter
{
	private static final Logger logger = LoggerFactory.getLogger(BeanDateConnverter.class);
	public static final String[] ACCEPT_DATE_FORMATS = {
		"yyyy-MM-dd HH:mm:ss",
		"yyyy-MM-dd"
	};

	public BeanDateConnverter() {
	}

	public Object convert(Class arg0, Object value) {
		logger.debug("conver " + value + " to date object");
		if(value==null) return null;
		String dateStr=value.toString();
		dateStr=dateStr.replace("T", " ");
		try{
			return DateUtils.parseDate(dateStr, ACCEPT_DATE_FORMATS);
		}catch(Exception ex){
			logger.debug("parse date error:"+ex.getMessage());
		}
		return null;
	}
}
