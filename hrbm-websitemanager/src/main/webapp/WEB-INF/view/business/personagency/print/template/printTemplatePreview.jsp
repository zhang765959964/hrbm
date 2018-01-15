<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>${title }</title>
<link rel="shortcut icon" href="${ctx}/styles/default/images/favicon.ico"/>
<link rel="stylesheet" href="${ctx}/styles/business/personagency/print/report.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<style type="text/css" media=print>
.noprint {
	display: none
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
<object ID='wb' WIDTH=0 HEIGHT=0 CLASSID='CLSID:8856F961-340A-11D0-A96B-00C04FD705A2'></object> 
    <!--begin-->
	<a href="javascript:wb.ExecWB(6,1); " role="button" id="closeItem"
		class="btn btn-info noprint"><i class="icon-print"></i>打印</a>
		<a href="javascript:wb.ExecWB(8,1); " role="button" id="closeItem"
		class="btn btn-info noprint"><i class="icon-print"></i>打印设置</a>
		<a href="javascript:wb.ExecWB(7,1); " role="button" id="closeItem"
		class="btn btn-info noprint"><i class="icon-print"></i>打印预览</a>
	${html}
<!--end-->
</body>
</html>
