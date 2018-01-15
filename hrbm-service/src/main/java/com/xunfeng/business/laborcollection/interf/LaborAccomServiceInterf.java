package com.xunfeng.business.laborcollection.interf;


import com.xunfeng.business.laborcollection.model.LaborAccom;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 就业情况信息表 接口类
* @author:wanlupeng
* @createDate 2016-06-08 10:47:45 
* @version V1.0   
*/
public interface LaborAccomServiceInterf extends GenericServiceInterface<LaborAccom,Long>
{
	public LaborAccom   getByAccom(Long aac001);
	public LaborAccom   getByAac001(Long aac001);//详情页面查询
}
