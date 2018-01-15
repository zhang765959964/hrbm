package com.xunfeng.business.personagency.subsidy.interf;


import java.util.Map;

import com.xunfeng.business.personagency.subsidy.dto.ArchivesMakeupDto;
import com.xunfeng.business.personagency.subsidy.model.ArchivesMakeup;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_ARCHIVES_MAKEUP 接口类
* @author:user
* @createDate 2016-12-01 11:32:07 
* @version V1.0   
*/
public interface ArchivesMakeupServiceInterf extends GenericServiceInterface<ArchivesMakeup,Long>
{
   public ResultData<ArchivesMakeup> getAllByFilter(QueryFilter fiter);	
   public void archivesMakeup(ArchivesMakeupDto archivesMakeupDto) ;
   public ResultData<Map>  getAllArchivesMakeupPersonList(String searchValue,PageBean pageBean);
}
