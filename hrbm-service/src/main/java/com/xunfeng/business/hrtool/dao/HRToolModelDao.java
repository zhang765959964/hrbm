package com.xunfeng.business.hrtool.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.hrtool.model.HRToolModel;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: hr工具箱模板表 Dao类
* @author:wanghan
* @createDate 2016-03-08 17:26:01 
* @version V1.0   
*/
@Repository
public class HRToolModelDao extends BaseDao<HRToolModel>
{
	@Override
	public Class<?> getEntityClass()
	{
		return HRToolModel.class;
	}

}