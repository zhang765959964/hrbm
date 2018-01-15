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
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.retired.model.RetiredPerson;
import com.xunfeng.business.personagency.retired.web.form.RetiredPersonForm;
import com.xunfeng.business.personagency.retired.interf.RetiredPersonServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_RETIRED_PERSON 控制器类
* @author:zhangfan
* @createDate 2016-08-02 17:12:13 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/retired/person/")
public class RetiredPersonController extends BaseController
{
	@Resource
	@Qualifier("retiredPerson")
	private RetiredPersonServiceInterf retiredPersonService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	/**
	 * 添加或更新RSDA_BS_RETIRED_PERSON。
	 * @param request
	 * @param response
	 * @param retiredPersonForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新RSDA_BS_RETIRED_PERSON")
	public void save(HttpServletRequest request, HttpServletResponse response,RetiredPersonForm retiredPersonForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    RetiredPerson retiredPerson = retiredPersonService.getById(id);
			retiredPerson=retiredPersonForm.getModel(retiredPerson);
			if(retiredPersonForm.isMvcAdd()){
				resultMsg="添加RSDA_BS_RETIRED_PERSON";
				retiredPerson.setId(uniqueIdUtil.genId(RetiredPerson.class.getName()));
				retiredPersonService.add(retiredPerson);
				
			}else{
				resultMsg="更新RSDA_BS_RETIRED_PERSON";
			    retiredPersonService.update(retiredPerson);
				
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
	 * 取得RSDA_BS_RETIRED_PERSON分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		RetiredPersonForm  retiredPersonForm=new RetiredPersonForm();
		initCreater(retiredPersonForm);
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredPersonList.jsp");
		return mv.addObject("retiredPersonForm", retiredPersonForm);
	}
	/**
	 * 取得RSDA_BS_RETIRED_PERSON分页列表
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
		ResultData<RetiredPerson> resultData=retiredPersonService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除RSDA_BS_RETIRED_PERSON
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除RSDA_BS_RETIRED_PERSON")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			retiredPersonService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除RSDA_BS_RETIRED_PERSON成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	
	
	/**
	 * 	新增RSDA_BS_RETIRED_PERSON
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增RSDA_BS_RETIRED_PERSON")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RetiredPersonForm  retiredPersonForm=new RetiredPersonForm();
		retiredPersonForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredPersonEdit.jsp");
		
		return modelAndView.addObject("retiredPersonForm",retiredPersonForm);					
	}
	/**
	 * 	编辑RSDA_BS_RETIRED_PERSON
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑RSDA_BS_RETIRED_PERSON")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		RetiredPerson retiredPerson=retiredPersonService.getById(id);
		RetiredPersonForm  retiredPersonForm=new RetiredPersonForm();
		retiredPersonForm.putModel(retiredPerson);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredPersonEdit.jsp");
		return modelAndView.addObject("retiredPersonForm",retiredPersonForm);					
	}

	/**
	 * 取得RSDA_BS_RETIRED_PERSON明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看RSDA_BS_RETIRED_PERSON明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		RetiredPerson retiredPerson = retiredPersonService.getById(id);	
		return getAutoView().addObject("retiredPerson", retiredPerson);
	}
	
	
	
	
	
	
}
