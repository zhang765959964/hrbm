package com.xunfeng.business.personagency.affair.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.affair.model.PersonLetter;
import com.xunfeng.business.personagency.affair.model.TitleDeclaration;
import com.xunfeng.business.personagency.affair.dao.TitleDeclarationDao;
import com.xunfeng.business.personagency.affair.interf.TitleDeclarationServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职称申报评定表 Service类
* @author:jiangxin
* @createDate 2016-09-18 15:38:07 
* @version V1.0   
*/
@Service
public class TitleDeclarationService extends BaseService<TitleDeclaration> implements TitleDeclarationServiceInterf
{
	@Resource
	private TitleDeclarationDao dao;
	
	
	
	public TitleDeclarationService()
	{
	}
	
	@Override
	protected IEntityDao<TitleDeclaration, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<TitleDeclaration> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<TitleDeclaration> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//查询所有的职称申报信息
	public ResultData  getAllTitleDeclaration(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllTitleDeclaration( fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	//删除职称申报信息
	public void deleteTitleDeclarationByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			TitleDeclaration titleDeclaration = dao.getById(id);
			titleDeclaration.setCcpr08("1");
			dao.update(titleDeclaration);
		}
	}
	
}
