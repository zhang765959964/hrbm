package com.xunfeng.business.person.service;

import com.xunfeng.business.person.dao.PersonProjectDao;
import com.xunfeng.business.person.model.PersonProject;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 项目经验表 Service类
* @author:wanghan
* @createDate 2015-07-22 11:18:06 
* @version V1.0   
*/
@Service
public class PersonProjectService extends BaseService<PersonProject>
{
	@Resource
	private PersonProjectDao dao;
	
	
	
	public PersonProjectService()
	{
	}
	
	@Override
	protected IEntityDao<PersonProject, Long> getEntityDao()
	{
		return dao;
	}
	public  List<PersonProject> getPersonProjectList(Long aac001){
		
		Map params=new HashMap();
		params.put("aac001", aac001);
		return dao.getListBySqlKey("getAll",params);
		
	}

}
