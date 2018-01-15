<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>借阅归还批量确认</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/batchArchiveCheckoutConfirm.js"></script>
	<style type="text/css">
		.ui-jqgrid tr.jqgrow td.highBg{
		    background: #00FF00 ;
	    }
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="tabable row">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#batchArchivesCCEdu">档案批量借阅确认</a></li>
				<li><a data-toggle="tab" href="#batchArchivesReturnEdu" onclick="confirmTwoDiv()">档案批量归还确认</a></li>
			</ul>
			<div class="tab-content">
				<div id="batchArchivesCCEdu" class="tab-pane in active">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" id="checkoutArchiveCode" placeholder="请输入完整的档案编号" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" id="checkoutAaac002" placeholder="请输入完整的身份证号" data-placement="bottom"/>
							</div>
							<div class="col-xs-9 col-sm-3">
								<a href="javascript:void(0)" role="button" class="btn btn-yellow" onclick="refresh()"><i class="icon-refresh"></i>刷新</a>
								<a href="javascript:void(0)" role="button" class="btn btn-success" onclick="confirmTop()"><i class="icon-hand-up"></i>置顶</a>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">批次查询:</label>
							<div class="col-xs-9 col-sm-6">
								<select class="form-control" name="Q_batchName_SL">
									<option value="" selected="selected">--请选择--</option>
									<c:forEach var="list" items="${batchList }">
										<option value="${list.batchName }">${list.batchName }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-xs-9 col-sm-3">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary"><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="$('#reset').click()">
						   			<i class="icon-repeat"></i>重置
						   		</a>
						   		<input id="reset" hidden="hidden" type="reset">
							</div>
						</div>
					</form>
					<div class="moduleWrapNob">
						<div class="moduleTit">结果列表</div>
						<div class="moduleCont">
							<div class="mgy10"></div>
							<div class="row">
								<div class="col-xs-12">
									<table id="archiveConfirmOne" class="datagridClass"></table>
									<div id="jqGridPager"></div>
								</div>
							</div>
						</div>
					</div>
					<form:form modelAttribute="" method="post" action="">
						<div class="moduleWrapNobg">
							<div class="moduleTit">经办信息</div>
							<div class="moduleCont">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
									<div class="col-xs-9 input-group col-sm-2">
							             <input  class="form-control" type="text"  value="${checkoutConfirmDate}" readonly="true">
							        </div>
									<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
									<div class="col-xs-9 col-sm-2">
										<input  class="form-control" type="text"  value="${checkoutConfirmOrgName}" readonly="true">
								  	</div>
									<label class="col-xs-3 col-sm-2" for="inputError">经办人姓名:</label>
									<div class="col-xs-9 col-sm-2">
										<input  class="form-control" type="text"  value="${checkoutConfirmName}" readonly="true">
									</div>
								</div>
							</div>
						</div>
						<div class="bottomBtn">
					   		<div class="h50">&nbsp;</div>
					   		<div class="floatBtn">
						   		<a href="javascript:void(0)" role="button" class="btn btn-yellow" onclick="batchComfirmCheckout()"><i class="icon-check"></i>批量借阅确认</a>
					   		</div>
					   	</div>
				   	</form:form>
				</div>
				<div id="batchArchivesReturnEdu" class="tab-pane"></div>
			</div>
		</div>
	</div>
</body>
</html>