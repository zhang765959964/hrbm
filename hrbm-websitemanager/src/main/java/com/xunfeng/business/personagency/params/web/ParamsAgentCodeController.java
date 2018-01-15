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

import com.xunfeng.business.personagency.params.interf.ParamsAgentCodeServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsAgentCode;
import com.xunfeng.business.personagency.params.web.form.ParamsAgentCodeForm;
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
* @Description: 劳动代理代码维护 控制器类
* @author:wanghan
* @createDate 2016-09-07 10:24:17 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/params/paramsAgentCode/")
public class ParamsAgentCodeController extends BaseController
{
	@Resource
	@Qualifier("paramsAgentCode")
	private ParamsAgentCodeServiceInterf paramsAgentCodeService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新劳动代理代码维护。
	 * @param request
	 * @param response
	 * @param paramsAgentCodeForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新劳动代理代码维护")
	public void save(HttpServletRequest request, HttpServletResponse response,ParamsAgentCodeForm paramsAgentCodeForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    ParamsAgentCode paramsAgentCode = paramsAgentCodeService.getById(pkId);
			paramsAgentCode=paramsAgentCodeForm.getModel(paramsAgentCode);
			if(paramsAgentCodeForm.isMvcAdd()){
				resultMsg="添加劳动代理代码维护";
				paramsAgentCode.setPkId(uniqueIdUtil.genId(ParamsAgentCode.class.getName()));
				paramsAgentCodeService.add(paramsAgentCode);
				
			}else{
				resultMsg="更新劳动代理代码维护";
			    paramsAgentCodeService.update(paramsAgentCode);
				
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
	 * 取得劳动代理代码维护分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/params/paramsAgentCodeList.jsp");
		
		return mv;
	}
	/**
	 * 取得劳动代理代码维护分页列表
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
		ResultData<ParamsAgentCode> resultData=paramsAgentCodeService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除劳动代理代码维护
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除劳动代理代码维护")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			paramsAgentCodeService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除劳动代理代码维护成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增劳动代理代码维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增劳动代理代码维护")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ParamsAgentCodeForm  paramsAgentCodeForm=new ParamsAgentCodeForm();
		paramsAgentCodeForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsAgentCodeEdit.jsp");
		
		return modelAndView.addObject("paramsAgentCodeForm",paramsAgentCodeForm);					
	}
	/**
	 * 	编辑劳动代理代码维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑劳动代理代码维护")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		ParamsAgentCode paramsAgentCode=paramsAgentCodeService.getById(pkId);
		ParamsAgentCodeForm  paramsAgentCodeForm=new ParamsAgentCodeForm();
		paramsAgentCodeForm.putModel(paramsAgentCode);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsAgentCodeEdit.jsp");
		return modelAndView.addObject("paramsAgentCodeForm",paramsAgentCodeForm);					
	}

	/**
	 * 取得劳动代理代码维护明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看劳动代理代码维护明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId");
		ParamsAgentCode paramsAgentCode = paramsAgentCodeService.getById(pkId);	
		return getAutoView().addObject("paramsAgentCode", paramsAgentCode);
	}
	
}
