<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位缴费管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpRecordSearchList.js?version=201609181813"></script>
</head>
<body>

	<div class="moduleWrapNobg">
		<div class="moduleTit">单位信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="corpForm" >
			    <form:hidden path="aab001" ></form:hidden>
		      	<input type="hidden" id="fdPaymentType" value="${fdPaymentType}" ></input>
				<div class="row">

					<label class="col-xs-12 col-sm-2" for="inputError">单位名称:</label>
					<div class="col-xs-12 col-sm-6">
						 <form:input  class="form-control" type="text"  path="aab004" readonly="true"></form:input>
					</div>

					<label class="col-xs-12 col-sm-2" for="inputError">工商登记执照号码:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="aab007" readonly="true"></form:input>
					</div>

					<label class="col-xs-12 col-sm-2" for="inputError">单位协议编号:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaNo" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">单位协议签订日期:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaCreatetime" readonly="true"></form:input>
					</div>

					<label class="col-xs-12 col-sm-2" for="inputError">单位联系人:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="aae004" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">联系人电话:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">传真:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">有效标记:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaStatusName" readonly="true"></form:input>
					</div>
				</div>
			</form:form>
		</div>
	</div>		
	<div class="moduleWrapNob">
		<div class="moduleTit">缴费记录</div>
		<div class="moduleCont">
			<div class="row">
				<div class="col-xs-12">
						<table id="paymentCorpRecordList"  class="datagridClass"  ></table>
						<div id="jqGridPager"></div>
				</div>
			</div>
		</div>
	</div>	
						
</body>		
</html>


