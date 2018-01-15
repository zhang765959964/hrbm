package com.xunfeng.business.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.corp.model.CorpEnter;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位进场招聘表 Dao类
* @author:wanghan
* @createDate 2016-04-14 09:11:39 
* @version V1.0   
*/
@Repository
public class CorpEnterDao extends BaseDao<CorpEnter>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpEnter.class;
	}

}