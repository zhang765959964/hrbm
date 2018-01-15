package com.xunfeng.sys.uums.interf;
import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysDept;

/**
 *<pre>
 * 对象功能:科室表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-30 09:51:03
 *</pre>
 */

public interface SysDeptServiceInterf extends GenericServiceInterface<SysDept,Long>
{

	@SuppressWarnings("rawtypes")
	public void update(Map dataMap,SysDept sysDept);
	
	/**
	 * 分页数据获取
	 * @param queryFilter 检索条件
	 * @return 分页数据返回
	 */
	public ResultData<SysDept> getDepPageList(QueryFilter queryFilter);
	
}
