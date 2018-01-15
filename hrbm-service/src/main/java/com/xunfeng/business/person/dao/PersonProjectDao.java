package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.PersonProject;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 项目经验表 Dao类
* @author:wanghan
* @createDate 2015-07-22 11:18:06 
* @version V1.0   
*/
@Repository
public class PersonProjectDao extends BaseDao<PersonProject>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonProject.class;
	}

}