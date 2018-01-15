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

import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.person.web.form.PersonWorkExpceForm;
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
* @Description: 个人工作经历表 控制器类
* @author:wanlupeng
* @createDate 2016-07-15 09:51:03 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/person/personWorkExpce/")
public class PersonWorkExpceController extends BaseController
{
	@Resource
	@Qualifier("personWorkExpce")
	private PersonWorkExpceServiceInterf personWorkExpceService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新个人工作经历表。
	 * @param request
	 * @param response
	 * @param personWorkExpceForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人工作经历表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonWorkExpceForm personWorkExpceForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long aac0b0=RequestUtil.getLong(request,"aac0b0");
		    PersonWorkExpce personWorkExpce = personWorkExpceService.getById(aac0b0);
			personWorkExpce=personWorkExpceForm.getModel(personWorkExpce);
			if(personWorkExpceForm.isMvcAdd()){
				resultMsg="添加个人工作经历";
				personWorkExpce.setAac0b0(uniqueIdUtil.genId(SqeIdName.PersonWorkExpce.getSeqName()));
				personWorkExpceService.add(personWorkExpce);
			}else{
				resultMsg="更新个人工作经历";
			    personWorkExpceService.update(personWorkExpce);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功"+personWorkExpce.getAac0b0());
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得个人工作经历表分页列表
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
	 * 取得个人工作经历表分页列表
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

		ResultData<PersonWorkExpce> resultData=personWorkExpceService.getAllWorkExpce(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除个人工作经历表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人工作经历表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "aac0b0");
			personWorkExpceService.deletePersonWorkExpceByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人工作经历表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人工作经历表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人工作经历表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PersonWorkExpceForm  personWorkExpceForm=new PersonWorkExpceForm();
		personWorkExpceForm.setAac001(RequestUtil.getLong(request,"aac001"));
		personWorkExpceForm.putModel(null);
		personWorkExpceForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		personWorkExpceForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		personWorkExpceForm.setAae036(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/person/workExpce/personWorkExpceEdit.jsp");
		
		return modelAndView.addObject("personWorkExpceForm",personWorkExpceForm);					
	}
	/**
	 * 	编辑个人工作经历表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人工作经历表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long aac0b0=RequestUtil.getLong(request,"aac0b0",0L);
		PersonWorkExpce personWorkExpce=personWorkExpceService.getById(aac0b0);
		PersonWorkExpceForm  personWorkExpceForm=new PersonWorkExpceForm();
		personWorkExpceForm.putModel(personWorkExpce);
		ModelAndView modelAndView= new ModelAndView("/business/person/workExpce/personWorkExpceEdit.jsp");
		return modelAndView.addObject("personWorkExpceForm",personWorkExpceForm);					
	}

	/**
	 * 取得个人工作经历表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人工作经历表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long aac0b0=RequestUtil.getLong(request,"aac0b0");
		PersonWorkExpce personWorkExpce = personWorkExpceService.getById(aac0b0);	
		return getAutoView().addObject("personWorkExpce", personWorkExpce);
	}
	
	@RequestMapping("isExist")
	@Action(description = "判断工作经历是否已添加")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<PersonWorkExpce> list = personWorkExpceService.getByExist(fiter);	
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
