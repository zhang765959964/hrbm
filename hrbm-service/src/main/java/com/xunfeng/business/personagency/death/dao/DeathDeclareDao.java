package com.xunfeng.business.personagency.death.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.death.model.DeathDeclare;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 死亡待遇申报 Dao类
* @author:zhangfan
* @createDate 2016-08-26 16:25:11 
* @version V1.0   
*/
@Repository
public class DeathDeclareDao extends BaseDao<DeathDeclare>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DeathDeclare.class;
	}

	/**
	 * 根据人员id和档案编号获得死亡待遇申请信息
	 * @param filter
	 * @return
	 */
	public List<Map> getByPersonIdOraArchiveCode(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getByPersonIdOraArchiveCode", fiter);
		return dataList;
	}
	
	/**
	 * 根据人员id删除死忙
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
	}
	
	public Map getPrintDeathList(String personIds){
		return (Map)this.getOne("getPrintDeathList", personIds);
		
	}
	
}