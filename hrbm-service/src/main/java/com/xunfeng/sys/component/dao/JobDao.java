package com.xunfeng.sys.component.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.component.model.Job;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工种自定义标准 Dao类
* @author:wanghan
* @createDate 2015-09-23 15:34:24 
* @version V1.0   
*/
@Repository
public class JobDao extends BaseDao<Job>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Job.class;
	}

}