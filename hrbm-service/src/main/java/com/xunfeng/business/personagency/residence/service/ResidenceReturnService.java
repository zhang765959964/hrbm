package com.xunfeng.business.personagency.residence.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.residence.model.ResidenceReturn;
import com.xunfeng.business.personagency.residence.dao.ResidenceReturnDao;
import com.xunfeng.business.personagency.residence.interf.ResidenceReturnServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口借用归还表 Service类
* @author:jiangxin
* @createDate 2016-08-30 09:58:41 
* @version V1.0   
*/
@Service
public class ResidenceReturnService extends BaseService<ResidenceReturn> implements ResidenceReturnServiceInterf
{
	@Resource
	private ResidenceReturnDao dao;
	
	
	
	public ResidenceReturnService()
	{
	}
	
	@Override
	protected IEntityDao<ResidenceReturn, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ResidenceReturn> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ResidenceReturn> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//删除户口借用归还信息
	public void deleteResidenceReturnByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			ResidenceReturn residenceReturn = dao.getById(id);
			residenceReturn.setCcpr08("1");
			dao.update(residenceReturn);
		}
	}
}
