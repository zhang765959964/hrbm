package com.xunfeng.business.personagency.unitagreement.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.unitagreement.dao.UnitAgreementDao;
import com.xunfeng.business.personagency.unitagreement.dto.UnitAgreementDto;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位协议表 Service类
* @author:zhangfan
* @createDate 2016-07-06 12:11:01 
* @version V1.0   
*/
@Service
public class UnitAgreementService extends BaseService<UnitAgreement> implements UnitAgreementServiceInterf
{
	@Resource
	private UnitAgreementDao dao;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	@Resource
	CorpService corpService;
	
	
	public UnitAgreementService()
	{
	}
	
	@Override
	protected IEntityDao<UnitAgreement, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public List<UnitAgreement> getAllCorpUnit(QueryFilter queryFilter) {
		
		return  dao.getListForm("getAllCorpUnit", queryFilter);
	}

	@Override
	public UnitAgreement getCorpByCorpName(String aab004) {
		
		return dao.getCorpByCorpName(aab004);
	}              

	@Override
	public List<UnitAgreement> getByCorpId(Long aab001) {
		return dao.getByCopyId(aab001);
	}
	
	@Override
	public UnitAgreement getByCoryId(Long aab001) {
		return dao.getCopyById(aab001);
	}
	
	public ResultData getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<UnitAgreement> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public void saveOrUpdate(UnitAgreementDto unitAgreementDto) {
		Corp corp = corpService.getById(unitAgreementDto.getAab001());	//获得单位信息
		corp= BeanToBean.copyProperties(unitAgreementDto, corp, false);	
		UnitAgreement unitAgreement = this.getByCoryId(unitAgreementDto.getAab001());	//获得单位协议基本信息
		Long uaStatus = -1L;
		
		if(unitAgreement!=null){
			Long id = unitAgreement.getId();
			UnitAgreement uu =  this.getById(id);
			uaStatus = uu.getUaStatus();
			unitAgreement= BeanToBean.copyProperties(unitAgreementDto, unitAgreement, false);
			Corp c = corpService.getById(unitAgreementDto.getAab001());
			c.setAab001(unitAgreementDto.getAab001());
			c.setAab004(unitAgreementDto.getAab004());
			c.setAab007(unitAgreementDto.getAab007());
			c.setAab019(unitAgreementDto.getAab019());
			c.setAae006(unitAgreementDto.getAae006());
			c.setAab020(unitAgreementDto.getAab020());
			c.setAaa021(unitAgreementDto.getAaa021());
			corpService.update(c);
			uu.setUaStopCause(unitAgreementDto.getUaStopCause());	//终止原因
			uu.setUaStopEndtime(new Date());
			if(uaStatus==1){
				uu.setUaStatus(0L); 	//终止状态   
				uu.setStopId(null);
				uu.setStopName("");
				uu.setStopOrgId(null);
				uu.setStopOrgName("");
				uu.setStopDatexx(null);
				uu.setStopDate(null);
				uu.setCreaterDate(new Date());
				uu.setUaNo(unitAgreementDto.getUaNo());	//单位协议编号
				uu.setUaCreatetime(unitAgreementDto.getUaCreatetime());	//协议签订日期
				uu.setUaName(unitAgreementDto.getUaName());	//单位联系人
				uu.setUaPhone(unitAgreementDto.getUaPhone());	//联系电话
				uu.setUaIsFree(unitAgreementDto.getUaIsFree());	//是否免费
				uu.setUaCard(unitAgreementDto.getUaCard());	//办理人身份证号
				uu.setUaContent(unitAgreementDto.getUaContent());	//协议主要内容
				uu.setUaNote(unitAgreementDto.getUaNote());	//备注
			}else{
				uu.setUaStatus(1L);
				uu.setStopId(unitAgreementDto.getCreaterId());
				uu.setStopName(unitAgreementDto.getCreaterName());
				uu.setStopOrgId(unitAgreementDto.getCreaterOrgId());
				uu.setStopOrgName(unitAgreementDto.getCreaterOrgName());
				uu.setStopDatexx(new Date());
				uu.setStopDate(unitAgreementDto.getStopDate());
			}
			
			
			uu.setCreaterId(unitAgreementDto.getCreaterId());
			uu.setCreaterName(unitAgreementDto.getCreaterName());
			uu.setCreaterOrgId(unitAgreementDto.getCreaterOrgId());
			uu.setCreaterOrgName(unitAgreementDto.getCreaterOrgName());
			
			
		    this.update(uu);
			
		}else{
			
			Corp c = corpService.getById(unitAgreementDto.getAab001());
			corp.setAab001(unitAgreementDto.getAab001());
			corp.setAab004(unitAgreementDto.getAab004());
			corp.setAab007(unitAgreementDto.getAab007());
			corp.setAab019(unitAgreementDto.getAab019());
			corp.setAae006(unitAgreementDto.getAae006());
			corp.setAab020(unitAgreementDto.getAab020());
			corp.setAaa021(unitAgreementDto.getAaa021());
			corpService.update(c);
			
			unitAgreement = new UnitAgreement();
			unitAgreement= BeanToBean.copyProperties(unitAgreementDto, unitAgreement, false);
			unitAgreement.setId(uniqueIdUtilService.genId(UnitAgreement.class.getName()));
			unitAgreement.setUaUnitId(unitAgreementDto.getAab001());
			unitAgreement.setUaStatus(0L);
		    this.add(unitAgreement);
		   
			
		}
		
	}
	
	
	
	
	@Override
	public Long getByUnitNo(String uaNo) {
		return dao.getByUnitNo(uaNo);
	}
	public ResultData getAllCorp(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List dataList=dao.getAllCorp(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public ResultData getByUnitStatus(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getByUnitStatus(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public ResultData getUnitAgreementList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList= dao.getBySqlKey("getUnitAgreementList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
		
	
}
