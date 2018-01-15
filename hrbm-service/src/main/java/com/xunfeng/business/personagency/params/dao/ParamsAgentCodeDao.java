package com.xunfeng.business.personagency.params.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.params.model.ParamsAgentCode;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 劳动代理代码维护 Dao类
* @author:wanghan
* @createDate 2016-09-07 10:24:17 
* @version V1.0   
*/
@Repository
public class ParamsAgentCodeDao extends BaseDao<ParamsAgentCode>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ParamsAgentCode.class;
	}

}