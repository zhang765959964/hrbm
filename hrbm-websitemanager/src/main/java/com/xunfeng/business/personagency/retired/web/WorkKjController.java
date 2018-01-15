package com.xunfeng.business.personagency.retired.web;

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
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.ZJ_DateUtils;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.retired.web.form.WorkKjForm;
import com.xunfeng.business.personagency.retired.model.WorkKj;
import com.xunfeng.business.personagency.retired.interf.WorkKjServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作扣减情况维护 控制器类
* @author:zhangfan
* @createDate 2016-07-23 10:31:59 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/workkj/")
public class WorkKjController extends BaseController
{
	@Resource
	@Qualifier("workKj")
	private WorkKjServiceInterf workKjService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新主要工作扣减情况维护。
	 * @param request
	 * @param response
	 * @param workKjForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新主要工作扣减情况维护")
	public void save(HttpServletRequest request, HttpServletResponse response,WorkKjForm workKjForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		resultMsg =  "工作扣减情况维护";
		try{
			initCreater(workKjForm);
			WorkKj kj = BeanToBean.copyProperties(workKjForm, new WorkKj(), false);
			Integer month = ZJ_DateUtils.getMct(workKjForm.getCreateTime(),workKjForm.getEndTime() , "-");
			kj.setKjNum(month.longValue());
			workKjService.saveOrUpdate(kj);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得主要工作扣减情况维护分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/workKjList.jsp");
		
		return mv;
	}
	/**
	 * 取得主要工作扣减情况维护分页列表
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
		ResultData resultData = workKjService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除主要工作扣减情况维护
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除主要工作扣减情况维护")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			workKjService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除主要工作扣减情况维护成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增主要工作扣减情况维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增主要工作扣减情况维护")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		
		Long retiredId = RequestUtil.getLong(request, "id");
		WorkKjForm  workKjForm=new WorkKjForm();
		workKjForm.setRetiredDeclareId(retiredId);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/workKjEdit.jsp");
		
		return modelAndView.addObject("workKjForm",workKjForm).addObject("retiredId", retiredId);					
	}
	/**
	 * 	编辑主要工作扣减情况维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑主要工作扣减情况维护")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		WorkKj workKj=workKjService.getById(id);
		WorkKjForm  workKjForm=new WorkKjForm();
		workKjForm.putModel(workKj);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/workKjEdit.jsp");
		return modelAndView.addObject("workKjForm",workKjForm);					
	}

	/**
	 * 取得主要工作扣减情况维护明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看主要工作扣减情况维护明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		WorkKj workKj = workKjService.getById(id);	
		return getAutoView().addObject("workKj", workKj);
	}
	
	
	
}
