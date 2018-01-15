package com.xunfeng.business.personagency.retired.web;

import java.util.Iterator;
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
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.retired.dto.WorkExperienceDto;
import com.xunfeng.business.personagency.retired.interf.WorkExperienceServiceInterf;
import com.xunfeng.business.personagency.retired.model.WorkExperience;
import com.xunfeng.business.personagency.retired.web.form.WorkExperienceForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作经历维护 控制器类
* @author:zhangfan
* @createDate 2016-07-22 15:23:26 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/experience/")
public class WorkExperienceController extends BaseController
{
	@Resource
	@Qualifier("workExperience")
	private WorkExperienceServiceInterf workExperienceService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	/**
	 * 添加或更新主要工作经历维护。
	 * @param request
	 * @param response
	 * @param workExperienceForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveOrUpdate")
	@Action(description="添加或更新主要工作经历维护")
	public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response,WorkExperienceForm workExperienceForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
			resultMsg = "工作经历维护";
			initCreater(workExperienceForm);
			WorkExperienceDto workExperienceDto   = BeanToBean.copyProperties(workExperienceForm, new WorkExperienceDto(), false);
			workExperienceService.saveOrUpdate(workExperienceDto);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得主要工作经历维护分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		Long personId = RequestUtil.getLong(request, "personId");
		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		List<Map<String ,Object>> dictionarys1 =dictionaryService.getTabList("RSDA_TAB_CRAFT", null);
		WorkExperienceForm  workExperienceForm=new WorkExperienceForm();
		initCreater(workExperienceForm);
		
		String gzValue = "";
		for (Iterator iterator = dictionarys1.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			gzValue += map.get("CODE").toString()+":"+map.get("NAME")+";";
		}
		gzValue = gzValue.substring(0, gzValue.length()-1);
		ModelAndView mv= new ModelAndView("/business/personagency/retired/workExperienceList.jsp")
		.addObject("gzValue", gzValue).addObject("personId", personId).addObject("workExperienceForm", workExperienceForm);
		return mv;
	}
	/**
	 * 取得主要工作经历维护分页列表
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
		ResultData resultData=workExperienceService.getWorkWh(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除主要工作经历维护
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除主要工作经历维护")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			workExperienceService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除主要工作经历维护成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增主要工作经历维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增主要工作经历维护")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long retiredId = RequestUtil.getLong(request, "id");
		WorkExperienceForm  workExperienceForm=new WorkExperienceForm();
		workExperienceForm.putModel(null);
		workExperienceForm.setRetiredDeclareId(retiredId);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/workExperienceEdit.jsp");
		
		return modelAndView.addObject("workExperienceForm",workExperienceForm).addObject("retiredId", retiredId);					
	}
	/**
	 * 	编辑主要工作经历维护
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑主要工作经历维护")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		WorkExperience workExperience=workExperienceService.getById(id);
		WorkExperienceForm  workExperienceForm=new WorkExperienceForm();
		workExperienceForm.putModel(workExperience);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/workExperienceEdit.jsp");
		return modelAndView.addObject("workExperienceForm",workExperienceForm);					
	}

	/**
	 * 取得主要工作经历维护明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看主要工作经历维护明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		WorkExperience workExperience = workExperienceService.getById(id);	
		return getAutoView().addObject("workExperience", workExperience);
	}
	
	
	
	
}
