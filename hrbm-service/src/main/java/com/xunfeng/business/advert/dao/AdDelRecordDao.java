package com.xunfeng.business.advert.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.advert.model.AdDelRecord;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告删除记录表 Dao类
* @author:
* @createDate 2016-08-03 10:35:28 
* @version V1.0   
*/
@Repository
public class AdDelRecordDao extends BaseDao<AdDelRecord>
{
	@Override
	public Class<?> getEntityClass()
	{
		return AdDelRecord.class;
	}
	
}