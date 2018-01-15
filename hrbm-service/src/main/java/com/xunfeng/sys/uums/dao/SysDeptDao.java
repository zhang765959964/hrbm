package com.xunfeng.sys.uums.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.uums.model.SysDept;
/**
 *<pre>
 * 对象功能:科室表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-30 09:51:03
 *</pre>
 */
@Repository
public class SysDeptDao extends BaseDao<SysDept>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysDept.class;
	}

}