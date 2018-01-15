<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>参保文件管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsInsuredFileList.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">文件名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_fdFileName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">文件编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_fdFileNumber_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1">
									<i class="icon-search"></i>查询
								</a>
								<a href="#modal-form" role="button" onclick="resetForm('searchForm')" class="btn btn-info">
									<i class="icon-repeat"></i>重置
								</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="moduleWrapNob">
				<div class="moduleTit">查询结果</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addParamsInsuredFile()" role="button" class="btn btn-primary" data-toggle="modal">
							<i class="icon-plus"></i>添加
						</a>
						<a href="javascript:void(0)" onclick="editParamsInsuredFile()" role="button" class="btn btn-info" data-toggle="modal">
							<i class="icon-pencil"></i>修改
						</a>
						<a href="javascript:void(0)" onclick="delParamsInsuredFile()" role="button" class="btn btn-danger">
							<i class="icon-trash"></i>删除
						</a>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="paramsInsuredFileList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


