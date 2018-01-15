package com.xunfeng.business.personagency.archive.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.archive.model.ArchiveLendExp;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出拓展表 Dao类
* @author:jiangxin
* @createDate 2016-12-26 11:21:59 
* @version V1.0   
*/
@Repository
public class ArchiveLendExpDao extends BaseDao<ArchiveLendExp>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ArchiveLendExp.class;
	}

}