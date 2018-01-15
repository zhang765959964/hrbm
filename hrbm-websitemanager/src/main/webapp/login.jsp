<%@page import="org.springframework.security.authentication.AuthenticationServiceException"%>
<%@page import="org.springframework.security.authentication.AccountExpiredException"%>
<%@page import="org.springframework.security.authentication.DisabledException"%>
<%@page import="org.springframework.security.authentication.LockedException"%>
<%@page import="org.springframework.security.authentication.BadCredentialsException"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.xunfeng.core.util.AppUtil"%>
<%@page import="java.util.Properties"%>
<%@ page pageEncoding="UTF-8" %>
<%@page import="org.springframework.security.web.WebAttributes"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html lang="zh-cn" onkeydown="enterLogin(event);">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="expires" content="-1">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="shortcut icon" href="${ctx}/styles/default/images/favicon.ico"/>
<!-- 	<title>濮阳市区县业务经办支撑系统</title> -->
	<title>${sysTitle }</title>
	<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/jquery/plugins/jquery.cookie.js"></script>
	<link rel="stylesheet" type="text/css" href="${ctx}/styles/login/css/login.css"/>
	<%
		Properties configProperties=(Properties)AppUtil.getBean("configproperties");
		String validCodeEnabled=configProperties.getProperty("validCodeEnabled");
	%>

</head>

<body>
<div class="logContainer">
	<div class="logo dn">
		<div><!--  <img src="mlogo.png"/>--></div>
	</div>
	<div class="logo">
		<div class="clearfix logoImg">
			<span class="fl"><img src="${ctx}/styles/login/images/logo1.png"></span>
<!-- 			<h1 class="logoh1 dib">濮阳市区县业务经办支撑系统</h1> -->
				<h1 class="logoh1 dib">${sysTitle}</h1>
			
		</div>
	</div>
	<div class="logContWrap clearfix">
		<div class="logCont">
			<div class="leftBg fl">
			</div>
			<div class="rightBox fl">
				<div class="rhead">用户登录</div>
				<div class="errortip">
				<%
					Object loginError=(Object)request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

					if(loginError!=null ){
						String msg="";
						if(loginError instanceof BadCredentialsException){
							msg="密码输入错误";
						}
						else if(loginError instanceof AuthenticationServiceException){
							AuthenticationServiceException ex=(AuthenticationServiceException)loginError;
							msg=ex.getMessage();
						}
						else{
							msg=loginError.toString();
						}
				%>
					<div id="checkFalse"><%=msg%></div>
				<%
					}
				%>
					<!--  <div class="" id="usernameTip">登录账户不能为空</div>
					<div class="" id="userpwdTip">登录账户或密码错误</div>
					<div class="" id="validCodeTip">验证码错误</div>-->
				</div>
				<div class="rcont">
					<form  action="${ctx}/login.xf" method="post"  id="form-login">
						<div class="rinput">
							<span>账户</span>
							<span><input type="text" name="username" id="username" /></span>
						</div>
						<div class="rinput">
							<span>密码</span>
							<span><input type="password" name="password" id="password" /></span>
						</div>
						<div class="seccode" style="display:none">
							<span>验证码</span>
							<span><input type="text" name="validCode" id="validCode"/></span>
							<div><a href="javascript:void(0);" onclick="reload();">换一个</a></div>
							<div><img id="validImg" src="" width="70" height="30"/></div>
						</div>
						<div class="rbtn" onclick="submitLogin();">
							登录
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="copyRight">
		版权所有：郑州市职业介绍中心&nbsp;&nbsp;技术支持：<a class="ablue" href="http://www.xfxxgs.com">河南讯丰信息技术有限公司</a>&nbsp;&nbsp; 技术支持电话：0371-86502090</div>
</div>
<input type="hidden" value=<%=validCodeEnabled%> id="validCodeEnabled">
<script type="text/javascript">
	if(top!=this){//当这个窗口出现在iframe里，表示其目前已经timeout，需要把外面的框架窗口也重定向登录页面
		  top.location='${ctx}/login.jsp';
	}
	$(function(){
		var validCodeEnabled = $("#validCodeEnabled").val();
		if(validCodeEnabled && validCodeEnabled=='true'){
			reload();
			$(".seccode").css({"display":"block"})
		}
		/*$(".rinput input").click(function(){
			$(".errortip").children("#checkFalse").remove();
		})
		$(".seccode input").click(function(){
			$(".errortip").children("#checkFalse").remove();
		})*/
		$(".rinput input").change(function(){
			var jobj = $(this);
			var objName = jobj.attr("name");
			if(objName && objName=="username"){
				$(".errortip").children("#usernameTip").remove();
			}else{
				$(".errortip").children("#pwdTip").remove();
			}

		})
		$(".seccode input").change(function(){
			$(".errortip").children("#validCodeTip").remove();
		})
	});
	//获得验证码
	function reload(){
		var url="${ctx}/servlet/ValidCode?rand=" +new Date().getTime();
		document.getElementById("validImg").src=url;
	}
	//个人登录
	function submitLogin(){debugger;
		var username = $("#username").val();
		var password = $("#password").val();
		var validCode = $("#validCode").val();
		var isUsevalidCode= $("#validCodeEnabled").val();
		$(".errortip").empty();
		if(!username){//用户名为空
			$(".errortip").empty().append("<div id='usernameTip'>登录账户不能为空</div>");
			return;
		}
		else if(username.length>20){//用户名长度超过了20个字符
			$(".errortip").empty().append("<div id='usernameTip'>账户不能超过20个字符</div>");
		    return;
		}
		else if(!password){
			$(".errortip").empty().append("<div id='pwdTip'>登录密码不能为空</div>");
			return;
		}else if(password.length>32){
			$(".errortip").empty().append("<div id='pwdTip'>密码不能超过32个字符</div>");
			return;
		}else if(isUsevalidCode && isUsevalidCode=='true'){
			if(!validCode){
				$(".errortip").empty().append("<div id='validCodeTip'>验证码不能为空</div>");
				return;
			}else if(validCode.length>4){
					$(".errortip").empty().append("<div id='validCodeTip'>验证码有误</div>");
					return;
			}else{
				$("#form-login").submit();
			}
		}else{//提交表单
			$("#form-login").submit();
		}
	}

	// 回车登录
	function enterLogin(et){
		if(et.keyCode){
            if (et.keyCode==13)
                // alert("IE Chrome 点击回车键");
            	submitLogin();
	    }
	}
</script>
</body>
</html>
