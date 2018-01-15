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
import com.xunfeng.business.personagency.payment.interf.PaymentDerateServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentMainServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.business.personagency.payment.web.form.ArchivesPersonBaseForm;
import com.xunfeng.business.personagency.payment.web.form.PaymentRecordForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
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
@RequestMapping("/business/personagency/payment/derate/")
public class PaymentDerateController extends BaseController {
	@Resource
	@Qualifier("paymentRecord")
	private PaymentRecordServiceInterf paymentRecordService;
	@Resource
	@Qualifier("paymentDerate")
	private PaymentDerateServiceInterf paymentDerateService;
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
				SysUser sysUser = ContextUtil.getCurrentUser();
				paymentRecord.setFkCreaterId(sysUser.getAcd230());
				paymentRecord.setFdCreaterName(sysUser.getAac003());
				SysOrg sysOrg = ContextUtil.getCurrentUserOrg();
				paymentRecord.setFdCreaterDate(new Date());
				paymentRecord.setFkCreaterOrgId(sysOrg.getAcd200());
				paymentRecord.setFdCreaterOrgName(sysOrg.getAcd202());
				paymentRecord.setPkId(uniqueIdUtil.genId(PaymentRecord.class.getName()));
				String expPersonPhone=paymentRecordForm.getArchivesPersonBaseForm().getExpPersonPhone();
				String aae005=paymentRecordForm.getArchivesPersonBaseForm().getAAE005();
				paymentDerateService.addPaymentDerate(paymentRecord,expPersonPhone,aae005);
				
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
//
//	/**
//	 * 批量添加或更新单位缴费记录。
//	 * 
//	 * @param request
//	 * @param response
//	 * @param paymentRecordForm
//	 *            添加或更新的实体
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("corpBatchsave")
//	@Action(description = "添加或更新缴费记录")
//	public void corpBatchsave(HttpServletRequest request, HttpServletResponse response,
//			PaymentRecordForm paymentRecordForm) throws Exception {
//		Long[] personIds = RequestUtil.getLongAryByStr(request, "personIds");
//		String resultMsg = null;
//		ResultMessage message = null;
//		try {
//			PaymentRecord paymentRecord=new PaymentRecord();
//			paymentRecord = paymentRecordForm.getModel(paymentRecord);
//			resultMsg = "添加缴费记录";
//			SysUser sysUser = ContextUtil.getCurrentUser();
//			paymentRecord.setFkCreaterId(sysUser.getAcd230());
//			paymentRecord.setFdCreaterName(sysUser.getAac003());
//			SysOrg sysOrg = ContextUtil.getCurrentUserOrg();
//			paymentRecord.setFdCreaterDate(new Date());
//			paymentRecord.setFkCreaterOrgId(sysOrg.getAcd200());
//			paymentRecord.setFdCreaterOrgName(sysOrg.getAcd202());
//			paymentRecordService.batchAddCorpPayment(paymentRecord, personIds);
//			message = new ResultMessage(ResultMessage.Success, resultMsg + "成功");
//			writeResultMessage(response.getWriter(), message);
//		} catch (Exception ex) {
//			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(), message);
//		}
//	}

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
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentDerateIndex.jsp");

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
		Long lzStatus	= 0l;	//流转状态
		Long jsStatus = 0L;		//接收状态
		Long daStatus = 0l;	//档案状态
		
		Long personId = RequestUtil.getLong(request, "personId", 0L);
		String type = RequestUtil.getString(request, "type", "");
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
		}
		ModelAndView mv = new ModelAndView("/business/personagency/payment/paymentDerateList.jsp");
		return mv.addObject("type", type).addObject("archivesPersonForm", archivesPersonForm)
				.addObject("personId", personId).addObject("lzStatus", lzStatus).addObject("jsStatus",jsStatus).addObject("daStatus", daStatus);

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
		Long fkPersonId = RequestUtil.getLong(request, "fkPersonId", 0L);
		ResultData<PaymentRecordPersonDto> resultData = paymentDerateService.getPersonDerateList(fkPersonId,fiter.getPageBean());
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
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "pkId");
			paymentRecordService.delByIds(lAryId);
			message = new ResultMessage(ResultMessage.Success, "删除缴费记录成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
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
		PaymentMain paymentMain=paymentMainService.getPaymentMain(personId);
		if(paymentMain!=null){
			paymentRecordForm.setFdStartDate(DateUtil.addMonth(paymentMain.getFdEndPaymentDate(), "yyyy-MM", 1) );
		}else{
			paymentRecordForm.setFdStartDate(DateUtil.addMonth(archivesPersonForm.getReceiveDate(), "yyyy-MM", 1));
		}
		ModelAndView modelAndView = new ModelAndView("/business/personagency/payment/paymentDerateEdit.jsp");
		paymentRecordForm.setArchivesPersonBaseForm(archivesPersonForm);
		return modelAndView.addObject("paymentRecordForm", paymentRecordForm).addObject("fdPaymentType", fdPaymentType);
	}



}
