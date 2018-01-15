package com.xunfeng.business.ovemp.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.ovemp.corp.model.OvempCorpType;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构类型表 Dao类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:02 
* @version V1.0   
*/
@Repository
public class OvempCorpTypeDao extends BaseDao<OvempCorpType>
{
	@Override
	public Class<?> getEntityClass()
	{
		return OvempCorpType.class;
	}

}