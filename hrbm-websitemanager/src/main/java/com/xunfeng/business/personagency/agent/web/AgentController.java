package com.xunfeng.business.personagency.agent.web;

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
import com.xunfeng.business.personagency.payment.interf.PaymentDerateServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;

/**
 * 代理信息删除controller
 * @author zf
 * @date 2016年9月10日14:50:45
 *
 */
@Controller
@RequestMapping("/business/personagency/agent/")
public class AgentController extends BaseController {
	
	
	@Resource
	@Qualifier("retiredDeclare")
	private  RetiredDeclareServiceInterf retiredDeclareService;		//退休人员service
	
	
	@Resource
	@Qualifier("paymentDerate")
	private PaymentDerateServiceInterf paymentDerateService;	//缴费记录service
	
	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;			//档案service
	
	
	/**
	 * 进入到退休信息删除页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredList")
	public ModelAndView retiredList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/agent/retiredList.jsp");
		return mv;
	}
	
	
	/**
	 * 获得退休人员json页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> retiredListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=retiredDeclareService.getRetiredAll(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	/**
	 * 取得缴费记录分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("paymentIndex")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/business/personagency/agent/paymentIndex.jsp");
		return mv;
	}
	
	/**
	 * 取得缴费记录分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("paymentList")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long personId = RequestUtil.getLong(request, "personId", 0L);
		Map personMap = new HashMap();
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		if (personId != 0) {
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		}
		ModelAndView mv = new ModelAndView("/business/personagency/agent/paymentList.jsp");
		return mv.addObject("archivesPersonForm", archivesPersonForm)
				.addObject("personId", personId);

	}

	/**
	 * 取得缴费记录分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("paymentListJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		Long fkPersonId = RequestUtil.getLong(request, "fkPersonId", 0L);
		ResultData<PaymentRecordPersonDto> resultData = paymentDerateService.getPersonDerateList(fkPersonId,fiter.getPageBean());
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	
	
	/**
	 * 获得退休人员json页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getByvPersonId")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByvPersonId(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		Long personId = RequestUtil.getLong(request, "AAC001");
		fiter.addFilter("personId", personId);
		ResultData resultData=retiredDeclareService.getRetiredAll(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	/**
	 * 根据人员id删除
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delByPersonId")
	@Action(description="删除退休人员申报表")
	@ResponseBody
	public ResultMessage delByPersonId(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long personId = RequestUtil.getLong(request, "personId");
			retiredDeclareService.delByPersonId(personId);
			message=new ResultMessage(ResultMessage.Success, "删除退休人员申报表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	
	/**
	 * 取得人员档案表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("archivesList")
	public ModelAndView archivesList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/agent/archivesList.jsp");
		return mv;
	}
	
	/**
	 * 取得人员档案表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("archivesListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> archivesListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData  resultData = archivesService.getAllArchives(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());

	}
	
	
	
}
