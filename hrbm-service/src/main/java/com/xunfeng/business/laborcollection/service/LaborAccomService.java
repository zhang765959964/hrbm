package com.xunfeng.business.laborcollection.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.laborcollection.model.LaborAccom;
import com.xunfeng.business.laborcollection.dao.LaborAccomDao;
import com.xunfeng.business.laborcollection.interf.LaborAccomServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 就业情况信息表 Service类
* @author:wangyanyan
* @createDate 2016-06-08 10:47:45 
* @version V1.0   
*/
@Service
public class LaborAccomService extends BaseService<LaborAccom> implements LaborAccomServiceInterf
{
	@Resource
	private LaborAccomDao dao;
	
	
	
	public LaborAccomService()
	{
	}
	
	@Override
	protected IEntityDao<LaborAccom, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public LaborAccom getByAccom(Long aac001) {
		// TODO Auto-generated method stub
		return (LaborAccom) dao.getOne("getByAccom",aac001);
	}
	
	@Override
	public LaborAccom getByAac001(Long aac001) {
		// TODO Auto-generated method stub
		return (LaborAccom) dao.getOne("getByAac001",aac001);
	}
	
	
}
