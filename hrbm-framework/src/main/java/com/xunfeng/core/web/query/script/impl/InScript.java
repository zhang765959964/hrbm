package com.xunfeng.core.web.query.script.impl;

import com.xunfeng.core.web.query.entity.JudgeSingle;
import com.xunfeng.core.web.query.script.ISingleScript;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 包含类型
* @author wanghan 
* @createDate 2015年4月23日-上午10:43:32 
* @version V1.0   
*/
public class InScript implements ISingleScript{
	
	@Override
	public String getSQL(JudgeSingle judgeSingle) {
		StringBuilder sb = new StringBuilder();
		if ("1".equals(judgeSingle.getCompare())) {//包含
			sb.append(judgeSingle.getFixFieldName()).append(" in (").append("")
					.append(judgeSingle.getValue()).append(")");
		} else if ("2".equals(judgeSingle.getCompare())) {//不包含
			sb.append(judgeSingle.getFixFieldName()).append(" not in (").append("")
					.append(judgeSingle.getValue()).append(")");
		}else if ("3".equals(judgeSingle.getCompare())) {//等于变量
			sb.append(judgeSingle.getFixFieldName()).append(" = ").append("")
			.append(judgeSingle.getValue());
		}else if ("4".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append(" !=").append("")
			.append(judgeSingle.getValue());
		}
		return sb.toString();
	}
}
