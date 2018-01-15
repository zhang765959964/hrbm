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
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.web.form.PersonExpandForm;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息拓展表 控制器类
* @author:wanlupeng
* @createDate 2016-07-06 18:11:28 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/person/personExpand/")
public class PersonExpandController extends BaseController
{
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新个人基本信息拓展表。
	 * @param request
	 * @param response
	 * @param personExpandForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人基本信息拓展表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonExpandForm personExpandForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long expandId=RequestUtil.getLong(request,"expandId");
		    PersonExpand personExpand = personExpandService.getById(expandId);
			personExpand=personExpandForm.getModel(personExpand);
			if(personExpandForm.isMvcAdd()){
				resultMsg="添加个人基本信息拓展表";
				//personExpand.setExpandId(uniqueIdUtil.genSeqId(SqeIdName.PersonExpand.getSeqName()));
				personExpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
				personExpandService.add(personExpand);
				
			}else{
				resultMsg="更新个人基本信息拓展表";
			    personExpandService.update(personExpand);
				
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
	 * 取得个人基本信息拓展表分页列表
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
	 * 取得个人基本信息拓展表分页列表
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
		List<PersonExpand> list=personExpandService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除个人基本信息拓展表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人基本信息拓展表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "expandId");
			personExpandService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人基本信息拓展表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人基本信息拓展表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人基本信息拓展表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PersonExpandForm  personExpandForm=new PersonExpandForm();
		personExpandForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/person/personExpandEdit.jsp");
		
		return modelAndView.addObject("personExpandForm",personExpandForm);					
	}
	/**
	 * 	编辑个人基本信息拓展表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人基本信息拓展表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long expandId=RequestUtil.getLong(request,"expandId",0L);
		PersonExpand personExpand=personExpandService.getById(expandId);
		PersonExpandForm  personExpandForm=new PersonExpandForm();
		personExpandForm.putModel(personExpand);
		
		return getAutoView().addObject("personExpandForm",personExpandForm);					
	}

	/**
	 * 取得个人基本信息拓展表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人基本信息拓展表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long expandId=RequestUtil.getLong(request,"expandId");
		PersonExpand personExpand = personExpandService.getById(expandId);	
		return getAutoView().addObject("personExpand", personExpand);
	}
	
}
