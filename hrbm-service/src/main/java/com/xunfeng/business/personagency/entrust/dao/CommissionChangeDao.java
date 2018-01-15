package com.xunfeng.business.personagency.entrust.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.entrust.model.CommissionChange;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 委托类型变更 Dao类
* @author:jiangxin
* @createDate 2016-08-22 14:48:20 
* @version V1.0   
*/
@Repository
public class CommissionChangeDao extends BaseDao<CommissionChange>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CommissionChange.class;
	}
	public List<Map>  getAllCommissionChange(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllCommissionChange",fiter);		
		return dataList;
	}
}