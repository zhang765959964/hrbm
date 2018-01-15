<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>退休人员查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8" src="${ctx }/js/business/personagency/retired/searchRetiredCare.js?v=2016122018"></script>
</head>
<body>
	<form:form modelAttribute="retiredCareForm" method="post" action="${ctx}/business/personagency/retired/care/saveCarePl.xf">
		<div class="moduleWrapNobg">
			<div class="moduleTit"><span class="fl">大病医保信息</span>
				<span class="fr mgr15">
					<a role="button" class="btn btn-danger " onclick="searchParamsDiffCorp()"><i class="icon-search"></i>查询困难企业</a>
				</span>
			</div>
			<div class="moduleCont">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">是否已申报:</label>
					<div class="col-xs-9 col-sm-2">
						<select name="isDeclare"  class="form-control">
							<option value="">--请选择--</option>
							<option value="0">否</option>
							<option  value="1">是</option>
						</select>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">是否通过:</label>
					<div class="col-xs-9 col-sm-2">
						<select name="isFlag" class="form-control">
							<option value="">--请选择--</option>
							<option value="0">否</option>
							<option  value="1">是</option>
						</select>
					</div>
					 <div class="col-xs-12 col-sm-8">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="原因">原因:</label>
							<div class="col-xs-9 cole -sm-9">
								<form:input  class="form-control" type="text"  path="reason" ></form:input>
							</div>
						</div>
					</div>
				</div>
				<div class="row">							
					<div class="col-xs-12 col-sm-12">
	                    <div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="申报备注">申报备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea path="note"  row="5" col="5" type="text"/>
							</div>
						</div>
					 </div>
				 </div>			
				 <hr/>		
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError" title="经办日期">经办日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
						<form:input class="form-control " path="createrDate" readonly="true"></form:input>
						<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="经办机构">经办机构:</label>
					<div class="col-xs-9 col-sm-2 ">
						<form:input class="form-control" type="text" path="createrOrgName" readonly="true"></form:input>
						<form:input type="hidden" path="createrOrgId" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="经办人姓名">经办人姓名:</label>
					<div class="col-xs-9 col-sm-2 ">
						<form:input class="form-control" type="text" path="createrName" readonly="true"></form:input>
						<form:input type="hidden" path="createrId"></form:input>
					</div>
				</div>
			</div>
		</div>
		<div class="bottomBtn">
			<div class="floatBtn">
				<button id="btn2" role="button" class="btn btn-primary" type="submit"><i class="icon-save"></i>保存</button>
			</div>
		</div>
	</form:form>
</body>
</html>
