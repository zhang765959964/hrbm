<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>工资标准调整</title>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	</head>
	<form:form modelAttribute="archivesPersonForm" method="post" action="">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
			<div class="col-xs-9 col-sm-2">
				 <form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
			<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                   	  <form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
                        <span class="input-group-addon">
                            <i class="icon-calendar bigger-110"></i>
                        </span>
                  </div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
			<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                    <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                    <span class="input-group-addon">
                        <i class="icon-calendar bigger-110"></i>
                    </span>
                  </div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案接收人:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
			<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                   	 <form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                   	 <span class="input-group-addon">
                        	<i class="icon-calendar bigger-110"></i>
                    	</span>
                 </div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案状态:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">手机号:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">所属单位名称:</label>
			<div class="col-xs-9 col-sm-6">
				<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
			</div>
		</div>
	</form:form>
</html>