package com.xunfeng.sys.dictionary.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.dictionary.model.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员类别表 Dao类
* @author:wxl
* @createDate 2015-08-10 16:44:29 
* @version V1.0   
*/
@Repository
public class DictionaryDao extends BaseDao<Dictionary>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Dictionary.class;
	}

	public List<Dictionary> getByTableName(String tableName){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("tableName",tableName);
		return this.getListBySqlKey("getByTableName",params);
	}
}