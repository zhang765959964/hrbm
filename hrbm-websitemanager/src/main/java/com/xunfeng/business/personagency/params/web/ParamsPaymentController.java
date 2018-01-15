package com.xunfeng.business.personagency.params.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.params.interf.ParamsPaymentServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.business.personagency.params.web.form.ParamsPaymentForm;
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
* @Description: 缴费标准 控制器类
* @author:wanghan
* @createDate 2016-09-05 10:04:34 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/params/paramsPayment/")
public class ParamsPaymentController extends BaseController
{
	@Resource
	@Qualifier("paramsPayment")
	private ParamsPaymentServiceInterf paramsPaymentService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新缴费标准。
	 * @param request
	 * @param response
	 * @param paramsPaymentForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新缴费标准")
	public void save(HttpServletRequest request, HttpServletResponse response,ParamsPaymentForm paramsPaymentForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    ParamsPayment paramsPayment = paramsPaymentService.getById(pkId);
			paramsPayment=paramsPaymentForm.getModel(paramsPayment);
			if(paramsPaymentForm.isMvcAdd()){
				resultMsg="添加缴费标准";
				paramsPayment.setPkId(uniqueIdUtil.genId(ParamsPayment.class.getName()));
				paramsPaymentService.add(paramsPayment);
				
			}else{
				resultMsg="更新缴费标准";
			    paramsPaymentService.update(paramsPayment);
				
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
	 * 取得缴费标准分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/params/paramsPaymentList.jsp");
		
		return mv;
	}
	/**
	 * 取得缴费标准分页列表
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
		ResultData<ParamsPayment> resultData=paramsPaymentService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除缴费标准
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除缴费标准")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			paramsPaymentService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除缴费标准成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增缴费标准
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增缴费标准")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ParamsPaymentForm  paramsPaymentForm=new ParamsPaymentForm();
		initCreater(paramsPaymentForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsPaymentEdit.jsp");
		
		return modelAndView.addObject("paramsPaymentForm",paramsPaymentForm);					
	}
	/**
	 * 	编辑缴费标准
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑缴费标准")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		ParamsPayment paramsPayment=paramsPaymentService.getById(pkId);
		ParamsPaymentForm  paramsPaymentForm=new ParamsPaymentForm();
		paramsPaymentForm.putModel(paramsPayment);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsPaymentEdit.jsp");
		return modelAndView.addObject("paramsPaymentForm",paramsPaymentForm);					
	}

	/**
	 * 取得缴费标准明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看缴费标准明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId");
		ParamsPayment paramsPayment = paramsPaymentService.getById(pkId);	
		return getAutoView().addObject("paramsPayment", paramsPayment);
	}
	
}
