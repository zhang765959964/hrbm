package com.xunfeng.business.personagency.receive.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.receive.model.ProxyManual;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 代理手册表 Dao类
* @author:jx
* @createDate 2016-07-07 09:37:15 
* @version V1.0   
*/
@Repository
public class ProxyManualDao extends BaseDao<ProxyManual>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ProxyManual.class;
	}
	public List<Map>  getAllProxyManual(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllProxyManual",fiter);		
		return dataList;
	}
}