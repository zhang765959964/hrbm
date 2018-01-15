package com.xunfeng.business.ovemp.common.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.ovemp.common.model.CommonModel;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: JW_COOP_ORG Dao类
* @author:wanghan
* @createDate 2016-09-12 11:06:38 
* @version V1.0   
*/
@Repository
public class CommonModelDao extends BaseDao<CommonModel>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CommonModel.class;
	}

}