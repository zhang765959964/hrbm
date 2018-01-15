package com.xunfeng.business.personagency.affair.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.affair.model.TitleDeclaration;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职称申报评定表 Dao类
* @author:jiangxin
* @createDate 2016-09-18 15:38:07 
* @version V1.0   
*/
@Repository
public class TitleDeclarationDao extends BaseDao<TitleDeclaration>
{
	@Override
	public Class<?> getEntityClass()
	{
		return TitleDeclaration.class;
	}
	public List<Map>  getAllTitleDeclaration(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllTitleDeclaration",fiter);		
		return dataList;
	}
}