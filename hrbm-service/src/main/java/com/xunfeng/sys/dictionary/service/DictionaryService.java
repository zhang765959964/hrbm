package com.xunfeng.sys.dictionary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.sys.dictionary.dao.DictionaryDao;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.dictionary.model.Dictionary;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 人员类别表 Service类
* @author:wxl
* @createDate 2015-08-10 16:44:29 
* @version V1.0   
*/
@Service
public class DictionaryService extends BaseService<Dictionary> implements  DictionaryServiceInterf
{
	@Resource
	private DictionaryDao dao;



	@Autowired
	@Qualifier(value = "jdbcTemplate")
	JdbcTemplate jdbcTemp;
	public DictionaryService()
	{
	}
	
	@Override
	protected IEntityDao<Dictionary, Long> getEntityDao()
	{
		return dao;
	}

	public List<Dictionary> getByTableName(String tableName){
		return dao.getByTableName(tableName);
	}

	public List<Map<String ,Object>> getTabList(String tableName,String  sqlCondi){
		sqlCondi=StringUtils.isNotBlank(sqlCondi)?" where "+sqlCondi:"";
		String sql=" select code,name from " +tableName +sqlCondi;
		List<Map<String ,Object>> list=jdbcTemp.queryForList(sql);
		return  list;

	}
	
	public List<Map<String ,Object>> getTabList(String valueField,String textField,String tableName,String  sqlCondi){
		sqlCondi=StringUtils.isNotBlank(sqlCondi)?" where "+sqlCondi:"";
		String sql=" select "+valueField+" as valueField," + textField+" as textField  from " +tableName +sqlCondi;
		List<Map<String ,Object>> list=jdbcTemp.queryForList(sql);
		return  list;

	}
	
	/**
	 * 缓存获取字典map
	 * @param tabName 字典表名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> getCacheTabMap(String tabName){
		Object obj =  EhcacheUtil.getInstance().get("dictionary.cache", tabName);
		List<Map<String ,Object>> maps = null;
		if(obj==null){
			maps = 	this.getTabList(tabName,null);
			EhcacheUtil.getInstance().put("dictionary.cache", tabName, maps);
		}else{
			maps = (List<Map<String, Object>>) obj;
		}
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		for (Map<String, Object> map : maps) {
			retMap.put(String.valueOf(map.get("CODE")), map.get("NAME"));
		}
		return retMap;
	};
	
	/**
	 * 缓存获取字典List
	 * @param tabName 字典表名称
	 * @return
	 */
	public List<Map<String,Object>> getCacheTabList(String tabName){
		@SuppressWarnings("unchecked")
		List<Map<String ,Object>> maps = (List<Map<String, Object>>) EhcacheUtil.getInstance().get("dictionary.cache", tabName);
		if(maps==null){
			maps = this.getTabList(tabName,null);
		}
		EhcacheUtil.getInstance().put("dictionary.cache", tabName, maps);
		return maps;
	};
	/**
	 *查询所有的行业信息（TAB_INDUSTRY）
	 */
	public List<Dictionary> getIndustry(){
		return dao.getBySqlKey("getIndustry");
	};

}
