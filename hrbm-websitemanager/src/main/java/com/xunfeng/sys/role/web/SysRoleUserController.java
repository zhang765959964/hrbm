package com.xunfeng.sys.role.web;

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
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.role.interf.SysRoleServiceInterf;
import com.xunfeng.sys.role.interf.SysRoleUserServiceInterf;
import com.xunfeng.sys.role.model.SysRole;
import com.xunfeng.sys.role.model.SysRoleUser;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;
/**
 *<pre>
 * 对象功能:角色人员关系表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-09 09:37:41
 *</pre>
 */
@Controller
@RequestMapping("/sys/role/sysRoleUser/")
public class SysRoleUserController extends BaseController
{
	@Resource	
    @Qualifier("sysRoleUser")
	private SysRoleUserServiceInterf sysRoleUserService;
	
	@Resource
    @Qualifier("sysuser")
	private SysUserServiceInterf sysUService;
	@Resource
	@Qualifier("sysRole")
	private SysRoleServiceInterf sysRoleService;

	@RequestMapping("addRoleUser")
	@Action(description="查看角色人员关系表分页列表")
	@ResponseBody
	public ResultMessage addRoleUser(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ResultMessage message=null;
		try{
			long roleId=RequestUtil.getLong(request, "roleId", 0);
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "userIds");
			sysRoleUserService.addUser(roleId, lAryId);
			message=new ResultMessage(ResultMessage.Success, "分配人员成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "分配人员失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}
	/**
	 * 取得角色人员关系表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description="查看角色人员关系表分页列表")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,Long roleId) throws Exception
	{	
		SysRole sysRole=sysRoleService.getById(roleId);
		ModelAndView mv=this.getAutoView().addObject("roleId", roleId).addObject("sysRole", sysRole);
		
		return mv;
	}
	/**
	 * 取得角色人员关系表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看角色人员关系表分页列表")
	@ResponseBody
	public Map<Object,Object>  listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter queryFilter= new QueryFilter(request);
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    queryFilter.setPageBean(pageBean);
		ResultData<SysUser> resultData=sysUService.getUserListPageByRoleId(queryFilter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除角色人员关系表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("removeRoleUser")
	@Action(description="删除角色人员关系表")
	@ResponseBody
	public ResultMessage removeRoleUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			long roleId=RequestUtil.getLong(request, "roleId", 0);
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "userIds");
			sysRoleUserService.delRoleUser(roleId, lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除角色人员关系表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}
	
	/**
	 * 	编辑角色人员关系表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑角色人员关系表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		String returnUrl=RequestUtil.getPrePage(request);
		SysRoleUser sysRoleUser=sysRoleUserService.getById(id);
		
		return getAutoView().addObject("sysRoleUser",sysRoleUser)
							.addObject("returnUrl",returnUrl);
	}

	/**
	 * 取得角色人员关系表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看角色人员关系表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SysRoleUser sysRoleUser = sysRoleUserService.getById(id);	
		return getAutoView().addObject("sysRoleUser", sysRoleUser);
	}
	
	/**
	 * 角色可添加人员页面跳转
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="查询角色可以添加人员列表")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/sys/role/sysAddRoleUserList.jsp").addObject("roleId", request.getParameter("roleId")).addObject("acd200", request.getParameter("acd200"));
		return modelAndView;
	}
	
	/**
	 * 角色可添加人员列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJsonUsers")
	@Action(description="查看角色可添加人员列表")
	@ResponseBody
	public Map<Object,Object>  listJsonUsers(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter queryFilter= new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		queryFilter.setPageBean(pageBean);
		ResultData<SysUser> resultData=sysUService.getUserListPageByNoRoleId(queryFilter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
 
	/**
	 * 角色用户添加
	 * @param request
	 * @param response
	 * @param sysUsers
	 * @throws Exception
	 */
	@RequestMapping("saveCheckUsers")
	@Action(description="角色用户添加")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResultMessage message=null;	
		try {
			String roleId = request.getParameter("roleId");
			String acds= request.getParameter("acd230");
			if(!StringUtil.isEmpty(acds)){
				sysUService.addUserRoles(acds, roleId);
				message=new ResultMessage(ResultMessage.Success, "添加成功");
				writeResultMessage(response.getWriter(),message);
			}	
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "添加失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	/**
	 * 删除角色人员关系表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("removeCheckUser")
	@Action(description="删除角色人员关系表")
	@ResponseBody
	public ResultMessage removeCheckUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			long roleId=RequestUtil.getLong(request, "roleId", 0);
			String acds= request.getParameter("acd230");
			sysUService.delUserRoles(acds, String.valueOf(roleId));
			message=new ResultMessage(ResultMessage.Success, "删除角色人员成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}
}
