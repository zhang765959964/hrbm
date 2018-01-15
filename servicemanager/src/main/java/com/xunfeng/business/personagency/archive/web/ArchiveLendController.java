package com.xunfeng.business.personagency.archive.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysOrgService;
import com.xunfeng.sys.uums.service.SysUserService;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.dto.ArchiveLendAppDto;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.business.personagency.archive.service.ArchiveLendService;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 控制器类
* @author:jx
* @createDate 2016-07-12 10:08:56 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/archiveLend/")
public class ArchiveLendController extends BaseController
{
	@Resource
	private ArchiveLendService archiveLendService;
	@Resource
	private ArchivesService archivesService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysOrgService sysOrgService;
	
	//调出数据接口   蒋鑫  2016.11.22
	@RequestMapping("getArchiveLend")
	@ResponseBody
	public Map<Object,Object> getArchiveLend(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			queryFilter.addFilter("orderField", "m.LEND_CREATER_DATE asc,m.LEND_ID asc ");
			queryFilter.getFilters().remove("sort");
		}else if("2".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "a.MARKET_POSITION asc ");
			queryFilter.getFilters().remove("sort");
		}else{
			queryFilter.addFilter("orderField", "m.LEND_CREATER_DATE asc,m.LEND_ID asc ");
		}
		//queryFilter.addFilter("orderSeq", "asc");
		queryFilter.addFilter("lendFlowStatus", 4);
		queryFilter.addFilter("lendCreaterOrgIdApp", orgIds);
	    ResultData<ArchiveLendAppDto>  resultData = archiveLendService.getAllArchiveLendApp(queryFilter);
	    return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
}
