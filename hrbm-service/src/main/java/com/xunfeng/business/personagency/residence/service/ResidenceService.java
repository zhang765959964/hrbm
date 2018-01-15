package com.xunfeng.business.personagency.residence.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.business.personagency.residence.model.Residence;
import com.xunfeng.business.personagency.residence.dao.ResidenceDao;
import com.xunfeng.business.personagency.residence.interf.ResidenceServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口材料表 Service类
* @author:jiangxin
* @createDate 2016-08-26 11:46:18 
* @version V1.0   
*/
@Service
public class ResidenceService extends BaseService<Residence> implements ResidenceServiceInterf
{
	@Resource
	private ResidenceDao dao;
	
	
	
	public ResidenceService()
	{
	}
	
	@Override
	protected IEntityDao<Residence, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<Residence> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Residence> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	//查询所有户口材料数据
	public ResultData getAllResidence(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllResidence(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//删除户口材料信息
	public void deleteResidenceByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			Residence residence = dao.getById(id);
			residence.setCcpr08("1");
			dao.update(residence);
		}
	}
}
