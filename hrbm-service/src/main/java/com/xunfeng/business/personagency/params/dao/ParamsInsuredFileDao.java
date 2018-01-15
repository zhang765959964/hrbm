package com.xunfeng.business.personagency.params.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.params.model.ParamsInsuredFile;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 参保文件 Dao类
* @author:wanghan
* @createDate 2016-09-07 10:23:40 
* @version V1.0   
*/
@Repository
public class ParamsInsuredFileDao extends BaseDao<ParamsInsuredFile>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ParamsInsuredFile.class;
	}

}