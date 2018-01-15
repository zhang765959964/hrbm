package com.xunfeng.business.personagency.residence.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.residence.model.ResidenceMoveOut;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口迁入迁出表 Dao类
* @author:jiangxin
* @createDate 2016-08-27 15:36:07 
* @version V1.0   
*/
@Repository
public class ResidenceMoveOutDao extends BaseDao<ResidenceMoveOut>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ResidenceMoveOut.class;
	}
	public List<Map>  getAllResidenceMoveOut(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllResidenceMoveOut",fiter);		
		return dataList;
	}
}