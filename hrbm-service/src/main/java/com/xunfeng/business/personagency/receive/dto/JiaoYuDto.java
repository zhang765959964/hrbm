package com.xunfeng.business.personagency.receive.dto;

import java.io.Serializable;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Form对象
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public class JiaoYuDto implements Serializable
{
	
	// 学历信息编号
	protected Long  aac0d0;
	// 毕业学校
	protected String  aac045;
	// 毕业时间
	protected String  aac046;
	// 学历
	protected String  atc011;
	// 学位
	protected String  aac037;
	// 所学专业
	protected String  acc01g;
	
	public Long getAac0d0() {
		return aac0d0;
	}
	public void setAac0d0(Long aac0d0) {
		this.aac0d0 = aac0d0;
	}
	public String getAac045() {
		return aac045;
	}
	public void setAac045(String aac045) {
		this.aac045 = aac045;
	}
	
	public String getAac046() {
		return aac046;
	}
	public void setAac046(String aac046) {
		this.aac046 = aac046;
	}
	public String getAtc011() {
		return atc011;
	}
	public void setAtc011(String atc011) {
		this.atc011 = atc011;
	}
	public String getAac037() {
		return aac037;
	}
	public void setAac037(String aac037) {
		this.aac037 = aac037;
	}
	public String getAcc01g() {
		return acc01g;
	}
	public void setAcc01g(String acc01g) {
		this.acc01g = acc01g;
	}
	
}