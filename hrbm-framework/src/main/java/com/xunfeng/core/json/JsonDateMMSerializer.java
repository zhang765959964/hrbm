/**   
*  
*/


package com.xunfeng.core.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年5月14日-下午4:12:40 
 * @version V1.0   
 */
public class JsonDateMMSerializer extends JsonSerializer<Date> {  
	   private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	   @Override  
	   public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)  
	           throws IOException, JsonProcessingException {  
	       String value = dateFormat.format(date);  
	       gen.writeString(value);  
	   }  
	}  
