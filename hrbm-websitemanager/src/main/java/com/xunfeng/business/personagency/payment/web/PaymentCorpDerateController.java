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

import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpDerateServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpRecordServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.web.form.CorpForm;
import com.xunfeng.business.personagency.payment.web.form.PaymentCorpRecordForm;
import com.xunfeng.business.personagency.payment.web.form.PaymentRecordForm;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 单位减免 控制器类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
@Controller
@RequestMapping("/business/personagency/payment/paymentCorpDerate/")
public class PaymentCorpDerateController extends BaseController {
	@Resource
	@Qualifier("paymentCorpRecord")
	private PaymentCorpRecordServiceInterf paymentCorpRecordService;
	
	
	@Resource
	@Qualifier("paymentCorpDerate")
	private PaymentCorpDerateServiceInterf paymentCorpDerateService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;

	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;

	@Resource
	@Qualifier("unitAgreement")
	private UnitAgreementServiceInterf unitAgreementService;

	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	@Resource
	@Qualifier("paymentRecord")
	private PaymentRecordServiceInterf paymentRecordService;

	/**
	 * 添加或更新单位减免。
	 * 
	 * @param request
	 * @param response
	 * @param paymentCorpRecordForm
	 *            添加或更新的实体
	 * @return  
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新单位减免")
	public void save(HttpServletRequest request, HttpServletResponse response,
			PaymentCorpRecordForm paymentCorpRecordForm) throws Exception {
		String resultMsg = null;
		ResultMessage message = null;

		try {
			Long pkId = RequestUtil.getLong(request, "pkId");
			PaymentCorpRecord paymentCorpRecord = paymentCorpRecordService.getById(pkId);

			if (paymentCorpRecord == null) {
				resultMsg = "添加单位减免";
				initCreater(paymentCorpRecordForm);
				paymentCorpRecord = paymentCorpRecordForm.getModel(paymentCorpRecord);
				paymentCorpRecord.setPkId(uniqueIdUtil.genId(PaymentCorpRecord.class.getName()));
				paymentCorpRecord.setFdPaymentStatus(PaymentStatus.未缴);
				paymentCorpRecord.setFdDerateStatus(DerateStatus.减免);
				paymentCorpRecordService.add(paymentCorpRecord);

			} else {
				resultMsg = "更新单位减免";
				paymentCorpRecord.setFdPaymentDate(paymentCorpRecordForm.getFdPaymentDate());
				paymentCorpRecord.setFdDerateStatus(DerateStatus.减免);
				paymentCorpRecordService.update(paymentCorpRecord);
			}
			message = new ResultMessage(ResultMessage.Success, resultMsg + "成功");

			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

	/**
	 * 取得单位减免分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long aab001 = RequestUtil.getLong(request, "aab001");

		Corp corp = corpService.getById(aab001);
		UnitAgreement unitAgreement = unitAgreementService.getByCoryId(aab001);
		CorpForm corpForm = new CorpForm();
		if (corp != null) {
			BeanToBean.copyProperties(corp, corpForm, false);
		}
		if (unitAgreement != null) {
			BeanToBean.copyProperties(unitAgreement, corpForm, false);
		}
		ModelAndView mv = new ModelAndView("/business/personagency/payment/corp/paymentCorpDerateList.jsp");
		return mv.addObject("corpForm", corpForm);
	}


	/**
	 * 取得单位减免分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("/business/personagency/payment/corp/paymentCorpDerateIndex.jsp");

		return mv;
	}



	/**
	 * 取得单位减免分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		ResultData<PaymentCorpRecordDto> resultData =paymentCorpDerateService.getCorpDerateList(fiter);// paymentCorpRecordService.getAllByFilter(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	


	/**
	 * 取得单位单位下档案信息分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpArchiveslistJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> corpArchiveslistJson(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

//		PageBean pageBean = new PageBean(request);
//		Long corpId = RequestUtil.getLong(request, "corpId");
		QueryFilter fiter = new QueryFilter(request);
		fiter.addFilter("archiveReceiveStatus",2);
		fiter.addFilter("archiveStatusValue", "1");
		fiter.addFilter("archiveFlowStatusValue", "4,6,9");
		ResultData<Map> resultData = archivesService.getCorpAllArchive(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}

	/**
	 * 删除单位减免
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description = "删除单位减免")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResultMessage message = null;
		try {
			Long lAryId = RequestUtil.getLong(request, "pkId");
			paymentCorpRecordService.delById(lAryId);
			message = new ResultMessage(ResultMessage.Success, "删除单位减免成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	/**
	 * 新增单位缴费
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("getAddData")
	@Action(description = "新增单位缴费")
	@ResponseBody
	public Map add(HttpServletRequest request) throws Exception {
		Map map=new HashMap();
		Long corpId = RequestUtil.getLong(request, "corpId");
		Long count=paymentCorpRecordService.getPaymentCorpRecordCount(corpId, PaymentStatus.未缴);
		if(count>0){
			map.put("result", 0);
			map.put("message", "已有未缴费记录，不能新增");
		}else{
			PaymentCorpRecordForm paymentCorpRecordForm = new PaymentCorpRecordForm();
			paymentCorpRecordForm.setPkId(0L);
			paymentCorpRecordForm.setFkCorpId(corpId);
			initCreater(paymentCorpRecordForm);
			paymentCorpRecordForm.setFdPaymentDate(new Date());
			paymentCorpRecordForm.setFdPaymentStatus(PaymentStatus.未缴);
			paymentCorpRecordForm.setFkCorpId(corpId);	
			PaymentCorpRecord paymentCorpRecord = paymentCorpRecordForm.getModel(null);
			paymentCorpRecord.setPkId(uniqueIdUtil.genId(PaymentCorpRecord.class.getName()));
			paymentCorpRecord.setFdPaymentStatus(PaymentStatus.未缴);
			paymentCorpRecord.setFdDerateStatus(DerateStatus.减免);
			paymentCorpRecordService.add(paymentCorpRecord);
			map.put("result", 1);
			map.put("rowData", paymentCorpRecord);
		}
		return map;
	}


	/**
	 * 编辑单位减免
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("batchAdd")
	@Action(description = "编辑单位减免")
	public ModelAndView batchAdd(HttpServletRequest request) throws Exception {
		String personIds = RequestUtil.getString(request, "personIds");
		String corpId = RequestUtil.getString(request, "corpId");
		String selType = RequestUtil.getString(request, "selType");
		Long fkCorpRecordId = RequestUtil.getLong(request, "corpRecordId");
		
		ModelAndView modelAndView = new ModelAndView(
				"/business/personagency/payment/corp/paymentCorpDerateBatchAdd.jsp");
		return modelAndView.addObject("fkCorpRecordId", fkCorpRecordId).addObject("personIds", personIds).addObject("corpId", corpId).addObject("selType", selType);
	}

	
	/**单位多选减免实收
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("paymentDerateSave")
	@Action(description = "单位多选减免实收")
	@ResponseBody
	public ResultMessage receiveMutiPayment(HttpServletRequest request, HttpServletResponse response, PaymentRecordForm paymentRecordForm) throws Exception {

		ResultMessage message = null;
		try {
			int paymentType = RequestUtil.getInt(request, "paymentType");
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "personIds");
			String selType = RequestUtil.getString(request, "selType");
			PaymentRecord paymentRecord=paymentRecordForm.getModel(new PaymentRecord());
			SysUser sysUser=ContextUtil.getCurrentUser();
			paymentRecord.setFkCreaterId(sysUser.getAcd230());
			paymentRecord.setFdCreaterName(sysUser.getAac003());
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			paymentRecord.setFdCreaterDate(new Date()) ;
			paymentRecord.setFkCreaterOrgId(sysOrg.getAcd200());
			paymentRecord.setFdCreaterOrgName(sysOrg.getAcd202());
			if("muti".equals(selType)){
				paymentCorpDerateService.mutiCorpDerate(paymentRecord, lAryId, paymentType);
			}else{
				paymentCorpDerateService.allCorpDerate(paymentRecord, paymentType);
			}
			
			
			message = new ResultMessage(ResultMessage.Success, "单位减免成功!");
		}catch (RuntimeException ex) {
			message = new ResultMessage(ResultMessage.Fail, ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "单位减免失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}
}
