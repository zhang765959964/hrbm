<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>退休人员查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/searchRetiredCardList.js?20161226"></script>
</head>
<body>
	<form:form modelAttribute="retiredCardForm" method="post" action="${ctx}/business/personagency/retired/card/save.xf">
		<div class="moduleWrapNobg">
			<div class="moduleCont">
				<form:hidden path="id"></form:hidden>
				<form:hidden path="createrId"></form:hidden>
				<form:hidden path="createrOrgId"></form:hidden>
				<form:hidden path="retiredDeclareId"></form:hidden>
				<form:hidden path="retiredDeclareStatus"></form:hidden>
				<form:hidden path="retiredStatus"></form:hidden>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">
						<em>*</em>退休证领取时间:
					</label>
					<div class="col-xs-9 input-group col-sm-2">
						<div class="input-group row required">
							<form:input class="form-control" type="text" path="retiredCardDate"></form:input>
							<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">
						<em>*</em>退休证领取人:
					</label>
					<div class="col-xs-9 col-sm-2 required ">
						<form:input class="form-control" type="text" path="retiredCardName"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">
						<em>*</em>退休证号:
					</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input class="form-control" type="text" path="retiredCardCode"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
						<form:input class="form-control" type="text" path="createrDate" readonly="true"></form:input>
						<span class="input-group-addon"><i class="icon-calendar bigger-110"></i> </span>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input class="form-control" type="text" path="createrOrgName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input class="form-control" type="text" path="createrName" readonly="true"></form:input>
					</div>
				</div>
			</div>
		</div>
		<div class="bottomBtn">
			<div class="floatBtn">
				<!--<a href="javascript:void(0)" role="button" class="btn btn-primary"  onclick="submitForm()">领取退休证</a>  -->
				<button role="button" class="btn btn-primary" type="submit">
					<i class="icon-ok"></i>领取退休证
				</button>
			</div>
		</div>
	</form:form>
</body>
</html>
