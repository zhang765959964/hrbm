package com.xunfeng.business.personagency.affair.web;

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

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.affair.model.PersonLetter;
import com.xunfeng.business.personagency.affair.web.form.PersonLetterForm;
import com.xunfeng.business.personagency.affair.interf.PersonLetterServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 人事档案联系函表 控制器类
* @author:jiangxin
* @createDate 2016-09-14 09:32:03 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/affair/personLetter/")
public class PersonLetterController extends BaseController
{
	@Resource
	@Qualifier("personLetter")
	private PersonLetterServiceInterf personLetterService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新人事档案联系函表。
	 * @param request
	 * @param response
	 * @param personLetterForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新人事档案联系函表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonLetterForm personLetterForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    PersonLetter personLetter = personLetterService.getById(id);
			personLetter=personLetterForm.getModel(personLetter);
			if(personLetterForm.isMvcAdd()){
				resultMsg="添加人事档案联系函信息";
				personLetter.setId(uniqueIdUtil.genId(PersonLetter.class.getName()));
				personLetterService.add(personLetter);
			}else{
				resultMsg="修改人事档案联系函信息";
			    personLetterService.update(personLetter);
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
	 * 取得人事档案联系函表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/affair/personLetterList.jsp");
		return mv;
	}
	//
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/affair/personLetterSearch.jsp");
		return mv;
	}
	
	/**
	 * 取得人事档案联系函表分页列表
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
		fiter.addFilter("ccpr08", 0);
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		ResultData<PersonLetter> resultData=personLetterService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除人事档案联系函表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除人事档案联系函表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			personLetterService.deletePersonLetterByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除人事档案联系函成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增人事档案联系函表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增人事档案联系函表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PersonLetterForm  personLetterForm=new PersonLetterForm();
		personLetterForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/affair/personLetterEdit.jsp");
		personLetterForm.setCczy06("16");
		personLetterForm.setCcpr08("0");
		personLetterForm.setDateOfIssue(new Date());
		initCreater(personLetterForm);
		return modelAndView.addObject("personLetterForm",personLetterForm);					
	}
	/**
	 * 	编辑人事档案联系函表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑人事档案联系函表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		PersonLetter personLetter=personLetterService.getById(id);
		PersonLetterForm  personLetterForm=new PersonLetterForm();
		personLetterForm.putModel(personLetter);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/affair/personLetterEdit.jsp");
		return modelAndView.addObject("personLetterForm",personLetterForm);					
	}

	/**
	 * 取得人事档案联系函表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看人事档案联系函表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		PersonLetter personLetter = personLetterService.getById(id);	
		return getAutoView().addObject("personLetter", personLetter);
	}
	
}
