package com.xunfeng.business.person.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.person.model.PersonJobLetters;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: PERSON_JOB_LETTERS Dao类
* @author:wanghan
* @createDate 2015-12-03 14:49:46 
* @version V1.0   
*/
@Repository
public class PersonJobLettersDao extends BaseDao<PersonJobLetters>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonJobLetters.class;
	}

}