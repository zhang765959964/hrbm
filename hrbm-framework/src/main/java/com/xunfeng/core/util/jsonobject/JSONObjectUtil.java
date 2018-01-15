
package com.xunfeng.core.util.jsonobject;

import java.util.Date;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xunfeng.core.util.jsonobject.support.BooleanSerializer;
import com.xunfeng.core.util.jsonobject.support.DateSerializer;
import com.xunfeng.core.util.jsonobject.support.JsonObjectSerializer;
import com.xunfeng.core.util.jsonobject.support.SuperclassExclusionStrategy;
  

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: josn操作类 
* @author wanghan 
* @createDate 2015年4月23日-上午11:57:11 
* @version V1.0   
*/
public class JSONObjectUtil {
	/**
	 * @param jsonObject
	 * @param cls
	 * @return 
	 * C
	 * @exception 
	 * @since  1.0.0
	 */
	public static <C>  C toBean(JSONObject jsonObject,Class<C> cls){
		return toBean(jsonObject.toString(), cls);
	}
	
	/**  
	 * 把jsonStr生成一个cls对象
	 * @param jsonObject
	 * @param cls
	 * @return 
	 * C
	 * @exception 
	 * @since  1.0.0
	 */
	public static <C>  C toBean(String  jsonStr,Class<C> cls){
		GsonBuilder gsonBuilder = new GsonBuilder();  
        gsonBuilder.registerTypeAdapter(String.class, new JsonObjectSerializer())
        		   .registerTypeAdapter(Date.class, new DateSerializer())
        		   .registerTypeAdapter(Boolean.class, new BooleanSerializer())
        		   .addDeserializationExclusionStrategy(new SuperclassExclusionStrategy())
        		   .addSerializationExclusionStrategy(new SuperclassExclusionStrategy());
        Gson gson = gsonBuilder.create();
		C o = (C)gson.fromJson(jsonStr,cls);
		return o;
	}
	
	public static void main(String[] args) {
	}
}
