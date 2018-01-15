package com.xunfeng.business.personagency.archive.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 Dao类
* @author:jx
* @createDate 2016-07-12 10:08:55 
* @version V1.0   
*/
@Repository
public class ArchiveLendDao extends BaseDao<ArchiveLend>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ArchiveLend.class;
	}
	public List<Map>  getAllArchiveLend(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllArchiveLend",fiter);		
		return dataList;
	}
	public List<Map>  getAllArchiveLendSearch(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllArchiveLendSearch",fiter);		
		return dataList;
	}
}