package com.xunfeng.business.dissupport.divice.web;

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
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.dissupport.divice.model.DiviceModel;
import com.xunfeng.business.dissupport.divice.web.form.DiviceModelForm;
import com.xunfeng.business.dissupport.divice.interf.DiviceModelServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 型号表 控制器类
* @author:wanghan
* @createDate 2016-07-27 17:03:37 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/divice/diviceModel/")
public class DiviceModelController extends BaseController
{
	@Resource
	@Qualifier("diviceModel")
	private DiviceModelServiceInterf diviceModelService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新型号表。
	 * @param request
	 * @param response
	 * @param diviceModelForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新型号表")
	public void save(HttpServletRequest request, HttpServletResponse response,DiviceModelForm diviceModelForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long mod001=RequestUtil.getLong(request,"mod001");
		    DiviceModel diviceModel = diviceModelService.getById(mod001);
			diviceModel=diviceModelForm.getModel(diviceModel);
			if(diviceModelForm.isMvcAdd()){
				resultMsg="添加型号表";
				diviceModel.setMod001(uniqueIdUtil.genId(DiviceModel.class.getName()));
				diviceModelService.add(diviceModel);
				
			}else{
				resultMsg="更新型号表";
			    diviceModelService.update(diviceModel);
				
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
	 * 取得型号表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/divice/diviceModelList.jsp");
		
		return mv;
	}
	/**
	 * 取得型号表分页列表
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
		List<DiviceModel> list=diviceModelService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除型号表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除型号表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "mod001");
			diviceModelService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除型号表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增型号表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增型号表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		DiviceModelForm  diviceModelForm=new DiviceModelForm();
		diviceModelForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/diviceModelEdit.jsp");
		
		return modelAndView.addObject("diviceModelForm",diviceModelForm);					
	}
	/**
	 * 	编辑型号表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑型号表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long mod001=RequestUtil.getLong(request,"mod001",0L);
		DiviceModel diviceModel=diviceModelService.getById(mod001);
		DiviceModelForm  diviceModelForm=new DiviceModelForm();
		diviceModelForm.putModel(diviceModel);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/divice/diviceModelEdit.jsp");
		return modelAndView.addObject("diviceModelForm",diviceModelForm);					
	}

	/**
	 * 取得型号表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看型号表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long mod001=RequestUtil.getLong(request,"mod001");
		DiviceModel diviceModel = diviceModelService.getById(mod001);	
		return getAutoView().addObject("diviceModel", diviceModel);
	}
	
}
