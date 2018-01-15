<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>社保补贴管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/subsidyCommon.js"></script>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/bankSocialImportList.js"></script>
</head>

<form:form modelAttribute="socialCorpDeclareForm" method="post" action="${ctx}/business/personagency/subsidy/socialCorpDeclare/save.xf">
	<form:hidden path="id"></form:hidden>
	<form:hidden path="aab001"></form:hidden>
	<form:hidden path="createrId"></form:hidden>
	<form:hidden path="createrOrgId"></form:hidden>
	<div class="moduleWrapNobg">
		<div class="moduleTit">单位基本信息</div>

		<div class="moduleCont">

			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
				<div class="col-xs-9 col-sm-2  ">
					<form:input class="form-control" type="text" readonly="true" path="aab004"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">单位性质:</label>
				<div class="col-xs-9 col-sm-2  ">
					<xf:select textField="name" tableName="TAB_UNITNATURE" selectClass="form-control" disabled="true" name="aab019" value="${socialCorpDeclareForm.aab019}" valueField="code" hasDefault="0"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">填报时间:</label>
				<div class="col-xs-9 col-sm-2  ">
					<form:input class="form-control" type="text" readonly="true" path="fillDate"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">提交批次：</label>
				<div class="col-xs-9 col-sm-2  ">
					<xf:select textField="BATCH_NAME" tableName="RSDA_BS_SOCIAL_BATCH" selectClass="form-control" disabled="true" name="batchId" id="batchId" value="${socialCorpDeclareForm.batchId}" valueField="id" hasDefault="0"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
				<div class="col-xs-9 col-sm-2  ">
					<form:input class="form-control" type="text" readonly="true" path="aae005"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">法人代表:</label>
				<div class="col-xs-9 col-sm-2  ">
					<form:input class="form-control" type="text" readonly="true" path="aab013"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">负责人：</label>
				<div class="col-xs-9 col-sm-2  ">
					<form:input class="form-control" type="text" readonly="true" path="aae004"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">详细地址:</label>
				<div class="col-xs-9 col-sm-6  ">
					<form:input class="form-control" type="text" readonly="true" path="aae006"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">开户银行:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" readonly="true" path="bankName"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">银行卡号:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" readonly="true" path="bankCardNo"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">银行账户名:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" readonly="true" path="bankOwnerName"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">合计补贴金额:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" readonly="true" path="totalSubsidyAmount"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">审批情况:</label>
				<div class="col-xs-9 col-sm-6 ">
					<form:input class="form-control" type="text" path="approvalDesc" readonly="true"></form:input>
				</div>

			</div>
		</div>
	</div>

</form:form>
<!-- 结果列表 -->
<div class="moduleWrapNob">
	<div class="moduleTit">查询结果</div>
	<div class="moduleCont">
		<div class="mgy10">
			<a href="javascript:void(0)" id="imp" role="button" class="btn  btn-success">
				<i class="icon-edit"></i>导入
			</a>
			<div class="keep-open btn-group" title="Columns">
				<a href="javascript:void(0)" id="exp" role="button" class="btn btn-purple dropdown-toggle" data-toggle="dropdown">
					<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<table id="socialSubsidyList"></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
	</div>
</div>
