package com.xunfeng.business.personagency.unitagreement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位协议表 Dao类
* @author:zhangfan
* @createDate 2016-07-06 12:11:01 
* @version V1.0   
*/
@Repository
public class UnitAgreementDao extends BaseDao<UnitAgreement>
{
	@Override
	public Class<?> getEntityClass()
	{
		return UnitAgreement.class;
	}
	
	
	/**
	 * 根据单位名称获得单位基本信息
	 */
	public UnitAgreement getCorpByCorpName(String aab004){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab004", aab004);
		return (UnitAgreement) this.getOne("getByCorpName", map);
	}

	
	/**
	 * @param 根据单位id返回单位信息
	 * @return
	 */
	public List<UnitAgreement> getByCopyId(Long aab001){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab001", aab001);
		return this.getList("getByCopyId", map);
	}
	
	
	/**
	 * 根据单位id 单位签订信息
	 * @param aab001
	 * @return
	 */
	public UnitAgreement getCopyById(Long aab001){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab001", aab001);
		return (UnitAgreement) this.getOne("getByCopyId", map);
		
	}
	
	/**
	 * 查询单位协议编号是否重复
	 * @param uaNo 单位协议编号
	 * @return
	 */
	public Long getByUnitNo(String uaNo){
		return (Long) this.getOne("getByUnitNo", uaNo);
	}
	
	public List<Map>  getAllCorp(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllCorp",fiter);		
		return dataList;
	}
	
	
	/**
	 * 根据单位协议签订状态返回 单位id 单位名称 单位营业号
	 * @param status
	 * @return
	 */
	public  List<Map> getByUnitStatus(QueryFilter fiter){
		return  this.getListForm("getByUnitStatus", fiter);
	}
	
	
}