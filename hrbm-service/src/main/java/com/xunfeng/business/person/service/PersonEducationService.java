package com.xunfeng.business.person.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonEducationDao;
import com.xunfeng.business.person.interf.PersonEducationServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:个人教育背景表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:43
 *</pre>
 */
@Service
public class PersonEducationService extends BaseService<PersonEducation> implements PersonEducationServiceInterf
{
	@Resource
	private PersonEducationDao dao;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	
	
	
	public PersonEducationService()
	{
	}
	
	@Override
	protected IEntityDao<PersonEducation, Long> getEntityDao()
	{
		return dao;
	}
	
	public  List<PersonEducation> getPersonEducationList(Long aac001){
		
		Map params=new HashMap();
		params.put("aac001", aac001);
		params.put("ccpr08", "0");
		return dao.getListBySqlKey("getAll",params);
		
	}
	/**
	 * @param personId
	 * @return 根据个人编号获取家庭教育情况（人事档案）
	 */
	public Map getPersonEducationByPersonId(Long personId){
		Map params=new HashMap();
		params.put("AAC001", personId);
		params.put("CCPR08", "0");
		return (Map)dao.getOne("getPersonEducationByPersonId", params);
	}
	/**
	 * 获得个人教育背景分页(公办系统)
	 */
	public ResultData<PersonEducation> getAllEducation(QueryFilter fiter){
		
		ResultData<PersonEducation> resultData=new ResultData<PersonEducation>();
		List<PersonEducation> dataList =dao.getBySqlKey("getAllEducation", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	@Override
	public void delByIds(Long[] idArray){
		for(Long id : idArray){
			this.delById(id);
		}
		
	}
	@Override
	public void delById(Long id){
		PersonEducation  personEducation = dao.getById(id);
		Long personId = personEducation.getAac001();
		dao.delById(id);
		List<PersonEducation> listPersonEducation = this.getPersonEducationList(personId);
		if(listPersonEducation == null || listPersonEducation.size()<=0){//教育经历简历完整
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
			personBaseInfo.setCcmu50(personBaseInfo.getCcmu50()- 5);
			personBaseInfo.setCcmu53("0");//教育经历简历完整
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		}
		
	}
	@Override
	public void add(PersonEducation personEducation){
		//修改个人信息表
		Long personId = personEducation.getAac001();
		List<PersonEducation> listPersonEducation = this.getPersonEducationList(personId);
		if(listPersonEducation==null || listPersonEducation.size()<=0){//增加简历完整度
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
			Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
			personBaseInfo.setCcmu50(resumePercent+5);
			personBaseInfo.setCcmu53("1");//教育经历简历完整
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		 }
		dao.add(personEducation);
	}
	
	//查看是否已添加过该教育背景
	public  List<PersonEducation> getByAac045(QueryFilter fiter){
		return dao.getBySqlKey("getByAac045", fiter);
	};

}
