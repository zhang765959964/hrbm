package com.xunfeng.business.personagency.params.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.params.model.ParamsAccountsCorp;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 账号与市场关联维护 Dao类
* @author:wanghan
* @createDate 2016-09-07 10:24:43 
* @version V1.0   
*/
@Repository
public class ParamsAccountsCorpDao extends BaseDao<ParamsAccountsCorp>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ParamsAccountsCorp.class;
	}

}