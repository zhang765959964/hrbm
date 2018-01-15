package com.xunfeng.business.personagency.payment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 单位减免 控制器类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
@Controller
@RequestMapping("/business/personagency/payment/")
public class PaymentCorpDerateController extends BaseController {


	@Resource
	private CorpService corpService;


	@RequestMapping("listJson")
	@ResponseBody
	public List listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		List<Corp> list =corpService.getAll();
		return list;
	}
}
