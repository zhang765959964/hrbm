package org.hrbm.framework;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.xunfeng.core.util.StringUtil;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class URlEncloder {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String turl="http://f032fd15.ngrok.io/mobile/index.html#/wxUserIfLogin/wxUser1";
		turl=URLEncoder.encode(turl, "UTF-8");
		String url="http://f032fd15.ngrok.io/mobile/action/businessHander?callBackUrl="+turl;
		//String url=URLEncoder.encode("http://f032fd15.ngrok.io/mobile/action/businessHander?callBackUrl= http://f032fd15.ngrok.io/mobile/index.html#/wxUserIfLogin/wxUser1", "UTF-8");

		 url=URLEncoder.encode(url, "UTF-8");
		 System.out.println(url);
//		url=URLEncoder.encode(url, "UTF-8");
//		url=StringUtil.escape(url);
		System.out.println(url);
		
		

	}

}
