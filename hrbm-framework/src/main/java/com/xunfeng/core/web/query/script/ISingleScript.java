package com.xunfeng.core.web.query.script;

import com.xunfeng.core.web.query.entity.JudgeSingle;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 单值条件脚本
* @author wanghan 
* @createDate 2015年4月23日-上午10:42:41 
* @version V1.0   
*/
public interface ISingleScript {
	/**
	 * 获取脚本的SQL
	 * 
	 * @param judgeSingle
	 *            单值条件
	 * @return
	 */
	public String getSQL(JudgeSingle judgeSingle);
}
