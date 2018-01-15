package com.xunfeng.core.web.query.script.impl;

import com.xunfeng.core.web.query.entity.JudgeSingle;
import com.xunfeng.core.web.query.script.ISingleScript;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 数值类型的脚本 
* @author wanghan 
* @createDate 2015年4月23日-上午10:46:12 
* @version V1.0   
*/
public class NumberScript implements ISingleScript {

	@Override
	public String getSQL(JudgeSingle judgeSingle) {
		StringBuilder sb = new StringBuilder();
		if ("1".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append("=")
					.append(judgeSingle.getValue());
		} else if ("2".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append("!=")
					.append(judgeSingle.getValue());
		} else if ("3".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append(">")
					.append(judgeSingle.getValue());
		} else if ("4".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append(">=")
					.append(judgeSingle.getValue());
		} else if ("5".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append("<")
					.append(judgeSingle.getValue());
		} else if ("6".equals(judgeSingle.getCompare())) {
			sb.append(judgeSingle.getFixFieldName()).append("<=")
					.append(judgeSingle.getValue());
		}
		return sb.toString();
	}

}
