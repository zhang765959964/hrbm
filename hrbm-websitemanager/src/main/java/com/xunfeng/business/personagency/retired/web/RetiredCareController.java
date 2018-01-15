package com.xunfeng.business.personagency.retired.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.ZJ_DateUtils;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.retired.model.RetiredCare;
import com.xunfeng.business.personagency.retired.model.WorkExperience;
import com.xunfeng.business.personagency.retired.web.form.RetiredCareForm;
import com.xunfeng.business.personagency.retired.web.form.RetiredPersonCareForm;
import com.xunfeng.business.personagency.retired.dto.RetiredCareDto;
import com.xunfeng.business.personagency.retired.interf.RetiredCareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.WorkExperienceServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员大病医保表 控制器类
* @author:zhangfan
* @createDate 2016-12-16 11:23:41 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/retired/care/")
public class RetiredCareController extends BaseController
{
	@Resource
	@Qualifier("retiredCare")
	private RetiredCareServiceInterf retiredCareService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("workExperience")
	private WorkExperienceServiceInterf workExperienceService;
	
	
	/**
	 * 添加或更新退休人员大病医保表。
	 * @param request
	 * @param response
	 * @param retiredCareForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新退休人员大病医保表")
	public void save(HttpServletRequest request, HttpServletResponse response,RetiredCareForm retiredCareForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		resultMsg="大病医保保存";
		initCreater(retiredCareForm);
		try{
			RetiredCareDto  retiredCareDto =BeanToBean.copyProperties(retiredCareForm, new RetiredCareDto(), false);
			retiredCareService.saveOrUpdate(retiredCareDto);
			if(retiredCareDto.getId()!=null&&retiredCareDto.getId()>0){
				resultMsg = "大病医保修改";
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	@RequestMapping("saveCarePl")
	@Action(description="添加或更新退休人员大病医保表")
	public void saveCarePl(HttpServletRequest request, HttpServletResponse response,RetiredCareForm retiredCareForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		resultMsg = "大病医保保存";
		try {
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pk_id");
			RetiredCareDto retiredCareDto = BeanToBean.copyProperties(retiredCareForm, new RetiredCareDto(), false);
			for (Long personId : lAryId) {
				RetiredCare retiredCare = retiredCareService.getCareByPersonId(personId);
				if(retiredCare==null){
					resultMsg = "你选择的数据不合法，请选择可申报大病医保的信息！";
					message=new ResultMessage(ResultMessage.Success, resultMsg);
					writeResultMessage(response.getWriter(),message);
					return;
				}else{
					if(retiredCare.getIsCareDeclare()!=1){
						resultMsg = "你选择的数据不合法，请选择可申报大病医保的信息！";
						message=new ResultMessage(ResultMessage.Success, resultMsg);
						writeResultMessage(response.getWriter(),message);
						return;
					}else{
						retiredCareService.saveOrUpdatePl(lAryId, retiredCareDto);
						message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
						writeResultMessage(response.getWriter(),message);
						return;
					}
				}
			}
			
		} catch (Exception e) {
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(e));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	
	
	/**
	 * 取得退休人员大病医保表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		RetiredCareForm  retiredCareForm=new RetiredCareForm();
		initCreater(retiredCareForm);
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredCareList.jsp");
		return mv.addObject("retiredCareForm", retiredCareForm);
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData<RetiredCare> resultData =retiredCareService.getRetiredCareList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
		
	}
	
	
	
	
	/**
	 * 删除退休人员大病医保表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除退休人员大病医保表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			retiredCareService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除退休人员大病医保表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增退休人员大病医保表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增退休人员大病医保表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RetiredCareForm  retiredCareForm=new RetiredCareForm();
		initCreater(retiredCareForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredCareEdit.jsp");
		return modelAndView.addObject("retiredCareForm",retiredCareForm);					
	}
	/**
	 * 	编辑退休人员大病医保表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑退休人员大病医保表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{	
		StringBuffer sb = new StringBuffer();
		Long personId = RequestUtil.getLong(request,"personId",0L);
		RetiredCareForm retiredCareForm = null;
		RetiredPersonCareForm retiredPersonCareForm = new RetiredPersonCareForm();
		if(personId!=0L){	//这个是详情
			List<WorkExperience> listWork = workExperienceService.getByPersonId(personId);
			if(listWork.size()>0){
				for (WorkExperience workExperience : listWork) {
					String begin = ZJ_DateUtils.dateToStr(workExperience.getCreateTime());
					String end  = ZJ_DateUtils.dateToStr(workExperience.getEndTime());
					sb.append("\n"+begin+"至"+end+"在"+workExperience.getWorkUnit()+""+"工作。");
				}
			}
			request.setAttribute("sb", sb);
			retiredCareForm = new RetiredCareForm();
			Map careMap = retiredCareService.getByPersonId(personId);
			retiredPersonCareForm = (RetiredPersonCareForm) BeanUtils.populateEntity(careMap,retiredPersonCareForm);
			retiredCareForm.setRetiredPersonCareForm(retiredPersonCareForm);
			retiredCareForm = (RetiredCareForm)BeanUtils.populateEntity(careMap,retiredCareForm);
			initCreater(retiredCareForm);
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredCareEdit.jsp");
		return modelAndView.addObject("retiredCareForm",retiredCareForm);					
	}

	/**
	 * 取得退休人员大病医保表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看退休人员大病医保表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		RetiredCare retiredCare = retiredCareService.getById(id);	
		return getAutoView().addObject("retiredCare", retiredCare);
	}
	
}
