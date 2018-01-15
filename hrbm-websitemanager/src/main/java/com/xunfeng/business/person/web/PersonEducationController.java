package com.xunfeng.business.person.web;

import java.util.Date;
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

import com.xunfeng.business.person.interf.PersonEducationServiceInterf;
import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.business.person.web.form.PersonEducationForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人教育背景表 控制器类
* @author:wanlupeng
* @createDate 2016-07-14 17:57:20 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/person/personEducation/")
public class PersonEducationController extends BaseController
{
	@Resource
	@Qualifier("personEducation")
	private PersonEducationServiceInterf personEducationService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新个人教育背景表。
	 * @param request
	 * @param response
	 * @param personEducationForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人教育背景表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonEducationForm personEducationForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long aac0d0=RequestUtil.getLong(request,"aac0d0");
		    PersonEducation personEducation = personEducationService.getById(aac0d0);
			personEducation=personEducationForm.getModel(personEducation);
			if(personEducationForm.isMvcAdd()){
				resultMsg="添加个人教育背景";
				personEducation.setAac0d0(uniqueIdUtil.genId(SqeIdName.PersonEducation.getSeqName()));
				personEducationService.add(personEducation);
			}else{
				resultMsg="更新个人教育背景";
			    personEducationService.update(personEducation);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功"+personEducation.getAac0d0());
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得个人教育背景表分页列表
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
	 * 取得个人教育背景表分页列表
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
		ResultData<PersonEducation> resultData=personEducationService.getAllEducation(fiter);
		return getJqGridData(resultData.getPageBean(),resultData.getDataList());
	}
	/**
	 * 删除个人教育背景表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人教育背景表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "aac0d0");
			personEducationService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人教育背景表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人教育背景表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人教育背景表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PersonEducationForm  personEducationForm=new PersonEducationForm();
		personEducationForm.putModel(null);
		personEducationForm.setAac001(RequestUtil.getLong(request,"aac001"));
		personEducationForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		personEducationForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		personEducationForm.setAae036(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/person/personEducationEdit.jsp");
		return modelAndView.addObject("personEducationForm",personEducationForm);					
	}
	/**
	 * 	编辑个人教育背景表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人教育背景表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long aac0d0=RequestUtil.getLong(request,"aac0d0",0L);
		PersonEducation personEducation=personEducationService.getById(aac0d0);
		PersonEducationForm  personEducationForm=new PersonEducationForm();
		personEducationForm.putModel(personEducation);
		return getAutoView().addObject("personEducationForm",personEducationForm);					
	}

	/**
	 * 取得个人教育背景表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人教育背景表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long aac0d0=RequestUtil.getLong(request,"aac0d0");
		PersonEducation personEducation = personEducationService.getById(aac0d0);	
		return getAutoView().addObject("personEducation", personEducation);
	}
	/**
	 * 所学专业判重
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isExist")
	@Action(description = "判断该所学专业是否已选择")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			long atc01g = RequestUtil.getLong(request, "atc01g");
			long acc01g = RequestUtil.getLong(request, "acc01g");
			if(acc01g==atc01g){
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			}else if(acc01g!=0&&atc01g!=0&&atc01g==acc01g){
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			}else{
				resultMessage = new ResultMessage(ResultMessage.Fail, "不存在");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}
	@RequestMapping("isExistAac045")
	@Action(description = "判断教育背景是否已添加")
	@ResponseBody
	public ResultMessage isExistAac045(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<PersonEducation> list = personEducationService.getByAac045(fiter);	
			if (list != null && list.size() > 0) {
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			} else {
				resultMessage = new ResultMessage(ResultMessage.Fail, "不存在");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}
	
}
