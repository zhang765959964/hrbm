package com.xunfeng.business.personagency.subsidy.interf;


import java.util.Date;

import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴参数 接口类
* @author:wanghan
* @createDate 2016-07-07 10:26:13 
* @version V1.0   
*/
public interface SocialParamsServiceInterf extends GenericServiceInterface<SocialParams,Long>
{
	public ResultData<SocialParams> getAllByFilter(QueryFilter fiter);
	/**根据当前日期获取该日期对应的养老保险补贴标准参数
	 * @param currentDate
	 * @return
	 */
	public SocialParams getPensionSocialParams(Date currentDate);
	/**根据当前日期获取该日期对应的医疗保险补贴标准参数
	 * @param currentDate
	 * @return
	 */
	public SocialParams getMedicalSocialParams(Date currentDate);
}
