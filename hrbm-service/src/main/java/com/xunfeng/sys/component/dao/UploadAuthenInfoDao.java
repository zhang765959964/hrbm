package com.xunfeng.sys.component.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.component.model.UploadAuthenInfo;
import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Dao类
* @author:wxl
* @createDate 2015-07-23 17:10:45 
* @version V1.0   
*/
@Repository
public class UploadAuthenInfoDao extends BaseDao<UploadAuthenInfo>
{
	@Override
	public Class<?> getEntityClass()
	{
		return UploadAuthenInfo.class;
	}

}