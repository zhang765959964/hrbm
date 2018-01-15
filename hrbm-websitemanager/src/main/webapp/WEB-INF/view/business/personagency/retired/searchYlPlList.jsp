<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>养老待遇申请</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/searchYlPlList.js?v=201612021759"></script>
<form:form  modelAttribute="yangLaoForm1" method="post" action="${ctx}/business/personagency/yanglao/saveRetiredPl.xf">
	<div class="row" >
		<form:hidden path="id" ></form:hidden>
		<form:hidden path="createrId" ></form:hidden>
		<form:hidden path="createrOrgId" ></form:hidden>
		<form:hidden path="retiredId" ></form:hidden>
		<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
		<div class="col-xs-9 input-group col-sm-2">
			<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
	    </div>
        <label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
		<div class="col-xs-9 col-sm-2">
			<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
		</div>
		<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
		<div class="col-xs-9 col-sm-2">
		    <form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
		</div>
	</div>	
	 		 
	<hr/>
	<div class="row">
		<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>应退休时间:</label>
		<div class="col-xs-9 input-group col-sm-2">
			<div class="input-group row required">
				<form:input  id="retiredDate1" class="form-control" type="text"  path="retiredDate"></form:input>
				<span class="input-group-addon">
					<i class="icon-calendar bigger-110"></i>
				</span>
			</div>
		</div>
		<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>缴费年月:</label>
		<div class="col-xs-9 input-group col-sm-2">
			<div class="input-group row required">
				<form:input  id="payDate1" class="form-control" type="text"  path="payDate" ></form:input>
				<span class="input-group-addon">
					<i class="icon-calendar bigger-110"></i>
				</span>
			</div>
		</div>
		<label class="col-xs-3 col-sm-2" for="inputError">退休申报状态:</label>
		<div class="col-xs-9 col-sm-2">
			<input  class="form-control"  type="text" value="待申报" readonly="true"></input>
		</div>
	</div>	
	
	<div class="bottomBtn">
	  	<div class="floatBtn">
	  		<button  id="btn2" role="button" class="btn btn-primary" type="submit"><i class="icon-save"></i>保存</button>
	  		<a href="javascript:void(0)" role="button" class="btn btn-success" onclick="printRetiredYl()"><i class="icon-barcode"></i>打印待遇申请表</a>
	   	</div>
	</div>
</form:form>


</html>	
	
	
	
