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
	<script type="text/javascript" src="${ctx}/js/business/personagency/retired/searchYlList.js?v=20161228"></script>
</head>
	
<div class="container-fluid">
	<form:form  modelAttribute="yangLaoForm" method="post" action="${ctx}/business/personagency/yanglao/save.xf">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">养老待遇申请信息</div>
				<div class="moduleCont">
					<form:hidden path="id" ></form:hidden>
					<form:hidden path="createrId" ></form:hidden>
					<form:hidden path="createrOrgId" ></form:hidden>
					<form:hidden path="retiredId" />
					<form:hidden path="personId"/>
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">序号:</label>
						<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="ylForm.xh" readonly="true"></form:input>
						</div>	
						<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
						<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="ylForm.retiredPeopleNo" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
						<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="ylForm.personName" readonly="true"></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<form:input  class="form-control" type="text"  path="ylForm.personCsrq" readonly="true"></form:input>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>	
						<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
						<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="ylForm.nationName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">参加工作日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<form:input  class="form-control" type="text"  path="ylForm.createrWorkDate" readonly="true"></form:input>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">退休人员所属区域:</label>
						<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="ylForm.retiredArea" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">符合离退休条款:</label>
						<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="ylForm.rgName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>缴费年月:</label>
						<div class="col-xs-9 input-group col-sm-2">
						 	<div class="input-group row required">
								<form:input  class="form-control" type="text"  path="payDate" ></form:input>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>应退休时间:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<div class="input-group row required">
								<form:input  class="form-control" type="text"  path="retiredDate" ></form:input>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						
						<label class="col-xs-3 col-sm-2" for="inputError">退休申报状态:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text" id="status"  path="ylForm.statusName"  readonly="true"></form:input>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="申报备注">申报备注:</label>
								<div class="col-xs-9 col-sm-10">
									<form:textarea row="5" col="5" path="declareNote"></form:textarea>
								</div>
							</div>
						</div>
					</div>
					<hr/>
					<div class="row" >
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-2">
						    <form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
						 <form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
	                    </div>
					</div>					
				</div>
			</div>
		</div>
		<div class="bottomBtn">
	   		<div class="floatBtn">
		   		<button role="button" type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   		</div>
	   	</div>
	</form:form>
</div>
</html>	
	
	
	
