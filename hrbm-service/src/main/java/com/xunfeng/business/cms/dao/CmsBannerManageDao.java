package com.xunfeng.business.cms.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.cms.model.CmsBannerManage;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 栏目板块管理 比如快速栏目中的前十个信息名称 Dao类
* @author:wanghan
* @createDate 2016-03-22 16:46:24 
* @version V1.0   
*/
@Repository
public class CmsBannerManageDao extends BaseDao<CmsBannerManage>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CmsBannerManage.class;
	}

}