<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>代理综合查询</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	</head>
<body>
<script type="text/javascript" src="${ctx}/js/business/personagency/agent/query/zhcxList.js?v=20170213"></script>
	<input type="hidden"  id="personIds" value="0"/>
	<div class="container-fluid">
		<div class="row">
			<!-- 查询条件 -->
			<jsp:include page="zhcx/zhcxWhere.jsp"></jsp:include>
		</div>
		<!-- tab选项卡 -->
		<jsp:include page="zhcx/zhcxTab.jsp"></jsp:include>
	</div>
</body>
</html>