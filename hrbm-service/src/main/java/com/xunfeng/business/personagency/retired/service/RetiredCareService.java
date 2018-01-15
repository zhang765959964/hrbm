package com.xunfeng.business.personagency.retired.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ZJ_DateUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.retired.model.RetiredCare;
import com.xunfeng.business.personagency.retired.model.WorkExperience;
import com.xunfeng.business.personagency.retired.dao.RetiredCareDao;
import com.xunfeng.business.personagency.retired.dto.RetiredCareDto;
import com.xunfeng.business.personagency.retired.interf.RetiredCareServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员大病医保表 Service类
* @author:zhangfan
* @createDate 2016-12-16 11:23:41 
* @version V1.0   
*/
@Service
public class RetiredCareService extends BaseService<RetiredCare> implements RetiredCareServiceInterf
{
	@Resource
	private RetiredCareDao dao;
	
	@Resource
	private PersonBaseInfoService personService;	//个人service
	
	@Resource
	private PersonExpandService personExpandService;	//个人信息扩展表Service
	
	@Resource
	private  UniqueIdUtilService uniqueIdUtilService;
	
	@Resource
	private WorkExperienceService workExperienceService;	//工作经历service
	
	public RetiredCareService()
	{
	}
	
	@Override
	protected IEntityDao<RetiredCare, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<RetiredCare> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<RetiredCare> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public ResultData getRetiredCareList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList = dao.getBySqlKey("getRetiredCareList", fiter);
		
		String str = "";
		List newDataList = new ArrayList();		//存放人员id
		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
				Map m = (Map) iterator.next();
				BigDecimal id =  (BigDecimal)m.get("id");
				Long personId = id.longValue();	
				newDataList.add(personId);
		}
		Map<Object,String> dataMap = new HashMap<Object,String>();	//封装多条数据	
		Long ids = 0l;
		if(newDataList.size()>0){	//合并成一条数据
			for (int i = 0; i < newDataList.size(); i++) {
				ids  = (Long) newDataList.get(i);
				List<WorkExperience>  workList = workExperienceService.getByPersonId(ids);	
				if(workList.size()>0){
					for (WorkExperience workExperience : workList) {
						String begin = "";
						String end  = "";
						
						if(ids.longValue()!=workExperience.getPersonId()){
							str += "";
						}else{
							str +=(begin+"至"+end+"在"+workExperience.getWorkUnit()+""+"工作。");
							dataMap.put(ids, str);
						}
					}
					str = new String();
				}
			}
		}
		List personList = new ArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			@SuppressWarnings("rawtypes")
			Map map =(Map)dataList.get(i);
			for (Entry<Object, String> s : dataMap.entrySet()) {
				if(s.getKey().toString().equals(map.get("AAC001").toString())){
					map.put("workResume", s.getValue());
				}
			}
			personList.add(map);
		}
		resultData.setDataList(personList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	

	@Override
	public Map getByPersonId(Long personId) {
		
		return (Map) dao.getOne("getByPersonId", personId);
	}

	@Override
	public void saveOrUpdate(RetiredCareDto retiredCareDto) {
		
		PersonBaseInfo  personBaseInfo = personService.getById(retiredCareDto.getPersonId());
		if(personBaseInfo!=null){
			personBaseInfo.setAae005(retiredCareDto.getMobilephone());
			personService.update(personBaseInfo);
		}
		PersonExpand personExpand =	personExpandService.getByExpPersonId(retiredCareDto.getPersonId());
		if(personExpand!=null){
			personExpand.setExpPersonPhone(retiredCareDto.getPhone());
			personExpandService.update(personExpand);
		}
		RetiredCare reitredCare =null;
		if(retiredCareDto.getId()!=null){
			 reitredCare = new  RetiredCare();
			 reitredCare = dao.getById(retiredCareDto.getId());
			if(reitredCare!=null){
				reitredCare = BeanToBean.copyProperties(retiredCareDto,reitredCare, false);
				dao.update(reitredCare);
			}
		}else{
			reitredCare = new  RetiredCare();
			reitredCare = BeanToBean.copyProperties(retiredCareDto,reitredCare, false);
			reitredCare.setId(uniqueIdUtilService.genId(RetiredCare.class.getName()));
			reitredCare.setPersonId(retiredCareDto.getPersonId());
			dao.add(reitredCare);
		}
	}

	@Override
	public void saveOrUpdatePl(Long[] arrId, RetiredCareDto retiredCareDto) {
		RetiredCare retiredCare;
		RetiredCare rs = new RetiredCare();
		for (Long id : arrId) {
			retiredCare = this.getCareByPersonId(id);
			if(retiredCare!=null){
				rs = BeanToBean.copyProperties(retiredCare, rs, false);
				rs.setNote(retiredCareDto.getNote());
				rs.setReason(retiredCareDto.getReason());
				rs.setIsFlag(retiredCareDto.getIsFlag());
				rs.setIsDeclare(retiredCareDto.getIsDeclare());
				dao.update(rs);
			}else{
				retiredCare = new RetiredCare();
				BeanToBean.copyProperties(retiredCareDto, retiredCare, false);
				retiredCare.setId(uniqueIdUtilService.genId(RetiredCare.class.getName()));
				retiredCare.setPersonId(id);
				dao.add(retiredCare);
			}
			
		}
		
	}

	@Override
	public RetiredCare getCareByPersonId(Long personId) {
		
		return dao.getCareByPersonId(personId);
	}


	
	
}
