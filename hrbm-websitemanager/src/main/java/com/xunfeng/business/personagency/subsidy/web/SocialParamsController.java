package com.xunfeng.business.personagency.subsidy.web;

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

import com.xunfeng.business.personagency.subsidy.interf.SocialParamsServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import com.xunfeng.business.personagency.subsidy.web.form.SocialParamsForm;
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
* @Description: 社保补贴参数 控制器类
* @author:wanghan
* @createDate 2016-07-07 10:26:13 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/subsidy/socialParams/")
public class SocialParamsController extends BaseController
{
	@Resource
	@Qualifier("socialParams")
	private SocialParamsServiceInterf socialParamsService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;

	
	
	
	/**
	 * 添加或更新社保补贴参数。
	 * @param request
	 * @param response
	 * @param socialParamsForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新社保补贴参数")
	public void save(HttpServletRequest request, HttpServletResponse response,SocialParamsForm socialParamsForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    SocialParams socialParams = socialParamsService.getById(id);
			socialParams=socialParamsForm.getModel(socialParams);
			if(socialParamsForm.isMvcAdd()){
				resultMsg="添加社保补贴参数";
				socialParams.setId(uniqueIdUtil.genId(SocialParams.class.getName()));
				socialParamsService.add(socialParams);
				
			}else{
				resultMsg="更新社保补贴参数";
			    socialParamsService.update(socialParams);
				
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(RuntimeException ex){
			message=new ResultMessage(ResultMessage.Fail, ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得社保补贴参数分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/socialParamsList.jsp");
		
		return mv;
	}
	/**
	 * 取得社保补贴参数分页列表
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
		ResultData<SocialParams> resultData=socialParamsService.getAllByFilter(fiter);	
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除社保补贴参数
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除社保补贴参数")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			long starTime=System.currentTimeMillis();
			socialParamsService.delByIds(lAryId);
			long endTime=System.currentTimeMillis();
			long Time=endTime-starTime;
			 System.out.println(Time);
			message=new ResultMessage(ResultMessage.Success, "删除社保补贴参数成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增社保补贴参数
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增社保补贴参数")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		SocialParamsForm  socialParamsForm=new SocialParamsForm();
		socialParamsForm.putModel(null);
		initCreater(socialParamsForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialParamsEdit.jsp");
		
		return modelAndView.addObject("socialParamsForm",socialParamsForm);					
	}
	/**
	 * 	编辑社保补贴参数
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑社保补贴参数")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		SocialParams socialParams=socialParamsService.getById(id);
		SocialParamsForm  socialParamsForm=new SocialParamsForm();
		socialParamsForm.putModel(socialParams);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialParamsEdit.jsp");
		return modelAndView.addObject("socialParamsForm",socialParamsForm);					
	}

	/**
	 * 取得社保补贴参数明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看社保补贴参数明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SocialParams socialParams = socialParamsService.getById(id);	
		return getAutoView().addObject("socialParams", socialParams);
	}
	
}
