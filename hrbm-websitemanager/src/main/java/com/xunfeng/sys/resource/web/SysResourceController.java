package com.xunfeng.sys.resource.web;

import java.util.ArrayList;
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

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.resource.interf.SysResourceServiceInterf;
import com.xunfeng.sys.resource.model.SysResource;
import com.xunfeng.sys.resource.web.form.SysResourceForm;
import com.xunfeng.sys.role.interf.SysRoleResourceServiceInterf;
import com.xunfeng.sys.role.interf.SysRoleServiceInterf;
import com.xunfeng.sys.role.model.SysRole;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wanghan
 * @createDate 2015年4月29日-上午8:44:59
 * @version V1.0
 */
@Controller
@RequestMapping("/sys/resource/sysResource/")
public class SysResourceController extends BaseController {
	@Resource
	@Qualifier("sysResource")
	private SysResourceServiceInterf sysResourceService;

	@Resource
	@Qualifier("sysRole")
	private SysRoleServiceInterf sysRoleService;

	@Resource
	@Qualifier("sysRoleResource")
	private SysRoleResourceServiceInterf sysRoleResourceService;

	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;

	/**
	 * 取得系统资源表分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = this.getAutoView();

		return mv;
	}

	@RequestMapping("tree")
	public ModelAndView tree(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long roleId = RequestUtil.getLong(request, "roleId", 0L);
		SysRole sysRole = sysRoleService.getById(roleId);
		ModelAndView mv = this.getAutoView().addObject("roleId", roleId)
				.addObject("sysRole", sysRole);
		return mv;
	}

	@RequestMapping("listJson")
	@ResponseBody
	public Map<Object, Object> listJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		int limit = RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean = WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		ResultData<SysResource> sysResourceList = sysResourceService
				.getPageList(fiter);
		return getTableData(sysResourceList.getPageBean().getTotalCount(),
				sysResourceList.getDataList());

	}

	//
	// /**
	// * 删除系统资源表
	// * @param request
	// * @param response
	// * @throws Exception
	// */
	// @RequestMapping("del")
	// @Action(description="删除系统资源表")
	// @ResponseBody
	// public ResultMessage del(HttpServletRequest request, HttpServletResponse
	// response) throws Exception
	// {
	//
	// ResultMessage message=null;
	// try{
	// Long[] lAryId =RequestUtil.getLongAryByStr(request, "resIds");
	// sysResourceService.delByIds(lAryId);
	// message=new ResultMessage(ResultMessage.Success, "删除系统资源表成功!");
	//
	// }catch(Exception ex){
	//
	// message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
	// logger.error(ExceptionUtil.getExceptionMessage(ex));
	// }
	// return message;
	// }
	//
	/**
	 * 添加或更新功能模块表。
	 * 
	 * @param request
	 * @param response
	 * @param sysResourceForm
	 *            添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新功能模块表")
	public void save(HttpServletRequest request, HttpServletResponse response,
			SysResourceForm sysResourceForm) throws Exception {
		String resultMsg = null;
		ResultMessage message = null;
		try {
			Long funid = RequestUtil.getLong(request, "funid");
			SysResource sysResource = sysResourceService.getById(funid);
			sysResource = sysResourceForm.getModel(sysResource);
			sysResource.setFunuse(new Long(0));
			if (sysResourceForm.isMvcAdd()) {
				resultMsg = "添加功能模块表";
				//sysResource.setFunid(uniqueIdUtil.genSeqId(SqeIdName.SysResource.getSeqName()));
				sysResource.setFunid(uniqueIdUtil.genId(SysResource.class.getName()));
				sysResourceService.add(sysResource);
			} else {
				resultMsg = "更新功能模块表";
				sysResourceService.update(sysResource);
			}
			message = new ResultMessage(ResultMessage.Success, resultMsg + "成功");
			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

	/**
	 * 新增功能模块表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description = "新增功能模块表")
	public ModelAndView add(HttpServletRequest request) throws Exception {
		SysResourceForm sysResourceForm = new SysResourceForm();
		SysResource sysResource = new SysResource();
		sysResource.setFunpid(RequestUtil.getLong(request, "funpid", 0L));
		sysResourceForm.putModel(sysResource);
		ModelAndView modelAndView = new ModelAndView(
				"/sys/resource/sysResourceEdit.jsp");
		String parName = "";
		if(sysResource.getFunpid()!=0){
			SysResource sysResourcePar = sysResourceService.getById(sysResource.getFunpid());
			parName = sysResourcePar.getFunname();
			sysResourceForm.setFunplat(sysResourcePar.getFunplat());
		}
		return modelAndView.addObject("sysResourceForm", sysResourceForm).addObject("parName",parName);
	}

	/**
	 * 编辑功能模块表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑功能模块表")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long funid = RequestUtil.getLong(request, "funid", 0L);
		SysResource sysResource = sysResourceService.getById(funid);
		String parName = "";
		if(sysResource.getFunpid()!=0){
			SysResource sysResourcePar = sysResourceService.getById(sysResource.getFunpid());
			parName = sysResourcePar.getFunname();
		}
		SysResourceForm sysResourceForm = new SysResourceForm();
		sysResourceForm.putModel(sysResource);
		return getAutoView().addObject("sysResourceForm", sysResourceForm).addObject("parName", parName).addObject("isEdit", true);
	}

	//
	// /**
	// * 取得系统资源表明细
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("get")
	// public ModelAndView get(HttpServletRequest request, HttpServletResponse
	// response) throws Exception
	// {
	// Long resId=RequestUtil.getLong(request,"resId");
	// SysResource sysResource = sysResourceService.getById(resId);
	// return getAutoView().addObject("sysResource", sysResource);
	// }
	//
	// /**
	// * 首页导航菜单加载的资源树
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("treeJson")
	// @ResponseBody
	// public List treeJson(HttpServletRequest request,HttpServletResponse
	// response) throws Exception
	// {
	// List list=new ArrayList();
	// Long resId=RequestUtil.getLong(request,"resId");
	// SysUser curUser = ContextUtil.getCurrentUser();
	// List<SysResource> sysResourceList =
	// sysResourceService.getEhCacheUserResource(curUser,1L,true);
	// list.addAll(sysResourceList);
	// return list;
	//
	// }

	@RequestMapping("resTreeJson")
	@ResponseBody
	public List<SysResource> resTreeJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long roleId = RequestUtil.getLong(request, "roleId");
		// Long roleId=RequestUtil.getLong(request,"roleId");
		List<SysResource> sysResourceList = sysResourceService
				.getRoleResourceTree(roleId, ContextUtil.getCurrentUserId(),
						SystemConst.KEY_MANAGER.equals(ContextUtil.getCurrentUser().getCczh01()));
		if(SystemConst.KEY_MANAGER.equals(ContextUtil.getCurrentUser().getCczh01())){
			List<SysResource> sysRess = new ArrayList<SysResource>();
			SysResource sysResource = new SysResource();
			sysResource.setFunid(new Long(0));
			sysResource.setFunpid(new Long(0));
			sysResource.setFunname("根目录");
			sysRess.add(sysResource);
			sysRess.addAll(sysResourceList);
			return sysRess;
		}
		return sysResourceList;

	}

	/**
	 * 新增功能模块表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("resourceTree")
	@Action(description = "新增功能模块表")
	public ModelAndView resourceTree(HttpServletRequest request)
			throws Exception {
		SysResourceForm sysResourceForm = new SysResourceForm();
		ModelAndView modelAndView = new ModelAndView(
				"/sys/resource/sysResourceTree.jsp");

		return modelAndView
				.addObject("sysResourceForm", sysResourceForm)
				.addObject("roleId", RequestUtil.getLong(request, "roleId", 0L));
	}

	/**
	 * 修改角色权限
	 * 
	 * @param request
	 * @param response
	 * @param sysResource
	 *            添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveTree")
	@Action(description = "添加或修改角色权限")
	public void save(HttpServletRequest request, HttpServletResponse response)
			throws Exception { // resIds
		Long roleId = RequestUtil.getLong(request, "roleId");
		String resIds = request.getParameter("resIds");
		ResultMessage message = null;
		try {
			if (!StringUtil.isEmpty(resIds)) {
				if(resIds.startsWith("0,")){
					resIds=resIds.substring(2,resIds.length());
				}
				sysRoleResourceService.addResource(roleId, resIds.split(","));
			}else{
				//清空所有权限
				sysRoleResourceService.addResource(roleId,null);
			}
			message = new ResultMessage(ResultMessage.Success, "修改角色权限成功");
			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "修改角色权限失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

}
