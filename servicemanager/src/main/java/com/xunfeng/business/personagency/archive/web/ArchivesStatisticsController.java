package com.xunfeng.business.personagency.archive.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.sys.uums.service.SysOrgService;
import com.xunfeng.sys.uums.service.SysUserService;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.personagency.archive.dto.ArchiveCheckoutAppDto;
import com.xunfeng.business.personagency.archive.dto.ArchivesStatisticsAppDto;
import com.xunfeng.business.personagency.archive.dto.ArchivesStatisticsDetailAppDto;
import com.xunfeng.business.personagency.archive.service.ArchiveCheckoutService;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 控制器类
* @author:jx
* @createDate 2016-07-22 14:56:36 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/archiveStatistics/")
public class ArchivesStatisticsController extends BaseController
{
	@Resource
	private ArchiveCheckoutService archiveCheckoutService;
	@Resource
	private ArchivesService archivesService;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysOrgService sysOrgService;
	
	//今日完成接口  蒋鑫  2016.11.28
	@RequestMapping("getFinishToday")
	@ResponseBody
	public Map<Object,Object> getFinishToday(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String userid = (String)map.get("userid");
		if(userid!=null){
		}else{
			userid = "8808";
			queryFilter.addFilter("userid", userid);
		}
		if(queryFilter.getFilters().get("type")!=null && "0".equals(queryFilter.getFilters().get("type")) ){
			queryFilter.getFilters().remove("type");
		}
		if("1".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "a.createrDate");
			queryFilter.getFilters().remove("sort");
		}else if("2".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "a.POSITION");
			queryFilter.getFilters().remove("sort");
		}else{
			queryFilter.addFilter("orderField", "a.createrDate");
		}
		queryFilter.addFilter("orderSeq", "asc");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		//String dateString = "2016-11-25";
		queryFilter.addFilter("beginCreaterDate", dateString);
		queryFilter.addFilter("endCreaterDate", dateString);
		ResultData<ArchivesStatisticsAppDto> resultData = archivesService.getFinshTotalApp(queryFilter);
		Long totalCount = archivesService.getFinshTotalAppCount(userid, null, dateString);
		Long storeCount = archivesService.getFinshTotalAppCount(userid, "1", dateString);
		Long checkoutCount = archivesService.getFinshTotalAppCount(userid, "2", dateString);
		Long returnCount = archivesService.getFinshTotalAppCount(userid, "3", dateString);
		Long lendCount = archivesService.getFinshTotalAppCount(userid, "4", dateString);
	    return getJqGridData(resultData.getPageBean(),totalCount,storeCount,checkoutCount,returnCount,lendCount, resultData.getDataList());
	}
	
	//今日完成接口  蒋鑫  2016.11.28
	@RequestMapping("getFinishDetail")
	@ResponseBody
	public Map<Object,Object> getFinishDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String userid = (String)map.get("userid");
	    if(userid!=null){
		}else{
			userid = "8808";
			queryFilter.addFilter("userid", userid);
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		//String dateString = "2016-11-25";
		queryFilter.addFilter("beginCreaterDate", dateString);
		queryFilter.addFilter("endCreaterDate", dateString);
		ResultData<ArchivesStatisticsDetailAppDto> resultData = archivesService.getFinshTotalDetailApp(queryFilter);
		Long totalCount = archivesService.getFinshTotalAppCount(userid, null, dateString);
		Long storeCount = archivesService.getFinshTotalAppCount(userid, "1", dateString);
		Long checkoutCount = archivesService.getFinshTotalAppCount(userid, "2", dateString);
		Long returnCount = archivesService.getFinshTotalAppCount(userid, "3", dateString);
		Long lendCount = archivesService.getFinshTotalAppCount(userid, "4", dateString);
		List  list = resultData.getDataList();
		if(list.size()>0){
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				ArchivesStatisticsDetailAppDto object = (ArchivesStatisticsDetailAppDto) iterator.next();
				object.setStoreDetailCount(archivesService.getFinshTotalAppCount(userid, "1", dateString,object.getWindowCreateName()));
				object.setCheckoutDetailCount(archivesService.getFinshTotalAppCount(userid, "2", dateString,object.getWindowCreateName()));
				object.setReturnDetailCount(archivesService.getFinshTotalAppCount(userid, "3", dateString,object.getWindowCreateName()));
				object.setLendDetailCount(archivesService.getFinshTotalAppCount(userid, "4", dateString,object.getWindowCreateName()));
			}
		}
	    return getJqGridData(resultData.getPageBean(),totalCount,storeCount,checkoutCount,returnCount,lendCount, list);
	}
	
}
