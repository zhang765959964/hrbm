package com.xunfeng.business.personagency.retired.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.retired.model.RetiredXh;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休序号历史记录表 Dao类
* @author:zhangfan
* @createDate 2016-11-29 17:11:56 
* @version V1.0   
*/
@Repository
public class RetiredXhDao extends BaseDao<RetiredXh>
{
	@Override
	public Class<?> getEntityClass()
	{
		return RetiredXh.class;
	}
	
	/**
	 * 根据type 类型返回最小值
	 * @param type
	 * @return
	 */
	public RetiredXh getByRetiredType(String type){
		Map params = new HashMap<String,String>();
		params.put("type", type);
		return this.getUnique("getByRetiredType", params);
		
	}
	
	
	/**
	 * 根据退休类型和时间获得当前最小的历史记录信息 
	 * @param type 类型
	 * @param bm   退休编码
	 * @return
	 */
	public RetiredXh getByRetiredTypeOrBm(String type,String bm){
		Map params = new HashMap<String,String>();
		params.put("type", type);
		params.put("bm",bm+"%");
		return this.getUnique("getByRetiredTypeOrBm", params);
		
	}
	
	
	
	/**
	 * 根据退休个人编码删除数据
	 * @param bm
	 */
	public void delByBm(String bm){
		this.delBySqlKey("delByBm", bm);
	}
	
}