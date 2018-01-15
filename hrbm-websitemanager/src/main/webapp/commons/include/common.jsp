<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<%-- 	   <link rel="stylesheet" href="${ctx}/assets/css/colorpicker.css" /> --%>
<%-- 	   <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" /> --%>
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
		<script src="${ctx}/assets/js/bootstrap-table.min.js"></script>
		<script src="${ctx}/assets/js/bootstrap-table-zh-CN.js"></script>
		<script src="${ctx}/js/lib/bootstrap3-editable/js/bootstrap-editable.min.js"></script>		
		<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css" type="text/css">
		<script src="${ctx}/js/lib/bootstrap-validator/js/bootstrapValidator.js"></script>
		<script src="${ctx}/js/lib/bootstrap-validator/js/language/zh_CN.js"></script>
		<script type="text/javascript" src='${ctx}/js/util/jquery.serializeJson.js'></script>
		<script type="text/javascript" src='${ctx}/js/util/jQuery.Hz2Py-min.js'></script>	
		<script type="text/javascript" src='${ctx}/js/util/jquery.pinyinAleph.js'></script>
		<script type="text/javascript" src='${ctx}/js/util/util.js'></script>	
		<script type="text/javascript" src="${ctx}/js/util/dateFormatOrParse.js"></script>	
		<script type="text/javascript" src="${ctx}/js/lib/bootstrap-datetime-range/moment.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/lib/bootstrap-datetime-range/daterangepicker.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.daterangepicker.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selectuser.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selectcorp.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.selectcommon.js"></script>
<script>
	var CTX = "${ctx}";
	var fileDirectory = "${fileDirectory}";
	$(document).ajaxSuccess(function(event, xhr, settings) {
		var responseStr = xhr.responseText;
		if (responseStr.indexOf("超时") != -1) {
			window.location.href = window.location.href
		}
	});
</script>

