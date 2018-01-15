package com.xunfeng.business.dissupport.divice.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanzUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.corp.interf.CorpPositionServiceInter;
import com.xunfeng.business.dissupport.divice.model.DiviConfig;
import com.xunfeng.business.dissupport.divice.web.form.DiviConfigForm;
import com.xunfeng.business.dissupport.divice.interf.DiviConfigServiceInterf;
import com.xunfeng.business.dissupport.divice.interf.DiviceModelServiceInterf;
import com.xunfeng.business.jobfair.interf.JobFairInfoServiceInter;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备配置表 控制器类
* @author:wanghan
* @createDate 2016-07-28 15:30:48 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/divice/diviConfig/")
public class DiviConfigController extends BaseController
{
	@Resource
	@Qualifier("diviConfig")
	private DiviConfigServiceInterf diviConfigService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("diviceModel")
	private DiviceModelServiceInterf diviceModelService;
	@Resource
	@Qualifier("corpPosition")
	private CorpPositionServiceInter corpPositionService;
	@Resource
	@Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	/**
	 * 添加或更新设备配置表。
	 * @param request
	 * @param response
	 * @param diviConfigForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新设备配置表")
	public void save(HttpServletRequest request, HttpServletResponse response,DiviConfigForm diviConfigForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long con001=RequestUtil.getLong(request,"con001");
		    DiviConfig diviConfig = diviConfigService.getById(con001);
		    diviConfig=diviConfigForm.getModel(diviConfig);
			String bsQuery = BeanzUtils.getBaseQuery(diviConfigForm, SystemConst.BS_TYPE);
			String csQuery = BeanzUtils.getBaseQuery(diviConfigForm, SystemConst.CS_TYPE);
			diviConfig.setCon999(bsQuery.concat(" AND ").concat(csQuery));
			diviConfig.setCon099(csQuery);
			diviConfig.setCon299(bsQuery);
			//设置修改信息
//			diviConfig.setCon229(String.valueOf(ContextUtil.getCurrentUserId()));
//			diviConfig.setCon230(new Date());
			
			if(diviConfigForm.isMvcAdd()){
				resultMsg="添加检索设置";
				diviConfig.setCon227(String.valueOf(ContextUtil.getCurrentUserId()));
				diviConfig.setCon228(new Date());
				diviConfig.setCon001(uniqueIdUtil.genId(DiviConfig.class.getName()));
				diviConfigService.add(diviConfig);
				
			}else{
				resultMsg="更新检索设置";
			    diviConfigService.update(diviConfig);
				
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
	 * 取得设备配置表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/divice/diviConfigList.jsp").addObject("models",diviceModelService.getAll());
		
		return mv;
	}
	/**
	 * 取得设备配置表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData<Map<String, Object>> resultData=diviConfigService.getViewList(addJurisdiction(fiter));		
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除设备配置表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除设备配置表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "con001");
			diviConfigService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除设备配置表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增设备配置表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增设备配置表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		DiviConfigForm  diviConfigForm=new DiviConfigForm();
		diviConfigForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/diviConfigEdit.jsp");
		return modelAndView.addObject("diviConfigForm",diviConfigForm);					
	}
	/**
	 * 	编辑设备配置表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑设备配置表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long con001=RequestUtil.getLong(request,"con001",0L);
		DiviConfig diviConfig=diviConfigService.getById(con001);
		DiviConfigForm  diviConfigForm=new DiviConfigForm();
		diviConfigForm.putModel(diviConfig);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/diviConfigEdit.jsp");
		return modelAndView.addObject("diviConfigForm",diviConfigForm);					
	}

	/**
	 * 	编辑设备配置表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("diviConfigQueryList")
	@Action(description="编辑设备配置表")
	public ModelAndView diviConfigQueryList(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/diviConfigQueryList.jsp");
		DiviConfigForm  diviConfigForm=new DiviConfigForm();
		if(StringUtil.isNotEmpty(request.getParameter("con001"))){
			Long con001=RequestUtil.getLong(request,"con001",0L);
			DiviConfig diviConfig=diviConfigService.getById(con001);
			diviConfigForm.putModel(diviConfig);
			if(StringUtil.isNotEmpty(diviConfig.getCon215())){
				SysUser sysUser =sysUserService.getById(Long.valueOf(diviConfig.getCon215()));
				modelAndView.addObject("updateName", sysUser.getAac003());
			}
			if(StringUtil.isNotEmpty(diviConfig.getBae011())){
				SysUser sysUser =sysUserService.getById(Long.valueOf(diviConfig.getBae011()));
				modelAndView.addObject("addName", sysUser.getAac003());
			}
		}else{
			diviConfigForm.putModel(null);
		}
		return modelAndView.addObject("diviConfigForm",diviConfigForm).addObject("models",diviceModelService.getAll()).addObject("orgs", getOrganSelectList());					
	}
	
	/**
	 * 发布屏检索设置列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */                                                                                              
	@RequestMapping("corpPositionListJson")
	@Action(description="发布屏检索设置列表")
	@ResponseBody
	public Map<Object,Object> corpPositionListJson(HttpServletRequest request,HttpServletResponse response,DiviConfigForm diviConfigForm) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		String bsQuery = BeanzUtils.getBaseQuery(diviConfigForm, SystemConst.BS_TYPE);
		String csQuery = BeanzUtils.getBaseQuery(diviConfigForm, SystemConst.CS_TYPE);
		fiter.addFilter("con999", bsQuery.concat(" AND ").concat(csQuery));
		fiter.addFilter("con099",csQuery);
		fiter.addFilter("con299", bsQuery);
		ResultData<Map<String,Object>>  resultData =diviConfigService.getPostionViewList(addJurisdiction(fiter));	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 取得设备配置表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看设备配置表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long con001=RequestUtil.getLong(request,"con001");
		DiviConfig diviConfig = diviConfigService.getById(con001);	
		return getAutoView().addObject("diviConfig", diviConfig);
	}
	
}
