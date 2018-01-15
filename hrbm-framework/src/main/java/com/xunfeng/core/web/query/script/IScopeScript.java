package com.xunfeng.core.web.query.script;

import com.xunfeng.core.web.query.entity.JudgeScope;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 范围值条件脚本接口
* @author wanghan 
* @createDate 2015年4月23日-上午10:43:03 
* @version V1.0   
*/
public interface IScopeScript {

	/**
	 * 获取脚本的SQL
	 * @param judgeScope
	 * @return
	 */
	public String getSQL(JudgeScope judgeScope);
}
