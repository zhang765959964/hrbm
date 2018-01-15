package com.xunfeng.business.personagency.archive.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.business.personagency.archive.web.form.ArchiveCheckoutForm;
import com.xunfeng.business.personagency.archive.web.form.ArchiveLendForm;
import com.xunfeng.business.personagency.archive.interf.ArchiveCheckoutServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.storage.model.WageStandard;
import com.xunfeng.business.personagency.storage.web.form.WageStandardForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 控制器类
* @author:wanghan
* @createDate 2016-07-22 14:56:36 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/batch/archiveCheckout/")
public class BatchArchiveCheckoutController extends BaseController
{
	@Resource
	@Qualifier("archiveCheckout")
	private ArchiveCheckoutServiceInterf archiveCheckoutService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	//返回批量借阅登记页面
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/batchArchiveCheckoutRegister.jsp");
		ArchiveCheckoutForm  archiveCheckoutForm=new ArchiveCheckoutForm();
		archiveCheckoutForm.setCheckoutStatus(1L);
		SysUser sysUser=ContextUtil.getCurrentUser();
		archiveCheckoutForm.setCheckoutRegisterId(sysUser.getAcd230());
		archiveCheckoutForm.setCheckoutRegisterName(sysUser.getAac003());
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		archiveCheckoutForm.setCheckoutRegisterDate(new Date());
		archiveCheckoutForm.setCheckoutRegisterOrgId(sysOrg.getAcd200());
		archiveCheckoutForm.setCheckoutRegisterOrgName(sysOrg.getAcd202());
		Calendar theCb = Calendar.getInstance();
		theCb.setTime(new Date());
		theCb.add(theCb.DATE, +30);
		Date checkoutPeriodDate = theCb.getTime();
		archiveCheckoutForm.setCheckoutPeriodDate(checkoutPeriodDate);
		return mv.addObject("archiveCheckoutForm", archiveCheckoutForm);
	}
	//返回档案查找借阅登记
	@RequestMapping("searchListJson")
	@Action(description="返回档案查找借阅登记")
	@ResponseBody
	public List searchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		/*if(!StringUtil.isEmpty((String)fiter.getFilters().get("aac002"))){
			fiter.addFilter("aac002", "%"+fiter.getFilters().get("aac002")+"%");
		}
		if(!StringUtil.isEmpty((String)fiter.getFilters().get("archiveCode"))){
			fiter.addFilter("archiveCode", "%"+fiter.getFilters().get("archiveCode")+"%");
		}*/
		ResultData  resultData = archivesService.getArchivesCheckoutNot(fiter);		
		return resultData.getDataList();
	}
	
	//返回档案批量借阅登记
	@RequestMapping("listJson")
	@Action(description="返回档案查找借阅登记")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData  resultData = archivesService.getAllArchivesCheckoutR(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	//档案批量借阅登记
	@RequestMapping("resgisterOne")
	@Action(description="加载档案批量借阅登记页面")
	public ModelAndView resgisterOne(HttpServletRequest request) throws Exception
	{
		
		ArchiveCheckoutForm  archiveCheckoutForm=new ArchiveCheckoutForm();
		archiveCheckoutForm.setCheckoutStatus(1L);
		SysUser sysUser=ContextUtil.getCurrentUser();
		archiveCheckoutForm.setCheckoutRegisterId(sysUser.getAcd230());
		archiveCheckoutForm.setCheckoutRegisterName(sysUser.getAac003());
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		archiveCheckoutForm.setCheckoutRegisterDate(new Date());
		archiveCheckoutForm.setCheckoutRegisterOrgId(sysOrg.getAcd200());
		archiveCheckoutForm.setCheckoutRegisterOrgName(sysOrg.getAcd202());
		Calendar theCb = Calendar.getInstance();
		theCb.setTime(new Date());
		theCb.add(theCb.DATE, +30);
		Date checkoutPeriodDate = theCb.getTime();
		archiveCheckoutForm.setCheckoutPeriodDate(checkoutPeriodDate);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/batchArchiveResgisterOne.jsp");
					 modelAndView.addObject("archiveCheckoutForm2", archiveCheckoutForm);
		return modelAndView;					
	}
	//档案批量归还登记
	@RequestMapping("resgisterTwo")
	@Action(description="加载档案批量归还登记页面")
	public ModelAndView resgisterTwo(HttpServletRequest request) throws Exception
	{
		
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		String checkinDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		List batchList = archiveCheckoutService.getBatchName(2l);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/batchArchiveResgisterTwo.jsp");
					 modelAndView.addObject("checkinName", sysUser.getAac003()).addObject("checkinOrgName", sysOrg.getAcd202())
					 .addObject("checkinDate", checkinDate).addObject("batchList", batchList);
		return modelAndView;					
	}
	//单位档案批量调出登记
	@RequestMapping("resgisterSave")
	@Action(description="单位档案批量调出登记保存")
	public void resgisterSave(HttpServletRequest request, HttpServletResponse response,ArchiveCheckoutForm archiveCheckoutForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
			Long id=RequestUtil.getLong(request,"id");
		    ArchiveCheckout archiveCheckout = archiveCheckoutService.getById(id);
			archiveCheckout=archiveCheckoutForm.getModel(archiveCheckout);
			if(archiveCheckoutForm.isMvcAdd()){
				resultMsg="批量借阅登记";
				archiveCheckoutService.addBatchCheckOutRegister(archiveCheckout,archiveCheckoutForm.getArchiveIds());
			}else{
				resultMsg="批量借阅登记";
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
	//批量借阅确认
	@RequestMapping("batchComfirmCheckout")
	@Action(description="批量借阅确认")
	@ResponseBody
	public ResultMessage batchComfirmCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String ids = RequestUtil.getString(request, "id");
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			ArchiveCheckout archiveCheckout = new ArchiveCheckout();
			archiveCheckout.setCheckoutConfirmId(sysUser.getAcd230());
			archiveCheckout.setCheckoutConfirmName(sysUser.getAac003());
			archiveCheckout.setCheckoutConfirmDate(new Date());
			archiveCheckout.setCheckoutConfirmOrgId(sysOrg.getAcd200());
			archiveCheckout.setCheckoutConfirmOrgName(sysOrg.getAcd202());
			archiveCheckoutService.addBatchComfirmCheckout(archiveCheckout,ids);
			message=new ResultMessage(ResultMessage.Success, "借阅确认成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "借阅确认失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	//批量归还登记
	@RequestMapping("batchReturnResgister")
	@Action(description="批量归还登记")
	@ResponseBody
	public ResultMessage batchReturnResgister(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String ids = RequestUtil.getString(request, "id");
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			ArchiveCheckout archiveCheckout = new ArchiveCheckout();
			archiveCheckout.setCheckinId(sysUser.getAcd230());
			archiveCheckout.setCheckinName(sysUser.getAac003());
			archiveCheckout.setCheckinDate(new Date());
			archiveCheckout.setCheckinOrgId(sysOrg.getAcd200());
			archiveCheckout.setCheckinOrgName(sysOrg.getAcd202());
			archiveCheckoutService.addBatchReturnResgister(archiveCheckout,ids);
			message=new ResultMessage(ResultMessage.Success, "归还登记成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "归还登记失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	//批量归还确认
	@RequestMapping("batchReturnComfirm")
	@Action(description="批量归还确认")
	@ResponseBody
	public ResultMessage batchReturnComfirm(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String ids = RequestUtil.getString(request, "id");
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			ArchiveCheckout archiveCheckout = new ArchiveCheckout();
			archiveCheckout.setCheckinConfirmId(sysUser.getAcd230());
			archiveCheckout.setCheckinConfirmName(sysUser.getAac003());
			archiveCheckout.setCheckinConfirmDate(new Date());
			archiveCheckout.setCheckinConfirmOrgId(sysOrg.getAcd200());
			archiveCheckout.setCheckinConfirmOrgName(sysOrg.getAcd202());
			archiveCheckoutService.addBatchReturnComfirm(archiveCheckout,ids);
			message=new ResultMessage(ResultMessage.Success, "归还确认成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "归还确认失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	//借阅归还批量确认页面
	@RequestMapping("confirmList")
	public ModelAndView confirmList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/batchArchiveCheckoutConfirm.jsp");
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		String checkoutConfirmDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		List batchList = archiveCheckoutService.getBatchName(1l);
		mv.addObject("checkoutConfirmName", sysUser.getAac003()).addObject("checkoutConfirmOrgName", sysOrg.getAcd202())
			.addObject("checkoutConfirmDate", checkoutConfirmDate).addObject("batchList", batchList);
		return mv;
	}
	//档案批量归还确认页面
	@RequestMapping("confirmTwo")
	@Action(description="加载档案批量借阅登记页面")
	public ModelAndView confirmTwo(HttpServletRequest request) throws Exception
	{
		
		ModelAndView mv= new ModelAndView("/business/personagency/archive/batchArchiveCheckoutConfirmReturn.jsp");
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		String checkoutConfirmDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		List batchList = archiveCheckoutService.getBatchName(3l);
		mv.addObject("checkinConfirmName", sysUser.getAac003()).addObject("checkinConfirmOrgName", sysOrg.getAcd202())
			.addObject("checkinConfirmDate", checkoutConfirmDate).addObject("batchList", batchList);
		return mv;				
	}
	//置顶功能实现
	@RequestMapping("operationTop")
	@Action(description="置顶功能实现")
	@ResponseBody
	public List operationTop(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
	    fiter.addFilter("ccpr08", 0);
		ResultData  resultData = archiveCheckoutService.getAllArchiveCheckout(fiter);		
		return resultData.getDataList();
	}
	//验证批次名是不是已经存在
	@RequestMapping("checkedBatchName")
	@Action(description = "验证批次名是不是已经存在")
	@ResponseBody
	public Map checkedBatchName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map =new HashMap();
		try{
			//查询批次名
			String  batchName =  RequestUtil.getString(request, "batchName");
			Long card = archiveCheckoutService.getCheckedByBatchName(batchName);
			if(card>0){
				map.put("valid",false);
			}else{
				map.put("valid",true);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("valid",false);
		}
		return map;
	}
}
