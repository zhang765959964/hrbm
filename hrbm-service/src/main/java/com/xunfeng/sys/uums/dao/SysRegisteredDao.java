package com.xunfeng.sys.uums.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.uums.model.SysRegistered;
/**
 *<pre>
 * 对象功能:用户信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:jiangxin
 * 创建时间:2015-05-23 08:56:37
 *</pre>
 */
@Repository
public class SysRegisteredDao extends BaseDao<SysRegistered>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysRegistered.class;
	}

}