package com.xunfeng.sys.identity.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.identity.dao.BusinessIdentityDao;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.model.BusinessIdentity;
import com.xunfeng.sys.identity.util.UniqueIdUtilImpl;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: WS_M_SYS_BUS_ID Service类
* @author:user
* @createDate 2016-11-29 09:45:50 
* @version V1.0   
*/
@Service
public class BusinessIdentityService extends BaseService<BusinessIdentity> 
{
	@Resource
	private BusinessIdentityDao dao;
	
	
	
	public BusinessIdentityService()
	{
	}
	
	@Override
	protected IEntityDao<BusinessIdentity, Long> getEntityDao() 
	{
		return dao;
	}
	
	
    public  Long   getNewBusinessIdentity(SeqType SeqType){				
    	Map params=new HashMap();
		params.put("type", SeqType.getCode());
		BusinessIdentity businessIdentity=dao.getUnique("getAll",params);
		if(businessIdentity==null){
			businessIdentity=new BusinessIdentity();
			businessIdentity.setBound(1L);
			businessIdentity.setType(SeqType.getCode());
			businessIdentity.setTypeName(SeqType.getName());
			businessIdentity.setId(UniqueIdUtilImpl.genId());
			this.add(businessIdentity);
		}else{
			businessIdentity.setBound(businessIdentity.getBound()+1);
			this.update(businessIdentity);
		}
		return businessIdentity.getBound();
	}
	
}
