package com.xunfeng.business.person.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.person.model.PersonFamily;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员家庭关系表 Dao类
* @author:wanlupeng
* @createDate 2016-07-07 09:13:01 
* @version V1.0   
*/
@Repository
public class PersonFamilyDao extends BaseDao<PersonFamily>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonFamily.class;
	}

}