package com.xunfeng.core.web.query.entity;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 过滤条件 
* @author wanghan 
* @createDate 2015年4月23日-上午10:58:27 
* @version V1.0   
*/
public class Filter {

	// 名字
	private String name;
	// 备注（显示名）
	private String desc;
	// key
	private String key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
