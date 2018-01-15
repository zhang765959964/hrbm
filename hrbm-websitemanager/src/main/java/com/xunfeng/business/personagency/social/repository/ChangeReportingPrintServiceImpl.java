package com.xunfeng.business.personagency.social.repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.social.interf.ChangeReportingServiceInterf;
import com.xunfeng.core.web.util.RequestUtil;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL Service类
* @author:wanghan
* @createDate 2016-10-20 15:19:40 
* @version V1.0   
*/
@Service
public class ChangeReportingPrintServiceImpl implements BindDataService  
{
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("changeReporting")
	private ChangeReportingServiceInterf changeReportingService;
	
	
	@Override
	public Map getBindData(Map paramMap) {
		// TODO Auto-generated method stub
		String type = (String)paramMap.get("type");
		String id = (String)paramMap.get("id");
		Map<String, Object> returnMap=new HashMap();
		if("1".equals(type)){
			returnMap  = changeReportingService.getChangeReportingById(Long.parseLong(id));
		}
		return returnMap;
	}
	
}
