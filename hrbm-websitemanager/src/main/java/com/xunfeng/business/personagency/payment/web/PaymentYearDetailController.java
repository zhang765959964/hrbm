package com.xunfeng.business.personagency.payment.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.payment.interf.PaymentYearDetailServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentYearDetail;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL 控制器类
* @author:user
* @createDate 2016-11-03 16:16:59 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/payment/paymentYearDetail/")
public class PaymentYearDetailController extends BaseController
{
	@Resource
	@Qualifier("paymentYearDetail")
	private PaymentYearDetailServiceInterf paymentYearDetailService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	

	/**
	 * 取得RSDA_BS_PAYMENT_YEARDETAIL分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData<PaymentYearDetail> resultData=paymentYearDetailService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除RSDA_BS_PAYMENT_YEARDETAIL
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除缴费记录")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long lAryId =RequestUtil.getLong(request, "id");
			paymentYearDetailService.delById(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除缴费记录成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
}
