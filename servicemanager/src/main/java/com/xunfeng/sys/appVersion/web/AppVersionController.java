package com.xunfeng.sys.appVersion.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.appVersion.model.AppVersion;
import com.xunfeng.sys.appVersion.service.AppVersionService;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: app版本表 控制器类
* @author:jiangxin
* @createDate 2016-11-29 17:05:15 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/appVersion/appVersion/")
public class AppVersionController extends BaseController
{
	@Resource
	private AppVersionService appVersionService;
	
	//app版本升级接口
	@RequestMapping("getAppVersion")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public AppVersion listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		Map<String,Object> map = fiter.getFilters();
		String versionNumber = (String)map.get("versionNumber");
		
		//ResultData<AppVersion> resultData=appVersionService.getAllByFilter(fiter);		
		AppVersion appVersion = new AppVersion();
		//appVersion = appVersionService.getAppVersionBy(versionNumber);
		//appVersion = appVersionService.getAppVersionBy(null);
		return appVersion;
	}
	
	
	
}
