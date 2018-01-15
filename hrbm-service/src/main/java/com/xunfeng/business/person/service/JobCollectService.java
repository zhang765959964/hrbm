package com.xunfeng.business.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.JobCollectDao;
import com.xunfeng.business.person.interf.JobCollectServiceInterf;
import com.xunfeng.business.person.model.JobCollect;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:个人职位收藏夹 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:01:28
 *</pre>
 */
@Service
public class JobCollectService extends BaseService<JobCollect>  implements JobCollectServiceInterf
{
	@Resource
	private JobCollectDao dao;
	
	public JobCollectService()
	{
	}
	
	@Override
	protected IEntityDao<JobCollect, Long> getEntityDao()
	{
		return dao;
	}

	public ResultData<Map>  getJobCollectList(QueryFilter queryFilter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setDataList(dao.getListForm("getJobCollectList",queryFilter));
		resultData.setPageBean(queryFilter.getPageBean());
		return resultData;	
	}
	public boolean isCollect(Long acb210,long ccmu01){
        Map  map =new HashMap();
		map.put("acb210",acb210);
		map.put("ccmu01",ccmu01);
		List collectList=dao.getListBySqlKey("getAll",map);
		return collectList!=null&&collectList.size()>0?true:false;

	}
	public void delByjobidAndUserid(Long acb210,long ccmu01){
		Map  map =new HashMap();
		map.put("acb210",acb210);
		map.put("ccmu01",ccmu01);
		dao.delBySqlKey("delByjobidAndUserid", map);
	}
	
	/**
	 * 通过账户id获得收藏的职位总数
	 */
	public Long getTotalJobCollect(Long ccmu01){
		return (Long) dao.getOne("getTotalJobCollect", ccmu01);
	}
	
	
}
