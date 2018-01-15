package com.xunfeng.business.personagency.params.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.params.model.ParamsMonthBase;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 月缴费基数 Dao类
* @author:wanghan
* @createDate 2016-09-07 09:23:00 
* @version V1.0   
*/
@Repository
public class ParamsMonthBaseDao extends BaseDao<ParamsMonthBase>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ParamsMonthBase.class;
	}

}