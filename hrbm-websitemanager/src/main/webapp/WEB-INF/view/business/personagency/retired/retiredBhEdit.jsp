<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>退休编号修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/retiredBhEdit.js?v=20170107"></script>
</head>
<body>
	<form:form modelAttribute="retiredDeclareForm" method="post" action="${ctx}/business/personagency/retired/declare/updateRetiredBh.xf">
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="moduleCont">
					<form:hidden path="id"></form:hidden>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="姓名">姓名:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="retiredDto.personName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="档案编号">档案编号:</label>
						<div class="col-xs-9 col-sm-input">
							<input class="form-control" type="text" value="${archiveCode}" readonly="true"></input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="身份证号">身份证号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="retiredDto.personCard" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="序号">序号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="xh" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="退休个人编码"><em>*</em>退休个人编码:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input class="form-control" type="text" path="retiredPeopleBm"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="申报备注"><em>*</em>申报备注:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input class="form-control" type="text" path="declareNote"></form:input>
						</div>
					</div>
				</div>
				<div class="bottomBtn">
					<div class="h50">&nbsp;</div>
					<div class="floatBtn">
						<button class="btn btn-primary" role="button" type="submit">
							<i class="icon-save"></i>保存
						</button>
						<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()">关闭</a>
					</div>
				</div>
			</div>
	</form:form>
</body>
</html>

