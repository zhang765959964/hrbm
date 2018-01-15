package com.xunfeng.sys.uums.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.uums.model.SysOrg;
/**
 *<pre>
 * 对象功能:职介机构表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-29 16:03:27
 *</pre>
 */
@Repository
public class SysOrgDao extends BaseDao<SysOrg>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SysOrg.class;
	}

	/**
	 * 查询子级机构
	 * @param acd200
	 * @return
	 */
	public List<SysOrg> getSubOrgans(Long acd200) {
		return this.getBySqlKey("getSubOrgs", acd200);
	}

}