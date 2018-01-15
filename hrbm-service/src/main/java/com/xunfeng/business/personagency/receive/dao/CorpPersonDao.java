package com.xunfeng.business.personagency.receive.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.receive.model.CorpPerson;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位人员关系表 Dao类
* @author:wanghan
* @createDate 2016-08-09 09:11:37 
* @version V1.0   
*/
@Repository
public class CorpPersonDao extends BaseDao<CorpPerson>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpPerson.class;
	}

}