package com.xunfeng.business.personagency.retired.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredSocialServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredSocial;
import com.xunfeng.business.personagency.retired.web.form.RetiredSocialForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员转社会化 控制器类
* @author:zhangfan
* @createDate 2016-08-09 15:09:43 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/retired/social/")
public class RetiredSocialController extends BaseController
{
	@Resource
	@Qualifier("retiredSocial")
	private RetiredSocialServiceInterf retiredSocialService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	
	/**
	 * 添加或更新退休人员转社会化。
	 * @param request
	 * @param response
	 * @param retiredSocialForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新退休人员转社会化")
	public void save(HttpServletRequest request, HttpServletResponse response,RetiredSocialForm retiredSocialForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
			resultMsg = "退休人员转社会化";
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pk_id");
			initCreater(retiredSocialForm);
			RetiredSocial retiredSocial = BeanToBean.copyProperties(retiredSocialForm, new RetiredSocial(), false);
			retiredSocialService.saveOrUpdate(lAryId, retiredSocial);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	

	
	/**
	 * 根据退休申诉id获得社会转社会量
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getRetiredById")
	@Action(description="领取退休证")
	public ModelAndView getRetiredById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		RetiredSocialForm retiredSocialForm = new RetiredSocialForm();
		initCreater(retiredSocialForm);
		ModelAndView mv = new ModelAndView("/business/personagency/retired/searchRetiredSocialList.jsp");
		return mv.addObject("retiredSocialForm", retiredSocialForm);
	}
	
	
	

	
	
	
	/**
	 * 取得退休人员转社会化分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredSocialList.jsp");
		return mv;
	}
	
	
	/**
	 * 退休转社会化查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("socialList")
	public ModelAndView listSocial(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredSocialListSearch.jsp");
		return mv;
	}
	
	/**
	 * 取得退休人员转社会化分页列表
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
		ResultData<RetiredSocial> resultData=retiredSocialService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 退休人员转社会化列表 信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredSocialList")
	@Action(description="退休人员转社会化列表")
	@ResponseBody
	public Map<Object,Object> getRetiredSocialList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=retiredSocialService.getRetiredSocialList(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	/**
	 * 退休转社会化查询 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredSocialListJson")
	@Action(description="退休转社会化查询")
	@ResponseBody
	public Map<Object,Object> getRetiredSocialListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=retiredSocialService.getRetiredSocialListJson(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	/**
	 * 删除退休人员转社会化
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除退休人员转社会化")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			retiredSocialService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除退休人员转社会化成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	

	
	
	
	
	/**
	 * 	新增退休人员转社会化
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增退休人员转社会化")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RetiredSocialForm  retiredSocialForm=new RetiredSocialForm();
		retiredSocialForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredSocialEdit.jsp");
		
		return modelAndView.addObject("retiredSocialForm",retiredSocialForm);					
	}
	/**
	 * 	编辑退休人员转社会化
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑退休人员转社会化")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		RetiredSocial retiredSocial=retiredSocialService.getById(id);
		RetiredSocialForm  retiredSocialForm=new RetiredSocialForm();
		retiredSocialForm.putModel(retiredSocial);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredSocialEdit.jsp");
		return modelAndView.addObject("retiredSocialForm",retiredSocialForm);					
	}

	/**
	 * 取得退休人员转社会化明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看退休人员转社会化明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		RetiredSocial retiredSocial = retiredSocialService.getById(id);	
		return getAutoView().addObject("retiredSocial", retiredSocial);
	}
	
}
