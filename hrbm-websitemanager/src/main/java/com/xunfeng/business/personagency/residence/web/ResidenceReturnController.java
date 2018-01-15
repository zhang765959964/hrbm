package com.xunfeng.business.personagency.residence.web;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.personagency.residence.model.ResidenceMoveOut;
import com.xunfeng.business.personagency.residence.model.ResidenceReturn;
import com.xunfeng.business.personagency.residence.web.form.ResidenceReturnForm;
import com.xunfeng.business.personagency.residence.interf.ResidenceMoveOutServiceInterf;
import com.xunfeng.business.personagency.residence.interf.ResidenceReturnServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口借用归还表 控制器类
* @author:jiangxin
* @createDate 2016-08-30 09:58:41 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/residence/residenceReturn/")
public class ResidenceReturnController extends BaseController
{
	@Resource
	@Qualifier("residenceReturn")
	private ResidenceReturnServiceInterf residenceReturnService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("residenceMoveOut")
	private ResidenceMoveOutServiceInterf residenceMoveOutService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	
	/**
	 * 添加或更新户口借用归还表。
	 * @param request
	 * @param response
	 * @param residenceReturnForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新户口借用归还表")
	public void save(HttpServletRequest request, HttpServletResponse response,ResidenceReturnForm residenceReturnForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    ResidenceReturn residenceReturn = residenceReturnService.getById(id);
			residenceReturn=residenceReturnForm.getModel(residenceReturn);
			if(residenceReturnForm.isMvcAdd()){
				resultMsg="添加户口借用信息";
				residenceReturn.setId(uniqueIdUtil.genId(ResidenceReturn.class.getName()));
				residenceReturnService.add(residenceReturn);
			}else{
				resultMsg="修改户口借用信息";
			    residenceReturnService.update(residenceReturn);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	// 户口借用归还
	@RequestMapping("backResidence")
	@Action(description="删除户口借用归还表")
	@ResponseBody
	public ResultMessage backResidence(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			 Long id=RequestUtil.getLong(request,"id",0L);
			 ResidenceReturn residenceReturn = residenceReturnService.getById(id);
			 residenceReturn.setReturnDate(new Date());
			 SysUser sysUser=ContextUtil.getCurrentUser();
			 SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			 residenceReturn.setReturnCreaterDate(new Date());
			 residenceReturn.setReturnCreaterId(sysUser.getAcd230());
			 residenceReturn.setReturnCreaterName(sysUser.getAac003());
			 residenceReturn.setReturnCreaterOrgId(sysOrg.getAcd200());
			 residenceReturn.setReturnCreaterOrgName(sysOrg.getAcd202());
			 residenceReturnService.update(residenceReturn);
			message=new ResultMessage(ResultMessage.Success, "归还户口信息成功");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "归还户口信息失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 取得户口借用归还表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/residence/residenceReturnList.jsp");
		
		return mv;
	}
	/**
	 * 取得户口借用归还表分页列表
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
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		fiter.addFilter("ccpr08", 0);
		ResultData<ResidenceReturn> resultData=residenceReturnService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除户口借用归还表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除户口借用归还表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			residenceReturnService.deleteResidenceReturnByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除户口借用归还信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增户口借用归还表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增户口借用归还表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long moId=RequestUtil.getLong(request,"moId",0L);
		ResidenceReturnForm  residenceReturnForm=new ResidenceReturnForm();
		residenceReturnForm.putModel(null);
		ResidenceMoveOut residenceMoveOut = residenceMoveOutService.getById(moId);
		if(residenceMoveOut!=null){
			residenceReturnForm.setArchivesId(residenceMoveOut.getArchivesId());
			residenceReturnForm.setPersonId(residenceMoveOut.getPersonId());
			residenceReturnForm.setMoId(moId);
		}
		initCreater(residenceReturnForm);
		residenceReturnForm.setCczy06("16");
		residenceReturnForm.setCcpr08("0");
		Calendar theCa = Calendar.getInstance();
		theCa.setTime(new Date());
		theCa.add(theCa.DATE, +30);
		Date date = theCa.getTime();
		residenceReturnForm.setMaturityDate(date);
		residenceReturnForm.setBorrowerDate(new Date());
		PersonBaseInfo person = personBaseInfoService.getById(residenceMoveOut.getPersonId()==null?0l:residenceMoveOut.getPersonId());
		if(person!=null){
			residenceReturnForm.setBorrowerName(person.getAac003());
			residenceReturnForm.setBorrowerPhone(person.getAae005());
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/residenceReturnEdit.jsp");
		return modelAndView.addObject("residenceReturnForm",residenceReturnForm);					
	}
	/**
	 * 	编辑户口借用归还表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑户口借用归还表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		ResidenceReturn residenceReturn=residenceReturnService.getById(id);
		ResidenceReturnForm  residenceReturnForm=new ResidenceReturnForm();
		residenceReturnForm.putModel(residenceReturn);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/residenceReturnEdit.jsp");
		return modelAndView.addObject("residenceReturnForm",residenceReturnForm);					
	}

	/**
	 * 取得户口借用归还表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看户口借用归还表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		ResidenceReturn residenceReturn = residenceReturnService.getById(id);	
		return getAutoView().addObject("residenceReturn", residenceReturn);
	}
	
}
