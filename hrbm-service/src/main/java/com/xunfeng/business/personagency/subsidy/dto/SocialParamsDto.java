package com.xunfeng.business.personagency.subsidy.dto;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴参数 Model对象
* @author:wanghan
* @createDate 2016-07-07 10:26:13 
* @version V1.0   
*/
public class SocialParamsDto extends SocialParams
{
	// 参数类型
	protected String  paramsName;

	public String getParamsName() {
		return paramsName;
	}

	public void setParamsName(String paramsName) {
		this.paramsName = paramsName;
	}

}