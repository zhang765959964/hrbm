package com.xunfeng.business.personagency.residence.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.residence.model.Residence;
import com.xunfeng.business.personagency.residence.model.ResidenceMoveOut;
import com.xunfeng.business.personagency.residence.dao.ResidenceMoveOutDao;
import com.xunfeng.business.personagency.residence.interf.ResidenceMoveOutServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口迁入迁出表 Service类
* @author:jiangxin
* @createDate 2016-08-27 15:36:07 
* @version V1.0   
*/
@Service
public class ResidenceMoveOutService extends BaseService<ResidenceMoveOut> implements ResidenceMoveOutServiceInterf
{
	@Resource
	private ResidenceMoveOutDao dao;
	
	
	
	public ResidenceMoveOutService()
	{
	}
	
	@Override
	protected IEntityDao<ResidenceMoveOut, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ResidenceMoveOut> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ResidenceMoveOut> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//查询所有户口迁入数据
	public ResultData getAllResidenceMoveOut(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllResidenceMoveOut(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//删除户口迁入迁移信息
	public void deleteResidenceMoveOutByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			ResidenceMoveOut residenceMoveOut = dao.getById(id);
			residenceMoveOut.setCcpr08("1");
			dao.update(residenceMoveOut);
		}
	}
	//查询户口迁入迁移条数
	public Long getTotalResidenceMoveOut(String residenceStatus){
		Map params = new HashMap();
		if(!"0".equals(residenceStatus)){
			params.put("residenceStatus",residenceStatus);
		}
		params.put("ccpr08",0);
		return (Long)dao.getOne("getTotalResidenceMoveOut", params);
	}
	
}
