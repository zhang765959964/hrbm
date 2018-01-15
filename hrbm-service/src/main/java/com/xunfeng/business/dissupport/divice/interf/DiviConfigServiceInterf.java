package com.xunfeng.business.dissupport.divice.interf;


import java.util.Map;

import com.xunfeng.business.dissupport.divice.model.DiviConfig;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备配置表 接口类
* @author:wanghan
* @createDate 2016-07-28 15:30:48 
* @version V1.0   
*/
public interface DiviConfigServiceInterf extends GenericServiceInterface<DiviConfig,Long>
{
	/**
	 * 获取视图查询列表
	 * @param queryFilter
	 * @return
	 */
	public ResultData<Map<String, Object>> getViewList(
				QueryFilter queryFilter);
	/**
	 * 获取职位检索列表查询
	 * @param queryFilter
	 * @return
	 */
	public ResultData<Map<String, Object>> getPostionViewList(
				QueryFilter queryFilter);
}
