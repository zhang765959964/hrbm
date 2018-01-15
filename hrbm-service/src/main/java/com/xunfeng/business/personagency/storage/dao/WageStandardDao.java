package com.xunfeng.business.personagency.storage.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.storage.model.WageStandard;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工资标准表 Dao类
* @author:jiangxin
* @createDate 2016-08-17 11:06:20 
* @version V1.0   
*/
@Repository
public class WageStandardDao extends BaseDao<WageStandard>
{
	@Override
	public Class<?> getEntityClass()
	{
		return WageStandard.class;
	}

}