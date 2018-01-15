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
import com.xunfeng.sys.setMeal.model.FeeOrderDetail;
import com.xunfeng.sys.setMeal.web.form.FeeOrderDetailForm;
import com.xunfeng.sys.setMeal.interf.FeeOrderDetailServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购详表 控制器类
* @author:
* @createDate 2016-07-19 09:19:03 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/setMeal/feeOrderDetail/")
public class FeeOrderDetailController extends BaseController
{
	@Resource
	@Qualifier("feeOrderDetail")
	private FeeOrderDetailServiceInterf feeOrderDetailService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新套餐订购详表。
	 * @param request
	 * @param response
	 * @param feeOrderDetailForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新套餐订购详表")
	public void save(HttpServletRequest request, HttpServletResponse response,FeeOrderDetailForm feeOrderDetailForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long detailSn=RequestUtil.getLong(request,"detailSn");
		    FeeOrderDetail feeOrderDetail = feeOrderDetailService.getById(detailSn);
			feeOrderDetail=feeOrderDetailForm.getModel(feeOrderDetail);
			if(feeOrderDetailForm.isMvcAdd()){
				resultMsg="添加套餐订购详表";
				feeOrderDetail.setDetailSn(uniqueIdUtil.genId(FeeOrderDetail.class.getName()));
				feeOrderDetailService.add(feeOrderDetail);
				
			}else{
				resultMsg="更新套餐订购详表";
			    feeOrderDetailService.update(feeOrderDetail);
				
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
	 * 取得套餐订购详表分页列表
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
	 * 取得套餐订购详表分页列表
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
		List<FeeOrderDetail> list=feeOrderDetailService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除套餐订购详表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除套餐订购详表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "detailSn");
			feeOrderDetailService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除套餐订购详表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增套餐订购详表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增套餐订购详表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		FeeOrderDetailForm  feeOrderDetailForm=new FeeOrderDetailForm();
		feeOrderDetailForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/sys/setMeal/feeOrderDetailEdit.jsp");
		
		return modelAndView.addObject("feeOrderDetailForm",feeOrderDetailForm);					
	}
	/**
	 * 	编辑套餐订购详表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑套餐订购详表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long detailSn=RequestUtil.getLong(request,"detailSn",0L);
		FeeOrderDetail feeOrderDetail=feeOrderDetailService.getById(detailSn);
		FeeOrderDetailForm  feeOrderDetailForm=new FeeOrderDetailForm();
		feeOrderDetailForm.putModel(feeOrderDetail);
		
		return getAutoView().addObject("feeOrderDetailForm",feeOrderDetailForm);					
	}

	/**
	 * 取得套餐订购详表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看套餐订购详表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long detailSn=RequestUtil.getLong(request,"detailSn");
		FeeOrderDetail feeOrderDetail = feeOrderDetailService.getById(detailSn);	
		return getAutoView().addObject("feeOrderDetail", feeOrderDetail);
	}
	
}
