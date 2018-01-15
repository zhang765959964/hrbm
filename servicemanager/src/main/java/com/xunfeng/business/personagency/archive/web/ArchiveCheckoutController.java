package com.xunfeng.business.personagency.archive.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysOrgService;
import com.xunfeng.sys.uums.service.SysUserService;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.personagency.archive.dto.ArchiveCheckoutAppDto;
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
@RequestMapping("/business/personagency/archiveCheckout/")
public class ArchiveCheckoutController extends BaseController
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
	
	//借阅数据接口   蒋鑫  2016.11.07
	@RequestMapping("getRegisterCheckout")
	@ResponseBody
	public Map<Object,Object> getRegisterCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String userid = (String)map.get("userid");
		String orgIds = "";
		if(userid!=null){
			SysUser sysUser = sysUserService.getById(Long.parseLong(userid));
			List<SysOrg> orgList = sysOrgService.getSubOrgans(sysUser.getAcd200());
			if(orgList!=null && !orgList.isEmpty()){
				if(orgList.size()==1){
					orgIds = orgList.get(0).getAcd200().toString();
				}else{
					for (int i = 0; i < orgList.size(); i++) {
						if(i==0){
							orgIds+= orgList.get(i).getAcd200();
						}else{
							orgIds+=","+orgList.get(i).getAcd200();
						}
					}
				}
			}else{
				orgIds = sysUser.getAcd200().toString();
			}
		}
		if(queryFilter.getFilters().get("checkoutKinds")!=null && "1".equals(queryFilter.getFilters().get("checkoutKinds")) ){
			queryFilter.getFilters().remove("checkoutKinds");
		}
		
		if("1".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "n.CHECKOUT_REGISTER_DATE asc,n.id asc ");
			queryFilter.getFilters().remove("sort");
		}else if("2".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "a.MARKET_POSITION asc");
			queryFilter.getFilters().remove("sort");
		}else{
			queryFilter.addFilter("orderField", "n.CHECKOUT_REGISTER_DATE asc,n.id asc");
		}
		//queryFilter.addFilter("orderSeq", "asc");
		queryFilter.addFilter("ccpr08", 0);
		queryFilter.addFilter("checkoutStatusValue", 1);
		queryFilter.addFilter("checkoutRegisterOrgIdApp", orgIds);
		ResultData<ArchiveCheckoutAppDto> resultData = archiveCheckoutService.getAllArchiveCheckoutApp(queryFilter);
	    return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	//返还数据接口   蒋鑫  2016.11.07
	@RequestMapping("getReturnCheckout")
	@ResponseBody
	public Map<Object,Object> getReturnCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String userid = (String)map.get("userid");
		String orgIds = "";
		if(userid!=null){
			SysUser sysUser = sysUserService.getById(Long.parseLong(userid));
			List<SysOrg> orgList = sysOrgService.getSubOrgans(sysUser.getAcd200());
			if(orgList!=null && !orgList.isEmpty()){
				if(orgList.size()==1){
					orgIds = orgList.get(0).getAcd200().toString();
				}else{
					for (int i = 0; i < orgList.size(); i++) {
						if(i==0){
							orgIds+= orgList.get(i).getAcd200();
						}else{
							orgIds+=","+orgList.get(i).getAcd200();
						}
					}
				}
			}else{
				orgIds = sysUser.getAcd200().toString();
			}
		}
		if("1".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "n.CHECKIN_DATE asc,n.id asc");
			queryFilter.getFilters().remove("sort");
		}else if("2".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "a.MARKET_POSITION asc");
			queryFilter.getFilters().remove("sort");
		}else{
			queryFilter.addFilter("orderField", "n.CHECKIN_DATE asc,n.id asc");
		}
		//queryFilter.addFilter("orderSeq", "asc");
		queryFilter.addFilter("ccpr08", 0);
		queryFilter.addFilter("checkoutStatusValue", 3);
		queryFilter.addFilter("checkinOrgIdApp", orgIds);
		ResultData<ArchiveCheckoutAppDto> resultData = archiveCheckoutService.getAllArchiveCheckoutApp(queryFilter);
	    return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
}
