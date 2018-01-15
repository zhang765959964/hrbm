<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
		<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" media="all" href="${ctx}/js/lib/bootstrap-datetime-range/daterangepicker.css" />
		<link type="text/css" href="${ctx}/js/lib/jquery-ui-bootstrap/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-table.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/perfect-scrollbar.min.css" />
		<link rel="stylesheet" href="${ctx}/js/lib/jqgrid/css/ui.jqgrid-bootstrap.css" type="text/css">
		<link rel="stylesheet" href="${ctx}/js/lib/jqgrid/css/ui.jqgrid-bootstrap-ui.css" type="text/css">
		<link rel="stylesheet" href="${ctx}/styles/default/css/index.css?v=2688869666335" type="text/css">
		<link rel="stylesheet" href="${ctx}/styles/default/css/rsda.css?v=20161214" type="text/css">
		<link type="text/css"  href="${ctx}/js/lib/multiple-select/multiple-select.css" rel="stylesheet" /><!-- select with checkbox and search filter-->
		<link rel="stylesheet" href="${ctx}/styles/default/css/plugin-change.css" type="text/css">
		<script src="${ctx}/assets/js/1.10.2/jquery.min.js"></script>
		<!--[if lt IE 9]>
		<script src="${ctx}/assets/js/html5shiv.js"></script>
		<script src="${ctx}/assets/js/respond.min.js"></script>
		<![endif]-->

		<!--[if IE]>
		<script src="${ctx}/assets/js/1.10.2/jquery.min.js"></script>
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
<%-- 		<script src="${ctx}/assets/js/ace-elements.min.js"></script> --%>
<%-- 		<script src="${ctx}/assets/js/ace.min.js"></script> --%>
		<script src="${ctx}/assets/js/bootstrap.min.js"></script>
		<script src="${ctx}/js/lib/jquery-ui-bootstrap/jquery-ui-1.10.0.custom.min.js"></script>
		<script src="${ctx}/assets/js/bootbox.min.js"></script>
		<script src="${ctx}/assets/js/perfect-scrollbar.min.js"></script>
		<script type="text/javascript" src='${ctx}/js/ui/xfui.js?version=201609231064'></script>
		<script src="${ctx}/assets/js/bootstrap-table.min.js"></script>
		<script src="${ctx}/assets/js/bootstrap-table-zh-CN.js"></script>
		<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css" type="text/css">
		<script src="${ctx}/js/lib/bootstrap-validator/js/bootstrapValidator.js?version=20161201011"></script>
		<script src="${ctx}/js/lib/bootstrap-validator/js/language/zh_CN.js"></script>
		<script src="${ctx}/js/lib/jqgrid/js/i18n/grid.locale-cn.js"></script>
		<script src="${ctx}/js/lib/jqgrid/js/jquery.jqGrid.min.js"></script>
		<!-- <script src="${ctx}/js/lib/jqgrid/js/jquery.jqGrid.js"></script> -->
		<script type="text/javascript" src='${ctx}/js/util/validateUtil.js?version=20161201001'></script>
		<script type="text/javascript" src='${ctx}/js/util/jquery.unIdUtil.js'></script>
		<script type="text/javascript" src='${ctx}/js/util/jquery.serializeJson.js'></script>
		<script type="text/javascript" src='${ctx}/js/util/jQuery.Hz2Py-min.js'></script>
		<script type="text/javascript" src='${ctx}/js/util/jquery.pinyinAleph.js'></script>
		<script type="text/javascript" src='${ctx}/js/util/util.js?verson=201612200000200000102'></script>
		<script type="text/javascript" src='${ctx}/js/util/commonUtil.js?version=201709231018'></script>
		<script type="text/javascript" src="${ctx}/js/util/dateFormatOrParse.js"></script>
		<script type="text/javascript" src="${ctx}/js/lib/bootstrap-datetime-range/moment.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/lib/bootstrap-datetime-range/daterangepicker.js?version=201609231007"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.daterangepicker.js?version=201609231007"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selectuser.js?version=201609231005"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selectcorp.js?version=201609231006"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selectcommon.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/data.exp.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/data.imp.js?version=201609231006"></script>
		<script type="text/javascript" src="${ctx}/js/util/form.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selcity.js"></script>
		<script type="text/javascript" src="${ctx}/js/lib/multiple-select/multiple-select.js?verson=20161222000000"></script>
<style>
.background {
	display: block;
	width: 100%;
	height: 100%;
	opacity: 0.4;
	filter: alpha(opacity = 40);
	background: while;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 2000;
}

.progressBar {
	border: solid 2px #86A5AD;
/* 	background: white url(progressBar_m.gif) no-repeat 10px 10px; */
}

.progressBar {
	display: block;
	width: 148px;
	height: 40px;
	position: fixed;
	top: 200px;
	left: 50%;
	margin-left: -74px;
	margin-top: -14px;
	padding: 10px 10px 10px 50px;
	text-align: left;
	line-height: 27px;
	font-weight: bold;
	position: absolute;
	z-index: 2001;
}
</style>
<div id="background" class="background" style="display: none; "></div> 
<div id="progressBar" class="progressBar" style="display: none; ">请稍等...</div> 
		
<script>
	var CTX = "${ctx}";
	var fileDirectory = "${fileDirectory}";
	$(document).ajaxComplete(function(event, xhr, settings) {

		var responseStr = xhr.responseText;
		if (responseStr.indexOf("超时") != -1) {
			window.location.href = window.location.href
		}
	});
	
	
	
</script>

