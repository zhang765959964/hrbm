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

import com.xunfeng.business.personagency.params.interf.ParamsDiffCorpServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsDiffCorp;
import com.xunfeng.business.personagency.params.web.form.ParamsDiffCorpForm;
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
* @Description: 困难企业 控制器类
* @author:wanghan
* @createDate 2016-09-07 10:22:54 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/params/paramsDiffCorp/")
public class ParamsDiffCorpController extends BaseController
{
	@Resource
	@Qualifier("paramsDiffCorp")
	private ParamsDiffCorpServiceInterf paramsDiffCorpService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新困难企业。
	 * @param request
	 * @param response
	 * @param paramsDiffCorpForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新困难企业")
	public void save(HttpServletRequest request, HttpServletResponse response,ParamsDiffCorpForm paramsDiffCorpForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    ParamsDiffCorp paramsDiffCorp = paramsDiffCorpService.getById(pkId);
			paramsDiffCorp=paramsDiffCorpForm.getModel(paramsDiffCorp);
			if(paramsDiffCorpForm.isMvcAdd()){
				resultMsg="添加困难企业";
				paramsDiffCorp.setPkId(uniqueIdUtil.genId(ParamsDiffCorp.class.getName()));
				paramsDiffCorpService.add(paramsDiffCorp);
				
			}else{
				resultMsg="更新困难企业";
			    paramsDiffCorpService.update(paramsDiffCorp);
				
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
	 * 取得困难企业分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long type =  RequestUtil.getLong(request, "type");
		ModelAndView mv= new ModelAndView("/business/personagency/params/paramsDiffCorpList.jsp").addObject("type", type);
		return mv;
	}
	/**
	 * 取得困难企业分页列表
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
		ResultData<ParamsDiffCorp> resultData=paramsDiffCorpService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除困难企业
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除困难企业")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			paramsDiffCorpService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除困难企业成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增困难企业
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增困难企业")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ParamsDiffCorpForm  paramsDiffCorpForm=new ParamsDiffCorpForm();
		paramsDiffCorpForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsDiffCorpEdit.jsp");
		
		return modelAndView.addObject("paramsDiffCorpForm",paramsDiffCorpForm);					
	}
	/**
	 * 	编辑困难企业
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑困难企业")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		ParamsDiffCorp paramsDiffCorp=paramsDiffCorpService.getById(pkId);
		ParamsDiffCorpForm  paramsDiffCorpForm=new ParamsDiffCorpForm();
		paramsDiffCorpForm.putModel(paramsDiffCorp);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsDiffCorpEdit.jsp");
		return modelAndView.addObject("paramsDiffCorpForm",paramsDiffCorpForm);					
	}

	/**
	 * 取得困难企业明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看困难企业明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId");
		ParamsDiffCorp paramsDiffCorp = paramsDiffCorpService.getById(pkId);	
		return getAutoView().addObject("paramsDiffCorp", paramsDiffCorp);
	}
	
}
