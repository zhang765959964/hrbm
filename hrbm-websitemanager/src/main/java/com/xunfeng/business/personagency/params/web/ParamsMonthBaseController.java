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

import com.xunfeng.business.personagency.params.interf.ParamsMonthBaseServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsMonthBase;
import com.xunfeng.business.personagency.params.web.form.ParamsMonthBaseForm;
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
* @Description: 月缴费基数 控制器类
* @author:wanghan
* @createDate 2016-09-07 09:23:00 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/params/paramsMonthBase/")
public class ParamsMonthBaseController extends BaseController
{
	@Resource
	@Qualifier("paramsMonthBase")
	private ParamsMonthBaseServiceInterf paramsMonthBaseService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新月缴费基数。
	 * @param request
	 * @param response
	 * @param paramsMonthBaseForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新月缴费基数")
	public void save(HttpServletRequest request, HttpServletResponse response,ParamsMonthBaseForm paramsMonthBaseForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    ParamsMonthBase paramsMonthBase = paramsMonthBaseService.getById(pkId);
			paramsMonthBase=paramsMonthBaseForm.getModel(paramsMonthBase);
			if(paramsMonthBaseForm.isMvcAdd()){
				resultMsg="添加月缴费基数";
				paramsMonthBase.setPkId(uniqueIdUtil.genId(ParamsMonthBase.class.getName()));
				paramsMonthBaseService.add(paramsMonthBase);
				
			}else{
				resultMsg="更新月缴费基数";
			    paramsMonthBaseService.update(paramsMonthBase);
				
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
	 * 取得月缴费基数分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/params/paramsMonthBaseList.jsp");
		
		return mv;
	}
	/**
	 * 取得月缴费基数分页列表
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
		ResultData<ParamsMonthBase> resultData=paramsMonthBaseService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除月缴费基数
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除月缴费基数")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			paramsMonthBaseService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除月缴费基数成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增月缴费基数
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增月缴费基数")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ParamsMonthBaseForm  paramsMonthBaseForm=new ParamsMonthBaseForm();
		initCreater(paramsMonthBaseForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsMonthBaseEdit.jsp");
		
		return modelAndView.addObject("paramsMonthBaseForm",paramsMonthBaseForm);					
	}
	/**
	 * 	编辑月缴费基数
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑月缴费基数")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		ParamsMonthBase paramsMonthBase=paramsMonthBaseService.getById(pkId);
		ParamsMonthBaseForm  paramsMonthBaseForm=new ParamsMonthBaseForm();
		paramsMonthBaseForm.putModel(paramsMonthBase);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsMonthBaseEdit.jsp");
		return modelAndView.addObject("paramsMonthBaseForm",paramsMonthBaseForm);					
	}

	/**
	 * 取得月缴费基数明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看月缴费基数明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId");
		ParamsMonthBase paramsMonthBase = paramsMonthBaseService.getById(pkId);	
		return getAutoView().addObject("paramsMonthBase", paramsMonthBase);
	}
	
}
