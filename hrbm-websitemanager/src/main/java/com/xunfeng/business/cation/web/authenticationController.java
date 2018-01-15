//package com.xunfeng.business.cation.web;
//
//import java.util.List;
//import java.util.Map;
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
//import com.xunfeng.business.cation.interf.AuthenticationServiceInterf;
//import com.xunfeng.business.cation.model.Authentication;
//import com.xunfeng.business.cation.web.form.AuthenticationForm;
//import com.xunfeng.core.annotion.Action;
//import com.xunfeng.core.util.ExceptionUtil;
//import com.xunfeng.core.util.UniqueIdUtil;
//import com.xunfeng.core.web.ResultMessage;
//import com.xunfeng.core.web.controller.BaseController;
//import com.xunfeng.core.web.query.QueryFilter;
//import com.xunfeng.core.web.util.RequestUtil;
// /** 
//* @company:河南讯丰信息技术有限公司
//* @Description: 网上认证提交信息表 控制器类
//* @author:wanghan
//* @createDate 2015-11-11 18:17:38 
//* @version V1.0   
//*/
//@Controller
//@RequestMapping("/business/cation/authentication/")
//public class authenticationController extends BaseController
//{
//	@Resource
//	@Qualifier("authentication")
//	private AuthenticationServiceInterf authenticationService;
//	
//	
//	/**
//	 * 添加或更新网上认证提交信息表。
//	 * @param request
//	 * @param response
//	 * @param authentication 添加或更新的实体
//	 * @param bindResult
//	 * @param viewName
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("save")
//	@Action(description="添加或更新网上认证提交信息表")
//	public void save(HttpServletRequest request, HttpServletResponse response,AuthenticationForm authenticationForm) throws Exception
//	{
//		String resultMsg=null;	
//		ResultMessage message=null;	
//		
//		try{
//		    Long caoa01=RequestUtil.getLong(request,"caoa01");
//		    Authentication authentication = authenticationService.getById(caoa01);
//			authentication=authenticationForm.getModel(authentication);
//			if(authenticationForm.isMvcAdd()){
//				resultMsg="添加网上认证提交信息表";
//				authentication.setCaoa01(UniqueIdUtil.genId());
//				authenticationService.add(authentication);
//				
//			}else{
//				resultMsg="更新网上认证提交信息表";
//			    authenticationService.update(authentication);
//				
//			}
//			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
//
//			writeResultMessage(response.getWriter(),message);
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(),message);
//		}
//	}
//	
//	
//	/**
//	 * 取得网上认证提交信息表分页列表
//	 * @param request
//	 * @param response
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("list")
//	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		ModelAndView mv=this.getAutoView();
//		
//		return mv;
//	}
//	/**
//	 * 取得网上认证提交信息表分页列表
//	 * @param request
//	 * @param response
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("listJson")
//	@Action(description="查看从业人员信息表分页列表")
//	@ResponseBody
//	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		QueryFilter fiter=new QueryFilter(request);
//		List<Authentication> list=authenticationService.getAll(fiter);		
//		return getTableData(fiter.getPageBean().getTotalCount(), list);
//	}
//	/**
//	 * 删除网上认证提交信息表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("del")
//	@Action(description="删除网上认证提交信息表")
//	@ResponseBody
//	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//
//		ResultMessage message=null;
//		try{
//			Long[] lAryId =RequestUtil.getLongAryByStr(request, "caoa01");
//			authenticationService.delByIds(lAryId);
//			message=new ResultMessage(ResultMessage.Success, "删除网上认证提交信息表成功!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//        return message;
//	}
//		/**
//	 * 	新增网上认证提交信息表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("add")
//	@Action(description="新增网上认证提交信息表")
//	public ModelAndView add(HttpServletRequest request) throws Exception
//	{
//		AuthenticationForm  authenticationForm=new AuthenticationForm();
//		authenticationForm.putModel(null);
//		ModelAndView modelAndView= new ModelAndView("/business/cation/authenticationEdit.jsp");
//		
//		return modelAndView.addObject("authenticationForm",authenticationForm);					
//	}
//	/**
//	 * 	编辑网上认证提交信息表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("edit")
//	@Action(description="编辑网上认证提交信息表")
//	public ModelAndView edit(HttpServletRequest request) throws Exception
//	{
//		Long caoa01=RequestUtil.getLong(request,"caoa01",0L);
//		Authentication authentication=authenticationService.getById(caoa01);
//		AuthenticationForm  authenticationForm=new AuthenticationForm();
//		authenticationForm.putModel(authentication);
//		
//		return getAutoView().addObject("authenticationForm",authenticationForm);					
//	}
//
//	/**
//	 * 取得网上认证提交信息表明细
//	 * @param request   
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("get")
//	@Action(description="查看网上认证提交信息表明细")
//	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		Long caoa01=RequestUtil.getLong(request,"caoa01");
//		Authentication authentication = authenticationService.getById(caoa01);	
//		return getAutoView().addObject("authentication", authentication);
//	}
//	
//}
