package com.xunfeng.core.web.query.script.impl;

import com.xunfeng.core.web.query.entity.JudgeScript;
import com.xunfeng.core.web.query.script.ISqlScript;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 脚本类型 
* @author wanghan 
* @createDate 2015年4月23日-上午10:45:00 
* @version V1.0   
*/
public class SqlScript implements ISqlScript {

	@Override
	public String getSQL(JudgeScript judgeScript) {
		if(judgeScript == null)
			return "";
		
		return judgeScript.getValue();
	}


}
