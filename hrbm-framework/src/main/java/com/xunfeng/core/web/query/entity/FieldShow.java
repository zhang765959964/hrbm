package com.xunfeng.core.web.query.entity;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 字段显示 
* @author wanghan 
* @createDate 2015年4月23日-上午11:04:23 
* @version V1.0   
*/
public class FieldShow {

	
	protected String name;
	
	protected String desc;
	
	protected int show =0;

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

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}
	
	
}
