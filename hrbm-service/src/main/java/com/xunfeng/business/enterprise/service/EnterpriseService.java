package com.xunfeng.business.enterprise.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.enterprise.model.Enterprise;
import com.xunfeng.business.enterprise.dao.EnterpriseDao;
import com.xunfeng.business.enterprise.interf.EnterpriseServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位基本信息表 Service类
* @author:liwenhao
* @createDate 2016-06-16 16:09:33 
* @version V1.0   
*/
@Service
public class EnterpriseService extends BaseService<Enterprise> implements EnterpriseServiceInterf
{
	@Resource
	private EnterpriseDao dao;
	
	
	
	public EnterpriseService()
	{
	}
	
	@Override
	protected IEntityDao<Enterprise, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
