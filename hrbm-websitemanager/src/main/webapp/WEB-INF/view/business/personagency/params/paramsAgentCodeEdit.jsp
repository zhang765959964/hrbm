<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 劳动代理代码维护</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsAgentCodeEdit.js"></script>
</head>
<body>
	<form:form modelAttribute="paramsAgentCodeForm" method="post" action="${ctx}/business/personagency/params/paramsAgentCode/save.xf">
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="moduleWrapNob change-bg-iframe">
					<div class="moduleCont">
						<form:hidden path="pkId"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>代码类别:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdTypeCode"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>类别名称:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdTypeName"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>代码名称:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdCodeName"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>代码值:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdCodeValue"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError">拼音码:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input class="form-control" type="text" path="fdPinyinCode"></form:input>
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
