package com.xunfeng.core.web;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import net.sf.json.util.JSONStringer;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: web请求返回消息 
* @author wanghan 
* @createDate 2015年4月23日-上午10:17:10 
* @version V1.0   
*/
public class ResultMessage implements Serializable{
	/** */
	private static final long serialVersionUID = -7102370526170507252L;

	/** 成功 */
	public static final int Success = 1;

	/** 失败 */
	public static final int Fail = 0;
	
	/** 个人未登录*/
	public static final int PersonNoLogin = -1;
	
	
	/** 企业未登录 */
	public static final int corpNoLogin = -2;
	
	// 返回结果(成功或失败)
	private int result = Success;
	// 返回消息
	private String message = "";
	// 引起原因
	private String cause = "";
	
	private Object data = null;
	public ResultMessage() {
	}

	public ResultMessage(int result, String message) {
		this.result = result;
		this.message = message;
	}
	
	public ResultMessage(int result, String message, String cause) {
		this.result = result;
		this.message = message;
		this.cause = cause;
	}

	public ResultMessage(int result,String message,Object data){
		this.result=result;
		this.message = message;
		this.data = data;
	}
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toString() {
		JSONStringer stringer = new JSONStringer();
		stringer.object();
		stringer.key("result");
		stringer.value(result);
		stringer.key("message");
		stringer.value(message);
		stringer.key("cause");
		stringer.value(cause);
		if(data!=null){
			stringer.key("data");
			stringer.value(JSON.toJSON(data).toString());
		}
		
		stringer.endObject();
		return stringer.toString();
	}

}
