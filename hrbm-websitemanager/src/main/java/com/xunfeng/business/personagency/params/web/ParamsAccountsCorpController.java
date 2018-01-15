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

import com.xunfeng.business.personagency.params.interf.ParamsAccountsCorpServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsAccountsCorp;
import com.xunfeng.business.personagency.params.web.form.ParamsAccountsCorpForm;
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
* @Description: 账号与市场关联维护 控制器类
* @author:wanghan
* @createDate 2016-09-07 10:24:43 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/params/paramsAccountsCorp/")
public class ParamsAccountsCorpController extends BaseController
{
	@Resource
	@Qualifier("paramsAccountsCorp")
	private ParamsAccountsCorpServiceInterf paramsAccountsCorpService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新账号与市场关联维护。
	 * @param request
	 * @param response
	 * @param paramsAccountsCorpForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新账号与市场关联维护")
	public void save(HttpServletRequest request, HttpServletResponse response,ParamsAccountsCorpForm paramsAccountsCorpForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    ParamsAccountsCorp paramsAccountsCorp = paramsAccountsCorpService.getById(pkId);
			paramsAccountsCorp=paramsAccountsCorpForm.getModel(paramsAccountsCorp);
			if(paramsAccountsCorpForm.isMvcAdd()){
				resultMsg="添加账号与市场关联维护";
				paramsAccountsCorp.setPkId(uniqueIdUtil.genId(ParamsAccountsCorp.class.getName()));
				paramsAccountsCorpService.add(paramsAccountsCorp);
				
			}else{
				resultMsg="更新账号与市场关联维护";
			    paramsAccountsCorpService.update(paramsAccountsCorp);
				
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
	 * 取得账号与市场关联维护分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/params/paramsAccountsCorpList.jsp");
		
		return mv;
	}
	/**
	 * 取得账号与市场关联维护分页列表
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
		ResultData resultData=paramsAccountsCorpService.getParamsList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除账号与市场关联维护
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除账号与市场关联维护")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			paramsAccountsCorpService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除账号与市场关联维护成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增账号与市场关联维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增账号与市场关联维护")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ParamsAccountsCorpForm  paramsAccountsCorpForm=new ParamsAccountsCorpForm();
		paramsAccountsCorpForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsAccountsCorpEdit.jsp");
		
		return modelAndView.addObject("paramsAccountsCorpForm",paramsAccountsCorpForm);					
	}
	/**
	 * 	编辑账号与市场关联维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑账号与市场关联维护")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		ParamsAccountsCorp paramsAccountsCorp=paramsAccountsCorpService.getById(pkId);
		ParamsAccountsCorpForm  paramsAccountsCorpForm=new ParamsAccountsCorpForm();
		paramsAccountsCorpForm.putModel(paramsAccountsCorp);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsAccountsCorpEdit.jsp");
		return modelAndView.addObject("paramsAccountsCorpForm",paramsAccountsCorpForm);					
	}

	/**
	 * 取得账号与市场关联维护明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看账号与市场关联维护明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId");
		ParamsAccountsCorp paramsAccountsCorp = paramsAccountsCorpService.getById(pkId);	
		return getAutoView().addObject("paramsAccountsCorp", paramsAccountsCorp);
	}
	
}
