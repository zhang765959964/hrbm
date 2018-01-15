<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>存档费缴费管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpRecordReceiveEdit.js?version=201609181815"></script>

</head>
<body><div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form:form modelAttribute="paymentCorpRecord" >
					    <form:hidden path="pkId"  ></form:hidden>
						<div class="row">
							<label class="col-xs-12 col-sm-label" for="inputError">单位名称:</label>
							<div class="col-xs-12 col-sm-two-col">
								 <form:input  class="form-control" type="text"  path="aab004" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">单位协议编号:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="uaNo" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">单位联系人:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="aae004" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">联系人电话:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">传真:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">缴费日期:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="fdPaymentDate" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">缴费金额:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="fdPaymentAmount" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">缴费标记:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="fdPaymentStatus" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="receiveAllPayment()" class="btn btn-primary btn-border1" ><i class="icon-ok"></i>确定缴费</a>
								<a href="#" role="button" onclick="doSearch()" class="btn btn-success btn-border1" ><i class="icon-print"></i>直接打印</a>
								<a href="#" role="button" onclick="doSearch()" class="btn btn-yellow btn-border1" ><i class="icon-user"></i>个人打印发票</a>
								<a href="javascript:void(0)" onclick="xfui.closeDialog();" class="btn btn-info"><i class="icon-remove"></i>关闭</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>		
			<div class="moduleWrapNob change-bg-iframe">
				<div class="moduleTit">缴费记录</div>
				<div class="moduleCont">
					<div class="row">
						<div class="col-xs-12 col-sm-12">
							<table id="paymentRecordList"  class="datagridClass"  ></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
	</div>
</div>						
</body>		
</html>


