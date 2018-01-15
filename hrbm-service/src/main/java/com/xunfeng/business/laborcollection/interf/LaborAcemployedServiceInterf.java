package com.xunfeng.business.laborcollection.interf;


import com.xunfeng.business.laborcollection.model.LaborAcemployed;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 未就业及失业情况信息表 接口类
* @author:wangyanyan
* @createDate 2016-06-08 10:51:17 
* @version V1.0   
*/
public interface LaborAcemployedServiceInterf extends GenericServiceInterface<LaborAcemployed,Long>
{

	public LaborAcemployed getByAcemployed(Long aac001);
	
	/**查看详情**/
	public LaborAcemployed getByAac001(Long aac001);
	
}
