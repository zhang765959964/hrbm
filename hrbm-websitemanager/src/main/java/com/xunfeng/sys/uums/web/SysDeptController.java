package com.xunfeng.sys.uums.web;

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
import com.xunfeng.sys.uums.interf.SysDeptServiceInterf;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysDept;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.web.form.SysDeptForm;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 科室表 控制器类 
* @author wanghan 
* @createDate 2015年4月30日-上午10:02:09 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/uums/sysDept/")
public class SysDeptController extends BaseController
{
	@Resource
	@Qualifier("sysdept")
	private SysDeptServiceInterf sysDeptService;
	
	@Resource
	@Qualifier("sysorg")
	private SysOrgServiceInterf sysOrgService;
	
	@Resource
    @Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	
	
	/**
	 * 添加或更新科室表。
	 * @param request
	 * @param response
	 * @param sysDeptForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新科室表")
	public void save(HttpServletRequest request, HttpServletResponse response,SysDeptForm sysDeptForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long dep001=RequestUtil.getLong(request,"dep001");
		    SysDept sysDept = sysDeptService.getById(dep001);
		    sysDept = sysDeptForm.getModel(sysDept);
			if(sysDeptForm.isMvcAdd()){
				resultMsg="添加部门信息";
				sysDept.setDep001(uniqueIdUtil.genId(SysDept.class.getName()));
				//设置经办人代码 经办机构代码
				sysDept.setAae011(String.valueOf(ContextUtil.getCurrentUserId()));
				sysDept.setAae019(ContextUtil.getCurrentUser().getAac003());
				sysDept.setAae017(String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
				sysDept.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());
				sysDept.setAae036(new Date());
				sysDeptService.add(sysDept);
			}else{
				resultMsg="更新部门信息";
			    sysDeptService.update(sysDept);
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
	 * 取得科室表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	/**
	 * 取得部门表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看部门信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		String acd200 = request.getParameter("acd200");
		if(StringUtil.isEmpty(acd200)){
			if(!SystemConst.KEY_MANAGER.equals(ContextUtil.getCurrentUser().getCczh01())){
			fiter.addFilter("acd200", ContextUtil.getCurrentUserOrg().getAcd200());
			}
		}
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		ResultData<SysDept> list= sysDeptService.getDepPageList(fiter);		
		return getTableData(list.getPageBean().getTotalCount(), list.getDataList());
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isExist")
	@Action(description = "判断部门是否存在")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<SysDept> list = sysDeptService.getAll(fiter);
			if (list != null && list.size() > 0) {
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			} else {
				resultMessage = new ResultMessage(ResultMessage.Fail, "不存在");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}
	
	/**
	 * 删除科室表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除科室表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long lAryId =RequestUtil.getLong(request, "dep001");	
			sysDeptService.delById(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除科室表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增科室表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增部门信息")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		SysDeptForm  sysDeptForm=new SysDeptForm();
		SysDept department = new SysDept();
		Object acd200 = request.getParameter("acd200");
		if(acd200!=null){
			//优先传入组织机构
			department.setAcd200(Long.parseLong(acd200.toString()));
		}else{
			//当前用户组织机构
			department.setAcd200(ContextUtil.getCurrentUserOrg().getAcd200());
		}
		sysDeptForm.putModel(department);
		ModelAndView modelAndView= new ModelAndView("/sys/uums/sysDeptEdit.jsp");
		return modelAndView.addObject("sysDeptForm",sysDeptForm).addObject("sysOrgs",getOrganSelectList());					
	}
	/**
	 * 	编辑科室表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑科室表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long dep001=RequestUtil.getLong(request,"dep001",0L);
		SysDept sysDept=sysDeptService.getById(dep001);
		SysDeptForm  sysDeptForm=new SysDeptForm();
		sysDeptForm.putModel(sysDept);
		List<SysOrg> sysOrgs  = getOrganSelectList();
		String orgName = null;
		for (SysOrg sysOrg : sysOrgs) {
			if(sysDept.getAcd200().equals(sysOrg.getAcd200())){
				orgName = sysOrg.getAcd202();
			}
		}
		return getAutoView().addObject("sysDeptForm",sysDeptForm).addObject("sysOrgs",sysOrgs).addObject("isEdit", true).addObject("orgName", orgName);					
	}

	/**
	 * 取得科室表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看科室表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long dep001=RequestUtil.getLong(request,"dep001");
		SysDept sysDept = sysDeptService.getById(dep001);	
		return getAutoView().addObject("sysDept", sysDept);
	}
	
	/**
	 * 部门人员查询页面跳转
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getDeptUsers")
	@Action(description="部门人员查询页面")
	public ModelAndView deptUsers(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/sys/uums/sysDeptUserList.jsp").addObject("dep001", request.getParameter("dep001")).addObject("acd200", request.getParameter("acd200"));
		return modelAndView;
	}
	
	/**
	 * 部门可添加人员页面跳转
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addDeptUsers")
	@Action(description="查询部门可以添加人员列表")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/sys/uums/sysAddDeptUserList.jsp").addObject("dep001", request.getParameter("dep001")).addObject("acd200", request.getParameter("acd200"));
		return modelAndView;
	}
	
	/**
	 * 部门人员查看
	 * @param request 
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listUsersJson")
	@Action(description="查看部门信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listUsersJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		ResultData<SysUser> list= sysUserService.getUserListPage(fiter);		
		return getTableData(list.getPageBean().getTotalCount(), list.getDataList());
	}
	
	/**
	 * 取得部门可添加人员列表
	 * @param request 
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listAddUsersJson")
	@Action(description="查看部门可添加人员列表")
	@ResponseBody
	public Map<Object,Object> listDeptUsersJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		ResultData<SysUser> list= sysUserService.getUserListOtherDeptPage(fiter);		
		return getTableData(list.getPageBean().getTotalCount(), list.getDataList());
	}
	
	/**
	 * 添加部门人员
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("addCheckUser")
	@Action(description="添加部门人员")
	@ResponseBody
	public ResultMessage removeCheckUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long dep001=RequestUtil.getLong(request, "dep001", 0);
			String acds= request.getParameter("acd230");
			Long orgId=RequestUtil.getLong(request, "acd200", 0);
			sysUserService.updateUserDept(acds, dep001, orgId);
//			sysUserService.delUserRoles(acds, String.valueOf(roleId));
			message=new ResultMessage(ResultMessage.Success, "添加部门人员成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "添加部门人员失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}
	
}