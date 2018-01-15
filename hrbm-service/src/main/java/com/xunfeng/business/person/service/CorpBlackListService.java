package com.xunfeng.business.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.CorpBlackListDao;
import com.xunfeng.business.person.interf.CorpBlackListServiceInterf;
import com.xunfeng.business.person.model.CorpBlackList;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 屏蔽单位 Service类
* @author:wanghan
* @createDate 2015-07-23 14:48:15 
* @version V1.0   
*/
@Service
public class CorpBlackListService extends BaseService<CorpBlackList>  implements CorpBlackListServiceInterf
{
	@Resource
	private CorpBlackListDao dao;
	
	
	
	public CorpBlackListService()
	{
	}
	
	@Override
	protected IEntityDao<CorpBlackList, Long> getEntityDao()
	{
		return dao;
	}
	public List<CorpBlackList> getPersonBackList(Long aac001){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("aac001", aac001);
		return dao.getListBySqlKey("getAll", params);		
	}
	


	
}
