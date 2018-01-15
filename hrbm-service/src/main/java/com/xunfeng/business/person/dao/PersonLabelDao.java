package com.xunfeng.business.person.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.person.model.PersonLabel;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 标签明细表 Dao类
* @author:wanghan
* @createDate 2016-03-31 14:57:08 
* @version V1.0   
*/
@Repository
public class PersonLabelDao extends BaseDao<PersonLabel>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonLabel.class;
	}

}