package com.xunfeng.business.dissupport.divice.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.dissupport.divice.model.DiviceModel;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 型号表 Dao类
* @author:wanghan
* @createDate 2016-07-27 17:03:37 
* @version V1.0   
*/
@Repository
public class DiviceModelDao extends BaseDao<DiviceModel>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DiviceModel.class;
	}

}