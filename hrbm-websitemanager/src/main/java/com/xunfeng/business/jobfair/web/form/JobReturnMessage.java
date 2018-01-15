package com.xunfeng.business.jobfair.web.form;

import com.alibaba.fastjson.JSONObject;
import com.xunfeng.core.web.ResultMessage;

public class JobReturnMessage extends ResultMessage{
  /**
	 * 
	 */
	private static final long serialVersionUID = -9176415600647014404L;
	private String jobId;
	  
		public JobReturnMessage() {
		}
		public JobReturnMessage(int type,String message,String jobId) {
			super(type,message);
			this.jobId = jobId;
		}
		
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
    @Override
    	public String toString() {
    		return JSONObject.toJSONString(this);
    	}
}
