package com.xunfeng.business.laborcollection.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.laborcollection.model.LaborAcpost;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 不在岗情况信息表 Dao类
* @author:wangyanyan
* @createDate 2016-06-24 09:46:09 
* @version V1.0   
*/
@Repository
public class LaborAcpostDao extends BaseDao<LaborAcpost>
{
	@Override
	public Class<?> getEntityClass()
	{
		return LaborAcpost.class;
	}

}