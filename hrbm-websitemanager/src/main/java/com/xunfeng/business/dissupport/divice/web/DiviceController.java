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
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.dissupport.divice.model.Divice;
import com.xunfeng.business.dissupport.divice.model.DiviceModel;
import com.xunfeng.business.dissupport.divice.web.form.SysDiviceForm;
import com.xunfeng.business.dissupport.divice.interf.DiviceModelServiceInterf;
import com.xunfeng.business.dissupport.divice.interf.DiviceServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备表 控制器类
* @author:wanghan
* @createDate 2016-07-27 11:46:42 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/divice/sysDivice/")
public class DiviceController extends BaseController
{
	@Resource
	@Qualifier("diviceModel")
	private DiviceModelServiceInterf diviceModelService;
	@Resource
	@Qualifier("divice")
	private DiviceServiceInterf diviceService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	/**
	 * 添加或更新设备表。
	 * @param request
	 * @param response
	 * @param sysDiviceForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新设备表")
	public void save(HttpServletRequest request, HttpServletResponse response,SysDiviceForm sysDiviceForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long div001=RequestUtil.getLong(request,"div001");
		    Divice sysDivice = diviceService.getById(div001);
			sysDivice=sysDiviceForm.getModel(sysDivice);
			if(sysDiviceForm.isMvcAdd()){
				resultMsg="添加设备表";
//				TODO 创建序列
				sysDivice.setDiv001(uniqueIdUtil.genId(Divice.class.getName()));
				diviceService.add(sysDivice);
				
			}else{
				resultMsg="更新设备表";
			    diviceService.update(sysDivice);
				
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
	 * 取得设备表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/divice/sysDiviceList.jsp").addObject("orgs", getOrganSelectList()).addObject("models",diviceModelService.getAll());
		
		return mv;
	}
	/**
	 * 取得设备表分页列表
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
		 ResultData<Map<String, Object>> resultData=diviceService.getViewList(fiter);		
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 取得设备表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("modelJson")
	@Action(description="查询机构设备列表")
	@ResponseBody
	public List<DiviceModel> modelJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
//		if(StringUtil.isEmpty(request.getParameter("acd200"))){
//			fiter.addFilter("acd200", ContextUtil.getCurrentUserOrg().getAcd200());
//		}
		List<DiviceModel> resultData=diviceModelService.getAll(fiter);		
		return resultData;
	}
	/**
	 * 删除设备表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除设备表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "div001");
			diviceService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除设备表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增设备表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增设备表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		SysDiviceForm  sysDiviceForm=new SysDiviceForm();
		Divice sysDivice = new Divice();
		sysDivice.setAcd200(ContextUtil.getCurrentUserOrg().getAcd200());
		sysDivice.setAae036(new Date());
		sysDivice.setAae019(ContextUtil.getCurrentUser().getCczh01());
		sysDivice.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());
		//设备类型默认设置5
		sysDivice.setDiv014(new Long(5));
		//不禁用
		sysDivice.setDiv010("F");
		sysDiviceForm.putModel(sysDivice);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/sysDiviceEdit.jsp");
		
		
		return modelAndView.addObject("sysDiviceForm",sysDiviceForm).addObject("orgs", getOrganSelectList());					
	}
	/**
	 * 	编辑设备表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑设备信息")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long div001=RequestUtil.getLong(request,"div001",0L);
		Divice sysDivice=diviceService.getById(div001);
		SysDiviceForm  sysDiviceForm=new SysDiviceForm();
		sysDiviceForm.putModel(sysDivice);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/sysDiviceEdit.jsp");
		return modelAndView.addObject("sysDiviceForm",sysDiviceForm).addObject("orgs", getOrganSelectList());					
	}

	/**
	 * 取得设备表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看设备表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long div001=RequestUtil.getLong(request,"div001");
		Divice sysDivice = diviceService.getById(div001);	
		return getAutoView().addObject("sysDivice", sysDivice);
	}
	
}
