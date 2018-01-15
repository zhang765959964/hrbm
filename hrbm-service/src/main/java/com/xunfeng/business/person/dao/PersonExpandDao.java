package com.xunfeng.business.person.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.person.model.PersonExpand;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息拓展表 Dao类
* @author:wanlupeng
* @createDate 2016-07-06 18:11:28 
* @version V1.0   
*/
@Repository
public class PersonExpandDao extends BaseDao<PersonExpand>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonExpand.class;
	}

}