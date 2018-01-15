<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<title></title>
<script>
   function closeItem(){
	   xfui.closeDialog();
   }
</script>
</head>
<body>
	<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
	<div class="div-line"></div>
	<br/>
	<div style="text-align: center;color: blue;">
		<h3>系统名称：郑州大学创业就业管理中心</h3>
		<h3>版本：1.0</h3> 
		<h3>技术支持：河南讯丰信息技术有限公司</h3> 
	</div>
</body>
</html>