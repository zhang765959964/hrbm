package com.xunfeng.business.personagency.payment.web;

import java.util.List;
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
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpOverDto;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpDerateServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpRecordServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 单位减免 控制器类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
@Controller
@RequestMapping("/business/personagency/payment/corp/together/search/")
public class PaymentCorpTogetherSearController extends BaseController {
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
	 * 取得单位减免分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("/business/personagency/payment/corp/paymentGeneralSearchList.jsp");
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
		ResultData<PaymentCorpRecordDto> resultData = paymentCorpRecordService.getAllWithCorpInfoFilter(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	

	/**
	 * 取得单位欠费分页列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("overListJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> overListJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		ResultData<PaymentCorpOverDto> resultData = paymentCorpRecordService.getOverUnitAgreement(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}

}
