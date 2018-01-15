package com.xunfeng.business.personagency.residence.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.residence.model.Residence;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口材料表 Dao类
* @author:jiangxin
* @createDate 2016-08-26 11:46:18 
* @version V1.0   
*/
@Repository
public class ResidenceDao extends BaseDao<Residence>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Residence.class;
	}
	public List<Map>  getAllResidence(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllResidence",fiter);		
		return dataList;
	}
}