package com.xunfeng.business.person.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:个人工作经历表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:00:45
 *</pre>
 */

public interface PersonWorkExpceServiceInterf extends GenericServiceInterface<PersonWorkExpce,Long>
{
	
	
	public  List<PersonWorkExpce> getPersonWorkExpceList(Long aac001);
	/**
	 * @param personId
	 * @return 根据个人id查询个人工作情况
	 */
	public Map getPersonWorkExpceByPersonId(Long personId);
	//分页功能
	public ResultData<PersonWorkExpce> getAllWorkExpce(QueryFilter fiter);
	public ResultData<PersonWorkExpce> getAllByFilter(QueryFilter fiter);
	/**
	 * @param lAryId  删除个人工作经历
	 */
	public void deletePersonWorkExpceByIds(Long[] lAryId);
	
	//查询工作经历
	public List<PersonWorkExpce> getByExist(QueryFilter fiter);
}
