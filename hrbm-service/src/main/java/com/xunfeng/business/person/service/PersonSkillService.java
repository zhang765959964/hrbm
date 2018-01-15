package com.xunfeng.business.person.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonSkillDao;
import com.xunfeng.business.person.interf.PersonSkillServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonSkill;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
 *<pre>
 * 对象功能:个人技能表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:54
 *</pre>
 */
@Service
public class PersonSkillService extends BaseService<PersonSkill> implements PersonSkillServiceInterf
{
	@Resource
	private PersonSkillDao dao;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	
	
	
	public PersonSkillService()
	{
	}
	
	@Override
	protected IEntityDao<PersonSkill, Long> getEntityDao()
	{
		return dao;
	}
	public  List<PersonSkill> getPersonSkillList(Long aac001){
		
		Map params=new HashMap();
		params.put("aac001", aac001);
		return dao.getListBySqlKey("getAll",params);
		
	}
	@Override
	public void add(PersonSkill personSkill){
		//修改个人信息表
		Long personId = personSkill.getAac001();
		List<PersonSkill> listPersonSkill = this.getPersonSkillList(personId);
		if(listPersonSkill==null || listPersonSkill.size()<=0){//增加简历完整度
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
			Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
			personBaseInfo.setCcmu50(resumePercent+5);
			personBaseInfo.setCcmu52("1");//技能特长简历完整
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		 }
		dao.add(personSkill);
	}
	
}
