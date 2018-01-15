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
import com.xunfeng.business.personagency.payment.dto.PaymentRefundDto;
import com.xunfeng.business.personagency.payment.enumeration.PaymentConst;
import com.xunfeng.business.personagency.payment.enumeration.RefundStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentMainServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRefundServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.payment.model.PaymentRefund;
import com.xunfeng.business.personagency.payment.web.form.ArchivesPersonBaseForm;
import com.xunfeng.business.personagency.payment.web.form.PaymentRefundConfirmForm;
import com.xunfeng.business.personagency.payment.web.form.PaymentRefundForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
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
 * @Description: 退费记录 控制器类
 * @author:wanghan
 * @createDate 2016-08-17 14:13:49
 * @version V1.0
 */
@Controller
@RequestMapping("/business/personagency/payment/paymentRefund/")
public class PaymentRefundController extends BaseController {
	@Resource
	@Qualifier("paymentRefund")
	private PaymentRefundServiceInterf paymentRefundService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("paymentRecord")
	private PaymentRecordServiceInterf paymentRecordService;

	@Resource
	@Qualifier("paymentMain")
	private PaymentMainServiceInterf paymentMainService;

	/**
	 * 添加或更新退费记录。
	 * 
	 * @param request
	 * @param response
	 * @param paymentRefundForm
	 *            添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新退费记录")
	public void save(HttpServletRequest request, HttpServletResponse response, PaymentRefundForm paymentRefundForm)
			throws Exception {
		String resultMsg = null;
		ResultMessage message = null;

		try {
			Long pkId = RequestUtil.getLong(request, "pkId");
			PaymentRefund paymentRefund = paymentRefundService.getById(pkId);
			paymentRefund = paymentRefundForm.getModel(paymentRefund);
			if (paymentRefundForm.isMvcAdd()) {
				resultMsg = "添加退费记录";
				Long count = paymentRefundService.getRefundCount(paymentRefund.getPkPersonId(), RefundStatus.已登记);
				if (count > 0) {
					message = new ResultMessage(ResultMessage.Success, "已有退费登记记录，请先完成");

					writeResultMessage(response.getWriter(), message);
					return;
				}
				paymentRefund.setPkId(uniqueIdUtil.genId(PaymentRefund.class.getName()));
				SysUser sysUser = ContextUtil.getCurrentUser();
				paymentRefund.setFkCreaterId(sysUser.getAcd230());
				paymentRefund.setFdCreaterName(sysUser.getAac003());
				SysOrg sysOrg = ContextUtil.getCurrentUserOrg();
				paymentRefund.setFdCreaterDate(new Date());
				paymentRefund.setFkCreaterOrgId(sysOrg.getAcd200());
				paymentRefund.setFdCreaterOrgName(sysOrg.getAcd202());
				paymentRefundService.add(paymentRefund);

			} else {
				resultMsg = "更新退费记录";
				paymentRefundService.update(paymentRefund);

			}
			message = new ResultMessage(ResultMessage.Success, resultMsg + "成功");

			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentRefundIndex.jsp");

		return mv;
	}

	/**
	 * 取得退费记录分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long personId = RequestUtil.getLong(request, "personId", 0L);
		Long lzStatus	= 0l;	//流转状态
		Long jsStatus = 0L;		//接收状态
		Long daStatus = 0l;	//档案状态
		Map personMap = new HashMap();
		ArchivesPersonBaseForm archivesPersonForm = new ArchivesPersonBaseForm();
		
		if (personId != 0) {
			Archives archives = archivesService.getArchivesByPId(personId);
 			if(archives!=null){	//档案编号不为空
 				lzStatus = archives.getArchiveFlowStatus();	//流转状态
 				jsStatus = archives.getArchiveReceiveStatus();	//档案接收状态
 				daStatus = archives.getArchiveStatus();	//档案状态
 			}  
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonBaseForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
			String paymentEndDate = paymentMainService.getLastPayMentDate(personId);
			archivesPersonForm.setPaymentEndDate(paymentEndDate);
		}
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentRefundList.jsp");
		return mv.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
				.addObject("lzStatus", lzStatus).addObject("jsStatus",jsStatus).addObject("daStatus", daStatus);

	}

	/**
	 * 取得退费记录分页列表
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
		ResultData<PaymentRefund> resultData = paymentRefundService.getAllByFilter(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}

	/**
	 * 删除退费记录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description = "删除退费记录")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResultMessage message = null;
		try {
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "pkId");
			paymentRefundService.delByIds(lAryId);
			message = new ResultMessage(ResultMessage.Success, "删除退费记录成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	/**
	 * 新增退费记录
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description = "新增退费记录")
	public ModelAndView add(HttpServletRequest request) throws Exception {
		Long pkPersonId = RequestUtil.getLong(request, "personId", 0L);
		Map personMap = archivesService.getArchivesByPersonId(pkPersonId);
		String fdRefundEndDate = paymentMainService.getLastPayMentDate(pkPersonId);
		PaymentRefundForm paymentRefundForm = new PaymentRefundForm();
		// paymentRefundForm = (PaymentRefundForm)
		// BeanUtils.populateEntity(personMap, paymentRefundForm);
		paymentRefundForm.setAac002((String) personMap.get("AAC002"));
		paymentRefundForm.setAac003((String) personMap.get("AAC003"));
		paymentRefundForm.setArchiveCode((String) personMap.get("archiveCode"));
		paymentRefundForm.setPkPersonId(pkPersonId);
		paymentRefundForm.setFdRefundStandard("5");
		paymentRefundForm.setFdRefundStartDate("2015-01");
		paymentRefundForm.setFdRefundEndDate(fdRefundEndDate);
		initCreater(paymentRefundForm);
		ModelAndView modelAndView = new ModelAndView("/business/personagency/payment/paymentRefundEdit.jsp");
		return modelAndView.addObject("paymentRefundForm", paymentRefundForm);
	}

	/**
	 * 编辑退费记录
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑退费记录")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long pkId = RequestUtil.getLong(request, "pkId", 0L);
		PaymentRefund paymentRefund = paymentRefundService.getPaymentRefundById(pkId);
		PaymentRefundForm paymentRefundForm = new PaymentRefundForm();
		paymentRefundForm = BeanToBean.copyProperties(paymentRefund, paymentRefundForm);
		ModelAndView modelAndView = new ModelAndView("/business/personagency/payment/paymentRefundEdit.jsp");
		return modelAndView.addObject("paymentRefundForm", paymentRefundForm);

	}

	/**
	 * 删除退费记录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isAllowAdd")
	@Action(description = "删除退费记录")
	@ResponseBody
	public ResultMessage isAllowAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResultMessage message = null;
		try {
			Long pkPersonId = RequestUtil.getLong(request, "personId", 0L);
			Long count=paymentRefundService.getRefundCount(pkPersonId, RefundStatus.已登记);
			if(count>0){
				message = new ResultMessage(ResultMessage.Fail, "已有登记中退费记录，请先退费");
				return message;
			}
			PaymentMain paymentMain = paymentMainService.getPaymentMain(pkPersonId);
			if (paymentMain == null) {
				message = new ResultMessage(ResultMessage.Fail, "无缴费记录");
			} else if (DateUtil.compare(paymentMain.getFdEndPaymentDate(), PaymentConst.endPaymentDate, "yyyy-MM") <= 0) {
				message = new ResultMessage(ResultMessage.Fail, "无可退费用");
			} else {
				message = new ResultMessage(ResultMessage.Success, "");
			}

		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "退费判断失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	@RequestMapping("confirmList")
	public ModelAndView confirmList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentRefundConfirmList.jsp");

		return mv;
	}

	/**
	 * 取得已登记退费记录分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("regListJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> regListJson(HttpServletRequest request, HttpServletResponse response) throws Exception {

		QueryFilter fiter = new QueryFilter(request);
		ResultData<PaymentRefundDto> resultData = paymentRefundService.getRegisterRefundList(fiter.getPageBean());
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());

	}

	/**
	 * 编辑退费记录
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("confirmEdit")
	@Action(description = "编辑退费记录")
	public ModelAndView confirmEdit(HttpServletRequest request) throws Exception {

		Long pkId = RequestUtil.getLong(request, "pkId", 0L);
		PaymentRefund paymentRefund = paymentRefundService.getPaymentRefundById(pkId);
		PaymentRefundConfirmForm paymentRefundConfirmForm = new PaymentRefundConfirmForm();
		paymentRefundConfirmForm = BeanToBean.copyProperties(paymentRefund, paymentRefundConfirmForm);
		SysUser sysUser = ContextUtil.getCurrentUser();
		SysOrg sysOrg = ContextUtil.getCurrentUserOrg();
		paymentRefundConfirmForm.setFkConfirmsId(sysUser.getAcd230());
		paymentRefundConfirmForm.setFdConfirmsName(sysUser.getAac003());
		paymentRefundConfirmForm.setFdConfirmsDate(new Date());
		paymentRefundConfirmForm.setFdConfirmsOrgId(sysOrg.getAcd200());
		paymentRefundConfirmForm.setFdConfirmsOrgName(sysOrg.getAcd202());
		ModelAndView modelAndView = new ModelAndView("/business/personagency/payment/paymentRefundConfirmEdit.jsp");
		return modelAndView.addObject("paymentRefundConfirmForm", paymentRefundConfirmForm);

	}

	/**
	 * 添加或更新退费记录。
	 * 
	 * @param request
	 * @param response
	 * @param paymentRefundForm
	 *            添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("confirm")
	@Action(description = "添加或更新退费记录")
	public void confirm(HttpServletRequest request, HttpServletResponse response,
			PaymentRefundConfirmForm paymentRefundForm) throws Exception {
		String resultMsg = "财务退费";
		ResultMessage message = null;

		try {
			Long pkId = RequestUtil.getLong(request, "pkId");
			PaymentRefund paymentRefund = paymentRefundService.getById(pkId);
			paymentRefund = paymentRefundForm.getModel(paymentRefund);
			paymentRefundService.confirmRefund(paymentRefund);
			message = new ResultMessage(ResultMessage.Success, resultMsg + "成功");
			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

}
