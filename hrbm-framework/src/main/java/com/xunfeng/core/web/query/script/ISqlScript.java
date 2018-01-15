package com.xunfeng.core.web.query.script;

import com.xunfeng.core.web.query.entity.JudgeScript;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: SQL条件脚本接口 
* @author wanghan 
* @createDate 2015年4月23日-上午10:42:31 
* @version V1.0   
*/
public interface ISqlScript {

	/**
	 * 获取脚本的SQL
	 * 
	 * @param judgeSingle
	 * @return
	 */
	public String getSQL(JudgeScript judgeScript);
}
