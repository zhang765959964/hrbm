package com.xunfeng.business.personagency.payment.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.payment.web.form.ArchivesPersonBaseForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 缴费记录 控制器类
* @author:wanghan
* @createDate 2016-08-15 15:23:02 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/payment/paymentReceive/")
public class PaymentRecordReceiveController extends BaseController
{
	@Resource
	@Qualifier("paymentRecord")
	private PaymentRecordServiceInterf paymentRecordService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	

	/**
	 * 批量实收
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("payment")
	@ResponseBody
	public ResultMessage payment(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long recordId =RequestUtil.getLong(request, "recordId");
			SysUser sysUser=ContextUtil.getCurrentUser();
			paymentRecordService.bathPayment(recordId, sysUser);
			message=new ResultMessage(ResultMessage.Success, "缴费成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "缴费失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 取得缴费记录分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView List(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		String type=RequestUtil.getString(request,"type","");
		ModelAndView mv= new ModelAndView("/business/personagency/payment/paymentRecordReceive.jsp");
		
		return mv.addObject("type", type);
	}
	
	
	/**
	 * 取得未缴费记录分页列表
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
		int page=RequestUtil.getInt(request, "page");
		int pageSize=RequestUtil.getInt(request,"rows",PageBean.DEFAULT_PAGE_SIZE);
		int fitlerType=RequestUtil.getInt(request, "fitlerType");
		PageBean pageBean=new PageBean(page,pageSize);
		ResultData<PaymentRecordPersonDto> resultData;
		if(fitlerType==0){
			 resultData=paymentRecordService.getNoReceiveGroupPayList(pageBean,new Date());	
		}else{
			resultData=paymentRecordService.getNoReceiveGroupPayList(pageBean);	
		}
		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 取得已缴费记录分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listOverJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listNOJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		int page=RequestUtil.getInt(request, "page");
		int pageSize=RequestUtil.getInt(request,"rows",PageBean.DEFAULT_PAGE_SIZE);
		PageBean pageBean=new PageBean(page,pageSize);
		ResultData<PaymentRecordPersonDto> resultData=paymentRecordService.getOverReceiveGroupPayList(pageBean,new Date());	
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 	编辑缴费记录
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑缴费记录")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long recordId=RequestUtil.getLong(request,"recordId",0L);
		
		Map personMap = new HashMap();
		ArchivesPersonBaseForm archivesPersonForm = new ArchivesPersonBaseForm();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonBaseForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/payment/paymentRecordReceiveEdit.jsp");
		return modelAndView.addObject("archivesPersonForm",archivesPersonForm).addObject("recordId", recordId).addObject("opType", "edit");					
	}

	/**
	 * 	编辑缴费记录
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("view")
	@Action(description="编辑缴费记录")
	public ModelAndView view(HttpServletRequest request) throws Exception
	{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long recordId=RequestUtil.getLong(request,"recordId",0L);
		Map personMap = new HashMap();
		ArchivesPersonBaseForm archivesPersonForm = new ArchivesPersonBaseForm();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonBaseForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/payment/paymentRecordReceiveEdit.jsp");
		return modelAndView.addObject("archivesPersonForm",archivesPersonForm).addObject("recordId", recordId).addObject("opType", "view");					
	}
	
}
