<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>党组织关系管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/business/personagency/party/searchPartyList.js?v=201612051617"></script>
</head>
<div class="moduleWrapNobg">
	<div class="moduleTit">档案信息</div>
	<input type="hidden" name="personIds" value="${personId }" id="personIds" />
	<input type="hidden" name="partyIds" value="${partyIds }" id="partyIds" />
	<input type="hidden" value="${partyStatus}" id="partyStatus" name="partyStatus" />
	<input type="hidden" id="beginDate" />
	<input type="hidden" id="endDate" />
	<input type="hidden" id="flag" value="${flag}"/>
	<input type="hidden" id="delStatus" value="0" />
	<form:form modelAttribute="partyForm">
		<form:hidden class="form-control" path="createrName" />
		<form:hidden class="form-control" path="createrDate" />
		<form:hidden class="form-control" path="createrOrgName" />
	</form:form>
	<div class="moduleCont">
		<form:form modelAttribute="partyPersonForm">
			<div class="row">
				<div class="col-xs-12 col-sm-8 mgb0">
					<div class="row mgb0">
						<label class="col-xs-3 col-sm-3" for="inputError" title="公民身份证号">公民身份证号:</label>
						<div class="col-xs-9 col-sm-9">
							<form:input class="form-control" type="text" path="personCard" readonly="true"></form:input>
						</div>
					</div>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError" for="inputError">出生日期:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<form:input class="form-control" type="text" path="personCsrq" readonly="true"></form:input>
					<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
					</span>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input class="form-control" type="text" path="personName" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="personSex" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="phone" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<form:input class="form-control" type="text" id="dabh" path="archiveCode" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="archiveName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<form:input class="form-control" type="text" path="archiveBirthDate" readonly="true"></form:input>
					<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
					</span>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<form:input class="form-control" type="text" path="receiveDate" readonly="true"></form:input>
					<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
					</span>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">档案状态:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="archiveStatusName" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">接收人:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="archiveReceiveName" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="archiveTypeName" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">所属单位名称:</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:input class="form-control" type="text" path="corpName" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">手机号:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<form:input class="form-control" type="text" path="mobilePhone" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">政治面貌:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<form:input class="form-control" type="text" path="affilName" readonly="true"></form:input>
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="tabable">
	<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
		<li class="active">
			<a data-toggle="tab" href="#perBase">党组织关系转入转出</a>
		</li>
		<li>
			<a data-toggle="tab" href="#perEdu">党费交纳</a>
		</li>
	</ul>
	<div class="tab-content">
		<div id="perBase" class="tab-pane in active">
			<div class="moduleWrapNob">
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:addParty()" role="button" class="btn btn-primary">
									<i id="into" class="icon-edit"></i>转入
						</a>
						<a href="javascript:addOutParty()" role="button" class="btn btn-success">
								<i class="icon-external-link"></i>转出
						</a>
						<a href="javascript:delParty()" role="button" class="btn btn-danger">
							<i class="icon-trash"></i>删除
						</a>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="partyList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="perEdu" class="tab-pane">
			<!-- 结果列表1 -->
			<div class="moduleWrapNob">
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:addPartyPay()" role="button" class="btn btn-primary">
							<i class="icon-plus"></i>添加
						</a>
						<a href="javascript:delPartyPay(${personId})" role="button" class="btn btn-danger">
							<i class="icon-trash"></i>删除
						</a>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="partyPayList" class="datagridClass"></table>
								<div id="jqGridPager1"></div>
							</div>
						</div>
					</div>
					<div class="h60">&nbsp;</div>

				</div>
			</div>
		</div>
	</div>

</div>
</html>



