package com.xunfeng.sys.console.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.config.model.SysConfig;
import com.xunfeng.sys.resource.interf.SysResourceServiceInterf;
import com.xunfeng.sys.resource.model.SysResource;
import com.xunfeng.sys.resource.repository.SysResourceRepository;
import com.xunfeng.sys.uums.model.SysDept;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 主控制器 
* @author wanghan 
* @createDate 2015年4月23日-上午10:14:54 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/console")
public class MainController extends BaseController {

	@Resource
	@Qualifier("sysResource")
	private SysResourceServiceInterf sysResourceService;
	/** 切换组织
	 * 
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping("turnToMain")
	public ModelAndView turnToMain(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.debug("....................................跳转....................................");
		return this.getView("console", "turnToMain");
	}

	/**
	 * 控制台页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("main")
	public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//当前用户
		SysUser curUser = ContextUtil.getCurrentUser();
//		SysResource sysResource=sysResourceService.getResByAlias("ROOTRES");
		
//		List<SysResource> sysResourceList=sysResourceService.getEhCacheUserResource( curUser,sysResource.getResId(),false);
		//List<SysResource> sysResourceList=sysResourceService.getResListByPaerentId(sysResource.getResId());
		List<SysResource> sysResourceList=SysResourceRepository.getSysResourceList(curUser);
		
		ModelAndView view=new ModelAndView("/sys/console/indexNew.jsp");
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg  sysOrg =ContextUtil.getCurrentUserOrg();
		SysDept sysDept = ContextUtil.getCurrentUserDept();
	 	SysConfig indexTitle = ContextUtil.getIndexTitle();
		view.addObject("sysResourceList", sysResourceList)
						.addObject("sysUser", sysUser)
						.addObject("sysOrg",sysOrg)
						.addObject("sysDept",sysDept)
					 	.addObject("indexTitle",indexTitle);
		return view;
	}

	/**
	 * 控制台页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("datagrid")
	public ModelAndView datagrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView view=null;
		view=new ModelAndView("/sys/console/datagrid.jsp");
		//return view;
		//
		return view;
	}
	
	
	/**
	 * 培训机构控制台页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("trainMain")
	public ModelAndView trainMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request.getSession().getAttribute("orgAccount")==null || request.getSession().getAttribute("pxOrgId").equals("")){
			return new ModelAndView("/trainLogin.jsp");
		}
		String orgAccount=(String) request.getSession().getAttribute("orgAccount");
		Long orgId=(Long)request.getSession().getAttribute("pxOrgId");
		ModelAndView view=new ModelAndView("/sys/console/indexTrain.jsp");
		view.addObject("orgAccount", orgAccount);
		view.addObject("orgId", orgId);
		return view;
	}

}
