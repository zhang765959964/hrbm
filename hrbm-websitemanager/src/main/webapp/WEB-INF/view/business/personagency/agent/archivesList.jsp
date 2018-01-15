<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>人员档案表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<script type="text/javascript" src="${ctx}/js/business/personagency/agent/archivesList.js?v=20161226"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="query/zhcx/zhcxWhere.jsp"></jsp:include>
			<!-- 查询条件结束 -->
			<div class="moduleWrapNob">
				<div class="moduleTit">结果列表</div>
				<div class="mgy10">
					<a href="javascript:void(0)"  onclick="" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
				</div>
				<div class="row">
					<div class="col-xs-12">
							<table id="archivesList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>