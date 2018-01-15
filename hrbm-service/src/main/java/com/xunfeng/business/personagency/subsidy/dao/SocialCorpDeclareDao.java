package com.xunfeng.business.personagency.subsidy.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.subsidy.model.SocialCorpDeclare;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位补贴申报 Dao类
* @author:wanghan
* @createDate 2016-07-14 15:38:33 
* @version V1.0   
*/
@Repository
public class SocialCorpDeclareDao extends BaseDao<SocialCorpDeclare>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SocialCorpDeclare.class;
	}

}