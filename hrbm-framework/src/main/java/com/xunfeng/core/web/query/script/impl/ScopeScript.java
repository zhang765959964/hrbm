package com.xunfeng.core.web.query.script.impl;

import com.xunfeng.core.web.query.entity.JudgeScope;
import com.xunfeng.core.web.query.script.IScopeScript;
import com.xunfeng.core.web.query.script.ISingleScript;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 范围值 
* @author wanghan 
* @createDate 2015年4月23日-上午10:45:57 
* @version V1.0   
*/
public class ScopeScript implements IScopeScript {
	@Override
	public String getSQL(JudgeScope judgeScope) {
		StringBuilder sb = new StringBuilder();
		// 获得单值脚本构造器
		ISingleScript queryScript = SingleScriptFactory
				.getQueryScript(judgeScope.getOptType());
		// 获得开始值脚本
		String scriptBegin = queryScript.getSQL(judgeScope.getBeginJudge());
		// 获得结束值脚本
		String scriptEnd = queryScript.getSQL(judgeScope.getEndJudge());
		// 拼接
		sb.append(" (").append(scriptBegin).append(" ")
				.append(judgeScope.getRelation()).append(" ").append(scriptEnd)
				.append(") ");
		return sb.toString();
	}
}
