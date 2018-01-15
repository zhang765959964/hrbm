package com.xunfeng.business.careertalk.dao;

import com.xunfeng.business.careertalk.model.CareerTalk;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会 Dao类
* @author:zhouhang
* @createDate 2015-09-22 18:18:47 
* @version V1.0   
*/
@Repository
public class CareerTalkDao extends BaseDao<CareerTalk>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CareerTalk.class;
	}
}