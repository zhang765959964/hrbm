package com.xunfeng.business.person.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.dao.PersonExpandDao;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息拓展表 Service类
* @author:wanlupeng
* @createDate 2016-07-06 18:11:28 
* @version V1.0   
*/
@Service
public class PersonExpandService extends BaseService<PersonExpand> implements PersonExpandServiceInterf
{
	@Resource
	private PersonExpandDao dao;
	
	
	
	public PersonExpandService()
	{
	}
	
	@Override
	protected IEntityDao<PersonExpand, Long> getEntityDao() 
	{
		return dao;
	}
	public PersonExpand getByExpPersonId(Long expPersonId){
		
		return (PersonExpand) dao.getOne("getByExpPersonId", expPersonId);
		
	}
	//查看详情
	public PersonExpand getByExpId(Long expPersonId){
		
		return (PersonExpand) dao.getOne("getByExpId", expPersonId);
		
	}
	
}
