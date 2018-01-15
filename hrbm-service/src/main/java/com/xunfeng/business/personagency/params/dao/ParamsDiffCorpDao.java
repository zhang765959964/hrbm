package com.xunfeng.business.personagency.params.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.params.model.ParamsDiffCorp;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 困难企业 Dao类
* @author:wanghan
* @createDate 2016-09-07 10:22:54 
* @version V1.0   
*/
@Repository
public class ParamsDiffCorpDao extends BaseDao<ParamsDiffCorp>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ParamsDiffCorp.class;
	}

}