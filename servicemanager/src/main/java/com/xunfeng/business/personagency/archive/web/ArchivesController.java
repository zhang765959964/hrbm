package com.xunfeng.business.personagency.archive.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.spi.orb.Operation;
import com.xunfeng.util.Json;
import com.xunfeng.util.UserConversionOrg;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysOrgService;
import com.xunfeng.sys.uums.service.SysUserService;
import com.xunfeng.business.personagency.archive.dto.ArchiveAppDto;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.service.ArchiveCheckoutService;
import com.xunfeng.business.personagency.archive.service.ArchiveLendService;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 控制器类
* @author:jx
* @createDate 2016-11-07 18:19:23 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/archive/")
public class ArchivesController extends BaseController	
{
	@Resource
	private ArchivesService archivesService;
	@Resource
	private ArchiveCheckoutService archiveCheckoutService;
	@Resource
	private ArchiveLendService archiveLendService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysOrgService sysOrgService;
	
	//借阅、返还、调出、入库、未处理请求数接口   蒋鑫  2016.11.07
	@RequestMapping("operatedNumber")
	@ResponseBody
	public Map operatedNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		Map archiveMap = new HashMap();
		//借阅待确认
		Long jydqr = archiveCheckoutService.getArchivesCheckoutCount(1l,orgIds);
		//返还待确认
		Long fhdqr = archiveCheckoutService.getArchivesCheckoutCount(3l,orgIds);
		//调出待确认
		Long dcdqr = archiveLendService.getArchivesLendCount(4l,orgIds);
		//待入库条数
		Long drk = archivesService.getArchivesCount(1l, 9l, 1l,orgIds);
		//待处理总条数
		Long totalCount = jydqr+fhdqr+dcdqr+drk;
		archiveMap.put("totalCount", totalCount);
		archiveMap.put("jydqr", jydqr);
		archiveMap.put("fhdqr", fhdqr);
		archiveMap.put("dcdqr", dcdqr);
		archiveMap.put("drk", drk);
		return archiveMap;
	}
	
	//档案详情接口   蒋鑫  2016.11.14
	@RequestMapping("getArchivesDetail")
	@ResponseBody
	public ArchiveAppDto getArchivesDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String archiveCode = (String)map.get("archiveCode");
		String id = (String)map.get("id");
		if(StringUtil.isEmpty(archiveCode)){
			archiveCode = null;
		}
		if(StringUtil.isEmpty(id)){
			id = null;
		}
		if(id==null && archiveCode==null){
			id = "000000";
			archiveCode = "000000";
		}
	    ArchiveAppDto  archiveAppDto = archivesService.getArchivesAppBy(id, archiveCode);
	    return archiveAppDto;
	}
	
	@RequestMapping("operationConfirmation")
	@ResponseBody
	public Json operationConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Json json = new Json();
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String userid = (String)map.get("userid");
		String generalId = (String)map.get("generalId");
		String operationType = (String)map.get("operationType");
		if(StringUtil.isEmpty(userid)){
			json.setMsg("用户id为空");
		}else if(StringUtil.isEmpty(generalId)){
			json.setMsg("当前被操作数据id为空");
		}else if(StringUtil.isEmpty(operationType)){
			json.setMsg("当前被操作数据类型为空");
		}else{
			//获得app登录人信息
			SysUser sysUser = sysUserService.getById(Long.parseLong(userid));
			SysOrg sysOrg = sysOrgService.getById(sysUser.getAcd200()==null?1:sysUser.getAcd200());
			if("1".equals(operationType)){//借阅确认
				String result = archiveCheckoutService.addCurrencyRegisterCheckout(Long.parseLong(generalId), sysUser, sysOrg);
				if("1".equals(result)){
					json.setSuccess(true);
					json.setMsg("借阅确认成功！");
				}else if("2".equals(result)){
					json.setSuccess(false);
					json.setMsg("该数据已经借阅确认过！");
				}else{
					json.setSuccess(false);
					json.setMsg("借阅确认失败！");
				}
			}else if("2".equals(operationType)){//返还确认
				String result = archiveCheckoutService.addCurrencyReturnCheckout(Long.parseLong(generalId), sysUser, sysOrg);
				if("1".equals(result)){
					json.setSuccess(true);
					json.setMsg("返还确认成功！");
				}else if("2".equals(result)){
					json.setSuccess(false);
					json.setMsg("该数据已经返还确认过！");
				}else{
					json.setSuccess(false);
					json.setMsg("返还确认失败！");
				}
			}else if("3".equals(operationType)){//调出确认
				String result = archiveLendService.addCurrencyLendComfirm(Long.parseLong(generalId), sysUser, sysOrg);
				if("1".equals(result)){
					json.setSuccess(true);
					json.setMsg("调出确认成功！");
				}else if("2".equals(result)){
					json.setSuccess(false);
					json.setMsg("该数据已经调出确认过！");
				}else{
					json.setSuccess(false);
					json.setMsg("调出确认失败！");
				}
			}else if("4".equals(operationType)){//入库确认
				String result = archivesService.addCurrencyStoreConfirm(Long.parseLong(generalId), sysUser, sysOrg);
				if("1".equals(result)){
					json.setSuccess(true);
					json.setMsg("入库确认成功！");
				}else if("2".equals(result)){
					json.setSuccess(false);
					json.setMsg("该数据已经入库确认过！");
				}else{
					json.setSuccess(false);
					json.setMsg("入库确认失败！");
				}
			}else{
				json.setMsg("被操作的数据类型填写有误");
			}
		}
	    return json;
	}
	
}
