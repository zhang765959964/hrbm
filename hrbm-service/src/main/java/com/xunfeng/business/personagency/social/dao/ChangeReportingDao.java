package com.xunfeng.business.personagency.social.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.social.model.ChangeReporting;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保变更申报记录表 Dao类
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
@Repository
public class ChangeReportingDao extends BaseDao<ChangeReporting>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ChangeReporting.class;
	}

}