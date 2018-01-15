package com.xunfeng.business.personagency.archive.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.archive.model.Archives;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Dao类
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
@Repository
public class ArchivesDao extends BaseDao<Archives>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Archives.class;
	}
	public List<Map>  getAllArchives(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllArchives",fiter);		
		return dataList;
	}
	public List<Map>  getAllPersonArchives(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllPersonArchives",fiter);		
		return dataList;
	}
	public Map getArchivesByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getArchivesByPersonId", params);
	}
	public Map getReceiveArchivesByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getReceiveArchivesByPersonId", params);
	}
	public Map getStorageArchivesByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)this.getOne("getStorageArchivesByPersonId", params);
	}
	public Archives getArchivesByPId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return this.getUnique("getArchivesByPId", params);
	}
	public List<Map>  getCorpAllArchive(QueryFilter fiter){
		fiter.addFilter("dataSources", 1);
		List<Map> dataList = this.getListForm("getCorpAllArchive",fiter);		
		return dataList;
	}
	public Map getArchivesPersonByArchivesId(Long archivesId){
		Map params=new HashMap();
		params.put("id", archivesId);
		return (Map)this.getOne("getArchivesPersonByArchivesId", params);
	}
	public List<Map>  getAllArchivesCheckoutR(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllArchivesCheckoutR",fiter);		
		return dataList;
	}
}