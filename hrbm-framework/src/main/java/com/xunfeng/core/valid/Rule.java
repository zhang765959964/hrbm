package com.xunfeng.core.valid;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 验证规则 
* @author wanghan 
* @createDate 2015年4月23日-上午11:17:31 
* @version V1.0   
*/
public class Rule {
	
	/**
	 * 规则名称
	 */
	private String name="";
	
	/**
	 * 规则信息。
	 */
	private String ruleInfo="";
	
	/**
	 * 规则提示信息。
	 */
	private String tipInfo="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRuleInfo() {
		
		return ruleInfo;
	}

	public void setRuleInfo(String ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

	public String getTipInfo() {
		return tipInfo;
	}

	public void setTipInfo(String tipInfo) {
		this.tipInfo = tipInfo;
	}
	

	
	

}
