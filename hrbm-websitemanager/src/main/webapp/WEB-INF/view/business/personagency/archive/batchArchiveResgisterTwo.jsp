<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案批量归还登记</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<script type="text/javascript" src="${ctx}/js/util/form.js"></script>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/batchArchiveResgisterTwo.js"></script>
</head>
	<form id="searchForm3">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="archiveCode" id="archiveCodeTwo" placeholder="请输入完整的档案编号" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="aac002" id="aac002Two" placeholder="请输入完整的身份证号" data-placement="bottom"/>
			</div>
			<div class="col-xs-9 col-sm-3">
				<a  role="button" class="btn btn-primary" href="javascript:addSearch2()"><i class=" icon-plus-sign"></i>加入查询</a>
				<a  role="button" class="btn btn-info"    href="javascript:subtractSearch2()"><i class="icon-minus-sign"></i>去除查询</a>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">批次查询:</label>
			<div class="col-xs-9 col-sm-6">
				<select class="form-control" id="batchNameId">
					<option value="">--请选择--</option>
					<c:forEach var="list" items="${batchList }">
						<option value="${list.batchName }">${list.batchName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-xs-9 col-sm-3">
				<a  role="button" class="btn btn-yellow" href="javascript:batchSearch()"><i class="icon-list-ol"></i>批次查询</a>
				<a  role="button" class="btn btn-danger" href="javascript:clearJqGrid2()"><i class="icon-trash"></i>清空列表</a>
			</div>
		</div>
	</form>
	<div class="moduleWrapNob">
		<div class="moduleTit">查询结果</div>
		<div class="moduleCont">
			<div class="mgy10"></div>
			<div class="row">
				<div class="col-xs-12">
					<table id="archiveResgisterTwo" class="datagridClass"></table>
					<div id="jqGridPager3"></div>
				</div>
			</div>
		</div>
	</div>	
	<div class="row">
		<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
		<div class="col-xs-9 input-group col-sm-2">
             	<input  class="form-control" type="text"  value="${checkinDate }" readonly="true">
           </div>
		<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
		<div class="col-xs-9 col-sm-2">
			<input  class="form-control" type="text"  value="${checkinOrgName }" readonly="true">
	  	</div>
		<label class="col-xs-3 col-sm-2" for="inputError">经办人姓名:</label>
		<div class="col-xs-9 col-sm-2">
			<input  class="form-control" type="text"  value="${checkinName }" readonly="true">
		</div>
	</div>
	<div class="bottomBtn">
   		<div class="h50">&nbsp;</div>
   		<div class="floatBtn">
	   		<a  role="button" class="btn btn-success" href="javascript:batchReturnResgister()"><i class="icon-edit"></i>批量归还登记</a>
   		</div>
   	</div>
</html>