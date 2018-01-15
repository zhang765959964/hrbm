package com.xunfeng.sys.setMeal.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.setMeal.model.FeeServCfg;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 服务细项表 Dao类
* @author:wangyanyan
* @createDate 2016-07-19 09:11:01 
* @version V1.0   
*/
@Repository
public class FeeServCfgDao extends BaseDao<FeeServCfg>
{
	@Override
	public Class<?> getEntityClass()
	{
		return FeeServCfg.class;
	}

}