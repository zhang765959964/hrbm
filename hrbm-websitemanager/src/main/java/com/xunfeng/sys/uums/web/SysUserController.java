package com.xunfeng.sys.uums.web;

import java.util.ArrayList;
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
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.uums.interf.SysDeptServiceInterf;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysDept;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.web.form.SysUserForm;

/**
 * <pre>
 * 对象功能:从业人员信息表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-27 16:40:20
 * </pre>
 */
@Controller
@RequestMapping("/sys/uums/sysUser/")
public class SysUserController extends BaseController {
	@Resource
	@Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	@Resource
	@Qualifier("sysdept")
	private SysDeptServiceInterf sysDeptService;

	/**
	 * 添加或更新从业人员信息表。
	 * @param request
	 * @param response
	 * @param sysUserForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新从业人员信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,SysUserForm sysUserForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long acd230=RequestUtil.getLong(request,"acd230");
		    SysUser sysUser = sysUserService.getById(acd230);
			sysUser=sysUserForm.getModel(sysUser);
			//有效标记
			sysUser.setCcpr08(SystemConst.STATIC_VALUE_ZERO);
			sysUser.setUpdatetime(new Date());
			sysUser.setUpdateBy(ContextUtil.getCurrentUserId());
			if(sysUserForm.isMvcAdd()){
				sysUser.setAae011(String.valueOf(ContextUtil.getCurrentUserId()));
				sysUser.setAae019(ContextUtil.getCurrentUser().getAac003());
				sysUser.setAae036(new Date());
				sysUser.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());
				sysUser.setAae017(String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
				resultMsg="添加用户信息";
				sysUser.setAcd230(uniqueIdUtil.genId(SysUser.class.getName()));
				sysUserService.add(sysUser);
				
			}else{
				resultMsg="更新用户信息表";
			    sysUserService.update(sysUser);
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
	 * 取得从业人员信息表分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description = "查看从业人员信息表分页列表")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// List<SysUser> list=sysUserService.getAll(new
		// QueryFilter(request,"sysUserItem"));
		String adminAccount = SysUser.getAdminAccount();
		ModelAndView mv = this.getAutoView().addObject("adminAccount",
				adminAccount);

		return mv;
	}

	/**
	 * 取得从业人员信息表分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter=new QueryFilter(request);
		//添加用户组织ID
	    int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		ResultData<SysUser> list= sysUserService.getUserListPage(addJurisdiction(fiter));		
		return getTableData(list.getPageBean().getTotalCount(), list.getDataList());
	}

	/**
	 * 删除从业人员信息表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description = "删除从业人员信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String preUrl = RequestUtil.getPrePage(request);
		ResultMessage message = null;
		try {

			Long[] lAryId = RequestUtil.getLongAryByStr(request, "acd230");
			sysUserService.delByIds(lAryId);
			message = new ResultMessage(ResultMessage.Success, "删除从业人员信息表成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "删除失败"
					+ ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	/**
	 * 编辑从业人员信息表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑从业人员信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long acd230 = RequestUtil.getLong(request, "acd230", 0L);
		SysUser sysUser = sysUserService.getById(acd230);
		SysUserForm sysUserForm = new SysUserForm();
		sysUserForm.putModel(sysUser);
		List<SysOrg> orgs = this.getOrganSelectList();
		Long orgId = null;
		if(sysUser!=null&&sysUser.getAcd200()!=null){
			orgId = sysUser.getAcd200();
		}else{
			if(orgs!=null&&orgs.size()>0)
			orgId = orgs.get(0).getAcd200();
		}
		return getAutoView().addObject("sysUserForm", sysUserForm).addObject(
				"sysorgs", orgs).addObject("sysdepts", orgId==null?new ArrayList<SysDept>(0):this.getDeptListByOrgId(orgId));
	}

	/**
	 * 取得从业人员信息表明细
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description = "查看从业人员信息表明细")
	public ModelAndView get(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long acd230 = RequestUtil.getLong(request, "acd230");
		SysUser sysUser = sysUserService.getById(acd230);
		return getAutoView().addObject("sysUser", sysUser);
	}

	/**
	 * 部门引入人员
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("setUserDept")
	@Action(description = "部门引入人员")
	@ResponseBody
	public ResultMessage setUserDept(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage message = null;
		String resultMsg = null;
		try {
			String userIds = request.getParameter("acd230");
			Long deptId = RequestUtil.getLong(request, "dep001");
			SysDept sysDept = sysDeptService.getById(deptId);
			if (sysDept != null) {
				resultMsg = "部门引入人员";
			} else {
				resultMsg = "部门移除人员";
			}
			sysUserService.updateUserDept(userIds, sysDept == null ? null
					: deptId, sysDept == null ? 0 : sysDept.getAcd200());
			message = new ResultMessage(ResultMessage.Success, resultMsg
					+ "成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败"
					+ ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isExist")
	@Action(description = "判断是否存在")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;

		try {
			QueryFilter fiter = new QueryFilter(request);
			if(SystemConst.KEY_MANAGER.equals(request.getParameter("cczh01"))){
				return new ResultMessage(ResultMessage.Success, "已经存在");
			}
			List<SysUser> list = sysUserService.getAll(fiter);
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
	 * 编辑从业人员信息表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("modify")
	@Action(description = "编辑从业人员信息表")
	public ModelAndView modify(HttpServletRequest request) throws Exception {
		Long acd230 = RequestUtil.getLong(request, "acd230");
		String returnUrl = RequestUtil.getPrePage(request);
		SysUser sysUser = sysUserService.getById(acd230);
		return getAutoView().addObject("sysUser", sysUser).addObject(
				"returnUrl", returnUrl);
	}

	/**
	 * 修改密码。
	 * 
	 * @param request
	 * @param response
	 * @param sysUser
	 *            修改密码
	 */
	@RequestMapping("modifySave")
	@Action(description = "修改密码")
	public void modifySave(HttpServletRequest request,
			HttpServletResponse response, SysUser sysUser) throws Exception {
		String resultMsg = "修改密码";
		ResultMessage message = null;
		try {
			if (sysUser.getAcd230() != null && sysUser.getAcd230() != 0) {
				SysUser sysUse = sysUserService.getById(sysUser.getAcd230());
				sysUse.setCczh02(sysUser.getNewCczh02());
				sysUserService.update(sysUse);
				message = new ResultMessage(ResultMessage.Success, resultMsg
						+ "成功");
			} else {
				message = new ResultMessage(ResultMessage.Fail, resultMsg
						+ "失败");
			}
			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}
	
	/**
	 * 查询机构下部门
	 * @param request 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("queryDepts")
	@Action(description = "查询机构下部门")
	@ResponseBody
	public List<SysDept> queryDepts(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<SysDept> depts = new ArrayList<SysDept>();
		Long orgId = RequestUtil.getLong(request, "acd200");
		if(orgId!=null){
			depts = this.getDeptListByOrgId(orgId);
		}
		return depts;
	}
	
	/**
	 * 获取机构下部门
	 * 
	 * @param orgId
	 *            所属机构ID
	 * @return 返回集合
	 */
	public List<SysDept> getDeptListByOrgId(Long orgId) {
		QueryFilter fiter = new QueryFilter();
		fiter.addFilter("acd200", orgId);
		return sysDeptService.getAll(fiter);
	}

	// 关于公司
	@RequestMapping("about")
	public ModelAndView about(HttpServletRequest request) throws Exception {
		ModelAndView mv = this.getAutoView();
		return mv;
	}
}
