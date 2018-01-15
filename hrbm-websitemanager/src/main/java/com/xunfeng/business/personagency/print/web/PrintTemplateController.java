package com.xunfeng.business.personagency.print.web;

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

import com.xunfeng.business.personagency.print.interf.PrintTemplateServiceInterf;
import com.xunfeng.business.personagency.print.model.PrintTemplate;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.print.util.TemplateUtil;
import com.xunfeng.business.personagency.print.web.form.PrintTemplateForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.engine.FreemarkEngine;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 打印模版 控制器类
* @author:user
* @createDate 2016-12-23 10:33:19 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/print/printTemplate/")
public class PrintTemplateController extends BaseController
{
	@Resource
	@Qualifier("printTemplate")
	private PrintTemplateServiceInterf printTemplateService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	private FreemarkEngine freemarkEngine;
	
	/**
	 * 添加或更新打印模版。
	 * @param request
	 * @param response
	 * @param printTemplateForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新打印模版")
	public void save(HttpServletRequest request, HttpServletResponse response,PrintTemplateForm printTemplateForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    PrintTemplate printTemplate = printTemplateService.getById(pkId);
			printTemplate=printTemplateForm.getModel(printTemplate);
			if(printTemplateForm.isMvcAdd()){
				resultMsg="添加打印模版";	
				String template=TemplateUtil.htmlToTemplate(printTemplate.getFdModelHtml());
				printTemplate.setFdModelTemplate(template);
				printTemplateService.add(printTemplate);
				
			}else{
				resultMsg="更新打印模版";
				String template=TemplateUtil.htmlToTemplate(printTemplate.getFdModelHtml());
				printTemplate.setFdModelTemplate(template);
			    printTemplateService.update(printTemplate);
				
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
	 * 取得打印模版分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/print/template/printTemplateList.jsp");
		
		return mv;
	}
	/**
	 * 取得打印模版分页列表
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
		ResultData<PrintTemplate> resultData=printTemplateService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除打印模版
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除打印模版")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			printTemplateService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除打印模版成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增打印模版
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增打印模版")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PrintTemplateForm  printTemplateForm=new PrintTemplateForm();
		printTemplateForm.putModel(null);
		printTemplateForm.setPkId(uniqueIdUtil.genId(PrintTemplate.class.getName()));
		ModelAndView modelAndView= new ModelAndView("/business/personagency/print/template/printTemplateEdit.jsp");
		
		return modelAndView.addObject("printTemplateForm",printTemplateForm);					
	}
	/**
	 * 	编辑打印模版
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑打印模版")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		PrintTemplate printTemplate=printTemplateService.getById(pkId);
		PrintTemplateForm  printTemplateForm=new PrintTemplateForm();
		printTemplateForm.putModel(printTemplate);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/print/template/printTemplateEdit.jsp");
		return modelAndView.addObject("printTemplateForm",printTemplateForm);					
	}

	/*@RequestMapping("preview")
	@Action(description="编辑打印模版")
	public ModelAndView preview(HttpServletRequest request) throws Exception
	{
		String alias=RequestUtil.getString(request,"alias");
		QueryFilter fiter=new QueryFilter(request);
		PrintTemplate printTemplate=printTemplateService.getTemplateByAlias(alias);
        String template=printTemplate.getFdModelTemplate();
        String serviceId=printTemplate.getFdModelService();
        BindDataService bindDataService=(BindDataService)AppUtil.getBean(serviceId);
        Map map=bindDataService.getBindData(fiter.getFilters());
		String html = freemarkEngine.parseByStringTemplate(map, template);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/print/template/printTemplatePreview.jsp");
		return modelAndView.addObject("html",html).addObject("title", printTemplate.getFdModelName());					
	}*/
	
	@RequestMapping("preview")
	@Action(description="编辑打印模版")
	public ModelAndView preview(HttpServletRequest request) throws Exception
	{
		String alias=RequestUtil.getString(request,"alias");
		QueryFilter fiter=new QueryFilter(request);
		PrintTemplate printTemplate=printTemplateService.getTemplateByAlias(alias);
        String template=printTemplate.getFdModelTemplate();
        String serviceId=printTemplate.getFdModelService();
        BindDataService bindDataService=(BindDataService)AppUtil.getBean(serviceId);
        Map map=bindDataService.getBindData(fiter.getFilters());
		String html = freemarkEngine.parseByStringTemplate(map, template);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/print/template/printTemplatePreview.jsp");
		return modelAndView.addObject("html",html).addObject("title", printTemplate.getFdModelName());					
	}
}
