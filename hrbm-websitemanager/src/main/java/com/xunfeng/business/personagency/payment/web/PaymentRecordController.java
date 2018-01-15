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
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.enumeration.PaymentConst;
import com.xunfeng.business.personagency.payment.enumeration.PaymentType;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpRecordServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentMainServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.web.form.ArchivesPersonBaseForm;
import com.xunfeng.business.personagency.payment.web.form.PaymentRecordForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.DateUtil;
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
 * @Description: 缴费记录 控制器类
 * @author:wanghan
 * @createDate 2016-08-15 15:23:02
 * @version V1.0
 */
@Controller
@RequestMapping("/business/personagency/payment/paymentRecord/")
public class PaymentRecordController extends BaseController {
	@Resource
	@Qualifier("paymentRecord")
	private PaymentRecordServiceInterf paymentRecordService;
	@Resource
	@Qualifier("paymentCorpRecord")
	private PaymentCorpRecordServiceInterf paymentCorpRecordService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	
	@Resource
	@Qualifier("paymentMain")
	private PaymentMainServiceInterf paymentMainService;

	/**
	 * 添加或更新缴费记录。
	 * 
	 * @param request
	 * @param response
	 * @param paymentRecordForm
	 *            添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新缴费记录")
	public void save(HttpServletRequest request, HttpServletResponse response, PaymentRecordForm paymentRecordForm)
			throws Exception {
		String resultMsg = null;
		ResultMessage message = null;

		try {
			Long pkId = RequestUtil.getLong(request, "pkId");
			PaymentRecord paymentRecord = paymentRecordService.getById(pkId);

			String fdPaymentType = RequestUtil.getString(request, "fdPaymentType");
			paymentRecord = paymentRecordForm.getModel(paymentRecord);
			if (paymentRecordForm.isMvcAdd()) {
				resultMsg = "添加缴费记录";
				Long noPayCount=paymentRecordService.getNoPaymentCount(paymentRecord.getFkPersonId());
				if(noPayCount>0){
					message = new ResultMessage(ResultMessage.Fail, resultMsg + "有未缴费记录，请先缴费");

					writeResultMessage(response.getWriter(), message);
					return;
				}
				SysUser sysUser = ContextUtil.getCurrentUser();
				paymentRecord.setFkCreaterId(sysUser.getAcd230());
				paymentRecord.setFdCreaterName(sysUser.getAac003());
				SysOrg sysOrg = ContextUtil.getCurrentUserOrg();
				paymentRecord.setFdCreaterDate(new Date());
				paymentRecord.setFkCreaterOrgId(sysOrg.getAcd200());
				paymentRecord.setFdCreaterOrgName(sysOrg.getAcd202());
				paymentRecord.setPkId(uniqueIdUtil.genId(PaymentRecord.class.getName()));
				if (fdPaymentType.equals(PaymentType.单位缴费.getCode())) {
					paymentCorpRecordService.addCorpPayment(paymentRecord);
				} else {
					String expPersonPhone=paymentRecordForm.getArchivesPersonBaseForm().getExpPersonPhone();
					String aae005=paymentRecordForm.getArchivesPersonBaseForm().getAAE005();
					paymentRecordService.add(paymentRecord,expPersonPhone,aae005);
				}
			} else {
				resultMsg = "更新缴费记录";
				paymentRecordService.update(paymentRecord);

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
	 * 取得缴费记录分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String type = RequestUtil.getString(request, "type", "");
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentRecordIndex.jsp");

		return mv.addObject("type", type);
	}

	/**
	 * 取得缴费记录分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long personId = RequestUtil.getLong(request, "personId", 0L);
		
		String type = RequestUtil.getString(request, "type", "");
		Map personMap = new HashMap();
		ArchivesPersonBaseForm archivesPersonForm = new ArchivesPersonBaseForm();
		if (personId != 0) {
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonBaseForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		}
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentRecordList.jsp");
		return mv.addObject("type", type).addObject("archivesPersonForm", archivesPersonForm)
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
	@RequestMapping("listJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		ResultData<PaymentRecordPersonDto> resultData = paymentRecordService.getPersonRecordByFilter(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
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
	@RequestMapping("listCorpJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listCorpJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long fkCorpRecordId = RequestUtil.getLong(request, "fkCorpRecordId");
		String fdDerateStatus = RequestUtil.getString(request, "fdDerateStatus");
		PageBean pagePean=new PageBean(request);
		ResultData<PaymentRecordPersonDto> resultData = paymentRecordService.getPersonRecordByCorpRecordId(fkCorpRecordId,fdDerateStatus,pagePean);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}

	/**
	 * 删除缴费记录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description = "删除缴费记录")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResultMessage message = null;
		try {
			Long pkId = RequestUtil.getLong(request, "pkId");
			paymentRecordService.delById(pkId);
			message = new ResultMessage(ResultMessage.Success, "删除缴费记录成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail,  ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	/**
	 * 新增缴费记录
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description = "新增缴费记录")
	public ModelAndView add(HttpServletRequest request) throws Exception {
		Long personId = RequestUtil.getLong(request, "personId", 0L);
		Long fdPaymentType = RequestUtil.getLong(request, "fdPaymentType", 0L);
		Long fkCorpRecordId = RequestUtil.getLong(request, "corpRecordId");

		Map personMap = new HashMap();
		ArchivesPersonBaseForm archivesPersonForm = new ArchivesPersonBaseForm();
		if (personId != 0) {
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonBaseForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		}
		
		PaymentRecordForm paymentRecordForm = new PaymentRecordForm();
		paymentRecordForm.setFkPersonId(personId);
		paymentRecordForm.setFkCorpRecordId(fkCorpRecordId);
//		PaymentMain paymentMain=paymentMainService.getPaymentMain(personId);
		String endPaymentDate=paymentMainService.getLastPayMentDate(personId);
		paymentRecordForm.setFdStartDate(DateUtil.addMonth(endPaymentDate, "yyyy-MM", 1));
		ModelAndView modelAndView = new ModelAndView("/business/personagency/payment/paymentRecordEdit.jsp");
		paymentRecordForm.setArchivesPersonBaseForm(archivesPersonForm);
		return modelAndView.addObject("paymentRecordForm", paymentRecordForm).addObject("fdPaymentType", fdPaymentType);
	}

	/**
	 * 编辑缴费记录
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑缴费记录")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long pkId = RequestUtil.getLong(request, "pkId", 0L);
		PaymentRecord paymentRecord = paymentRecordService.getById(pkId);
		PaymentRecordForm paymentRecordForm = new PaymentRecordForm();
		paymentRecordForm.putModel(paymentRecord);
		ModelAndView modelAndView = new ModelAndView("/business/personagency/payment/paymentRecordEdit.jsp");
		return modelAndView.addObject("paymentRecordForm", paymentRecordForm);
	}

	/**
	 * 取得缴费记录明细
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description = "查看缴费记录明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long pkId = RequestUtil.getLong(request, "pkId");
		PaymentRecord paymentRecord = paymentRecordService.getById(pkId);
		return getAutoView().addObject("paymentRecord", paymentRecord);
	}

}
