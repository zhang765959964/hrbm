package com.xunfeng.business.personagency.unitagreement.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.personagency.unitagreement.dto.UnitAgreementDto;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位协议表 接口类
* @author:zhangfan
* @createDate 2016-07-06 12:11:01 
* @version V1.0   
*/
public interface UnitAgreementServiceInterf extends GenericServiceInterface<UnitAgreement,Long>
{
	
	/**
	 * 取得单位协议查询信息
	 **/
	public List<UnitAgreement> getAllCorpUnit(QueryFilter queryFilter);
	
	
	/**
	 * 根据单位名称查询基本信息
	 * @param corpName
	 * @return
	 */
	public UnitAgreement getCorpByCorpName(String aab004);
	
	
	/**
	 * 根据id查询单位基本信息
	 * @param 
	 * @return
	 */
	public List<UnitAgreement> getByCorpId(Long aab001);
	
	
	
	public ResultData getAllByFilter(QueryFilter fiter);	
	
	/**
	 * 查询单位协议列表
	 * @param fiter
	 * @return
	 */
	public ResultData getUnitAgreementList(QueryFilter fiter);
	
	
	
	/**
	 * 保存更新单位协议信息
	 * @param unitAgreementDto
	 */
	 public void saveOrUpdate(UnitAgreementDto unitAgreementDto);
	 
	 /**
	  * 根据单位id查询 单位基本信息
	  * @param aab001
	  * @return
	  */
	 public UnitAgreement getByCoryId(Long aab001);
	 
	 
	 /**
	  * 查询单位协议编号
	  * @param uaNo
	  * @return
	  */
	 public Long getByUnitNo(String uaNo); 
	 
	 public ResultData getAllCorp(QueryFilter fiter);
	 
	 /**
	  * 根据协议签订状态返回 单位id 单位名称 单位营业号
	  * @param Status
	  * @return
	  */
	 public ResultData getByUnitStatus(QueryFilter fiter);
	 
}
