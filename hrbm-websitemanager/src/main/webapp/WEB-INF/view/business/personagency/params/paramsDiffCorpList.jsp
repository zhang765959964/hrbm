<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>困难企业管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script src="${ctx}/js/business/personagency/params/paramsDiffCorpList.js?v=20161226"></script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="row">
				<div class="moduleWrapNobg">
					<div class="moduleTit">查询条件</div>
					<div class="moduleCont">
						<form id="searchForm">
							<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">所属区域:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_fdCorpAddre_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_searchValue_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 mgb20 tar pdx20">
									<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1">
										<i class="icon-search"></i>查询
									</a>
									<a href="#modal-form" role="button" class="btn btn-info" onclick="resetForm('searchForm')">
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
							<c:if test="${type == 0 }">
								<a href="javascript:void(0)" onclick="addParamsDiffCorp()" role="button" class="btn btn-primary" data-toggle="modal">
									<i class="icon-plus"></i>添加
								</a>
								<a href="javascript:void(0)" onclick="editParamsDiffCorp()" role="button" class="btn btn-info" data-toggle="modal">
									<i class="icon-pencil"></i>修改
								</a>
								<a href="javascript:void(0)" onclick="delParamsDiffCorp()" role="button" class="btn btn-danger">
									<i class="icon-trash"></i>删除
								</a>
							</c:if>

						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="paramsDiffCorpList" class="datagridClass"></table>
								<div id="jqGridPager"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


