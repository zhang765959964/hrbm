package com.xunfeng.business.person.web;

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
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.web.form.PersonFamilyForm;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员家庭关系表 控制器类
* @author:wanlupeng
* @createDate 2016-07-07 09:13:01 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/person/personFamily/")
public class PersonFamilyController extends BaseController
{
	@Resource
	@Qualifier("personFamily")
	private PersonFamilyServiceInterf personFamilyService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新人员家庭关系表。
	 * @param request
	 * @param response
	 * @param personFamilyForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新人员家庭关系表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonFamilyForm personFamilyForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    PersonFamily personFamily = personFamilyService.getById(id);
			personFamily=personFamilyForm.getModel(personFamily);
			if(personFamilyForm.isMvcAdd()){
				resultMsg="添加人员家庭关系表";
				//personFamily.setId(uniqueIdUtil.genSeqId(SqeIdName.PersonFamily.getSeqName()));
				personFamily.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));
				personFamilyService.add(personFamily);
				
			}else{
				resultMsg="更新人员家庭关系表";
			    personFamilyService.update(personFamily);
				
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
	 * 取得人员家庭关系表分页列表
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
	 * 取得人员家庭关系表分页列表
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
		List<PersonFamily> list=personFamilyService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除人员家庭关系表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除人员家庭关系表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			personFamilyService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除人员家庭关系表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增人员家庭关系表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增人员家庭关系表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PersonFamilyForm  personFamilyForm=new PersonFamilyForm();
		personFamilyForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/person/personFamilyEdit.jsp");
		
		return modelAndView.addObject("personFamilyForm",personFamilyForm);					
	}
	/**
	 * 	编辑人员家庭关系表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑人员家庭关系表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		PersonFamily personFamily=personFamilyService.getById(id);
		PersonFamilyForm  personFamilyForm=new PersonFamilyForm();
		personFamilyForm.putModel(personFamily);
		
		return getAutoView().addObject("personFamilyForm",personFamilyForm);					
	}

	/**
	 * 取得人员家庭关系表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看人员家庭关系表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		PersonFamily personFamily = personFamilyService.getById(id);	
		return getAutoView().addObject("personFamily", personFamily);
	}
	
}
