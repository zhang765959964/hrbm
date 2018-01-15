package com.xunfeng.sys.role.web;

import java.util.Date;
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
import com.xunfeng.sys.role.interf.SysRoleServiceInterf;
import com.xunfeng.sys.role.model.SysRole;
import com.xunfeng.sys.role.web.form.SysRoleForm;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;
import com.xunfeng.sys.uums.model.SysOrg;
/**
 *<pre>
 * 对象功能:系统角色表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-08 16:08:57
 *</pre>
 */
@Controller
@RequestMapping("/sys/role/sysRole/")
public class SysRoleController extends BaseController
{
	@Resource
	@Qualifier("sysRole")
	private SysRoleServiceInterf sysRoleService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("sysorg")
	private SysOrgServiceInterf sysOrgService;
	
	/**
	 * 添加或更新系统角色表。
	 * @param request
	 * @param response
	 * @param sysRole 添加或更新的实体
	 * @param bindResult
	 * @param viewName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新角色表")
	public void save(HttpServletRequest request, HttpServletResponse response,SysRoleForm sysRoleForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long roleid=RequestUtil.getLong(request,"roleid");
		    SysRole sysRole = sysRoleService.getById(roleid);
		    sysRole=sysRoleForm.getModel(sysRole);
		    //设置经办人信息
		    sysRole.setAae011(String.valueOf(ContextUtil.getCurrentUserId()));
		    sysRole.setAae019(ContextUtil.getCurrentUser().getAac003());
		    //设置所属机构信息
		    
		    //设置经办时间
		    sysRole.setAae036(new Date());
			if(sysRoleForm.isMvcAdd()){
				resultMsg="添加角色信息";
				sysRole.setRoleid(uniqueIdUtil.genId(SysRole.class.getName()));
				sysRoleService.add(sysRole);
				
			}else{
				resultMsg="更新角色信息";
				sysRoleService.update(sysRole);
				
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得系统角色表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description="查看系统角色信息分页列表")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	@RequestMapping("listJson")
	@Action(description="查看系统资源表列表数据")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	QueryFilter fiter=new QueryFilter(request);
		String aae017 = request.getParameter("aae017");
		if(StringUtil.isEmpty(aae017)){
			if(!SystemConst.KEY_MANAGER.equals( ContextUtil.getCurrentUser().getCczh01()))
			fiter.addFilter("aae017", ContextUtil.getCurrentUserOrg().getAcd200());
		}
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData<SysRole>  resultData= sysRoleService.getPageList(fiter);
		 
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
		
	}
	/**
	 * 删除系统角色表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除系统角色表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "roleIds");
			sysRoleService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除系统角色表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 	编辑角色表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑角色表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long roleid=RequestUtil.getLong(request,"roleid",0L);
		SysRole sysRole=sysRoleService.getById(roleid);
		SysRoleForm  sysRoleForm=new SysRoleForm();
		sysRoleForm.putModel(sysRole);
		
		return getAutoView().addObject("sysRoleForm",sysRoleForm).addObject("sysOrgs", getOrganSelectList());
	}

	/**
	 * 	新增角色信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增角色信息")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		String aae017 = request.getParameter("aae017");
		SysRole sysRole = new SysRole();
		//默认传入组织ID或者当前登录用户组织id
        sysRole.setAae017(StringUtil.isEmpty(aae017)?ContextUtil.getCurrentUserOrg().getAae017():aae017);
		SysRoleForm  sysRoleForm=new SysRoleForm();
		sysRoleForm.putModel(sysRole);
		ModelAndView modelAndView= new ModelAndView("/sys/role/sysRoleEdit.jsp");
		
		return modelAndView.addObject("sysRoleForm",sysRoleForm).addObject("sysOrgs", getOrganSelectList());				
	}

	/**
	 * 取得系统角色表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看系统角色表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long roleId=RequestUtil.getLong(request,"roleId");
		SysRole sysRole = sysRoleService.getById(roleId);	
		return getAutoView().addObject("sysRole", sysRole);
	}
	
}
