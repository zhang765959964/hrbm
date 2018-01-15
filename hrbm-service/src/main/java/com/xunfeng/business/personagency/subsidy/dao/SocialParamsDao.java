package com.xunfeng.business.personagency.subsidy.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴参数 Dao类
* @author:wanghan
* @createDate 2016-07-07 10:26:13 
* @version V1.0   
*/
@Repository
public class SocialParamsDao extends BaseDao<SocialParams>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SocialParams.class;
	}

}