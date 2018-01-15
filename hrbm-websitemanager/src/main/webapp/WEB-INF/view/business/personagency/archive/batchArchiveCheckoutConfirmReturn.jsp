<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>借阅归还批量确认</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<script type="text/javascript" src="${ctx}/js/util/form.js"></script>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/batchArchiveCheckoutConfirmReturn.js?verson=20161212"></script>
	<style type="text/css">
		.ui-jqgrid tr.jqgrow td.highBg{
		    background: #00FF00 ;
	    }
	</style>
</head>
<body>
	<form id="searchForm2">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="Q_archiveCode_SL" id="returnArchiveCode" placeholder="请输入完整的档案编号" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="Q_aac002_SUPL" id="returnAac002" placeholder="请输入完整的身份证号" data-placement="bottom"/>
			</div>
			<div class="col-xs-9 col-sm-3">
				<a href="javascript:refresh2()" role="button" class="btn btn-yellow" ><i class="icon-refresh"></i>刷新</a>
				<a href="javascript:returnTop()" role="button" class="btn btn-success" ><i class="icon-hand-up"></i>置顶</a>
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
				<a href="javascript:doSearch2()" role="button"  class="btn btn-primary"><i class="icon-search"></i>查询</a>
				<a href="javascript:resetForm('searchForm2')" role="button" class="btn btn-info" >
		   			<i class="icon-repeat"></i>重置
		   		</a>
			</div>
		</div>
	</form>
	<div class="moduleWrapNob">
		<div class="moduleTit">结果列表</div>
		<div class="moduleCont">
			<div class="mgy10"></div>
			<div class="row">
				<div class="col-xs-12">
					<table id="archiveConfirmTwo" class="datagridClass"></table>
					<div id="jqGridPager2"></div>
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
				           <input  class="form-control" type="text"  value="${checkinConfirmDate }" readonly="true">
				      </div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
				<div class="col-xs-9 col-sm-2">
					<input  class="form-control" type="text"  value="${checkinConfirmOrgName }" readonly="true">
				 	</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办人姓名:</label>
				<div class="col-xs-9 col-sm-2">
					<input  class="form-control" type="text"  value="${checkinConfirmName }" readonly="true">
					</div>
				</div>
			</div>
		</div>
		<div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
		   		<a href="javascript:batchReturnComfirm()" role="button" class="btn btn-yellow" ><i class="icon-check"></i>批量归还确认</a>
	   		</div>
	   	</div>
   	</form:form>
</body>
</html>