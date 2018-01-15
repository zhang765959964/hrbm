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
import com.xunfeng.sys.setMeal.model.FeeServCfg;
import com.xunfeng.sys.setMeal.web.form.FeeServCfgForm;
import com.xunfeng.sys.setMeal.interf.FeeServCfgServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 服务细项表 控制器类
* @author:wangyanyan
* @createDate 2016-07-19 09:11:01 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/setMeal/feeServCfg/")
public class FeeServCfgController extends BaseController
{
	@Resource
	@Qualifier("feeServCfg")
	private FeeServCfgServiceInterf feeServCfgService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新服务细项表。
	 * @param request
	 * @param response
	 * @param feeServCfgForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新服务细项表")
	public void save(HttpServletRequest request, HttpServletResponse response,FeeServCfgForm feeServCfgForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long servCode=RequestUtil.getLong(request,"servCode");
		    FeeServCfg feeServCfg = feeServCfgService.getById(servCode);
			feeServCfg=feeServCfgForm.getModel(feeServCfg);
			if(feeServCfgForm.isMvcAdd()){
				resultMsg="添加服务细项表";
				feeServCfg.setServCode(String.valueOf(uniqueIdUtil.genId(FeeServCfg.class.getName())));
				feeServCfgService.add(feeServCfg);
				
			}else{
				resultMsg="更新服务细项表";
			    feeServCfgService.update(feeServCfg);
				
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
	 * 取得服务细项表分页列表
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
	 * 取得服务细项表分页列表
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
		List<FeeServCfg> list=feeServCfgService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除服务细项表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除服务细项表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "servCode");
			feeServCfgService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除服务细项表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增服务细项表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增服务细项表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		FeeServCfgForm  feeServCfgForm=new FeeServCfgForm();
		feeServCfgForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/sys/setMeal/feeServCfgEdit.jsp");
		
		return modelAndView.addObject("feeServCfgForm",feeServCfgForm);					
	}
	/**
	 * 	编辑服务细项表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑服务细项表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long servCode=RequestUtil.getLong(request,"servCode",0L);
		FeeServCfg feeServCfg=feeServCfgService.getById(servCode);
		FeeServCfgForm  feeServCfgForm=new FeeServCfgForm();
		feeServCfgForm.putModel(feeServCfg);
		
		return getAutoView().addObject("feeServCfgForm",feeServCfgForm);					
	}

	/**
	 * 取得服务细项表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看服务细项表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long servCode=RequestUtil.getLong(request,"servCode");
		FeeServCfg feeServCfg = feeServCfgService.getById(servCode);	
		return getAutoView().addObject("feeServCfg", feeServCfg);
	}
	
}
