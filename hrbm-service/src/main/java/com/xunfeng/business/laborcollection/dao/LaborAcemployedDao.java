package com.xunfeng.business.laborcollection.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.laborcollection.model.LaborAcemployed;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 未就业及失业情况信息表 Dao类
* @author:wangyanyan
* @createDate 2016-06-08 10:51:17 
* @version V1.0   
*/
@Repository
public class LaborAcemployedDao extends BaseDao<LaborAcemployed>
{
	@Override
	public Class<?> getEntityClass()
	{
		return LaborAcemployed.class;
	}

}