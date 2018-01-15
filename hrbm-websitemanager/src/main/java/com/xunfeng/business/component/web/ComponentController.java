package com.xunfeng.business.component.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.corp.interf.CorpPositionServiceInter;
import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;
import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * 检索查询组件
 * @author lwh
 *
 */
@Controller
@RequestMapping("/business/component/component/")
public class ComponentController extends BaseController{
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	@Resource
	@Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	@Resource
	@Qualifier("personJobRegist")
	private PersonJobRegistServiceInter personJobRegistService;
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("corpPosition")
	private CorpPositionServiceInter corpPositionService;
	/**
	 * 获取经办人列表
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("viewUsers")
	@Action(description="查询部门可以添加人员列表")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/component/orgUserList.jsp").addObject("utype", request.getParameter("utype"));
		return modelAndView;
	}
	
	/**
	 * 取得经办人分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listUserJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listUserJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter=new QueryFilter(request);
		//添加用户组织ID
	    int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		fiter.addFilter("acd200", ContextUtil.getCurrentUserOrg().getAcd200());
		ResultData<SysUser> list= sysUserService.getUserListPage(addJurisdiction(fiter));		
		return getTableData(list.getPageBean().getTotalCount(), list.getDataList());
	}
	
	/**
	 * 取得求职个人信息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personList")
	public ModelAndView listView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/component/personComponentBaseInfoList.jsp");
		return modelAndView;
	}
	
	
	/**
	 * 取得求职人员信息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> personListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
	    fiter.addFilter("acb208n", "0");
	    ResultData<Map<String, Object>> resultData=personBaseInfoService.getCommPersonList(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 取得个人基本信息列表(V_AC01)
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personBaseList")
	public ModelAndView personBaseList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/component/personComponentInfoList.jsp");
		return modelAndView;
	}
	
	/**
	 * 取得个人基本信息列表(V_AC01)
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personBaseListJson")
	@Action(description="个人基本信息")
	@ResponseBody
	public Map<Object,Object> personBaseListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
//	    fiter.addFilter("acb208n", "0");
	    ResultData<Map<String, Object>> resultData=personBaseInfoService.getCommBasePersonList(addJurisdiction(fiter));
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 个人求职意向获得
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personJobReg")
	@Action(description="查询个人求职意向")
	@ResponseBody
	public PersonJobRegist personJobReg(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Long aac001 =RequestUtil.getLong(request, "aac001",0);
		PersonJobRegist jobRegist = personJobRegistService.getByPersonId(aac001);
		return jobRegist;
	}
	
	/**
	 * 单位信息查询列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpList")
	public ModelAndView corpList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/component/corpList.jsp");
		return modelAndView;
	}
	
	/**
	 * 取得单位基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listCorpJson")
	@Action(description="取得单位基本信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listCorpJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
	    fiter.addFilter("aab01dforcomm", true);
		ResultData<Corp> resultData=corpService.getAllCorp(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 单位招聘岗位列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpPostionList")
	public ModelAndView corpPostionList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/component/corpPostionList.jsp");
		return modelAndView;
	}
	
	/**
	 * 招聘职位信息查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpPositionListView")
	public ModelAndView corpPositionListView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{     
		return new ModelAndView("/business/component/corpPositionComponentList.jsp").addObject("orgs", getOrganSelectList());
	}
	/**
	 * 招聘职位信息查询列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */                                                                                              
	@RequestMapping("corpPositionListJson")
	@Action(description="招聘职位信息分页列表")
	@ResponseBody
	public Map<Object,Object> corpPositionListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		if(StringUtil.isNotEmpty(request.getParameter("acc214"))){
			fiter.addFilter("acc214", request.getParameter("acc214").split(","));
		}
		ResultData<Map<String,Object>>  resultData =corpPositionService.getCorpPositionComponentViewList(addJurisdiction(fiter));	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
}
