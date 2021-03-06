<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费标准管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsPaymentList.js"></script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="row">
				<div class="moduleWrapNob">
					<div class="moduleTit">缴费标准维护</div>
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addParamsPayment()" role="button" class="btn btn-primary" data-toggle="modal">
								<i class="icon-plus"></i>添加
							</a>
							<a href="javascript:void(0)" onclick="editParamsPayment()" role="button" class="btn btn-info" data-toggle="modal">
								<i class="icon-pencil"></i>修改
							</a>
							<a href="javascript:void(0)" onclick="delParamsPayment()" role="button" class="btn btn-danger">
								<i class="icon-trash"></i>删除
							</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="paramsPaymentList" class="datagridClass"></table>
								<div id="jqGridPager"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


