package com.xunfeng.business.ovemp.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.ovemp.corp.model.OvempCorp;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
@Repository
public class OvempCorpOrgDao extends BaseDao<OvempCorp>
{
	@Override
	public Class<?> getEntityClass()
	{
		return OvempCorp.class;
	}

}