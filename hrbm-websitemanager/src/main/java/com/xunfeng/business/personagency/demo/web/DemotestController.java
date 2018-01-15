package com.xunfeng.business.personagency.demo.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.demo.interf.DemotestServiceInterf;
import com.xunfeng.business.personagency.demo.model.Demotest;
import com.xunfeng.business.personagency.demo.web.form.DemotestForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_DEMO 控制器类
* @author:zhangfan
* @createDate 2016-07-28 10:46:20 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/demo/demotest/")
public class DemotestController extends BaseController
{
	@Resource
	@Qualifier("demotest")
	private DemotestServiceInterf demotestService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新RSDA_BS_DEMO。
	 * @param request
	 * @param response
	 * @param demotestForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新RSDA_BS_DEMO")
	public void save(HttpServletRequest request, HttpServletResponse response,DemotestForm demotestForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    Demotest demotest = demotestService.getById(id);
			demotest=demotestForm.getModel(demotest);
			if(demotestForm.isMvcAdd()){
				resultMsg="添加RSDA_BS_DEMO";
				demotest.setId(uniqueIdUtil.genId(Demotest.class.getName()));
				demotestService.add(demotest);
				
			}else{
				resultMsg="更新RSDA_BS_DEMO";
			    demotestService.update(demotest);
				
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
	 * 取得RSDA_BS_DEMO分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/demo/demotestList.jsp");
		
		return mv;
	}
	/**
	 * 取得RSDA_BS_DEMO分页列表
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
		ResultData<Demotest> resultData=demotestService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除RSDA_BS_DEMO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除RSDA_BS_DEMO")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			demotestService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除RSDA_BS_DEMO成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增RSDA_BS_DEMO
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增RSDA_BS_DEMO")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		DemotestForm  demotestForm=new DemotestForm();
		demotestForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/demo/demotestEdit.jsp");
		
		return modelAndView.addObject("demotestForm",demotestForm);					
	}
	/**
	 * 	编辑RSDA_BS_DEMO
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑RSDA_BS_DEMO")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Demotest demotest=demotestService.getById(id);
		DemotestForm  demotestForm=new DemotestForm();
		demotestForm.putModel(demotest);
		ModelAndView modelAndView= new ModelAndView("/business/demo/demotestEdit.jsp");
		return modelAndView.addObject("demotestForm",demotestForm);					
	}

	/**
	 * 取得RSDA_BS_DEMO明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看RSDA_BS_DEMO明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		Demotest demotest = demotestService.getById(id);	
		return getAutoView().addObject("demotest", demotest);
	}
	
}
