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
<html lang="zh-cn">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>培训机构合作平台</title>
	<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/jquery/plugins/jquery.cookie.js"></script>
	<link rel="stylesheet" type="text/css" href="${ctx}/styles/login/css/login.css"/>
	<%
	    request.getSession().setAttribute("pxOrgId", "");
        request.getSession().setAttribute("orgAccount", "");
		Properties configProperties=(Properties)AppUtil.getBean("configproperties");
		String validCodeEnabled=configProperties.getProperty("validCodeEnabled");
	%>
<style>
  .logContWrap{width:100%;height:530px;background: url(${ctx}/styles/login/images/bg2.jpg) center top no-repeat #365da8;}
</style>
</head>

<body>
<div class="logContainer">
	<div class="logo dn">
		<div><!--  <img src="mlogo.png"/>--></div>
	</div>
	<div class="logo">
		<div class="clearfix logoImg">
			<span class="fl"><img src="${ctx}/styles/login/images/logo1.png"></span>
			<h1 class="logoh1 dib">培训机构合作平台</h1>
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
					<form  action="${ctx}/trainLogin.xf" method="post"  id="form-login">
						<div class="rinput">
							<span>账户</span>
							<span><input type="text" name="username" id="username" /></span>
							<input type="hidden"  id="flag"  name="flag" value="1" />
						</div>
						<div class="rinput">
							<span>密码</span>
							<span><input type="password" name="password" id="password"/></span>
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
		版权所有：濮阳市人力资源和社会保障局&nbsp;&nbsp;技术支持：<a class="ablue" href="http://www.xfxxgs.com">河南讯丰</a>&nbsp;&nbsp; 技术支持电话：0371-86502090</div>
</div>
<input type="hidden" value=<%=validCodeEnabled%> id="validCodeEnabled">
<script type="text/javascript">
	$(function(){
		var validCodeEnabled = $("#validCodeEnabled").val();
		if(validCodeEnabled && validCodeEnabled=='true'){
			reload();
			$(".seccode").css({"display":"block"})
		}
	
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
	
	/**
	 * 验证账号
 	 */
	function checkAccount(account,pwd){
		var flag=false;//true 表示通过
		$.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/per/checkAccount.xf',
    		data:{orgAccount:account,orgPwd:pwd},
    		dataType:'json',
    		async: false,
    		success: function(data){
    			if(data.result==1){
    				flag=true;
    			}else{
    				$(".errortip").empty().append("<div id='usernameTip'>"+data.message+"</div>");
    			}
             }
    	});
		return flag;
	}
	
	//个人登录
	function submitLogin(){
		//debugger;
		var username = $("#username").val();
		var password = $("#password").val();
		var validCode = $("#validCode").val();
		var isUsevalidCode= $("#validCodeEnabled").val();
		$(".errortip").empty();
		if(!username){//用户名为空
			$(".errortip").empty().append("<div id='usernameTip'>登录账户不能为空</div>");
			return;
		}else if(!password){
			$(".errortip").empty().append("<div id='pwdTip'>登录密码不能为空</div>");
			return;
		}else if(password.length>32){
			$(".errortip").empty().append("<div id='pwdTip'>密码不能超过32个字符</div>");
			return;
		}else{//提交表单
			//ajax 验证用户账号和密码是否正确和账号是否禁用
			var flag=checkAccount(username,password);
			if(flag){
				$("#form-login").submit();
			}
			/* $.ajax({ url: '${ctx}/business/train/trainOrg/per/checkAccount.xf',
	    		data:{orgAccount:username,orgPwd:password},
	    		dataType:'json',
	    		success: function(data){
	    			if(data.result==1){
	    				$("#form-login").submit();
	    				return;
	    			}else{
	    				$(".errortip").empty().append("<div id='usernameTip'>"+data.message+"</div>");
	    			}
	             }
	    	}); */
		}
	}
</script>
</body>
</html>