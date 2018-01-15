package com.xunfeng.sys.console.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.util.CookieUitl;

@Controller
public class LoginHandlerController  {
	
	private  String defaultLogin="/login.jsp";
	

	@RequestMapping("/loginRedirect.xf")
	public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String loginAction=CookieUitl.getValueByName("loginAction", request);
		String redirectUrl="";
		Map<String,String> actionPageMap=(Map<String,String>)AppUtil.getBean("actionPageMap");
		if(StringUtil.isNotEmpty(loginAction) && actionPageMap.containsKey(loginAction)){
			redirectUrl=actionPageMap.get(loginAction);
			response.sendRedirect(request.getContextPath() +redirectUrl);
			return ;
		}
		response.sendRedirect(request.getContextPath() +this.defaultLogin);
		
	}


}
