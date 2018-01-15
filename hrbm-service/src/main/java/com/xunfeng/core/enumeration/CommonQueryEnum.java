package com.xunfeng.core.enumeration;

/**
 * 查询共同枚举类
 * @author Administrator
 *
 */
public enum CommonQueryEnum {
	JwCoopOrg("getCoopOrgViewList");
	
	private CommonQueryEnum(String queryKey) {
		this.queryKey = queryKey;
	}
	
	private  String queryKey;
	
	public String getQueryKey() {
		return queryKey;
	}
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}
	
}
