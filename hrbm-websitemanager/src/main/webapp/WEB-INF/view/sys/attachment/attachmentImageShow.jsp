<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<%@include file="/commons/include/common.jsp" %>

</head>

<body>
<div >
	<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="xfui.closeTab()" iconCls="icon-clear">关闭</a>
	</div>
	<hr/>
	<div class="">
		<div class="panel-detail" style="text-align:center; margin-left: auto;margin-right: auto;width: auto;height: auto">
			<img alt="${title}" style="width: auto;height: auto" src="${ctx}/sys/attachment/attachment/getImageById.xf?filePath=${caoa02}" >
		</div>
	</div>
</div>
</body>
</html>