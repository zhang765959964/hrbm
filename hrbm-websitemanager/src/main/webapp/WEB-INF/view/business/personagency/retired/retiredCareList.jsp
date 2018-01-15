<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>退休人员大病医保表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/retiredCareList.js?v=201701121" charset="utf-8"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">是否正式退休:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" value="是" readonly="true" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="beginretiredDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="endretiredDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休类别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_TYPE" name="retiredTypeId" valueField="code" hasDefault="0"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休个人编码起:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="retiredPeopleBmStart" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休个人编码止:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="retiredPeopleBmEnd" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否可申报:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="isCareDeclare" class="form-control">
									<option value="">--请选择--</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否已申报:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="isDeclare" class="form-control">
									<option value="">--请选择--</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否通过:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="isFlag" class="form-control">
									<option value="">--请选择--</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">大病医保所属区域:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_addre_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" id="personCard" name="Q_personCard_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" id="archiveCode" name="Q_archiveCode_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1">
									<i class="icon-zoom-in"></i>查询
								</a>
								<a href="#modal-form" role="button" onclick="resetFormNotHide('searchForm')" class="btn btn-info">
									<i class="icon-repeat"></i>重置
								</a>
								<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="addSearch()">
									<i class=" icon-plus-sign"></i>加入列表
								</a>
								<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="delSearch()">
									<i class="icon-minus-sign"></i>去除列表
								</a>
								<a href="javascript:void(0)" role="button" class="btn btn-danger" onclick="clearForm()">
									<i class="icon-trash"></i>清空列表
								</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="moduleWrapNob">
				<div class="moduleTit">
					<span>退休人员登记信息</span>
				</div>
				<div class="moduleCont">
					<div class="mgy10">
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
					</div>
				
					<div class="row">
						<div class="col-xs-12">
							<table id="retiredCareList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- 引入大病医保页面 -->
			<jsp:include page="searchRetiredCare.jsp"></jsp:include>

		</div>
	</div>
</body>
</html>


