package com.xunfeng.sys.setMeal.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.setMeal.model.FeeUseDetail;
import com.xunfeng.sys.setMeal.web.form.FeeUseDetailForm;
import com.xunfeng.sys.setMeal.interf.FeeUseDetailServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 消费使用流水表 控制器类
* @author:
* @createDate 2016-07-19 09:22:45 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/setMeal/feeUseDetail/")
public class FeeUseDetailController extends BaseController
{
	@Resource
	@Qualifier("feeUseDetail")
	private FeeUseDetailServiceInterf feeUseDetailService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新消费使用流水表。
	 * @param request
	 * @param response
	 * @param feeUseDetailForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新消费使用流水表")
	public void save(HttpServletRequest request, HttpServletResponse response,FeeUseDetailForm feeUseDetailForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long useSn=RequestUtil.getLong(request,"useSn");
		    FeeUseDetail feeUseDetail = feeUseDetailService.getById(useSn);
			feeUseDetail=feeUseDetailForm.getModel(feeUseDetail);
			if(feeUseDetailForm.isMvcAdd()){
				resultMsg="添加消费使用流水表";
				feeUseDetail.setUseSn(uniqueIdUtil.genId(FeeUseDetail.class.getName()));
				feeUseDetailService.add(feeUseDetail);
				
			}else{
				resultMsg="更新消费使用流水表";
			    feeUseDetailService.update(feeUseDetail);
				
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
	 * 取得消费使用流水表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	/**
	 * 取得消费使用流水表分页列表
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
		List<FeeUseDetail> list=feeUseDetailService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除消费使用流水表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除消费使用流水表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "useSn");
			feeUseDetailService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除消费使用流水表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增消费使用流水表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增消费使用流水表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		FeeUseDetailForm  feeUseDetailForm=new FeeUseDetailForm();
		feeUseDetailForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/sys/setMeal/feeUseDetailEdit.jsp");
		
		return modelAndView.addObject("feeUseDetailForm",feeUseDetailForm);					
	}
	/**
	 * 	编辑消费使用流水表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑消费使用流水表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long useSn=RequestUtil.getLong(request,"useSn",0L);
		FeeUseDetail feeUseDetail=feeUseDetailService.getById(useSn);
		FeeUseDetailForm  feeUseDetailForm=new FeeUseDetailForm();
		feeUseDetailForm.putModel(feeUseDetail);
		
		return getAutoView().addObject("feeUseDetailForm",feeUseDetailForm);					
	}

	/**
	 * 取得消费使用流水表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看消费使用流水表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long useSn=RequestUtil.getLong(request,"useSn");
		FeeUseDetail feeUseDetail = feeUseDetailService.getById(useSn);	
		return getAutoView().addObject("feeUseDetail", feeUseDetail);
	}
	
}
