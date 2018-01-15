package com.xunfeng.sys.console.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xunfeng.business.train.interf.TrainOrgServiceInterf;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.web.controller.BaseController;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:  登录控制器
* @author wanghan 
* @createDate 2015年4月23日-上午10:12:46 
* @version V1.0   
*/
@Controller
@RequestMapping("/trainLogin.xf")
//@Action(ownermodel=SysAuditModelType.LOGIN_MANAGEMENT)
public class TrainLoginController extends BaseController {
	
	@Resource
	@Qualifier("trainOrg")
	private TrainOrgServiceInterf trainOrgService;

	/**
	 * 登录成功跳转的路径
	 */
	private String succeedUrl="/sys/console/trainMain.xf";
	
	/**
	 * 培训机构账号登录 
	 */
	@RequestMapping
	@Action(description="用户登录")
	public void trainLogin(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "username") String username,@RequestParam(value = "password") String password )
			throws IOException {
		//根据用户名查找培训机构
		TrainOrg to=trainOrgService.getOrgByAccount(username);
		if(to==null || !password.equals(to.getOrgPwd())){
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "用户名密码输入错误!");
			return;	
		}
		if("1".equals(to.getIsDisable())){//账号被禁用
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "该账号已被禁用!");
			return;	
		}
		if(!("1".equals(to.getIsAudit()))){//账号未被审核通过
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "该账号未审核通过!");
			return;	
		}
		request.getSession().setAttribute("pxOrgId", to.getPxOrgId());
		request.getSession().setAttribute("orgAccount", to.getOrgAccount());
		response.sendRedirect(request.getContextPath() + succeedUrl);
	}
	
}
