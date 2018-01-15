package com.xunfeng.business.person.service;

import com.xunfeng.business.person.dao.PersonJobLettersDao;
import com.xunfeng.business.person.model.PersonJobLetters;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @company:河南讯丰信息技术有限公司
* @Description: PERSON_JOB_LETTERS Service类
* @author:wanghan
* @createDate 2015-12-03 14:49:46 
* @version V1.0   
*/
@Service
public class PersonJobLettersService extends BaseService<PersonJobLetters>
{
	@Resource
	private PersonJobLettersDao dao;
	
	
	
	public PersonJobLettersService()
	{
	}
	
	@Override
	protected IEntityDao<PersonJobLetters, Long> getEntityDao() 
	{
		return dao;
	}
	
	public List<PersonJobLetters> getJobLettersByUserId(Long ccmu01){
		Map map =new HashMap();
		map.put("ccmu01",ccmu01);
		List<PersonJobLetters> list=dao.getBySqlKey("getAll",map);
		return list;
	}
}
