package com.xunfeng.business.ovemp.cooporg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.business.ovemp.cooporg.model.OvempCoopOrg;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: JW_COOP_ORG Dao类
* @author:wanghan
* @createDate 2016-09-12 14:54:09 
* @version V1.0   
*/
@Repository
public class OvempCoopOrgDao extends BaseDao<OvempCoopOrg>
{
	@Override
	public Class<?> getEntityClass()
	{
		return OvempCoopOrg.class;
	}
	
	/**
	 * 查询子级机构
	 * @param acd200
	 * @return
	 */
	public List<OvempCoopOrg> getSubOrgans(Long acd200) {
		return this.getBySqlKey("getSubOrgs", acd200);
	}
}