package com.xunfeng.core.encrypt;

import java.io.UnsupportedEncodingException;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: Base64工具类 
* @author wanghan 
* @createDate 2015年4月23日-下午2:25:02 
* @version V1.0   
*/
public class Base64 
{
	/**
	 * 将字符串转化为base64编码
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getBase64(String s) throws UnsupportedEncodingException {
		byte[] bytes= org.apache.commons.codec.binary.Base64.encodeBase64(s.getBytes("utf-8"));
		return new String(bytes, "utf-8");
		
	}

	/**
	 * 将 BASE64 编码的字符串 s 进行解码
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getFromBase64(String s) throws UnsupportedEncodingException {
		byte[] bytes=s.getBytes("GBK");
		byte[] convertBytes=org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
		return new String(convertBytes, "GBK");
	}
	
	
	
	
	
}
