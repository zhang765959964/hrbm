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

import com.xunfeng.business.personagency.retired.interf.RetiredXhServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredXh;
import com.xunfeng.business.personagency.retired.web.form.RetiredXhForm;
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
* @Description: 退休序号历史记录表 控制器类
* @author:zhangfan
* @createDate 2016-11-29 17:11:56 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/retired/retiredXh/")
public class RetiredXhController extends BaseController
{
	@Resource
	@Qualifier("retiredXh")
	private RetiredXhServiceInterf retiredXhService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新退休序号历史记录表。
	 * @param request
	 * @param response
	 * @param retiredXhForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新退休序号历史记录表")
	public void save(HttpServletRequest request, HttpServletResponse response,RetiredXhForm retiredXhForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    RetiredXh retiredXh = retiredXhService.getById(id);
			retiredXh=retiredXhForm.getModel(retiredXh);
			if(retiredXhForm.isMvcAdd()){
				resultMsg="添加退休序号历史记录表";				
				retiredXhService.add(retiredXh);
				
			}else{
				resultMsg="更新退休序号历史记录表";
			    retiredXhService.update(retiredXh);
				
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
	 * 取得退休序号历史记录表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredXhList.jsp");
		
		return mv;
	}
	/**
	 * 取得退休序号历史记录表分页列表
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
		ResultData<RetiredXh> resultData=retiredXhService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除退休序号历史记录表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除退休序号历史记录表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			retiredXhService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除退休序号历史记录表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增退休序号历史记录表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增退休序号历史记录表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RetiredXhForm  retiredXhForm=new RetiredXhForm();
		retiredXhForm.putModel(null);
		retiredXhForm.setId(uniqueIdUtil.genId(RetiredXh.class.getName()));
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredXhEdit.jsp");
		
		return modelAndView.addObject("retiredXhForm",retiredXhForm);					
	}
	/**
	 * 	编辑退休序号历史记录表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑退休序号历史记录表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		RetiredXh retiredXh=retiredXhService.getById(id);
		RetiredXhForm  retiredXhForm=new RetiredXhForm();
		retiredXhForm.putModel(retiredXh);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredXhEdit.jsp");
		return modelAndView.addObject("retiredXhForm",retiredXhForm);					
	}

	/**
	 * 取得退休序号历史记录表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看退休序号历史记录表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		RetiredXh retiredXh = retiredXhService.getById(id);	
		return getAutoView().addObject("retiredXh", retiredXh);
	}
	
}
