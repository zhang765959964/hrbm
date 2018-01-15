package com.xunfeng.business.personagency.receive.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 获取主键
* @author jx 
* @createDate 2016年07月27日-上午11:11:21 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/receive/receive/")
public class GetPrimaryKeyController extends BaseController
{
	
	@RequestMapping("getPrimaryKey")
	@Action(description = "获取主键")
	@ResponseBody
	public ResultMessage getPrimaryKey(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		ResultMessage message=null;
		Long id =0l;
		try {
			String name = RequestUtil.getString(request, "name");
			id = uniqueIdUtil.genId(name);
			message=new ResultMessage(ResultMessage.Success, id.toString());
		} catch (Exception ex) {
			message=new ResultMessage(ResultMessage.Fail, "0");
		}
		return message;
	}
}
