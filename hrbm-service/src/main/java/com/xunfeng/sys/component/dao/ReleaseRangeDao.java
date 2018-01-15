package com.xunfeng.sys.component.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.component.model.ReleaseRange;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职位与信息方式对应关系表 Dao类
* @author:wanghan
* @createDate 2016-06-12 10:30:25 
* @version V1.0   
*/
@Repository
public class ReleaseRangeDao extends BaseDao<ReleaseRange>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ReleaseRange.class;
	}

}