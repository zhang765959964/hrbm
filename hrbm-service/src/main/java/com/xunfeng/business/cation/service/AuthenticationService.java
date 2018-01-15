package com.xunfeng.business.cation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.cation.dao.authenticationDao;
import com.xunfeng.business.cation.interf.AuthenticationServiceInterf;
import com.xunfeng.business.cation.model.Authentication;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Service类
* @author:wanghan
* @createDate 2015-11-11 18:17:38 
* @version V1.0   
*/
@Service
public class AuthenticationService extends BaseService<Authentication> implements AuthenticationServiceInterf
{
	@Resource
	private authenticationDao dao;
	
	
	
	public AuthenticationService()
	{
	}
	
	@Override
	protected IEntityDao<Authentication, Long> getEntityDao() 
	{
		return dao;
	}

	public List<Authentication> getByAab001(Long aab001) {
		// TODO Auto-generated method stub
		return dao.getBySqlKey("getByAab001",aab001);
	}

}
