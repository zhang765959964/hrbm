package com.xunfeng.business.person.dao;

import com.xunfeng.business.person.model.CorpBlackList;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 屏蔽单位 Dao类
* @author:wanghan
* @createDate 2015-07-23 14:48:15 
* @version V1.0   
*/
@Repository
public class CorpBlackListDao extends BaseDao<CorpBlackList>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpBlackList.class;
	}

}