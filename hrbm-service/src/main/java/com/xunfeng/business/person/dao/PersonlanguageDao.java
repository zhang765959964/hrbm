package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.Personlanguage;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 语言能力表 Dao类
* @author:wanghan
* @createDate 2015-07-22 11:17:52 
* @version V1.0   
*/
@Repository
public class PersonlanguageDao extends BaseDao<Personlanguage>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Personlanguage.class;
	}

}