package com.xunfeng.business.careertalk.dao;

import com.xunfeng.business.careertalk.model.CareerRoom;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会教室 Dao类
* @author:zhouhang
* @createDate 2015-09-21 09:49:15 
* @version V1.0   
*/
@Repository
public class CareerRoomDao extends BaseDao<CareerRoom>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CareerRoom.class;
	}

}