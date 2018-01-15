package com.xunfeng.business.person.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:个人教育背景表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:43
 *</pre>
 */
public interface PersonEducationServiceInterf  extends GenericServiceInterface<PersonEducation,Long> 
{

	
	public  List<PersonEducation> getPersonEducationList(Long aac001);
	//分页功能
	public ResultData<PersonEducation> getAllEducation(QueryFilter fiter);
	/**
	 * @param personId
	 * @return 根据个人编号获取家庭教育情况（人事档案）
	 */
	public Map getPersonEducationByPersonId(Long personId);
	//查看是否已添加过该教育背景
	public  List<PersonEducation> getByAac045(QueryFilter fiter);
}
