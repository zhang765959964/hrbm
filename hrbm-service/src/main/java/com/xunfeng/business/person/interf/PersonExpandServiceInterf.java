package com.xunfeng.business.person.interf;


import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息拓展表 接口类
* @author:wanlupeng
* @createDate 2016-07-06 18:11:28 
* @version V1.0   
*/
public interface PersonExpandServiceInterf extends GenericServiceInterface<PersonExpand,Long>
{
	public PersonExpand getByExpPersonId(Long expPersonId);
	//查看详情
	public PersonExpand getByExpId(Long expPersonId);
}
