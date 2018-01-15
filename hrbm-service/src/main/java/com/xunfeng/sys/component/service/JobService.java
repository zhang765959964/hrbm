package com.xunfeng.sys.component.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.component.dao.JobDao;
import com.xunfeng.sys.component.interf.JobServiceInter;
import com.xunfeng.sys.component.model.Job;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 工种自定义标准 Service类
* @author:wanghan
* @createDate 2015-09-23 15:34:24 
* @version V1.0   
*/
@Service
public class JobService extends BaseService<Job> implements JobServiceInter
{
	@Resource
	private JobDao dao;
	
	
	
	public JobService()
	{
	}
	
	@Override
	protected IEntityDao<Job, Long> getEntityDao() 
	{
		return dao;
	}
	
	public List<Job> getJobList(Long pId){
        Map param=new HashMap();
		param.put("pid",pId);
		return  dao.getBySqlKey("getAll",param);
	}
}
