package com.xunfeng.business.laborcollection.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.laborcollection.model.LaborAcemployed;
import com.xunfeng.business.laborcollection.dao.LaborAcemployedDao;
import com.xunfeng.business.laborcollection.interf.LaborAcemployedServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 未就业及失业情况信息表 Service类
* @author:wangyanyan
* @createDate 2016-06-08 10:51:17 
* @version V1.0   
*/
@Service
public class LaborAcemployedService extends BaseService<LaborAcemployed> implements LaborAcemployedServiceInterf
{
	@Resource
	private LaborAcemployedDao dao;
	
	
	
	public LaborAcemployedService()
	{
	}
	
	@Override
	protected IEntityDao<LaborAcemployed, Long> getEntityDao() 
	{
		return dao;
	}
	@Override
	public LaborAcemployed getByAcemployed(Long aac001) {
		// TODO Auto-generated method stub
		return (LaborAcemployed) dao.getOne("getByAcemployed",aac001);
	}
	@Override
	public LaborAcemployed getByAac001(Long aac001) {
		// TODO Auto-generated method stub
		return (LaborAcemployed) dao.getOne("getByAac001",aac001);
	}
	
}
