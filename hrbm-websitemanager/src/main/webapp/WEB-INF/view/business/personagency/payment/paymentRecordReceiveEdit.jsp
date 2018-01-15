<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRecordReceiveEdit.js?version=2016091818172"></script>
<title>缴费记录管理</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleTit">存档信息</div>
			<div class="moduleCont">
				<form:form modelAttribute="archivesPersonForm" method="post" action="">
					<input type="hidden" id="recordId" value="${recordId}" />
					<input type="hidden" id="opType" value="${opType}" />
					<div class="row">
						<label class="col-xs-12 col-sm-label" for="inputError">身份证号码:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="AAC002" readonly="true"></form:input>
						</div>

						<label class="col-xs-12 col-sm-label" for="inputError">姓名:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="AAC003" readonly="true"></form:input>
						</div>

						<label class="col-xs-12 col-sm-label" for="inputError">联系电话:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="expPersonPhone" readonly="true"></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-12 col-sm-label" for="inputError">性别:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="genderName" readonly="true"></form:input>
						</div>
						<label class="col-xs-12 col-sm-label" for="inputError">出生日期:</label>
						<div class="col-xs-12 input-group col-sm-input" style="padding-left: 15px">
							<form:input class="form-control" type="text" path="AAC006" readonly="true"></form:input>
							<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						<label class="col-xs-12 col-sm-label" for="inputError">档案出生日期:</label>
						<div class="col-xs-12 input-group col-sm-input" style="padding-left: 15px">
							<form:input class="form-control" type="text" path="archiveBirthDate" readonly="true"></form:input>
							<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-12 col-sm-label" for="inputError">档案编号:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="archiveCode" readonly="true"></form:input>
						</div>

						<label class="col-xs-12 col-sm-label" for="inputError">档案姓名:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="archiveName" readonly="true"></form:input>
						</div>

						<label class="col-xs-12 col-sm-label" for="inputError">档案接收人:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="archiveReceiveName" readonly="true"></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-12 col-sm-label" for="inputError">档案转入日期:</label>
						<div class="col-xs-12 input-group col-sm-input" style="padding-left: 15px">
							<form:input class="form-control" type="text" path="receiveDate" readonly="true"></form:input>
							<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						<label class="col-xs-12 col-sm-label" for="inputError">档案状态:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="archiveStatusName" readonly="true"></form:input>
						</div>

						<label class="col-xs-12 col-sm-label" for="inputError">手机号:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="AAE005" readonly="true"></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-12 col-sm-label" for="inputError">存档类型:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="archiveTypeName" readonly="true"></form:input>
						</div>

						<label class="col-xs-12 col-sm-label" for="inputError">所属单位名称:</label>
						<div class="col-xs-12 col-sm-input">
							<form:input class="form-control" type="text" path="expEntrustCompany" readonly="true"></form:input>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="moduleWrapNob">
			<div class="moduleTit">缴费明细</div>
			<div class="moduleCont">
				<c:if test="${opType eq 'edit'}">
					<div class="mgy10">
						<a href="javascript:void(0)" id="payment" class="btn btn-primary">
							<i class="icon-save"></i>确认缴费
						</a>
						<a href="javascript:void(0)" id="closeDialog" class="btn btn-info">
							<i class="icon-remove"></i>关闭
						</a>
					</div>
				</c:if>
				<div class="row">
					<div class="col-xs-12">
						<table id="paymentRecordList" class="datagridClass"></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${opType eq 'view'}">
		<div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="xfui.closeDialog()"><i class="icon-remove"></i>关闭</a>
	   		
	   	</div>
	   	</c:if>
	</div>
</body>
</html>


