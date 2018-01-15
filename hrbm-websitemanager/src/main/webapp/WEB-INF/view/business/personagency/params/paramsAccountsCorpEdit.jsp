<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 账号与市场关联维护</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsAccountsCorpEdit.js"></script>
</head>
<body>
	<form:form modelAttribute="paramsAccountsCorpForm" method="post" action="${ctx}/business/personagency/params/paramsAccountsCorp/save.xf">
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="moduleWrapNob change-bg-iframe">
					<%-- 				<div class="moduleTit">账号与市场关联维护</div> --%>
					<div class="moduleCont">

						<form:hidden path="pkId"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="用户帐号"> 
								<em>*</em>用户帐号:
							</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdUserAccount"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError" title="用户名称">
								<em>*</em>用户名称:
							</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdUserName"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError" title="用户所在机构">
								<em>*</em>用户所在机构:
							</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdDeptName"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="市场位置名称">
								<em>*</em>市场位置名称:
							</label>
							<div class="col-xs-9 col-sm-input required">
								<xf:select tableName="CD20" textField="ACD202" valueField="ACD200" value="${paramsAccountsCorpForm.fdOrgId}" name="fdOrgId"></xf:select>
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
				<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="closeItem()">
					<i class="icon-remove"></i>关闭
				</a>

			</div>

		</div>
	</form:form>
</body>
</html>
