//package com.xunfeng.sys.role.web;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.xunfeng.core.annotion.Action;
//import com.xunfeng.core.util.ExceptionUtil;
//import com.xunfeng.core.web.ResultMessage;
//import com.xunfeng.core.web.controller.BaseController;
//import com.xunfeng.core.web.query.QueryFilter;
//import com.xunfeng.core.web.util.RequestUtil;
//import com.xunfeng.sys.role.interf.SysRoleResourceServiceInterf;
//import com.xunfeng.sys.role.model.SysRoleResource;
///**
// *<pre>
// * 对象功能:角色资源关系表 控制器类
// * 开发公司:河南讯丰信息技术有限公司
// * 开发人员:wanghan
// * 创建时间:2015-06-10 11:31:51
// *</pre>
// */
//@Controller
//@RequestMapping("/sys/role/sysRoleResource/")
//public class SysRoleResourceController extends BaseController
//{
//	@Resource
//	@Qualifier("sysRoleResource")
//	private SysRoleResourceServiceInterf sysRoleResourceService;
//	/**
//	 * 添加或更新角色资源关系表。
//	 */
//	@RequestMapping("addRoleRes")
//	@Action(description="分配资源")
//	@ResponseBody
//	public ResultMessage addRoleRes(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		
//				
//		ResultMessage message=null;
//		try{
//			long roleId=RequestUtil.getLong(request, "roleId", 0);
//			Long[] lAryId =RequestUtil.getLongAryByStr(request, "resIds");
//			sysRoleResourceService.addResource(roleId, lAryId);
//			message=new ResultMessage(ResultMessage.Success, "分配资源成功!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "分配资源失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//		return message;
//	}
//	/**
//	 * 取得角色资源关系表分页列表
//	 * @param request
//	 * @param response
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("list")
//	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		List<SysRoleResource> list=sysRoleResourceService.getAll(new QueryFilter(request,"sysRoleResourceItem"));
//		ModelAndView mv=this.getAutoView().addObject("sysRoleResourceList",list);
//		
//		return mv;
//	}
//	
//	/**
//	 * 删除角色资源关系表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("del")
//	@Action(description="删除角色资源关系表")
//	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		String preUrl= RequestUtil.getPrePage(request);
//		ResultMessage message=null;
//		try{
//			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
//			sysRoleResourceService.delByIds(lAryId);
//			message=new ResultMessage(ResultMessage.Success, "删除角色资源关系表成功!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//		addMessage(message, request);
//		response.sendRedirect(preUrl);
//	}
//	
//	/**
//	 * 	编辑角色资源关系表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("edit")
//	@Action(description="编辑角色资源关系表")
//	public ModelAndView edit(HttpServletRequest request) throws Exception
//	{
//		Long id=RequestUtil.getLong(request,"id",0L);
//		String returnUrl=RequestUtil.getPrePage(request);
//		SysRoleResource sysRoleResource=sysRoleResourceService.getById(id);
//		
//		return getAutoView().addObject("sysRoleResource",sysRoleResource)
//							.addObject("returnUrl",returnUrl);
//	}
//
//	/**
//	 * 取得角色资源关系表明细
//	 * @param request   
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("get")
//	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		Long id=RequestUtil.getLong(request,"id");
//		SysRoleResource sysRoleResource = sysRoleResourceService.getById(id);	
//		return getAutoView().addObject("sysRoleResource", sysRoleResource);
//	}
//	
//}
