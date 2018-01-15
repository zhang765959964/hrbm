package com.xunfeng.sys.component.service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.component.dao.UploadAuthenInfoDao;
import com.xunfeng.sys.component.model.UploadAuthenInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Service类
* @author:wxl
* @createDate 2015-07-23 17:10:45 
* @version V1.0   
*/
@Service
public class UploadAuthenInfoService extends BaseService<UploadAuthenInfo>
{
	@Resource
	private UploadAuthenInfoDao dao;
	
	
	
	public UploadAuthenInfoService()
	{
	}
	
	@Override
	protected IEntityDao<UploadAuthenInfo, Long> getEntityDao()
	{
		return dao;
	}
	
	
}
