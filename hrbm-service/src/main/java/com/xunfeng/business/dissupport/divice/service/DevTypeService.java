package com.xunfeng.business.dissupport.divice.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.dissupport.divice.model.DevType;
import com.xunfeng.business.dissupport.divice.dao.DevTypeDao;
import com.xunfeng.business.dissupport.divice.interf.DevTypeServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备类别表 Service类
* @author:wanghan
* @createDate 2016-07-28 11:19:04 
* @version V1.0   
*/
@Service
public class DevTypeService extends BaseService<DevType> implements DevTypeServiceInterf
{
	@Resource
	private DevTypeDao dao;
	
	
	
	public DevTypeService()
	{
	}
	
	@Override
	protected IEntityDao<DevType, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
