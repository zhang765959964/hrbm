package com.xunfeng.business.person.interf;

import java.util.Map;

import com.xunfeng.business.person.model.JobCollect;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:个人职位收藏夹 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:28
 *</pre>
 */
public interface JobCollectServiceInterf  extends GenericServiceInterface<JobCollect,Long>
{

	public ResultData<Map>  getJobCollectList(QueryFilter queryFilter);
	/**
	 * 通过账户id和职位id判断是否有收藏的职位
	 */
	public boolean isCollect(Long acb210,long ccmu01);
	/**
	 * 通过账户id和职位id删除收藏的职位
	 */
	public void delByjobidAndUserid(Long acb210,long ccmu01);
	/**
	 * 通过账户id获得收藏的职位总数
	 */
	public Long getTotalJobCollect(Long ccmu01);
}
