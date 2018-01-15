package com.xunfeng.business.laborcollection.interf;


import com.xunfeng.business.laborcollection.model.LaborAcpost;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 不在岗情况信息表 接口类
* @author:wangyanyan
* @createDate 2016-06-24 09:46:09 
* @version V1.0   
*/
public interface LaborAcpostServiceInterf extends GenericServiceInterface<LaborAcpost,Long>
{

	public LaborAcpost getByAcpost(Long aac001);
	/**详情页面查询信息**/
	public LaborAcpost getByAac001(Long aac001);
	
}
