package com.xunfeng.business.personagency.storage.interf;


import java.util.Map;

import com.xunfeng.business.personagency.storage.model.WageStandard;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工资标准表 接口类
* @author:jiangxin
* @createDate 2016-08-17 11:06:20 
* @version V1.0   
*/
public interface WageStandardServiceInterf extends GenericServiceInterface<WageStandard,Long>
{
   public ResultData<WageStandard> getAllByFilter(QueryFilter fiter);	
   /**
	 * @param lAryId  删除工资标准调整
	 */
   public void delWageStandardByIds(Long[] lAryId);
   public void addWageStandard(WageStandard wageStandard);
   public void updateWageStandard(WageStandard wageStandard);
   public Map getWageStandardById(Long id);
}
