package com.xunfeng.business.personagency.archive.web;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanUtils;
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
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.web.form.ArchiveCheckoutForm;
import com.xunfeng.business.personagency.archive.interf.ArchiveCheckoutServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.entrust.web.form.CommissionChangeForm;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 控制器类
* @author:wanghan
* @createDate 2016-07-22 14:56:36 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/archive/archiveCheckout/")
public class ArchiveCheckoutController extends BaseController
{
	@Resource
	@Qualifier("archiveCheckout")
	private ArchiveCheckoutServiceInterf archiveCheckoutService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	/**
	 * 添加或更新档案借阅记录表。
	 * @param request
	 * @param response
	 * @param archiveCheckoutForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新档案借阅记录表")
	public void save(HttpServletRequest request, HttpServletResponse response,ArchiveCheckoutForm archiveCheckoutForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    ArchiveCheckout archiveCheckout = archiveCheckoutService.getById(id);
			archiveCheckout=archiveCheckoutForm.getModel(archiveCheckout);
			if(archiveCheckoutForm.isMvcAdd()){
				resultMsg="新增档案借阅记录";
				archiveCheckout.setId(uniqueIdUtil.genId(ArchiveCheckout.class.getName()));
				archiveCheckout.setCcpr08("0");
				archiveCheckoutService.saveArchiveCheckout(archiveCheckout);
			}else{
				resultMsg="编辑档案借阅记录";
			    archiveCheckoutService.update(archiveCheckout);
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
	 * 取得档案借阅记录表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archiveCheckoutList.jsp");
		return mv;
	}
	
	/**
	 * @param request
	 * @param response  档案借阅返还登记
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("registerList")
	public ModelAndView registerList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archiveRegisterCheckoutList.jsp");
		return mv;
	}
	/**
	 * @param request
	 * @param response  档案借阅返还确认
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("confirmList")
	public ModelAndView confirmList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archiveConfirmCheckoutList.jsp");
		return mv;
	}
	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("registerResultList")
	@Action(description="档案借阅返还登记查询")
	public ModelAndView registerResultList(HttpServletRequest request) throws Exception
	{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveRegisterCheckoutResult.jsp");
		modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
			.addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId())
			.addObject("archiveFlowStatus", archivesPersonForm.getArchiveFlowStatus()==null?"0":archivesPersonForm.getArchiveFlowStatus())
			.addObject("archiveReceiveStatus",archivesPersonForm.getArchiveReceiveStatus()==null?"0":archivesPersonForm.getArchiveReceiveStatus());				
		return modelAndView;
	}
	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("confirmResultList")
	@Action(description="档案借阅返还确认查询")
	public ModelAndView confirmResultList(HttpServletRequest request) throws Exception
	{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveConfirmCheckoutResult.jsp");
		modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
			.addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId())
			.addObject("archiveFlowStatus", archivesPersonForm.getArchiveFlowStatus()==null?"0":archivesPersonForm.getArchiveFlowStatus())
			.addObject("archiveReceiveStatus",archivesPersonForm.getArchiveReceiveStatus()==null?"0":archivesPersonForm.getArchiveReceiveStatus());				
		return modelAndView;
	}
	/**
	 * 取得档案借阅记录表分页列表
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
	    if("1".equals(fiter.getFilters().get("checkoutKinds"))){
			fiter.getFilters().remove("checkoutKinds");
		}
	    if("4".equals(fiter.getFilters().get("checkoutStatusNot"))){
			fiter.getFilters().remove("checkoutStatusNot");
		}
		ResultData  resultData = archiveCheckoutService.getAllArchiveCheckout(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	//到期未归还名单
	@RequestMapping("maturityNotReturned")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> MaturityNotReturned(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
	    fiter.addFilter("ccpr08", 0);
	    fiter.addFilter("checkoutKinds", 2);
	    fiter.addFilter("checkoutStatus", 2);
	    fiter.addFilter("endcheckoutPeriodDate", new Date());
		ResultData  resultData = archiveCheckoutService.getAllArchiveCheckout(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除档案借阅记录表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除档案借阅记录表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			archiveCheckoutService.delRegisterCheckoutByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除档案借阅记录成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增档案借阅记录表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增档案借阅记录表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long archiveId=RequestUtil.getLong(request,"archiveId",0L);
		ArchiveCheckoutForm  archiveCheckoutForm=new ArchiveCheckoutForm();
		archiveCheckoutForm.putModel(null);
		archiveCheckoutForm.setArchiveId(archiveId);
		archiveCheckoutForm.setCheckoutStatus(1L);
		SysUser sysUser=ContextUtil.getCurrentUser();
		archiveCheckoutForm.setCheckoutRegisterId(sysUser.getAcd230());
		archiveCheckoutForm.setCheckoutRegisterName(sysUser.getAac003());
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		archiveCheckoutForm.setCheckoutRegisterDate(new Date());
		archiveCheckoutForm.setCheckoutRegisterOrgId(sysOrg.getAcd200());
		archiveCheckoutForm.setCheckoutRegisterOrgName(sysOrg.getAcd202());
		Map personMap = new HashMap();
		if(archiveId!=0){
			personMap = archivesService.getArchivesPersonByArchivesId(archiveId);
		}	
		if(!personMap.isEmpty()){
			archiveCheckoutForm.setCheckoutPerson(personMap.get("aac003").toString());
			archiveCheckoutForm.setCheckoutPersonPhone(personMap.get("aae005")==null?"":personMap.get("aae005").toString());		
		}
		Calendar theCa = Calendar.getInstance();
		theCa.setTime(new Date());
		theCa.add(theCa.DATE, +1);
		Date checkoutDate = theCa.getTime();
		archiveCheckoutForm.setCheckoutDate(checkoutDate);
		Calendar theCb = Calendar.getInstance();
		theCb.setTime(new Date());
		theCb.add(theCb.DATE, +30);
		Date checkoutPeriodDate = theCb.getTime();
		archiveCheckoutForm.setCheckoutPeriodDate(checkoutPeriodDate);
		//存借阅人和借阅人电话
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveCheckoutEdit.jsp");
		return modelAndView.addObject("archiveCheckoutForm",archiveCheckoutForm);					
	}
	//借阅确认
	@RequestMapping("registerComfirmCheckout")
	@Action(description="借阅确认")
	@ResponseBody
	public ResultMessage registerComfirmCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long id = RequestUtil.getLong(request, "id", 0);
			//ArchiveCheckout archiveCheckout = archiveCheckoutService.getArchiveCheckoutByArchiveId(archiveId,1l);
			ArchiveCheckout archiveCheckout = archiveCheckoutService.getById(id);
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archiveCheckout.setCheckoutConfirmId(sysUser.getAcd230());
			archiveCheckout.setCheckoutConfirmName(sysUser.getAac003());
			archiveCheckout.setCheckoutConfirmDate(new Date());
			archiveCheckout.setCheckoutConfirmOrgId(sysOrg.getAcd200());
			archiveCheckout.setCheckoutConfirmOrgName(sysOrg.getAcd202());
			archiveCheckoutService.addRegisterComfirmCheckout(archiveCheckout);
			message=new ResultMessage(ResultMessage.Success, "借阅确认成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "借阅确认失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}

	/**
	 * @param request
	 * @param response
	 * @return 返还登记
	 * @throws Exception
	 */
	@RequestMapping("returnRegisterCheckout")
	@Action(description="返还登记")
	@ResponseBody
	public ResultMessage returnRegisterCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long id = RequestUtil.getLong(request, "id", 0);
			//ArchiveCheckout archiveCheckout = archiveCheckoutService.getArchiveCheckoutByArchiveId(archiveId,2l);
			ArchiveCheckout archiveCheckout = archiveCheckoutService.getById(id);
			SysUser sysUser=ContextUtil.getCurrentUser();
			archiveCheckout.setCheckinId(sysUser.getAcd230());
			archiveCheckout.setCheckinName(sysUser.getAac003());
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archiveCheckout.setCheckinDate(new Date());
			archiveCheckout.setCheckinOrgId(sysOrg.getAcd200());
			archiveCheckout.setCheckinOrgName(sysOrg.getAcd202());
			archiveCheckoutService.addReturnRegisterCheckout(archiveCheckout);
			message=new ResultMessage(ResultMessage.Success, "返还登记成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "返还登记失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * @param request
	 * @param response
	 * @return 返还确认
	 * @throws Exception
	 */
	@RequestMapping("returnConfirmCheckout")
	@Action(description="返还确认")
	@ResponseBody
	public ResultMessage returnConfirmCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long id = RequestUtil.getLong(request, "id", 0);
			//ArchiveCheckout archiveCheckout = archiveCheckoutService.getArchiveCheckoutByArchiveId(archiveId,3l);
			ArchiveCheckout archiveCheckout = archiveCheckoutService.getById(id);
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archiveCheckout.setCheckinConfirmId(sysUser.getAcd230());
			archiveCheckout.setCheckinConfirmName(sysUser.getAac003());
			archiveCheckout.setCheckinConfirmDate(new Date());
			archiveCheckout.setCheckinConfirmOrgId(sysOrg.getAcd200());
			archiveCheckout.setCheckinConfirmOrgName(sysOrg.getAcd202());
			archiveCheckoutService.addReturnConfirmCheckout(archiveCheckout);
			message=new ResultMessage(ResultMessage.Success, "返还确认成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "返还确认失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 	编辑档案借阅记录表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑档案借阅记录表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		ArchiveCheckout archiveCheckout=archiveCheckoutService.getById(id);
		ArchiveCheckoutForm  archiveCheckoutForm=new ArchiveCheckoutForm();
		archiveCheckoutForm.putModel(archiveCheckout);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveCheckoutEdit.jsp");
		return modelAndView.addObject("archiveCheckoutForm",archiveCheckoutForm);					
	}

	/**
	 * 取得档案借阅记录表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看档案借阅记录表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		ArchiveCheckout archiveCheckout = archiveCheckoutService.getById(id);	
		return getAutoView().addObject("archiveCheckout", archiveCheckout);
	}
	//刷新表头数据
	@RequestMapping("freshArchives")
	@Action(description="刷新保存后div")
	public ModelAndView freshArchives(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/freshArchivesDiv.jsp");
		modelAndView.addObject("archivesPersonForm",archivesPersonForm);		
		return modelAndView;					
	}
}
