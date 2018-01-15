package com.xunfeng.business.personagency.retired.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.retired.model.RetiredPerson;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_RETIRED_PERSON Dao类
* @author:zhangfan
* @createDate 2016-08-02 17:12:13 
* @version V1.0   
*/
@Repository
public class RetiredPersonDao extends BaseDao<RetiredPerson>
{
	@Override
	public Class<?> getEntityClass()
	{
		return RetiredPerson.class;
	}

}