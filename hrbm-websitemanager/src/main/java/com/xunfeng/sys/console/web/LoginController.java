package com.xunfeng.sys.console.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.annotion.ActionExecOrder;
import com.xunfeng.core.log.SysAuditThreadLocalHolder;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.filter.HtSwitchUserFilter;
import com.xunfeng.core.web.servlet.ValidCode;
import com.xunfeng.core.web.util.CookieUitl;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:  登录控制器
* @author wanghan 
* @createDate 2015年4月23日-上午10:12:46 
* @version V1.0   
*/
@Controller
@RequestMapping("/login.xf")
//@Action(ownermodel=SysAuditModelType.LOGIN_MANAGEMENT)
public class LoginController extends BaseController {
	@Resource
    @Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager = null;
//	@Resource
//	private Properties configproperties;
//	
//	@Resource
//	private SessionLocaleResolver sessionLocaleResolver;
//	
//	@Resource
	private SessionAuthenticationStrategy sessionStrategy=new NullAuthenticatedSessionStrategy();
//	

	
//	@Resource
//	HtSecurityMetadataSource securityMetadataSource;
	//must the same as <remember-me key="bpm3PrivateKey"/> of app-security.xml 
	private String rememberPrivateKey="bpm3PrivateKey";
	public final static String TRY_MAX_COUNT="tryMaxCount";
	public final static int maxTryCount=100;
	

	/**
	 * 登录成功跳转的路径
	 */
	private String succeedUrl="/sys/console/main.xf";
	
	@RequestMapping
	@Action(description="用户登录",execOrder=ActionExecOrder.AFTER,
			detail="<#if success>用户【${SysAuditLinkService.getSysUserLink(username)}】登录系统成功<#else>账号【${username}】登录失败</#if>")
	public void login(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "username") String username,@RequestParam(value = "password") String password )
			throws IOException {
		
		String validCodeEnabled=configproperties.getProperty("validCodeEnabled");
		SecurityContextHolder.clearContext();
		//添加系统日志信息 -B
		try {
			SysAuditThreadLocalHolder.putParamerter("success", false);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		boolean error=false;
		try{
			if(validCodeEnabled!=null && "true".equals(validCodeEnabled)){
				String validCode=(String)request.getSession().getAttribute(ValidCode.SessionName_Randcode);
				String code=request.getParameter("validCode");
				if(validCode==null || StringUtils.isEmpty(code) || !validCode.equals(code)){
					request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "验证码不正确！");
					error=true;
				    throw new AccessDeniedException("验证码不正确");
					
				}
			}
			if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
				request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "用户名密码为空!");
				error=true;
				throw new AccessDeniedException("用户名密码为空!");
			}
			
			SysUser sysUser=sysUserService.getByUserName(username);
			
			String encrptPassword=password;//EncryptUtil.encryptSha256(password);
			if(sysUser==null||!encrptPassword.equals(sysUser.getPassword())){
				request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "用户名密码输入错误!");
				error=true;
				return;	
			}else if(sysUser!=null||encrptPassword.equals(sysUser.getPassword())){
				 //判断当前人员状态 add by wyy 2016-07-23
				 if(!"0".equals(sysUser.getCcpr08())){//非正常状态
					throw new  DisabledException("账号删除了");
				 }
			}
			
			//添加系统日志信息 -B
			try {
				SysAuditThreadLocalHolder.putParamerter("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
			authRequest.setDetails(new WebAuthenticationDetails(request));
			SecurityContext securityContext = SecurityContextHolder.getContext();
			Authentication auth = authenticationManager.authenticate(authRequest);
			securityContext.setAuthentication(auth);
//			String[] lan = language.split("_");
//			Locale curLocale = new Locale(lan[0],lan[1]);
//			//设置多语言支持
//			sessionLocaleResolver.setLocale(request, response, curLocale);
			
			//request.getSession().setAttribute(WebAttributes.LAST_USERNAME, username);	
			//登陆时移除管理员标识
			request.getSession().removeAttribute("isAdmin");
			
			sessionStrategy.onAuthentication(auth, request, response);
			
			
			//从session中删除组织数据。
//			ContextUtil.removeCurrentOrg(request,response);
			//从session中删除当前子系统。
//			request.getSession().removeAttribute(SubSystem.CURRENT_SYSTEM);
			request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME", username);
			
			//删除cookie。
			CookieUitl.delCookie("loginAction", request, response);
			//删除切换用户的cookie
			CookieUitl.delCookie(HtSwitchUserFilter.SwitchAccount, request, response);
			
			//writeRememberMeCookie(request,response,username,encrptPassword);
		}catch (LockedException e) {
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, username+":用户被锁定!");
			error=true;
		}catch (DisabledException e) {
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, username+":用户被禁用!");
			error=true;
		}catch (AccountExpiredException e) {
			request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, username+":用户已过期!");
			error=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(error==true){
				javax.servlet.http.HttpSession session=request.getSession();
				Integer tryCount=(Integer) session.getAttribute(TRY_MAX_COUNT);
		    	if(tryCount==null){
		    		session.setAttribute(TRY_MAX_COUNT, 1);
		    	}else{
		    		if(tryCount>maxTryCount-1){
		    			//锁定账户 TODO
		    			//session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, new MaxTryLoginException("超过最大登录尝试次数"+maxTryCount+",用户已被锁定"));
		    		}
		    		session.setAttribute("tryMaxCount", tryCount+1);
		    	}
		    }
			
			response.sendRedirect(request.getContextPath() + succeedUrl);
			
		}
			
		
	}
	

	/**
	 * 加上用户登录的remember me 的cookie
	 * @param request
	 * @param response
	 * @param username
	 * @param enPassword
	 */
	private void writeRememberMeCookie(HttpServletRequest request,HttpServletResponse response,String username,String enPassword){
		String rememberMe=request.getParameter("_spring_security_remember_me");
		if("1".equals(rememberMe)){
			long tokenValiditySeconds = 1209600; // 14 days
			long tokenExpiryTime = System.currentTimeMillis() + (tokenValiditySeconds * 1000);
			String signatureValue = DigestUtils.md5Hex(username + ":" + tokenExpiryTime + ":" + enPassword + ":" + rememberPrivateKey);
			String tokenValue = username + ":" + tokenExpiryTime + ":" + signatureValue;
			String tokenValueBase64 = new String(Base64.encodeBase64(tokenValue.getBytes()));
			Cookie cookie = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, tokenValueBase64);
			cookie.setMaxAge(60 * 60 * 24 * 365 * 5); // 5 years
			cookie.setPath(org.springframework.util.StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
			response.addCookie(cookie);
		}
	}
	

	
}
