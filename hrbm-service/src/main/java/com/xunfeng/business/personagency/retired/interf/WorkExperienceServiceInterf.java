package com.xunfeng.business.personagency.retired.interf;

import java.util.List;

import com.xunfeng.business.personagency.retired.dto.WorkExperienceDto;
import com.xunfeng.business.personagency.retired.model.WorkExperience;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作经历维护 接口类
* @author:zhangfan
* @createDate 2016-07-22 15:23:26 
* @version V1.0   
*/
public interface WorkExperienceServiceInterf extends GenericServiceInterface<WorkExperience,Long>
{
	
	public void delByPersonId(Long personId);	
	
	/**
	 * 查询退休人员工作维护情况
	 * @param filer
	 * @return
	 */
	public ResultData getWorkWh(QueryFilter fiter);
	
	
	/**
	 * 保存或者更新工作维护信息
	 * @param workExperienceDto
	 */
	public void saveOrUpdate(WorkExperienceDto workExperienceDto);
	
	/**
	 * 根据人员id查询工作简历信息
	 * @param personId
	 * @return
	 */
	public List<WorkExperience> getByPersonId(Long personId);
}
