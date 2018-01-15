package com.xunfeng.business.person.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonTrainDao;
import com.xunfeng.business.person.interf.PersonTrainServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonTrain;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
 *<pre>
 * 对象功能:培训经历表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:00:23
 *</pre>
 */
@Service
public class PersonTrainService extends BaseService<PersonTrain> implements PersonTrainServiceInterf
{
	@Resource
	private PersonTrainDao dao;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	
	
	
	public PersonTrainService()
	{
	}
	
	@Override
	protected IEntityDao<PersonTrain, Long> getEntityDao()
	{
		return dao;
	}
	public  List<PersonTrain> getPersonTrainList(Long aac001){
		
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
		PersonTrain personTrain = dao.getById(id);
		Long personId = personTrain.getAac001();
		dao.delById(id);
		List<PersonTrain> listTrain = this.getPersonTrainList(personId);
		if(listTrain==null || listTrain.size()<=0){//培训经历简历完整
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
			personBaseInfo.setCcmu50(personBaseInfo.getCcmu50()- 5);
			personBaseInfo.setCcmu57("0");
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		}
		
	}
	@Override
	public void add(PersonTrain personTrain){
		//修改个人信息表
		Long aac001 = personTrain.getAac001();
	    List<PersonTrain> listTrain = this.getPersonTrainList(aac001);
		if(listTrain==null || listTrain.size()<=0){//增加简历完整度
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
			Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
			personBaseInfo.setCcmu50(resumePercent+5);
			personBaseInfo.setCcmu57("1");//培训经历简历完整
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		 }
		dao.add(personTrain);
	}
	
}
