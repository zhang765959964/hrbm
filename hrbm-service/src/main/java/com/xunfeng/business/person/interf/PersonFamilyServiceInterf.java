package com.xunfeng.business.person.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员家庭关系表 接口类
* @author:wanlupeng
* @createDate 2016-07-07 09:13:01 
* @version V1.0   
*/
public interface PersonFamilyServiceInterf extends GenericServiceInterface<PersonFamily,Long>
{
	/**
	 * @param personId
	 * @return 根据个人id查询出个人家庭情况
	 */
	public Map getPersonFamilyPersonId(Long personId);
	
	public PersonFamily getByFaPersonId(Long faPersonId);
	//查看详情
	public PersonFamily getByPersonId(Long faPersonId);
	//查看配偶身份证号是否已存在
	public List<PersonFamily> getByFaSpouseCard(QueryFilter fiter);
	
}
