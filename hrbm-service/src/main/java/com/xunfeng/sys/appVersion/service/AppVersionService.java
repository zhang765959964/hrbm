package com.xunfeng.sys.appVersion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.appVersion.model.AppVersion;
import com.xunfeng.sys.appVersion.dao.AppVersionDao;
import com.xunfeng.sys.appVersion.interf.AppVersionServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: app版本表 Service类
* @author:jiangxin
* @createDate 2016-11-29 17:05:15 
* @version V1.0   
*/
@Service
public class AppVersionService extends BaseService<AppVersion> implements AppVersionServiceInterf
{
	@Resource
	private AppVersionDao dao;
	
	
	
	public AppVersionService()
	{
	}
	
	@Override
	protected IEntityDao<AppVersion, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<AppVersion> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<AppVersion> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	public AppVersion getAppVersionBy(String versionNumber){
		Map params=new HashMap();
		params.put("versionNumber", versionNumber);
		AppVersion AppVersion = dao.getUnique("getAppVersionBy", params);
		return AppVersion;
	}
	
}
