package com.xunfeng.business.person.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonQualificationDao;
import com.xunfeng.business.person.interf.PersonQualificationServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonQualification;
import com.xunfeng.business.person.model.PersonTrain;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
 *<pre>
 * 对象功能:个人资格证书表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:29
 *</pre>
 */
@Service
public class PersonQualificationService extends BaseService<PersonQualification> implements PersonQualificationServiceInterf
{
	@Resource
	private PersonQualificationDao dao;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	
	
	
	public PersonQualificationService()
	{
	}
	
	@Override
	protected IEntityDao<PersonQualification, Long> getEntityDao()
	{
		return dao;
	}
	
	public  List<PersonQualification> getPersonQualificationList(Long aac001){
		
		Map params=new HashMap();
		params.put("aac001", aac001);
		params.put("ccpr08", "0");
		return dao.getListBySqlKey("getAll",params);
		
	}
	@Override
	public void delByIds(Long[] idArray){
		for(Long id : idArray){
			this.delById(id);
		}
		
	}
	@Override
	public void delById(Long id){
		PersonQualification  personQualification = dao.getById(id);
		Long personId = personQualification.getAac001();
		dao.delById(id);
		List<PersonQualification> listQualification = this.getPersonQualificationList(personId);
		if(listQualification == null || listQualification.size()<=0){//培训经历简历完整
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
			personBaseInfo.setCcmu50(personBaseInfo.getCcmu50()- 5);
			personBaseInfo.setCcmu52("0");//技能证书简历完整
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		}
		
	}
	@Override
	public void add(PersonQualification personQualification){
		//修改个人信息表
		Long personId = personQualification.getAac001();
		List<PersonQualification> listQualification = this.getPersonQualificationList(personId);
		if(listQualification==null || listQualification.size()<=0){//增加简历完整度
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
			Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
			personBaseInfo.setCcmu50(resumePercent+5);
			personBaseInfo.setCcmu57("1");//培训经历简历完整
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		 }
		dao.add(personQualification);
	}
}
