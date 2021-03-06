package com.xunfeng.business.personagency.death.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.death.interf.DeathPersonServiceInterf;
import com.xunfeng.business.personagency.death.model.DeathPerson;
import com.xunfeng.business.personagency.death.web.form.DeathPersonForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 供养直系亲属情况 控制器类
* @author:zhangfan
* @createDate 2016-08-30 10:12:09 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/death/person/")
public class DeathPersonController extends BaseController
{
	@Resource
	@Qualifier("deathPerson")
	private DeathPersonServiceInterf deathPersonService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新供养直系亲属情况。
	 * @param request
	 * @param response
	 * @param deathPersonForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新供养直系亲属情况")
	public void save(HttpServletRequest request, HttpServletResponse response,DeathPersonForm deathPersonForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    DeathPerson deathPerson = deathPersonService.getById(id);
			deathPerson=deathPersonForm.getModel(deathPerson);
			if(deathPersonForm.isMvcAdd()){
				resultMsg="添加供养直系亲属情况";
				deathPersonService.add(deathPerson);
			}else{
				resultMsg="更新供养直系亲属情况";
			    deathPersonService.update(deathPerson);
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
	 * 取得供养直系亲属情况分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/death/deathPersonList.jsp");
		
		return mv;
	}
	/**
	 * 取得供养直系亲属情况分页列表
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
		ResultData<DeathPerson> resultData=deathPersonService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除供养直系亲属情况
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除供养直系亲属情况")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			deathPersonService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除供养直系亲属情况成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增供养直系亲属情况
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增供养直系亲属情况")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		DeathPersonForm  deathPersonForm=new DeathPersonForm();
		deathPersonForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/death/deathPersonEdit.jsp");
		
		return modelAndView.addObject("deathPersonForm",deathPersonForm);					
	}
	/**
	 * 	编辑供养直系亲属情况
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑供养直系亲属情况")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		DeathPerson deathPerson=deathPersonService.getById(id);
		DeathPersonForm  deathPersonForm=new DeathPersonForm();
		deathPersonForm.putModel(deathPerson);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/death/deathPersonEdit.jsp");
		return modelAndView.addObject("deathPersonForm",deathPersonForm);					
	}

	/**
	 * 取得供养直系亲属情况明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看供养直系亲属情况明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		DeathPerson deathPerson = deathPersonService.getById(id);	
		return getAutoView().addObject("deathPerson", deathPerson);
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getByvDeathPersonJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByvDeathPerson(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData= deathPersonService.getByvDeathPerson(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 适用于综合查询代理详细查询 
	 * 死亡待遇申报亲属信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deathPersonvListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByvPersonId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		Long personId = RequestUtil.getLong(request, "personId",0L);
		if(personId!=0){
			fiter.addFilter("personId", personId);
		}
		ResultData<DeathPerson> resultData= deathPersonService.getByvPersonId(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
}
