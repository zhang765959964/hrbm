package com.xunfeng.business.personagency.retired.service;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.business.personagency.retired.dao.WorkExperienceDao;
import com.xunfeng.business.personagency.retired.dto.WorkExperienceDto;
import com.xunfeng.business.personagency.retired.interf.WorkExperienceServiceInterf;
import com.xunfeng.business.personagency.retired.model.WorkExperience;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作经历维护 Service类
* @author:zhangfan
* @createDate 2016-07-22 15:23:26 
* @version V1.0   
*/
@Service
public class WorkExperienceService extends BaseService<WorkExperience> implements WorkExperienceServiceInterf
{
	@Resource
	private WorkExperienceDao dao;
	
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	public WorkExperienceService()
	{
	}
	
	@Override
	protected IEntityDao<WorkExperience, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public void delByPersonId(Long personId) {
		dao.delByPersonId(personId);
	}


	
	@Override
	public ResultData getWorkWh(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList =dao.getBySqlKey("getWorkWh", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public void saveOrUpdate(WorkExperienceDto workExperienceDto) {
		
		WorkExperience workExperience = dao.getById(workExperienceDto.getId());
		if(workExperience!=null){
			workExperience.setCreateTime(workExperienceDto.getCreateTime());
			workExperience.setEndTime(workExperienceDto.getEndTime());
			workExperience.setWorkUnit(workExperienceDto.getWorkUnit());
			if(!workExperienceDto.getGzName().equals("#")){
				workExperience.setGzId(Long.parseLong(workExperienceDto.getGzName()));
			}else{
				workExperience.setGzId(-1L);
			}
			dao.update(workExperience);
		}else{
			workExperience = new WorkExperience();
			workExperience =BeanToBean.copyProperties(workExperienceDto, workExperience,false);
			uniqueIdUtilService.genId(WorkExperience.class.getName());
			if(!workExperienceDto.getGzName().equals("#")){
				workExperience.setGzId(Long.parseLong(workExperienceDto.getGzName()));
			}
		
			dao.add(workExperience);
		}
		
		
	}
	@Override
	public List<WorkExperience> getByPersonId(Long personId) {
		return dao.getByPersonId(personId);
	}

	
}
