package com.xunfeng.business.personagency.archive.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonEducationServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.personagency.archive.dto.StorageArchiveAppDto;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.receive.dto.GongZuoDto;
import com.xunfeng.business.personagency.receive.dto.JiaTingDto;
import com.xunfeng.business.personagency.receive.dto.JiaoYuDto;
import com.xunfeng.business.personagency.receive.dto.PersonBaseDto;
import com.xunfeng.business.personagency.receive.dto.ReceiveArchivesPersonDto;
import com.xunfeng.business.personagency.receive.interf.ReceiveArchivesServiceInterf;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysOrgService;
import com.xunfeng.sys.uums.service.SysUserService;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jx
* @createDate 2016年7月14日
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/storage/")
public class StorageArchivesController extends BaseController
{
	@Resource
	private ArchivesService archivesService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysOrgService sysOrgService;
	
	//档案入库数据接口   蒋鑫  2016.11.14
	@RequestMapping("getAllStoreArchives")
	@ResponseBody
	public Map<Object,Object> getAllStoreArchives(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			queryFilter.addFilter("orderField", "a.id");
			queryFilter.getFilters().remove("sort");
		}else if("2".equals(queryFilter.getFilters().get("sort"))){
			queryFilter.addFilter("orderField", "a.MARKET_POSITION");
			queryFilter.getFilters().remove("sort");
		}else{
			queryFilter.addFilter("orderField", "a.id");
		}
		queryFilter.addFilter("orderSeq", "asc");
		queryFilter.addFilter("archiveStatus", 1);
		queryFilter.addFilter("archiveFlowStatus", 9);
		queryFilter.addFilter("archiveReceiveStatus", 1);
		queryFilter.addFilter("archiveReceiveOrgIdApp", orgIds);
	    ResultData<StorageArchiveAppDto>  resultData = archivesService.getAllArchivesApp(queryFilter);
	    return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}

	
}
