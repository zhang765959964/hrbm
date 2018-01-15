package com.xunfeng.business.dissupport.divice.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.dissupport.divice.model.Divice;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备表 Dao类
* @author:wanghan
* @createDate 2016-07-27 17:06:00 
* @version V1.0   
*/
@Repository
public class DiviceDao extends BaseDao<Divice>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Divice.class;
	}

}