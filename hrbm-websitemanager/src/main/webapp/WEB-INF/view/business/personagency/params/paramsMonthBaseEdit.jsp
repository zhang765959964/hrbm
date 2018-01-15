<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 月缴费基数</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsMonthBaseEdit.js?version=20161207"></script>
</head>
<body>
	<form:form modelAttribute="paramsMonthBaseForm" method="post" action="${ctx}/business/personagency/params/paramsMonthBase/save.xf">
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="moduleWrapNob change-bg-iframe">
					<div class="moduleCont">
						<form:hidden path="pkId"></form:hidden>
						<form:hidden path="fkCreaterOrgId"></form:hidden>
						<form:hidden path="fkCreaterId"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>月缴费基数:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdMonthBase"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>参数描述:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdParmsDesc"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>备注:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdDesc"></form:input>
							</div>
						</div>
						<div class="row">

							<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input class="form-control" type="text" path="fdCreaterName" readonly="true"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-input">
								<form:input class="form-control" type="text" path="fdCreaterDate" readonly="true"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input class="form-control" type="text" path="fdCreaterOrgName" readonly="true"></form:input>
							</div>

						</div>

					</div>
				</div>
			</div>
			<div class="h60">&nbsp;</div>
			<div class="floatBtn">
				<button type="submit" class="btn btn-primary">
					<i class="icon-save"></i>保存
				</button>
				<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()">
					<i class="icon-remove"></i>关闭
				</a>

			</div>

		</div>
	</form:form>
</body>
</html>
