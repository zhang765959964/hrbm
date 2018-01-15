package com.xunfeng.core.json;

import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import com.xunfeng.core.util.DateFormatUtil;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:  日期JSON格式化 
* @author wanghan 
* @createDate 2015年4月23日-下午2:11:20 
* @version V1.0   
*/
public class DateJsonValueProcessor implements JsonValueProcessor {
	//格式化的日期格式
	private String format = "yyyy-MM-dd HH:mm:ss";

	public DateJsonValueProcessor(String format) {
		super();
		this.format = format;
	}

	public DateJsonValueProcessor() {
		super();
	}

	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return this.process(value);
	}

	@Override
	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		return this.process(value);
	}

	private Object process(Object value) {
		if (value == null)
			return "";
		else if (value instanceof Date) {
			try {
				return DateFormatUtil.format((Date) value, format);
			} catch (Exception ex) {
			}
		}
		return value.toString();
	}

}
