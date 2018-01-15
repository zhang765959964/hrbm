package com.xunfeng.business.personagency.residence.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.residence.model.ResidenceReturn;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口借用归还表 Dao类
* @author:jiangxin
* @createDate 2016-08-30 09:58:41 
* @version V1.0   
*/
@Repository
public class ResidenceReturnDao extends BaseDao<ResidenceReturn>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ResidenceReturn.class;
	}

}