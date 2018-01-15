package com.xunfeng.business.dissupport.jobmatch.interf;


import java.util.Map;

import com.xunfeng.business.dissupport.jobmatch.model.PersonJobRecommend;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 求职推荐匹配表 接口类
* @author:wanghan
* @createDate 2016-08-15 20:00:42 
* @version V1.0   
*/
public interface PersonJobRecommendServiceInterf extends GenericServiceInterface<PersonJobRecommend,Long>
{
	/**
	 * 判断是否已推荐过
	 * @param acb210 招聘空位编号
	 * @param acc200 求职登记编号
	 * @return 返回结果
	 */
	public boolean isExists(Long acb210,Long acc200);
	
	/**
	 * 获取最大ID
	 * @return
	 */
	public Long getMaxId();
	
	/**
	 * 查询岗位详情
	 * @param queryFilter 检索条件
	 * @return 职位详情
	 */
	public Map<String,Object> getCorpPostionView(QueryFilter queryFilter);
}
