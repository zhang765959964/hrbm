package com.xunfeng.business.personagency.person.interf;

import com.xunfeng.business.personagency.person.dto.AgencyPersonExpandDto;




/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL 接口类
* @author:user
* @createDate 2016-11-09 10:49:09 
* @version V1.0   
*/
public interface AgencyPersonExpandServiceInterf 
{
	public AgencyPersonExpandDto  getPersonExpandById(Long aac001);
	
	public void  addPersonExpand(AgencyPersonExpandDto expandDto);
	
	public void  updatePersonExpand(AgencyPersonExpandDto expandDto);
}
