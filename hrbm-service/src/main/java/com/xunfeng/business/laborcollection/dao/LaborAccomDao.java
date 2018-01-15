package com.xunfeng.business.laborcollection.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.laborcollection.model.LaborAccom;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 就业情况信息表 Dao类
* @author:wangyanyan
* @createDate 2016-06-08 10:47:45 
* @version V1.0   
*/
@Repository
public class LaborAccomDao extends BaseDao<LaborAccom>
{
	@Override
	public Class<?> getEntityClass()
	{
		return LaborAccom.class;
	}

}