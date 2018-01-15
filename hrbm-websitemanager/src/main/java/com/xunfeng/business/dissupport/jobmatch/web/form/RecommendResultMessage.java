package com.xunfeng.business.dissupport.jobmatch.web.form;

import com.alibaba.fastjson.JSONObject;
import com.xunfeng.core.web.ResultMessage;

/**
 * 匹配推荐返回信息
 * 
 * @author Administrator
 *
 */
public class RecommendResultMessage extends ResultMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6918195717173038760L;
	private String accId = null;

	public RecommendResultMessage() {
	}

	public RecommendResultMessage(int type, String message, String accId) {
		super(type, message);
		this.accId = accId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}
    @Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
