package com.xunfeng.business.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.dao.PersonFamilyDao;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员家庭关系表 Service类
* @author:wanlupeng
* @createDate 2016-07-07 09:13:01 
* @version V1.0   
*/
@Service
public class PersonFamilyService extends BaseService<PersonFamily> implements PersonFamilyServiceInterf
{
	@Resource
	private PersonFamilyDao dao;
	
	
	
	public PersonFamilyService()
	{
	}
	
	@Override
	protected IEntityDao<PersonFamily, Long> getEntityDao() 
	{
		return dao;
	}
	public PersonFamily getByFaPersonId(Long faPersonId){
		
		return (PersonFamily) dao.getOne("getByFaPersonId", faPersonId);
		
	}
	//查看详情
	public PersonFamily getByPersonId(Long faPersonId){
		
		return (PersonFamily) dao.getOne("getByPersonId", faPersonId);
		
	}
	/**
	 * @param personId
	 * @return 根据个人id查询出个人家庭情况
	 */
	public Map getPersonFamilyPersonId(Long personId){
		Map params=new HashMap();
		params.put("faPersonId", personId);
		return (Map)dao.getOne("getPersonFamilyPersonId", params);
	}

	/**
	 * @param faSpouseCard
	 * @return 根据faSpouseCard判断身份证号是否已存在
	 * 2016/08/02
	 */
	public List<PersonFamily> getByFaSpouseCard(QueryFilter fiter) {
		// TODO Auto-generated method stub
		return dao.getBySqlKey("getAll",fiter);
	}
	
}
