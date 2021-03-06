<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台管理系统</title>
		<meta name="keywords" content="后台管理系统" />
		<meta name="description" content="后台管理系统" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		<meta name="renderer" content="webkit">
		<link rel="shortcut icon" href="${ctx}/styles/default/images/favicon.ico"/>
		<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${ctx}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		<!-- fonts
		<link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />
		-->
		<!-- ace styles -->
		<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />
		<link src="${ctx}/js/lib/bootstrap3-editable/css/bootstrap-editable.css"/>
		<link rel="stylesheet" type="text/css" media="all" href="${ctx}/js/lib/bootstrap-datetime-range/daterangepicker.css" />
		 <link type="text/css" href="${ctx}/js/lib/jquery-ui-bootstrap/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${ctx}/assets/css/ace-ie.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${ctx}/styles/default/css/index.css" type="text/css">
		<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-table.min.css" />
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->

		<script src="${ctx}/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="${ctx}/assets/js/html5shiv.js"></script>
		<script src="${ctx}/assets/js/respond.min.js"></script>
		<![endif]-->


		<!--<script src="http://ajax.useso.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>



		<!--[if IE]>
		<script src="${ctx}/assets/js/jquery/1.10.2/jquery.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${ctx}/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='${ctx}/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${ctx}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="${ctx}/assets/js/bootstrap.min.js"></script>
		<script src="${ctx}/assets/js/typeahead-bs2.min.js"></script>
		<script src="${ctx}/js/lib/jquery-ui-bootstrap/jquery-ui-1.10.0.custom.min.js"></script>


		<!-- page specific plugin scripts -->


		<!-- ace scripts -->
		<script src="${ctx}/assets/js/ace-elements.min.js"></script>
		<script src="${ctx}/assets/js/ace.min.js"></script>
		<script src="${ctx}/assets/js/bootbox.min.js"></script>
		<script type="text/javascript" src='${ctx }/js/ui/xfui.js'></script>
		<style>
		html,body{height:100%;}
		</style>
		<script>
		//左侧菜单单击事件
        function _onClick(_this) {
			if(!$(_this).attr("url")){
				return;
			}
			$(".dropdown-toggle").each(function(){
				$(this).attr("class","dropdown-toggle");
			});
			$(_this).attr("class","dropdown-toggle active");
        	xfui.open_tabs($(_this).attr("txt"),"${ctx}"+$(_this).attr("url"));
        }
        </script>
        <style>.navbar-brand{padding-left:0 !important;}</style>
	</head>

	<body class="navbar-fixed breadcrumbs-fixed overflowyh">
		<div class="navbar navbar-default navbar-fixed-top" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="javascript:void(0)" class="navbar-brand">
						<small>
						<img src="${ctx}/styles/login/images/logo1.png"  style="width:33px;">
							濮阳市区县业务经办支撑系统
						</small>
					</a><!-- 濮阳市区县业务经办支撑系统/.brand -->
				</div><!-- /.navbar-header -->
				<div class="navbar-header pull-right" role="navigation">
					<!-- <div class="nav-search" id="nav-search" style="right:170px;">
 						<form class="form-search">
 							<span class="input-icon">
 								<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
 								<i class="icon-search nav-search-icon"></i>
 							</span>
 						</form>
					</div> -->
					<!-- #nav-search -->
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
 								<!-- <img class="nav-user-photo" src="${ctx}/assets/avatars/user.jpg" alt="Jason's Photo" /> -->
								<span class="user-info">
									<small>欢迎光临,</small>
									${sysUser.aac003}
								</span>
								<i class="icon-caret-down"></i>
							</a>
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li class="divider"></li>
								<li>
									<a href="${ctx}/logout">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
						<li class="changeSkin">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
 								<!-- <img class="nav-user-photo" src="${ctx}/assets/avatars/user.jpg" alt="Jason's Photo" /> -->
								<span class="user-info">
									<small>欢迎光临,</small>
									${sysUser.aac003}
								</span>
								<i class="icon-caret-down"></i>
							</a>
							<div class="pull-right">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container h100p" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner h100p">
				<div class="sidebar sidebar-fixed" id="sidebar">
					<script type="text/javascript">try{ace.settings.check('sidebar' , 'fixed')}catch(e){}</script>
					<ul class="nav nav-list" id="navLeft">
					  <c:forEach items="${sysResourceList}" var="sysResource">
					     <li>
							<a href="#" class="dropdown-toggle">
								<i class="${sysResource.funmenu}"></i>
								<span class="menu-text ellipsis"> ${sysResource.funname}</span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
							    <c:forEach items="${sysResource.subSysResourceList}" var="subsysResource">
							         <li>
										<a href="#" class="dropdown-toggle" url="${subsysResource.funmapping}" txt="${subsysResource.funname}" onclick="_onClick(this)">
											<!-- <i class="${subsysResource.funmenu}"></i> -->
											<i  class="icon-double-angle-right"></i>
											<span class="menu-text ellipsis"> ${subsysResource.funname}</span>
											<c:choose>
											<c:when test="${empty subsysResource.subSysResourceList}">
											<b class="arrow icon-angle-right"></b>
											</c:when>
											<c:otherwise>
											<b class="arrow icon-angle-down"></b>
											</c:otherwise>
											</c:choose>
										</a>
									  	<ul class="submenu">
										    <c:forEach items="${subsysResource.subSysResourceList}" var="sub_subsysResource">
										        <li>
													<a href="#" class="dropdown-toggle" url="${sub_subsysResource.funmapping}" txt="${sub_subsysResource.funname}"  onclick="_onClick(this)">
														<i  class="icon-angle-right"></i><!-- ${sub_subsysResource.funmenu} -->
														<span class="menu-text ellipsis"> ${sub_subsysResource.funname}</span>
														<!-- <b class="arrow icon-angle-right"></b> -->
													</a>
												</li>
										    </c:forEach>
										</ul>
									  </li>
							    </c:forEach>
							</ul>

						  </li>
					  </c:forEach>

					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content h100p">
					<div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
					    <script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						<ul class="nav nav-tabs pdl10 tab-size-bigger" id="navrightTop">
	                        <!-- <li class="active"><a href="#home" data-toggle="tab">首页</a></li> -->
	                    </ul>
                    </div>
					<div class="page-content">
						<!-- PAGE CONTENT BEGINS -->
						<div class="tab-content no-border" id="tabContent">
				        <!-- 	<div class="tab-pane active" id="home" style="min-height: 100%; margin-top: 5px;">
							</div> -->
                    	</div>
						<!-- PAGE CONTENT ENDS -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->


		</div><!-- /.main-container -->


		<script type="text/javascript">
        	function ifid(){
        	var iframes = document.getElementsByTagName("iframe");

			for(var i=0;i<iframes.length;i++){
				//alert("2");
				 if (iframes[i] && !window.opera)
                    {
                            //如果用户的浏览器是IE
                            var contentDocHeight = iframes[i].contentDocument.body.offsetHeight;
                            iframes[i].height = contentDocHeight;
                            //alert(iframes[i].height)
                        }
                        else if (iframes[i].Document && iframes[i].Document.body.scrollHeight) {
                            alert("4")
                            //其它浏览器
                            iframes[i].height = iframes[i].Document.body.scrollHeight;
                            alert(iframes[i].height);
                        }
                    }
			}
			// return iframes[i].height;
       // ifid();
		</script>

</body>
</html>

