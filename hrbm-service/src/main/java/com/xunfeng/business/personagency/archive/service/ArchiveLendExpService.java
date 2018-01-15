package com.xunfeng.business.personagency.archive.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.archive.model.ArchiveLendExp;
import com.xunfeng.business.personagency.archive.dao.ArchiveLendExpDao;
import com.xunfeng.business.personagency.archive.interf.ArchiveLendExpServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出拓展表 Service类
* @author:jiangxin
* @createDate 2016-12-26 11:21:59 
* @version V1.0   
*/
@Service
public class ArchiveLendExpService extends BaseService<ArchiveLendExp> implements ArchiveLendExpServiceInterf
{
	@Resource
	private ArchiveLendExpDao dao;
	
	
	
	public ArchiveLendExpService()
	{
	}
	
	@Override
	protected IEntityDao<ArchiveLendExp, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ArchiveLendExp> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchiveLendExp> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
