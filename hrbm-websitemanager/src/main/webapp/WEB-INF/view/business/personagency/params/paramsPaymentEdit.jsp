<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 缴费标准</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsPaymentEdit.js"></script>
</head>
<body>
	<form:form modelAttribute="paramsPaymentForm" method="post" action="${ctx}/business/personagency/params/paramsPayment/save.xf">
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="moduleWrapNob change-bg-iframe">
					<%-- 		<div class="moduleTit">缴费标准</div> --%>
					<div class="moduleCont">
						<form:hidden path="pkId"></form:hidden>
						<form:hidden path="fkCreaterId"></form:hidden>
						<form:hidden path="fkCreaterOrgId"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="标准执行开始年月">
								<em>*</em>标准执行开始年月:
							</label>
							<div class="col-xs-9 input-group  col-sm-input">
								<div class="input-group row required">
									<form:input class="form-control date" format="YYYY-MM" autoUpdateInput="false" type="text" path="fdStartdate" readonly="true"></form:input>
									<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError" title="标准执行结束年月">
								<em>*</em>标准执行结束年月:
							</label>
							<div class="col-xs-9 input-group col-sm-input">
								<div class="input-group row required">
									<form:input class="form-control date" format="YYYY-MM" autoUpdateInput="false" type="text" path="fdEnddate" readonly="true"></form:input>
									<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError" title="优惠标准">
								<em>*</em>优惠标准:
							</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdStandard"></form:input>
							</div>
						</div>

						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="持优惠证标准">
								<em>*</em>持优惠证标准:
							</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdDiscountStandard"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="经办人">经办人:</label>
							<div class="col-xs-9 col-sm-input ">
								<form:input class="form-control" type="text" path="fdCreaterName" readonly="true"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError" title="经办日期">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-input">
								<form:input class="form-control" type="text" path="fdCreaterDate" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError" title="经办机构">经办机构:</label>
							<div class="col-xs-9 col-sm-input ">
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
				<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="closeItem()">
					<i class="icon-remove"></i>关闭
				</a>
				<!-- 	   		<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">登记新户</a> -->
				<!-- 	   		<a href="javascript:void(0)" role="button" class="btn btn-success">打印条码标签</a> -->

			</div>

		</div>
	</form:form>
</body>
</html>
