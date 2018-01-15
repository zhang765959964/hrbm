package com.xunfeng.sys.component.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.component.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 举办城市代码表 Dao类
* @author:wxl
* @createDate 2015-07-31 14:48:55 
* @version V1.0   
*/
@Repository
public class CityComponentDao extends BaseDao<City>
{
	@Override
	public Class<?> getEntityClass()
	{
		return City.class;
	}
	//根据父元素获取
	public List<City> getByPid(Long pId){
		return this.getBySqlKey("getByPid",pId);
	}

	//根据Code获取城市
	public City getByCode(String code){
		return this.getUnique("getByCode",code);
	}
}